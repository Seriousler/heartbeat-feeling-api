package com.azimao.heartbeat.common.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private BaseInterceptor baseInterceptor;
    @Autowired
    private ApiInterceptor apiInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/**", "/swagger**/**", "/**/api-docs/**");
        registry.addInterceptor(apiInterceptor)
                .addPathPatterns("/api/**", "/swagger**/**", "/**/api-docs/**");
    }

}
