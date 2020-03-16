package com.gankki.bo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 测试 @ConfigurationProperties
 * @author liuhao
 * @date 2020/3/16
 */
@Data
public class PropertiesTestBO {
    private String url;
    private String username;
    private String password;
}
