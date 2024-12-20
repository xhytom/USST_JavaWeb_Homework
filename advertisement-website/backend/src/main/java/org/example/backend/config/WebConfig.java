package org.example.backend.config;

import org.example.backend.interceptor.RoleInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置权限拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RoleInterceptor roleInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(roleInterceptor)  // 注册拦截器
                .addPathPatterns("/api/ads/**", "/api/users/**")  // 配置需要拦截的路径
                .excludePathPatterns("/api/public/**");  // 配置不需要拦截的路径
    }
}
