package com.gankki.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试用例编写
 * @author liuhao
 * @date 2020/10/23
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("test1")
    public String test1(){
        return "test1";
    }

    @RequestMapping("test2")
    public String test2(){
        return "test2";
    }

}
