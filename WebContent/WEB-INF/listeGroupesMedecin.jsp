<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html>
<html>
<head>
<title>Liste des groupes</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Liste des groupes">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png" href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/jquery-ui/jquery-ui.css"/>" rel="stylesheet"/>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->

</head>
<body>

<div class="container">

                <c:import url="/inc/enadnotice.jsp"/>
                
                <div class="row">
                
                       <div class="col-xs-12">
                       
                                 <div class="enad_ENAD">
                                 
                                 Liste des groupes
                                 
                                 </div>
                       </div>
                
                </div>
                
                <br>
                
                <c:import url="/inc/presentationMedecin.jsp"/>
                
                <br>
                
                <!-- MENU + CONTACTS + NOTIFS -->
                
                <div class="row">
                
                        <!-- CONTACTS -->
                        
                        <c:import url="/inc/contactsmed.jsp"/>
                        
                        <!-- MENU -->
                        
                        <div class="col-xs-8">
                        
                                  <div class="menumed">
                                  
                                          <div class="row">
                                          
                                                 <div class="col-xs-12 ">
                                                 
                                                           <div class="boutonseances">
                                                           
                                                                   <a class="btn-block buttonsmenu" href="<c:url value="/liste_seances_validation_Medecin"/>"><i class="fa fa-calendar"></i><br/>Liste des séances en attente de validation</a>
                                                           
                                                           </div>
                                                 
                                                 </div>
                                          
                                          
                                          </div>
                                          
                                          <br>
                                          <br>
                                          
                                          <div class="row">
                             
                                    <div class="col-xs-12 ">
                                    
                                           <div class="boutonseances">
                                           
                                                 <a class="btn-block buttonsmenu" href="<c:url value="/liste_seances_validees_Medecin"/>"><i class="fa fa-calendar"></i><br/>Liste des séances validées</a>
                                           
                                           
                                           </div>
                                    </div>
                             
                                     
                             </div>
                             
                             <br>
                             <br>
                                  
                                  
                                  </div>
                        
                        </div>
                        
                        <!-- NOTIFS  -->
                        
                        <c:import url="/inc/notifsmed.jsp"/>
                
                </div>
                
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                
                <!-- Importer footer car il ne varie pas -->
                
                <c:import url="/inc/footer.jsp"/>
                
</div>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>

</body>
</html>