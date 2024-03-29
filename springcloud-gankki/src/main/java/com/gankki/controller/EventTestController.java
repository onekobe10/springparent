package com.gankki.controller;

import com.gankki.event.ApplicationEventTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 事件监听测试 Event Listener
 * @author liuhao
 * @date 2020/1/11
 */
@Slf4j
@RestController
@RequestMapping("event")
public class EventTestController {
    @Autowired
    ApplicationContext applicationContext;

    @RequestMapping("test")
    public String eventTest1(){
        log.warn("哈哈");
        System.out.println(Thread.currentThread().getId());
        ApplicationEventTest test = new ApplicationEventTest(this);
        applicationContext.publishEvent(test);
        return "ok";
    }

}
