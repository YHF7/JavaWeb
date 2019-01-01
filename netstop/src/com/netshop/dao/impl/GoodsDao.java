package com.netshop.dao.impl;

import com.netshop.entity.Goodstype;
import com.netshop.entity.Goods;
import com.netshop.dao.IGoodsDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao implements IGoodsDao {
    public List<Goods> getGoodsList(int goodstypeId) {
        List<Goods> list = new ArrayList<Goods>();
        String sql = String.format("select goods.*,typeName,parentId from goods," + "goodstype where goods.typeId=goodstype.typeId and (goods.typeId=%d or goods.typeid in" + " (select distinct typeId from goodstype where parentId=%d))", goodstypeId, goodstypeId);
        try{
            ResultSet rs = connDB.executeQuery(sql);
            while(rs.next()) {
                int goodsId = rs.getInt("goodsId");
                String goodsName = rs.getString("goodsName");
                String goodsTitle = rs.getString("goodsTitle");
                String goodsImg = rs.getString("goodsImg");
                double goodsPrice = rs.getDouble("goodsPrice");
                String goodsDescr = rs.getString("goodsDescr");
                String brand = rs.getString("brand");
                int quantity = rs.getInt("quantity");
                double weight = rs.getDouble("weight");
                String typeName = rs.getString("typeName");
                int parentId = rs.getInt("parentId");

                Goodstype goodstype = new Goodstype(goodstypeId,typeName,parentId);
                goodstype.setTypeId(goodstypeId);

                Goods goods = new Goods(goodsId, goodsName,goodsTitle,goodsImg,goodsPrice,goodsDescr,brand,quantity,weight,goodstype);
                list.add(goods);
            }
        }catch(SQLException se) {
            se.printStackTrace();
        }finally {
            connDB.close();
        }
        return list;
    }

    public Goods getGoodsById(int goodsId) {
        Goods goods = null;
        String sql = "select goodsId, goodsName,goodsTitle,goodsImg,goodsPrice,goodsDescr," + "brand,quantity,weight,goodstype.typeId,typeName,parentId from" + " goods,goodstype where goods.typeId=goodstype.typeId and goodsId=?";
        ResultSet rs = this.connDB.executeQuery(sql,new Object[]{goodsId});
        try{
            if (rs.next()) {
                String goodsName = rs.getString("goodsName");
                String goodsTitle = rs.getString("goodsImg");
                String goodsImg = rs.getString("goodsImg");
                double goodsPrice = rs.getDouble("goodsPrice");
                String goodsDescr = rs.getString("goodsDescr");
                String brand = rs.getString("brand");
                int quantity = rs.getInt("quantity");
                double weight = rs.getDouble("weight");

                int typeId = rs.getInt("typeId");
                String typeName = rs.getString("typeName");
                int parentId = rs.getInt("parentId");

                Goodstype goodstype = new Goodstype(typeId,typeName,parentId);
                goods = new Goods(goodsId, goodsName,goodsTitle,goodsImg,goodsPrice,goodsDescr,brand,quantity,weight,goodstype);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            this.connDB.close();
        }
        return goods;
    }

}