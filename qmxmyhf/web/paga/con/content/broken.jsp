<%--
  Created by IntelliJ IDEA.
  User: yhf
  Date: 2018/11/30
  Time: 下午11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 style="text-align: center;margin-top: 3%;font-size: 40px;">新增用户折线图</h1>
    <%
        Connection con=null;//一条公路的名字
        Statement sts=null;//执行sql命名的类
        ResultSet rs=null;//装结果的容器
        request.setCharacterEncoding("UTF-8");
        %>
            <script type="text/javascript">
                var data2 = "";
            </script>
        <%
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/qmxmyhf?useUnicode=true&characterEncoding=UTF-8","root","");
            String sql="select time from user";
            sts=con.createStatement();
            rs=sts.executeQuery(sql);
            while(rs.next()) {
                %>
                    <script type="text/javascript">
                        data2 += '<%=rs.getString(1)%>' + ",";
                    </script>
                <%
            }
        }
        catch(Exception e){
            out.println(e.getMessage());
        }
        rs.close();
        sts.close();
        con.close();
    %>
    <div id="main" style="width: 1300px;height:500px;margin-left: 17%;"></div>
</body>
<script type="text/javascript" src="../../js/echarts.common.min.js"></script>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));


    GetDateStr = function(AddDayCount) {
        var dd = new Date();
        dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期
        var y = dd.getFullYear();
        var m = dd.getMonth()+1;//获取当前月份的日期
        if (m<10) {
            m = "0" + m;
        }
        var d = dd.getDate();
        if (d<10) {
            d= "0" +d;
        }
        return y+"-"+m+"-"+d;
    }

    let data1 = [GetDateStr(-6),GetDateStr(-5),GetDateStr(-4),GetDateStr(-3),GetDateStr(-2),GetDateStr(-1),GetDateStr(0)];
    var arr = data2.split(',');
    
    let data3 = [];
    for (var i = 0; i < data1.length; i++) {
        let a = 0;
        for (var j = 0; j < arr.length; j++) {
            if (data1[i] == arr[j]) {
                a++;
            }
        }
        data3[i] = a;
    }



    var option = {
        xAxis: {
            type: 'category',
            data: data1
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: data3,
            type: 'line'
        }]
    };
    myChart.setOption(option);

</script>
</html>
