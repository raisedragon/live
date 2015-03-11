<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign system=vars.system>
<#assign subtables=model.subTableList>
<#assign pk=func.getPk(model) >
<#assign pkVar=func.convertUnderLine(pk) >
package com.winit.${system}.${package}.query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;


import com.winit.common.query.Sort;
import com.winit.vms.core.query.SetData;

/**
 * ${model.tabComment} Query对象
 * Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     			Version       Date			Changes
 * ${vars.developer}    	1.0       ${date?string("yyyy-MM-dd HH:mm:ss")}			Created
 *
 * </pre>
 * @since 1.
 */
public class ${class}Query {
	public static class FindQuery {

		protected List<Criteria> oredCriteria;

		
		protected Sort sort;
		
		
		protected boolean first;
		
		public FindQuery() {
			oredCriteria = new ArrayList<Criteria>();
		}
		
		public Sort getSort() {
			return sort;
		}


		public List<Criteria> getOredCriteria() {
			return oredCriteria;
		}

		public void or(Criteria criteria) {
			oredCriteria.add(criteria);
		}

		public Criteria or() {
			Criteria criteria = createCriteriaInternal();
			oredCriteria.add(criteria);
			return criteria;
		}

		public Criteria createCriteria() {
			Criteria criteria = createCriteriaInternal();
			if (oredCriteria.size() == 0) {
				oredCriteria.add(criteria);
			}
			return criteria;
		}

		protected Criteria createCriteriaInternal() {
			Criteria criteria = new Criteria();
			return criteria;
		}
		
		public FindQuery first(){
			first = true;
			return this;
		}

		public void clear() {
			oredCriteria.clear();
			sort = null;
			first = false;
		}
	}

	public static class UpdateQuery {
		protected UpdateClause updateClause;

		protected List<Criteria> oredCriteria;

		public UpdateClause getUpdateClause() {
			return updateClause;
		}

		public List<Criteria> getOredCriteria() {
			return oredCriteria;
		}

		public void or(Criteria criteria) {
			oredCriteria.add(criteria);
		}

		public Criteria or() {
			Criteria criteria = createCriteriaInternal();
			oredCriteria.add(criteria);
			return criteria;
		}

		public Criteria createCriteria() {
			Criteria criteria = createCriteriaInternal();
			if (oredCriteria.size() == 0) {
				oredCriteria.add(criteria);
			}
			return criteria;
		}

		protected Criteria createCriteriaInternal() {
			Criteria criteria = new Criteria();
			return criteria;
		}

		public UpdateQuery() {
			oredCriteria = new ArrayList<Criteria>();
			updateClause = new UpdateClause();
		}

	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		<#list model.columnList as col>
		<#assign colName=func.convertUnderLine(col.columnName)>
		<#assign colType><#if col.colType=="timestamp">Date<#elseif col.colType=="Double">BigDecimal<#elseif (col.columnName?substring(0,2))?lower_case=="is">Boolean<#elseif col.colType=='char'>String<#else>${col.colType}</#if></#assign>
		<#if colName=="isDelete">
		<#else>
		/* ${col.comment} */
		public Criteria and${colName?cap_first}IsNull() {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" is null");
			return (Criteria) this;
		}
		
		public Criteria and${colName?cap_first}IsNotNull() {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" is not null");
			return (Criteria) this;
		}
		public Criteria and${colName?cap_first}EqualTo(${colType}  value) {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" =", value, "${colName}");
			return (Criteria) this;
		}
			
		
		<#if colType!="Boolean">
		public Criteria and${colName?cap_first}Between(${colType}  value1, ${colType}  value2) {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" between", value1, value2, "${colName}");
			return (Criteria) this;
		}
		</#if>

		<#if func.getJdbcType(col.colDbType)=="NUMERIC">
		public Criteria and${colName?cap_first}In(List<${colType}> values) {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" in", values, "${colName}");
			return (Criteria) this;
		}
		public Criteria and${colName?cap_first}GreaterThan(${colType}  value) {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" >", value, "${colName}");
			return (Criteria) this;
		}

		public Criteria and${colName?cap_first}GreaterThanOrEqualTo(${colType}  value) {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" >=", value, "${colName}");
			return (Criteria) this;
		}

		public Criteria and${colName?cap_first}LessThan(${colType}  value) {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" <", value, "${colName}");
			return (Criteria) this;
		}

		public Criteria and${colName?cap_first}LessThanOrEqualTo(${colType}  value) {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" <=", value, "${colName}");
			return (Criteria) this;
		}
		</#if>
		<#if func.getJdbcType(col.colDbType)=="VARCHAR" && colType!="Boolean">
		public Criteria and${colName?cap_first}In(List<${colType}> values) {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" in", values, "${colName}");
			return (Criteria) this;
		}
		public Criteria and${colName?cap_first}Like(${colType}  value) {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" like", value, "${colName}");
			return (Criteria) this;
		}

		public Criteria and${colName?cap_first}NotLike(${colType}  value) {
			addCriterion(${class}Property.COLUMN_NAME_${colName}+" not like", value, "${colName}");
			return (Criteria) this;
		}
		</#if>
		</#if>
		</#list>
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value) {
			super();
			this.condition = condition;
			this.value = value;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.betweenValue = true;
		}
	}

	public static class UpdateClause {
		protected List<SetData> dataClauses;

		public List<SetData> getdataClauses() {
			if (dataClauses.size() == 0) {
				throw new RuntimeException("更新的数据，必须指定");
			}
			return dataClauses;
		}

		protected UpdateClause() {
			this.dataClauses = new ArrayList<SetData>();
		}
		<#list model.commonList as col>
		<#assign colName=func.convertUnderLine(col.columnName)>
		<#assign colType><#if col.colType=="timestamp">Date<#elseif col.colType=="Double">BigDecimal<#elseif (col.columnName?substring(0,2))?lower_case=="is">Boolean<#elseif col.colType=="char">String<#else>${col.colType}</#if></#assign>
		/* 设置 ${col.comment} */
		public void set${colName?cap_first}(${colType}  ${colName}) {
			dataClauses.add(new SetData(${class}Property.COLUMN_NAME_${colName}+" = ", ${colName}));
		}
		</#list>

	}
}