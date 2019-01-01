package com.netshop.dao;

import java.util.List;

import com.netshop.dao.impl.ConnDB;
import com.netshop.entity.Goods;

public interface IGoodsDao {
    ConnDB connDB = new ConnDB();
    public List<Goods> getGoodsList(int goodstypeId);
    public Goods getGoodsById(int goodsId);

}
