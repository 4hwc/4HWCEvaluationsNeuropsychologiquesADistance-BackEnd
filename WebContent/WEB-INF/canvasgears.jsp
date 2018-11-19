<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >

<html>
<head>

<title>CANVAS GEARS</title>

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
        
      }
      
      #myCanvas{
     
     position:absolute;
     
     padding: 50px;
     
     margin : 20px;
     
      }
      
    </style>
</head>
<body>


          <div class="container">
          
                  <div class="row">
                  
                       
                         <div class="col-xs-12">
                         
                                <canvas id="myCanvas" class="col-xs-10" width="700" height="480"></canvas>
                         
                                <script type="text/javascript">
                                
                                window.requestAnimFrame = (function(callback) {
                                    return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||
                                    function(callback) {
                                      window.setTimeout(callback, 1000 / 60);
                                    };
                                  })();

                                  /*
                                   * Gear constructor
                                   */
                                  function Gear(config) {
                                    this.x = config.x;
                                    this.y = config.y;
                                    this.outerRadius = config.outerRadius;
                                    this.innerRadius = config.innerRadius;
                                    this.midRadius = config.midRadius;
                                    this.holeRadius = config.holeRadius;
                                    this.numTeeth = config.numTeeth;
                                    this.theta = config.theta;
                                    this.thetaSpeed = config.thetaSpeed / 1000;
                                    this.lightColor = config.lightColor;
                                    this.darkColor = config.darkColor;
                                    this.clockwise = config.clockwise;
                                  }
                                  
                                  /*
                                   * Gear draw method
                                   */
                                  Gear.prototype.draw = function() {
                                    var canvas = document.getElementById('myCanvas');
                                    var context = canvas.getContext('2d');

                                    context.save();
                                    var numPoints = this.numTeeth * 2;
                                    // draw gear teeth
                                    context.beginPath();
                                    context.lineJoin = 'bevel';
                                    for(var n = 0; n < numPoints; n++) {

                                      var radius = null;

                                      if(n % 2 == 0) {
                                        radius = this.outerRadius;
                                      }
                                      else {
                                        radius = this.innerRadius;
                                      }

                                      var theta = this.theta;
                                      theta += ((Math.PI * 2) / numPoints) * (n + 1);

                                      var x = (radius * Math.sin(theta)) + this.x;
                                      var y = (radius * Math.cos(theta)) + this.y;

                                      if(n == 0) {
                                        context.moveTo(x, y);
                                      }
                                      else {
                                        context.lineTo(x, y);
                                      }
                                    }

                                    context.closePath();
                                    context.lineWidth = 5;
                                    context.strokeStyle = this.darkColor;
                                    context.stroke();
                                    
                                 // draw gear body
                                    context.beginPath();
                                    context.arc(this.x, this.y, this.midRadius, 0, 2 * Math.PI, false);

                                    var grd = context.createLinearGradient(this.x - 100, this.y - 100, this.x + 100, this.y + 100);
                                    grd.addColorStop(0, this.lightColor);
                                    grd.addColorStop(1, this.darkColor);
                                    context.fillStyle = grd;
                                    context.fill();
                                    context.lineWidth = 5;
                                    context.strokeStyle = this.darkColor;
                                    context.stroke();

                                    // draw gear hole
                                    context.beginPath();
                                    context.arc(this.x, this.y, this.holeRadius, 0, 2 * Math.PI, false);
                                    context.fillStyle = 'white';
                                    context.fill();
                                    context.strokeStyle = this.darkColor;
                                    context.stroke();
                                    context.restore();
                                  };
                                  
                                  function animate(gears, lastTime) {
                                      var canvas = document.getElementById('myCanvas');
                                      var context = canvas.getContext('2d');

                                      // update
                                      var time = (new Date()).getTime();
                                      var timeDiff = time - lastTime;

                                      for(var i = 0; i < gears.length; i++) {
                                        var gear = gears[i];

                                        if(gears[i].clockwise) {
                                          gears[i].theta -= (gear.thetaSpeed * timeDiff);
                                        }
                                        else {
                                          gears[i].theta += (gear.thetaSpeed * timeDiff);
                                        }
                                      }

                                      // clear
                                      context.clearRect(0, 0, canvas.width, canvas.height);

                                      // draw
                                      for(var i = 0; i < gears.length; i++) {
                                        gears[i].draw();
                                      }

                                      // request new frame
                                      requestAnimFrame(function() {
                                        animate(gears, time);
                                      });
                                    }
                                    var gears = [];
                                    
                                 // blue gear
                                    gears.push(new Gear({
                                      x: 120,
                                      y: 125,
                                      outerRadius: 90,
                                      innerRadius: 50,
                                      midRadius: 80,
                                      holeRadius: 10,
                                      numTeeth: 24,
                                      theta: 0,
                                      thetaSpeed: 1,
                                      lightColor: '#B1CCFF',
                                      darkColor: '#3959CC',
                                      clockwise: false
                                    }));

                                    // red gear
                                    gears.push(new Gear({
                                      x: 222,
                                      y: 216,
                                      outerRadius: 50,
                                      innerRadius: 15,
                                      midRadius: 40,
                                      holeRadius: 10,
                                      numTeeth: 12,
                                      theta: 0.14,
                                      thetaSpeed: 2,
                                      lightColor: '#FF9E9D',
                                      darkColor: '#AD0825',
                                      clockwise: true
                                    }));
                                    
                                 // orange gear
                                    gears.push(new Gear({
                                      x: 272,
                                      y: 168,
                                      outerRadius: 28,
                                      innerRadius: 5,
                                      midRadius: 18,
                                      holeRadius: 7,
                                      numTeeth: 6,
                                      theta: 0.14,
                                      thetaSpeed: 4,
                                      lightColor: '#FFDD87',
                                      darkColor: '#D25D00',
                                      clockwise: false
                                    }));

                                    // green gear
                                    gears.push(new Gear({
                                      x: 463,
                                      y: 170,//144
                                      outerRadius: 170,
                                      innerRadius: 100,
                                      midRadius: 160,
                                      holeRadius: 10,
                                      numTeeth: 48,
                                      theta: 0,
                                      thetaSpeed: 0.5,
                                      lightColor: '#8AFF99',
                                      darkColor: '#005C06',
                                      clockwise: true
                                    }));

                                    var time = (new Date()).getTime();
                                    animate(gears, time);
                                
                                
                                
                                </script>
                         
                         
                         </div>
                  
                  
                  </div>
          
          
          
          </div>

</body>
</html>