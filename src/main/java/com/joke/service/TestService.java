package com.joke.service;

import com.joke.config.tip.Tip;
import com.joke.pojo.test.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TestService {

    List<Test> queryAllTest();

    Tip queryAllUser(HttpServletRequest request);
}
