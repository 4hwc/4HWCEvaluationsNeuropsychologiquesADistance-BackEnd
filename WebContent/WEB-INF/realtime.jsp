<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REAL TIME</title>
</head>
<body>



<script type="text/javascript">

//12h46

var et;
function Actu(){
	var nownow = new Date();

	//var seconds = nownow.getSeconds();
	//console.log(seconds);
	
	//var y = nownow.getYear()+1900;
	//var m = nownow.getMonth()+1;
	//var d= nownow.getDate();
	//var h = nownow.getHours();
	//var mi = nownow.getMinutes();
	//var se  = nownow.getSeconds();
	var millise = nownow.getMilliseconds();
	
	et = millise;
	
	setInterval(Actu,1);
	}
	Actu();
	
	console.log(et);


</script>

</body>
</html>