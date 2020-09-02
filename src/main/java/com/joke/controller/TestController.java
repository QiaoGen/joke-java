package com.joke.controller;

import com.joke.config.tip.SuccessTip;
import com.joke.config.tip.Tip;
import com.joke.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(value = "测试Controller",tags = {"测试接口"})
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @ApiOperation(value = "请求调用示例", notes = "invokePost说明", httpMethod = "GET")
    @GetMapping("/test11")
    @ResponseBody
    public Tip executeTest(HttpServletRequest request){
        return testService.queryAllUser(request);
    }


    @GetMapping("/testTwo")
    public Tip test(){
        return new SuccessTip("这是一个网页");
    }

}
