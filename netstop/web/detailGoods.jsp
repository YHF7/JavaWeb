<%@page import="com.netshop.entity.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'detailGoods.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!-- 将样式文件和JS文件链接进来 -->
    <link rel="stylesheet" type="text/css" href="css/detailGoods.css">
    <script type="text/javascript" src="js/detailGoods.js"></script>
</head>

<body>
<div id="wrap">
    <%
        if(request.getAttribute("goods") != null)
        {
            Goods goods = (Goods)request.getAttribute("goods");
    %>
    <form method="post"
          action="servlet/CartServlet?action=add&goodsId=<%=goods.getGoodsId() %>">
        <div class="photo">
            <img src="<%=goods.getGoodsImg() %>" width="300px" height="300px" />
        </div>
        <div class="text">
            <h3>标题:<%=goods.getGoodsTitle() %></h3>
            <div>商品名称:<%=goods.getGoodsName() %></div>
            <div>品牌:<%=goods.getBrand() %></div>
            <div>库存数量:<%=goods.getQuantity() %></div>
            <div>重量:<%=goods.getWeight() %></div>
            <div>价格:<span class="price">¥<%=goods.getGoodsPrice() %></span></div>
            <ul class="buy">
                <li class="buyNum">
                    <label for="buyNum">购买数量:</label>
                    <input type="text" name="buyNum" id="buyNum" value="1">
                </li>
                <li>
                    <ul>
                        <li>
                            <a href="javascript:void(0)" onclick="modifyNum('+')">+</a>
                        </li>
                        <li class="sub">
                            <a href="javascript:void(0)" onclick="modifyNum('-')">-</a>
                        </li>
                    </ul>
                </li>
                <li class="addCart"><input type="submit" value="立即抢购"></li>
            </ul>
            <div>商品描述：<br/><%=goods.getGoodsDescr().replaceAll("\n", "<br>") %></div>
        </div>
    </form>
    <%
        }
        else
            out.print("该商品不存在！");
    %>
</div>
</body>
</html>








