package com.joke;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableScheduling
//@MapperScan("com.joke.dao")

@SpringBootApplication
@EnableSwagger2
public class JokeApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokeApplication.class, args);
    }

}
