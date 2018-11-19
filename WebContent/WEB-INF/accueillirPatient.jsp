<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<!DOCTYPE html>
<html>
<head>

<title><c:if test="${ ! empty sessionScope.sessionPatient }">

		<c:if test="${ sessionScope.sessionPatient.sexe_patient eq 'homme' }">
                     
                     Accueil du patient
                     
                     </c:if>

		<c:if test="${ sessionScope.sessionPatient.sexe_patient eq 'femme' }">
                     
                     Accueil de la patiente
                     
                     </c:if>

	</c:if></title>


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Page d'accueil du patient">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>" rel="stylesheet" />
	

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->

</head>
<body>

	<div class="container">
	
	
	
	<!-- <c:import url="/inc/verificationNavigateur.jsp" /> -->
	
	
	
	<c:if test="${  empty sessionScope.sessionPatient }">
	
	<script type="text/javascript">
	
	window.location='/enad/enad';
	
	//créer servlet spécial deconnexion après session expirée
	
	
	</script>
	
	
	</c:if>
	
	



		<c:import url="/inc/enadnotice.jsp" />

		<div class="row">

			<div class="col-xs-12">

				<div class="enad_ENAD">

					<c:if test="${ ! empty sessionScope.sessionPatient }">

						<c:if
							test="${ sessionScope.sessionPatient.sexe_patient eq 'homme' }">
                     
                     Accueil du patient
                     
                     </c:if>

						<c:if
							test="${ sessionScope.sessionPatient.sexe_patient eq 'femme' }">
                     
                     Accueil de la patiente
                     
                     </c:if>

					</c:if>



				</div>

			</div>


		</div>

		<br>


		<c:import url="/inc/presentationPatient.jsp" />

		<br>

		<!-- MENU + CONTACTS + NOTIFS -->

		<div class="row">



			<!-- CONTACTS -->

			<c:import url="/inc/contactspat.jsp" />

			<!-- MENU -->

			<div class="col-xs-8">

				<div class="menumed">
				
				<c:if test="${  empty seances }">
				
				      <div class="modal fade" id="modalzeropat" role="dialog" aria-labelledby="modalzeropatLabel" aria-hidden="true">
				      
				              <div class="modal-dialog modal-lg">
				              
				                    <div class="modal-content">
				                    
				                         <div class="modal-header">
				                         
				                             <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                             <h2 class="modal-title">Liste de séances du jour vide </h2>
									                 
				                         
				                         
				                         </div>
				                         
				                         <div class="modal-body well">
				                         
				                             <div class="row">
				                             
				                                  <div class="col-xs-12">
				                                  
				                                       <div class="enad_ins_pat">
				                                       
				                                            <div class="form-group">
				                                            
				                                                 <p class="titres_ins_medecin">
				                                                                        
				                                                     Liste de séances du jour vide 
										
										                         </p>
				                                            
				                                            </div>
				                                       
				                                       
				                                       </div>
				                                  
				                                  
				                                  </div>
				                             
				                             
				                             </div>
				                         
				                         </div>
				                         
				                         <div class="modal-footer">
				                                      
				                                      <button class="btn btn-info" data-dismiss="modal">Fermer</button>
				                                      
				                                      
				                         </div>
				                    
				                    
				                    </div>
				              
				              
				              </div>
				      
				      
				      </div>
				
				
				</c:if>
				
				<c:if test="${  ! empty seances }">
				
				    <div class="modal fade" id="modalzeropat" role="dialog" aria-labelledby="modalzeropatLabel" aria-hidden="true">
				    
				            <div class="modal-dialog modal-lg">
				            
				                          <div class="modal-content">
				                          
				                          
				                               <div class="modal-header">
				                               
				                                   <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                  <h2 class="modal-title">Liste de séances du jour </h2>
									                 
				                               
				                               </div>
				                               
				                               
				                               <div class="modal-body">
				                               
				                               
                                
                                     <div class="row totalseancesvalidees">
                                     
                                     TOTAL : ${seances.size() }
                                     
                                     </div>
                                     
                                     <br>
                                     <br>
                                     <br>
                                     
                                     <div class="row validees">
                                     
                                         <div class="row col-xs-12  table-responsive">
                                         
                                              <table class="table table-bordered table-striped">
                                           
                                                  <tr class="danger">
                                                  
                                                        <th>N°</th>
                                                        
                                                        <th>Titre</th>
                                                        
                                                        <th>Date et heure de création</th>
                                                      
                                                        <th>Médecin</th>
                                                      
                                                        <th>Fiche détaillée</th>
                                                      
                                                        
                                                  
                                                  
                                                  
                                                  </tr>
                                                  
                                                  <c:forEach  items="${ seances }" var="listedeseances" varStatus="boucle">
                                                  
                                                      <tr>
                                                      
                                                          <td> <c:out value=" ${boucle.index +1 } "/> </td>
                                                       
                                                       
                                                       
                                                          <td> <c:out value="${listedeseances.titre_seance } "/> </td>
                                                       
                                                          <td> <c:out value="${listedeseances.date_heure_creation_seance } "/> </td>
                                                       
                                                           <td> <c:out value="${listedeseances.prenoms_noms_medecin } "/> </td>
                                                           
                                                           <td>
                                                           
                                                                 <a data-toggle="modal" data-backdrop="false" href="#${boucle.index +1 }" class="btn btn-primary">Consulter</a>
                                                             
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
                                                                                          
                                                                                                    <td> <c:out value="${listedeseances.plan_seance } "/> </td>
                                                                                    
                                                                                                
                                                                                                </tr>
                                                                                        
                                                                                        
                                                                                        </table>
                                                                                    
                                                                                    </div>
                                                                                    
                                                                                    <div class="modal-footer">
                                                                                    
                                                                                             <button class="btn btn-info" data-dismiss="modal">Fermer</button>
                                                                                    
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
                                
                                
                                
				                               
				                               
				                               
				                               
				                               </div>
				                               
				                               <div class="modal-footer">
				                                      
				                                      <button class="btn btn-info" data-dismiss="modal">Fermer</button>
				                                      
				                                      
				                                </div>
				                          
				                          
				                          
				                          </div>
				                          
				                          
				                          
				                          
				                          
				            
				            
				            </div>
				    
				    </div>
				
				
				</c:if>
				
				<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

	

	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
	
	
	<script type="text/javascript">
	
	
	$(window).load(function(){
		
		$('#modalzeropat').modal('show');
		
		
	});
	
	
	
	
	</script>



					<div class="row">

						<div class="col-xs-12 ">

							<div class="boutonseancespat">


								<a class="btn-block buttonsmenu"
									href="<c:url value="/seances_Patient"/>"><i
									class="fa fa-calendar"></i><br />Agenda</a>





							</div>



						</div>

					</div>

					<br /> 
					
					<c:if test="${ clic_med_dessin_recopier eq 'oui'   }">
					
					<br>
					
					<div class="row">
					
					    <div class="col-xs-12">
					    
					        <div class="boutoncarnetdesantepat">
					        
					            <a class="btn-block buttonsmenu" class="btn-block" target="_blank"
									href="<c:url value="/realisation_dessin_recopier_mmse?identifiantpatient=${sessionScope.sessionPatient.identifiant_patient}&identifiantmedecin=${identifiantmed_dessin_recopier}&id_aleatoire=${idaleatoire_dessin_recopier}"/>">
									<br />Je recopie le dessin.</a>
					                      
					        
					        
					        </div>
					    
					    </div>
					
					</div>
					
					<br>
					
					
					</c:if>
					
					<c:if test="${ clic_med_phrase_ecrire eq 'oui'   }">
					
					<br>
					
					<div class="row">
					
					    <div class="col-xs-12">
					    
					        <div class="boutoncarnetdesantepat">
					        
					            <a class="btn-block buttonsmenu" class="btn-block" target="_blank"
									href="<c:url value="/realisation_phrase_ecrire_mmse?identifiantpatient=${sessionScope.sessionPatient.identifiant_patient}&identifiantmedecin=${identifiantmed_phrase_ecrire}&id_aleatoire=${idaleatoire_phrase_ecrire}"/>">
									<br />J'écris ma phrase.</a>
					                      
					        
					        
					        </div>
					    
					    </div>
					
					</div>
					
					<br>
					
					
					</c:if>

					

					
					
					<c:if test="${ clic_med_fcro eq 'oui'   }">
					
					        <br>
					       
					       <div class="row">
					       
					               <div class="col-xs-12">
					               
					                      <div class="boutoncarnetdesantepat">
					                      
					                      <a class="btn-block buttonsmenu" class="btn-block" target="_blank"
									href="<c:url value="/realisation_fcro?identifiantpatient=${seance_fcro.identifiant_patient }&identifiantmedecin=${seance_fcro.identifiant_medecin }&identifiantutilisateur=${sessionScope.sessionPatient.identifiant_patient }&idseance=${seance_fcro.id_seance }"/>">
									<br />Je réalise la Figure Complexe de Rey-Osterrieth envoyée par le médecin ${seance_fcro.prenoms_noms_medecin } .</a>
					                      
					                      
					                      
					                      </div>
					               
					               
					               
					               </div>
					       
					       </div>
					       
					       <br>
					
					</c:if>
					
					 <br>
					 
					 <c:if test="${ clic_med_tm_un eq 'oui'   }">
					
					        <br>
					       
					       <div class="row">
					       
					               <div class="col-xs-12">
					               
					                      <div class="boutoncarnetdesantepat">
					                      
					                      <a class="btn-block buttonsmenu" class="btn-block" target="_blank"
									href="<c:url value="/realisation_tm_un?identifiantpatient=${seance_tm_un.identifiant_patient }&identifiantmedecin=${seance_tm_un.identifiant_medecin }&identifiantutilisateur=${sessionScope.sessionPatient.identifiant_patient }&idseance=${seance_tm_un.id_seance }"/>">
								<br />Je réalise le Trail Making Version 1  envoyé par le médecin ${seance_tm_un.prenoms_noms_medecin } .</a>
					                      
					                      
					                      
					                      </div>
					               
					               
					               
					               </div>
					       
					       </div>
					       
					       <br>
					       
					       
					
					</c:if>

                 <br>
                 
                 <c:if test="${ clic_med_tm_deux eq 'oui'   }">
					
					        <br>
					       
					       <div class="row">
					       
					               <div class="col-xs-12">
					               
					                      <div class="boutoncarnetdesantepat">
					                      
					                      <a class="btn-block buttonsmenu" class="btn-block" target="_blank"
									href="<c:url value="/realisation_tm_deux?identifiantpatient=${seance_tm_deux.identifiant_patient }&identifiantmedecin=${seance_tm_deux.identifiant_medecin }&identifiantutilisateur=${sessionScope.sessionPatient.identifiant_patient }&idseance=${seance_tm_deux.id_seance }"/>">
									<br />Je réalise le Trail Making Version 2  envoyé par le médecin ${seance_tm_deux.prenoms_noms_medecin } .</a>
					                      
					                      
					                      
					                      </div>
					               
					               
					               
					               </div>
					       
					       </div>
					       
					       <br>
					       
					       
					
					</c:if>

                 <br>
				</div>



			</div>

			<!-- NOTIFS  -->

			<c:import url="/inc/notifspat.jsp" />



		</div>

		<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />











		<!-- Importer footer car il ne varie pas -->

		<c:import url="/inc/footer.jsp" />


	</div>
	
	<c:if test="${occurence_accueil == 1 }">
	
	<script type="text/javascript">


var msg = new SpeechSynthesisUtterance("bienvenue à l'accueil  ${sessionScope.sessionPatient.prenoms_patient } ${sessionScope.sessionPatient.noms_patient }  ");

msg.lang="fr-FR";
window.speechSynthesis.speak(msg);


</script>

<c:if test="${  empty seances }">

<script type="text/javascript">

var msgz = new SpeechSynthesisUtterance("Vous n'avez pas de séance pour ce jour. ");

msgz.lang="fr-FR";
window.speechSynthesis.speak(msgz);



</script>



</c:if>

<c:if test="${ ! empty seances }">

<script type="text/javascript">

var msgz = new SpeechSynthesisUtterance("Vous avez ${ seances.size() } séance pour ce jour. ");

msgz.lang="fr-FR";
window.speechSynthesis.speak(msgz);



</script>


</c:if>
	
	
	</c:if>
	
	

	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	
	<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>


</body>
</html>