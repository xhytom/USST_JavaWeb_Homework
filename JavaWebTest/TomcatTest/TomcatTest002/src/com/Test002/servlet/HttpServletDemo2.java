package com.Test002.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/httpServletDemo2")
public class HttpServletDemo2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println("接受get请求方法 ");

        String res = new String();
        if (name.equals("root") && age.equals("123456")) {
            res = "恭喜你登陆成功！";
        } else {
            res = "很遗憾登陆失败！";
        }

        PrintWriter printWriter = resp.getWriter();
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");

        printWriter.write("<html> <meta charset = \"utf-8\"" +
                "<body>" +
                "<h1>" +
                res +
                "</h1>" +
                "</body>" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("接受post请求方法 ");
    }
}
