package com.User.Service;

import com.User.Dao.UserDao;
import com.User.Entity.UserEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    public ArrayList<UserEntity> queryAllUser() throws SQLException {
        ArrayList<UserEntity> userEntities = UserDao.queryAllUser();
        return userEntities;
    }

    public UserEntity queryUserById(Long id) throws SQLException {
        return UserDao.queryUserById(id);
    }
    public UserEntity queryUserByName(String name) throws SQLException {
        return UserDao.queryUserByName(name);
    }

    public UserEntity signIn(String name, String password) throws SQLException {
        UserEntity user = userExists(name);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
    public int signUp(String name, String password, int age) throws SQLException {
        if (name == null) {
            return 0;
        }
        if (password == null) {
            return 0;
        }
        if (age == 0) {
            return 0;
        }
        UserEntity user = userExists(name);
        if (user != null) {
            return 0;
        }
        user = new UserEntity();
        user.setName(name);
        user.setAge(age);
        user.setPassword(password);
        return UserDao.addUser(user);
    }
    public UserEntity userExists(String name) throws SQLException {
        UserEntity user = UserDao.queryUserByName(name);
        if (user == null) {
            return null;
        }
        return user;
    }
}
