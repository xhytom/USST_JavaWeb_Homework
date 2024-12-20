package org.example.backend.config;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis-Plus配置类，用于配置分页插件
 */
@Configuration  // 标注为配置类
public class MyBatisPlusConfig {

    /**
     * 配置分页插件
     * @return 分页插件实例
     */
    @Bean
    public PaginationInnerInterceptor paginationInterceptor() {
        return new PaginationInnerInterceptor();  // 分页插件，自动处理分页请求
    }
}
