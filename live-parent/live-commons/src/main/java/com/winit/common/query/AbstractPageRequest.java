/*
 * Copyright 2013 the original author or authors.
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
package com.winit.common.query;

import java.io.Serializable;

/**
 * Abstract Java Bean implementation of {@code Pageable}.
 * 
 * @author
 */
public abstract class AbstractPageRequest implements Pageable, Serializable {

	private static final long serialVersionUID = 1232825578694716871L;

	private int page;
	private int size;

	public AbstractPageRequest(){
	}
	
	/**
	 * Creates a new {@link AbstractPageRequest}. Pages are zero indexed, thus providing 0 for {@code page} will return
	 * the first page.
	 * 
	 * @param page must not be less than zero.
	 * @param size must not be less than one.
	 */
	public AbstractPageRequest(int page, int size) {

		/*if (page < 0) {
			//throw new IllegalArgumentException("Page index must not be less than zero!");
		}

		if (size < 1) {
			//throw new IllegalArgumentException("Page size must not be less than one!");
		}*/

		this.page = page;
		this.size = size;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.data.entity.Pageable#getPageSize()
	 */
	public int getPageSize() {
		return size;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.data.entity.Pageable#getPageNumber()
	 */
	public int getPageNumber() {
		return page;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.data.entity.Pageable#getOffset()
	 */
	public int getOffset() {
		return page * size;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.data.entity.Pageable#hasPrevious()
	 */
	public boolean hasPrevious() {
		return page > 0;
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.data.entity.Pageable#previousOrFirst()
	 */
	public Pageable previousOrFirst() {
		return hasPrevious() ? previous() : first();
	}

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.data.entity.Pageable#next()
	 */
	public abstract Pageable next();

	/**
	 * Returns the {@link Pageable} requesting the previous {@link Page}.
	 * 
	 * @return
	 */
	public abstract Pageable previous();

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.data.entity.Pageable#first()
	 */
	public abstract Pageable first();

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;

		result = prime * result + page;
		result = prime * result + size;

		return result;
	}

	/* 
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		AbstractPageRequest other = (AbstractPageRequest) obj;
		return this.page == other.page && this.size == other.size;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
