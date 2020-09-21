package com.offcn.Utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.Bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class RegistCheck {
    public static boolean RegisterCheck(String tableName,String CheckKey,String CheckValue){
        QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
        String sql="select * from "+tableName+" where "+CheckKey+" = '"+CheckValue+"'";
        try{
            User query = qr.query(sql, new BeanHandler<User>(User.class));
            if(query!=null)return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
