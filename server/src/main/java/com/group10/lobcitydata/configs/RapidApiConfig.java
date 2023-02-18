package com.group10.lobcitydata.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("rapidapi")
public class RapidApiConfig {
    private String urlBase;
    private String apiKey;
    private String host;

    public String getApiKey() {
        return apiKey;
    }

    public String getHost() {
        return host;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String toString() {
        return "{apiKey=" + apiKey + ", host=" + host + ", urlBase=" +
                urlBase + "}";
    }
}
