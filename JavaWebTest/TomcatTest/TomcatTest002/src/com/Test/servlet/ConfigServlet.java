package com.Test.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servletConfig", initParams = {
        @WebInitParam
                (name = "p1", value = "Cai_Guang")
})
public class ConfigServlet implements Servlet {

    private ServletConfig servletConfig = null;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig servletConfig1 = getServletConfig();
        String p1 = "p1";
        String v1 = servletConfig1.getInitParameter(p1);
        PrintWriter printWriter = servletResponse.getWriter();
        printWriter.println(p1 + " " + v1);
        System.out.println(v1);
    }

    @Override
    public String getServletInfo() {
        return "Cai_Guang";
    }

    @Override
    public void destroy() {

    }
}
