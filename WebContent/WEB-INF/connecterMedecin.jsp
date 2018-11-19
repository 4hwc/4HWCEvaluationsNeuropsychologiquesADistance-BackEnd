<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>

<%@ page
	import="java.util.Map,java.util.HashMap,enad.beans.Medecin,enad.forms.ConnexionMedecinForm"%>
<!DOCTYPE html >
<html>
<head>

<title>Connexion du médecin</title>



<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Le but est de permettre à un médecin de se connecter.">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

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

<script>

//API FILE PRESENT ?
//if (window.File && window.FileReader && window.FileList && window.Blob) {
//alert("File API supported.!");
//} else {
//alert('The File APIs are not fully supported in this browser.');
// }
</script>

	<div class="container">
	
	<c:import url="/inc/verificationNavigateur.jsp" />

		<c:import url="/inc/enadnotice.jsp" />


		<div class="row">

			<div class="col-xs-12">

				<div class="enad_ENAD">Connexion du médecin</div>

			</div>


		</div>

		<div class="row">

			<div class="col-xs-12">

				<div class="enad_con_med">

					<form method="post" class="col-xs-12 well"
						action="<c:url value="/connexion_Medecin"/>">

						<fieldset>

							<br />

							<div class="form-group">

								<p class="titres_con_medecin">Identifiant du médecin</p>

								<label for="identifiantMedecin"></label> <input
									class="form-control input-lg" type="text"
									id="identifiantMedecin" name="identifiantMedecin"
									placeholder="S'il vous plaît, veuillez saisir votre identifiant choisi à l'inscription. Merci pour votre compréhension."
									value="<c:out value="${medecin.identifiant_medecin }"/>"
									required />

								<c:if test="${! empty form.erreurs['identifiantMedecin'] }">

									<br />

									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${form.erreurs['identifiantMedecin'] }</p>
									</div>


								</c:if>
							</div>

							<br />

							<div class="form-group">

								<p class="titres_con_medecin">Mot de passe du médecin</p>

								<label for="mdpMedecin"></label> <input
									class="form-control input-lg" type="password" id="mdpMedecin"
									name="mdpMedecin"
									placeholder="S'il vous plaît, veuillez saisir votre mot de passe choisi à l'inscription. Merci pour votre compréhension."
									value="" required />

								<c:if test="${! empty form.erreurs['mdpMedecin'] }">

									<br />

									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${form.erreurs['mdpMedecin'] }</p>

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
									href="<c:url value="/oubli_Motdepasse"/>"><span
									class="glyphicon glyphicon-search"></span> <br />J'ai oublié
									mon mot de passe. Ainsi, je souhaite saisir un nouveau mot de
									passe. </a> <br /> <br /> <a
									class="btn btn-danger btn-lg btn-block "
									href="<c:url value="/inscription_Medecin"/>"><span
									class="glyphicon glyphicon-info-sign"></span> <br />Je
									m'inscris avant de me connecter.</a> <br /> <br />

								<button class="btn btn-success btn-lg btn-block " type="submit">
									<span class="glyphicon glyphicon-log-in"></span>
									<h4>Je me connecte en tant que médecin.</h4>
								</button>
							</div>

							<c:if test="${! empty form.resultat}">

								<br />

								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>
									
									<c:if test="${ form.resultat eq echec}">
									
									<script type="text/javascript">
         
         var plusinfo = new SpeechSynthesisUtterance("Échec de la connexion");
         
         plusinfo.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinfo);

         
         </script>
									
									</c:if>

									<p>${form.resultat}</p>
									
									
									
									

								</div>
							</c:if>




						</fieldset>
					</form>
				</div>

			</div>

		</div>


		<br /> <br />






		<!-- Importer footer car il ne varie pas -->

		<c:import url="/inc/footer.jsp" />

	</div>

	<script>

$(function(){
	
	$(".close").click(function(){
		$(".alert").hide("slow");
	});
	
	
});

</script>

	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>


</body>

</html>