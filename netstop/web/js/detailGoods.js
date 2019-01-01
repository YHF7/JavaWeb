//修改购买数量
function modifyNum(op)
{
	var buyNum = document.getElementById("buyNum");	//购买数量文本框
	var num = buyNum.value;	//购买数量
	if(op == "+")
	{
		num++;
		if(num > 999)
			num--;
	}
	else if(op == "-")
	{
		num--;
		if(num < 1)
			num++;
	}
	buyNum.value = num;	//更新数量
}

