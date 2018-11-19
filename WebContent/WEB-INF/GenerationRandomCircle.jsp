<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
    <!DOCTYPE html >
<html>
<head>

<title>Réalisation du Trail Making Version 1</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Réalisation de la Figure Complexe de Rey-Osterrieth">
<meta name="author" content="ENAD">



<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet" />

<link href="<c:url value="/inc/colorpicker/css/colorpicker.css"/>" rel="stylesheet" />



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
      
      
      
      canvas {

/*border-style:solid;*/

       border-radius: 10px;
       
      /* border-color:'#3498db';*/
      
      border: 5px #3498db solid;
}










</style>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>


   <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>

  
<script type="text/javascript">

  


</script>



</head>
<body>

      <div class="container">
      
              <c:if test="${  sessionuser eq 'patient'  }">
              
                    
                    
                    <div  class=" col-xs-1 btn-group-vertical btn-group-lg" >
                                                 
                                                
                                                      
                                                      <a  id ="downloadandgivetodoctor" style="   height:80px;" class="btn btn-info  btn-lg" rel="tooltip" data-original-title="Capturer"><span class="glyphicon glyphicon-screenshot"></span></a> 
                                                      
                                                      <a  id ="dessiner" style="   height:80px;" class="btn btn-info  btn-lg" rel="tooltip" data-original-title="Dessiner"><span class="glyphicon glyphicon-pencil"></span></a> 
                                                      
                                                      
                                                     <a id="effacer" class="btn btn-info  btn-lg"style="   height:80px;" rel="tooltip" data-original-title="Effacer"><span class="glyphicon glyphicon-erase"></span></a> 
                                                     
                                                     
                                                 <a id="supprimer" class="btn btn-info  btn-lg" style="   height:80px;" rel="tooltip" data-original-title="Supprimer"><span class="glyphicon glyphicon-trash"></span></a> 
                                                 
                                                 
                                </div>
                        
                        
                            
                           
                           <div class="col-xs-1">
                           
                           
                           
                           </div>
                   
                   
                
                   
                  
                   
                   
                   <canvas  id="canvasfcromg"  >
                   
                   
                   
                   
                   
                   </canvas>
                    
                    
                   
                   
                   <script type="text/javascript">
                    
                   $(document).ready(function(){
                	   
                	   
                	   var larg = (document.body.clientWidth)||(window.innerWidth);
               		var haut = (document.body.clientHeight)||(window.innerHeight);
               		

               		console.log('larg :'+larg);
               		
               		console.log('haut :'+haut);
               		
               		
               		var largeurresponsive ,hauteurresponsive,largeurresponsivearrondie,hauteurresponsivearrondie;
               		
               		
               		
               		if(larg<768){
               			
               	 largeurresponsive = (larg*1050)/1366;
               			
               	 hauteurresponsive = (haut*600)/662;
               			
               	 largeurresponsivearrondie = Math.floor(largeurresponsive);
               			
               	 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
               			
               			
               			
               			
               		}

               		if(larg >= 768 && larg<992){
               			
               	 largeurresponsive = (larg*1050)/1366;
               			
               	 hauteurresponsive = (haut*600)/662;
               			
               	 largeurresponsivearrondie = Math.floor(largeurresponsive);
               			
               	 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
               			
               			
               			
               			
               		}

               		if(larg >= 992 && larg<1200){
               			
               	largeurresponsive = (larg*1050)/1366;
               			
               	 hauteurresponsive = (haut*600)/662;
               			
               	 largeurresponsivearrondie = Math.floor(largeurresponsive);
               			
               	 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
               			
               			
               			
               		}

               		if(larg >= 1200 ){
               			
               			 largeurresponsive = (larg*1050)/1366;
               			
               			 hauteurresponsive = (haut*600)/662;
               			
               			 largeurresponsivearrondie = Math.floor(largeurresponsive);
               			
               			 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
               			
               			
               			
               			
               		}
               		
               		var w,h;
               		
               		w = largeurresponsivearrondie+'';
               		
               			h=hauteurresponsivearrondie+'';
               		
               		document.getElementById('canvasfcromg').setAttribute('height',h);
               		
               		document.getElementById('canvasfcromg').setAttribute('width',w);
                	   
                	   function uploadFile(file){
        	  		    	 
        	  		    	 var url = '/enad/captureimagefcro?idseance=${id_seance}';
        	  		    	 var xhr = new XMLHttpRequest();
        	  		    	 var fd = new FormData();
        	  		    	 
        	  		    	 xhr.open("POST", url, true);
        	  		    	 xhr.onreadystatechange = function() {
        	  		    	 if (xhr.readyState == 4 && xhr.status == 200) {
        	  		    	 // Every thing ok, file uploaded
        	  		    	
        	  		    	 console.log(xhr.responseText); // handle response.
        	  		    	 }
        	  		    	 };
        	  		    	 fd.append("upload_img_fcro", file); //parameter : upload_img_fcro 
        	  		    	 xhr.send(fd);
        	  		    	 
        	  		     }//uploadfile
                  	   
                  	   
                  	   function downloadsendCanvas(link, canvaser) {
                      	      
                      	      
                      	      function nomnom(){
                           		  
                           		 // var medpat = '${noms_prenoms_medpat}'; // Je reçois les noms et prénoms (sources de caractères spéciaux)
                      	  			  
                        	  			var idseance = '${id_seance}';
                        	  			
                        	  			var idmed = '${idmed}' ;
                        	  			
                        	  			var idpat = '${idpat}';
                        	  			  
                        	  			  
                        	  			  
                        	  			  
                                  	  var date = new  Date();

                    	  				var year = date.getYear()+1900;

                    	  				var month = date.getMonth()+1;

                    	  				 var dateactuelle ="_dateheure_"+year+"_"+month+"_"+date.getDate()+"_"+date.getHours()+"_"+date.getMinutes()+"_"+date.getSeconds()+"_"+date.getMilliseconds();

                    	  				 
                    	  				var nomfinal ="fcro"+dateactuelle+"_"+"s"+"_"+idseance+"_"+"m"+"_"+idmed+"_"+"p"+"_"+idpat+"_.png";
                    	  				
                    	  				//console.log("NOM FINAL : "+nomfinal);
                    	  				
                    	  				
                    	  				return nomfinal;
                    	  				
                           		  
                           	  }
                      	      
                      	      link.href = canvaser.toDataURL();
                      	      link.download = nomnom();
                      		   
                      		   var dataURL = canvaser.toDataURL("image/png");
                       	      
                        	     
                       	      //GENERER FICHIER
                       	      var blobBin = atob(dataURL.split(',')[1]);
                       	      
                       	     var array = [];
                       	     
                       	  for(var i = 0; i < blobBin.length; i++) {
                       	      array.push(blobBin.charCodeAt(i));
                       	  }

                       	  var blobscreenshot=new Blob([new Uint8Array(array)], {type: 'image/png'});
                       	  
                       	  
                       	  var filescreenshot = new File([new Uint8Array(array)], nomnom());

                       	  

                       	 // console.log("size:"+filescreenshot.size);

                       	  //console.log("date:"+filescreenshot.lastModifiedDate);

                       	  //console.log("name:"+filescreenshot.name);
                       	  
                       	   
                       	   
                       	  /// downloadsendCanvas(document.getElementById('downloadandgivetodoctor'), canvaser, nomnom());
                       	   
                       	   
                       	 
                       	  
                       	//document.getElementById('downloadandgivetodoctor').addEventListener('click', function() {
      	  		    	    //uploadFile(filescreenshot); 
      	  		    	///}, false);
                       	
                       	uploadFile(filescreenshot);
                       	
                      	      
                      	  }//downloadsendcanvas
                      	  
                      	  
                  	   
                   	
                   	document.getElementById('downloadandgivetodoctor').addEventListener('click', function() {
  	  		    	    downloadsendCanvas(this, document.querySelector('#canvasfcromg')); 
  	  		    }, false);
                   	 
                   	
                      	  
                   	(function() {
                		var canvaso = document.querySelector('#canvasfcromg');
                		var ctxo = canvaso.getContext('2d');
                		
                		ctxo.fillStyle = "white";
                		ctxo.fillRect(0, 0, canvaso.width, canvaso.height);
                		
                		
                		var positions_x = [];
                 	   
                 	   var positions_y = [];
                 	   
                 	 
                 	   
                 	   positions_x.push(Math.floor(Math.random()*931)+60);
                 	   
                 	  positions_y.push(Math.floor(Math.random()*481)+60);
                 	  
                 	  var nbre_elements_souhaite = 8;
                 	  
                 	  while(positions_x.length < nbre_elements_souhaite){
                 		  
                         var px = Math.floor(Math.random()*931)+60;
                 		 
                 		 var py = Math.floor(Math.random()*481)+60;
                 		 
                 		
                 		
                 		var compteur = 0;
                 		
                 		var h=0;
                 		
                 		while(h<positions_x.length){
                 			
                 			var diff_x_aucarre = Math.pow(px - positions_x[h],2);
                    		 
                      		var diff_y_aucarre = Math.pow(py - positions_y[h],2);
                      		
                      		var racinecarre = Math.sqrt(diff_x_aucarre + diff_y_aucarre);
                      		
                 			
                 			if(racinecarre>=240){
                 				
                 				compteur++;
                 				
                 			}


                 			h++;
                 		}
                 		
                 		if(compteur == positions_x.length ){
         					
         					positions_x.push(px);
             				
             				positions_y.push(py);
             				
         					
         				}
                 		
                 		
                 		  
                 		  
                 	  }
                 	  
                 	  //A la fin j'ai des cercles espacés, maintenant je les affiche
                 	  
                 	 
                		
                		
                		for (var k=0;k<positions_x.length;k++){
                			
                			ctxo.strokeStyle = "rgb(23, 145, 167)";
                    		
                    		ctxo.beginPath(); // Le cercle extérieur
                    		
                    		
                    		ctxo.arc(positions_x[k], positions_y[k], 60, 0, Math.PI * 2);  
                    		
                    		ctxo.stroke();
                			
                		}
                		
                		
                			
                			
                		
                		
                		
                		
                		
                		//canvas.width = parseInt(sketch_style.getPropertyValue('width'));
                		//canvas.height = parseInt(sketch_style.getPropertyValue('height'));

                		var mouse = {x: 0, y: 0};
                		var last_mouse = {x: 0, y: 0};
                		
                		/* Mouse Capturing Work */
                		canvaso.addEventListener('mousemove', function(e) {
                			last_mouse.x = mouse.x;
                			last_mouse.y = mouse.y;
                			
                			mouse.x = e.pageX - this.offsetLeft;
                			mouse.y = e.pageY - this.offsetTop;
                		}, false);
                		
                		
                		canvaso.addEventListener('touchmove', function(e) {
                			last_mouse.x = mouse.x;
                			last_mouse.y = mouse.y;
                			
                			mouse.x = e.pageX - this.offsetLeft;
                			mouse.y = e.pageY - this.offsetTop;
                		}, false);
                		
                		
                		/* Drawing on Paint App */
                		ctxo.lineWidth = "3";
                		ctxo.lineJoin = 'metter';
                		ctxo.lineCap = 'butt';
                		ctxo.strokeStyle = 'black';
                		
                		
                		canvaso.addEventListener('mousedown', function(e) {
                			canvaso.addEventListener('mousemove', onPaint, false);
                		}, false);
                		
                		canvaso.addEventListener('mouseup', function() {
                			canvaso.removeEventListener('mousemove', onPaint, false);
                		}, false);
                		
                		//Mobile
                		
                		canvaso.addEventListener('touchstart', function(e) {
                			canvaso.addEventListener('touchmove', onPaint, false);
                		}, false);
                		
                		canvaso.addEventListener('touchend', function() {
                			canvaso.removeEventListener('touchmove', onPaint, false);
                		}, false);
                		
                		var onPaint = function() {
                			ctxo.beginPath();
                			ctxo.moveTo(last_mouse.x, last_mouse.y);
                			ctxo.lineTo(mouse.x, mouse.y);
                			ctxo.closePath();
                			ctxo.stroke();
                			ctxo.save();
                		};
                		
                		canvaso.addEventListener('touchstart', function(e) {
                        	$('#canvasfcromg').css('cursor', 'crosshair');
                		}, false);
                		
                		canvaso.addEventListener('touchend', function() {
                			$('#canvasfcromg').css('cursor', 'crosshair');
                		}, false);
                		
                		
                        
                        document.getElementById('effacer').addEventListener('click', function() {
                      	  
                        	ctxo.lineWidth = "20";
                      	  
                        	ctxo.strokeStyle = 'white';
                        	
                        	
                			
                		} , false);
                        
                        document.getElementById('dessiner').addEventListener('click', function() {
                        	  
                        	ctxo.lineWidth = "3";
                      	  
                        	ctxo.strokeStyle = 'black';
                        	
                        	
                			
                		} , false);
                 	   
                 	 
                          
                 	  document.getElementById('supprimer').addEventListener('click', function() {
                        	  
                        	  ctxo.clearRect(0, 0, canvaso.width, canvaso.height);
                        	  
                        	  ctxo.fillRect(0, 0, canvaso.width, canvaso.height);
                      		
                  			
                  		} , false);
                		
                	}());
                	
                	
                    $('#canvasfcromg').mousedown(function(e){
                    	
                    	$('#canvasfcromg').css('cursor', 'crosshair');
                    	
                    	  
                    	});
                    
                   $('#canvasfcromg').hover(function(e){
                    	
                    	$('#canvasfcromg').css('cursor', 'crosshair');
                    	
                    	  
                    	});
                   
                   $('#canvasfcromg').mouseenter(function(e){
                   	
                   	$('#canvasfcromg').css('cursor', 'crosshair');
                   	
                   	  
                   	});
                    
                    $('#canvasfcromg').mousemove(function(e){
                    	
                    	$('#canvasfcromg').css('cursor', 'crosshair');
                    	  
                    	});
                    
                    
                    $('.btn').tooltip({placement:'right'});
                	   
                   });
                   
                   
                   
                   
                   
                   </script>
                        
                      
              </c:if>
              
              <c:if test="${  sessionuser eq 'medecin'  }">
              
              
                    <div class="row">
                    
                            <div class="col-xs-12">
              
              <br>
              <br>
              <br>
            
                  

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



$("#myCanvas").css("background", "linear-gradient(to right, #ffffff 0%, #ccff99 100%)");



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
    
    
    

    // T
    
    //Droite
    
    balls.push(new Ball(173, 53, 0, 0, a));
    balls.push(new Ball(158, 53, 0, 0,a));
    balls.push(new Ball(143, 53, 0, 0,a));
    balls.push(new Ball(130, 53, 0, 0,a));
    
    balls.push(new Ball(117, 53, 0, 0, a)); // Point central 
    
    //Gauche
    
    balls.push(new Ball(102, 53, 0, 0, a));
    balls.push(new Ball(87, 53, 0, 0,a));
    balls.push(new Ball(72, 53, 0, 0,a));
    balls.push(new Ball(57, 53, 0, 0,a));
    
    
    balls.push(new Ball(117, 70, 0, 0,a));
    balls.push(new Ball(117, 82, 0, 0, a));
    balls.push(new Ball(117, 96, 0, 0, a));
    
    balls.push(new Ball(117, 107, 0, 0, a));
    balls.push(new Ball(117, 120, 0, 0, a));
    balls.push(new Ball(117, 130, 0, 0,a));
    balls.push(new Ball(117, 136, 0, 0, a));
    balls.push(new Ball(117, 143, 0, 0, a));
    

    // M
    
    var offsetm = 50;
   
    balls.push(new Ball(offsetm+195, 53, 0, 0, b));
    
    
    balls.push(new Ball(offsetm+255, 53, 0, 0, b));
    
    balls.push(new Ball(offsetm+210, 68, 0, 0, b));
    balls.push(new Ball(offsetm+225, 83, 0, 0, b));
    
    balls.push(new Ball(offsetm+240, 68, 0, 0, b));
    
    
    
    balls.push(new Ball(offsetm+195, 68, 0, 0, b));
    balls.push(new Ball(offsetm+195, 73, 0, 0, b));
    balls.push(new Ball(offsetm+195, 88, 0, 0, b));
    balls.push(new Ball(offsetm+195, 103, 0, 0, b));
    balls.push(new Ball(offsetm+195, 118, 0, 0, b));
    balls.push(new Ball(offsetm+195, 133, 0, 0,b));
    balls.push(new Ball(offsetm+195, 143, 0, 0,b));
    
    balls.push(new Ball(offsetm+255, 68, 0, 0, b));
    balls.push(new Ball(offsetm+255, 83, 0, 0, b));
    balls.push(new Ball(offsetm+255, 98, 0, 0, b));
    balls.push(new Ball(offsetm+255, 113, 0, 0, b));
    balls.push(new Ball(offsetm+255, 128, 0, 0, b));
    balls.push(new Ball(offsetm+255, 133, 0, 0, b));
    balls.push(new Ball(offsetm+255, 143, 0, 0,b));
    
    
   
    
    
    
    
    
    
 // 1
    var oOffset = 250;
 
    balls.push(new Ball(oOffset + 205, 53, 0, 0, c));   
    
    
    balls.push(new Ball(oOffset + 205, 68, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 83, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 98, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 113, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 128, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 143, 0, 0, c));
    
    balls.push(new Ball(oOffset + 205, 98, 0, 0, c));
    
    

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
              
              </c:if>
      
      </div>
      
      <c:if test="${  sessionuser eq 'medecin'  }">
              
              <div class="container">
              
              <c:import url="/inc/footer.jsp"/> 
              
              </div>
             
              
  </c:if>

</body>
</html>