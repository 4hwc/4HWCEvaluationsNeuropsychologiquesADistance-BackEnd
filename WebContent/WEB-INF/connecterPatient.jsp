<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<!DOCTYPE html >
<html>
<head>

<title>Connexion du patient ou de la patiente</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Le but est de permettre à un patient de se connecter.">
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

	<div class="container">
	
	<c:import url="/inc/verificationNavigateur.jsp" />

		<c:import url="/inc/enadnotice.jsp" />


		<!-- Patient -->

		<div class="row">

			<div class="col-xs-12">



				<div class="enad_ENAD">Connexion de la patiente ou du patient</div>


			</div>


		</div>

		<!-- Formulaire connexion patient -->

		<div class="row">

			<div class="col-xs-12">

				<div class="enad_con_pat well">

					<br> <a class="btn btn-primary btn-lg btn-block "
						target="_blank"
						href="<c:url value="/recherche_par_prenoms_noms_Patient"/>"><strong
						style="background-color: ; font-size: 2em;"><i class="fa fa-user" aria-hidden="true"></i></strong>
						<br />Je me connecte en utilisant la recherche par prénoms et
						noms.</a> <br /> <br /> <a class="btn btn-primary btn-lg btn-block "
						target="_blank"
						href="<c:url value="/recherche_par_identifiants_Patient"/>"><i
						class="fa fa-search"></i> <br />
					<br />Je me connecte en utilisant la recherche par identifiants.</a> <br />
					<br /> <a class="btn btn-danger btn-lg btn-block "
						href="<c:url value="/inscription_Patient"/>"><span
						class="glyphicon glyphicon-info-sign"></span> <br />Je m'inscris
						avant de me connecter.</a> <br /> <br />


				</div>

			</div>


		</div>


		<!-- Importer footer car il ne varie pas -->

		<c:import url="/inc/footer.jsp" />






	</div>
	
	<script type="text/javascript">

//SPEAK


	
	window.speechSynthesis.cancel();
	
	
	

var msg = new SpeechSynthesisUtterance('Pour vous aidez à guérir, ENAD vous facilite la connexion via deux options :');

var optionun = new SpeechSynthesisUtterance('Option une : Utilisez vos noms et prénoms pour que je vous connecte. ');

var optiondeux = new SpeechSynthesisUtterance('Option deux : Utilisez votre identifiant pour que je vous connecte');


var avis = new SpeechSynthesisUtterance('Je pense que l option une vous plaira');

msg.lang='fr-FR';

optionun.lang='fr-FR';

optiondeux.lang='fr-FR';

avis.lang='fr-FR';







//window.speechSynthesis.speak(msg);

//window.speechSynthesis.speak(optionun);

//window.speechSynthesis.speak(optiondeux);

//window.speechSynthesis.speak(avis);




</script>
	
	

	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	<script src="<c:url value="/inc/jquery-3.1.0.js"/>"></script>
	<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>


</body>

</html>