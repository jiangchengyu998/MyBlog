package com.javalizi.blog.config;

import com.javalizi.blog.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/admin/**")
                .addPathPatterns("/blogger/main")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/error");
    }
}
