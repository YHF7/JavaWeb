package com.netshop.entity;
public class Orderitem {
    private int itemId;
    private Order order;
    private Goods goods;
    private int quantity;

    public Orderitem() {
        super();
    }
    public Orderitem(Order order,Goods goods,int quantity) {
        super();
        this.order = order;
        this.goods = goods;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public Goods getGoods() {
        return goods;
    }

    public int getQuantity() {
        return quantity;
    }

    public Orderitem(int itemId, Order order, Goods goods, int quantity) {
        super();
        this.itemId = itemId;
        this.order = order;
        this.goods = goods;
        this.quantity = quantity;
    }
}