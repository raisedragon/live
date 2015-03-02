<#import "function.ftl" as func>
<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign system=vars.system>
<#assign type="com.winit."+system+"."+package+".entity." +class>
<#assign queryType="com.winit."+system+"."+package+".query." +class+"Query">
<#assign tableName=model.tableName>
<#assign system=vars.system>
<#assign foreignKey=model.foreignKey>
<#assign sub=model.sub>
<#assign colList=model.columnList>
<#assign commonList=model.commonList>
<#assign pk=func.getPk(model) >
<#assign pkVar=func.getPkVar(model) >
<#-- 模板开始  -->
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.winit.${system}.${package}.dao.${class}Dao">
	<resultMap id="${class}" type="${type}">
		<#list colList as col>
		<#assign colName=func.convertUnderLine(col.columnName)>
		<#if (col.isPK) >
		<id property="${colName}" column="${col.columnName}" jdbcType="${func.getJdbcType(col.colDbType)}"/>
		<#else>
		<result property="${colName}" column="${col.columnName}" jdbcType="${func.getJdbcType(col.colDbType)}"/>
		</#if>
		</#list>
	</resultMap>
	
	<sql id="columns">
		<#list colList as col>
			${col.columnName}<#if col_has_next>,</#if>
		</#list>
	</sql>
	
	<insert id="add" useGeneratedKeys="true" keyProperty="id"  parameterType="${type}">
		INSERT INTO ${tableName}
		(<#list colList as col>${col.columnName}<#if col_has_next>,</#if></#list>)
		VALUES 
		(<#list colList as col><#assign colName=func.convertUnderLine(col.columnName)><#noparse>#{</#noparse>${colName},jdbcType=${func.getJdbcType(col.colDbType)}<#noparse>}</#noparse><#if col_has_next>, </#if></#list>)
	</insert>
	
	<select id="get"   parameterType="java.lang.Long" resultMap="${class}">
		SELECT <include refid="columns" /> FROM ${tableName} 
		WHERE 
			IS_DELETE='N'
			AND ${pk}=<#noparse>#{</#noparse>${func.convertUnderLine(pk)}}
	</select>
	
	<select 
	    id="find" parameterType="com.winit.common.query.Searchable"
	    resultMap="${class}"
	    timeout="60000">
		SELECT <include refid="columns" /> FROM ${tableName}
	</select>
	
	<update id="update" parameterType="${type}">
		UPDATE ${tableName} SET
		<#list commonList as col>
		<#assign colName=func.convertUnderLine(col.columnName)>
		${col.columnName}=<#noparse>#{</#noparse>${colName},jdbcType=${func.getJdbcType(col.colDbType)}<#noparse>}</#noparse><#if col_has_next>,</#if>
		</#list>
		WHERE
		${pk}=<#noparse>#{</#noparse>${func.convertUnderLine(pk)}}
	</update>
	
	<delete id="delete" parameterType="java.lang.Long">
		DELETE FROM ${tableName} 
		WHERE
		${pk}=<#noparse>#{</#noparse>${func.convertUnderLine(pk)}}
	</delete>
	
	<update id="tombstoned" parameterType="java.lang.Long">
		<bind name="currentTime" value="@com.winit.vms.core.security.SCUtils@currentDate()"/>
		<bind name="currentUserId" value="@com.winit.vms.core.security.SCUtils@currentUserId()"/>
		UPDATE ${tableName} SET
			IS_DELETE='Y',
			UPDATED=<#noparse>#{</#noparse>currentTime,jdbcType=TIMESTAMP},
			UPDATEDBY=<#noparse>#{</#noparse>currentUserId,jdbcType=VARCHAR}
		WHERE
			${pk}=<#noparse>#{</#noparse>${func.convertUnderLine(pk)}}
	</update>
	
	<update id="disable" parameterType="java.lang.Long">
		<bind name="currentTime" value="@com.winit.vms.core.security.SCUtils@currentDate()"/>
		<bind name="currentUserId" value="@com.winit.vms.core.security.SCUtils@currentUserId()"/>
		UPDATE ${tableName} SET
			IS_ACTIVE='N',
			UPDATED=<#noparse>#{</#noparse>currentTime,jdbcType=TIMESTAMP},
			UPDATEDBY=<#noparse>#{</#noparse>currentUserId,jdbcType=VARCHAR}
		WHERE
			${pk}=<#noparse>#{</#noparse>${func.convertUnderLine(pk)}}
	</update>
	<update id="enable" parameterType="java.lang.Long">
		<bind name="currentTime" value="@com.winit.vms.core.security.SCUtils@currentDate()"/>
		<bind name="currentUserId" value="@com.winit.vms.core.security.SCUtils@currentUserId()"/>
		UPDATE ${tableName} SET
			IS_ACTIVE='Y',
			UPDATED=<#noparse>#{</#noparse>currentTime,jdbcType=TIMESTAMP},
			UPDATEDBY=<#noparse>#{</#noparse>currentUserId,jdbcType=VARCHAR}
		WHERE
			${pk}=<#noparse>#{</#noparse>${func.convertUnderLine(pk)}}
	</update>
	
	<!-- Operate by criteria -->
	
	<select id="queryByCriteria" parameterType="${queryType}$FindQuery" resultMap="${class}">
		SELECT 
		<#list colList as col>
			RES.${col.columnName}<#if col_has_next>,</#if>
		</#list>
		<include refid="queryByCriteriaSql" />
		<include refid="orderByClauseSql"/>
		<if test="first">
			limit 1
		</if>
	</select>
	
	<select id="queryCountByCriteria" parameterType="${queryType}$FindQuery" resultType="Long">
		SELECT count(1)
		<include refid="queryByCriteriaSql" />
	</select>

	<sql id="queryByCriteriaSql">
		from ${tableName} RES
		<include refid="criteriaSql"/>
	</sql>
	<update id="updateByUpdateQuery" parameterType="${queryType}$UpdateQuery">
		UPDATE ${tableName} RES
		<include refid="updateDataCaluseSql"/>
		<include refid="criteriaSql"/>
	</update>
	
	
	<sql id="criteriaSql">
		<where>
			IS_DELETE='N'
			<if test="oredCriteria.size()==1">
				<trim prefix="AND" >
					<include refid="oredCriteriaSql"/>
				</trim>
			
			</if>
			<if test="oredCriteria.size()>1">
				<trim prefix="AND (" suffix=")" >
					<include refid="oredCriteriaSql"/>
				</trim>
			</if>
		</where>
	</sql>
		
		
	<sql id="oredCriteriaSql">
		<foreach  collection="oredCriteria" item="criteria" separator="or">
			<if test="criteria.valid">
				<if test="criteria.criteria.size()==1">
					<trim prefixOverrides="and">
						<include refid="criterionSql"/>
					</trim>
				</if>
				<if test="criteria.criteria.size()>1">
					<trim prefix="(" prefixOverrides="and" suffix=")">
						<include refid="criterionSql"/>
					</trim>
				</if>
			</if>
		</foreach>
	</sql>
	
	<sql id="criterionSql">
		<foreach collection="criteria.criteria" item="criterion">
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
		<if test="sort!=null">
			ORDER BY 
				<#noparse>${</#noparse>sort.sortSql}
		</if>
	</sql>
	
</mapper>