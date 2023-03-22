package com.gankki.controller;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 单元测试运行
 * @author liuhao
 * @date 2020/10/26
 */
public class TestRunner {

    /**
     * TestControllerTest 的测试执行类
     * @param args
     */
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestControllerTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("TestControllerTest 方法的执行结果：" + result.wasSuccessful());
    }

}
