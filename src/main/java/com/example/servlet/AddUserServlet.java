package com.example.servlet;

import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        int age=Integer.parseInt(req.getParameter("age"));
        String phone=req.getParameter("phone");
        UserDao dao=new UserDaoImpl();
        dao.Add(id,name,age,phone);
        resp.sendRedirect(req.getContextPath()+"/showServlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
