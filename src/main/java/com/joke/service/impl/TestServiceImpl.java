package com.joke.service.impl;

import com.joke.dao.test.TestDao;
import com.joke.pojo.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.joke.service.TestService;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<Test> queryAllTest() {
        return testDao.queryAllTest();
    }
}
