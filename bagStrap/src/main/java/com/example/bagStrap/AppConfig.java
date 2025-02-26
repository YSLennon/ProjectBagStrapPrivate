package com.example.bagStrap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Value("${upload.url.path}")
    private String uploadUrlPath;
    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> servletContext.setAttribute("uploadUrlPath",uploadUrlPath);
    }
}
