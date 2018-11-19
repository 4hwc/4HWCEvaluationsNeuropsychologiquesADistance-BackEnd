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
      
      <div id="dlgbox_identifiant" style="display:none;
  
   position:fixed;
    width:600px;
    z-index:999999;
    border-radius:10px;
    
    
    right:30%;
    
    top:20%;
    
    left:30%;
    
    border: 10px #0099cc outset;">
      
             <div id="dlg-header_identifiant" style="background-color:#0099cc;
  color:white;
  font-size:20px;
  padding:10px;
  margin: 10px 10px 0px 10px;
  ">Échec de la modification de l'identifiant </div>
             
             <div id="dlg-body_identifiant" style="background-color:white;
  
  color:black;
  
  font-size:14px;
  
  padding:10px;
  
  margin:0px 10px 0px 10px;">
             
                  
                  
                  ${formidentifiant.erreurs['identifiantPatient'] }
                  
                  <br>
                  <br>
                  
                   
             </div>
             
             
             <div id="dlg-footer_identifiant" style="background-color:#f2f2f2;
  
  text-align:right;
  padding:10px;
  margin:0px 10px 10px 10px;">
             
                 <button id="validfreq_identifiant" style="color: white;
  background-color: #2ecc71;
  border-color: #ecf0f1;" class="btn ">Fermer</button>
             
             </div>
                                     
      </div>
        
        
        
        </div>



</div>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<c:if test="${ formulaire_activee eq 'oui' }">


<script type="text/javascript">

alert("ert");

</script>



</c:if>


<c:if test="${ formulaire_activee eq 'ou' }">




     <script type="text/javascript">
     
     //document.getElementById("white-background").style.display ="block";
	   
	 // document.getElementById("dlgbox_identifiant").style.display ="block";
     
     alert("ertyeeeeer");
     
	   
	  



$('#validfreq_identifiant').click(function(){
	
	//boitedisparait
	

document.getElementById("white-background").style.display ="none";

document.getElementById("dlgbox_identifiant").style.display ="none";
	
	
});

	  
	  
	 
	

</script>




</c:if>



