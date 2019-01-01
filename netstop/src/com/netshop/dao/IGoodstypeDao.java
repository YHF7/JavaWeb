package com.netshop.dao;

import java.util.List;

import com.netshop.dao.impl.ConnDB;
import com.netshop.entity.Goodstype;

public interface IGoodstypeDao {
    //操作数据库的类
    ConnDB connDB = new ConnDB();

    //查询所有商品类型列表(包括所有子类型)，返回类型对象集合
    public List<Goodstype> getAllGoodstype(int parentId);

    //添加一个商品类型
    public int add(Goodstype goodstype);

    //添加一组商品类型
    public int add(int parentId, String[] typeNames);

    //添加一组商品类型
    public int add(Goodstype[] gts);

    //查询商品类型列表(不查询子类型)，返回类型对象集合
    public List<Goodstype> getGoodstypeList(int parentId);

    //查询商品类型列表，返回json字符串
    public String getGoodstypeJsonText(int parentId);


}
