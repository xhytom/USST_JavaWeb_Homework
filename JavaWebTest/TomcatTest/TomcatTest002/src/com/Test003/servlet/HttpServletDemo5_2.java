package com.Test003.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/httpServletDemo5_2")
public class HttpServletDemo5_2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo5_2 ... begin");
        String name = req.getParameter("name");
        String age = req.getParameter("age");


        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String keys : parameterMap.keySet()) {
            System.out.println("key is " + keys);
            for (String vals : parameterMap.get(keys)) {
                System.out.println("val from " + keys + " is " + vals);
            }
        }
        System.out.println("Demo5_2 ... end");

        RequestDispatcher rd = req.getRequestDispatcher("/welcome5.jsp");
        if (name.equals("root") && age.equals("123456")) {
            req.setAttribute("status", "成功");
            req.setAttribute("username", name);
        } else {
            req.setAttribute("status", "失败");
            req.setAttribute("username", "傻逼" + name);
        }
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
