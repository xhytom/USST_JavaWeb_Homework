package com.Test002.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/httpServletDemo3")
public class HttpServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        String contextPath = req.getContextPath();
        StringBuffer requestUrl = req.getRequestURL();

        String requestUrlStr = requestUrl.toString();

        String requestUri = req.getRequestURI();
        String queryString = req.getQueryString();

        String header = req.getHeader("User-Agent");

        System.out.println("method : " + method);
        System.out.println("context-Path : " + contextPath);
        System.out.println("requestUrl : " + requestUrl);
        System.out.println("requestUrlStr : " + requestUrlStr);
        System.out.println("requestUri : " + requestUri);
        System.out.println("queryString : " + queryString);
        System.out.println("header(\"User-Agent\") : " + header);

        String parameters = queryString;

        HashMap<String, String> parameterHashMap = new HashMap<>();

        String[] parameter = parameters.split("&");

        for (String p : parameter) {
            String[] ps = p.split("=");
            String key = URLDecoder.decode(ps[0], "UTF-8");
            String val = URLDecoder.decode(ps[1], "UTF-8");
            parameterHashMap.put(key, val);
        }

        Map<String, String[]> parameterMap = req.getParameterMap();

        String[] parameterValues = req.getParameterValues("name");

        String parameterVal = req.getParameter("name");
        System.out.println(parameterHashMap);
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey());
            for (String t : entry.getValue()) {
                System.out.println(t);
            }
        }
        for (String s : parameterValues) {
            System.out.println(s);
        }
        System.out.println(parameterVal);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
