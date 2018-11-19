<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Images de l'installation</title>


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
                               
                                     <div class="col-xs-12 ">
                                     
                                          <img class="" style="margin:auto;" width="100%" height="800"  alt="ENAD" src="<c:url value="/inc/webrtcun.JPG"/>" >
                                     
                                     
                                     </div>
                               
                               </div>
                               
                               <br>
                               <br>
                               
                               <div class="row">
                               
                                 <div class="col-xs-12 ">
                                     
                                          <img class="" style="margin:auto;" width="100%" height="800"  alt="ENAD" src="<c:url value="/inc/webrtcdeux.JPG"/>" >
                                     
                                     
                                     </div>
                               
                               </div>
                               
                               <br>
                               <br>
                               
                               <div class="row">
                               
                                  <div class="col-xs-12 ">
                                     
                                          <img class="" style="margin:auto;" width="100%" height="800"  alt="ENAD" src="<c:url value="/inc/webrtctrois.JPG"/>" >
                                     
                                     
                                     </div>
                               
                               </div>
                               
                               <br>
                               <br>
                               
                               <div class="row">
                               
                                  <div class="col-xs-12 ">
                                  
                                        
                                     
                                          <img class="" style="margin:auto;" width="100%" height="800"  alt="ENAD" src="<c:url value="/inc/webrtcquatre.JPG"/>" >
                                     
                                     
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
            
           
            var a = new SpeechSynthesisUtterance("L'extension est utile pour la fonctionnalité temps réel.");
            
            
            var b = new SpeechSynthesisUtterance("Voici quelques images pour vous donner une idée de l'installation.");
            
            
            var c = new SpeechSynthesisUtterance("Pour installer l'extension , cliquez sur le bouton bleu au sommet et suivez les instructions.");
            
          
            var d = new SpeechSynthesisUtterance("Pour savoir si vous avez déjà installé, faites de même.");
            
            
            var e = new SpeechSynthesisUtterance("Si vous avez d'autres questions, cliquez sur le bouton bleu tout en bas.");
            
            a.lang="fr-FR";
            
            b.lang="fr-FR";
            
            c.lang="fr-FR";
            
            d.lang="fr-FR";
            
            e.lang="fr-FR";
            
            
            window.speechSynthesis.speak(a);
            
            window.speechSynthesis.speak(b);
            
            window.speechSynthesis.speak(c);
            
            window.speechSynthesis.speak(d);
            
            window.speechSynthesis.speak(e);
            
            
            
            
            </script>
            
            
            
<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
       
       <script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
       <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
       
       
</body>
</html>