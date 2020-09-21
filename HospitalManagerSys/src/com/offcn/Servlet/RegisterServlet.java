package com.offcn.Servlet;


import com.offcn.Bean.Register;
import com.offcn.Service.RegisterService;
import com.offcn.Utils.LimitTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends BaseServlet {
    RegisterService rs=new RegisterService();
    public void QueryRegisterByKey(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rid=req.getParameter("rid");
        String name=req.getParameter("name");
        String department=req.getParameter("department");
        String currentPage=req.getParameter("currentPage");
        int totalCount = rs.QueryTotalCount(rid, name, department);

        LimitTool tool=new LimitTool(totalCount,3,currentPage);

        List<Register> registers = rs.QueryRegisterByKey(rid, name, department, tool);
        req.setAttribute("registers",registers);
        req.setAttribute("rid",rid);
        req.setAttribute("name",name);
        req.setAttribute("department",department);
        req.setAttribute("tool",tool);
        req.getRequestDispatcher("register/index.jsp").forward(req, resp);
    }
    public void InsertRegisterInfo(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String rid=req.getParameter("rid");
        String name=req.getParameter("name");
        String siNumber=req.getParameter("siNumber");
        String idCard=req.getParameter("idCard");
        String registerMoney=req.getParameter("registerMoney");
        String phone=req.getParameter("phone");
        String isPay=req.getParameter("isPay");
        String sex=req.getParameter("sex");
        String age=req.getParameter("age");
        String consultation=req.getParameter("consultation");
        String department=req.getParameter("department");
        String did=req.getParameter("did");
        String remark=req.getParameter("remark");
        Register register=new Register(rid,name,idCard,siNumber,Double.parseDouble(registerMoney),phone,Integer.parseInt(isPay),Integer.parseInt(sex),Integer.parseInt(age),Integer.parseInt(consultation),Integer.parseInt(department),Integer.parseInt(did),1,new Date(),remark);

        boolean b = rs.InsertRegisterInfo(register);
        if(b){
            System.out.println("插入成功");
            resp.sendRedirect("RegisterServlet?method=QueryRegisterByKey");
        }else{
            System.out.println("插入失败");
        }
    }
    public void QueryRegisterByRid(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String rid=req.getParameter("rid");
        Register register = rs.QueryRegisterByRid(rid);
        req.setAttribute("re",register);
        req.getRequestDispatcher("register/look.jsp").forward(req, resp);
    }
    public void DeleteRegisterByRids(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String rids=req.getParameter("rids");
        boolean b = rs.DeleteRegisterByRids(rids);
        if(b){
            System.out.println("删除成功");
            resp.sendRedirect("RegisterServlet?method=QueryRegisterByKey");
        }else{
            System.out.println("删除失败");
        }
    }
    public void ModifyQueryByRid(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String rid=req.getParameter("rid");
        Register register = rs.QueryRegisterByRid(rid);
        req.setAttribute("re",register);
        req.getRequestDispatcher("register/edit.jsp").forward(req, resp);
    }
    public void ModifyRegisterByKey(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String rid=req.getParameter("rid");
        String name=req.getParameter("name");
        String siNumber=req.getParameter("siNumber");
        String idCard=req.getParameter("idCard");
        String registerMoney=req.getParameter("registerMoney");
        String phone=req.getParameter("phone");
        String isPay=req.getParameter("isPay");
        String sex=req.getParameter("sex");
        String age=req.getParameter("age");
        String consultation=req.getParameter("consultation");
        String department=req.getParameter("department");
        String did=req.getParameter("did");
        String remark=req.getParameter("remark");

        Register register=new Register(rid,name,idCard,siNumber,Double.parseDouble(registerMoney),phone,Integer.parseInt(isPay),Integer.parseInt(sex),Integer.parseInt(age),Integer.parseInt(consultation),Integer.parseInt(department),Integer.parseInt(did),1,new Date(),remark);
        System.out.println(register);

        boolean b = rs.ModifyRegisterByKey(register);
        if(b){
            System.out.println("更新成功");
            resp.sendRedirect("RegisterServlet?method=QueryRegisterByKey");
        }else{
            System.out.println("更新失败");
        }
    }
}
