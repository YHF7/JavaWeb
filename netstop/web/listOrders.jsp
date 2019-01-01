<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.netshop.entity.Order"%>
<%@page import="com.netshop.entity.Orderitem"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'listOrder.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/listOrders.css">

</head>

<body>
<div style="width:1024px; margin:20px auto;">
    订单列表:
    <ul id="ulOrder">
            <%
       if(request.getAttribute("list") != null)
       {
            List<Order> list = (List<Order>)request.getAttribute("list");
            for(int i=0; i<list.size(); i++)
            {
                Order order = list.get(i);
    %>
        <li class="liOrder">
            <div class="liHead">
                <div class="select"><input type="checkbox" name="ck" id="ck">选择</div>
                <div class="orderid">订单号:<%=order.getOrderId() %></div>
                <div class="del">
                    <a href="javascript:void(0)" onclick="alert('暂未实现')">删除</a>
                </div>
            </div>
            <ul>
                    <%
            Set<Orderitem> orderitems = order.getOrderItems();
            Iterator<Orderitem> it = orderitems.iterator();
            while(it.hasNext())
            {
               Orderitem oi = it.next();
          %>
                <li>
                    <div class="photo">
                        <a href="servlet/GoodsServlet?action=detail&goodsId=<%=oi.getGoods().getGoodsId() %>"
                           target="blank">
                            <img src="<%=oi.getGoods().getGoodsImg() %>"width="100px" height="100px" />
                        </a>
                    </div>
                    <div class="price">￥<%=oi.getGoods().getGoodsPrice() %></div>
                    <div class="quantity"><%=oi.getQuantity() %></div>
                    <div class="total">￥<%=oi.getQuantity() * oi.getGoods().getGoodsPrice() %></div>
</li>
<%
    }
%>
</ul>
</li>
<%
        }
    }
%>
</ul>
</div>
</body>
</html>
