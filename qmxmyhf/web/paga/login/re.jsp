<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 're.jsp' starting page</title>
    
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
	    <%--<%--%>
		<%--String username = request.getParameter("username");--%>
		<%--String password = request.getParameter("password");--%>
     		<%--if(username.equals("yhf")&&password.equals("yhf")){--%>
				<%--//session设置方法 只可以用在指令--%>
				<%--session.setAttribute("us",username);--%>

				<%--//request设置方法 只可以用在指令--%>
				<%--//request.setAttribute("us",username);--%>


				<%--//applicationp设置数据方法--%>
				<%--//application.setAttribute("us",username);//保留用户名--%>
				<%--//response.setHeader("Refresh",".1;url=index.jsp");--%>
				<%--response.sendRedirect("paga/gl.jsp");--%>
     		<%--}else {--%>
				<%--/* out.print("登陆失败,请重新输入账号或密码"); */--%>
				<%--response.setHeader("Refresh",".1;url=login.jsp");--%>
				<%--}--%>
	<%--%>--%>
		<%
			Connection con=null;//一条公路的名字
			Statement sts=null;//执行sql命名的类
			ResultSet rs=null;//装结果的容器
			request.setCharacterEncoding("UTF-8");
			String n=request.getParameter("username");
			String p=request.getParameter("password");
			try{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmxmyhf?useUnicode=true&characterEncoding=UTF-8","root","");
				String sql="select * from user where uName='"+n+"' and uPwd='"+p+"'";
				sts=con.createStatement();
				rs=sts.executeQuery(sql);
				if(rs.next()) {
					session.setAttribute("username",n);
					response.sendRedirect("../con/gl.jsp");
				}
				else
					response.sendRedirect("login.jsp");
			}
			catch(Exception e){
				out.println(e.getMessage());
			}
			rs.close();
			sts.close();
			con.close();
		%>
  </body>
</html>
