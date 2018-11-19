<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Notice</title>


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
                 
                 <div class="col-xs-2">
                 
                 </div>
                 
                       <div class="col-xs-8">
                       
                               <div class="menumed">
                               
                                     <div class="row">
                                     
                                          <div class="col-xs-12 ">
                                          
                                                 <div class="boutonseances">
                                                 
                                                    <a class="btn-block buttonsmenu"
									href="<c:url value="/installation_Utilisation_Extension_Images"/>"><i
									class="fa fa-cog"></i><br />Installation et utilisation de l'extension en images</a>
                                                 
                                                 
                                                 </div>
                                          
                                          
                                          </div>
                                     
                                     </div>
                                     
                                     
                                     
                                     
                                     
                                     <div class="row ">
                                     
                                         <div class="col-xs-12 ">
                                          
                                                 <div class="boutonseances">
                                                 
                                                    <a class="btn-block buttonsmenu"
									href="<c:url value="/noticePatient_e"/>"><i
									class="fa fa-user"></i><br />Patient(e)</a>
                                                 
                                                 
                                                 </div>
                                          
                                          
                                          </div>
                                     
                                     </div>
                                     
                                    
                                     
                                     <div class="row ">
                                     
                                         <div class="col-xs-12 ">
                                          
                                                 <div class="boutonseances">
                                                 
                                                    <a class="btn-block buttonsmenu"
									href="<c:url value="/noticeMedecin"/>"><i
									class="fa fa-user-md"></i><br />Médecin</a>
                                                 
                                                 
                                                 </div>
                                          
                                          
                                          </div>
                                     
                                     </div>
                                     
                                     <br>
                                     <br>
                                     
                                     
                               
                               
                               </div>
                       
                       
                       </div>
                       
                       <div class="col-xs-2">
                       
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
            
            
            var msg = new SpeechSynthesisUtterance("Cette notice sera enrichie au fur et à mesure en fonction de vos besoins.");
            
            var c = new SpeechSynthesisUtterance("N'hésitez pas d'envoyer un message via le bouton de bas de page pour toutes questions ou suggestions.");
            
            var d = new SpeechSynthesisUtterance("S'il vous plaît, excusez moi si je prononce mal des mots. Je fais de mon mieux pour vous assister. ");
            
            
            var msgu = new SpeechSynthesisUtterance("Je vous souhaite une excellente compréhension.");
            
            msg.lang="fr-FR";
            
            msgu.lang="fr-FR";
            
            c.lang="fr-FR";
            
          
            window.speechSynthesis.speak(msg);
            
            window.speechSynthesis.speak(c);
            
            window.speechSynthesis.speak(msgu);
            
            
            
            
            
            </script>
            
            
            
<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
       
       <script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
       <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
       
       
</body>
</html>