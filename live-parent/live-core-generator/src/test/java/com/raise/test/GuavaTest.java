package com.raise.test;

import org.junit.Test;

import com.google.common.base.CaseFormat;

public class GuavaTest {
	@Test
	public void test(){
		String str = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_UNDERSCORE, "Lon_gA_baC");
		System.out.println(str);
	}
}
