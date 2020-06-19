package com.hkk.boottest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kang
 * @since 2020/6/19
 */
@ConfigurationProperties("config")
public class ProfileConfig {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
