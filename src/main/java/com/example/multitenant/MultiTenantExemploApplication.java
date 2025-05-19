package com.example.multitenant;

import com.example.multitenant.filter.TenantFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultiTenantExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiTenantExemploApplication.class, args);

	}



}
