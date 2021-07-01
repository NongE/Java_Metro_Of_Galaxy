package com.levelup.mog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

// properties에 저장한 변수, 값을 가져오기 위함
@ConfigurationProperties("api")
public class SetProperty {

    private String url;
    private String key;
    private String type;
    private String service;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
