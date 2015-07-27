<#assign type="${properties.basepackage}.${pkg}.entity.${clazz}"  />
<#assign selectQueryType="${properties.basepackage}.${pkg}.query.${clazz}SelectQuery"  />
<#assign updateQueryType="${properties.basepackage}.${pkg}.query.${clazz}UpdateQuery"  />
<#assign primaryKeyName="${primaryKey.columns[0].name}"  />
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${properties.basepackage}.${pkg}.dao.${clazz}Dao">
	<resultMap id="${clazz}ResultMap" type="${type}">
		<#list table.columns as column>
		<#assign colName="${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, column.name)}">
		<#if (column.partOfPrimaryKey) >
		<id property="${colName}" column="${column.name}" jdbcType="${_Ongl.mybatisType(column)}"/>
		<#else>
		<result property="${colName}" column="${column.name}" jdbcType="${_Ongl.mybatisType(column)}"/>
		</#if>
		</#list>
	</resultMap>
	
	<sql id="columns">
		<#list table.columns as column>
			${column.name}<#if column_has_next>,</#if>
		</#list>
	</sql>
	
	<insert id="add" parameterType="${type}">
		INSERT INTO ${tablename}
		(
		<#list table.columns as column>
			${column.name}<#if column_has_next>,</#if>
		</#list>
		)
		VALUES 
		(
		<#list table.columns as column>
			<#assign colName="${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, column.name)}">
			<#noparse>#{</#noparse>${colName},jdbcType=${_Ongl.mybatisType(column)}<#noparse>}</#noparse><#if column_has_next>, </#if>
		</#list>
		)
	</insert>
	
	<select id="get"   parameterType="${_Ongl.javaType(primaryKey)}" resultMap="${clazz}ResultMap">
		SELECT <include refid="columns" /> FROM ${tablename} 
		WHERE 
			IS_DELETED_='0'
			AND ${primaryKeyName}=<#noparse>#{</#noparse>${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, primaryKeyName)}}
	</select>
	
	<select 
	    id="find" parameterType="com.winit.common.query.Searchable"
	    resultMap="${clazz}ResultMap"
	    timeout="60000">
		SELECT <include refid="columns" /> FROM ${tablename}
	</select>
	
	<update id="update" parameterType="${type}">
		UPDATE ${tablename} SET
		<#list table.columns as column>
		<#assign colName="${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, column.name)}">
		${column.name}=<#noparse>#{</#noparse>${colName},jdbcType=${_Ongl.mybatisType(column)}<#noparse>}</#noparse><#if column_has_next>,</#if>
		</#list>
		WHERE
		${primaryKeyName}=<#noparse>#{</#noparse>${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, primaryKeyName)}}
	</update>
	
	<delete id="delete"  parameterType="${_Ongl.javaType(primaryKey)}">
		DELETE FROM ${tablename} 
		WHERE
		${primaryKeyName}=<#noparse>#{</#noparse>${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, primaryKeyName)}}
	</delete>
	
	<update id="tombstoned"  parameterType="${_Ongl.javaType(primaryKey)}">
		<bind name="currentTime" value="@com.gdcc.live.core.security.SCUtils@currentDate()"/>
		<bind name="currentUserId" value="@com.gdcc.live.core.security.SCUtils@currentUserId()"/>
		UPDATE ${tablename} SET
			IS_DELETED_='1',
			UPDATED=<#noparse>#{</#noparse>currentTime,jdbcType=TIMESTAMP},
			UPDATEDBY=<#noparse>#{</#noparse>currentUserId,jdbcType=VARCHAR}
		WHERE
			${primaryKeyName}=<#noparse>#{</#noparse>${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, primaryKeyName)}}
	</update>
	
	<update id="disable"  parameterType="${_Ongl.javaType(primaryKey)}">
		<bind name="currentTime" value="@com.gdcc.live.core.security.SCUtils@currentDate()"/>
		<bind name="currentUserId" value="@com.gdcc.live.core.security.SCUtils@currentUserId()"/>
		UPDATE ${tablename} SET
			IS_ACTIVE_='0',
			UPDATED=<#noparse>#{</#noparse>currentTime,jdbcType=TIMESTAMP},
			UPDATEDBY=<#noparse>#{</#noparse>currentUserId,jdbcType=VARCHAR}
		WHERE
			${primaryKeyName}=<#noparse>#{</#noparse>${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, primaryKeyName)}}
	</update>
	<update id="enable"  parameterType="${_Ongl.javaType(primaryKey)}">
		<bind name="currentTime" value="@com.gdcc.live.core.security.SCUtils@currentDate()"/>
		<bind name="currentUserId" value="@com.gdcc.live.core.security.SCUtils@currentUserId()"/>
		UPDATE ${tablename} SET
			IS_ACTIVE_='1',
			UPDATED=<#noparse>#{</#noparse>currentTime,jdbcType=TIMESTAMP},
			UPDATEDBY=<#noparse>#{</#noparse>currentUserId,jdbcType=VARCHAR}
		WHERE
			${primaryKeyName}=<#noparse>#{</#noparse>${Guava_CaseFormat.UPPER_UNDERSCORE.to(Guava_CaseFormat.LOWER_CAMEL, primaryKeyName)}}
	</update>
	
	<!-- Operate by criteria -->
	
	<select id="selectByCriteria" parameterType="${selectQueryType}" resultMap="${clazz}ResultMap">
		SELECT 
		<#list table.columns as column>
			RES.${column.name}<#if column_has_next>,</#if>
		</#list>
		<include refid="selectByCriteriaSql" />
		<include refid="orderByClauseSql"/>
	</select>
	
	<select id="selectCountByCriteria" parameterType="${selectQueryType}" resultType="Long">
		SELECT count(1)
		<include refid="selectByCriteriaSql" />
	</select>

	<sql id="selectByCriteriaSql">
		from ${tablename} RES
		<include refid="criteriaSql"/>
	</sql>
	<update id="updateByUpdateQuery" parameterType="${updateQueryType}">
		UPDATE ${tablename} RES
		<include refid="updateDataCaluseSql"/>
		<include refid="criteriaSql"/>
	</update>
	
	
	<sql id="criteriaSql">
		<where>
			IS_DELETED_='0'
			<if test="criteria.oreds.size()==1">
				<trim prefix="AND" >
					<include refid="oredCriteriaSql"/>
				</trim>
			
			</if>
			<if test="criteria.oreds.size()>1">
				<trim prefix="AND (" suffix=")" >
					<include refid="oredCriteriaSql"/>
				</trim>
			</if>
		</where>
	</sql>
		
		
	<sql id="oredCriteriaSql">
		<foreach  collection="criteria.oreds" item="ored" separator="or">
			<if test="ored.valid">
				<if test="ored.criterions.size()==1">
					<trim prefixOverrides="and">
						<include refid="criterionSql"/>
					</trim>
				</if>
				<if test="ored.criterions.size()>1">
					<trim prefix="(" prefixOverrides="and" suffix=")">
						<include refid="criterionSql"/>
					</trim>
				</if>
			</if>
		</foreach>
	</sql>
	
	<sql id="criterionSql">
		<foreach collection="ored.criterions" item="criterion">
			<choose>
				<when test="criterion.noValue">
					and RES.<#noparse>${</#noparse>criterion.condition}
				</when>
				<when test="criterion.singleValue">
					and RES.<#noparse>${</#noparse>criterion.condition} <#noparse>#{</#noparse>criterion.value}
				</when>
				<when test="criterion.betweenValue">
					and RES.<#noparse>${</#noparse>criterion.condition} <#noparse>#{</#noparse>criterion.value} and <#noparse>#{</#noparse>criterion.secondValue}
				</when>
				<when test="criterion.listValue">
					and RES.<#noparse>${</#noparse>criterion.condition}
					<foreach close=")" collection="criterion.value" item="listItem" open="(" separator=",">
						<#noparse>#{</#noparse>listItem}
					</foreach>
				</when>
			</choose>
		</foreach>
	</sql>
		
	<sql id="updateDataCaluseSql">
		<set>   
			<foreach collection="updateClause.dataClauses" item="clause" separator=",">
				<#noparse>${</#noparse>clause.property} <#noparse>#{</#noparse>clause.value}
			</foreach>
		</set>
	</sql>
	
	
	<sql id="orderByClauseSql">
		ORDER BY 
			<#noparse>${</#noparse>orderBy}
	</sql>
	
</mapper>