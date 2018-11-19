<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>COUNT DOWN CLOCK</title>

<!--  <link href="<c:url value="/inc/style.css"/>" rel="stylesheet" /> -->



<style type="text/css">

body{

/*background: linear-gradient(to bottom, #ffcc66 0%, #00ffcc 100%);*/




    background: linear-gradient(to bottom, #ffcc66 0%, #00ffcc 100%);
    color:#fff;
    


}

.countdownContainer{

position:absolute;

top:50%;

left:50%;

transform:translateX(-50%) translateY(-50%);

text-align:center;

background:transparent;



padding:10px;



}

.info{

font-size:100px;
}

</style>
</head>
<body>

      <table class="countdownContainer">
      
            <tr class="info">
            
                 <td colspan="4" > ENAD DEADLINE</td>
            
            </tr>
            
            <tr class="info">
            
               <td id="days">120</td>
               
               <td id="hours">4</td>
               
               <td id="minutes">12</td>
               
               <td id="seconds">22</td>
            
            
            </tr>
            
            <tr>
                   
                   <td >Days</td>
               
               <td >Hours</td>
               
               <td >Minutes</td>
               
               <td >Seconds</td>
            
                 
            
            </tr>
      
      
      </table>
      
      <script type="text/javascript">
      
         function countdown(){
        	 
        	 var now = new Date();
        	 
        	 var eventDate = new Date(2017,0,23);
        	 
        	 var currentTime = now.getTime();
        	 
        	 var eventTime = eventDate.getTime();
        	 
        	 var remTime = eventTime - currentTime;
        	 
        	 var s = Math.floor(remTime/1000);
        	 
        	 var m = Math.floor(s/60);
        	 
        	 var h = Math.floor(m/60);
        	 
        	 var d = Math.floor(h/24);
        	 
        	 h%=24;
        	 
        	 m%=60;
        	 
        	 s%=60;
        	 
        	 h=(h<10) ? "0"+h : h;
      	   
      	   m=(m<10) ? "0"+m : m;
      	   
      	   s=(s<10) ? "0"+s : s;
      	   
      	 document.getElementById("days").innerText = d;
  	   
  	   document.getElementById("days").textContent = d;
  	   
  	 document.getElementById("hours").innerText = h;
	   
	   document.getElementById("hours").textContent = h;
	   
document.getElementById("minutes").innerText = m;
  	   
  	   document.getElementById("minutes").textContent = m;
  	   
  	 document.getElementById("seconds").innerText = s;
	   
	   document.getElementById("seconds").textContent = s;
	   
	   setTimeout(countdown,1000);
        	 
        	
         }
         
         countdown();
      
      
      
      </script>

</body>
</html>