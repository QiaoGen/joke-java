package com.joke.service.impl;

import com.joke.dao.test.TestDao;
import com.joke.pojo.test.Test;
import com.joke.pojo.test.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joke.service.TestService;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> queryAllTest() {
        return testDao.queryAllTest();
    }

    @Override
    public List<User> queryAllUser() {
        return testDao.queryAllUser();
    }
}
