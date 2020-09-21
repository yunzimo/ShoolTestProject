package com.offcn.service;

import com.offcn.bean.Account;
import com.offcn.dao.AccountDao;

public class AccountService {
    public boolean AccountCheck(String username,String password){
        Account account=null;
        account=new AccountDao().getAccounts(username,password);
        if(account==null)return false;
        else return true;
    }
}
