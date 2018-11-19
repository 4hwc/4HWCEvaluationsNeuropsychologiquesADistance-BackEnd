<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >


<html>
<head>

<title> ENAD vérifie ... </title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="ENAD vérifie les paramètres">
<meta name="author" content="ENAD">


<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet"/>


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>


<script src="<c:url value="/inc/bowser-master/src/bowser.js"/>"></script>
    

<style>
      #myCanvas{
     
     position:fixed;
     
     top:10px;
     
     right:50%;
     
     margin:auto;
     
      }
      
      .couleur0{
      
      border: 5px #3498db solid;
      
      }
      
      .couleur1{
      
      border: 5px #2980B9 solid;
      }
      
      .couleur2{
      
      border: 5px #2ECC71 solid;
      }
      
      .couleur3{
      
      border: 5px #27AE60 solid;
      }
      
      .couleur4{
      
      border: 5px #F1C40F solid;
      }
      
      .couleur5{
      
      border: 5px #F39C12 solid;
      }
      
      .couleur6{
      
      border: 5px #E67E22 solid;
      }
      
      .couleur7{
      
      border: 5px #D35400 solid;
      }
      
      .couleur8{
      
      border: 5px #E74C3C solid;
      }
      
      .couleur9{
      
      border: 5px #C0392B solid;
      }
      
      .couleur10{
      
      border: 5px #ECF0F1 solid;
      }
      
      .couleur11{
      
      border: 5px #BDC3C7 solid;
      }
      
      .couleur12{
      
      border: 5px #95A5A6 solid;
      }
      
      .couleur13{
      
      border: 5px #7F8C8D solid;
      }
      
      .couleur14{
      
      border: 5px #9B59B6 solid;
      }
      
      .couleur15{
      
      border: 5px #8E44AD solid;
      }
      
      .couleur16{
      
      border: 5px #34495E solid;
      }
      
      .couleur17{
      
      border: 5px #2C3E50 solid;
      }
      
      .couleur18{
      
      border: 5px black solid;
      }
      
      .couleur19{
      
      border: 5px #AE7C5B solid;
      }
      
      #white-background{
  
    display:none;
    width:100%;
    height:100%;
    position:fixed;
    top:0px;
    left:0px;
    background-color:#fefefe;
    opacity:0.7;
    z-index:9999;
  
  }
  
  #dlgbox_different{
  
  /*Initially dialog box is hidden*/
  
  display:none;
  
   position:fixed;
    width:600px;
    z-index:999999;
    border-radius:10px;
    
    
    right:30%;
    
    top:20%;
    
    left:30%;
    
    border: 10px #0099cc outset;
  
  }
  
  #dlg-header_different{
  
  background-color:#0099cc;
  color:white;
  font-size:20px;
  padding:10px;
  margin: 10px 10px 0px 10px;
  
  }
  
  #dlg-body_different{
  
  background-color:white;
  
  color:black;
  
  font-size:14px;
  
  padding:10px;
  
  margin:0px 10px 0px 10px;
  
  }
  
  #dlg-footer_different{
  
  background-color:#f2f2f2;
  
  text-align:right;
  padding:10px;
  margin:0px 10px 10px 10px;
  
  }
  
  

#validfreq{


color: white;
  background-color: #2ecc71;
  border-color: #ecf0f1;

}
  
     
     
     #dlgbox_anterieure{
  
  /*Initially dialog box is hidden*/
  
  display:none;
  
   position:fixed;
    width:600px;
    z-index:999999;
    border-radius:10px;
    
    
    right:30%;
    
    top:20%;
    
    left:30%;
    
    border: 10px #0099cc outset;
  
  }
  
  #dlg-header_anterieure{
  
  background-color:#0099cc;
  color:white;
  font-size:20px;
  padding:10px;
  margin: 10px 10px 0px 10px;
  
  }
  
  #dlg-body_anterieure{
  
  background-color:white;
  
  color:black;
  
  font-size:14px;
  
  padding:10px;
  
  margin:0px 10px 0px 10px;
  
  }
  
  #dlg-footer_anterieure{
  
  background-color:#f2f2f2;
  
  text-align:right;
  padding:10px;
  margin:0px 10px 10px 10px;
  
  }
  
  

#validfreq_anterieure{


color: white;
  background-color: #2ecc71;
  border-color: #ecf0f1;

}
  
      
      
     
      
    </style>



</head>
<body>

<script type="text/javascript">




function speak( text, onend ) {
    		  window.speechSynthesis.cancel();
    		  var ssu = new SpeechSynthesisUtterance( text );
    		  ssu.lang = 'fr-FR';
    		  window.speechSynthesis.speak( ssu );
    		  function _wait() {
    		    if ( ! window.speechSynthesis.speaking ) {
    		      onend();
    		      return;
    		    }
    		    window.setTimeout( _wait, 200 );
    		  }
    		  _wait();
    		}



    		function doit() {
    			  speak( "Bienvenue, vérification en cours : navigateur Google Chrome et Version minimale 56. S'il vous plaît, veuillez patienter. Merci . ", function() { console.log( 'done' ); } );

    			 

    			}



    		doit();





</script>


<div class="container">
     
           <div class="row">
           
                 <div class="col-xs-12" >
                 
                 <canvas id="myCanvas" class="col-xs-6" width="578" height="580"></canvas>
     
     
     
     <div  id="info" class="col-xs-6" style="border-radius: 10px; font-size: 2em; font-style:italic;  top:10px;right:10px;height:500px;text-align:center; position:fixed;">
     
     <br>
     
     <br>
     
     ENAD vérifie la compatibilité du navigateur 
     
     <br>
     <br>
     
     pour vous assurer une expérience optimale. 
    
     <br>
     <br>
     
     S'il vous plaît, veuillez patienter.
     
     <br>
     <br>
     
     Merci !
     
     <br>
     <br>
     
     <strong style=" font-size: 2em ;"> <i class="fa fa-smile-o" aria-hidden="true"></i></strong>
     
     
     
     
     
     </div>
     
     <div id="white-background">
                                     
      </div>
      
      
      
      <div id="dlgbox_anterieure">
      
             <div id="dlg-header_anterieure">Version inférieure à 56 </div>
             
             <div id="dlg-body_anterieure">
             
                  
                  
                  La version minimale pour vous assurer une expérience de qualité est 56. Vous avez la possibilité de mettre à jour en cliquant sur ce bouton.
                  
                  <br>
                  <br>
                  
                   <a class="btn btn-primary btn-lg  btn-block "  href="https://support.google.com/chrome/answer/95414" style="   text-align:center;"
						target="_blank" id="buttoncanvas"
						>  <strong style=" font-size: 2em;"> <i class="fa fa-chrome" aria-hidden="true"></i></strong> <br />
					<br />
						
									</a>
                  
                  
                 
             
             
             </div>
             
             
             <div id="dlg-footer_anterieure">
             
                 <button id="validfreq_anterieure" class="btn ">Fermer</button>
             
             </div>
                                     
      </div>
      
      <div id="dlgbox_different">
      
             <div id="dlg-header_different">Navigateur incompatible </div>
             
             <div id="dlg-body_different">
             
                  
                  
                  Si vous n'avez pas google chrome, vous avez la possibilité de  télécharger en cliquant sur ce bouton.
                  
                  <br>
                  <br>
                  
                  <a class="btn btn-primary btn-lg  btn-block "  href="https://www.google.fr/chrome" style="   text-align:center;"
						target="_blank" id="buttoncanvas"
						>  <strong style=" font-size: 2em;"> <i class="fa fa-chrome" aria-hidden="true"></i></strong> <br />
					<br />
						
									</a>
                  
                  
                 
             
             
             </div>
             
             
             <div id="dlg-footer_different">
             
                 <button id="validfreq" class="btn ">Fermer</button>
             
             </div>
                                     
      </div>
     
     <script type="text/javascript">
     
     $('#validfreq').click(function(){
    		
    		//boitedisparait
    		
    		var whitebg = document.getElementById("white-background");
  	   
  	   var dlg = document.getElementById("dlgbox_different");
  	   
  	   whitebg.style.display ="none";
  	   
  	   dlg.style.display ="none";
    		
    		
    	});
     
     $('#validfreq_anterieure').click(function(){
 		
 		//boitedisparait
 		
 		var whitebgu = document.getElementById("white-background");
	   
	   var dlgu = document.getElementById("dlgbox_anterieure");
	   
	   whitebgu.style.display ="none";
	   
	   dlgu.style.display ="none";
 		
 		
 	});
    	
     
     
         
         var divinfo = document.getElementById('info');
         
         var colors = ['#3498DB','#2980B9','#2ECC71','#27AE60','#F1C40F','#F39C12','#E67E22','#D35400','#E74C3C','#C0392B','#ECF0F1','#BDC3C7','#95A5A6','#7F8C8D','#9B59B6','#8E44AD','#34495E','#2C3E50','black','#AE7C5B'];
         
         
         window.requestAnimFrame = (function(callback) {
             return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||
             function(callback) {
               window.setTimeout(callback, 20000 / 60);
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
           
           function redirect()
           
           {
           	window.location='/enad/enad_accueil';
           }
           
           function drawArcs(canvas, arcs,currentColor) {
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
                 
                 
                 context.strokeStyle = currentColor;
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
             
             function animate(canvas, arcs, lastTime,currentColor) {
                 var context = canvas.getContext('2d');

                 // update
                 var time = (new Date()).getTime();
                 var timeDiff = time - lastTime;
                 updateArcs(arcs, timeDiff);

                 // clear
                 context.clearRect(0, 0, canvas.width, canvas.height);

                 // draw
                 drawArcs(canvas, arcs,currentColor);

                 // request new frame
                 requestAnimFrame(function() {
                   animate(canvas, arcs, time,currentColor);
                 });
               }
             
            
               
               var canvas = document.getElementById('myCanvas');
               var arcs = initArcs();
               var time = (new Date()).getTime();
               
               function changeColors(){
              	 
              	 animate(canvas, arcs, time,colors[x]);
              	 
              	 divinfo.className = 'couleur'+x;
              	 
              	x++;
                
                if(x >= colors.length){
                    x = 0;
                    
                } 
                
                abc =   setTimeout(changeColors, 10000);
                
                
               }
               
               var x=0;
           	   
           	   var abc =  setTimeout(changeColors, 1000);
               
         
         
         
         
         
      //  Chrome 1+
         var isChrome = !!window.chrome && !!window.chrome.webstore;
      
      if(isChrome){
    	  
    	  var version = bowser.version;
    	  
    	 
    	  
    	  if(version>=56){
    		  
              setTimeout(redirect,60000);
    		  
    		  
    		  //Proposer d'installer extension si pas faite
    		  
    		  //var detect  = function(base, if_installed, if_not_installed) {
    			   // var s = document.createElement('script');
    			   // s.onerror = if_not_installed;
    			   // s.onload = if_installed;
    			    //document.body.appendChild(s);
    			    //s.src = base + '/manifest.json';
    			//}
    			//detect('chrome://extensions/' + 'nkemblooioekjnpfekmjhpgkackcajhg', function() {alert('boom!');});
    			
    		  //var testScript = document.createElement("script");            
    		  //testScript.setAttribute("onload", "alert('Extension Installed!')");
    		  //testScript.setAttribute("src", "chrome://extensions/nkemblooioekjnpfekmjhpgkackcajhg/manifest.json");
    		  //document.body.appendChild(testScript);
    		  
    		  //$("body").load("facebook.com", function(responseTxt, statusTxt, xhr){
    		        //if(statusTxt == "success")
    		            //alert("External content loaded successfully!");
    		       // if(statusTxt == "error")
    		          //  alert("Error: " + xhr.status + ": " + xhr.statusText);
    		    //});
    			
    			
    		  
    		  
    	  }else{
    		  
    		  //NAVIGATEUR CHROME AYANT UNE VERSION ANTERIEURE
    		  
    		  //https://support.google.com/chrome/answer/95414
    		  
    		  var whitebgp = document.getElementById("white-background");
        	   
        	   var dlgp = document.getElementById("dlgbox_anterieure");
       	  
        	   
        	  whitebgp.style.display ="block";
        	   
        	   dlgp.style.display ="block";
    		  
    		  
    		  
    		  
    	  }
    	  
      }else{
    	  
    	  //NAVIGATEUR DIFFERENT DE CHROME;
    	  
    	  //https://www.google.fr/chrome
    	  
    	  var whitebgo = document.getElementById("white-background");
     	   
     	   var dlgo = document.getElementById("dlgbox_different");
    	  
     	   
     	  whitebgo.style.display ="block";
     	   
     	   dlgo.style.display ="block";
       		
    	  
      }
         
         
     
     </script>
     
     
    
    
                 
                 
                 </div>
           
           
           </div>
     
     
     
     </div>

     
</body>
</html>