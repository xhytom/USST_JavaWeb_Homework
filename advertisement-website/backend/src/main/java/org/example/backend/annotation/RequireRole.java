package org.example.backend.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义权限注解，用于标识访问该接口的方法需要的角色
 */
@Target(ElementType.METHOD)  // 用于方法级别
@Retention(RetentionPolicy.RUNTIME)  // 运行时有效
public @interface RequireRole {
    String value();  // 用户需要的角色
}
