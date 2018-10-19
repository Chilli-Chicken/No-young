package com.tienchih.zhgl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "plc")
@PropertySource("classpath:system.properties")
public class SystemSettings {

    private String url;
    private String ctrlUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCtrlUrl() {
        return ctrlUrl;
    }

    public void setCtrlUrl(String ctrlUrl) {
        this.ctrlUrl = ctrlUrl;
    }

}