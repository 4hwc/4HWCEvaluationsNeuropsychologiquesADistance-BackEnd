<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="responsecontainer">
</div>



<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<script>
 $(document).ready(function() {
 	 $("#responsecontainer").load('/enad/refresh', function() {
 		  alert( "Load was performed." );
 	});
   var refreshId = setInterval(function() {
      $("#responsecontainer").load('/enad/refresh', function() {
    	  alert( "Load was performed." );
      });
   }, 10000000);
   $.ajaxSetup({ cache: false });
});
</script>

</body>
</html>