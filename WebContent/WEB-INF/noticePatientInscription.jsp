<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>NOTICE : Inscription de la patiente ou du patient</title>


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
                                     
                                          		<strong style="color:white;">ESPACE</strong> Votre identifiant vous permet de  recevoir toutes vos informations.
                                          		
                                          		<br><br>
                                          		
                                          		1/5* L'identifiant ne doit pas contenir d'espaces.
                                          		
                                          		<br><br>
                                          		
                                          		2/5** L'identifiant doit contenir au moins 4 caractères.
                                          		
                                          		<br><br>
                                          		
                                          		3/5*** Vous êtes unique, de même pour votre identifiant. Si l'identifiant n'est pas unique, vous serez informé(e) pour changer. 
                                          		
                                          		
                                          		
                                          		<br><br>
                                          		
                                          		4/5**** Pour la confirmation de l'identifiant, il faut juste écrire l'identifiant choisi une deuxième fois.
                                          		
                                          		<br><br>
                                          		
                                          		5/5***** Il faut retenir votre identifiant. C'est très important pour <a  target="_blank"
									href="<c:url value="/noticePatient_Connexion"/>">la connexion</a>.
                                          		
                                          		
                                          		
                                          		
                                          		
                                          		
                                     
                                     </div>
                               
                               </div>
                               
                               <br><br>
                       
                               <div class="row">
                               
                                     <div class="col-xs-12 ">
                                     
                                          <img class="" style="margin:auto;" width="100%" height=""  alt="ENAD" src="<c:url value="/inc/noticeinscriptionun.JPG"/>" >
                                     
                                     
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
            
            var msgi = new SpeechSynthesisUtterance("Dans cette rubrique inscription du patient ou de la patiente, ");
            
            
            var msg = new SpeechSynthesisUtterance("vous serez informés des cinq règles à respecter pour s'inscrire aisément.");
            
            var msgr = new SpeechSynthesisUtterance("Seules les étapes présentant une difficulté particulière seront abordées.");
            
            
            
           msgi.lang="fr-FR";
           
           msg.lang="fr-FR";
           
           msgr.lang="fr-FR";
            
            window.speechSynthesis.speak(msgi);
            
            window.speechSynthesis.speak(msg);
            
            window.speechSynthesis.speak(msgr);
            
           
            
            </script>
            
            
            
<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
       
       <script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
       <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
       
       
</body>
</html>