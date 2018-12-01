let dv = document.querySelector(".qh");
let li = dv.querySelectorAll("li");

var abc = 0;
for (var i = 0; i < li.length; i++) {
	li[i].num = i;
	li[i].onclick = function () {
        li[abc].className = "";
		this.className = "active";
		abc = this.num;
	}
}