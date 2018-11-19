<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >

<html>
<head>

<title>GOOGLE BOUNCING BALLS</title>

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

<style>
      body {
        margin: 0px;
        padding: 0px;
      }
      
      canvas{
     left:15%;
     right:15%;
     bottom:15%;
     top:15%;
      }
    </style>


</head>
<body>

<div class="container">

      <div class="row">
      
            <div class="col-xs-12">
            
                  

<canvas id="myCanvas" class="col-xs-8 hide" width="578" height="200"></canvas>

<br>
<br>
<br>
<br>


								
								
								
								<a class="btn btn-primary btn-lg  btn-block " style="   text-align:center;"
						target="_blank" id="buttoncanvas"
						>  <strong style=" font-size: 4em;"> <i class="fa fa-smile-o" aria-hidden="true"></i></strong> <br />
					<br />
					
					<strong style=" font-size: 1.5em;"> En attendant d'assister à la réalisation du test, ENAD vous propose un moment de détente .
					
					<br />
									
									Il faut cliquer sur ce bouton et modifier la position du curseur dans le cadre qui apparaîtra.
					
					</strong>
					
					
					
					
									
									</a>
									
									
									
									


<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<script type="text/javascript">



$("canvas").css("background", "linear-gradient(to right, #33ccff 0%, #ccff99 100%)");



$("#buttoncanvas").click(function(){
    
    
    $("#buttoncanvas").hide(1000,function(){
    	
    	$("#myCanvas").removeClass("hide");
    	$("#myCanvas").show(1000);
    });
});

</script>

<script type="text/javascript">

window.requestAnimFrame = (function(callback) {
    return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||
    function(callback) {
      window.setTimeout(callback, 1000 / 60);
    };
  })();
  
function initBalls() {
    balls = [];

    var a = '#2980b9'; //blue
    
    var b = '#1abc9c'; //green
    
    var c='#7f8c8d';//gris
    
    var d = '#d35400';//orange
    
    
    

    // F
    balls.push(new Ball(173, 53, 0, 0, a));
    balls.push(new Ball(158, 53, 0, 0,a));
    balls.push(new Ball(143, 53, 0, 0,a));
    balls.push(new Ball(130, 53, 0, 0,a));
    balls.push(new Ball(117, 53, 0, 0, a));
    balls.push(new Ball(117, 70, 0, 0,a));
    balls.push(new Ball(117, 82, 0, 0, a));
    balls.push(new Ball(117, 96, 0, 0, a));
    balls.push(new Ball(173, 96, 0, 0,a));
    balls.push(new Ball(158, 96, 0, 0, a));
    balls.push(new Ball(143, 96, 0, 0,a));
    balls.push(new Ball(130, 96, 0, 0,a));
    balls.push(new Ball(117, 107, 0, 0, a));
    balls.push(new Ball(117, 120, 0, 0, a));
    balls.push(new Ball(117, 130, 0, 0,a));
    balls.push(new Ball(117, 136, 0, 0, a));
    

    // C
    balls.push(new Ball(210, 53, 0, 0, b));
    balls.push(new Ball(195, 53, 0, 0, b));
    balls.push(new Ball(225, 53, 0, 0, b));
    balls.push(new Ball(240, 53, 0, 0, b));
    balls.push(new Ball(255, 53, 0, 0, b));
    
    
    balls.push(new Ball(195, 68, 0, 0, b));
    balls.push(new Ball(195, 73, 0, 0, b));
    balls.push(new Ball(195, 88, 0, 0, b));
    balls.push(new Ball(195, 103, 0, 0, b));
    balls.push(new Ball(195, 118, 0, 0, b));
    balls.push(new Ball(195, 133, 0, 0,b));
    
    
    balls.push(new Ball(210, 140, 0, 0, b));
    balls.push(new Ball(195, 140, 0, 0, b));
    balls.push(new Ball(225, 140, 0, 0, b));
    balls.push(new Ball(240, 140, 0, 0, b));
    balls.push(new Ball(250, 140, 0, 0,b));
    
    
    
    
    
    
    
    
 // R
    var oOffset = 80;
 
    balls.push(new Ball(oOffset + 205, 53, 0, 0, c));   
    balls.push(new Ball(oOffset + 210, 53, 0, 0, c));
    balls.push(new Ball(oOffset + 220, 53, 0, 0, c));
    balls.push(new Ball(oOffset + 230, 53, 0, 0, c));
    balls.push(new Ball(oOffset + 240, 53, 0, 0, c));
    balls.push(new Ball(oOffset + 250, 53, 0, 0, c));
    
    balls.push(new Ball(oOffset + 205, 68, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 83, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 98, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 113, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 128, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 143, 0, 0, c));
    
    balls.push(new Ball(oOffset + 205, 98, 0, 0, c));
    balls.push(new Ball(oOffset + 220, 98, 0, 0,c));
    balls.push(new Ball(oOffset + 235, 98, 0, 0, c));
    balls.push(new Ball(oOffset + 240, 98, 0, 0, c));
    balls.push(new Ball(oOffset + 255, 98, 0, 0, c));
    
    balls.push(new Ball(oOffset + 255, 88, 0, 0, c));
    balls.push(new Ball(oOffset + 255, 78, 0, 0, c));
    balls.push(new Ball(oOffset + 255, 68, 0, 0, c));
    balls.push(new Ball(oOffset + 255, 58, 0, 0, c));
    
    
    balls.push(new Ball(oOffset + 255, 143, 0, 0, c));
    
    balls.push(new Ball(oOffset + 245, 133, 0, 0, c));
    
    balls.push(new Ball(oOffset + 235, 123, 0, 0, c));
    
    balls.push(new Ball(oOffset + 225, 113, 0, 0, c));
    
 
    

    
    
 // 0
    
    
    
    balls.push(new Ball(381, 53, 0, 0, d));
    balls.push(new Ball(391, 53, 0, 0, d));
    balls.push(new Ball(401, 53, 0, 0, d));
    balls.push(new Ball(411, 53, 0, 0, d));
    balls.push(new Ball(422, 53, 0, 0, d));
    balls.push(new Ball(432, 53, 0, 0, d));
    
    balls.push(new Ball(432, 63, 0, 0, d));
    balls.push(new Ball(432, 73, 0, 0, d));
    balls.push(new Ball(432, 83, 0, 0, d));
    balls.push(new Ball(432, 93, 0, 0, d));
    balls.push(new Ball(432, 103, 0, 0, d));
    balls.push(new Ball(432, 118, 0, 0, d));
    balls.push(new Ball(432, 133, 0, 0, d));
    balls.push(new Ball(432, 143, 0, 0, d));
    
    balls.push(new Ball(381, 63, 0, 0, d));
    balls.push(new Ball(381, 73, 0, 0, d));
    balls.push(new Ball(381, 83, 0, 0, d));
    balls.push(new Ball(381, 93, 0, 0, d));
    balls.push(new Ball(381, 103, 0, 0, d));
    balls.push(new Ball(381, 118, 0, 0, d));
    balls.push(new Ball(381, 133, 0, 0, d));
    balls.push(new Ball(381, 143, 0, 0,d));
    
    
    balls.push(new Ball(381, 143, 0, 0, d));
    balls.push(new Ball(391, 143, 0, 0, d));
    balls.push(new Ball(401, 143, 0, 0, d));
    balls.push(new Ball(411, 143, 0, 0, d));
    balls.push(new Ball(421, 143, 0, 0, d));
    balls.push(new Ball(432, 143, 0, 0, d));
    
    
    
    
   

    

    return balls;
  }
  
function getMousePos(canvas, evt) {
    // get canvas position
    var obj = canvas;
    var top = 0;
    var left = 0;
    while(obj.tagName != 'BODY') {
      top += obj.offsetTop;
      left += obj.offsetLeft;
      obj = obj.offsetParent;
    }

    // return relative mouse position
    var mouseX = evt.clientX - left + window.pageXOffset;
    var mouseY = evt.clientY - top + window.pageYOffset;
    return {
      x: mouseX,
      y: mouseY
    };
  }
  
function updateBalls(canvas, balls, timeDiff, mousePos) {
    var context = canvas.getContext('2d');
    var collisionDamper = 0.3;
    var floorFriction = 0.0005 * timeDiff;
    var mouseForceMultiplier = 1 * timeDiff;
    var restoreForce = 0.002 * timeDiff;

    for(var n = 0; n < balls.length; n++) {
      var ball = balls[n];
      // set ball position based on velocity
      ball.y += ball.vy;
      ball.x += ball.vx;

      // restore forces
      if(ball.x > ball.origX) {
        ball.vx -= restoreForce;
      }
      else {
        ball.vx += restoreForce;
      }
      if(ball.y > ball.origY) {
        ball.vy -= restoreForce;
      }
      else {
        ball.vy += restoreForce;
      }
      
   // mouse forces
      var mouseX = mousePos.x;
      var mouseY = mousePos.y;

      var distX = ball.x - mouseX;
      var distY = ball.y - mouseY;

      var radius = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));

      var totalDist = Math.abs(distX) + Math.abs(distY);

      var forceX = (Math.abs(distX) / totalDist) * (1 / radius) * mouseForceMultiplier;
      var forceY = (Math.abs(distY) / totalDist) * (1 / radius) * mouseForceMultiplier;

      if(distX > 0) {// mouse is left of ball
        ball.vx += forceX;
      }
      else {
        ball.vx -= forceX;
      }
      if(distY > 0) {// mouse is on top of ball
        ball.vy += forceY;
      }
      else {
        ball.vy -= forceY;
      }

      // floor friction
      if(ball.vx > 0) {
        ball.vx -= floorFriction;
      }
      else if(ball.vx < 0) {
        ball.vx += floorFriction;
      }
      if(ball.vy > 0) {
        ball.vy -= floorFriction;
      }
      else if(ball.vy < 0) {
        ball.vy += floorFriction;
      }
      
   // floor condition
      if(ball.y > (canvas.height - ball.radius)) {
        ball.y = canvas.height - ball.radius - 2;
        ball.vy *= -1;
        ball.vy *= (1 - collisionDamper);
      }

      // ceiling condition
      if(ball.y < (ball.radius)) {
        ball.y = ball.radius + 2;
        ball.vy *= -1;
        ball.vy *= (1 - collisionDamper);
      }

      // right wall condition
      if(ball.x > (canvas.width - ball.radius)) {
        ball.x = canvas.width - ball.radius - 2;
        ball.vx *= -1;
        ball.vx *= (1 - collisionDamper);
      }

      // left wall condition
      if(ball.x < (ball.radius)) {
        ball.x = ball.radius + 2;
        ball.vx *= -1;
        ball.vx *= (1 - collisionDamper);
      }
    }
  }
  
function Ball(x, y, vx, vy, color) {
    this.x = x;
    this.y = y;
    this.vx = vx;
    this.vy = vy;
    this.color = color;
    this.origX = x;
    this.origY = y;
    this.radius = 10;
  }
  function animate(canvas, balls, lastTime, mousePos) {
    var context = canvas.getContext('2d');

    // update
    var date = new Date();
    var time = date.getTime();
    var timeDiff = time - lastTime;
    updateBalls(canvas, balls, timeDiff, mousePos);
    lastTime = time;

    // clear
    context.clearRect(0, 0, canvas.width, canvas.height);

    // render
    for(var n = 0; n < balls.length; n++) {
      var ball = balls[n];
      context.beginPath();
      context.arc(ball.x, ball.y, ball.radius, 0, 2 * Math.PI, false);
      context.fillStyle = ball.color;
      context.fill();
    }

    // request new frame
    requestAnimFrame(function() {
      animate(canvas, balls, lastTime, mousePos);
    });
  }
  
  var canvas = document.getElementById('myCanvas');
  var balls = initBalls();
  var date = new Date();
  var time = date.getTime();
  /*
   * set mouse position really far away
   * so the mouse forces are nearly obsolete
   */
  var mousePos = {
    x: 9999,
    y: 9999
  };

  canvas.addEventListener('mousemove', function(evt) {
    var pos = getMousePos(canvas, evt);
    mousePos.x = pos.x;
    mousePos.y = pos.y;
  });

  canvas.addEventListener('mouseout', function(evt) {
    mousePos.x = 9999;
    mousePos.y = 9999;
  });
  animate(canvas, balls, time, mousePos);



</script>
                                     
            
            
            </div>
            
            
									   
									
									
      
      
      </div>
      
      <c:import url="/inc/footer.jsp" />


</div>

	


<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>

        

</body>
</html>