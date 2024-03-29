package com.group10.lobcitydata.builders;

import java.util.HashMap;
import java.util.Map;

// 2.4.2 URL builder for requests, must support query parameters
public class UrlBuilder {
    private final String urlBase, route;
    HashMap<String, String> queryParams;
    
    public UrlBuilder(String urlBase, String route) {
        this.urlBase = urlBase;
        this.route = route;
        this.queryParams = new HashMap<>();
    }
    
    public void addQueryParam(String key, String value) {
        this.queryParams.put(key, value);
    }

    public void addQueryParams(Map<String,String> queryParams) {
        this.queryParams.putAll(queryParams);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.urlBase.trim());
        sb.append(this.route.trim());

        if (!this.queryParams.isEmpty()) {
            sb.append("?");
            this.queryParams.forEach((key, value) -> {
                sb.append(key);
                sb.append("=");
                sb.append(value);
                sb.append("&");
            });
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
