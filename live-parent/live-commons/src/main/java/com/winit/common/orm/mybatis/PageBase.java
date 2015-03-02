/*
 * Copyright 2008-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.winit.common.orm.mybatis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.winit.common.query.Pageable;

/**
 * Basic {@code Page} implementation.
 * 
 * @param <T> the type of which the page consists.
 * @author
 */
public class PageBase<T> extends ArrayList<T> implements Serializable {

	private static final long serialVersionUID = 867755909294344406L;
	
	public Pageable pageable;
	
	public long total;
	
	public PageBase(){
	}
	/**
	 * Constructor of {@code PageImpl}.
	 * 
	 * @param content the content of this page, must not be {@literal null}.
	 * @param pageable the paging information, can be {@literal null}.
	 * @param total the total amount of items available
	 */
	public PageBase(List<T> content, Pageable pageable, long total) {
		if (null == content) {
			content = new ArrayList<T>();
		}
		super.addAll(content);
		this.total = total;
		this.pageable = pageable;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.entity.Page#getTotalElements()
	 */
	public long getTotalElements() {
		return total;
	}
	
	public Pageable getPageable() {
		return pageable;
	}
}
