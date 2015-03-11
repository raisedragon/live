<#assign package=model.variables.package>
<#assign class=model.variables.class>
<#assign classVar=model.variables.classVar>
<#assign system=vars.system>
package com.winit.${system}.${package}.manager;

import java.util.List;
import com.winit.common.query.Searchable;
import com.winit.vms.core.manager.Manager;
import com.winit.${system}.${package}.entity.${class};
import com.winit.${system}.${package}.query.${class}Query;
/**
 * ${model.tabComment} Manager
 * Change to the actual description of this class
 * @version   Revision History
 * <pre>
 * Author     			Version       Date			Changes
 * ${vars.developer}    	1.0       ${date?string("yyyy-MM-dd HH:mm:ss")}			Created
 *
 * </pre>
 * @since 1.
 */
public interface ${class}Manager extends Manager<${class}>{

	/**
	 * 根据查询对象查询
	 * @param query
	 * @return
	 */
	public List<${class}> queryByCriteria(${class}Query.FindQuery query);
	
	
	/**
	 * 根据查询对象查询
	 * @param query
	 * @return
	 */
	public long queryCountByCriteria(${class}Query.FindQuery query);
	
	/**
	 * 根据查询对象更新
	 * @param query
	 * @return
	 */
	public void updateByUpdateQuery(${class}Query.UpdateQuery uQuery);

	
		/**
	 * 设置记录为有效状态
	 * @param id
	 */
	public void enable(Long id);
	
	/**
	 * 设置记录为无效状态
	 * @param id
	 */
	public void disable(Long id);
}

