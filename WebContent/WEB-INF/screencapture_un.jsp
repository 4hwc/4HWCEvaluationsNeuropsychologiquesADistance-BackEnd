<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SCREEN CAPTURE VERSION 1</title>

</head>
<body>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	
<script src="<c:url value="/inc/adapter-master/release/adapter.js"/>"></script>
	


<script type="text/javascript">

var MediaStreamConstraint = {
        audio: false,
        video: true,
        videoConstraints: {
            mandatory: {
                chromeMediaSource: 'tab'
            }
        }
    };
    
function callback(stream) {
    if (!stream) {
        console.error('Unable to capture the tab. Note that Chrome internal pages cannot be captured.');
        return;
    }

    setupRTCMultiConnection(stream);
}


	chrome.tabCapture.capture(MediaStreamConstraint, callback);
</script>

</body>
</html>