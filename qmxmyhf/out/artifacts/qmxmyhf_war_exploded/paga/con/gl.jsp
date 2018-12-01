<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0042)https://v3.bootcss.com/examples/dashboard/ -->
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../img/favicon.ico">

    <title>YHF管理系统主页</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="../css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/gl.css">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="gl.jsp"><img src="../img/logo3.png" style="width:35px;float:left;margin-top:-5px;margin-left:10px;">YHF管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="gl.jsp">欢迎您,<span style="color:red;"><%=session.getAttribute("username")%></span></a></li>
            <li><a href="../login/login.jsp">退出登录</a></li>
            <li><a href="##">Profile</a></li>
            <li><a href="##">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar qh">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="content/user.jsp" target="frm">用户管理 <span class="sr-only">(current)</span></a></li>
            <li><a href="content/broken.jsp" target="frm">新增用户图表</a></li>
            <li><a href="#">aaaaaaa</a></li>
            <li><a href="##">Export</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="#">Nav item</a></li>
            <li><a href="#">Nav item again</a></li>
            <li><a href="#">One more nav</a></li>
            <li><a href="#">Another nav item</a></li>
            <li><a href="#">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="#">Nav item again</a></li>
            <li><a href="#">One more nav</a></li>
            <li><a href="#">Another nav item</a></li>
          </ul>
        </div>
        <div class="con">
            <iframe class="iframe" name="frm" src="content/user.jsp"></iframe>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../js/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../js/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../js/ie10-viewport-bug-workaround.js"></script>
  
    <script type="text/javascript" src="../js/gl.js"></script>
</body></html>