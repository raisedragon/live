package com.raise.generator;

import java.io.IOException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.raise.generator.exception.GeneratorException;
import com.raise.generator.test.BaseTestCase;

import freemarker.template.TemplateException;

public class GeneratorTest extends BaseTestCase {

    @Autowired
    private Generator generator;

    @Test
    public void test() throws GeneratorException, IOException, TemplateException {
        generator.generated();
    }

}
