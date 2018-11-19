<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DRAG N DROP</title>

<style type="text/css">


#div1,#div2{

    float:left;
    width:280px;
    height:180px;
    margin:10px;
    padding:10px;
    border:1px solid #aaaaaa;



}


</style>



</head>
<body>

    <div id="div1" ondrop="return dropComplete(event)" ondragover="return allowDropStatus(event)">
    
           <img alt="drag" width="250" draggable="true" ondragstart="return dragInitialize(event)" height="150" id="drag1" src="<c:url value="/inc/enadsoleil.png"/>">
           
    
    
    </div>
    
    <div    id="div2"  ondrop="return dropComplete(event)" ondragover="return allowDropStatus(event)">
    
    </div>
    
    
    <script type="text/javascript">
    
    
    function dragInitialize(ev) {
    	ev.dataTransfer.effectAllowed='move';
    	ev.dataTransfer.setData("Text", ev.target.getAttribute('id'));
    	return true;
    	}
    
    function allowDropStatus(ev) {
    	ev.preventDefault();
    	return false;
    	}
    	function dropComplete(ev) {
    	ev.preventDefault();
    	var src = ev.dataTransfer.getData("Text");
    	ev.target.appendChild(document.getElementById(src));
    	ev.stopPropagation();
    	return false;
    	}
    	
    	
    
    
    </script>

     
</body>
</html>