package com.netshop.dao.impl;

import com.netshop.dao.IOrderDao;
import com.netshop.entity.Order;
import com.netshop.entity.User;
import com.netshop.entity.Orderitem;

import java.sql.ResultSet;
import java.util.*;

public class OrderDao implements IOrderDao {

    public int addOrder(Order order) {
        String sql01 = "insert into `order`(userId,orderDate,diId) value(?,?,?)";
        int x = this.connDB.executeUpdate(sql01,new Object[]{order.getUser().getUserId(),order.getOrderDate(),order.getDeInfo().getDiId()});
        if (x>0) {
            String sql02 = "select max(orderId) as zuida from order";
            ResultSet rs = this.connDB.executeQuery(sql02);
            try {
                if (rs.next()) {
                    x = rs.getInt("zuida");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }finally {
                this.connDB.close();
            }
        }
        return x;
    }

    public List<Order> getOrders(User user) {
        ArrayList<Order> al = new ArrayList<Order>();
        String sql = "select * from `order` where userId=?";
        ResultSet rs = this.connDB.executeQuery(sql,new Object[]{ user.getUserId()});
        OrderitemDao orderitemDao = new OrderitemDao();
        try {
            while (rs.next()) {
                Order order = new Order(rs.getInt("orderId"),user,rs.getString("orderDate"),rs.getString("orderStatus"));
                Set<Orderitem> orderitems = orderitemDao.getOrderitems(order);
                order.setOrderItems(orderitems);

                al.add(order);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            this.connDB.close();
        }
        return al;
    }
}