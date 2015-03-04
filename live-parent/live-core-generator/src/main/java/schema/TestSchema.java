package schema;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.apache.commons.io.FileUtils;

import schemacrawler.schema.Catalog;
import schemacrawler.schema.Column;
import schemacrawler.schema.Schema;
import schemacrawler.schema.Table;
import schemacrawler.schemacrawler.SchemaCrawlerOptions;
import schemacrawler.schemacrawler.SchemaInfoLevel;
import schemacrawler.utility.SchemaCrawlerUtility;

import com.google.common.base.CaseFormat;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.raise.freemarker.FreemarkerUtils;
import com.raise.generator.Configuration;
import com.raise.generator.ConfigurationParser;
import com.raise.generator.DataModel;
import com.raise.generator.Ongl;
import com.raise.generator.Source;

import freemarker.template.Template;

public class TestSchema {
	private static Properties properties = new Properties();
	static {
		InputStream in = ClassLoader.class
				.getResourceAsStream("/conf/codegen.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void test() throws Exception {

		InputStream in = ClassLoader.class
				.getResourceAsStream("/conf/codegenconfig.xml");

		Configuration config = ConfigurationParser.parse(in);

		final DataSource dataSource = makeDataSource();
		SchemaCrawlerOptions schemaCrawlerOptions = new SchemaCrawlerOptions();
		
		final SchemaInfoLevel schemaInfoLevel = new SchemaInfoLevel();
		schemaInfoLevel.setRetrieveSchemaCrawlerInfo(true);
		schemaInfoLevel.setRetrieveDatabaseInfo(true);
		schemaInfoLevel.setRetrieveJdbcDriverInfo(true);
		schemaInfoLevel.setRetrieveTables(true);
//	    schemaInfoLevel.setRetrieveRoutines(true);
	    schemaInfoLevel.setRetrieveColumnDataTypes(true);
	    schemaInfoLevel.setRetrieveTableColumns(true);
//	    schemaInfoLevel.setRetrieveForeignKeys(true);
//	    schemaInfoLevel.setRetrieveIndices(true);
//	    schemaInfoLevel.setRetrieveRoutineColumns(true);
	    schemaInfoLevel.setTag("schemaInfoLevel");
		
		schemaCrawlerOptions.setSchemaInfoLevel(schemaInfoLevel);
		Catalog catalog = SchemaCrawlerUtility.getCatalog(dataSource.getConnection(), schemaCrawlerOptions);
		Schema schema = catalog.getSchema(properties.getProperty("schema"));
		
		
		for (com.raise.generator.Table tbl : config.getTables()) {
			Table table = catalog.getTable(schema, tbl.getName());
			if(table==null){
				throw new Exception("Table "+schema.getName()+"."+tbl.getName()+" is not exists");
			}
			for(Source source:config.getSources()){
				final List<Column> columns = table.getColumns();
				for (Column column : columns) {
					System.out.print("-- " + column);
					System.out.println("  Type:"
							+ column.getColumnDataType()
									.getDatabaseSpecificTypeName());
				}
				
				
				Template template = FreemarkerUtils.getConfig().getTemplate(config.getTemplate(source.getRefTemplate()).getPath());
	
				DataModel dataModel = new DataModel(config,table);
	
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				OutputStreamWriter out = new OutputStreamWriter(baos);
	
				template.process(dataModel, out);
				String filename = config.getProperties().getProperty("basedir")
								+File.separator
								+source.getDirectory()
								+File.separator
								+source.getFilename();
				filename = handlePlaceHoder(filename, dataModel);
				File file = new File(filename);
				FileUtils.writeByteArrayToFile(file, baos.toByteArray());
				
				baos.close();
			}
		}

	}
	
	
	private String handlePlaceHoder(String str,DataModel model){
		Map<String,Object> map = new HashMap<String, Object>();
		for(Entry<Object, Object> entry:model.getProperties().entrySet()){
			map.put(entry.getKey()+"", entry.getValue());
		}
		map.put("class", model.getClazz());
		map.put("package", model.getPkg());
		map.put("module", model.getModule());
		map.put("table", model.getTable().getName());
		
		Pattern pattern = Pattern.compile("\\$\\{[^\\}]+\\}");
		Matcher matcher = pattern.matcher(str);
		
		StringBuffer buf = new StringBuffer();
		
		int index = 0;
		while(matcher.find()){
			buf.append(str.substring(index, matcher.start()));
			
			String group = matcher.group();
			String key =group.substring(2,group.length()-1).trim();
			buf.append(map.get(key)); 
			
			index = matcher.end();
		}
		buf.append(str.substring(index));
		
		return buf.toString();
	}
	


	/**
	 * ȡ��DataSource
	 * 
	 * @return
	 * @throws IOException
	 */
	private static DataSource makeDataSource() throws IOException {
		MysqlDataSource ds = new MysqlDataSource();
		ds.setURL(properties.getProperty("url"));
		ds.setUser(properties.getProperty("username"));
		ds.setPassword(properties.getProperty("password"));
		return ds;
	}
	
	public static void main(String[] args) {
//		CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
	}
}