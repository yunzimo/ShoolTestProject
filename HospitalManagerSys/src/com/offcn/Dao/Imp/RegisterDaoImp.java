package com.offcn.Dao.Imp;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.Bean.Register;
import com.offcn.Dao.RegisterDao;
import com.offcn.Utils.LimitTool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class RegisterDaoImp  implements RegisterDao {
    QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
    @Override
    public int TotalCount(String rid, String name, String department) {
        int count=0;
        StringBuilder sql=new StringBuilder("select count(*) from register where 1=1");
        if(name!=null&&(!name.equals(""))){
            sql.append(" and name like '%").append(name).append("%'");
        }
        if(rid!=null&&(!rid.equals(""))){
            sql.append(" and rid like '%").append(rid).append("%'");
        }
        if(department!=null&&(!department.equals(""))&&(!department.equals("0"))){
            sql.append(" and department = ").append(department);
        }
        try{
            Long l=(Long)qr.query(sql.toString(),new ScalarHandler());
            count=l.intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public List<Register> QueryRegisterByKey(String rid, String name, String department, LimitTool tool) {
        StringBuilder sql=new StringBuilder("select * from register where 1=1");
        if(name!=null&&(!name.equals(""))){
            sql.append(" and name like '%").append(name).append("%'");
        }
        if(rid!=null&&(!rid.equals(""))){
            sql.append(" and rid like '%").append(rid).append("%'");
        }
        if(department!=null&&(!department.equals(""))&&(!department.equals("0"))){
            sql.append(" and department = ").append(department);
        }
        sql.append(" limit ?,?");
        try{
            List<Register> query = qr.query(sql.toString(), new BeanListHandler<Register>(Register.class), tool.getStartIndex(), tool.getPageSize());
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int InsertRegisterInfo(Register register) {
//      rid  | name| idCard | siNumber | registerMoney | phone| isPay | sex  | age  | consultation | department | did  | status | registerDate | remark
        String sql="insert into register (rid,name,idCard,siNumber,registerMoney,phone,isPay,sex,age,consultation,department,did,status,registerDate,remark)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            return qr.update(sql,register.getRid(),register.getName(),register.getIdCard(),register.getSiNumber(),register.getRegisterMoney(),register.getPhone(),register.getIsPay(),register.getSex(),register.getAge(),register.getConsultation(),register.getDepartment(),register.getDid(),register.getStatus(),register.getRegisterDate(),register.getRemark());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Register QueryRegisterByRid(String rid) {
        String sql="select * from register where rid=?";
        try{
            Register query = qr.query(sql, new BeanHandler<Register>(Register.class), rid);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int DeleteRegisterByRids(String rids) {
        String sql="delete from register where rid in("+rids+")";
        try{
            return qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int ModifyRegisterByKey(Register register) {
        //      rid  | name| idCard | siNumber | registerMoney | phone| isPay | sex  | age  | consultation | department | did  | status | registerDate | remark
        String sql="update register set rid=?,name=?,idCard=?,siNumber=?,registerMoney=?,phone=?,isPay=?,sex=?,age=?,consultation=?,department=?,did=?,status=?,registerDate=?,remark=? where rid=?";
        try{
            return qr.update(sql,register.getRid(),register.getName(),register.getIdCard(),register.getSiNumber(),register.getRegisterMoney(),register.getPhone(),register.getIsPay(),register.getSex(),register.getAge(),register.getConsultation(),register.getDepartment(),register.getDid(),register.getStatus(),register.getRegisterDate(),register.getRemark(),register.getRid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void DeleteByDids(String dids) {
        String sql="delete from register where did in ("+dids+")";
        try{
            qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
