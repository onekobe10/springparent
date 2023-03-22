package com.gankki.service;

import com.gankki.exception.RollbackException;
import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;

public interface FooService {
    void insertRecord();
    void insertThenRollback() throws RollbackException;
    void invokeInsertThenRollback() throws RollbackException;

    /*public static void main(String[] args) {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("year", "2021");
        valueMap.put("mouth", "5");
        valueMap.put("day", "6");
        valueMap.put("uuId", "12345678");
        String pattern = "Hello World and everyone?method=Hello&from=World&Year=${year}&Mouth=${mouth}&Day=${day}&UuidId=${uuId}";
        //Already deprecated,Not recommended
        StringSubstitutor substitutor = new StringSubstitutor(valueMap);
        String replace = substitutor.replace(pattern);
        System.out.println(replace);
    }*/

    public static void main(String[] args) {
        System.out.println(6 / (2 * 2));
    }

}
