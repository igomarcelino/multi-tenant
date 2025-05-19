package com.example.multitenant.config;

import com.example.multitenant.filter.TenantFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<TenantFilter> tenantFilterRegistrationBean(TenantFilter tenantFilter) {
        FilterRegistrationBean<TenantFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(tenantFilter);
        registrationBean.addUrlPatterns("/upload");
        registrationBean.addUrlPatterns("/doc/*");
        return registrationBean;
    }
}
