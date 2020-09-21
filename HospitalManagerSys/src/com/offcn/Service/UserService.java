package com.offcn.Service;

import com.offcn.Bean.User;
import com.offcn.Dao.Imp.UserDaoImp;
import com.offcn.Dao.UserDao;

import javax.servlet.http.HttpSession;

public class UserService {
    UserDao ud=new UserDaoImp();
    public boolean InsertUser(User user){
        return ud.InsertUser(user)>0;
    }
    public boolean LoginCheck(String username,String password){
        if(ud.LoginCheck(username,password)!=null)return true;
        else return false;
    }
    public boolean verCodeCheck(String verify, HttpSession session){
        return ud.verCodeCheck(verify,session);
    }
}
