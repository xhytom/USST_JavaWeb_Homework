package com.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws PropertyVetoException, SQLException {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        pool.setMaxPoolSize(30);
        pool.setAcquireRetryAttempts(3);
        pool.setAcquireRetryDelay(1000);
        Connection connection = pool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = 4");

        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next()) {
            System.out.println("未找到");
            return;
        }
        Long id = resultSet.getLong("id");
        String phone = resultSet.getString("phone");
        String password  = resultSet.getString("password");

        System.out.println(id + phone + password);
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;

    }

//    pool.setUser("root");
}
