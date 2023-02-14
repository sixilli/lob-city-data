package com.group10.lobcitydata.adaptors;

import com.group10.lobcitydata.configs.RapidApiConfig;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class RapidApiAdaptor {
    private RapidApiConfig config;

    @Autowired
    public RapidApiAdaptor(RapidApiConfig config) {
        this.config = config;
    }

    public void printConfig() {
        System.out.println(config);
    }
}
