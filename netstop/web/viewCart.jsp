<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.netshop.entity.CartItem"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'viewCart.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<div style="widht:1030; margin:0 auto;">
    <p>购物车界面：</p>   <!-- 去DeliveryinfoServlet查询收货地址列表 -->
    <form id="form1" method="post" action="servlet/DeliveryinfoServlet?action=list">
        <table width=""1024 border="1" cellpadding="3" cellpacing="0">
            <tr>
                <td width="50">编号</td>
                <td width="160">商品预览</td>
                <td>商品标题</td>
                <td width="50">价格</td>
                <td width="100">数量</td>
                <td width="50">金额</td>
                <td width="100">收藏<br>删除</td>
            </tr>
            <%
                double total = 0.0;
                if(request.getAttribute("total") !=null)
                    total = (Double)request.getAttribute("total");
                if(request.getAttribute("list") != null)
                {
                    List<CartItem> list = (List<CartItem>)request.getAttribute("list");
                    for(int i=0; i<list.size(); i++)
                    {
                        CartItem ci = list.get(i);
            %>
            <tr>
                <td><%=ci.getGoods().getGoodsId() %></td>
                <td><img src="<%=ci.getGoods().getGoodsImg() %>" width="160" height="160" /></td>
                <td><%=ci.getGoods().getGoodsTitle() %></td>
                <td>￥<%=ci.getGoods().getGoodsPrice()%></td>
                <td><%=ci.getQuantity() %></td>
                <td>￥<%=ci.getTotal()%></td>
                <td>收藏<br>删除</td>
            </tr>
            <%
                    }
                }
            %>
            <tr>
                <td colspan="6" align="right">总计：￥<%=total %></td>
                <td><input type="submit" value="提交订单" /></td>
            </tr>

        </table>
    </form>
</div>
</body>
</html>
