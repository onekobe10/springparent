package com.gankki.product.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Java 业务开发常见错误100例
 * @author liuhao
 * @date 2020/11/25
 */
public class Test100Controller {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("1", "1");
        System.out.println(map.putIfAbsent("1", "2"));
        map.entrySet().stream().forEach(e -> {
            System.out.println(e.getValue());
        });
    }

}
