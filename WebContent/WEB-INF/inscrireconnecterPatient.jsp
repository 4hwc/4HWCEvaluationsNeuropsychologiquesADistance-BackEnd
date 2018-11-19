<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<!DOCTYPE html >
<html>
<head>

<title>Inscription ou Connexion du patient ou de la patiente</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Le but est de permettre à un patient de s'inscrire ou de se connecter.">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->


<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
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

		<header class="row">

			<!-- Pour éviter l'empilement en passant sur un média plus grand -->




			<div class="col-xs-12">

				<!-- Bordure ENAD -->

				<div class="enad_notice">



					<a id="enad_a" class="btn-block" target="_blank"
						href="<c:url value="/notice"/>">NOTICE D'UTILISATION</a>



				</div>

			</div>

		</header>

		<!-- Patient -->

		<div class="row">

			<div class="col-xs-12">



				<div class="enad_ENAD">Patient(e)</div>


			</div>


		</div>

		<!-- Vidéo qui tourne en boucle -->

		<div class="row">

			<div class="col-xs-12">

				<div class="enad_background">





					<div class="choix_1">



						<a id="enad_a" class="btn-block"
							href="<c:url value="/inscription_Patient"/>">Inscription</a>

					</div>

					<div class="choix_2">



						<a id="enad_a" class="btn-block"
							href="<c:url value="/connexion_Patient"/>">Connexion</a>

					</div>






					<video class="video" width="device-width" preload="auto" autoplay
						loop>

						<source src="<c:url value="/inc/videoenad.mp4"/>" type="video/mp4" />
						<source src="<c:url value="/inc/videoenad.webm"/>"
							type="video/webm" />
						<source src="<c:url value="/inc/videoenad.ogg"/>" type="video/ogg" />









					</video>






				</div>

			</div>


		</div>


		<!-- Importer footer car il ne varie pas -->

		<c:import url="/inc/footer.jsp" />
		
		<script type="text/javascript">

//SPEAK



var msg = new SpeechSynthesisUtterance('Inscription ou connexion ');




//window.speechSynthesis.speak(msg);




</script>
		






	</div>

	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>


</body>
</html>