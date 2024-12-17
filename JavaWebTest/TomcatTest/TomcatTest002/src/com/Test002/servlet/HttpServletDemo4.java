package com.Test002.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/httpServletDemo4")
public class HttpServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String keys : parameterMap.keySet()) {
            System.out.println("key is " + keys);
            for (String vals : parameterMap.get(keys)) {
                System.out.println("val from " + keys + " is " + vals);
            }
        }

        String name = req.getParameter("name");
        System.out.println(name);
    }
}
