package org.example.backend.service;

import org.example.backend.entity.User;

/**
 * 用户服务接口，定义用户注册、登录等操作
 */
public interface UserService {

    /**
     * 用户注册
     * @param user 用户对象
     * @return 注册是否成功
     */
    boolean register(User user);

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 返回JWT Token，如果登录失败返回null
     */
    String login(String username, String password);
}
