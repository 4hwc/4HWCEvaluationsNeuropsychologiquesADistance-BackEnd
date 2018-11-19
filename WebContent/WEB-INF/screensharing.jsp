<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Screen sharing example</title>
</head>
<body>

    <p align="center"><input type="button" id="share_screen" value="Share screen"/></p>
	<p align="center"><video src="" id="video" autoplay></video></p>
	
	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	
	<script src="<c:url value="/inc/adapter-master/release/adapter.js"/>"></script>
	
	
	
	<script type="text/javascript">
	
	
	
     	//navigator.getUserMedia = navigator.webkitGetUserMedia || navigator.getUserMedia ||navigator.mozGetUserMedia;
     	$('#share_screen').click(function() {
          	navigator.getUserMedia({
                   	audio: false,
                   	video: {
                       	mandatory: {
                           	chromeMediaSource: 'screen',
                           	maxWidth: 1280,
                           	maxHeight: 720
                       	},
                       	optional: []
                   	}
               	}, function(stream) {
                   	document.getElementById('video').src = window.URL.createObjectURL(stream);;
                   	$('#share_screen').hide();
               	}, function() {
                   	alert('Error, my friend. Screen stream is not available. Try in latest Chrome with Screen sharing enabled in about:flags.');
                 	}
          	)
     	})
	</script>




</body>
</html>