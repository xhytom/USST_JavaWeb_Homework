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

@WebServlet("/httpServletSignin")
public class HttpServletSignin extends HttpServlet {
    static UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        try {
            UserEntity user = userService.signIn(name, password);
            if (user == null) {
                RequestDispatcher rd = req.getRequestDispatcher("/notWelcome.jsp");
                rd.forward(req, resp);
                return;
            }
            req.setAttribute("name", user.getName());
            req.setAttribute("age", user.getAge());
            req.setAttribute("pwd", user.getPassword());
            req.setAttribute("id", user.getId());
            RequestDispatcher rd = req.getRequestDispatcher("/welcome.jsp");
            rd.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
