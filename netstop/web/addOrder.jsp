<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.netshop.entity.Deliveryinfo" %>
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
<div style="width: 1024px;margin: 0 auto; border: 1px solid #ccc;">
    <form action="servlet/OrderServlet?action=add" id="form1" method="post">
        确认订单：
        <table width="900px" border="0" cellspacing="3">
            <%
                if (request.getAttribute("list") != null) {

                    List<Deliveryinfo> list = (List<Deliveryinfo>)request.getAttribute("list");
                    for (int i=0;i<list.size();i++) {
                        Deliveryinfo di = list.get(i);

            %>
            <tr>
                <td width="30" align="center">
                    <input type="radio" name="diId" value="<%=di.getDiId()%>" <%=di.getIsDefault()==1%>>
                </td>
                <td width="100"><%=di.getReceiver()%></td>
                <td width="100"><%=di.getPhoneNum()%></td>
                <td><%=di.getAddress()%></td>
                <td width="100"><%=di.getPostcode()%></td>
                <td width="100"><a href="#">编辑</a>/<a href="#">删除</a></td>
            </tr>
            <%
                    }
                }
            %>
            <tr>
                <td align="center">新增</td>
                <td>收货人</td>
                <td>手机号</td>
                <td>收货地址</td>
                <td>邮编</td>
                <td>是否默认</td>
            </tr>
            <tr>
                <td align="center"><input type="radio" name="diId" value="0"></td>
                <td><input type="text" name="receiver" id="receiver" size="10" maxlength="20"></td>
                <td><input type="text" name="phoneNum" id="phoneNum" size="10" maxlength="20"></td>
                <td><input type="text" name="address" id="address" size="50" maxlength="200"></td>
                <td><input type="text" name="postcode" id="postcode" size="10" maxlength="10"></td>
                <td><input type="checkbox" name="rcheckbox" id="isDefault" value="1">设为默认</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>商品列表</td>
                <td>总金额</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>
                    <%
                        if (request.getAttribute("goodsTitleList") != null) {
                            ArrayList<String> list = (ArrayList<String>)request.getAttribute("goodsTitleList");
                            for (int i=0;i<list.size();i++) {
                                out.print(list.get(i)+"<br>");
                            }
                        } else {
                            out.print("&nbsp;");
                        }
                    %>
                </td>
                <td>
                    ¥
                    <%
                        if (request.getAttribute("total") != null) {
                            double total = (Double)request.getAttribute("total");
                            out.print(total);
                        }else {
                            out.print("0.0");
                        }
                    %>
                </td>
                <td>
                    <input type="submit" value="确认订单" name="qrdd" id="qrdd">
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>