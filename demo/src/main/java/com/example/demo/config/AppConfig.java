package com.example.demo.config;
import java.time.LocalTime;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    public String greeting() {
    	return "Application started at: " + LocalTime.now();
    }
    
}
