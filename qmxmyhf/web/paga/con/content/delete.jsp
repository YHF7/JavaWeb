<%--
  Created by IntelliJ IDEA.
  User: yhf
  Date: 2018/12/1
  Time: 下午2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
    <style>
        body {
            position: absolute;
            top: 10%;
            left: 17%;
        }
    </style>
<body>
    <%
        PreparedStatement pmst;
        Connection conn;
        ResultSet rs;
        int n = Integer.parseInt(request.getParameter("id"));
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmxmyhf?useUnicode=true&characterEncoding=UTF-8","root","");
            String sql="delete from `qmxmyhf`.`user` where id = ?";
            pmst = conn.prepareStatement(sql);
            pmst.setInt(1, n);
            //执行sql语句
            int flag=pmst.executeUpdate();
            if (flag>0) {
                out.println("删除成功");
                %>
                    <script type="text/javascript">
                        window.self.location=document.referrer;
                    </script>
                <%
            }else {
                out.println("删除失败");
            }
            //清除
            pmst.close();
            conn.close();
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
    %>
    <%--<a href="user.jsp" target="frm">返回</a>--%>
</body>
</html>
