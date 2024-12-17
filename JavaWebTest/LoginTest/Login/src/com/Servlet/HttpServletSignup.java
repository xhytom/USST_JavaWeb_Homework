package com.Servlet;

import com.User.Entity.UserEntity;
import com.User.Service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/httpServletSignup")
public class HttpServletSignup extends HttpServlet {
    static UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        try {
            int ret = userService.signUp(name, password, age);
            if (ret == 0) {
                RequestDispatcher rd = req.getRequestDispatcher("/notWelcome.jsp");
                rd.forward(req, resp);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = req.getRequestDispatcher("/httpServletSignin");
        rd.forward(req, resp);
    }
}
