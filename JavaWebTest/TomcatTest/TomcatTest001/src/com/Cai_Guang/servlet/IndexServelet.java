package com.Cai_Guang.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/awa")
public class IndexServelet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 根据url映射查找到 并调用service方法
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("awa");
        String userName = servletRequest.getParameter("userName");
        PrintWriter printWriter = servletResponse.getWriter();
        if (userName.equals("Cai_Guang")) {
            printWriter.println("ok");
        } else {
            printWriter.println("fail");
        }
        printWriter.close();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
