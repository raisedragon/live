package com.winit.vms.system;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.gdcc.live.core.identity.IdGenerator;


@ContextConfiguration({ "classpath:conf/spring/spring-context.xml" })
@ActiveProfiles({ "test" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class BaseTest {

    protected Log         logger = LogFactory.getLog(BaseTest.class);

    @Autowired
    protected IdGenerator idGenerator;

    @Test
    public void test() {

    }
}
