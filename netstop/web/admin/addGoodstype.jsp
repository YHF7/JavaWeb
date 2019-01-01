<%@ page import="com.netshop.entity.Goodstype"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addGoodstype.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/admin.js"></script>
	<script type="text/javascript">
		function firstChange()
		{
			var firstValue = document.getElementById("firstType").value;
			if(firstValue>0)
			{
				var method = "GET";
				var url = "<%=basePath %>servlet/GoodstypeServlet?action=listSub&parentId=" + firstValue;
				var data = null;
				var fun = setSecondType;			//指定异步返回数据的处理函数
				ajaxText(method, url, data, fun);	//调用异步函数
			}
			else if(firstValue==0)
			{
				setSecondType("[{'typeId':'0', 'typeName':'请选择'}]");
			}
		}
	</script>

  </head>
  
  <body>
  <%
  		if(request.getAttribute("msg") != null)
  		{
  			out.print("<div style='color:#F00'>" + request.getAttribute("msg") + "</div>");
  		}
  %>
  <p>商品类型添加： </p>
  /*
  <br>* 一级、二级都是"请选择"，则添加的是一级；
  <br>*只有二级是"请选择"，则添加的是二级类型；
  <br>*一级、二级都选择了，则添加的是三级类型
  <br>*一次可以添加多个类型，输入时每个类型占一行
  <br>*/
    <form name="form1" method="post" action="servlet/GoodstypeServlet?action=add">
     	一级类型：
		<select name="firstType" id="firstType" onChange="firstChange()">
		  <option value="0">请选择</option>
		  <%
		  		if(request.getAttribute("list") != null)
		  		{
		  			List<Goodstype> list = (List<Goodstype>)request.getAttribute("list");
		  			for(int i=0; i<list.size(); i++)
		  			{
		  				Goodstype goodstype = list.get(i);
		  %>
		  <option value="<%=goodstype.getTypeId() %>"><%=goodstype.getTypeName() %></option>
		  <%		  
		  			}
		  		}
		  %>
		</select><br>
        二级类型：
        <select name="secondType" id="secondType">
          <option value="0">请选择</option>
          </select><br>
        输入类型：<br>
        <textarea name="newType" id="newType" cols="30" rows="25"></textarea><br>
        <input type="submit" name="addType" id="addType" value="添加">
    </form>   
  </body>
</html>
