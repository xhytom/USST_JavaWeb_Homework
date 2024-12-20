package org.example.backend.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.backend.annotation.RequireRole;
import org.example.backend.entity.User;
import org.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.lang.reflect.Method;

/**
 * 权限拦截器，检查请求是否符合所需的角色权限
 */
@Component
public class RoleInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            // 获取方法上的注解
            RequireRole requireRole = method.getAnnotation(RequireRole.class);
            if (requireRole != null) {
                String requiredRole = requireRole.value();
                // 从请求中获取用户名（假设已经登录且有token等验证方式）
                String username = request.getHeader("username");
                User user = userService.getUserByUsername(username);

                // 检查用户角色是否符合要求
                if (user == null || !user.getRole().equals(requiredRole)) {
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);  // 如果角色不符合，则返回403禁止访问
                    return false;
                }
            }
        }
        return true;  // 如果权限符合，则继续处理请求
    }
}
