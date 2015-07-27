package com.raise.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.raise.core.identity.IdGenerator;


@ContextConfiguration({ "classpath:conf/spring/spring-context.xml" })
@ActiveProfiles({ "test" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class BaseTest {

    protected Logger         logger = LoggerFactory.getLogger(BaseTest.class);
    

    @Resource
    protected IdGenerator idGenerator;

    @Test
    public void test() {

    }
}
