package org.example;
import com.mysql.jdbc.Driver;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "root", "123456");

        // 创建执行者

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from movies_info");

        while (resultSet.next()) {
            System.out.println("name = " + resultSet.getString("name") + " type = " + resultSet.getString("type"));
        }
    }
}