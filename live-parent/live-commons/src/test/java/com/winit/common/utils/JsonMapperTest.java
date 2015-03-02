/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
package com.winit.common.utils;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * 测试Jackson对Object,Map,List,数组,枚举,日期类等的持久化.
 * 更多测试见showcase中的JsonDemo.
 * 
 * @author calvin
 */
public class JsonMapperTest {

	/**
	 * 序列化对象/集合到Json字符串.
	 */
	@Test
	public void toJson() throws Exception {
		// Bean
		TestBean bean = new TestBean("A");
		String beanString = JsonMapper.toJson(bean);
		System.out.println("Bean:" + beanString);

		// Map
		Map<String, Object> map = Maps.newLinkedHashMap();
		map.put("name", "A");
		map.put("age", 2);
		String mapString = JsonMapper.toJson(map);
		System.out.println("Map:" + mapString);

		// List<String>
		List<String> stringList = Lists.newArrayList("A", "B", "C");
		String listString = JsonMapper.toJson(stringList);
		System.out.println("String List:" + listString);

		// List<Bean>
		List<TestBean> beanList = Lists.newArrayList(new TestBean("A"), new TestBean("B"));
		String beanListString = JsonMapper.toJson(beanList);
		System.out.println("Bean List:" + beanListString);

		// Bean[]
		TestBean[] beanArray = new TestBean[] { new TestBean("A"), new TestBean("B") };
		String beanArrayString = JsonMapper.toJson(beanArray);
		System.out.println("Array List:" + beanArrayString);
	}

	/**
	 * 从Json字符串反序列化对象/集合.
	 */
	@Test
	public void fromJson() throws Exception {
		// Bean
		String beanString = "{\"name\":\"A\"}";
		TestBean bean = JsonMapper.fromJson(beanString, TestBean.class);
		System.out.println("Bean:" + bean);

		// Map
		String mapString = "{\"name\":\"A\",\"age\":2}";
		Map<String, Object> map = JsonMapper.fromJson(mapString, HashMap.class);
		System.out.println("Map:");
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		// List<String>
		String listString = "[\"A\",\"B\",\"C\"]";
		List<String> stringList = JsonMapper.fromJson(listString, List.class);
		System.out.println("String List:");
		for (String element : stringList) {
			System.out.println(element);
		}
	}

	/**
	 * 测试传入空对象,空字符串,Empty的集合,"null"字符串的结果.
	 */
	@Test
	public void nullAndEmpty() {
		// toJson测试 //

		// Null Bean
		TestBean nullBean = null;
		String nullBeanString = JsonMapper.toJson(nullBean);
		assertThat(nullBeanString).isEqualTo("null");

		// Empty List
		List<String> emptyList = Lists.newArrayList();
		String emptyListString = JsonMapper.toJson(emptyList);
		assertThat(emptyListString).isEqualTo("[]");

		// fromJson测试 //

		// Null String for Bean
		TestBean nullBeanResult = JsonMapper.fromJson(null, TestBean.class);
		assertThat(nullBeanResult).isNull();

		nullBeanResult = JsonMapper.fromJson("null", TestBean.class);
		assertThat(nullBeanResult).isNull();

		// Null/Empty String for List
		List nullListResult = JsonMapper.fromJson(null, List.class);
		assertThat(nullListResult).isNull();

		nullListResult = JsonMapper.fromJson("null", List.class);
		assertThat(nullListResult).isNull();

		nullListResult = JsonMapper.fromJson("[]", List.class);
		assertThat(nullListResult).isEmpty();
	}

	public static class TestBean {

		private String name;
		private String defaultValue = "hello";
		private String nullValue = null;

		public TestBean() {
		}

		public TestBean(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDefaultValue() {
			return defaultValue;
		}

		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}

		public String getNullValue() {
			return nullValue;
		}

		public void setNullValue(String nullValue) {
			this.nullValue = nullValue;
		}

		@Override
		public String toString() {
			return "TestBean [defaultValue=" + defaultValue + ", name=" + name + ", nullValue=" + nullValue + "]";
		}
	}

}
