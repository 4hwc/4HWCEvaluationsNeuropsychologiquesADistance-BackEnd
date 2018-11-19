<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>


<%@ page import="java.util.ArrayList,java.util.*,java.io.*"%>
<%@ page session="false"%>




<!DOCTYPE html>
<html>

<head>

<title>ENAD</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Le but est de permettre à un médecin d'évaluer un patient et de voir les résultats des tests neuropsychologiques en temps réel.">
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


		<!-- Evaluations neuropsychologiques à distance -->

		<div class="row">

			<div class="col-xs-12">



				<div class="enad_ENAD">Evaluations Neuropsychologiques A
					Distance</div>


			</div>


		</div>

		<!-- Vidéo qui tourne en boucle -->

		<div class="row">

			<div class="col-xs-12">

				<div class="enad_background">





					<div class="choix_1">



						<a id="enad_a" class="btn-block" target="_blank"
							href="<c:url value="/inscription_connexion_Medecin"/>">Médecin</a>

					</div>

					<div class="choix_2">



						<a id="enad_a" class="btn-block" target="_blank"
							href="<c:url value="/inscription_connexion_Patient"/>">Patient(e)</a>

					</div>






					<video class="video" controls width="device-width" preload="auto"
						autoplay loop>

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



	</div>



<script type="text/javascript">

//SPEAK




var plusinfo = new SpeechSynthesisUtterance("Pour plusse d'informations, la notice est à votre disposition.");


var web = new SpeechSynthesisUtterance("Surtout, vous devez installer une extension sur votre navigateur si ce n'est pas fait.");

		
var notice = new SpeechSynthesisUtterance("S'il vous plaît, il faut consulter la notice pour mieux m'utiliser.");

var utilisateur = new SpeechSynthesisUtterance("Êtes vous un médecin ? Êtes vous un patient ou une patiente ? Faites votre choix en cliquant ! ");


plusinfo.lang='fr-FR';

web.lang='fr-FR';

notice.lang='fr-FR';

utilisateur.lang='fr-FR';






//window.speechSynthesis.speak(notice);

//window.speechSynthesis.speak(web);

//window.speechSynthesis.speak(plusinfo);

//window.speechSynthesis.speak(utilisateur);


function speak( text, onend ) {
	  window.speechSynthesis.cancel();
	  var ssu = new SpeechSynthesisUtterance( text );
	  ssu.lang = 'fr-FR';
	  window.speechSynthesis.speak( ssu );
	  function _wait() {
	    if ( ! window.speechSynthesis.speaking ) {
	      onend();
	      return;
	    }
	    window.setTimeout( _wait, 1000 );
	  }
	  _wait();
	}



	function doit() {
		  speak( "Êtes vous un médecin ? Êtes vous un patient ou une patiente ? Faites votre choix en cliquant ! ", function() { console.log( 'done' ); } );

		 

		}



	


</script>



	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	<script src="<c:url value="/inc/jquery-3.1.0.js"/>"></script>
	<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>

</body>
</html>

