package com.netshop.dao;

import com.netshop.dao.impl.ConnDB;
import com.netshop.entity.User;
import com.netshop.entity.Order;
import java.util.List;

public interface IOrderDao {
    ConnDB connDB = new ConnDB();
    public int addOrder(Order oreder);

    public List<Order> getOrders(User user);
}