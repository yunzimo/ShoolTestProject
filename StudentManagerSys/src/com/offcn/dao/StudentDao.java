package com.offcn.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.bean.Student;
import com.offcn.utils.LimitTool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    public int AddStudent(Student student){
        QueryRunner qr = new QueryRunner(new ComboPooledDataSource());
        String sql="insert into student (name,age,sex,birthday,degree,hobby,pic,mark) values(?,?,?,?,?,?,?,?)";
        try{
            return qr.update(sql,student.getName(),student.getAge(),student.getSex(),student.getBirthday(),student.getDegree(),student.getHobby(),student.getPic(),student.getMark());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<Student> ShowAllStudentsInfo(String querykey, LimitTool limitTool){
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        StringBuilder sql = new StringBuilder("select * from student where 1=1");

        if(querykey!=null&&(!querykey.equals(""))){
            sql.append(" and name like '%"+querykey+"%'");
        }
        sql.append(" limit ?,?");
        try{
            return qr.query(sql.toString(),new BeanListHandler<Student>(Student.class),limitTool.getStartIndex(),limitTool.getPageSize());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int DeleteStudentById(int id){

        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="delete from student where id=?";
        try{
            return qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static String DeleteFaceById(int id){
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="select * from student where id=?";
        try{

            String query = qr.query(sql, new ScalarHandler<String>("pic"), id);
//            System.out.println(query);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Student ShowStudentInfoById(int id){
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="select * from student where id=?";
        try{
            Student query = qr.query(sql, new BeanHandler<Student>(Student.class), id);
            System.out.println(query);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int ModifyStudentInfo(Student student,int id){
        QueryRunner queryRunner=new QueryRunner(new ComboPooledDataSource());
        String sql="update student set name=?,age=?,sex=?,birthday=?,degree=?,hobby=?,pic=?,mark=? where id=?";
        try{
            return queryRunner.update(sql,student.getName(),student.getAge(),student.getSex(),student.getBirthday(),student.getDegree(),student.getHobby(),student.getPic(),student.getMark(),id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static int QueryInfoNumber(String querykey){
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        StringBuilder sql=new StringBuilder("select count(*) from student where 1=1");
        int count=0;
        if(querykey!=null&&(!querykey.equals(""))){
            sql.append(" and name like '%"+querykey+"%'");
        }
        try{
            Long number=(Long)qr.query(sql.toString(), new ScalarHandler<>());
            count=number.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
