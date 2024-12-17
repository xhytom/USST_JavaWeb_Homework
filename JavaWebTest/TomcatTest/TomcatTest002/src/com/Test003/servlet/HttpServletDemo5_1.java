package com.Test003.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/httpServletDemo5_1")
public class HttpServletDemo5_1 extends HttpServlet {
    /**
     * 请求转发时 只能转发到服务器内部 并且地址栏不会改变
     * 转发只有一次，如果需要多次则需要不断转发
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo5_1 ... begin");
        req.getRequestDispatcher("/httpServletDemo5_2").forward(req, resp);
        System.out.println("Demo5_1 ... end");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
