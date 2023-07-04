package com.gankki.data.test.log;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 日志测试规范
 * @Author: liuhao
 * @Date: 2019/10/29 23:33
 */
// 必须使用门面模式中的 Slf4j，便于统一
@Slf4j
public class LoggerTest {

    public static void main(String[] args){
        try {
            List<String> list = new ArrayList<>();
            String str = list.get(0);
            str.length();
        } catch (Exception e) {
            // 异常信息应该包括两类信息：案发现场信息和异常堆栈信息。如果不处理，那么通过关键字throws往上抛出。
            // 注意日志输出的级别，error级别只记录系统逻辑出错、异常或者重要的错误信息。
            // 可以使用warn日志级别来记录用户输入参数错误的情况，避免用户投诉时，无所适从。如非必要，请不要在此场景打出error级别，避免频繁报警。
            log.error("XXXX_{}", e.getMessage(), e);
            log.error("各类参数或者对象toString()_{}", e.getMessage(), e);
            log.error("各类参数或者对象toString()_{}", e.getMessage(), e);1
            log.error("各类参数或者对象toString()_{}", e.getMessage(), e);2

        }
    }


}
