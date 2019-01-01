package com.netshop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.netshop.dao.IGoodstypeDao;
import com.netshop.entity.Goodstype;

public class GoodstypeDao implements IGoodstypeDao {
    //查询所有商品类型列表(包括所有子类型)，返回类型对象集合
    public List<Goodstype> getAllGoodstype(int parentId)
    {
        List<Goodstype> list = new ArrayList<Goodstype>();
        String sql = "select typeId,typeName,parentId from goodstype where parentId=" + parentId;
        try
        {
            ResultSet rs = connDB.executeQuery(sql);
            while(rs.next())	//将查询得到的每条记录，都封装成一个Goodstype对象
            {
                Goodstype goodstype =
                        new Goodstype(rs.getInt("typeId"), rs.getString("typeName"), rs.getInt("parentId"));
                list.add(goodstype);	//将当前类型添加到List集合中
            }
        }
        catch(SQLException se){	se.printStackTrace();	}
        finally{	connDB.close();	}

        //继续查询每个类型的子类型
        for(int i=0; i<list.size(); i++)
        {
            Goodstype gt = list.get(i);
            List<Goodstype> list02 = this.getAllGoodstype(gt.getTypeId());	//找出该类型的所有子类型
            gt.setSubTypes(list02);			//设置子类型的集合
        }
        return list;
    }

    //添加一个商品类型
    @Override
    public int add(Goodstype goodstype) {
        String sql = "insert into goodstype(typeName, parentId) values(?, ?)";
        Object[] objs = new Object[]{ goodstype.getTypeName(), goodstype.getParentId()};
        int x = connDB.executeUpdate(sql, objs);
        return x;
    }

    //添加一组商品类型
    @Override
    public int add(int parentId, String[] typeNames) {
        ArrayList<Object[]> al = new ArrayList<Object[]>();
        for(int i=0; i<typeNames.length; i++)
        {
            //把一个子分类名+父分类编号组成数组，添加到ArrayList对象al中
            al.add(new Object[]{typeNames[i].trim(),parentId});	//trim()去首尾空格
        }
        String sql = "insert into goodstype(typeName, parentId) values(?, ?)";
        int x = connDB.executeBatch(sql, al);
        return x;
    }

    //添加一组商品类型
    @Override
    public int add(Goodstype[] gts) {
        ArrayList<Object[]> al = new ArrayList<Object[]>();
        for(int i=0; i<gts.length; i++)
        {
            //把一个子分类名+父分类编号组成数组，添加到ArrayList对象al中
            al.add(new Object[]{ gts[i].getTypeName(), gts[i].getParentId()});
        }
        String sql = "insert into goodstype(typeName, parentId) values(?, ?)";
        int x = connDB.executeBatch(sql, al);
        return x;
    }

    //查询商品类型列表(不查询子类型)，返回类型对象集合
    @Override	//查询商品类型列表
    public List<Goodstype> getGoodstypeList(int parentId) {
        List<Goodstype> list = new ArrayList<Goodstype>();
        String sql = "select typeId,typeName,parentId from goodstype where parentId=" + parentId;
        try
        {
            ResultSet rs = connDB.executeQuery(sql);
            while(rs.next())	//将查询得到的每条记录，都封装成一个Goodstype对象
            {
                Goodstype goodstype = new Goodstype(rs.getInt("typeId"), rs.getString("typeName"), rs.getInt("parentId"));
                list.add(goodstype);
            }
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        finally
        {
            connDB.close();
        }
        return list;
    }

    //查询商品类型列表，返回json字符串
    @Override	//查询商品类型列表，返回json字符串
    public String getGoodstypeJsonText(int parentId) {
        String str = "[{\"typeId\":\"0\",\"typeName\":\"请选择\"},";
        String sql = "select typeId,typeName,parentId from goodstype where parentId=" + parentId;
        try
        {
            ResultSet rs = connDB.executeQuery(sql);
            //将查询得到的每条记录，都格式化成键值对形式，
            //如[{"typeId":"1", "typeName":"家用电器"},{"typeId":"2", "typeName":"服装饰品"}]
            while(rs.next())
            {
                str += String.format("{\"typeId\":\"%d\",\"typeName\":\"%s\"},",
                        rs.getInt("typeId"), rs.getString("typeName"));
            }
            str = str.substring(0, str.length()-1) + "]";
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        finally
        {
            connDB.close();
        }
        return str;
    }
}
