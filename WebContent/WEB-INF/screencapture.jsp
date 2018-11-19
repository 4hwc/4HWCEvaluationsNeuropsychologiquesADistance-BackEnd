<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SCREEN CAPTURE</title>
</head>
<body>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	
	<script src="<c:url value="/inc/adapter-master/release/adapter.js"/>"></script>
	


<script type="text/javascript">

/**
 * 
//success callback when requesting audio input stream

 function gotStream(stream){
 	
 	var audioContext = new webkitAudioContext();
 	
 	//Create an audionode from the stream
 	
 	var mediaStreamSource = audioContext.createMediaStreamSource(stream);
 	
 	//connect it to the destination or any other node for processing
 	
 	mediaStreamSource.connect(audioContext.destination);
 	
 }

 navigator.webkitGetUserMedia({audio:true},gotStream);

 */

 function gotStream(stream){
	 	
	 	var audioContext = new webkitAudioContext();
	 	
	 	//Create an audionode from the stream
	 	
	 	var mediaStreamSource = audioContext.createMediaStreamSource(stream);
	 	
	 	//connect it to the destination or any other node for processing
	 	
	 	mediaStreamSource.connect(audioContext.destination);
	 	
	 }

 var constraints = {
			
			video :{
				
				mandatory :{
					
					chromeMediaSource:'screen'
				}
			}
	};

	navigator.webkitGetUserMedia(constraints,gotStream, function() {
       	alert('Error, my friend. Screen stream is not available. Try in latest Chrome with Screen sharing enabled in about:flags.');
 	});
 



</script>

</body>
</html>