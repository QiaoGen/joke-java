package com.joke.test;

import com.joke.service.TestService;
import com.joke.service.impl.TestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test {

    private Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private TestService testService;

    @org.junit.jupiter.api.Test
    public void test(){
        List<com.joke.pojo.test.Test> tests = testService.queryAllTest();
        log.info("Test:[{}]",tests);

//        List<User> users = testService.queryAllUser();
//        log.info("Users:[{}]",users);

    }

}
