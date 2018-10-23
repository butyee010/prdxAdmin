$(document).ready(function() {
	//sessionCheck();
});

var sestimeC;
var intervalSession = null;
var intervalCount = null;


function sessionCheck() {
	$.ajax({
		 url : 'sessionCheck',
		 type : 'POST',
		 async : false,
		 success : function(html) {
			 var isTimeOut = checkSessionTimeOut(html);
			 if (isTimeOut == null || isTimeOut) {
				 goToLoginNow();
			 } else if(isTimeOut != null && !isTimeOut){
				countSession(html);
				return;
			 }else{
				 goToLoginNow();
			 }
		 },
	 });
}

function countSession(html) {
	
	sestimeC = new Number(html.trim());
	 
	 if(intervalSession != null){
		 clearInterval(intervalSession);
	 }
	 
	 intervalSession = setInterval(function() {
		 goToLoginNow();
		 clearInterval(intervalSession);
		 clearInterval(intervalCount);
		 sestimeC = 0;
		 throw new Error();
	 },sestimeC+500);
	 
	 var dateCount = new Date(sestimeC);
	 
//	 $('#sestime').text("Time out : "+pad(dateCount.getMinutes(),2,0)
//			 +" minutes "+pad(dateCount.getSeconds(),2,0)+" seconds");
	 if(intervalCount != null){
		 clearInterval(intervalCount);
	 }
	 intervalCount = setInterval(function() {
		 sestimeC = sestimeC-1000;
		 dateCount = new Date(sestimeC);
//		 if(pad(dateCount.getMinutes(),2,0) <= 2){
//			 $('#sestime').css('color','red');
//		 }else{
//			 $('#sestime').removeAttr("style");
//		 }
//		 $('#sestime').text("Time out : "+pad(dateCount.getMinutes(),2,0)
//				 +" minutes "+pad(dateCount.getSeconds(),2,0)+" seconds");
	 },1000);
	
}

function checkSessionTimeOut(str) {
	return str.trim().toUpperCase() === "TIMEOUT";
}

function goToLoginNow() {
	
	var isLoginOAuth = false;
	if($("#isLoginOAuth").text() == 'true'){
		isLoginOAuth = true;
	}
	
	$.ajax({
		url : 'logout',
		type : 'POST',
		async : false,
		success : function(html) {
			if(isLoginOAuth){
				window.location.href = 'sessionTimeOut?isLoginOAuth='+isLoginOAuth;
			}else{
				window.location.href = 'sessionTimeOut';
			}
		}
	});
}


function pad(n, width, z) {
	  z = z || '0';
	  n = n + '';
	  return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
}