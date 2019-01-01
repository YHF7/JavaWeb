<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manageGoodstype.jsp' starting page</title>
    
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
    管理商品类型：<br>
    <a href="servlet/GoodstypeServler?action=goAdd">添加商品类型</a><br>
    <a href="servlet/GoodstypeServler?action=goModify">修改商品类型</a><br>
    <a href="servlet/GoodstypeServler?action=goDelete">删除商品类型</a><br>
    <a href="servlet/GoodstypeServler?action=goSelect">查看商品类型</a><br>
  </body>
</html>
