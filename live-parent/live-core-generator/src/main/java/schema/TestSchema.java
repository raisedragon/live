package schema;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import schemacrawler.schema.Catalog;
import schemacrawler.schema.Column;
import schemacrawler.schema.Schema;
import schemacrawler.schema.Table;
import schemacrawler.schemacrawler.SchemaCrawlerOptions;
import schemacrawler.utility.SchemaCrawlerUtility;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.raise.freemarker.FreemarkerUtils;
import com.raise.generator.Configuration;
import com.raise.generator.ConfigurationParser;
import com.raise.generator.DataModel;
import com.raise.generator.ObjectFactory;

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
		Catalog catalog = SchemaCrawlerUtility.getCatalog(
				dataSource.getConnection(), new SchemaCrawlerOptions());
		Schema schema = catalog.getSchema(properties.getProperty("schema"));

		for (com.raise.generator.Table tbl : config.getTables()) {
			Table table = catalog.getTable(schema, tbl.getName());
			if(table==null){
				throw new Exception("Table "+schema.getName()+"."+tbl.getName()+" is not exists");
			}
			System.out.println(table.getRemarks());
			final List<Column> columns = table.getColumns();
			for (Column column : columns) {
				System.out.print("-- " + column);
				System.out.println("  Type:"
						+ column.getColumnDataType()
								.getDatabaseSpecificTypeName());
			}

			Template template = FreemarkerUtils.getConfig().getTemplate(
					"entity.ftl");

			DataModel dataModel = new DataModel();

			dataModel.setConfig(config);
			dataModel.setTable(table);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			OutputStreamWriter out = new OutputStreamWriter(baos);

			template.process(dataModel, out);

			System.out.println(baos.toString());
		}

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
}