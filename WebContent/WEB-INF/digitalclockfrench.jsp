<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DIGITAL CLOCK FRENCH</title>

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet" />

<style type="text/css">

body{

background: linear-gradient(to bottom, #33ccff 0%, #0066ff 100%);

}

.clock{

position:absolute;

font-family:'agencyfb';

top:50%;

left:50%;

transform:translateX(-50%) translateY(-50%);

color:#fff;

font-size:100px;

border: 0px solid #ccc;

padding: 0px 5px 0px 5px;

}

</style>
</head>
<body>

   <div id="MyClockDisplay" class="clock"></div>
   
   <script type="text/javascript">
   
   function showTime(){
	   
	   var date = new Date();
	   
	   var h = date.getHours();//0-23
	   
	   var m = date.getMinutes(); //0-59
	   
	   var s = date.getSeconds(); //0-59
	   
	   
	   
	   h=(h<10) ? "0"+h : h;
	   
	   m=(m<10) ? "0"+m : m;
	   
	   s=(s<10) ? "0"+s : s;
	   
	   var time = h+":"+m+":"+s;
	   
	   document.getElementById("MyClockDisplay").innerText = time;
	   
	   document.getElementById("MyClockDisplay").textContent = time;
	   
	   setTimeout(showTime,1000);
   }
   
   showTime();
   
   
   
   
   
   </script>

</body>
</html>