package com.joke.service;

import com.joke.pojo.test.Test;
import com.joke.pojo.test.User;

import java.util.List;

public interface TestService {

    List<Test> queryAllTest();

    List<User> queryAllUser();
}
