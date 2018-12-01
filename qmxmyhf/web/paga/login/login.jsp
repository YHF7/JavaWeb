<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>YHF操作系统登录</title>
      <link rel="icon" href="paga/img/favicon.ico">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="paga/css/login.css">
  </head>
  
  <body>
	<div class="log">
        <!-- 左 -->
        <div class="left">
            <h1>欢迎登录</h1>
            <span>YHF管理系统 v1.0</span>
        </div>
        <!-- 右 -->
        <div class="right">
            <form action="paga/login/re.jsp" method="post">
                <h1>用户登录</h1>
                用户名: <input type="text" name="username" class="txt">
                <p>
                    密&nbsp;&nbsp;&nbsp;&nbsp;码 <input type="password" name="password" class="txt">
                    <p>
                        <input type="submit" value="登陆" class="btn bt1">
                        <%--<input type="reset" value="注册" class="btn">--%>
                        <a href="paga/register/register.jsp" class="btn bt2">注册</a>
            </form>
        </div>
    </div>
  </body>
</html>
