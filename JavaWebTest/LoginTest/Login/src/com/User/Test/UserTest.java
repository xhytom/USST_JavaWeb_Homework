package com.User.Test;

import com.User.Service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserTest {
    static UserService userService = new UserService();
    static Scanner scanner = new Scanner(System.in);
    static int age;
    static String name;
    static String password;
    public static void main(String[] args) throws SQLException {
        while (true) {
            System.out.println("1 - SignUp");
            System.out.println("2 - SignIn");
            System.out.println("3 - Quit");
            int op = scanner.nextInt();
            switch (op) {
                case 1:
                    signUp();
                    break;
                case 2:
                    signIn();
                    break;
                case 3:
                    break;
            }
            if (op == 3) {
                System.out.println("Byebye");
                break;
            }
        }
    }

    public static void signIn() throws SQLException {
        System.out.println("UserName");
        name = scanner.next();
        System.out.println("Password");
        password = scanner.next();
        System.out.println(name + password);
        if (userService.signIn(name, password) == null) {
            System.out.println("Error");
            return;
        }
        System.out.println("Success");
    }

    public static void signUp() throws SQLException {
        System.out.println("UserName");
        name = scanner.next();
        System.out.println("Password");
        password = scanner.next();
        System.out.println("Age ");
        age = scanner.nextInt();
        if (userService.signUp(name, password, age) == 0) {
            System.out.println("Error");
            return;
        }
        System.out.println("Success");
    }
}
