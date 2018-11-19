<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/inc/WeatherAPI/WeatherStyle.css"/>"
	rel="stylesheet" />
	
	<script src="<c:url value="/inc/WeatherAPI/WeatherWidget.js"/>"></script>
	
	
<title>Weather</title>
</head>

<body onload="getLocation()">

       <table class="myTable">
		<tr>
			<th>Location</th>
			<th>Current Weather</th>

		</tr>
		<tr>
			<td><div id="location"></div></td>
			<td><div id="weatherNow"></div></td>

		</tr>


	</table>
	<table class="ForeCastTable">
		<tr>
			<th id="day1">Day 1 Forecast</th>
			<th id="day2">Day 2 Forecast</th>
			<th id="day3">Day 3 Forecast</th>
			<th id="day4">Day 4 Forecast</th>
			<th id="day5">Day 5 Forecast</th>

		</tr>
		<tr>
			<td><div id="day1div"></div></td>
			<td><div id="day2div"></div></td>
			<td><div id="day3div"></div></td>
			<td><div id="day4div"></div></td>
			<td><div id="day5div"></div></td>
		</tr>


	</table>
       

</body>
</html>