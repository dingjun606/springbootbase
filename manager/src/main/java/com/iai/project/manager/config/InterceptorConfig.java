package com.iai.project.manager.config;

import com.iai.project.common.interceptor.CORSRequestInterceptor;
import com.iai.project.common.interceptor.UserTokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 拦截器
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public CORSRequestInterceptor corsRequestInterceptor() { return new CORSRequestInterceptor(); }
    @Bean
    public UserTokenInterceptor userTokenInterceptor() {
        return new UserTokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userTokenInterceptor())
                // 添加拦截
                .addPathPatterns("/user/*")
                // 白名单
                .excludePathPatterns("/user/*");

        registry.addInterceptor(corsRequestInterceptor());
    }

}
