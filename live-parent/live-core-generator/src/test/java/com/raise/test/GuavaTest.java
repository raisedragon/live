package com.raise.test;

import org.junit.Test;

import com.google.common.base.CaseFormat;

public class GuavaTest {
	@Test
	public void test(){
		String str = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "ABC_CDE_");
		System.out.println(str);
	}
}
