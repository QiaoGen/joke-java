package com.joke.dao.test;

import com.joke.pojo.test.Test;
import com.joke.pojo.test.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Drogon
 */
@Repository
public interface TestDao {

    List<Test> queryAllTest();

    List<User> queryAllUser();
}
