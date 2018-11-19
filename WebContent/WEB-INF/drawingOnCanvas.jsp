<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >


<html>
<head>

<title>DRAWING ON CANVAS</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Le but est de permettre à un médecin d'évaluer un patient et de voir les résultats des tests neuropsychologiques en temps réel.">
<meta name="author" content="ENAD">


<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->






<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->

<style type="text/css">


      body {
        margin: 0px;
        padding: 0px;
      }
      
      #myCanvas{
     left:15%;
     right:15%;
     bottom:15%;
     top:15%;
      }
    

#canvasfcromg {

/*border-style:solid;*/

       border-radius: 10px;
       
      /* border-color:'#3498db';*/
      
      border: 5px #3498db solid;
}







</style>

    
    
    <script type="text/javascript">
    var canvas, ctx, flag = false,
        prevX = 0,
        currX = 0,
        prevY = 0,
        currY = 0,
        dot_flag = false;

    var x = "black",
        y = 2;
    
    function init() {
        canvas = document.getElementById('can');
        ctx = canvas.getContext("2d");
        w = canvas.width;
        h = canvas.height;
    
        canvas.addEventListener("mousemove", function (e) {
            findxy('move', e)
        }, false);
        canvas.addEventListener("mousedown", function (e) {
            findxy('down', e)
        }, false);
        canvas.addEventListener("mouseup", function (e) {
            findxy('up', e)
        }, false);
        canvas.addEventListener("mouseout", function (e) {
            findxy('out', e)
        }, false);
    }
    
    function color(obj) {
        switch (obj.id) {
            case "green":
                x = "green";
                break;
            case "blue":
                x = "blue";
                break;
            case "red":
                x = "red";
                break;
            case "yellow":
                x = "yellow";
                break;
            case "orange":
                x = "orange";
                break;
            case "black":
                x = "black";
                break;
            case "white":
                x = "white";
                break;
        }
        if (x == "white") y = 14;
        else y = 2;
    
    }
    
    function draw() {
        ctx.beginPath();
        ctx.moveTo(prevX, prevY);
        ctx.lineTo(currX, currY);
        ctx.strokeStyle = x;
        ctx.lineWidth = y;
        ctx.stroke();
        ctx.closePath();
    }
    
    function erase() {
        var m = confirm("Want to clear");
        if (m) {
            ctx.clearRect(0, 0, w, h);
            document.getElementById("canvasimg").style.display = "none";
        }
    }
    
    function save() {
        document.getElementById("canvasimg").style.border = "2px solid";
        var dataURL = canvas.toDataURL();
        document.getElementById("canvasimg").src = dataURL;
        document.getElementById("canvasimg").style.display = "inline";
    }
    function findxy(res, e) {
        if (res == 'down') {
            prevX = currX;
            prevY = currY;
            currX = e.clientX - canvas.offsetLeft;
            currY = e.clientY - canvas.offsetTop;
    
            flag = true;
            dot_flag = true;
            if (dot_flag) {
                ctx.beginPath();
                ctx.fillStyle = x;
                ctx.fillRect(currX, currY, 2, 2);
                ctx.closePath();
                dot_flag = false;
            }
        }
        if (res == 'up' || res == "out") {
            flag = false;
        }
        if (res == 'move') {
            if (flag) {
                prevX = currX;
                prevY = currY;
                currX = e.clientX - canvas.offsetLeft;
                currY = e.clientY - canvas.offsetTop;
                draw();
            }
            
        }
    }
    </script>
    
    <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
    


</head>
<body onload="init()">

<canvas id="canvasfcromg" width="100" height="100">


</canvas>




<script type="text/javascript">
                                                
                                                $(document).ready(function(){
                                                	
                                                	(function() {
                                                		var canvas = document.querySelector('#canvasfcromg');
                                                		var ctx = canvas.getContext('2d');
                                                		
                                                		
                                                		//canvas.width = parseInt(sketch_style.getPropertyValue('width'));
                                                		//canvas.height = parseInt(sketch_style.getPropertyValue('height'));

                                                		var mouse = {x: 0, y: 0};
                                                		var last_mouse = {x: 0, y: 0};
                                                		
                                                		/* Mouse Capturing Work */
                                                		canvas.addEventListener('mousemove', function(e) {
                                                			last_mouse.x = mouse.x;
                                                			last_mouse.y = mouse.y;
                                                			
                                                			mouse.x = e.pageX - this.offsetLeft;
                                                			mouse.y = e.pageY - this.offsetTop;
                                                		}, false);
                                                		
                                                		
                                                		/* Drawing on Paint App */
                                                		ctx.lineWidth = 5;
                                                		ctx.lineJoin = 'round';
                                                		ctx.lineCap = 'round';
                                                		ctx.strokeStyle = 'blue';
                                                		
                                                		canvas.addEventListener('mousedown', function(e) {
                                                			canvas.addEventListener('mousemove', onPaint, false);
                                                		}, false);
                                                		
                                                		canvas.addEventListener('mouseup', function() {
                                                			canvas.removeEventListener('mousemove', onPaint, false);
                                                		}, false);
                                                		
                                                		var onPaint = function() {
                                                			ctx.beginPath();
                                                			ctx.moveTo(last_mouse.x, last_mouse.y);
                                                			ctx.lineTo(mouse.x, mouse.y);
                                                			ctx.closePath();
                                                			ctx.stroke();
                                                		};
                                                		
                                                	}());
                                                	
                                                     $('#canvasfcromg').mousedown(function(e){
                                                    	
                                                    	$('#canvasfcromg').css('cursor', 'crosshair');
                                                    	
                                                    	  
                                                    	});
                                                    
                                                    $('#canvasfcromg').mousemove(function(e){
                                                    	
                                                    	$('#canvasfcromg').css('cursor', 'crosshair');
                                                    	  
                                                    	});
                                                	
                                                	
                                                });
                                               

                                                </script>
                                   
<canvas id="can" width="400" height="400" style="position:absolute;top:10%;left:10%;border:2px solid;"></canvas>
        <div style="position:absolute;top:12%;left:43%;">Choose Color</div>
        <div style="position:absolute;top:15%;left:45%;width:10px;height:10px;background:green;" id="green" onclick="color(this)"></div>
        <div style="position:absolute;top:15%;left:46%;width:10px;height:10px;background:blue;" id="blue" onclick="color(this)"></div>
        <div style="position:absolute;top:15%;left:47%;width:10px;height:10px;background:red;" id="red" onclick="color(this)"></div>
        <div style="position:absolute;top:17%;left:45%;width:10px;height:10px;background:yellow;" id="yellow" onclick="color(this)"></div>
        <div style="position:absolute;top:17%;left:46%;width:10px;height:10px;background:orange;" id="orange" onclick="color(this)"></div>
        <div style="position:absolute;top:17%;left:47%;width:10px;height:10px;background:black;" id="black" onclick="color(this)"></div>
        <div style="position:absolute;top:20%;left:43%;">Eraser</div>
        <div style="position:absolute;top:22%;left:45%;width:15px;height:15px;background:white;border:2px solid;" id="white" onclick="color(this)"></div>
        <img id="canvasimg" style="position:absolute;top:10%;left:52%;" style="display:none;">
        <input type="button" value="save" id="btn" size="30" onclick="save()" style="position:absolute;top:55%;left:10%;">
        <input type="button" value="clear" id="clr" size="23" onclick="erase()" style="position:absolute;top:55%;left:15%;">
    </body>
</html>