package com.netshop.dao;

import java.util.List;

import com.netshop.dao.impl.ConnDB;
import com.netshop.entity.Deliveryinfo;
import com.netshop.entity.User;

public interface IDeliveryinfoDao {

    ConnDB connDB = new ConnDB();

    public List<Deliveryinfo> getDeliveryinfoList(User user);

    public int addDeliveryinfo(Deliveryinfo di);

    public int setDefault(int diID, User user);

    public Deliveryinfo getDeliveryinfoById(int diId);

}
