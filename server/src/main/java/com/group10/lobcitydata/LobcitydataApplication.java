package com.group10.lobcitydata;

import com.group10.lobcitydata.configs.RapidApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MapPropertySource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class LobcitydataApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(LobcitydataApplication.class);
		app.run();
	}

	public void run(String... args) {
	}
}
