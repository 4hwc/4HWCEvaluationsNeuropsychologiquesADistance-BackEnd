<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html>
<html>
<head>

<title>Exécution du test</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Exécution du test">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png" href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet"/>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->



</head>
<body>

<div class="container">

<c:import url="/inc/verificationAvoirPatientMmseBref.jsp" />

<c:import url="/inc/enadnotice.jsp"/>
      
      <div class="row">
      
            <div class="col-xs-12">
            
                    <div class="enad_ENAD">
                    
                    Exécution du test (Batterie Rapide d'Efficience Frontale (Dubois et Pillon))
                    
                    </div>
            </div>
      
      
      
      </div>
      
      <div class="row">
      
             <div class="col-xs-12">
             
                  <div class="enad_ins_med">
                  
                  
                         <form method="post" class="col-xs-12 well"
						action="<c:url value="/formulaire_batterie_rapide_efficience_frontale"/>">
						
						
						     <fieldset>
						     
						          <br />
						          
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
						          
						          <br>
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Epreuve des similitudes</p>
						               
						               <label for="scoreEpreuveSimilitudes"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreEpreuveSimilitudes" name="scoreEpreuveSimilitudes" min="0" max="3"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 3. Merci pour votre compréhension." value="<c:out value="${bref.scoreEpreuveSimilitudes }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreEpreuveSimilitudes'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreEpreuveSimilitudes'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          <br>
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Epreuve de fluence verbale</p>
						               
						               <label for="scoreEpreuveFluenceVerbale"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreEpreuveFluenceVerbale" name="scoreEpreuveFluenceVerbale" min="0" max="3"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 3. Merci pour votre compréhension." value="<c:out value="${bref.scoreEpreuveFluenceVerbale }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreEpreuveFluenceVerbale'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreEpreuveFluenceVerbale'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          <br>
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Comportement de préhension</p>
						               
						               <label for="scoreComportementPrehension"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreComportementPrehension" name="scoreComportementPrehension" min="0" max="3"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 3. Merci pour votre compréhension." value="<c:out value="${bref.scoreComportementPrehension }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreComportementPrehension'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreComportementPrehension'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          
						          <br>
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Séquences motrices de Luria</p>
						               
						               <label for="scoreSequencesMotricesLuria"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreSequencesMotricesLuria" name="scoreSequencesMotricesLuria" min="0" max="3"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 3. Merci pour votre compréhension." value="<c:out value="${bref.scoreSequencesMotricesLuria }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreSequencesMotricesLuria'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreSequencesMotricesLuria'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          <br>
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Epreuve des consignes conflictuelles</p>
						               
						               <label for="scoreEpreuveConsignesConflictuelles"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreEpreuveConsignesConflictuelles" name="scoreEpreuveConsignesConflictuelles" min="0" max="3"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 3. Merci pour votre compréhension." value="<c:out value="${bref.scoreEpreuveConsignesConflictuelles }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreEpreuveConsignesConflictuelles'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreEpreuveConsignesConflictuelles'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          <br>
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Epreuve de Go - No Go </p>
						               
						               <label for="scoreEpreuveGoNoGo"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreEpreuveGoNoGo" name="scoreEpreuveGoNoGo" min="0" max="3"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 3. Merci pour votre compréhension." value="<c:out value="${bref.scoreEpreuveGoNoGo }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreEpreuveGoNoGo'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreEpreuveGoNoGo'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          <br>
						          
						          <div class="form-group">

								<button class="btn btn-primary btn-lg btn-block " type="reset">
									<span class="glyphicon glyphicon-erase"></span>
									<h4>J'efface toutes les données du formulaire.</h4>
								</button>

								<br /> <br /> <a class="btn btn-warning btn-lg btn-block "
									href="<c:url value="/testsetresultats_Medecin"/>"><span
									class="glyphicon glyphicon-info-sign"></span> <br />Tests et résultats.
									
									</a> <br /> <br />


								<button class="btn btn-success btn-lg btn-block " type="submit">
									<span class="glyphicon glyphicon-ok-sign"></span>
									<h4>Je sauvegarde les résultats.</h4>
								</button>



							</div>
							
							<c:if test="${! empty form.resultat}">
							
							<script type="text/javascript">
         
         var plusinfo = new SpeechSynthesisUtterance("${form.resultat}");
         
         plusinfo.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinfo);

         
         </script>
         
         <c:if test="${ form.resultat eq succes}">
							
							<script type="text/javascript">
         
         var plusinf = new SpeechSynthesisUtterance("Score final de ${nomsprenomspat} : ${total} sur 18");
         
         plusinf.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinf);

         
         </script>
							
						
							
							
							</c:if>
							
							<c:if test="${ form.resultat eq echec}">
							
							
							</c:if>

								<br />



								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>

									<p>${form.resultat}</p>

								</div>
								
								<br />



								<div class="alert alert-info alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>

									<p>Score final de ${nomsprenomspat}  : ${total} / 18</p>

								</div>


							</c:if>
						          
						          
						     
						     
						     
						     
						     </fieldset>
						
						
						
						
						</form>
                  
                  
                  </div>
             
             
             </div>
      
              
      </div>
      
      
      <br>
      <br>
      
     
      
      <!-- Importer footer car il ne varie pas -->
                                             
<c:import url="/inc/footer.jsp"/>





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