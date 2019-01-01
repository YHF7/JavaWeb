package com.netshop.dao;

import com.netshop.dao.impl.ConnDB;
import com.netshop.entity.Orderitem;
import java.util.*;
import com.netshop.entity.Order;

public interface IOrderitemDao {
    ConnDB connDB = new ConnDB();

    public int addOrderItem(ArrayList<Orderitem> orderItems);

    public Set<Orderitem> getOrderitems(Order order);
}