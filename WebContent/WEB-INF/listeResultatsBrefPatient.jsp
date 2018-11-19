<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >
<html>
<head>

<title>Faites votre choix</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Nous vous remercions d'avoir utilisé ENAD.">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png" href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet"/>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->



</head>
<body>
<div class="container">

<c:if test="${  ! empty patients }">


<script type="text/javascript">

var msgu = new SpeechSynthesisUtterance("J'ai trouvé ${patients.size()} résultats");

msgu.lang = 'fr-FR';


window.speechSynthesis.speak(msgu);




</script>
                               
                               
                               
                               
                               
</c:if>

<c:if test="${  empty patients }">
                               
                               
                                        
                                        <script type="text/javascript">

var msgu = new SpeechSynthesisUtterance("Aucun résultat");

msgu.lang = 'fr-FR';


window.speechSynthesis.speak(msgu);




</script>
                               
                               
                               
                               </c:if>


<c:import url="/inc/enadnotice.jsp"/>

                           <div class="row">
                                             
                                                                <div class="col-xs-12">
                                                                  
                                                                                         
                                                                                         
                                                                                         <div class="enad_ENAD">
                                                                                         
                                                                                         Mes patient(e)s
                                                                                         
                                                                                         </div>
                                                                  
                                                                  
                                                                  </div>
                                             
                                             
                           </div>
                           
                           <br>

		<c:import url="/inc/presentationMedecin.jsp" />

		<br>
                           
                           <div class="row">
                           
                                  <div class="col-xs-12">
                                  
                                              <div class="enad_con_pat">
                                              
                                              
                                                         <form  class="col-xs-12 well"  >
                                                         
                                                                
                                                                   <fieldset>
                                                                   
                                                                           
                                                                           
                                                                           <div class="form-group">
                                                                           
                                                                                     
                                                                                     
                                                                                     
                          <c:if test="${ empty patients }">
                                                                                                   
                                                                                                         <br/>
                                                                                                         
                                                                                                         <div class="alert alert-info alert-dismissable col-xs-12">
                                                                                                         
                                                                                                                  <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                                                                                  
                                                                                                                  <p> Aucun résultat </p>
                                                                                                         </div>
                                                                                                   
                                                                                                   
                          </c:if>
                                                                           
                                                                            
                                                                           
                                                                           </div>
                                                                           
                                                                           
                                                                           
                                                                           <%-- Résultats de la recherche --%>
                                                                           
                                                                           <c:if test="${ ! empty patients }">
                                                                           
                                                                           <br>
                                                                           
                                                                           
                                                                                   <div class="form-group">
                                                                                   
                                                                                   
                                                                                             <div class="row">
                                                                                             
                                                                                                      
                                                                                                         <div class="col-xs-12">
                                                                                                         
                                                                                                         
                                                                                                                  <div class="titre_resultats_recherche_con_pat">
                                                                                                                  
                                                                                                                  ENAD a trouvé :
                                                                                                                  
                                                                                                                  <c:if test="${patients.size()> 1 }">
                                                                                                                  
                                                                                                                  ${patients.size() }
                                                                                                                  
                                                                                                                  résultats
                                                                                                                  
                                                                                                                  </c:if>
                                                                                                                  
                                                                                                                  <c:if test="${patients.size() == 1 }">
                                                                                                                  ${patients.size() }
                                                                                                                  
                                                                                                                  résultat
                                                                                                                  
                                                                                                                  </c:if>
                                                                                                                  
                                                                                                                  
                                                                                                                  
                                                                                                                  
                                                                                                                  </div>
                                                                                                         
                                                                                                         
                                                                                                         
                                                                                                         
                                                                                                         </div>
                                                                                             
                                                                                             
                                                                                             
                                                                                             
                                                                                             </div>
                                                                                             
                                                                                             <br>
                                                                                             <br>
                                                                                             
                                                                                             <div class="row">
                                                                                             
                                                                                                   <div class="resultats_recherche_con_pat">
                                                                                                   
                                                                                                     
                                                                                                      
                                                                                                      <c:forEach  items="${ patients }" var="listedepatients" >
                                                                                                      
                                                                                                      <div class="col-xs-1"></div>
                                                                                                      
                                                                                                      <div class="col-xs-11">
                                                                                                      
                                                                                                       <a id="" class="" target="_blank"  href="<c:url value="/resultats_bref_patient_unique?identifiant=${listedepatients.identifiant_patient }"/>"> <c:out value="${listedepatients.prenoms_patient }    ${listedepatients.noms_patient }"/></a>
                                                                                                      
                                                                                                      
                                                                                                      </div>
                                                                                                      
                                                                                                      
                                                                                                     
                                                                                                      <br>
                                                                                                      
                                                                                                    
                                                                                                      
                                                                                                      </c:forEach>
                                                                                                   
                                                                                                   
                                                                                                   
                                                                                                   </div>
                                                                                             
                                                                                                     
                                                                                             
                                                                                             
                                                                                             </div>
                                                                                   
                                                                                    
                                                                                   </div>
                                                                           
                                                                           
                                                                           
                                                                           </c:if>
                                                                           
                                                                           
                                                                           
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                                 
                                                                           
                                                                           
                                                                   
                                                                   
                                                                   
                                                                   </fieldset>
                                                                   
                                                                   <br>
                                                                   <br>
                                                                   <br>
                                                         
                                                         
                                                         
                                                         </form>
                                              
                                              
                                              
                                              </div>
                                  
                                  </div>
                           
                           
                           
                           
                           </div>
                           
                           
                           

<c:import url="/inc/footer.jsp"/>

</div>

<script >

$(function(){
	
	$(".close").click(function(){
		$(".alert").hide("slow");
	});
	
	
});

</script>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
       
       <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
         

</body>
</html>