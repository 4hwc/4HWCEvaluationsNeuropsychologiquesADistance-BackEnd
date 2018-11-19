<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>ESSAI</title>

<style type="text/css">

canvas {border-style:solid;}



</style>


</head>

<body>

<div id="kinetic">



</div>


<script type="text/javascript">

window.onload = function() {
	var scène = new Kinetic.Stage({
	container: "kinetic",
	width: 800,
	height: 800
	});
	var calque = new Kinetic.Layer();
	
	var rect = new Kinetic.Rect({
		x: 0,
		y: 0,
		width: 700,
		height: 400,
		stroke: "#c0c0c0",
		strokeWidth: 5,
		cornerRadius: 20
		});
	
	calque.add(rect);
	scène.add(calque);
	};




</script>



<script src="<c:url value="/inc/kinetic/kinetic-v5.1.0.js"/>"></script>

</body>

</html>