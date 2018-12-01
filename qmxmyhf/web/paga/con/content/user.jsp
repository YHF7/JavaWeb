<%--
  Created by IntelliJ IDEA.
  User: yhf
  Date: 2018/11/30
  Time: 下午3:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Title</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../../css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../../css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../js/ie-emulation-modes-warning.js"></script>
</head>
<body>
<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-top:-20px;">
          <h1 class="page-header">超级管理员</h1>
          <div class="row placeholders">
            <%
              Connection con=null;//一条公路的名字
              Statement sts=null;//执行sql命名的类
              ResultSet rs=null;//装结果的容器
              String n=request.getParameter("username");
              String p=request.getParameter("userpwd");
              try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmxmyhf","root","");
                String sql="select * from user";
                sts=con.createStatement();
                rs=sts.executeQuery(sql);
                while(rs.next()) {
                    if(rs.getString(4).equals("超级管理员")) {
            %>
              <div class="col-xs-6 col-sm-3 placeholder">
                <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
                <h4><%=rs.getString(2)%></h4>
                <span class="text-muted"><%=rs.getString(4)%></span>
              </div>
            <%
                  }
                }
              rs.close();
              sts.close();
              con.close();
            }
                  catch(Exception e){
                out.println(e.getMessage());
              }

            %>
          </div>

          <h2 class="sub-header">用户列表</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>id</th>
                  <th>用户名</th>
                  <th>用户密码</th>
                  <th>管理员</th>
                    <th>注册时间</th>
                    <th>用户年龄</th>
                    <th>用户性别</th>
                  <th>设置</th>
                </tr>
              </thead>
              <tbody>
                  <%
                    try{
                      Class.forName("com.mysql.jdbc.Driver");
                      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmxmyhf","root","");
                      String sql="select * from user";
                      sts=con.createStatement();
                      rs=sts.executeQuery(sql);
                      while(rs.next()) {
                  %>
                  <tr>
                    <td><%=rs.getString(1)%></td>
                    <td><%=rs.getString(2)%></td>
                    <td><%=rs.getString(3)%></td>
                    <td><%=rs.getString(4)%></td>
                      <td><%=rs.getString(5)%></td>
                      <td><%=rs.getString(6)%></td>
                      <td><%=rs.getString(7)%></td>
                    <td>
                      <%--<a href="page2.jsp?id=<%=rs.getString(1)%>">删除</a>--%>
                      <%--<a href="page3.jsp?id=<%=rs.getString(1)%>">修改</a>--%>
                        <a href="update.jsp?id=<%=rs.getString(1)%>">修改</a>
                          <a href="delete.jsp?id=<%=rs.getString(1)%>">删除</a>
                    </td>
                  </tr>
                  <%}
                    rs.close();
                    sts.close();
                    con.close();
                  }
                  catch(Exception e){
                    out.println(e.getMessage());
                  }

                  %>
              </tbody>
            </table>
          </div>
        </div>
</body>
<script src="../../js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../../js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../js/ie10-viewport-bug-workaround.js"></script>
</html>
