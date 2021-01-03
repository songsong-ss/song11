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
import java.util.List;

@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserDao dao=new UserDaoImpl();
        int id= Integer.parseInt(req.getParameter("id"));
        if(id>0){
            User user=dao.findById(id);
            req.setAttribute("user",user);
            req.getRequestDispatcher("look1.jsp").forward(req,resp);
        }else{
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
