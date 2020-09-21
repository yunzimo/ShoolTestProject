package com.offcn.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.bean.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import java.sql.SQLException;


public class AccountDao {
    public Account getAccounts(String username,String password){
        QueryRunner queryRunner=new QueryRunner(new ComboPooledDataSource());
        String sql="select * from admin where username=? and password=?";
        try{
            Account query = queryRunner.query(sql, new BeanHandler<Account>(Account.class),username,password);
            return query;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
