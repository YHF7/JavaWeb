package com.netshop.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userTel;
    private String userSex;
    private String birthdate;
    private String email;

    private Set deliveryinfos = new HashSet(); //新增属性，所有收货地址的集合
    private Set orders = new HashSet(); //新增属性，该用户所有订单的集合

    public User(){
        super();
    }

    public User(int userId,String userName,String userPwd,String userTel,String userSex,String birthdate,String email)
    {
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userTel = userTel;
        this.userSex = userSex;
        this.birthdate = birthdate;
        this.email = email;
    }
    //
    public User(int userId,String userName,String userPwd,String userTel,String userSex,String birthdate,String email,Set deliveryinfos, Set orders){
        super();
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userTel = userTel;
        this.userSex = userSex;
        this.birthdate = birthdate;
        this.email = email;
        this.deliveryinfos = deliveryinfos;
        this.orders = orders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set getDeliveryinfos() {
        return deliveryinfos;
    }

    public void setDeliveryinfos(Set deliveryinfos) {
        this.deliveryinfos = deliveryinfos;
    }

    public Set getOrders() {
        return orders;
    }

    public void setOrders(Set orders) {
        this.orders = orders;
    }

}



