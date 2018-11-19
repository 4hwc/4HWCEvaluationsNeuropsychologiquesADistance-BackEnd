<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >
<html>
<head>

<title>Recherche par identifiants</title>

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

<c:import url="/inc/verificationNavigateur.jsp" />

<c:import url="/inc/enadnotice.jsp"/>

           
                                             
                                             <div class="row">
                                             
                                                                <div class="col-xs-12">
                                                                  
                                                                                         
                                                                                         
                                                                                         <div class="enad_ENAD">
                                                                                         
                                                                                         Recherche par identifiants
                                                                                         
                                                                                         </div>
                                                                  
                                                                  
                                                                  </div>
                                             
                                             
                                             </div>
                                             
                                             <div class="row">
                                             
                                                 
                                                        <div class="col-xs-12">
                                                        
                                                                   
                                                                      <div class="enad_con_pat">
                                                                      
                                                                      
                                                                             <form method="post" class="col-xs-12 well"  action="<c:url value="/recherche_par_identifiants_Patient"/>">
                                                                             
                                                                             
                                                                                       <fieldset>
                                                                                       
                                                                                       
                                                                                             <br/>
                                                                                             
                                                                                             
                                                                                             <a class="btn btn-danger btn-lg btn-block "  href="<c:url value="/inscription_Patient"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je m'inscris avant de me connecter.</a>
                                                                                             
                                                                                             <br>
                                                                                             <br>
                                                                                             
                                                                                             <a class="btn btn-warning btn-lg btn-block "  href="<c:url value="/recherche_par_prenoms_noms_Patient"/>"> <strong style="font-size:2em;">&#8624;</strong> <br/>Oups ! Je souhaite plutôt me connecter en saisissant mes prénoms et noms.</a>
                                                                                             
                                                                                             <br>
                                                                                             <br>
                                                                                             
                                                                                             <div class="form-group">
                                                                                             
                                                                                                        <div class="input-group col-xs-12">
                                                                                                        
                                                                                                               <label for="rechercheparidentifiantsPatients"></label>
                                                                                                               
                                                                                                               <input type="search" id="rechercheparidentifiantsPatients" name="rechercheparidentifiantsPatients" class="form-control input-lg" placeholder="S'il vous plaît, veuillez saisir votre identifiant fourni à l'inscription. Merci pour votre compréhension." value="<c:out value="${patient.identifiant_patient }"/>" required>
                                                                                                               
                                                                                                               <span class="input-group-btn">
                                                                                                               
                                                                                                               <button class="btn btn-primary  "  type="submit"><h4>ENAD vous recherche ...</h4></button>
                                                                                                               
                                                                                                               
                                                                                                               </span>
                                                                                                        
                                                                                                        </div>
                                                                                                        
                                                                                                        <c:if test="${! empty form.erreurs['rechercheparidentifiantsPatients'] }">
                                                                                                   
                                                                                                         <br/>
                                                                                                         
                                                                                                         <div class="alert alert-info alert-dismissable col-xs-12">
                                                                                                         
                                                                                                                  <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                                                                                  
                                                                                                                 
									
									<script type="text/javascript">
         
         var plusinfo = new SpeechSynthesisUtterance("${ form.erreurs['rechercheparidentifiantsPatients'] }");
         
         plusinfo.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinfo);

         
         </script>
									
									
                                                                                                                  
                                                                                                                  <p>${form.erreurs['rechercheparidentifiantsPatients'] }</p>
                                                                                                         </div>
                                                                                                   
                                                                                                   
                                                                                                   </c:if>
                                                                                             
                                                                                             
                                                                                             </div>
                                                                                             
                                                                                             
                                                                                             <%-- Résultats de la recherche --%>
                                                                           
                                                                                           <div class="form-group">
                                                                           
                                                                           
                                                                           
                                                                           
                                                                                          </div>
                                                                                       
                                                                                       
                                                                                       
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