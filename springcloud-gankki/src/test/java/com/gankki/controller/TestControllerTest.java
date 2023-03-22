package com.gankki.controller;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TestController Tester.  单元测试
 *
 * @author liuhao
 * @version 1.0
 * @date 10/23/2020
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {
    @Autowired
    private TestController testController;

    @Before
    public void before() {
    }

    @After
    public void after() {
    }

    /**
     * Method: test()
     */
    @Test
    // @Ignore
    // 一个含有 @Ignore 注释的测试方法将不会被执行。
    // @Test(timeout=1000, expected = RuntimeException.class)
    // timeout：超过 1 s 的执行时间将认为方法测试是失败的
    // expected：测试代码是否它抛出了想要得到的异常
    public void test() throws Exception {
        String str = testController.test1();
        Assert.assertEquals("test1", str);
    }

    @Test
    public void test2() throws Exception {
        String str = testController.test2();
        Assert.assertEquals("test1", str);
    }

}
