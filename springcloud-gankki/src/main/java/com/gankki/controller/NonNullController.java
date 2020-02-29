package com.gankki.controller;

import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * NonNull&Nullable 测试
 */
@RestController
@RequestMapping("/null")
public class NonNullController {

    /**
     * 如果为空编译器会有警告，仅仅有警告，没有其他的类似断言的抛出异常
     * @return
     */
    @RequestMapping("test")
    public String test(){
        String s = null;
        return test(s);
    }

    @NonNull
    private static String test(@NonNull String s) {
        System.out.println("测试" + s);
        return null;
    }


}
