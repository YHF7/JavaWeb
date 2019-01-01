function ajaxText(method, url, data, fun){
    //1.创建对象
    var oAjax = null;
    if(window.XMLHttpRequest){
        oAjax = new XMLHttpRequest();
    }else{
        oAjax = new ActiveXObject("Microsoft.XMLHTTP");
    }
      
    //2.连接服务器  
    //oAjax.open('GET', "http://localhost:8080/loginCheck.jsp?uName=lisi&uPwd=123", true);   //open(方法, url, 是否异步)
    oAjax.open(method, url, true);   //open(方法, url, 是否异步)
      
    //3.发送请求  
    oAjax.send(data);
      
    //4.接收返回
    oAjax.onreadystatechange = function(){  //OnReadyStateChange事件
        if(oAjax.readyState == 4){  //4为完成
            if(oAjax.status == 200){    //200为成功
                //alert(oAjax.responseText); 
            	fun(oAjax.responseText);
            }else{
                alert("异步提交失败！");
            }
        }
    };
}

function setSecondType(responseText)
{
	//alert('(' + responseText + ')');
	var jsonArray = eval('(' + responseText + ')');	//将异步返回的字符串，解析成json对象数组
	var secondType = document.getElementById("secondType");
	secondType.options.length = 0; 	//清空
	for(var i=0; i<jsonArray.length; i++)
	{
		//新下拉选项 =	new Option(文本，						值)
		var newOp = new Option(jsonArray[i].typeName, jsonArray[i].typeId);
		try
		{
			secondType.options.add(newOp, null);
		}
		catch(ex)
		{
			secondType.options.add(newOp);		//ie
		}
		
	}
}
