package com.example.servlet;

import com.example.dao.LoginDao;
import com.example.dao.impl.LoginDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String verify=req.getParameter("verifyCode");
        String username,password;

        username=req.getParameter("username");
        password=req.getParameter("password");
        LoginDao dao=new LoginDaoImpl();
        HttpSession session=req.getSession();
        String checkCode=(String)session.getAttribute("code");
        session.removeAttribute("code");
        if(!checkCode.equalsIgnoreCase(verify)){
            req.setAttribute("verifyCheck","验证码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
            return;
        }
        try {
            if(dao.Login(username,password)){
                //登陆成功
                session.setAttribute("username",username);
                // session.setAttribute("password",password);
                resp.sendRedirect(req.getContextPath()+"/showServlet");
            }else{
                req.setAttribute("er","户名或密码错误");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
