package org.example.backend.controller;

import org.example.backend.entity.User;
import org.example.backend.service.UserService;
import org.example.backend.utils.JWTUtil;
import org.example.backend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户控制器，处理用户注册、登录等请求
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 用户注册接口
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        boolean success = userService.register(user);
        if (success) {
            return Result.ok().message("注册成功");
        } else {
            return Result.error().message("用户名已存在");
        }
    }

    // 用户登录接口
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        String token = JWTUtil.createToken(user.getUsername());
        return Result.ok().data("Token", token);
    }
}
