package com.joke;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JokeApplicationTests {

    @Value("${swagger2.enable}")
    public String Swagger;

    @Value("${spring.profiles.active}")
    private String PROFILE;

    @Test
    void contextLoads() {
        System.out.println(Swagger + "-" + PROFILE);
    }

}
