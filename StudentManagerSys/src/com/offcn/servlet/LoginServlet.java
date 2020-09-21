package com.offcn.servlet;

import com.offcn.service.AccountService;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        boolean check = new AccountService().AccountCheck(username, password);
        if(check){
            resp.getWriter().print("登录成功");
        }else {
            resp.getWriter().println("登录失败");
        }
    }
}
