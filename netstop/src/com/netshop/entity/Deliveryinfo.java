package com.netshop.entity;

public class Deliveryinfo {
    private int diId;
    private String receiver;
    private String address;
    private String postcode;
    private String phoneNum;
    private int isDefault;

    private User user;

    public Deliveryinfo(){
        super();
    }
    public Deliveryinfo(String receiver,String address,String postcode,String phoneNum,int isDefault,User user){
        super();
        this.receiver = receiver;
        this.address = address;
        this.postcode = postcode;
        this.phoneNum = phoneNum;
        this.isDefault= isDefault;
        this.user = user;
    }
    public Deliveryinfo(int diId,String receiver,String address,String postcode,String phoneNum,int isDefault, User user){
        super();
        this.diId = diId;
        this.receiver = receiver;
        this.address = address;
        this.postcode = postcode;
        this.phoneNum = phoneNum;
        this.isDefault= isDefault;
        this.user = user;
    }
    public int getDiId() {
        return diId;
    }
    public void setDiId(int diId) {
        this.diId = diId;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    public int getIsDefault() {
        return isDefault;
    }
    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

}
