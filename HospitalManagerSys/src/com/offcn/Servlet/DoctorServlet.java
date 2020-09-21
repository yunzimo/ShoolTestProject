package com.offcn.Servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.Bean.Doctor;
import com.offcn.Dao.Imp.RegisterDaoImp;
import com.offcn.Service.DoctorService;
import com.offcn.Utils.LimitTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet("/DoctorServlet")
public class DoctorServlet extends BaseServlet {
    DoctorService ds=new DoctorService();
    public void QueryDoctorByKey(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String department = req.getParameter("department");
        System.out.println(department);
        String currentPage=req.getParameter("currentPage");
        int totalCount = ds.QueryTotalCount(name, department);
        System.out.println(totalCount);
        LimitTool tool=new LimitTool(totalCount,3,currentPage);
        System.out.println(tool);
        List<Doctor> doctors = ds.QueryDoctorByKey(name, department, tool);
        req.setAttribute("dlist",doctors);
        req.setAttribute("tool",tool);
        req.setAttribute("name",name);
        req.setAttribute("department",department);
        req.getRequestDispatcher("doctor/index.jsp").forward(req, resp);
    }
    public void InsertDoctorInfo(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //获取页面数据
        String name=req.getParameter("name");
        String cardno=req.getParameter("cardno");
        String phone=req.getParameter("phone");
        String sex=req.getParameter("sex");
        String birthday=req.getParameter("birthday");
        String age=req.getParameter("age");
        String email=req.getParameter("email");
        String department=req.getParameter("department");
        String education=req.getParameter("education");
        String remark=req.getParameter("remark");

        Doctor doctor=new Doctor(name,cardno,phone,Integer.parseInt(sex),Integer.parseInt(age),birthday,email,Integer.parseInt(department),Integer.parseInt(education),remark);
        boolean b = ds.InsertDoctorInfo(doctor);
        if(b){
            System.out.println("插入成功");
            resp.sendRedirect("DoctorServlet?method=QueryDoctorByKey");
        }else{
            resp.sendRedirect("add.jsp");
        }
    }
    public void QueryDoctorInfoById(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String did=req.getParameter("did");
        Doctor doctor = ds.QueryDoctorById(Integer.parseInt(did));
        req.setAttribute("dc",doctor);
        req.getRequestDispatcher("doctor/look.jsp").forward(req, resp);
    }
    public void QueryModifyById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String did=req.getParameter("did");
        Doctor doctor = ds.QueryDoctorById(Integer.parseInt(did));
        req.setAttribute("dc",doctor);
        req.getRequestDispatcher("doctor/edit.jsp").forward(req, resp);
    }
    public void ModifyDoctorInfo(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        //获取页面数据
        String name=req.getParameter("name");
        String cardno=req.getParameter("cardno");
        String phone=req.getParameter("phone");
        String sex=req.getParameter("sex");
        String birthday=req.getParameter("birthday");
        String age=req.getParameter("age");
        String email=req.getParameter("email");
        String department=req.getParameter("department");
        String education=req.getParameter("education");
        String remark=req.getParameter("remark");
        String did=req.getParameter("did");

        Doctor doctor=new Doctor(Integer.parseInt(did),name,cardno,phone,Integer.parseInt(sex),Integer.parseInt(age),birthday,email,Integer.parseInt(department),Integer.parseInt(education),remark);
        boolean b = ds.ModifyDoctorInfo(doctor);
        if (b){
            System.out.println("修改成功");
            resp.sendRedirect("DoctorServlet?method=QueryDoctorByKey");
        }

    }
    public void QueryDoctorByDepartment(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        System.out.println("开始查询");
        String department=req.getParameter("department");
        List<Doctor> doctors = ds.QueryDoctorByDepartment(department);
        String jsonString = new ObjectMapper().writeValueAsString(doctors);
        System.out.println(jsonString);
        resp.getWriter().print(jsonString);
    }

    public void DeleteDoctorByDids(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String dids=req.getParameter("dids");
        System.out.println(dids);
        new RegisterDaoImp().DeleteByDids(dids);
        boolean b = ds.DeleteDoctorByDids(dids);
        if(b){
            System.out.println("删除成功");
            resp.sendRedirect("DoctorServlet?method=QueryDoctorByKey");
        }else{
            System.out.println("删除失败");
        }
    }

}
