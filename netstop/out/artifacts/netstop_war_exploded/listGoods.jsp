<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.netshop.entity.Goods"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'listGoods.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="css/listGoods.css">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<div id="wrap">
    <div id = "left">精选商品</div>
    <ul id="main">
        <%
            if(request.getAttribute("list") != null)
            {
                List<Goods> list = (List<Goods>)request.getAttribute("list");
                for(int i=0; i<list.size();i++)
                {
                    Goods goods = list.get(i);
        %>
        <li>
            <a href="servlet/GoodsServlet?action=detail&goodsId=<%=goods.getGoodsId() %>">
                <img src="<%=goods.getGoodsImg() %>"width="220" height="220">
            </a>
            <div class="price">￥<%=goods.getGoodsPrice() %></div>
            <div class="title">
                <a href="servlet/GoodsServlet?action=detail&goodsId=<%=goods.getGoodsId() %>">
                </a>
            </div>
        </li>
        <%
                }
            }
        %>
    </ul>
</div>
</body>
</html>
