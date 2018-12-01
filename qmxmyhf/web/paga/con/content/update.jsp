<%--
  Created by IntelliJ IDEA.
  User: yhf
  Date: 2018/12/1
  Time: 下午4:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="../../css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="../../css/update.css">
    <title>Title</title>
</head>
<body>
<%
    Connection con=null;//一条公路的名字
    Statement sts=null;//执行sql命名的类
    ResultSet rs=null;//装结果的容器
    int n = Integer.parseInt(request.getParameter("id"));
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmxmyhf?useUnicode=true&characterEncoding=UTF-8","root","");
        sts=con.createStatement();
        String sql="select * from `qmxmyhf`.`user` where id ="+n;
        rs=sts.executeQuery(sql);
        rs.next();
%>
<div class="update-con">
    <h2>修改用户资料</h2>
    <form class="form-horizontal" action="update2.jsp" method="post">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">用户ID:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="disabledInput" name="id" value="<%=rs.getString(1)%>" readonly>
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">用户名:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" name="uName" value="<%=rs.getString(2)%>">
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">用户密码:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" name="uPwd" value="<%=rs.getString(3)%>">
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">管理员:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" name="uYh" value="<%=rs.getString(4)%>">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">注册时间:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword3" name="time" value="<%=rs.getString(5)%>" disabled>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">用户年龄:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword3" name="age" value="<%=rs.getString(6)%>">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">用户性别:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword3" name="sex" value="<%=rs.getString(7)%>"
            </div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10 add">
                <button type="submit" class="btn btn-default">保存</button>
            </div>
            <a href="user.jsp" target="frm" class="btn btn-default"><span>返回</span></a>
        </div>

    </form>
</div>
<%
        //清除
        sts.close();
        rs.close();
        con.close();
    }
    catch(Exception e){
        out.println(e.getMessage());
    }
%>

</body>
</html>
