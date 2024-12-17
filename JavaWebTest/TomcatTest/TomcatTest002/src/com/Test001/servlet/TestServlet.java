package com.Test001.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/**
 * @WebServlet(urlPatterns = "/Test", loadOnStartup = x)
 * x 负数 在之后执行 init
 * x 非负数，越接近 0 优先级越高
 */

 @WebServlet(urlPatterns = "/Test", loadOnStartup = 0)
public class TestServlet implements Servlet {
    public TestServlet() {
        System.out.println("无参构造方法");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("在生命周期只执行一次的 init 代码");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("每次请求都会调用的 service 代码，这里存放业务逻辑");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("停止 tomcat 时销毁 servlet 的代码");
    }
}
