package com.gankki.controller;

import com.gankki.bo.PropertiesTest2BO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigurationProperties test
 * @author liuhao
 * @date 2020/3/17
 */
@Slf4j
@RestController
@RequestMapping("/configuration")
public class ConfigurationTestController {
    @Autowired
    private PropertiesTest2BO propertiesTest2BO;

    /**
     *
     * @return
     */
    @RequestMapping("test")
    public String test(){
        log.info("哈哈");
        return propertiesTest2BO.getUsername();
    }

}
