<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<!DOCTYPE html>
<html>
<head>
<title>Création de séances</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Création de séances">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet" />

<link href="<c:url value="/inc/jquery-ui/jquery-ui.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/jquery.timepicker.css"/>"
	rel="stylesheet" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->



</head>
<body>

	<div class="container">

		<c:import url="/inc/enadnotice.jsp" />

		<div class="row">

			<div class="col-xs-12">

				<div class="enad_ENAD">Création de séances</div>


			</div>


		</div>

		<br>

		<c:import url="/inc/presentationMedecin.jsp" />

		<br>

		<!-- MENU + CONTACTS + NOTIFS -->

		<div class="row">

			<!-- CONTACTS -->


			<c:import url="/inc/contactsmed.jsp" />


			<!-- MENU -->

			<div class="col-xs-8">

				<div class="enad_creer_seances">

					<form method="post" class="col-xs-12 well"
						action="<c:url value="/creation_seances_Medecin"/>">


						<fieldset>

							<br>
							<c:if test="${ ! empty patients || creationseance eq 'creationseance' }">

								<div class="form-group">

									<p class="titres_ins_medecin">Titre de séance</p>

									<label for="titreSeance"></label> <input
										class="form-control input-lg" type="text" id="titreSeance"
										name="titreSeance"
										placeholder="S'il vous plaît, veuillez saisir le titre de la séance. Merci pour votre compréhension."
										value="<c:out value="${seance.titre_seance }"/>" required />

									<c:if test="${! empty form.erreurs['titreSeance'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['titreSeance'] }</p>

										</div>


									</c:if>
								</div>

							</c:if>



							<br>

							<c:if test="${ ! empty patients || creationseance eq 'creationseance' }">

								<div class="form-group">

									<p class="titres_ins_medecin">Plan de séance</p>

									<label for="planSeance"></label>



									<textarea class="form-control input-lg" id="planSeance"
										name="planSeance"
										placeholder="S'il vous plaît, veuillez saisir le plan de la séance. Merci pour votre compréhension." 
										required rows="10" cols="50">   <c:out value="${seance.plan_seance }"/></textarea>

									<c:if test="${! empty form.erreurs['planSeance'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['planSeance'] }</p>

										</div>


									</c:if>

								</div>

							</c:if>



							<br>

							<c:if test="${  empty patients }">
							
							      <c:if test="${  empty form }">
							      
							      <div class="modal fade" id="modalzeropat" role="dialog" aria-labelledby="modalzeropatLabel" aria-hidden="true">
							      
							             
							             <div class="modal-dialog modal-lg">
							             
							             
							                     <div class="modal-content">
							                     
							                     
							                           <div class="modal-header">
							                           
							                           <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
							                           
							                           <h6 class="modal-title">Impossible pour vous de créer une séance.</h6>
							                           
							                           
							                           </div>
							                           
							                           <div class="modal-body well">
							                           
							                                <div class="row">
							                                
							                                     <div class="col-xs-12">
							                                     
							                                          <div class="enad_ins_pat">
							                                          
							                                               <div class="form-group">

									<p class="titres_ins_medecin">Il vous est impossible de
										créer une séance car vous n'avez aucune relation avec les
										patient(e)s.</p>
										
										<script type="text/javascript">
										
										var msgy = new SpeechSynthesisUtterance("Il vous est impossible de créer une séance car vous n'avez aucune relation avec les patients.");
												
											
                                        window.speechSynthesis.speak(msgy);
                                        
										
										</script>


								</div>
							                                          
							                                          
							                                          </div>
							                                     
							                                     
							                                     </div>
							                                
							                                
							                                
							                                </div>
							                           
							                           
							                           
							                           </div>
							                     
							                     
							                     
							                     </div>
							             
							             
							             
							             </div>
							          
							      
							      </div>
							      
							      
							      
							      
							      
							      </c:if>

								



							</c:if>
							
							
							<c:if test="${  empty patients }">
							
							
							      <c:if test="${  empty form }">
							      
							      <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

	

	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
	
	
	<script type="text/javascript">
	
	
	$(window).load(function(){
		
		$('#modalzeropat').modal('show');
		
		
	});
	
	
	
	
	</script>
							      
							      
							      
							      </c:if>
							
							
							</c:if>
							
							
							

							<c:if test="${ ! empty patients || creationseance eq 'creationseance' }">

								<div class="form-group">

									<p class="titres_ins_medecin">Choix du patient ou de la patiente</p>

									<label for="choixPatient"></label> <select name="choixPatient"
										id="choixPatient" class="form-control input-lg" required>

										<c:forEach items="${ patients }" var="listedepatients">

											<option value="${listedepatients.identifiant_patient }">${listedepatients.prenoms_patient }
												${listedepatients.noms_patient }</option>

										</c:forEach>

									</select>

									<c:if test="${! empty form.erreurs['choixPatient'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['choixPatient'] }</p>

										</div>


									</c:if>


								</div>

							</c:if>



							<br>

							<c:if test="${ ! empty patients || creationseance eq 'creationseance' }">

								<div class="form-group">

									<p class="titres_ins_medecin">Choix de la date</p>

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

									<label for="choixDate"></label> <input
										class="form-control input-lg" type="text" id="choixDate"
										name="choixDate" value="" maxlength="0"
										placeholder="S'il vous plaît, veuillez sélectionner la date de la séance  en utilisant le calendrier. Merci pour votre compréhension." value="<c:out value="${seance.date_realisation_seance }"/>"
										required />


									<c:if test="${! empty form.erreurs['choixDate'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['choixDate'] }</p>

										</div>


									</c:if>

								</div>

								<br>

								<div class="form-group">

									<p class="titres_ins_medecin">Choix de l'heure de début
										entre 0 et 23</p>



									<label for="choixHeureDebut"></label> <input
										class="form-control input-lg" type="number"
										id="choixHeureDebut" name="choixHeureDebut" min="0" max="23"
										placeholder="S'il vous plaît, veuillez saisir ou choisir l'heure de début. Merci pour votre compréhension."
										required />

									<c:if test="${! empty form.erreurs['choixHeureDebut'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['choixHeureDebut'] }</p>

										</div>


									</c:if>



								</div>

								<br>

								<div class="form-group">

									<p class="titres_ins_medecin">Choix de la minute de début
										entre 0 et 59</p>

									<label for="choixMinDebut"></label> <input
										class="form-control input-lg" type="number" id="choixMinDebut"
										name="choixMinDebut" min="0" max="59"
										placeholder="S'il vous plaît, veuillez saisir ou choisir la minute de début. Merci pour votre compréhension."
										required />



								</div>



								<br>

								<div class="form-group">

									<p class="titres_ins_medecin">Choix de l'heure de fin entre
										0 et 23</p>



									<label for="choixHeureFin"></label> <input
										class="form-control input-lg" type="number" id="choixHeureFin"
										name="choixHeureFin" min="0" max="23"
										placeholder="S'il vous plaît, veuillez saisir ou choisir l'heure de fin. Merci pour votre compréhension."
										required />

									<c:if test="${! empty form.erreurs['choixHeureFin'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['choixHeureFin'] }</p>

										</div>


									</c:if>

								</div>

								<br>

								<div class="form-group">

									<p class="titres_ins_medecin">Choix de la minute de fin
										entre 0 et 59</p>

									<label for="choixMinFin"></label> <input
										class="form-control input-lg" type="number" id="choixMinFin"
										name="choixMinFin" min="0" max="59"
										placeholder="S'il vous plaît, veuillez saisir ou choisir la minute de fin. Merci pour votre compréhension."
										required />



								</div>



								<br>

								<div class="form-group">

									<button class="btn btn-primary btn-lg btn-block " type="reset">
										<span class="glyphicon glyphicon-erase"></span>
										<h4>J'efface toutes les données du formulaire.</h4>
									</button>

									<br /> <br /> <a class="btn btn-warning btn-lg btn-block "
									href="<c:url value="/liste_seances_Medecin"/>"><span
									class="glyphicon glyphicon-info-sign"></span> <br />Oups ! Je souhaite
									accéder à la liste des séances.
									</a> <br /> <br />



									<button class="btn btn-success btn-lg btn-block " type="submit">
										<span class="glyphicon glyphicon-ok-sign"></span>
										<h4>Je crée une séance.</h4>
									</button>





								</div>

								<c:if test="${! empty form.resultat}">

									<br />



									<div class="alert alert-danger alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>
										
										<c:if test="${ form.resultat eq 'Échec de la création de la séance'}">
									
									<script type="text/javascript">
         
         var plusinfo = new SpeechSynthesisUtterance("Échec de la connexion");
         
         plusinfo.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinfo);

         
         </script>
									
									</c:if>

										<p>${form.resultat}</p>

									</div>


								</c:if>



							</c:if>




						</fieldset>






					</form>


				</div>


			</div>

			<!-- NOTIFS  -->

			<c:import url="/inc/notifsmed.jsp" />
		</div>


		<br> <br> <br>
		
		<br>
		
		<br>
		
		<br>





		<!-- Importer footer car il ne varie pas -->

		<c:import url="/inc/footer.jsp" />
	</div>

	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

	<script src="<c:url value="/inc/jquery.timepicker.js"/>"></script>

	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>

</body>
</html>