package com.gankki.event;

import com.gankki.event.ApplicationEventTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * event listener
 * @author liuhao
 * @date 2020/1/11
 */
@Slf4j
@Async
@Component
public class MyEventHandleTest {

    /**
     * 参数为Object类型时，所有事件都会监听到
     * 参数为指定类型事件时，该参数类型事件或者其子事件（子类）都可以接收到
     */
    @EventListener
    public void event(ApplicationEventTest event){
        System.out.println(Thread.currentThread().getId());
        event.printMsg();
    }
}
