package com.offcn.service;

import com.offcn.bean.Student;
import com.offcn.dao.StudentDao;
import com.offcn.utils.LimitTool;

import java.io.File;
import java.util.List;

public class StudentService {
    public boolean AddStudentCheck(Student student){
        if(new StudentDao().AddStudent(student)>0)return true;
        else return false;
    }

    public static List<Student> showStudents(String querykey, LimitTool limitTool){
        return new StudentDao().ShowAllStudentsInfo(querykey,limitTool);
    }

    public boolean DeleteStudentById(int id){
        return new StudentDao().DeleteStudentById(id)>0;
    }
    public static boolean DeleteFaceById(int id){
        String pic= StudentDao.DeleteFaceById(id);
        System.out.println("头像名:"+pic);
        File file = new File("/home/yunzimo/Downloads/testdown/"+pic);
        System.out.println(file.isFile());
        boolean delete = file.delete();
        return delete;
    }
    public static Student ShowStudentInfoById(int id){
        return StudentDao.ShowStudentInfoById(id);
    }
    public static boolean ModifyStudentInfo(Student student,int id){
        int i = StudentDao.ModifyStudentInfo(student, id);
        return i > 0;
    }
    public static int QueryInfoNumber(String querykey){
        return StudentDao.QueryInfoNumber(querykey);
    }

}
