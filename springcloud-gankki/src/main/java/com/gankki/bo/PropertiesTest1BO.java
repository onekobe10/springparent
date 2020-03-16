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
@Component("bar")
@ConfigurationProperties("bar.datasource")
public class PropertiesTest1BO {
    private String url;
    private String username;
    private String password;
}
