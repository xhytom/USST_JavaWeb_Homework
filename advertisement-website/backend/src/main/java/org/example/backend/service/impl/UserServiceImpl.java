package org.example.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.backend.entity.User;
import org.example.backend.mapper.UserMapper;
import org.example.backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService实现类，提供用户相关业务逻辑的实现
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public List<User> listUsers() {
        return list();  // 获取所有用户
    }

    @Override
    public void saveUser(User user) {
        save(user);  // 保存用户
    }

    @Override
    public void deleteUser(Long id) {
        removeById(id);  // 根据ID删除用户
    }

    @Override
    public User getUserByUsername(String username) {
        return lambdaQuery().eq(User::getUsername, username).one();  // 根据用户名查询用户
    }
}
