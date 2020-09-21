package com.offcn.Dao.Imp;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.Bean.Doctor;
import com.offcn.Dao.DoctorDao;
import com.offcn.Utils.LimitTool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class DoctorDaoImp  implements DoctorDao {
    @Override
    public int QueryTotalCount(String name, String department) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        StringBuilder sql=new StringBuilder("select count(*) from doctor where 1=1");
        int count=0;
        if(name!=null&&(!name.equals(""))){
            sql.append(" and name like '%").append(name).append("%'");
        }
        if(department!=null&&(!department.equals("0"))&&(!department.equals(""))){

            sql.append(" and department =").append(department);
        }
        try{
            Long l=(long)qr.query(String.valueOf(sql),new ScalarHandler<>());
            count=l.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Doctor> QueryDoctorByKey(String name, String department, LimitTool tool) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        StringBuilder sql=new StringBuilder("select * from doctor where 1=1");

        if(name!=null&&(!name.equals(""))){
            sql.append(" and name like '%").append(name).append("%'");
        }
        if(department!=null&&(!department.equals("0"))&&(!department.equals(""))){
            sql.append(" and department =").append(department);
        }
        sql.append(" limit ?,?");
        try{
            return qr.query(sql.toString(),new BeanListHandler<Doctor>(Doctor.class),tool.getStartIndex(),tool.getPageSize());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int InsertDoctorInfo(Doctor doctor) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="insert into doctor (name,cardno,phone,sex,age,birthday,email,department,education,remark)values(?,?,?,?,?,?,?,?,?,?)";
        try{
            return qr.update(sql,doctor.getName(),doctor.getCardno(),doctor.getPhone(),doctor.getSex(),doctor.getAge(),doctor.getBirthday(),doctor.getEmail(),doctor.getDepartment(),doctor.getEducation(),doctor.getRemark());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Doctor QueryDoctorById(int did) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="select * from doctor where did=?";
        try{
            return qr.query(sql, new BeanHandler<Doctor>(Doctor.class), did);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int ModifyDoctorInfo(Doctor doctor) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="update doctor set name=?,cardno=?,phone=?,sex=?,age=?,birthday=?,email=?,department=?,education=?,remark=? where did=?";
        try{
            return qr.update(sql,doctor.getName(),doctor.getCardno(),doctor.getPhone(),doctor.getSex(),doctor.getAge(),doctor.getBirthday(),doctor.getEmail(),doctor.getDepartment(),doctor.getEducation(),doctor.getRemark(),doctor.getDid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Doctor> QueryDoctorByDepartment(String department) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="select * from doctor where department=?";
        try{
           return qr.query(sql,new BeanListHandler<Doctor>(Doctor.class),department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int DeleteDoctorByDids(String dids) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="delete from doctor where did in ("+dids+")";
        try{
            return qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
