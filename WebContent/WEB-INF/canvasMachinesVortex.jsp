<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >

<html>
<head>

<title>CANVAS MACHINES VORTEX</title>
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
      #myCanvas{
     
     position:absolute;
     
     
     
     top:10px;
     
     right:300px;
     
     
     
      }
      
    </style>
</head>
<body>

     <div class="container">
     
           <div class="row">
           
                 <div class="col-xs-12">
                 
                 <canvas id="myCanvas" class="col-xs-6" width="578" height="580"></canvas>
     
     <script type="text/javascript">
     
     window.requestAnimFrame = (function(callback) {
         return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||
         function(callback) {
           window.setTimeout(callback, 1000 / 60);
         };
       })();

       function initArcs() {
         var arcs = [];

         // create 20 arcs
         for( n = 0; n < 20; n++) {
           var radius = (n + 1) * 10;
           var width = (n + 1) * 6;
           // between 0 and 2 PI
           var startingAngle = Math.random() * 2 * Math.PI;
           // 1 to 3 revolutions per second
           var speed = (Math.random() * 2) + 1;
           // between 0 and 1
           var opacity = (n / 20) * 0.75;

           arcs.push({
             radius: radius,
             startingAngle: startingAngle,
             width: width,
             opacity: opacity,
             speed: speed
           });
         }

         return arcs;
       }
       
       function drawArcs(canvas, arcs) {
           var context = canvas.getContext('2d');
           var centerX = canvas.width / 2;
           var centerY = canvas.height / 2;

           for( n = 0; n < arcs.length; n++) {
             context.save();
             context.beginPath();
             var thisArc = arcs[n];

             context.globalAlpha = thisArc.opacity;
             context.arc(centerX, centerY, thisArc.radius, thisArc.startingAngle, thisArc.startingAngle + Math.PI, true);
             context.lineWidth = thisArc.width;
             // line width
             context.strokeStyle = 'black';
             context.stroke();
             context.closePath();
             context.restore();
           }
         }
         function updateArcs(arcs, timeDiff) {
           for( n = 0; n < arcs.length; n++) {
             var thisArc = arcs[n];
             var angleDiff = thisArc.speed * timeDiff / 1000;
             thisArc.startingAngle -= angleDiff;
           }
         }
         
         function animate(canvas, arcs, lastTime) {
             var context = canvas.getContext('2d');

             // update
             var time = (new Date()).getTime();
             var timeDiff = time - lastTime;
             updateArcs(arcs, timeDiff);

             // clear
             context.clearRect(0, 0, canvas.width, canvas.height);

             // draw
             drawArcs(canvas, arcs);

             // request new frame
             requestAnimFrame(function() {
               animate(canvas, arcs, time);
             });
           }
           
           var canvas = document.getElementById('myCanvas');
           var arcs = initArcs();
           var time = (new Date()).getTime();
           animate(canvas, arcs, time);
     
     
     
     
     </script>
                 
                 
                 
                 
                 </div>
           
           
           </div>
     
     
     
     </div>

     
</body>
</html>