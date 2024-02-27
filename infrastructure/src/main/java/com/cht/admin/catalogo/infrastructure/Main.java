package com.cht.admin.catalogo.infrastructure;

import com.cht.admin.catalogo.application.UseCase;
import com.cht.admin.catalogo.infrastructure.configuration.WebServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.AbstractEnvironment;

import static org.springframework.core.env.AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.setProperty(DEFAULT_PROFILES_PROPERTY_NAME,"development");
        SpringApplication.run(WebServerConfig.class,args);
    }
}