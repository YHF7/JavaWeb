<%--
  Created by IntelliJ IDEA.
  User: yhf
  Date: 2018/12/1
  Time: 下午9:57
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Title</title>
</head>
<body>
<%
    PreparedStatement pmst;
    Connection conn;
    ResultSet rs;
    request.setCharacterEncoding("UTF-8");
    String uName=request.getParameter("uName");
    String uPwd=request.getParameter("uPwd");
    String sex=request.getParameter("sex");
    int age = Integer.parseInt(request.getParameter("age"));
    int id = Integer.parseInt(request.getParameter("id"));
    String uYh=request.getParameter("uYh");

    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmxmyhf?useUnicode=true&characterEncoding=UTF-8","root","");
        String sql="update `qmxmyhf`.`user` set `uPwd`=?, `uYh`=?, `age`=?, `sex`=?, `uName`=? where `id`=?";
        pmst = conn.prepareStatement(sql);
        //为占位符传值
        pmst.setString(1, uPwd);
        pmst.setString(2, uYh);
        pmst.setInt(3, age);
        pmst.setString(4, sex);
        pmst.setString(5,uName);
        pmst.setInt(6,id);
        //执行sql语句
        int flag=pmst.executeUpdate();
//        if (flag>0) {
//            out.println("修改用户资料成功");
//        }
        %>
        <script type="text/javascript">
            window.self.location=document.referrer;
        </script>
        <%
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
