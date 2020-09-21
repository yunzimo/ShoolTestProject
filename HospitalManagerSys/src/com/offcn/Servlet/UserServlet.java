package com.offcn.Servlet;


import com.offcn.Bean.User;
import com.offcn.Service.UserService;
import com.offcn.Utils.RegistCheck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;


@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
    UserService us=new UserService();
    public void RegCheck(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String CheckKey=req.getParameter("CheckKey");
        String CheckValue=req.getParameter("CheckValue");
        boolean b = RegistCheck.RegisterCheck("users", CheckKey, CheckValue);
        resp.getWriter().print(b);
    }
    public void InsertUser(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
//        name   | email            | status | username | password | modifytime
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User(name,email,1,username,password,new Date());
        System.out.println(user);
        boolean b = us.InsertUser(user);
        if(b){
            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("regist.jsp");
        }
    }
    public void LoginCheck(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        boolean b = us.LoginCheck(username, password);
        HttpSession session=req.getSession();
        if(b){
            resp.sendRedirect("index.jsp");
            session.setAttribute("username",username);
        }else{
            resp.sendRedirect("login.jsp");
            session.setAttribute("msg","登录失败，请检查用户名和密码");
        }

    }
    public void verCodeCheck(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String verify=req.getParameter("verify");
        HttpSession session = req.getSession();
        boolean b = us.verCodeCheck(verify, session);
        resp.getWriter().print(b);
    }
    public void DestroySession(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        HttpSession session=req.getSession();
        session.invalidate();
        resp.sendRedirect("login.jsp");
    }
}
