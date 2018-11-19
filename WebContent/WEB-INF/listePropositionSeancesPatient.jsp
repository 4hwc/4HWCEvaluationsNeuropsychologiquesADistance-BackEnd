<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html>
<html>
<head>

<title>Liste des propositions de séances</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Liste des propositions de séances">
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
                                 
                                 Liste des propositions de séances
                                 
                                 </div>
                       
                       </div>
                
                
                </div>
                
                <br>
                
                <c:import url="/inc/presentationPatient.jsp"/>
                
                <br>
                
                <!-- MENU + CONTACTS + NOTIFS -->
                
                <div class="row">
                
                <!-- CONTACTS -->
                
                <c:import url="/inc/contactspat.jsp"/>
                
                <!-- MENU -->
                
                <div class="col-xs-8">
                
                        <div class="propositions">
                        
                              <c:if test="${  empty propseances }">
                              
                                   <div class="row zeroseanceproposition">
                                     
                                     Aucune proposition de séance
                                     
                                     
                                     </div>
                                     
                                     <br>
                                     <br>
                                     
                                     
                                     <div class="row">
                                     
                                           <div class="enad_creer_seances">
                                           
                                           
                                       <form method="post" class="col-xs-12 well "  action="<c:url value="/creation_proposition_seances_patient"/>">
                                                                                                               
                                                                                                               
                                                                                                                             <fieldset>
                                                                                                                             
                                                                                                                             <input type="hidden" name="IdSeance" value="<c:out value="${idseance}"/>"/>
                                                                                                                             
                                                                                                                             
                                                                                                                                  <br>
                                                                                                                                  
                                                                                                                                  <div class="form-group">
                                                                                                                                  
                                                                                                                                        <p class="titres_ins_medecin"> Choix de la date </p>
                                              
                                                                                                                                        <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
                                              
                                                                                                                                        <script>
                                                                                                                                        
                                                                                                                                        $(function() {
                                                                                                                                        	   $( "#choixDate" ).datepicker({
                                                                                                                                        	       altField: "#choixDate",
                                                                                                                                        	       closeText: 'Fermer',
                                                                                                                                        	       prevText: 'Précédent',
                                                                                                                                        	       nextText: 'Suivant',
                                                                                                                                        	       currentText: 'Aujourd\'hui',
                                                                                                                                        	       monthNames: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
                                                                                                                                        	       monthNamesShort: ['Janv.', 'Févr.', 'Mars', 'Avril', 'Mai', 'Juin', 'Juil.', 'Août', 'Sept.', 'Oct.', 'Nov.', 'Déc.'],
                                                                                                                                        	       dayNames: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],
                                                                                                                                        	       dayNamesShort: ['Dim.', 'Lun.', 'Mar.', 'Mer.', 'Jeu.', 'Ven.', 'Sam.'],
                                                                                                                                        	       dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
                                                                                                                                        	       weekHeader: 'Sem.',
                                                                                                                                        	       firstDay: 1 ,
                                                                                                                                        	       dateFormat: 'd/m/yy',
                                                                                                                                        	       minDate:'+0d',
                                                                                                                                        	       showOtherMonths:true,
                                                                                                                                        	       selectOtherMonths:true,
                                                                                                                                        	       changeMonth:true,
                                                                                                                                        	       changeYear:true,
                                                                                                                                        	       numberOfMonths:4
                                                                                                                                        	       
                                                                                                                                        	       });
                                                                                                                                        	   });
                                                                                                                                        	   // var firstDay = $( "#datepicker" ).datepicker( "option", "firstDay" ); // marche pas
                                                                                                                                        	   // $( "#datepicker" ).datepicker( "option", "firstDay", 1 ); // premier jour à lundi
                                                                                                                                        	   // $.datepicker.setDefaults( $.datepicker.regional[ "fr" ] ); // texte en french marche pas
                                                                                                                                        	             $(function() {
                                                                                                                                        	               $( "#choixDate" ).datepicker();
                                                                                                                                        	             });  
                                                                                                                                        	   
                                                                                                                                           </script>
                                              
                                              
                                              
                                                                                                                                         <label for="choixDate"></label>
                                                                                                                                         <input class="form-control input-lg" type="text" id="choixDate" name="choixDate"  value="<c:out value="${propseance.date_realisation_seance_proposition }"/>"  placeholder="S'il vous plaît, veuillez sélectionner la date de la séance  en utilisant le calendrier. Merci pour votre compréhension." required />
                                              
                                              
                                                                                                                                  <c:if test="${! empty form.erreurs['choixDate'] }">
                                                                                                                                
                                                                                                                                
                                                                                                                                <br/>
                                                                                                                                <div class="alert alert-info alert-dismissable col-xs-12">
                                                                                                                 
                                                                                                                                   <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                                                                                 
                                                                                                                                   <p>${form.erreurs['choixDate'] }</p>
                                                                                                                 
                                                                                                                               </div>
                                                                                                                                
                                                                                                                                
                                                                                                                                </c:if>	
                                              
                                                                                                                                  
                                                                                                                                  
                                                                                                                                  </div>
                                                                                                                                  
                                                                                                                                  <br>
                                                                                                                                  
                                                                                                                                  
                                                                                                                                  <div class="form-group">
                                                                                                                                  
                                                                                                                                  
                                                                                                                                     <p class="titres_ins_medecin"> Choix de l'heure de début entre 0 et 23 </p>
                                              
                                              
                                              
                                                                                                                                     <label for="choixHeureDebut"></label>
                                                                                                                                     <input class="form-control input-lg" type="number" id="choixHeureDebut" name="choixHeureDebut" min="0" max="23" placeholder="S'il vous plaît, veuillez saisir ou choisir l'heure de début. Merci pour votre compréhension."   required />
                                              
                                                                                                                                 <c:if test="${! empty form.erreurs['choixHeureDebut'] }">
                                                                                                                                
                                                                                                                                
                                                                                                                                <br/>
                                                                                                                                <div class="alert alert-info alert-dismissable col-xs-12">
                                                                                                                 
                                                                                                                                   <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                                                                                 
                                                                                                                                   <p>${form.erreurs['choixHeureDebut'] }</p>
                                                                                                                 
                                                                                                                               </div>
                                                                                                                                
                                                                                                                                
                                                                                                                                </c:if>	
                                              
                                                                                                            
                                                                                                                                  
                                                                                                                                  </div>
                                                                                                                                  
                                                                                                                                  <br>
                                                                                                                                  
                                                                                                                                  <div class="form-group">
                                              
                                              <p class="titres_ins_medecin"> Choix de la minute de début entre 0 et 59 </p>
                                              
                                              <label for="choixMinDebut"></label>
                                              <input class="form-control input-lg" type="number" id="choixMinDebut" name="choixMinDebut" min="0" max="59"  placeholder="S'il vous plaît, veuillez saisir ou choisir la minute de début. Merci pour votre compréhension."  required />
                                              
                                              
                                              
                                              </div>
                                              
                                                                                                                             <br>
                                                                                                                             
                                                                                                                             <div class="form-group">
                                              
                                              <p class="titres_ins_medecin"> Choix de l'heure de fin entre 0 et 23 </p>
                                              
                                              
                                              
                                              <label for="choixHeureFin"></label>
                                              <input class="form-control input-lg" type="number" id="choixHeureFin" name="choixHeureFin" min="0" max="23" placeholder="S'il vous plaît, veuillez saisir ou choisir l'heure de fin. Merci pour votre compréhension."   required />
                                              
                                              <c:if test="${! empty form.erreurs['choixHeureFin'] }">
                                                                                                                                
                                                                                                                                
                                                                                                                                <br/>
                                                                                                                                <div class="alert alert-info alert-dismissable col-xs-12">
                                                                                                                 
                                                                                                                                   <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                                                                                 
                                                                                                                                   <p>${form.erreurs['choixHeureFin'] }</p>
                                                                                                                 
                                                                                                                               </div>
                                                                                                                                
                                                                                                                                
                                                                                                                                </c:if>	
                                              
                                              </div>
                                              
                                              <br>
                                              
                                              <div class="form-group">
                                              
                                              <p class="titres_ins_medecin"> Choix de la minute de fin entre 0 et 59 </p>
                                              
                                              <label for="choixMinFin"></label>
                                              <input class="form-control input-lg" type="number" id="choixMinFin" name="choixMinFin" min="0" max="59"  placeholder="S'il vous plaît, veuillez saisir ou choisir la minute de fin. Merci pour votre compréhension."  required />
                                              
                                              
                                              
                                              </div>
                                              
                                              
                                              <br>
                                              
                                              <div class="form-group">
                                            
                                            <button class="btn btn-primary btn-lg btn-block "  type="reset"><span class="glyphicon glyphicon-erase"></span><h4>J'efface toutes les données du formulaire.</h4></button>
                                                                                                                               
                                                                                                                               <br/>
                                                                                                                               <br/>
                                                                                                                               
                                                                                                                               
                                                                                                                               
                                                                                                                               <button class="btn btn-success btn-lg btn-block " type="submit"><span class="glyphicon glyphicon-ok-sign"></span><h4>Je propose une séance.</h4></button>
                                                                                                                               
                                                                                                                               
                                                                                                                               
                                                                                                                 
                                                                                                                               
                                            </div>
                                            
                                            <c:if test="${! empty form.resultat}">
                                                                                                                 
                                                                                                                 <br/>
                                                                                                                 
                                                                                                                 
                                                                                                                 
                                                                                                                 <div class="alert alert-danger alert-dismissable col-xs-12">
                                                                                                                 
                                                                                                                 <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                                                                                 
                                                                                                                 <p>${form.resultat}</p>
                                                                                                                 
                                                                                                                 </div>
                                                                                                                 
                                                                                                                 
                                                                                                                 </c:if>
                                    
                                                                                                  
                                                                                                                             
                                                                                                                             </fieldset>
                                                                                                               
                                                                                                               
                                                                                                               
                                                                                                               </form>    
                                           
                                           
                                           </div>
                                     
                                     
                                     </div>
                              
                              
                              
                              </c:if>
                              
                              <c:if test="${ ! empty propseances }">
                              
                                   <div class="row totalseancesproposition">
                                   
                                   TOTAL : ${propseances.size() }
                                   
                                   
                                   </div>
                                   
                                   <br>
                                   <br>
                                   <br>
                                   
                                   <div class="row">
                                   
                                         <div class="row col-xs-12  table-responsive">
                                         
                                         
                                                <table class="table table-bordered table-striped">
                                                
                                                   <tr class="danger">
                                                   
                                                          <th>Prénoms et noms</th>
                                                      
                                                          <th>Date de réalisation</th>
                                                      
                                                          <th>Heure de début</th>
                                                      
                                                          <th>Heure de fin</th>
                                                   
                                                   
                                                   
                                                   </tr>
                                                   
                                                   <c:forEach  items="${ propseances }" var="listedepropseances" varStatus="boucle">
                                                 
                                                 
                                                      <tr>
                                                      
                                                            <td> <c:out value="${listedepropseances.prenoms_noms_emission } "/> </td>
                                                            
                                                            <td> Prévue pour <c:out value="${listedepropseances.affichage_date_realisation_seance_proposition } "/> </td>
                                                            
                                                            <td> <c:out value="${listedepropseances.heure_realisation_seance_proposition } "/> </td>
                                                            
                                                            <td> <c:out value="${listedepropseances.heure_fin_seance_proposition } "/> </td>
                                                            
                                                            
                                                      
                                                      
                                                      </tr>
                                                 
                                                 
                                                 
                                                 </c:forEach>
                                            
                                                
                                                
                                                
                                                </table>
                                         
                                         
                                         
                                         </div>
                                   
                                   
                                   
                                   
                                   </div>
                                   
                                   <br>
                                        <br>
                                        <br>
                                        
                                        <div class="row col-xs-12">
                                        
                                             <a class="btn btn-primary btn-lg btn-block " data-toggle="modal" data-backdrop="false"  href="#formulaireprop"><span class="glyphicon glyphicon-erase"></span><br/>Je propose une séance.</a>
                                             
                                             <div class="modal fade" id="formulaireprop">
                                                                         
                                                                                  <div class="modal-dialog modal-lg">
                                                                                  
                                                                                        <div class="modal-content">
                                                                                        
                                                                                                <div class="modal-header">
                                                                                                
                                                                                                     <button type="button" class="close" data-dismiss="modal">X</button>
                                                                                                     
                                                                                                     <h4 class="modal-title">Votre proposition</h4>
                                                                                                
                                                                                                
                                                                                                
                                                                                                </div>
                                                                                                
                                                                                                <div class="modal-body">
                                                                                                
                                                                                                         <div class="enad_creer_seances">
                                                                                                         
                                                                                                         
                                                                                                               <form method="post" class="col-xs-12 well formpropositionspatient"  action="<c:url value="/creation_proposition_seances_patient"/>">
                                                                                                               
                                                                                                               
                                                                                                                             <fieldset>
                                                                                                                             
                                                                                                                             <input type="hidden" name="IdSeance" value="<c:out value="${idseance}"/>"/>
                                                                                                                             
                                                                                                                                  <br>
                                                                                                                                  
                                                                                                                                  <div class="form-group">
                                                                                                                                  
                                                                                                                                        <p class="titres_ins_medecin"> Choix de la date </p>
                                              
                                                                                                                                        <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
                                              
                                                                                                                                        <script>
                                                                                                                                        
                                                                                                                                        $(function() {
                                                                                                                                        	   $( "#choixDate" ).datepicker({
                                                                                                                                        	       altField: "#choixDate",
                                                                                                                                        	       closeText: 'Fermer',
                                                                                                                                        	       prevText: 'Précédent',
                                                                                                                                        	       nextText: 'Suivant',
                                                                                                                                        	       currentText: 'Aujourd\'hui',
                                                                                                                                        	       monthNames: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
                                                                                                                                        	       monthNamesShort: ['Janv.', 'Févr.', 'Mars', 'Avril', 'Mai', 'Juin', 'Juil.', 'Août', 'Sept.', 'Oct.', 'Nov.', 'Déc.'],
                                                                                                                                        	       dayNames: ['Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi', 'Samedi'],
                                                                                                                                        	       dayNamesShort: ['Dim.', 'Lun.', 'Mar.', 'Mer.', 'Jeu.', 'Ven.', 'Sam.'],
                                                                                                                                        	       dayNamesMin: ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
                                                                                                                                        	       weekHeader: 'Sem.',
                                                                                                                                        	       firstDay: 1 ,
                                                                                                                                        	       dateFormat: 'd/m/yy',
                                                                                                                                        	       minDate:'+0d',
                                                                                                                                        	       showOtherMonths:true,
                                                                                                                                        	       selectOtherMonths:true,
                                                                                                                                        	       changeMonth:true,
                                                                                                                                        	       changeYear:true,
                                                                                                                                        	       numberOfMonths:4
                                                                                                                                        	       
                                                                                                                                        	       });
                                                                                                                                        	   });
                                                                                                                                        	   // var firstDay = $( "#datepicker" ).datepicker( "option", "firstDay" ); // marche pas
                                                                                                                                        	   // $( "#datepicker" ).datepicker( "option", "firstDay", 1 ); // premier jour à lundi
                                                                                                                                        	   // $.datepicker.setDefaults( $.datepicker.regional[ "fr" ] ); // texte en french marche pas
                                                                                                                                        	             $(function() {
                                                                                                                                        	               $( "#choixDate" ).datepicker();
                                                                                                                                        	             });  
                                                                                                                                        	   
                                                                                                                                           </script>
                                              
                                              
                                              
                                                                                                                                         <label for="choixDate"></label>
                                                                                                                                         <input class="form-control input-lg" type="text" id="choixDate" name="choixDate"  value="<c:out value="${propseance.date_realisation_seance_proposition }"/>"  placeholder="S'il vous plaît, veuillez sélectionner la date de la séance  en utilisant le calendrier. Merci pour votre compréhension." required />
                                              
                                              
                                                                                                                                  <c:if test="${! empty form.erreurs['choixDate'] }">
                                                                                                                                
                                                                                                                                
                                                                                                                                <br/>
                                                                                                                                <div class="alert alert-info alert-dismissable col-xs-12">
                                                                                                                 
                                                                                                                                   <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                                                                                 
                                                                                                                                   <p>${form.erreurs['choixDate'] }</p>
                                                                                                                 
                                                                                                                               </div>
                                                                                                                                
                                                                                                                                
                                                                                                                                </c:if>	
                                              
                                                                                                                                  
                                                                                                                                  
                                                                                                                                  </div>
                                                                                                                                  
                                                                                                                                  <br>
                                                                                                                                  
                                                                                                                                  
                                                                                                                                  <div class="form-group">
                                                                                                                                  
                                                                                                                                  
                                                                                                                                     <p class="titres_ins_medecin"> Choix de l'heure de début entre 0 et 23 </p>
                                              
                                              
                                              
                                                                                                                                     <label for="choixHeureDebut"></label>
                                                                                                                                     <input class="form-control input-lg" type="number" id="choixHeureDebut" name="choixHeureDebut" min="0" max="23" placeholder="S'il vous plaît, veuillez saisir ou choisir l'heure de début. Merci pour votre compréhension."   required />
                                              
                                                                                                                                 <c:if test="${! empty form.erreurs['choixHeureDebut'] }">
                                                                                                                                
                                                                                                                                
                                                                                                                                <br/>
                                                                                                                                <div class="alert alert-info alert-dismissable col-xs-12">
                                                                                                                 
                                                                                                                                   <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                                                                                 
                                                                                                                                   <p>${form.erreurs['choixHeureDebut'] }</p>
                                                                                                                 
                                                                                                                               </div>
                                                                                                                                
                                                                                                                                
                                                                                                                                </c:if>	
                                              
                                                                                                            
                                                                                                                                  
                                                                                                                                  </div>
                                                                                                                                  
                                                                                                                                  <br>
                                                                                                                                  
                                                                                                                                  <div class="form-group">
                                              
                                              <p class="titres_ins_medecin"> Choix de la minute de début entre 0 et 59 </p>
                                              
                                              <label for="choixMinDebut"></label>
                                              <input class="form-control input-lg" type="number" id="choixMinDebut" name="choixMinDebut" min="0" max="59"  placeholder="S'il vous plaît, veuillez saisir ou choisir la minute de début. Merci pour votre compréhension."  required />
                                              
                                              
                                              
                                              </div>
                                              
                                                                                                                             <br>
                                                                                                                             
                                                                                                                             <div class="form-group">
                                              
                                              <p class="titres_ins_medecin"> Choix de l'heure de fin entre 0 et 23 </p>
                                              
                                              
                                              
                                              <label for="choixHeureFin"></label>
                                              <input class="form-control input-lg" type="number" id="choixHeureFin" name="choixHeureFin" min="0" max="23" placeholder="S'il vous plaît, veuillez saisir ou choisir l'heure de fin. Merci pour votre compréhension."   required />
                                              
                                              <c:if test="${! empty form.erreurs['choixHeureFin'] }">
                                                                                                                                
                                                                                                                                
                                                                                                                                <br/>
                                                                                                                                <div class="alert alert-info alert-dismissable col-xs-12">
                                                                                                                 
                                                                                                                                   <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                                                                                 
                                                                                                                                   <p>${form.erreurs['choixHeureFin'] }</p>
                                                                                                                 
                                                                                                                               </div>
                                                                                                                                
                                                                                                                                
                                                                                                                                </c:if>	
                                              
                                              </div>
                                              
                                              <br>
                                              
                                              <div class="form-group">
                                              
                                              <p class="titres_ins_medecin"> Choix de la minute de fin entre 0 et 59 </p>
                                              
                                              <label for="choixMinFin"></label>
                                              <input class="form-control input-lg" type="number" id="choixMinFin" name="choixMinFin" min="0" max="59"  placeholder="S'il vous plaît, veuillez saisir ou choisir la minute de fin. Merci pour votre compréhension."  required />
                                              
                                              
                                              
                                              </div>
                                              
                                              
                                              <br>
                                              
                                              <div class="form-group">
                                            
                                            <button class="btn btn-primary btn-lg btn-block "  type="reset"><span class="glyphicon glyphicon-erase"></span><h4>J'efface toutes les données du formulaire.</h4></button>
                                                                                                                               
                                                                                                                               <br/>
                                                                                                                               <br/>
                                                                                                                               
                                                                                                                               
                                                                                                                               
                                                                                                                               <button class="btn btn-success btn-lg btn-block " type="submit"><span class="glyphicon glyphicon-ok-sign"></span><h4>Je propose une séance.</h4></button>
                                                                                                                               
                                                                                                                               
                                                                                                                               
                                                                                                                 
                                                                                                                               
                                            </div>
                                            
                                            <c:if test="${! empty form.resultat}">
                                                                                                                 
                                                                                                                 <br/>
                                                                                                                 
                                                                                                                 
                                                                                                                 
                                                                                                                 <div class="alert alert-danger alert-dismissable col-xs-12">
                                                                                                                 
                                                                                                                 <button type="button" class="close" data-dismiss="alert">&times;</button>
                                                                                                                 
                                                                                                                 <p>${form.resultat}</p>
                                                                                                                 
                                                                                                                 </div>
                                                                                                                 
                                                                                                                 
                                                                                                                 </c:if>
                                    
                                                                                                  
                                                                                                                             
                                                                                                                             </fieldset>
                                                                                                               
                                                                                                               
                                                                                                               
                                                                                                               </form>
                                                                                                         
                                                                                                         
                                                                                                         
                                                                                                         
                                                                                                         </div>
                                                                                                
                                                                                                
                                                                                                </div>
                                                                                                
                                                                                                
                                                                                                <div class="modal-footer">
                                                                                                
                                                                                                
                                                                                                <button class="btn btn-info" data-dismiss="modal">Fermer</button>
                                                                                                
                                                                                                
                                                                                                
                                                                                                
                                                                                                </div>
                                                                                        
                                                                                        
                                                                                        
                                                                                        </div>
                                                                                  
                                                                                  
                                                                                  </div>
                                                                         
                                                                         
                                                                         </div>
                                                                         
                                                                         
                                                                         
                                        
                                        
                                        <c:if test="${  ! empty sessionScope.sessionPatient.identifiant_patient }">
                                                                         
                                                                                <c:if test="${ ! empty identifiantemission }">
                                                                                
                                                                                       
                                                                                       <c:if test="${ egal eq 'non'   }">
                                                                                       
                                                                                       
                                                                                            
                                                                                              <c:if test="${ ! empty validation }">
                                                                                              
                                                                                              
                                                                                              
                                                                                              
                                                                                                        <c:if test="${  validation eq 'oui' }">
                                                                                                        
                                                                                                        
                                                                                                        
                                                                                                        
                                                                                                              <c:if test="${ ! empty idseance }">
                                                                                                              
                                                                                                                        <br>
                                                                                                                        <br>
                                                                                                
                                                                                                
                                                                                                                       <a class="btn btn-success btn-lg btn-block " href="<c:url value="/validation_proposition_seance_Patient?idseance=${  idseance }"/>"><span class="glyphicon glyphicon-ok-sign"></span><br/>Je valide la dernière proposition.</a>
                                                                                                
                                                                                                
                                                                                                              </c:if>
                                                                                                        
                                                                                                        
                                                                                                        </c:if>
                                                                                              
                                                                                              
                                                                                              
                                                                                              </c:if>
                                                                                       
                                                                                       
                                                                                                
                                                                                       
                                                                                       
                                                                                       
                                                                                               
                                                                                       
                                                                                       
                                                                                        
                                                                                       </c:if>
                                                                                
                                                                                
                                                                         
                                                                                </c:if>
                                                                         
                                                                         
                                                                         
                                                                         </c:if>
                                        
                                        
                                        </div>
                              
                              
                              </c:if>
                        
                        
                        </div>
                
                </div>
                
                <!-- NOTIFS  -->
                
                <c:import url="/inc/notifspat.jsp"/>
                
                </div>
                
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                
                
                <c:import url="/inc/footer.jsp"/>

</div>

</body>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>

</html>