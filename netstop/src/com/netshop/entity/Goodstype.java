package com.netshop.entity;

import java.util.ArrayList;
import java.util.List;

public class Goodstype {
    private int typeId;			//商品类型编号
    private String typeName;	//商品类型名称
    private int parentId;		//所属上级商品类型

    //该商品类型下的所有子类型
    private List<Goodstype> subTypes = new ArrayList<Goodstype>();
    //新增，该类型下的所有商品的集合
    private List<Goods> goods = new ArrayList<Goods>();

    public Goodstype() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Goodstype(int typeId, String typeName, int parentId) {
        super();
        this.typeId = typeId;
        this.typeName = typeName;
        this.parentId = parentId;
    }

    public Goodstype(int typeId, String typeName, int parentId, List<Goods> goods) {
        super();
        this.typeId = typeId;
        this.typeName = typeName;
        this.parentId = parentId;
        this.goods = goods;
    }

    //getter和setter方法
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public List<Goodstype> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<Goodstype> subTypes) {
        this.subTypes = subTypes;
    }
}
