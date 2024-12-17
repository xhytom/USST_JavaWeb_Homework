package com.test;

import com.test.Entity.UserEntity;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/servletTest")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setAttribute("age", 20);
//        RequestDispatcher rd = req.getRequestDispatcher("/Test.jsp");
//        rd.forward(req, resp);
        ArrayList<UserEntity> userEntities = new ArrayList<UserEntity>();
        userEntities.add(new UserEntity("Cai_Guang", 19, 0));
        userEntities.add(new UserEntity("GammaRays", 20, 0));
        userEntities.add(new UserEntity("xhytom", 20, 1));
        userEntities.add(new UserEntity("zsc", 31, 1));
        userEntities.add(new UserEntity("zzj", 1000, 1));
        req.setAttribute("userEntities", userEntities);
        req.getRequestDispatcher("userList.jsp").forward(req, resp);
    }
}
