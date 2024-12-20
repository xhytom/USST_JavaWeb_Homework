package org.example.backend.service.impl;

import org.example.backend.entity.User;
import org.example.backend.mapper.UserMapper;
import org.example.backend.service.UserService;
import org.example.backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类，处理用户的注册和登录逻辑
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  // 密码加密

    // 用户注册实现
    @Override
    public boolean register(User user) {
        if (userMapper.findByUsername(user.getUsername()) != null) {
            return false;  // 用户名已存在
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));  // 加密密码
        userMapper.insert(user);  // 将用户信息存入数据库
        return true;
    }

    // 用户登录实现
    @Override
    public String login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return JWTUtil.createToken(user.getUsername());  // 生成JWT Token
        }
        return null;  // 登录失败
    }
}
