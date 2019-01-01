<%@page import="com.netshop.entity.User"%>
<%@page import="com.netshop.entity.Goodstype"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>My JSP 'index.jsp' starting page</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" type="text/css" href="css/index.css">
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
      $(document).ready(function(e) {
          $("#main .left ul li").mouseover(function(){
              $(this).children("ul:first").toggleClass("hidden");
          });
          $("#main .left ul li").mouseout(function(){
              $(this).children("ul:first").toggleClass("hidden");
          });
      });
  </script>
</head>

<body>
<div id="banner">
  <div class="menu">北京 你好，请登录  免费注册 我的订单 我的京东 京东会员 企业采购 客户服务 网站导航 手机京东</div>
</div>
<div id="logo">
  <h1></h1>
  <div class="search">
    <h2>秒杀 优惠券 闪购 拍卖 京东服饰 京东超市 生鲜 全球购 京东金融</h2>
  </div>
</div>
<div id="main">
  <div class="left">
    <ul>
      <li>
        <div>手机/运营商/数码</div>
        <ul class="hidden">
          <li>
            <h1>家用电器 > </h1>
            <div>| 电饭煲 | 微波炉 | 电烤箱 | 电磁炉 | 电陶炉 | 电压力锅 | 空气炸锅 | 豆浆机 </div>
          </li>
        </ul>
      </li>
      <%
        if(request.getAttribute("list") != null)
        {
          List<Goodstype> list = (List<Goodstype>)request.getAttribute("list");
          for(int i=0; i<list.size(); i++)
          {
            Goodstype goodstype = list.get(i);	//获取某个一级商品类型
      %>
      <li>
        <div><%=goodstype.getTypeName() %></div>
        <ul class="hidden">
          <%
            List<Goodstype> second = goodstype.getSubTypes();	//二级商品类型
            for(int j=0; j<second.size(); j++)
            {
              Goodstype sGoodstype = second.get(j);	//某二级类型
          %>
          <li>
            <h1><a href="servlet/GoodsServlet?action=list&typeId=<%=sGoodstype.getTypeId() %>"><%=sGoodstype.getTypeName() %></a> ></h1>
            <div>
              <%
                List<Goodstype> third = sGoodstype.getSubTypes();	//三级类型
                for(int k=0; k<third.size(); k++)
                {
                  Goodstype tGoodstype = third.get(k);
                  String str = String.format(" | <a href='servlet/GoodsServlet?action=list&typeId=%d'>%s</a>",
                          tGoodstype.getTypeId(), tGoodstype.getTypeName());
                  out.print(str);
                  //out.print(" | <a href='GoodsServlet?action=list&typeId='" + tGoodstype.getTypeId() + ">" + tGoodstype.getTypeName() + "</a>");
                }
              %>
            </div>
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
  <div class="middle">
    <img src="pics/sgsy.jpg" width="590" height="340" alt="">
    <div class="marRight10">
      <img src="pics/jdqqs.png" width="390" height="130" alt="">
    </div>
    <div>
      <img src="pics/shdq.jpg" width="390" height="130" alt="">
    </div>
  </div>
  <div class="right">
    <%
      //如果用户没登录，就显示登录框；如果已登录，就显示用户名
      if(session.getAttribute("user") == null)	//未登录
      {
    %>
    <form method="post" action="servlet/UserServlet?action=login">
      <table width="100%" border="0" cellspacing="0" cellpadding="6">
        <tr>
          <td width="50" align="right">用户名</td>
          <td align="left">
            <input name="userName" type="text" id="userName" size="15" maxlength="15"></td>
        </tr>
        <tr>
          <td align="right">密码</td>
          <td align="left">
            <input name="userPwd" type="text" id="userPwd" size="15" maxlength="20"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><input type="submit" name="tj" id="tj" value="登录">
            <input type="reset" name="cz" id="cz" value="重置">
          </td>
        </tr>
      </table>
    </form>
    <%
    }
    else
    {
    %>
    <div>欢迎你，<a href="#"><%=((User)session.getAttribute("user")).getUserName() %></a></div>
    <div><a href="servlet/OrderServlet?action=list">我的订单</a></div>
    <div><a href="servlet/UserServlet?action=logout">退出登录</a></div>
    <%
      }
    %>
  </div>
</div>
</body>
</html>
