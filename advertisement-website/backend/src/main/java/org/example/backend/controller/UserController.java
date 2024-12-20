package org.example.backend.controller;

import org.example.backend.entity.User;
import org.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController控制器类，处理用户相关的HTTP请求
 */
@RestController
@RequestMapping("/api/users")  // 定义请求路径为/api/users
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有用户
     * @return 用户列表
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.listUsers();
    }

    /**
     * 添加用户
     * @param user 用户对象
     * @return 操作结果
     */
    @PostMapping
    public String addUser(@RequestBody User user) {
        userService.saveUser(user);
        return "用户添加成功";
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return 操作结果
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "用户删除成功";
    }

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户信息
     */
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }
}
