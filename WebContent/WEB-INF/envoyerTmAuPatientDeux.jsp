<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<!DOCTYPE html>

<html>
<head>

<title>Envoi du test TRAIL - MAKING Version 2</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Envoi du test au patient">
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

		<c:import url="/inc/enadnotice.jsp" />

		<div class="row">

			<div class="col-xs-12">

				<div class="enad_ENAD">Envoi du test TRAIL - MAKING Version 2</div>
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

				<div class="enad_con_med">

					<div class="col-xs-12 well" >
					
					
					           <c:if test="${  empty seances }">
					           
					           
					                  <div class="titre_resultats_recherche_con_pat">
					                  
					                  Impossible d'envoyer le test. Il faut  vérifier que
					                  vous avez des séances prévues pour ce jour. Si oui, il
					                  faut vérifier que les éventuels patients concernés sont connectés.
					                  
					                  
					                  
					                  </div>
					                  
					                  <script type="text/javascript">
					                  
					                  var msgy = new SpeechSynthesisUtterance("Impossible d'envoyer le test. Il faut  vérifier que vous avez des séances prévues pour ce jour.");


					                  var msg = new SpeechSynthesisUtterance("Si oui, il faut vérifier que les éventuels patients concernés sont connectés.");

					                  msgy.lang = 'fr-FR';
					                  
					                  msg.lang = 'fr-FR';
					                  
					                  
					                  window.speechSynthesis.speak(msgy);
					                  
					                  window.speechSynthesis.speak(msg);
                                      
					                  
					                  
					                  
					                  </script>
					           
					           
					           
					           
					           
					           </c:if>
					           
					           
					           <c:if test="${ ! empty seances }">
					           
					           <c:if test="${seances.size()> 1 }">
					           
					           <script type="text/javascript">
					                  
					                  var msgy = new SpeechSynthesisUtterance("${seances.size() } séance disponible ");


					                  msgy.lang = 'fr-FR';
					                  
					                  window.speechSynthesis.speak(msgy);
					                  
					                  </script>
					           
					           
					           </c:if>
					           
					           <c:if test="${seances.size()== 1 }">
					           
					           <script type="text/javascript">
					                  
					                  var msgy = new SpeechSynthesisUtterance("séance unique ");


					                  msgy.lang = 'fr-FR';
					                  
					                  window.speechSynthesis.speak(msgy);
					                  
					                  </script>
					           
					           
					           </c:if>
					           
					           
					           <br>
					          
					          <div class="row">
					          
					          
					                 <div class="titre_resultats_recherche_con_pat">
                                                                                                                  
                                                                                                                  ENAD a trouvé :
                                                                                                                  
                                                                                                                  <c:if test="${seances.size()> 1 }">
                                                                                                                  
                                                                                                                  ${seances.size() }
                                                                                                                  
                                                                                                                  résultats
                                                                                                                  
                                                                                                                  </c:if>
                                                                                                                  
                                                                                                                  <c:if test="${seances.size() == 1 }">
                                                                                                                  ${seances.size() }
                                                                                                                  
                                                                                                                  résultat
                                                                                                                  
                                                                                                                  </c:if>
                                                                                                                  
                                                                                                                  
                                                                                                                  
                                                                                                                  
                                                                                                                  </div>
                                                                                                         
					          
					                 <br>
					          
					          
					                <p class="titres_con_medecin">Choix de la séance</p>
					                
					                <br>
					                
					                <div class="resultats_recherche_con_pat">
					                
					                          <c:forEach items="${seances }" var="listedeseances">
										         
										              
										              <a class="btn-block" target="_blank"   href="<c:url value="/attente_tm_Medecin_deux?identifiantpatient=${listedeseances.identifiant_patient }&identifiantmedecin=${listedeseances.identifiant_medecin }&identifiantutilisateur=${sessionScope.sessionMedecin.identifiant_medecin }&idseance=${listedeseances.id_seance }"/>"> <c:out value=" Séance prévue avec ${listedeseances.prenoms_noms_patient } de ${listedeseances.heure_realisation_seance } à ${listedeseances.heure_fin_seance } "/></a>
                                                                                                      
										              
										              <br>
										              
										              
										      
										      </c:forEach>
					                
					                
					                
					                </div>
					                
										      
								
					          
					          </div>
					      
					      
					      
					           
					           
					           
					           
					           </c:if>
					
					      
					      
					          
					      
					
					
					
					</div>

				</div>


			</div>


			<!-- NOTIFS  -->

			<c:import url="/inc/notifsmed.jsp" />



		</div>


		<br> <br> <br> <br> <br> <br> <br>

		<!-- Importer footer car il ne varie pas -->

		<c:import url="/inc/footer.jsp" />





	</div>


</body>
</html>