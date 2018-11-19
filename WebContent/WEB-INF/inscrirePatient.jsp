<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<!DOCTYPE html >
<html>
<head>

<title>Inscription du patient ou de la patiente</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Le but est de permettre à un(e) patient(e) de s'inscrire.">
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


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->


</head>

<body>

	<div class="container">
	
	<c:import url="/inc/verificationNavigateur.jsp" />

		<c:import url="/inc/enadnotice.jsp" />




		<!-- Patient -->

		<div class="row">

			<div class="col-xs-12">



				<div class="enad_ENAD">Inscription de la patiente ou du patient</div>


			</div>


		</div>

		<!-- Carrousel_patient -->

		<!-- A faire plus tard avec la partie vocale -->

		<!-- Formulaire inscription patient -->

		<div class="row">

			<div class="col-xs-12">

				<div class="enad_ins_pat ">


					<form method="post" class="col-xs-12 well "
						action="<c:url value="/inscription_Patient"/>">

						<fieldset>


							<br />

							<div class="form-group">

								<p class="titres_ins_patient">Prénom(s) </p>

								<label for="prenomsPatient"></label> <input
									class="form-control input-lg" type="text" id="prenomsPatient"
									name="prenomsPatient"
									placeholder="S'il vous plaît, veuillez saisir votre prénom ou vos prénoms. Merci pour votre compréhension."
									value="<c:out value="${patient.prenoms_patient }"/>" />

								<c:if test="${! empty form.erreurs['prenomsPatient'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${form.erreurs['prenomsPatient'] }</p>

									</div>


								</c:if>

							</div>

							<br />

							<div class="form-group">

								<p class="titres_ins_patient">Nom(s) </p>

								<label for="nomsPatient"></label> <input
									class="form-control input-lg" type="text" id="nomsPatient"
									name="nomsPatient"
									placeholder="S'il vous plaît, veuillez saisir votre nom ou vos noms. Merci pour votre compréhension."
									value="<c:out value="${patient.noms_patient }"/>" required />

								<c:if test="${! empty form.erreurs['nomsPatient'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${form.erreurs['nomsPatient'] }</p>

									</div>


								</c:if>

							</div>

							<br />

							<div class="form-group">



								<p class="titres_ins_patient">Sexe </p>



								<label for="femme">Femme</label> <input type="radio" id="femme"
									name="sexe" value="femme" /> <label for="homme">Homme</label>
								<input type="radio" id="homme" name="sexe" value="homme" />

								<c:if test="${! empty form.erreurs['sexe'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${form.erreurs['sexe'] }</p>

									</div>


								</c:if>





							</div>

							<br />
							
							

							<div class="form-group">

								<p class="titres_ins_patient">Date de naissance </p>

								<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
								<script>
                                                                                                                               
                                                                                                                               $(function() {
                                                                                                                            	   $( "#datedenaissance" ).datepicker({
                                                                                                                            	       altField: "#datedenaissance",
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
                                                                                                                            	       maxDate:'+0d',
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
                                                                                                                            	               $( "#datedenaissance" ).datepicker();
                                                                                                                            	             });  
                                                                                                                            	   
                                                                                                                            	   
                                                                                                                            	   
                                                                                                                             
                                                                                                                               
                                                                                                                               
                                                                                                                            
                                                                                                                               </script>

								<label for="datedenaissance"></label> <input
									class="form-control input-lg" type="text" id="datedenaissance"
									name="datedenaissance" maxlength="0"
									value=" " 
									placeholder="S'il vous plaît, veuillez sélectionner votre date de naissance en utilisant le calendrier. Merci pour votre compréhension."
									required />

								<c:if test="${! empty form.erreurs['datedenaissance'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${form.erreurs['datedenaissance'] }</p>

									</div>


								</c:if>




							</div>

							<br />

							<div class="form-group">

								<p class="titres_ins_patient">Identifiant </p>

								<label for="identifiantPatient"></label>  <input
									class="form-control input-lg" type="text"
									id="identifiantPatient" name="identifiantPatient"
									placeholder="S'il vous plaît, veuillez saisir un identifiant unique pour recevoir un contenu qui vous est destiné. Merci pour votre compréhension."
									value="<c:out value="${patient.identifiant_patient }"/>"
									required />

								<c:if test="${! empty form.erreurs['identifiantPatient'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${form.erreurs['identifiantPatient'] }</p>

									</div>


								</c:if>

							</div>

							<br />

							<div class="form-group">

								<p class="titres_ins_patient">Confirmation de l'identifiant
									</p>

								<label for="confirmeidentifiantPatient"></label> <input
									class="form-control input-lg" type="text"
									id="confirmeidentifiantPatient"
									name="confirmeidentifiantPatient"
									placeholder="S'il vous plaît, veuillez confirmer votre identifiant en le saisissant de nouveau. Merci pour votre compréhension."
									value="<c:out value=""/>" required />

								<c:if
									test="${! empty form.erreurs['confirmeidentifiantPatient'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${form.erreurs['confirmeidentifiantPatient'] }</p>

									</div>


								</c:if>

							</div>

							<br /> <br />



							<div class="form-group">

								<button class="btn btn-primary btn-lg btn-block " type="reset">
									<span class="glyphicon glyphicon-erase"></span>
									<h4>J'efface toutes les données du formulaire.</h4>
								</button>

								<br /> <br /> <a class="btn btn-warning btn-lg btn-block "
									href="<c:url value="/connexion_Patient"/>"><span
									class="glyphicon glyphicon-info-sign"></span> <br />Mon
									inscription est déjà faite. Alors, je me connecte en tant que
									patient(e).</a> <br /> <br />


								<button class="btn btn-success btn-lg btn-block " type="submit">
									<span class="glyphicon glyphicon-ok-sign"></span>
									<h4>Je m'inscris en tant que patient(e).</h4>
								</button>



							</div>

							<c:if test="${! empty form.resultat}">

								<br />



								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>
									
									<c:if test="${ form.resultat eq echec}">
									
									<script type="text/javascript">
         
         var plusinfo = new SpeechSynthesisUtterance("Échec de l'inscription");
         
         plusinfo.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinfo);

         
         </script>
									
									</c:if>

									<p>${form.resultat}</p>

								</div>


							</c:if>






						</fieldset>

						<br> <br>



					</form>









				</div>


			</div>


		</div>


		<br /> <br />















		<!-- Importer footer car il ne varie pas -->

		<c:import url="/inc/footer.jsp" />






	</div>
	
	<script type="text/javascript">
	
	window.speechSynthesis.cancel();
	
	
	</script>

	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>



</body>

</html>