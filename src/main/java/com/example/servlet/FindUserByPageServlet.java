package com.example.servlet;

import com.example.bean.Page;
import com.example.bean.User;
import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取参数
        int currentPage= Integer.parseInt(request.getParameter("currentPage"));
        int rows= Integer.parseInt(request.getParameter("rows"));

        //调用dao查询
        UserDao dao=new UserDaoImpl();
        Page pb=dao.findUserByPage(currentPage,rows);
        request.setAttribute("pb",pb);
        request.getRequestDispatcher("detail.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
