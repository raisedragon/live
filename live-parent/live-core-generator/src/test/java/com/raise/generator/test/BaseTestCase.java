package com.raise.generator.test;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@DirtiesContext
@ContextConfiguration(locations = { "/conf/spring/spring.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class BaseTestCase {
}
