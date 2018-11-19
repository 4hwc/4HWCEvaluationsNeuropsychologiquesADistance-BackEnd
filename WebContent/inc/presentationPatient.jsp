<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
    <!-- Barre de recherche-->
    
    
      <div class="row">
      
                <div class="col-xs-9">
                
                
                      <div  style="margin:auto;
	width:100%;
	border: 8px #66FFFF solid;
        border-radius:10px;
        padding:10px;
        
        height:105px;">
                      
                      
                        <form method="post" action="<c:url value="/recherches_Patient"/>" class=" col-xs-12  ">
                        
                              
                               
                                    <div class="input-group col-xs-12">
                             
                                  <input type="text" id="inputrecherche" class="elementrecherche form-control  input-lg" name="barre_recherche" placeholder="Votre recherche de médecins par noms et / ou prénoms..." value="<c:out value="${formr.champ_recherche }"/>">
                         
                                 <span class="input-group-btn">
                                 
                                     <button type="submit" class="btn btn-primary "  >ENAD recherche ...</button>
                      
                                 
                                 </span>
                                 
                                 
                                
                          
                             </div>
                          
                          
                          
                            
                      
                      </form>
                      
                      
                      
                      
                      </div>
                
                      
                
                          
                
                </div>
                
                <div class="col-xs-1">
      
      <div class="homemed">
      
      <a class="btn btn-block" id="recognition" ><strong style=" font-size: 4em;"> <i class="fa fa-microphone" aria-hidden="true"></i></strong>
       </a>
      
      </div>
      
      <!-- POP UP -->
      
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
  margin: 10px 10px 0px 10px;">ENAD vous écoutera après avoir appuyé sur le micro ...</div>
             
             <div id="dlg-body_anterieure" style="
  background-color:white;
  
  color:black;
  
  font-size:14px;
  
  padding:10px;
  
  margin:0px 10px 0px 10px;">
  
  
  
        <div id="result" style="height:200px;

border: 1px solid #ccc;
padding:10px;
box-shadow: 0 0 10px 0 #bbb;
margin-bottom:30px;
font-size:14px;
line-height:25px;"></div>


<button id="start" style="font-size:20px;

position:absolute;

top:267px;

left:50%;" ><i class="fa fa-microphone"></i></button>
             
                  
                  
             </div>
             
             
             <div id="dlg-footer_anterieure" style="background-color:#f2f2f2;
  
  text-align:right;
  padding:10px;
  margin:0px 10px 10px 10px;">
             
                 <button id="validfreq_anterieure" style="color: white;
  background-color: #2ecc71;
  border-color: #ecf0f1;
                 " class="btn ">Transférer dans la barre de recherche</button>
                 
                 <button id="fermer" style="color: white;
  background-color: #0099cc;
  border-color: #ecf0f1;
                 " class="btn ">Fermer uniquement sans transférer</button>
             
             </div>
                                     
      </div>
      
      <!-- Fin pop up -->
      
      
      
      </div>
                
                
                <div class="col-xs-2">
                
                    <div class="homepat">
                    
                           <a id="" class="btn-block "  href="<c:url value="/accueil_Patient"/>"><span class=""></span>Accueil</a>
                    
                    
                    </div>
                
                
                </div>
                
           </div> 
           
           <!-- prénoms+noms + datenaiss/ age +photo+ déconnexion-->
      
      <div class="row">
      
      <!-- prénoms+noms+datenaiss/age -->
      
                <div class="col-xs-7">
                
                     <div class="prenomsnomsagepat" >
	
        
        
                     
                     <c:if test="${ ! empty sessionScope.sessionPatient }">
                     
                     
                     <a id="" class="btn-block "  href="<c:url value="/profil_Patient?identifiant=${sessionScope.sessionPatient.identifiant_patient }"/>"> 
                     
                     
${sessionScope.sessionPatient.prenoms_patient }  ${sessionScope.sessionPatient.noms_patient }
</a>



             
                     
                     
                     </c:if> 
                     
                    
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     </div>
                
                
                
                          
                
                </div>
                
                <!-- photo-->
                
                <div class="col-xs-3">
                
                       <div class="photopat" id="idphotopat" style="height:300px;">
                       
                       
                       <c:if test="${ ! empty sessionScope.sessionPatient.url_photo_patient }">
                       
                       <img class="" width="200" height="200" id="img" alt="ENAD" src="http://${  sessionScope.adresseserveur }:8080/enad${  sessionScope.sessionPatient.url_photo_patient }" >
                          
                       
                       
                       <a id="" class="btn-block " target="_blank" href="<c:url value="/photoPatient"/>"> Modifier </a>
                       
                       
                       </c:if>
                       
                       <c:if test="${  empty sessionScope.sessionPatient.url_photo_patient }">
                       
                       <img class="" width="200" height="200" id="img" alt="ENAD" src="<c:url value="/inc/imageneutre.jpg"/>" >
                        
                       
                       <a id="" class="btn-block " target="_blank" href="<c:url value="/photoPatient"/>"> Modifier </a>
                       
                       </c:if>
                       
                       
                       
                       
                       
                       
                       </div>
                
                          
                
                </div>
                
                
                
                <!-- déconnexion-->
                
                <div class="col-xs-2">
                
                         <div class="deconnexionmed" >
                         
                          <c:if test="${ ! empty sessionScope.sessionPatient }">
                          
                                 <a id="enad_a" class="btn-block "  href="<c:url value="/deconnexionPatient?identifiant=${sessionScope.sessionPatient.identifiant_patient }"/>"><span class="glyphicon glyphicon-log-out"></span> <br/>Déconnexion</a>
                          
                          </c:if>
                         
                               
                   
                   
                   
                         </div>
                
                
                
                          
                
                </div>
      </div>
      
      <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
      
      
      <script type="text/javascript">
      
var speechRecognizer = new webkitSpeechRecognition();
      
      var recognizing = false;
      
       
       var r = document.getElementById('result');
       
       $('#recognition').click(function(){
    		
    	   var whitebg = document.getElementById("white-background");
	  	   
	  	   var dlg = document.getElementById("dlgbox_anterieure");
		   
		   whitebg.style.display ="block";
	  	   
	  	   dlg.style.display ="block";
	  	   
	  	 document.getElementById("result").textContent =" ";
  			
     		
     	});
       
       $('#fermer').click(function(){
   		
    	   var whitebg = document.getElementById("white-background");
	  	   
	  	   var dlg = document.getElementById("dlgbox_anterieure");
		   
		   whitebg.style.display ="none";
	  	   
	  	   dlg.style.display ="none";
	  	   
	  	 if(recognizing==true){
			   
			  speechRecognizer.stop();
			   
			   
		   }
     		
     		
     	});
       
       $('#start').click(function(){
    	   
if('webkitSpeechRecognition' in window){
        	   
        	  
        	   
        	   speechRecognizer.continuous = true;
        	   
        	   speechRecognizer.interimResults = true;
        	   
        	   speechRecognizer.lang = 'fr-FR';
        	   
        	   speechRecognizer.start();
        	   
        	   recognition.onstart = function() {
	           		
	           	    recognizing = true;
	           	    
	           	    
	           	  };
        	   
        	   var finalTranscripts = '';
        	   
        	   speechRecognizer.onresult = function (event){
        		   
        		   var interimTranscripts='';
        		   
        		   for(var i=event.resultIndex;i<event.results.length;i++){
        			   
        			   var transcript = event.results[i][0].transcript;
        			   
        			   transcript.replace("\n","<br>");
        			   
        			   if(event.results[i].isFinal){
        				   
        				   finalTranscripts += transcript;
        				   
        			   }else{
        				   
        				   interimTranscripts += transcript;
        			   }
        			   
        			   
        		   }
        		   
        		   r.innerHTML = finalTranscripts + '<span style="color:#999">'+interimTranscripts+'</span>';
        		   
        	   };
        	   
        	   speechRecognizer.onerror = function(event){
        		   
        	   };
        	   
        	   
        	   
           }else{
        	   
        	   r.innerHTML = 'Your browser is not supported. If google chrome please upgrade';
        	   
        	   
           }

    	   
     	});
       

  	   
  	 $('#validfreq_anterieure').click(function(){
  		
  		//boitedisparait
  		
  		var whitebgu = document.getElementById("white-background");
 	   
 	   var dlgu = document.getElementById("dlgbox_anterieure");
 	   
 	  var contenu = document.getElementById("result").innerText||document.getElementById("result").textContent; // Je récupère le contenu prononcé par le patient
 	  
    	 
 	 document.getElementById("inputrecherche").value = document.getElementById("inputrecherche").value+" "+ contenu; // Je copie dans la barre de recherche
 	 	  
 	   
 	   whitebgu.style.display ="none";
 	   
 	   dlgu.style.display ="none";
 	   
 	  var enad = new SpeechSynthesisUtterance("Je vais répéter votre recherche vocale:");
 	  
  	 var enadun = new SpeechSynthesisUtterance(document.getElementById("inputrecherche").value);
  	 
  	window.speechSynthesis.speak(enad);

  	window.speechSynthesis.speak(enadun);
  	
  	if(recognizing==true){
		   
		  speechRecognizer.stop();
		   
		   
	   }
  		
  		
  	});
       
       
    
       

      </script>
      