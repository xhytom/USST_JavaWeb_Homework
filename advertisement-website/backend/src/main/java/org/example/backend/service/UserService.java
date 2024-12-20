package org.example.backend.service;

import org.example.backend.entity.User;

import java.util.List;

/**
 * UserService接口，定义了用户相关的业务逻辑
 */
public interface UserService {
    List<User> listUsers();  // 获取所有用户

    void saveUser(User user);  // 保存用户

    void deleteUser(Long id);  // 删除用户

    User getUserByUsername(String username);  // 根据用户名获取用户信息
}
