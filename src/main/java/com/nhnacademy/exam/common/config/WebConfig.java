package com.nhnacademy.exam.common.config;

import com.nhnacademy.exam.common.interceptor.AcceptHeaderInterceptor;
import com.nhnacademy.exam.common.interceptor.AuthHeaderInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final AcceptHeaderInterceptor acceptHeaderInterceptor;
    private final AuthHeaderInterceptor authHeaderInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(acceptHeaderInterceptor).addPathPatterns("/**");
        registry.addInterceptor(authHeaderInterceptor).addPathPatterns("/**");
    }

}
