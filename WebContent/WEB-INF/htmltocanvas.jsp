<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
<title>HTML TO CANVAS</title>
</head>
<body>

<a class="btn btn-success" href="javascript:void(0);" onclick="htmlexecute();">Generate  
        Screenshot »</a> 





<script type="text/javascript">

function htmlexecute() {
	
	html2canvas(document.body, {
		  onrendered: function(canvas) {
		    document.body.appendChild(canvas);
		  },
		  
		  useCORS:false
		});
  	
  		
  }
  
  
</script>

<script src="<c:url value="/inc/html2canvas.js"/>"></script>

<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>



</body>
</html>