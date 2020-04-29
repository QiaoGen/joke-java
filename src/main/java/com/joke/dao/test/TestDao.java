package com.joke.dao.test;

import com.joke.pojo.test.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao {


    List<Test> queryAllTest();


}
