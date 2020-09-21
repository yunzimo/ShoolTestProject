package com.offcn.Dao.Imp;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.Bean.User;
import com.offcn.Dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class UserDaoImp  implements UserDao {

    @Override
    public int InsertUser(User user) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
//        name   | email            | status | username | password | modifytime
        String sql="insert into users (name,email,status,username,password,modifytime) values(?,?,?,?,?,?)";
        try{
            return qr.update(sql,user.getName(),user.getEmail(),user.getStatus(),user.getUsername(),user.getPassword(),user.getModifytime());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public User LoginCheck(String username, String password) {
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="select * from users where username=? and password=?";
        try{
            return qr.query(sql,new BeanHandler<User>(User.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean verCodeCheck(String verify, HttpSession session) {
        String verCode = (String) session.getAttribute("verCode");
        return verify.equals(verCode);
    }
}
