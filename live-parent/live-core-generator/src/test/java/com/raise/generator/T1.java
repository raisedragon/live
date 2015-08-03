package com.raise.generator;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.raise.generator.exception.GeneratorException;
import com.raise.generator.test.BaseTestCase;


public class T1 extends BaseTestCase {

    private static Logger logger = LoggerFactory.getLogger(T1.class);

    @Resource
    private Generator     generator;

    @Test
    public void test() throws GeneratorException {
        generator.generated("wt_label");
    }
}
