package com.netshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netshop.dao.impl.DeliveryinfoDao;
import com.netshop.entity.CartItem;
import com.netshop.entity.Deliveryinfo;
import com.netshop.entity.User;

public class DeliveryinfoServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String act = request.getParameter("action");
        DeliveryinfoDao deliveryinfoDao = new DeliveryinfoDao();
        if(act.equals("list"))
        {
            User user = (User)session.getAttribute("user");

            List<Deliveryinfo> list = deliveryinfoDao.getDeliveryinfoList(user);
            List<String> goodsTitleList = new ArrayList<String>();
            double total = 0.0;
            Map<Integer, CartItem> map = (Map<Integer, CartItem>)session.getAttribute("cart");
            Collection c = map.values();
            ArrayList<CartItem> ciList = new ArrayList<CartItem>(c);
            for (int i=0; i<ciList.size();i++)
            {
                CartItem ci = ciList.get(i);
                goodsTitleList.add(ci.getGoods().getGoodsTitle());
                total += ci.getTotal();
            }

            request.setAttribute("list",list);
            request.setAttribute("goodsTitleList",goodsTitleList);
            request.setAttribute("total",total);
            request.getRequestDispatcher("../addOrder.jsp").forward(request,response);
        }
    }


    public  void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request,response);
    }
}

