<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<!DOCTYPE html >
<html>
<head>
<title>

Attente...

</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Attente avant test">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet" />

<link href="<c:url value="/inc/jquery.loadingModal.css"/>" rel="stylesheet" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->

</head>

<body>

      <div class="container" id="responsecontainer">
      
      <c:if test="${ clic_pat eq 'non' }">
      
     
      <script type="text/javascript">
         
         var plusinfo = new SpeechSynthesisUtterance("S'il vous plaît, patientez.");
         
         plusinfo.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinfo);

         
         </script>
     
      
      <script src="<c:url value="/inc/jquery.loadingModal.js"/>"></script>
      
      
      <c:if test="${ sexe eq 'homme' }">
      
      <script type="text/javascript">
      
      var texte="S'il vous plaît, veuillez patienter qu'ENAD vous connecte au patient ${seance.prenoms_noms_patient } ...";
      
      $('body').loadingModal({
    	  text: texte
    	});
      
      
      
      </script>
                     
                     
                     </c:if>
                     
<c:if test="${ sexe eq 'femme' }">

   
      
      
      <script src="<c:url value="/inc/jquery.loadingModal.js"/>"></script>
      
	

<script type="text/javascript">

var texte="S'il vous plaît, veuillez patienter qu'ENAD vous connecte à la patiente ${seance.prenoms_noms_patient } ...";

      
      $('body').loadingModal({
    	  text: texte
    	});
      
      
      
      </script>
                     
                     
                     </c:if>    
      
      
      </c:if>
      
      <c:if test="${ clic_pat eq 'oui' }">
      
      <script type="text/javascript">
      
      window.location='/enad/realisation_fcro?identifiantpatient=${seance.identifiant_patient }&identifiantmedecin=${seance.identifiant_medecin }&identifiantutilisateur=${sessionScope.sessionMedecin.identifiant_medecin }&idseance=${seance.id_seance }';
      
              
      
      
      
      </script>
      
      </c:if>
      
      
      
      </div>
      
      <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
      
      
      
      <script src="<c:url value="/inc/jquery.loadingModal.js"/>"></script>
      
	<script src="<c:url value="/inc/bootstrap.js"/>"></script>
	
	<script>
 $(document).ready(function() {
 	 $("body").load('/enad/attente_Fcro_Medecin?identifiantpatient=${seance.identifiant_patient }&identifiantmedecin=${seance.identifiant_medecin }&identifiantutilisateur=${sessionScope.sessionMedecin.identifiant_medecin }&idseance=${seance.id_seance }');
		  
  	
   var refreshId = setInterval(function() {
      $("body").load('/enad/attente_Fcro_Medecin?identifiantpatient=${seance.identifiant_patient }&identifiantmedecin=${seance.identifiant_medecin }&identifiantutilisateur=${sessionScope.sessionMedecin.identifiant_medecin }&idseance=${seance.id_seance }');
 		
   }, 10000);
   
   $.ajaxSetup({ cache: false });
   
});
</script>
	
	
	
	
	
	

</body>
</html>