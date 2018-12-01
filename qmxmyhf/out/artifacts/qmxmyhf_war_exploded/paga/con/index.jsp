<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>YHF操作系统</title>
    
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
	<%
		//requset 获取方法
		//String s = (String)request.getAttribute("us");
		
		//spplication 获取方法
		String s = (String)session.getAttribute("us");

		//spplication 获取方法
		//String s = (String)application.getAttribute("us");
		out.print("欢迎"+s+",登陆"+"<p>");
	%>
	<h1>登陆成功，欢迎来到您的家园</h1>
  </body>
</html>
