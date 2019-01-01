package com.netshop.dao.impl;

import com.netshop.dao.IUserDao;
import com.netshop.entity.User;
import java.sql.ResultSet;

public class UserDao implements IUserDao {


    public User login(String userName,String userPwd) {
        User user = null;
        String sql = "select * from user where userName=? and userPwd=?";


        ResultSet rs = this.connDB.executeQuery(sql, new Object[]{userName, userPwd});
        try {
            if (rs.next()) {
                int userId = rs.getInt("userId");

                String userTel = rs.getString("userTel");
                String userSex = rs.getString("userSex");
                String birthdate = rs.getString("birthdate");
                String email = rs.getString("email");


                user = new User(userId, userName, userPwd, userTel, userSex, birthdate, email);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.connDB.close();
        }
        return user;
    }
}