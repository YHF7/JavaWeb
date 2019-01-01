package com.netshop.dao.impl;

import com.netshop.dao.IOrderitemDao;
import com.netshop.entity.Order;
import com.netshop.entity.Orderitem;
import com.netshop.entity.Goods;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OrderitemDao implements IOrderitemDao {

    @Override
    public int addOrderItem(ArrayList<Orderitem> orderItems) {
        String sql = "insert into `orderitem`( `quantity`, `orderId`, `goodsId`) values(?,?,?)";
        ArrayList<Object[]> al = new ArrayList<Object[]>();
        for (int i = 0; i < orderItems.size(); i++) {
            Orderitem oi = orderItems.get(i);
            al.add(new Object[]{oi.getOrder().getOrderId(),oi.getGoods().getGoodsId(),oi.getQuantity()});
        }
        int x = this.connDB.executeBatch(sql,al);
        return x;
    }

    @Override
    public Set<Orderitem> getOrderitems(Order order) {
        Set<Orderitem> orderitems = new HashSet<Orderitem>();
        String sql = "select itemId,orderId,orderitem.quantity,goods.* from orderitem,goods" + " where orderitem.goodsId=goods.goodsId and orderId=?";
        ResultSet rs = this.connDB.executeQuery(sql,new Object[]{order.getOrderId()});
        try {
            Goods goods;
            Orderitem oi;
            while (rs.next()) {
                goods = new Goods(rs.getInt("goodsId"),rs.getString("goodsName"),rs.getString("goodsTitle"),rs.getString("goodsImg"),rs.getDouble("goodsPrice"),rs.getString("goodsDescr"),rs.getString("brand"),rs.getInt("goods.quantity"),rs.getDouble("weight"));
                oi = new Orderitem(rs.getInt("itemId"),order,goods,rs.getInt("orderitem.quantity"));
                orderitems.add(oi);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            this.connDB.close();
        }
        return orderitems;
    }
}