package com.netshop.dao.impl;

import com.netshop.dao.IDeliveryinfoDao;
import com.netshop.entity.Deliveryinfo;
import com.netshop.entity.User;

import java.sql.ResultSet;
import java.util.*;

public class DeliveryinfoDao implements IDeliveryinfoDao{

    public List<Deliveryinfo> getDeliveryinfoList(User user) {
        List<Deliveryinfo> list = new ArrayList<Deliveryinfo>();

        String sql = "select * from deliveryinfo where userId=?";
        ResultSet rs = this.connDB.executeQuery(sql, new Object[]{user.getUserId() });
        try
        {
            while(rs.next())
            {
                int diId = rs.getInt("diId");
                String receiver = rs.getString("receiver");
                String address = rs.getString("address");
                String postcode = rs.getString("postcode");
                String phoneNum = rs.getString("phoneNum");
                int isDefault = rs.getInt("isDefault");

                Deliveryinfo di = new Deliveryinfo(diId,receiver,address, postcode,phoneNum,isDefault,user);
                list.add(di);
            }
        }
        catch(Exception ex){ex.printStackTrace();}
        finally{ this.connDB.close();}
        return list;
    }

    public int addDeliveryinfo(Deliveryinfo di){
        String sql = "insert into deliveryinfo(receiver,address,postcode,"+
                "phoneNum,isDefault,user) values(??????)";
        int x = this.connDB.executeUpdate(sql,new Object[]{
                di.getReceiver(),
                di.getAddress(),
                di.getPostcode(),
                di.getPhoneNum(),
                di.getUser().getUserId(), });
        if(x>0)
        {
            String sql2 = "select max(diId) as zuida from deliveryinfo";
            ResultSet rs = this.connDB.executeQuery(sql2);
            try
            {
                if(rs.next())
                {
                    x= rs.getInt("zuida");
                }
            }
            catch(Exception ex){     x=-1;ex.printStackTrace();}
            finally {     this.connDB.close();}
        }
        return x;
    }

    public int setDefault(int diId,User user){
        String sql01 = "update deliveryinfo set isDefault = 0 where uesrId=? and diId!=?";
        int x = this.connDB.executeUpdate(sql01, new Object[]{user.getUserId(),diId});

        if(x>0)
        {
            String sql02 = "update deliveryinfo set isDefault = 1 where diId=?";
            x = this.connDB.executeUpdate(sql02, new Object[]{   diId   });
        }
        return x;
    }

    public Deliveryinfo getDeliveryinfoById(int diId){
        Deliveryinfo di =null;
        String sql = "select * from deliveryinfo where diId=?";
        ResultSet rs = this.connDB.executeQuery(sql,new Object[]{  diId  });
        try
        {
            while(rs.next())
            {
                String receiver = rs.getString("receiver");
                String address = rs.getString("address");
                String postcode = rs.getString("postcode");
                String phoneNum = rs.getString("phoneNum");
                int isDefault = rs.getInt("isDefault");
                User user = new User();
                user.setUserId(rs.getInt("userId"));

                di = new Deliveryinfo(diId,receiver,address,
                        postcode,phoneNum,isDefault,user);
            }
        }
        catch(Exception ex){ex.printStackTrace();}
        finally{this.connDB.close();}
        return di;
    }
}
