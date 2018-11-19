<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>


<div class="row">

     <div class="col-xs-12">
     
         <div id="white-background" style="display:none;
    width:100%;
    height:100%;
    position:fixed;
    top:0px;
    left:0px;
    background-color:#fefefe;
    opacity:0.7;
    z-index:9999;">
                                     
      </div>
      
      <div id="dlgbox_anterieure" style="display:none;
  
   position:fixed;
    width:600px;
    z-index:999999;
    border-radius:10px;
    
    
    right:30%;
    
    top:20%;
    
    left:30%;
    
    border: 10px #0099cc outset;">
      
             <div id="dlg-header_anterieure" style="background-color:#0099cc;
  color:white;
  font-size:20px;
  padding:10px;
  margin: 10px 10px 0px 10px;
  ">Version inférieure à 56 </div>
             
             <div id="dlg-body_anterieure" style="background-color:white;
  
  color:black;
  
  font-size:14px;
  
  padding:10px;
  
  margin:0px 10px 0px 10px;">
             
                  
                  
                  La version minimale pour vous assurer une expérience de qualité est 56. Vous avez la possibilité de mettre à jour en cliquant sur ce bouton.
                  
                  <br>
                  <br>
                  
                   <a class="btn btn-primary btn-lg  btn-block "  href="https://support.google.com/chrome/answer/95414" style="   text-align:center;"
						target="_blank" id="buttoncanvas"
						>  <strong style=" font-size: 2em;"> <i class="fa fa-chrome" aria-hidden="true"></i></strong> <br />
					<br />
						
									</a>
                  
                  
                 
             
             
             </div>
             
             
             <div id="dlg-footer_anterieure" style="background-color:#f2f2f2;
  
  text-align:right;
  padding:10px;
  margin:0px 10px 10px 10px;">
             
                 <button id="validfreq_anterieure" style="color: white;
  background-color: #2ecc71;
  border-color: #ecf0f1;" class="btn ">Fermer</button>
             
             </div>
                                     
      </div>
      
      <div id="dlgbox_different" style="display:none;
  
   position:fixed;
    width:600px;
    z-index:999999;
    border-radius:10px;
    
    
    right:30%;
    
    top:20%;
    
    left:30%;
    
    border: 10px #0099cc outset;">
      
             <div id="dlg-header_different" style="background-color:#0099cc;
  color:white;
  font-size:20px;
  padding:10px;
  margin: 10px 10px 0px 10px;">Navigateur incompatible </div>
             
             <div id="dlg-body_different" style="background-color:white;
  
  color:black;
  
  font-size:14px;
  
  padding:10px;
  
  margin:0px 10px 0px 10px;">
             
                  
                  
                  Si vous n'avez pas google chrome, vous avez la possibilité de  télécharger en cliquant sur ce bouton.
                  
                  <br>
                  <br>
                  
                  <a class="btn btn-primary btn-lg  btn-block "  href="https://www.google.fr/chrome" style="   text-align:center;"
						target="_blank" id="buttoncanvas"
						>  <strong style=" font-size: 2em;"> <i class="fa fa-chrome" aria-hidden="true"></i></strong> <br />
					<br />
						
									</a>
                  
                  
                 
             
             
             </div>
             
             
             <div id="dlg-footer_different" style="background-color:#f2f2f2;
  
  text-align:right;
  padding:10px;
  margin:0px 10px 10px 10px;">
             
                 <button id="validfreq" style="color: white;
  background-color: #2ecc71;
  border-color: #ecf0f1;" class="btn ">Fermer</button>
             
             </div>
                                     
      </div>
     
     
     </div>



</div>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<script src="<c:url value="/inc/bowser-master/src/bowser.js"/>"></script>


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


//Chrome 1+
var isChrome = !!window.chrome && !!window.chrome.webstore;

if(isChrome){
 
 var version = bowser.version;
 
 if(version>=56){
	  
     //setTimeout(redirect,60000);
	  
	  
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




      
      
