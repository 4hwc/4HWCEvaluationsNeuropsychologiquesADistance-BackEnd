<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>NOTICE : Connexion du patient ou de la patiente</title>


<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Notice d'utilisation d'ENAD">
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
            
                 <c:import url="/inc/webrtc.jsp" />
                 
                 <br>
                 <br>
                 
                 <c:import url="/inc/accueilnotice.jsp" />
                 
                 <br>
                 <br>
                 <br>
                 
                 <div class="row">
                 
                 <div class="col-xs-1">
                 </div>
                 
                 
                 
                       <div class="col-xs-10">
                       
                       <div class="row">
                               
                                     <div class="col-xs-12 " style="font-style:italic;
        color:black;
        font-family:agencyfb;
        font-size:2em;">
                                     
                                          		<strong style="color:white;">ESPACE</strong> Après  <a  target="_blank"
									href="<c:url value="/noticePatient_Inscription"/>">l'inscription</a>,   vient l'étape de la connexion. Vous avez deux options au choix: recherche par prénoms et noms ET recherche par identifiants.
                                          		
                                          		
                                          		
                                     
                                     </div>
                               
                               </div>
                               
                               <br><br>
                       
                               <div class="row">
                               
                                     <div class="col-xs-12 ">
                                     
                                          <img class="" style="margin:auto;" width="100%" height=""  alt="ENAD" src="<c:url value="/inc/conpat.JPG"/>" >
                                     
                                     
                                     </div>
                               
                               </div>
                               
                               <br>
                               <br>
                               
                               <div class="row">
                               
                                     <div class="col-xs-12 " style="font-style:italic;
        color:black;
        font-family:agencyfb;
        font-size:2em;">
                                     
                                          		<strong style="color:white;">ESPACE</strong>1/2*La recherche par prénoms et noms vous permet de vous connecter en saisissant entièrement vos noms et prénoms ou une partie (une lettre ou une suite de lettres).
                                          		
                                          		
                                     
                                     </div>
                               
                               </div>
                               
                               <br><br>
                               
                               <div class="row">
                               
                                 <div class="col-xs-12 ">
                                     
                                          <img class="" style="margin:auto;" width="100%" height=""  alt="ENAD" src="<c:url value="/inc/rpn.JPG"/>" >
                                     
                                     
                                     </div>
                               
                               </div>
                               
                               <br><br>
                               
                               <div class="row">
                               
                                     <div class="col-xs-12 " style="font-style:italic;
        color:black;
        font-family:agencyfb;
        font-size:2em;">
                                     
                                          		<strong style="color:white;">ESPACE</strong>2/2**La recherche par identifiants vous permet de vous connecter en saisissant votre identifiant.
                                          		
                                          		
                                     
                                     </div>
                               
                               </div>
                               
                               <br><br>
                               
                               <div class="row">
                               
                                 <div class="col-xs-12 ">
                                     
                                          <img class="" style="margin:auto;" width="100%" height=""  alt="ENAD" src="<c:url value="/inc/ri.JPG"/>" >
                                     
                                     
                                     </div>
                               
                               </div>
                               
                               
                               
                               
                               
                               <br>
                               <br>
                       
                       
                       </div>
                       
                       <div class="col-xs-1">
                 </div>
                       
                       
                 
                 
                 
                 </div>
                 
                 <br>
                 <br>
                 <br>
                 <br>
                 <br>
                 <br>
                 
                 <c:import url="/inc/footernotice.jsp" />
            
                 
            </div>
            
            <script type="text/javascript">
            
            window.speechSynthesis.cancel();
            
            var msgi = new SpeechSynthesisUtterance("Dans cette rubrique connexion du patient ou de la patiente, ");
            
            
            var msg = new SpeechSynthesisUtterance("vous serez informés des deux règles à respecter pour se connecter aisément.");
            
           
            
            
           msgi.lang="fr-FR";
           
           msg.lang="fr-FR";
           
          
            
            window.speechSynthesis.speak(msgi);
            
            window.speechSynthesis.speak(msg);
            
           
           
            
            </script>
            
            
            
<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
       
       <script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
       <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
       
       
</body>
</html>