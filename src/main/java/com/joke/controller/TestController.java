package com.joke.controller;

import com.joke.config.tip.SuccessTip;
import com.joke.config.tip.Tip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试Controller",tags = {"测试接口"})
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "请求调用示例", notes = "invokePost说明", httpMethod = "GET")
    @GetMapping("/test")
    @ResponseBody
    public Tip executeTest(){
        return new SuccessTip("执行成功");
    }

}
