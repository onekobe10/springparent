package com.gankki.bo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 测试 @ConfigurationProperties
 * @author liuhao
 * @date 2020/3/16
 */
@Data
@ConfigurationProperties("sat.datasource")
public class PropertiesTest2BO {
    private String url;
    private String username;
    private String password;
}
