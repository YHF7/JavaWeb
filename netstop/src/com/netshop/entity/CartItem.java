package com.netshop.entity;

public class CartItem {
    private Goods goods;
    private int quantity;
    private double total;

    public CartItem(){
        super();
    }
    public CartItem(Goods goods, int quantity, double total){
        super();
        this.goods = goods;
        this.quantity = quantity;
        this.total = total;
    }
    public Goods getGoods() {
        return goods;
    }
    public void setGoods(Goods goods) {
        this.goods = goods;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

}
