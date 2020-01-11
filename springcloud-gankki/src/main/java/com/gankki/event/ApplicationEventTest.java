package com.gankki.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 *
 * @author liuhao
 * @date 2020/1/11
 */
public class ApplicationEventTest extends ApplicationEvent {

    public ApplicationEventTest(Object source) {
        super(source);
    }

    /**
     * 事件处理事项
     *
     */
    public void printMsg() {
        System.out.println("监听到事件：" + ApplicationEventTest.class);
    }
}
