package com.offcn.Servlet;

import com.offcn.Bean.Medicine;
import com.offcn.Service.MedicineService;
import com.offcn.Utils.LimitTool;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@MultipartConfig
@WebServlet("/MedicineServlet")
public class MedicineServlet extends BaseServlet {
    MedicineService ms=new MedicineService();
    public void QueryMedicineByKey(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String type=req.getParameter("type");
        String currentPage=req.getParameter("currentPage");
        int totaoCount = ms.QueryTotaoCount(name, type);
        LimitTool tool=new LimitTool(totaoCount,3,currentPage);
        List<Medicine> medicines = ms.QueryMedicineByKey(name, type, tool);
        System.out.println(medicines);
        req.setAttribute("medicines",medicines);
        req.setAttribute("name",name);
        req.setAttribute("type",type);
        req.setAttribute("tool",tool);
        req.getRequestDispatcher("medicine/index.jsp").forward(req, resp);
    }
    public void QueryMedicineById(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String mid=req.getParameter("mid");
        Medicine medicine = ms.QueryMedicineById(mid);
        req.setAttribute("mc",medicine);
        req.getRequestDispatcher("medicine/look.jsp").forward(req, resp);
    }
    public void InsertMedicine(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        String mid=req.getParameter("mid");
        String inPrice=req.getParameter("inPrice");
        String salPrice=req.getParameter("salPrice");
        String name=req.getParameter("name");
        String type=req.getParameter("type");
        String descs=req.getParameter("descs");
        String qualityDate=req.getParameter("qualityDate");
        String description=req.getParameter("description");
        String produceFirm=req.getParameter("produceFirm");
        String readme=req.getParameter("readme");
        String remark=req.getParameter("remark");

        //头像上传
        Part part=req.getPart("picture");
        String fileName = part.getSubmittedFileName();
        String path="/home/yunzimo/data/secondFile/Hospital-pic/";
        fileName= UUID.randomUUID()+fileName;
        String filepath=path+fileName;
        part.write(filepath);

        Medicine medicine=new Medicine(mid,fileName,Double.parseDouble(inPrice),Double.parseDouble(salPrice),name,Integer.parseInt(type),descs,Integer.parseInt(qualityDate),description,produceFirm,readme,remark);

        boolean b = ms.InsertMedicine(medicine);
        if(b){
            System.out.println("插入成功");
            resp.sendRedirect("MedicineServlet?method=QueryMedicineByKey");
        }
    }
    public void DeleteMedicineByMids(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        String mids=req.getParameter("mids");
        System.out.println(mids);
        boolean b = ms.DeleteMedicineByMids(mids);
        if(b){
            System.out.println("删除成功");
            resp.sendRedirect("MedicineServlet?method=QueryMedicineByKey");
        }else{
            System.out.println("删除失败");
        }
    }
    public void ModifyMedicineInfo(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        String mid=req.getParameter("mid");
        String inPrice=req.getParameter("inPrice");
        String salPrice=req.getParameter("salPrice");
        String name=req.getParameter("name");
        String type=req.getParameter("type");
        String descs=req.getParameter("descs");
        String qualityDate=req.getParameter("qualityDate");
        String description=req.getParameter("description");
        String produceFirm=req.getParameter("produceFirm");
        String readme=req.getParameter("readme");
        String remark=req.getParameter("remark");
        String oldpicture=req.getParameter("oldpicture");

        //头像上传
        Part part=req.getPart("picture");
        String fileName = part.getSubmittedFileName();
        System.out.println(fileName);
        if(!fileName.equals("")){
            String path="/home/yunzimo/data/secondFile/Hospital-pic/";
            fileName= UUID.randomUUID()+fileName;
            String filepath=path+fileName;
            part.write(filepath);
        }else{
            fileName=oldpicture;
        }
        Medicine medicine=new Medicine(mid,fileName,Double.parseDouble(inPrice),Double.parseDouble(salPrice),name,Integer.parseInt(type),descs,Integer.parseInt(qualityDate),description,produceFirm,readme,remark);


        boolean b = ms.ModifyMedicine(medicine);
        if(b){
            System.out.println("修改成功");
            resp.sendRedirect("MedicineServlet?method=QueryMedicineByKey");
        }
    }
    public void ModifyMedicineShow(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        String mid=req.getParameter("mid");
        Medicine medicine = ms.QueryMedicineById(mid);
        req.setAttribute("mc",medicine);
        req.getRequestDispatcher("medicine/edit.jsp").forward(req, resp);
    }
}
