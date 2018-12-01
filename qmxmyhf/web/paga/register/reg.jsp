<%--
  Created by IntelliJ IDEA.
  User: yhf
  Date: 2018/11/30
  Time: 上午10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,java.text.SimpleDateFormat,java.util.Date,java.util.Calendar,java.util.GregorianCalendar" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>YHF操作系统注册</title>

</head>
<body>
    <%
        PreparedStatement pmst;
        Connection conn;
        ResultSet rs;
        request.setCharacterEncoding("UTF-8");
        String uName=request.getParameter("username");
        String uPwd=request.getParameter("password");

        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        Date dd = calendar.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String t1 = df.format(dd);

        if (uName==""||uPwd=="") {
            response.sendRedirect("register.jsp");
            return;
        }
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmxmyhf?useUnicode=true&characterEncoding=UTF-8","root","");
            String sql="insert into `qmxmyhf`.`user` ( `uName`, `uPwd`,`uYh`,`time`,`age`,`sex`) values ( ?, ?,?,?,?,?)";
            pmst = conn.prepareStatement(sql);
            //为占位符传值
            pmst.setString(1, uName);
            pmst.setString(2, uPwd);
            pmst.setString(3, "管理员");
            pmst.setString(4, t1);
            pmst.setInt(5, 18);
            pmst.setString(6, "男");
            //执行sql语句
            int flag=pmst.executeUpdate();
            if (flag>0) {
                out.println("添加用户成功");
                response.sendRedirect("../login/login.jsp");
            }
            //清除
            pmst.close();
            conn.close();
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    %>
</body>
</html>
