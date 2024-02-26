package com.cht.admin.catalogo.infrastructure;

import com.cht.admin.catalogo.application.UseCase;
import com.cht.admin.catalogo.infrastructure.configuration.WebServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(WebServerConfig.class,args);
    }
}