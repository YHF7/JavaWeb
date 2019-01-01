package com.netshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.netshop.dao.impl.GoodsDao;
import com.netshop.entity.CartItem;
import com.netshop.entity.Goods;

public class CartServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String act = request.getParameter("action");	//servlet后的参数action
        GoodsDao goodsDao = new GoodsDao();	//后面要用到GoodstypeDao操作数据库

        if (act.equals("add")) {
            int goodsId = Integer.parseInt(request.getParameter("goodsId"));
            int buyNum = Integer.parseInt(request.getParameter("buyNum"));

            Goods goods = goodsDao.getGoodsById(goodsId);
            if (session.getAttribute("cart") == null) {
                Map<Integer,CartItem> map = new HashMap<Integer,CartItem>();
                CartItem ci = new CartItem(goods,buyNum,buyNum*goods.getGoodsPrice());
                map.put(goodsId,ci);
                session.setAttribute("cart",map);
            }else {
                Map<Integer,CartItem> map = (Map<Integer,CartItem>)session.getAttribute("cart");
                if (map.containsKey(goodsId)) {
                    CartItem ci = map.get(goodsId);
                    ci.setQuantity(ci.getQuantity() + buyNum);
                    ci.setTotal(ci.getQuantity() * ci.getGoods().getGoodsPrice());
                    map.put(goodsId,ci);
                }
                else {
                    CartItem ci = new CartItem(goods,buyNum,buyNum*goods.getGoodsPrice());
                    map.put(goodsId,ci);
                }
                session.setAttribute("cart",map);
            }
            request.getRequestDispatcher("CartServlet?action=list").forward(request,response);
        } else if (act.equals("list")) {
            double total = 0.0;
            Map<Integer,CartItem> map = (Map<Integer,CartItem>)session.getAttribute("cart");
            Collection c = map.values();
            List<CartItem> list = new ArrayList<CartItem>(c);
            for (int i=0;i<list.size();i++) {
                CartItem ci = list.get(i);
                total += ci.getTotal();
            }
            request.setAttribute("list",list);
            request.setAttribute("total",total);
            request.getRequestDispatcher("../viewCart.jsp").forward(request,response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

}

