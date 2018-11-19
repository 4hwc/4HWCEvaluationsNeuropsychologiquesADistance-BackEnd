<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>

<title>Bienvenue sur ENAD</title>

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

		<div class="row">

			<div class="col-xs-12">

				<div class="enad_background_image">

					<div class="barredeprogression">

						<div class="progress progress-striped">
							<div class="progress-bar progress-bar-info"></div>
						</div>

						<div id="pourcentage" class="pull-right"></div>

					</div>


					<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
					
<script type="text/javascript">

var date = new Date();

var h = date.getHours();//0-23

var m = date.getMinutes(); //0-59

var datedujour = date.getDay(); //0-6

var datedujour_numero = date.getDate();//1-31

var month = date.getMonth(); //0-11

var fullyear = date.getFullYear();

var datedujour_mot = "date";

var month_mot = "mois";

if(month==0)
	{
	month_mot="janvier"
	}
	
if(month==1)
{
month_mot="février"
}

if(month==2)
{
month_mot="mars"
}

if(month==3)
{
month_mot="avril"
}
if(month==4)
{
month_mot="mai"
}

if(month==5)
{
month_mot="juin"
}

if(month==6)
{
month_mot="juillet"
}

if(month==7)
{
month_mot="août"
}

if(month==8)
{
month_mot="septembre"
}

if(month==9)
{
month_mot="octobre"
}

if(month==10)
{
month_mot="novembre"
}

if(month==11)
{
month_mot="décembre"
}

if(datedujour==1)
	{
	datedujour_mot="lundi";
	}
	
if(datedujour==2)
{
datedujour_mot="mardi";
}

if(datedujour==3)
{
datedujour_mot="mercredi";
}

if(datedujour==4)
{
datedujour_mot="jeudi";
}

if(datedujour==5)
{
datedujour_mot="vendredi";
}

if(datedujour==6)
{
datedujour_mot="samedi";
}

if(datedujour==0)
{
datedujour_mot="dimanche";
}


var aujourdhui ="La date d'aujourd'hui c'est "+ datedujour_mot+"  "+datedujour_numero+"  "+month_mot+"  "+fullyear+".";

if(datedujour_numero==1)
	{
	 aujourdhui= "La date d'aujourd'hui c'est "+ datedujour_mot+"  "+"premier"+"  "+month_mot+"  "+fullyear+".";
	}


//console.log(datedujour_mot+"  "+datedujour_numero+"  "+month_mot+"  "+fullyear);


var a ="Salut, je m'appelle ÉNAD. Ce sigle signifie Évaluations Neuropsychologiques A Distance. "

var heureactuelle="Il est "+h+" heures "+m+" minutes. ";

var attente="Veuillez patienter pendant que je me configure."

var text = a+" "+aujourdhui+" "+heureactuelle+" "+attente;

var at = new SpeechSynthesisUtterance(" Vous trouverez deux boutons en haut et en bas de la majorité des pages.");

var ate = new SpeechSynthesisUtterance(" Celui du haut concerne la notice.");

var aty = new SpeechSynthesisUtterance(" Celui du bas concerne un lien direct pour une assistance. Pour toutes questions ou suggestions, cliquez sur ce lien et envoyez votre message.");


var web = new SpeechSynthesisUtterance("Surtout, vous devez installer l'extension temps réel sur votre navigateur si ce n'est pas fait.");

var plusinfo = new SpeechSynthesisUtterance("Pour plusse d'informations, la notice est à votre disposition.");

var sdf = new SpeechSynthesisUtterance(" Je suis à votre service.");

//window.speechSynthesis.speak(msg);

at.lang='fr-FR';

ate.lang='fr-FR';

aty.lang='fr-FR';

web.lang='fr-FR';

plusinfo.lang='fr-FR';

sdf.lang='fr-FR';




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
		  speak( text, function() { console.log( 'done' ); } );

		 

		}



	doit();
	
	window.speechSynthesis.speak(at);
	
	window.speechSynthesis.speak(ate);
	
	window.speechSynthesis.speak(aty);
	
	window.speechSynthesis.speak(web);
	
	window.speechSynthesis.speak(plusinfo);
	
	window.speechSynthesis.speak(sdf);
	
	
                            function timer(n) {
                            	$(".progress-bar").css("width",n+"%");
                            	$("#pourcentage").text("Chargement : "+n+"%");
                            	
                            	if(n<100){
                            		
                            		setTimeout(function(){
                            			timer(n+10);
                            		},6000);
                            	}
                            }
                            
                            $(function(){
                            	
                            	
                            		
                            		timer(0);
                            	
                            });
                    
                    
                    
                    
                    function redirect()
                    
                    {
                    	window.location='/enad/enad';
                    }
                    
                    setTimeout(redirect,66000);
                    
                    </script>

					<img class="image" alt="ENAD"
						src="<c:url value="/inc/enadsoleil.png"/>">
				</div>


			</div>
		</div>

	</div>





	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
</body>
</html>