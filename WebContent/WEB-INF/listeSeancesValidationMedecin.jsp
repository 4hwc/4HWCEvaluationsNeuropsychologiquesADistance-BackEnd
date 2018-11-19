<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
    
<!DOCTYPE html >
<html>
<head>

<title>Liste des séances en attente de validation</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Liste des séances en attente de validation">
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

<script>

$(document).ready(function(){
	
	function init (){
		   
		$(window).load(function() {
			 $("body").load('/enad/liste_seances_validation_Medecin');
				  
			
		  var refreshId = setInterval(function() {
		     $("body").load('/enad/liste_seances_validation_Medecin');
		   	  
		     
		  }, 1000);
		  $.ajaxSetup({ cache: false });
		});
		   
		   
	   }
	
	
	
});

   

</script>

</head>
<body onload="init()">

<div class="container" id="responsecontainer">

                <c:import url="/inc/enadnotice.jsp"/>
                
                <div class="row">
                
                       <div class="col-xs-12">
                       
                                 <div class="enad_ENAD">
                                 
                                 Liste des séances en attente de validation
                                 
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
                
                      <div class="validees">
                      
                      
                               <c:if test="${  empty seances }">
                               
                               
                                     <div class="row zeroseancevalidation">
                                     
                                     Aucune séance en attente de validation
                                     
                                     <script type="text/javascript">
										
										var msgy = new SpeechSynthesisUtterance("Aucune séance en attente de validation");
										
										msgy.lang = 'fr-FR';
												
											
                                        window.speechSynthesis.speak(msgy);
                                        
										
										</script>
                                     
                                     
                                     </div>
                               
                               
                               
                               </c:if>
                               
                               
                               <c:if test="${ ! empty seances }">
                               
                               
                                        <div class="row totalseancesvalidation">
                                        
                                        TOTAL : ${seances.size() }
                                        
                                        
                                        
                                        </div>
                                        
                                        <c:if test="${seances.size()==1 }">
                                        
                                        <script type="text/javascript">
										
										var msgqw = new SpeechSynthesisUtterance("J'ai trouvé une séance en attente de validation");
										
										msgqw.lang = 'fr-FR';
												
											
                                        window.speechSynthesis.speak(msgqw);
                                        
										
										</script>
                                        
                                        
                                        </c:if>
                                        
                                        <c:if test="${seances.size()>1 }">
                                        
                                        <script type="text/javascript">
										
										var msg = new SpeechSynthesisUtterance("J'ai trouvé ${seances.size() } séance en attente de validation");
										
										msg.lang = 'fr-FR';
												
											
                                        window.speechSynthesis.speak(msg);
                                        
										
										</script>
                                        
                                        
                                        </c:if>
                                        
                                        
                                        
                                        <br>
                                        <br>
                                        <br>
                                        
                                        
                                        <div class="row">
                                        
                                            <div class="row col-xs-12  table-responsive">
                                            
                                            
                                                 <table class="table table-bordered table-striped">
                                            
                                                  <tr class="danger">
                                                  
                                                      <th>N°</th>
                                                      
                                                      <th>Titre</th>
                                                      
                                                      <th>Date et heure de création</th>
                                                      
                                                      <th>Patient(e)</th>
                                                      
                                                      <th>Fiche détaillée</th>
                                                      
                                                      <th>Suppression</th>
                                                  
                                                  </tr>
                                                  
                                                  
                                                  <c:forEach  items="${ seances }" var="listedeseances" varStatus="boucle">
                                                  
                                                  
                                                    <tr>
                                                  
                                                       <td> <c:out value=" ${boucle.index +1 } "/> </td>
                                                       
                                                       
                                                       
                                                       <td> <c:out value="${listedeseances.titre_seance } "/> </td>
                                                       
                                                       <td> <c:out value="${listedeseances.date_heure_creation_seance } "/> </td>
                                                       
                                                       <td> <c:out value="${listedeseances.prenoms_noms_patient } "/> </td>
                                                       
                                                       <td> 
                                                       
                                                             <a data-toggle="modal" data-backdrop="false" href="#${boucle.index +1 }" class="btn btn-primary">Je Consulte.</a>
                                                             
                                                             <div class="modal fade" id="${boucle.index +1 }">
                                                             
                                                                  <div class="modal-dialog modal-lg">
                                                                  
                                                                       <div class="modal-content">
                                                                       
                                                                       
                                                                           <div class="modal-header">
                                                                           
                                                                                 <button type="button" class="close" data-dismiss="modal">X</button>
                                                                                 
                                                                                 <h4 class="modal-title">Plus d'informations</h4>
                                                                           
                                                                           
                                                                           
                                                                           </div>
                                                                           
                                                                           <div class="modal-body">
                                                                           
                                                                                 <table class="table table-bordered table-striped">
                                                                                 
                                                                                 
                                                                                    <tr class="danger">
                                                                                    
                                                                                        <th>Date de réalisation</th>
                                                                                        
                                                                                        <th>Heure de début</th>
                                                                                        
                                                                                        <th>Heure de fin</th>
                                                                                        
                                                                                        <th>Plan de séance</th>
                                                                                    
                                                                                    
                                                                                    
                                                                                    </tr>
                                                                                    
                                                                                    <tr>
                                                                                    
                                                                                          <td>Prévue pour  <c:out value="   ${listedeseances.affichage_date_realisation_seance } "/> </td>
                                                                                          
                                                                                          <td> <c:out value="${listedeseances.heure_realisation_seance } "/> </td>
                                                                                          
                                                                                          <td> <c:out value="${listedeseances.heure_fin_seance } "/> </td>
                                                                                          
                                                                                          <td> <c:out value="${listedeseances.plan_seance} "/> </td>
                                                                                    
                                                                                    
                                                                                    
                                                                                    </tr>
                                                                                 
                                                                                 
                                                                                 </table>
                                                                                 
                                                                                 <br>
                                                                                 <br>
                                                                                 <br>
                                                                                 
                                                                                 
                                                                                 
                                                                           
                                                                           </div>
                                                                           
                                                                           
                                                                           <div class="modal-footer">
                                                                           
                                                                           
                                                                           
                                                                                <button class="btn btn-info" data-dismiss="modal">Fermer</button>
                                                                           
                                                                           
                                                                           
                                                                           </div>
                                                                       
                                                                       
                                                                       
                                                                       </div>
                                                                  
                                                                  
                                                                  </div>
                                                             
                                                             
                                                             
                                                             </div>
                                                             
                                                             
                                                             
                                                              
                                                       
                                                       
                                                       </td>
                                                       
                                                       <td>
                                                       
                                                        
                                                        
                                                        <a data-toggle="modal" data-backdrop="false" href="#supp${boucle.index +1 }" class="btn btn-primary">Je supprime la séance.</a>
                                                             
                                                             <div class="modal fade" id="supp${boucle.index +1 }">
                                                             
                                                                  <div class="modal-dialog modal-lg">
                                                                  
                                                                       <div class="modal-content">
                                                                       
                                                                       
                                                                           <div class="modal-header">
                                                                           
                                                                                 <button type="button" class="close" data-dismiss="modal">X</button>
                                                                                 
                                                                                 <h4 class="modal-title">Avertissement</h4>
                                                                           
                                                                           
                                                                           
                                                                           </div>
                                                                           
                                                                           <div class="modal-body">
                                                                           
                                                                           Voulez-vous vraiment supprimer la séance ? Attention la suppression est irréversible !!!
                                                                           
                                                                           <br>
                                                                           <br>
                                                                           <br>
                                                                           
                                                                           <a class="btn btn-danger btn-lg btn-block " href="<c:url value="/suppressionSeance?idSeance=${listedeseances.id_seance }&page=${destinationapressuppression}"/>"><span class="glyphicon glyphicon-remove-circle"></span> <br/>Je supprime cette séance.</a>
                                                                           
                                                                           
                                                                           
                                                                           
                                                                           </div>
                                                                           
                                                                           
                                                                           <div class="modal-footer">
                                                                           
                                                                           
                                                                           
                                                                                <button class="btn btn-info" data-dismiss="modal">J'annule la suppression.</button>
                                                                           
                                                                           
                                                                           
                                                                           </div>
                                                                       
                                                                       
                                                                       
                                                                       </div>
                                                                  
                                                                  
                                                                  </div>
                                                             
                                                             
                                                             
                                                             </div>
                                                             
                                                        
                                                        
                                                         </td> 
                                                       
                                                     
                                                  </tr>
                                                 
                                                  </c:forEach>
                                                 
                                            
                                            </table>
                                        
                                            
                                            </div>
                                        
                                        
                                            
                                        </div>
                               
                               
                               
                               
                               
                               </c:if>
                      
                      
                             
                      
                      
                      
                      
                      </div>
                
                    
                </div>
                
                <!-- NOTIFS  -->
                
                <c:import url="/inc/notifsmed.jsp"/>
                
                </div>
                
                <br>
                <br>
                <br>
                <br>
                
                <!-- Importer footer car il ne varie pas -->
                
                <c:import url="/inc/footer.jsp"/>
</div>

</body>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>







</html>