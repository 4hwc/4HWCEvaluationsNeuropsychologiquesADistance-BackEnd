<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GET USER MEDIA</title>
</head>
<body>

    
	<p align="center"><video src="" id="video" autoplay></video></p>
	
	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	
	<script src="<c:url value="/inc/adapter-master/release/adapter.js"/>"></script>
	
	
	
	<script type="text/javascript">
	
	var constraints = {video:true};
	
	function successCallback(stream){
		
		var video = document.querySelector("video");
		
		video.src = window.URL.createObjectURL(stream);
	}
	
	
	function errorCallback(error){
		
		console.log("navigator.getUserMedia error :"+error);
		
	}
	
	
	navigator.getUserMedia(constraints,successCallback,errorCallback);
     	
	</script>



    

</body>
</html>