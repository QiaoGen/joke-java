package com.joke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableScheduling
//@MapperScan("com.joke.dao")
@SpringBootApplication
public class JokeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokeApplication.class, args);
    }

}
