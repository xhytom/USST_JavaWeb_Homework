package com.User.Dao;

import com.User.Entity.UserEntity;
import com.User.Utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    public static ArrayList<UserEntity> queryAllUser() throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<UserEntity> ret = null;
        while (resultSet.next()) {
            UserEntity user = new UserEntity();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getInt("age"));
            user.setPassword(resultSet.getString("password"));
            ret.add(user);
            System.out.println(user);
        }
        JdbcUtils.closeConnection(resultSet, preparedStatement, connection);

        return ret;
    }

    public static UserEntity queryUserById(Long id) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from user where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        UserEntity user = new UserEntity();
        if (!resultSet.next()) {
            return null;
        }
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        user.setPassword(resultSet.getString("password"));
        JdbcUtils.closeConnection(resultSet, preparedStatement, connection);
        return user;
    }

    public static UserEntity queryUserByName(String name) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "select * from user where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        UserEntity user = new UserEntity();
        if (!resultSet.next()) {
            return null;
        }
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setAge(resultSet.getInt("age"));
        user.setPassword(resultSet.getString("password"));
        JdbcUtils.closeConnection(resultSet, preparedStatement, connection);
        return user;
    }
    public static int addUser(UserEntity user) throws SQLException {
        Connection connection = JdbcUtils.getConnection();
        String sql = "insert into user values " +
                "(null, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setInt(2, user.getAge());
        preparedStatement.setString(3, user.getPassword());
        int res = preparedStatement.executeUpdate();
        JdbcUtils.closeConnection(preparedStatement, connection);
        return res;
    }
}
