function f(pageNome,pageTotal){
	
	var first=document.getElementById("first");
	var prev=document.getElementById("prev");
	var next=document.getElementById("next");
	var end=document.getElementById("end");
	
	
	if(pageNome==1){
		
		first.href="javascript:void(0);";
		prev.href="javascript:void(0);";
		first.className="gray";
		prev.className="gray";
		
		
	}
	if(pageNome==pageTotal){
		
		end.href="javascript:void(0);";
		next.href="javascript:void(0);";
		end.className="gray";
		next.className="gray";
		
		
	}
}
var interval;

function startSecond() {

	interval = window.setInterval("changeSecond()", 1000);

};

function changeSecond() {
	var second = document.getElementById("second");

	var svalue = second.innerHTML;

	svalue = svalue - 1;

	if (svalue == 0) {
		window.clearInterval(interval);
		location.href = "/BookStore/MainServlet";
		return;
	}

	second.innerHTML = svalue;
}







