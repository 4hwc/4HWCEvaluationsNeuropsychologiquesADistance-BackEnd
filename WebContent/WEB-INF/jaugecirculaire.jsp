<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Jauge circulaire</title>

<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
}

div.round {
	margin: 50px;
	width: 200px;
	height: 200px;
	position: relative;
	border: 1px solid #999;
}

div.round input {
	position: absolute;
	top: 60px;
	left: 50px;
	font-size: 60px;
	text-align: center;
	width: 100px;
	border: none;
	background: none;
	outline: none;
}

div.round canvas {
	position: absolute;
	top: 0;
	left: 0;
	right: 0;
	bottom: 0;
}
</style>
</head>
<body>

	<input type="text" name="round" class="round" data-min="0"
		data-max="50" value="10" />

	<input type="text" name="round" class="round" data-min="50"
		data-max="100" value="70" data-color="#FF0000" />

</body>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>



<script type="text/javascript" src="<c:url value="/inc/app.js"/>"></script>
</html>