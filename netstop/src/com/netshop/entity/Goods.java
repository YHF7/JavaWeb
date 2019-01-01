package com.netshop.entity;

public class Goods {
    private int goodsId;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private double goodsPrice;
    private String goodsDescr;
    private String brand;
    private int quantity;
    private double weight;

    private Goodstype goodsType;

    public Goods(){
        super();
    }

    public Goods(int goodsId, String goodsName, String goodsTitle,
                 String goodsImg, double goodsPrice, String goodsDescr,
                 String brand, int quantity, double weight)
    {
        super();
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsTitle = goodsTitle;
        this.goodsImg = goodsImg;
        this.goodsPrice = goodsPrice;
        this.goodsDescr = goodsDescr;
        this.brand = brand;
        this.quantity = quantity;
        this.weight = weight;
    }
    public Goods(int goodsId, String goodsName, String goodsTitle,
                 String goodsImg, double goodsPrice, String goodsDescr,
                 String brand, int quantity, double weight, Goodstype goodsType)
    {
        super();
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsTitle = goodsTitle;
        this.goodsImg = goodsImg;
        this.goodsPrice = goodsPrice;
        this.goodsDescr = goodsDescr;
        this.brand = brand;
        this.quantity = quantity;
        this.weight = weight;
        this.goodsType = goodsType;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDescr() {
        return goodsDescr;
    }

    public void setGoodsDescr(String goodsDescr) {
        this.goodsDescr = goodsDescr;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Goodstype getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Goodstype goodsType) {
        this.goodsType = goodsType;
    }


}
