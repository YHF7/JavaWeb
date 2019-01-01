package com.netshop.dao;

import com.netshop.dao.impl.ConnDB;
import com.netshop.entity.User;

public interface IUserDao {
    ConnDB connDB = new ConnDB();

    public User login(String userName,String userPwd);
}