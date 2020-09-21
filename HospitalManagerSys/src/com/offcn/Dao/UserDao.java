package com.offcn.Dao;

import com.offcn.Bean.User;

import javax.servlet.http.HttpSession;

public interface UserDao {
    public int InsertUser(User user);
    public User LoginCheck(String username, String password);
    public boolean verCodeCheck(String verify, HttpSession session);
}
