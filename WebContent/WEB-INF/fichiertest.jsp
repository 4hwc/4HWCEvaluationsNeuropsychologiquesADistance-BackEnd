<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FILE TEST</title>

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet" />
</head>
<body>

<a class="btn btn-success"  onclick="htmlexecute();">Generate  
        Screenshot »</a> 
        
        <br>

<a class="btn btn-primary"  onclick="htmlexecute();">Generate  
        Screenshot »</a> 
        
        <br>
        
        <a class="btn btn-warning"  onclick="htmlexecute();">Generate  
        Screenshot »</a> 
        
        <br>
        
        <div id="testdiv"></div>



<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<script src="<c:url value="/inc/html2canvas/html2canvas.js"/>"></script>


<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>





<script type="text/javascript">


  
$(document).ready(function() {
	//var testdiv = document.getElementById("testdiv");
	 var a =   html2canvas($(document.body), {
	        onrendered: function(canvas) {
	            // canvas is the final rendered <canvas> element
	            var dataURL = canvas.toDataURL("image/png");
	            //window.open(myImage);
	            //alert(typeof myImage);
	            
	            //var x = document.createElement("INPUT");
	            //x.setAttribute("type", "file");
	            //document.body.appendChild(x);
	            
	            //alert(typeof x);
	            
	            var imageObj = new Image();
	            
	            
	            
	            imageObj.src = dataURL;
	            
	            document.body.appendChild(imageObj);
	         
	        }
	    });
	});
  
  
</script>








</body>
</html>