package com.netshop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.netshop.dao.impl.DeliveryinfoDao;
import com.netshop.dao.impl.OrderDao;
import com.netshop.dao.impl.OrderitemDao;
import com.netshop.entity.CartItem;
import com.netshop.entity.Deliveryinfo;
import com.netshop.entity.Order;
import com.netshop.entity.Orderitem;
import com.netshop.entity.User;

public class OrderServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        String act =request.getParameter("action");
        DeliveryinfoDao diDao = new DeliveryinfoDao();
        OrderDao orderDao = new OrderDao();
        OrderitemDao orderitemDao = new OrderitemDao();
        if(act.equals("add"))
        {
            int diId = Integer.parseInt(request.getParameter("diId"));
            User user = (User)session.getAttribute("user");

            if(diId == 0)
            {
                String receiver = request.getParameter("receiver");
                String address = request.getParameter("address");
                String postcode = request.getParameter("postcode");
                String phoneNum = request.getParameter("phoneNum");
                int isDefault = 0;
                if(request.getParameter("isDefault") != null)
                    isDefault = Integer.parseInt(request.getParameter("isDefault"));
                Deliveryinfo di = new Deliveryinfo(receiver,address,postcode,phoneNum,isDefault,user);

                diId = diDao.addDeliveryinfo(di);
                if(isDefault==1)
                {
                    diDao.setDefault(diId, user);
                }
            }

            Deliveryinfo di02 = diDao.getDeliveryinfoById(diId);
            java.util.Date dt = new java.util.Date();
            String orderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dt);
            Order order = new Order(user, orderDate, di02);
            int orderId = orderDao.addOrder(order);

            if(orderId > 0)
            {
                order.setOrderId(orderId);
                Map<Integer, CartItem> map = (Map<Integer, CartItem>)session.getAttribute("cart");
                ArrayList<CartItem> al01 = new ArrayList<CartItem>(map.values());
                ArrayList<Orderitem> al02 = new ArrayList<Orderitem>();
                for(int i=0; i<al01.size(); i++)
                {
                    CartItem ci = al01.get(i);
                    Orderitem oi = new Orderitem(order, ci.getGoods(), ci.getQuantity());
                    al02.add(oi);
                }
                int x = orderitemDao.addOrderItem(al02);
                if(x > 0)
                {
                    session.removeAttribute("cart");
                    request.getRequestDispatcher("OrderServlet?action=list").forward(request, response);
                }
                else if(x == -1)
                {
                    out.print("添加订单时发生异常，以回滚!");
                }
            }
            else
                out.print("订单添加出错¡");

        }
        else if(act.equals("list"))
        {
            User user = (User)session.getAttribute("user");
            List<Order> list = orderDao.getOrders(user);
            request.setAttribute("list", list);
            request.getRequestDispatcher("../listOrders.jsp").forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        this.doPost(request, response);
    }
}

