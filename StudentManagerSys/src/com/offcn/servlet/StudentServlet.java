package com.offcn.servlet;

import com.offcn.bean.Student;
import com.offcn.dao.StudentDao;
import com.offcn.service.StudentService;
import com.offcn.utils.LimitTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/StudentServlet")
@MultipartConfig
public class StudentServlet extends BaseServlet {

    public void AddStudents(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{


        //获取所有的数据
        String name=req.getParameter("name");
        int age= Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");
        String birthday=req.getParameter("birthday");
        System.out.println(birthday);

        String degree=req.getParameter("degree");
        String[] hobbys=req.getParameterValues("hobby");
        String mark=req.getParameter("mark");

        //对hobby进行处理
        String hobby="";

        for(String h:hobbys){
            hobby+=h+",";
        }
        System.out.println(hobby);
        hobby=hobby.substring(0,hobby.length()-1);
        System.out.println(hobby);

        //对头像进行处理
        Part part=req.getPart("pic");
        String path="/home/yunzimo/Downloads/testdown/";
        String filename=part.getSubmittedFileName();
        String pic=UUID.randomUUID()+filename;
        path=path+pic;
        part.write(path);

        Student student=new Student(name,age,sex,birthday,degree,hobby,pic,mark);
        System.out.println(student);

        if(new StudentService().AddStudentCheck(student)){
            req.getRequestDispatcher("StudentServlet?method=ShowAllStudentInfo").forward(req, resp);
        }else{
            resp.getWriter().print("插入失败");
        }
    }
    public void ShowAllStudentInfo(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String querykey=req.getParameter("querykey");
        req.setAttribute("querykey",querykey);
        String currentPage=req.getParameter("currentPage");
        int totalCount=StudentService.QueryInfoNumber(querykey);
        LimitTool limitTool=new LimitTool(totalCount,3,currentPage);
        List<Student> list=null;
        list=StudentService.showStudents(querykey,limitTool);
        System.out.println(list.size());
        req.setAttribute("list",list);
        req.setAttribute("limit",limitTool);
        req.getRequestDispatcher("ShowStuInfo.jsp").forward(req,resp);
    }
    public void DeleteStudentById(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        boolean b1 = StudentService.DeleteFaceById(id);
        if(b1){
            System.out.println("同时删除头像文件成功");
        }else{
            System.out.println("删除头像失败");
        }
        boolean b = new StudentService().DeleteStudentById(id);
        if(b){
            req.getRequestDispatcher("StudentServlet?method=ShowAllStudentInfo").forward(req, resp);
        }else{
            resp.getWriter().println("删除出错");
        }
    }
    public void ShowStudentInfoById(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        Student student = StudentService.ShowStudentInfoById(id);
        req.setAttribute("s",student);
        req.getRequestDispatcher("ShowStudentDetail.jsp").forward(req, resp);
    }
    public void ShowStudentInfoModify(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        Student student = StudentService.ShowStudentInfoById(id);
        req.setAttribute("s",student);
        req.getRequestDispatcher("modifyStudent.jsp").forward(req, resp);
    }
    public void UpdateStudentInfo(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        //获取所有的数据
        String name=req.getParameter("name");
        int age= Integer.parseInt(req.getParameter("age"));
        String sex=req.getParameter("sex");
        String birthday=req.getParameter("birthday");
        System.out.println(birthday);

        String degree=req.getParameter("degree");
        String[] hobbys=req.getParameterValues("hobby");
        String mark=req.getParameter("mark");
        int id= Integer.parseInt(req.getParameter("id"));

        //对hobby进行处理
        String hobby="";

        for(String h:hobbys){
            hobby+=h+",";
        }
        System.out.println(hobby);
        hobby=hobby.substring(0,hobby.length()-1);
        System.out.println(hobby);

        //对头像进行处理
        Part part=req.getPart("pic");
        String pic="";
        if(part.getSize()!=0){
            String path="/home/yunzimo/Downloads/testdown/";
            String filename=part.getSubmittedFileName();
            pic=UUID.randomUUID()+filename;
            path=path+pic;
            part.write(path);
            boolean b1 = StudentService.DeleteFaceById(id);
            if(b1){
                System.out.println("同时删除头像文件成功");
            }else{
                System.out.println("删除头像失败");
            }
        }else{
            pic=req.getParameter("oldpic");
        }


        Student student=new Student(name,age,sex,birthday,degree,hobby,pic,mark);
        System.out.println(student);

        if(StudentService.ModifyStudentInfo(student,id)){
            req.getRequestDispatcher("StudentServlet?method=ShowAllStudentInfo").forward(req, resp);
        }else{
            resp.getWriter().print("修改失败");
        }
    }

}
