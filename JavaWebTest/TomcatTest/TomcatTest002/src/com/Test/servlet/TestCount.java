package com.Test.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("/count")
public class TestCount implements Servlet {

    private Integer count = 1;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        servletResponse.setContentType("text/html;charset=UTF-8");

        PrintWriter writer = servletResponse.getWriter();
        System.out.println(Thread.currentThread().getName() + " count = " + count);
        writer.println("您是第" + count + "个同学访问这个网站的");
//        try {
//            Thread.sleep(5000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        writer.close();
        synchronized (this) {
            count ++;
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
