package com.joke.service.impl;

import com.joke.config.tip.SuccessTip;
import com.joke.config.tip.Tip;
import com.joke.dao.test.TestDao;
import com.joke.pojo.test.Test;
import com.joke.service.TestService;
import com.joke.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
    public Tip queryAllUser(HttpServletRequest request) {
        String ipAddress = IpUtil.getIpAddress(request);
//        String ipAddress = IpUtil.getClientIp(request);
        return new SuccessTip(ipAddress);
    }
}
