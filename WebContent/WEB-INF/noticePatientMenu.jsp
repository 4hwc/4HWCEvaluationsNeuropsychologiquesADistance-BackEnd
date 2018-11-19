<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>NOTICE : Menu du patient ou de la patiente</title>


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
                                     
                                          		<strong style="color:white;">ESPACE</strong> En utilisant ENAD, voici le menu que vous manipulerez :
                                          		
                                     </div>
                               
                               </div>
                               
                               <br><br>
                       
                               <div class="row">
                               
                                     <div class="col-xs-12 ">
                                     
                                          <img class="" style="margin:auto;" width="100%" height=""  alt="ENAD" src="<c:url value="/inc/agendapat.JPG"/>" >
                                     
                                     
                                     </div>
                               
                               </div>
                               
                               <br>
                               <br>
                               
                               <div class="row">
                               
                                     <div class="col-xs-12 " style="font-style:italic;
                                     
                                     
                                     
        color:black;
        font-family:agencyfb;
        font-size:2em;">
        
                                              1/3* La  rubrique "Agenda" vous permet d'accéder au planning de vos consultations pour un meilleur suivi. 
                                              
                                              
                                          		
                                     </div>
                               
                               </div>
                               
                               <br><br>
                               
                               <div class="row">
                               
                                     <div class="col-xs-12 " style="font-style:italic;
                                     
                                     
                                     
        color:black;
        font-family:agencyfb;
        font-size:2em;">
        
                                              2/3** Après la création de  la séance, la séance est en attente de validation par la patiente ou le patient. Après validation, elle
                                              devient validée. Ainsi, elle peut avoir lieu puisque les deux parties ont donné leur accord. De manière générale, le médecin crée la séance
                                              et le patient ou la patiente valide.
                                              
                                              
                                              
                                          		
                                     </div>
                               
                               </div>
                               
                               <br><br>
                               
                               <div class="row">
                               
                                     <div class="col-xs-12 " style="font-style:italic;
                                     
                                     
                                     
        color:black;
        font-family:agencyfb;
        font-size:2em;">
        
                                              3/3*** Après avoir validé la séance, on peut exécuter les 5 tests suivants envoyés par le médecin. FCRO et TM apparaîtront sur votre menu lorsque le moment sera venu de les réaliser.
                                              
                                              <br><br>
                                              
                                              <strong style="color:white;">ESPACE</strong>Figure Complexe de Rey-Osterrieth abrégé FCRO
                                              
                                              <br><br>
                                              
                                              <strong style="color:white;">ESPACE</strong>TRAIL - MAKING abrégé TM
                                              
                                              <br><br>
                                              
                                              <strong style="color:white;">ESPACE</strong>Test de Dénomination Orale d'Images abrégé TDOI
                                              
                                              <br><br>
                                              
                                              <strong style="color:white;">ESPACE</strong>Batterie Rapide d'Efficience Frontale (Dubois et Pillon)abrégé BREF
                                              
                                              <br><br>
                                              
                                              <strong style="color:white;">ESPACE</strong>Mini Mental State Examination (MMSE) (Version consensuelle du GRECO) abrégé MMSE
                                              
                                              
                                              
                                          		
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
            
            var msgi = new SpeechSynthesisUtterance("Dans cette rubrique menu de la patiente ou du patient, ");
            
            
            var msg = new SpeechSynthesisUtterance("vous serez informés des trois règles à respecter pour utiliser le menu aisément.");
            
            var msgr = new SpeechSynthesisUtterance("Toutes les fonctionnalités ne sont pas présentées en détail  ");
            
            var a = new SpeechSynthesisUtterance("dans le but de vous permettre d'accéder facilement aux bases.");
            
            
            var b = new SpeechSynthesisUtterance(" Vous découvrirez plus en détail en pratiquant.");
            
            var c = new SpeechSynthesisUtterance("N'hésitez pas d'envoyer un message via le bouton de bas de page pour toutes questions ou suggestions.");
            
            var d = new SpeechSynthesisUtterance("Je suppose que vous avez fait le tour de toutes les rubriques.");
            
            var e = new SpeechSynthesisUtterance("Sinon, cliquez sur le bouton jaune en haut pour aller à l'accueil.");
            
            var f = new SpeechSynthesisUtterance("N'oubliez pas que je suis à votre service.");
            
            var g = new SpeechSynthesisUtterance("Je vous souhaite une excellente utilisation.");
            
            
            
            
            
            
            
            
            
            
           msgi.lang="fr-FR";
           
           msg.lang="fr-FR";
           
           msgr.lang="fr-FR";
           
a.lang="fr-FR";
           
           b.lang="fr-FR";
           
           c.lang="fr-FR";
           
d.lang="fr-FR";
           
           e.lang="fr-FR";
           
           f.lang="fr-FR";
           
           g.lang="fr-FR";
            
            window.speechSynthesis.speak(msgi);
            
            window.speechSynthesis.speak(msg);
            
            window.speechSynthesis.speak(msgr);
            
window.speechSynthesis.speak(a);
            
            window.speechSynthesis.speak(b);
            
            window.speechSynthesis.speak(c);
            
window.speechSynthesis.speak(d);
            
            window.speechSynthesis.speak(e);
            
            window.speechSynthesis.speak(f);
            
            window.speechSynthesis.speak(g);
            
           
            
            </script>
            
            
            
<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
       
       <script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
       <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
       
       
</body>
</html>