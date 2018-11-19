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
                    
                    Exécution du test (Mini Mental State Examination (MMSE) (Version consensuelle du GRECO))
                    
                    </div>
            </div>
      
      
      
      </div>
      
      <div class="row">
      
             <div class="col-xs-12">
             
                  <div class="enad_ins_med">
                  
                  
                         <form method="post" class="col-xs-12 well"
						action="<c:url value="/formulaire_mmse"/>">
						
						
						     <fieldset>
						     
						          <br />
						          
						          <!-- Champ invisible pour id aléatoire -->
						          
						          <input type="hidden" id="champ_aleatoire" name="name_champ_aleatoire"  />
										 
						          
						          
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
						          
						               <p class="titres_ins_medecin">Orientation</p>
						               
						               <label for="scoreOrientation"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreOrientation" name="scoreOrientation" min="0" max="10"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 10. Merci pour votre compréhension." value="<c:out value="${mmse.scoreOrientation }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreOrientation'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreOrientation'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          <br>
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Apprentissage</p>
						               
						               <label for="scoreApprentissage"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreApprentissage" name="scoreApprentissage" min="0" max="3"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 3. Merci pour votre compréhension." value="<c:out value="${mmse.scoreApprentissage }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreApprentissage'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreApprentissage'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          <br>
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Attention Et Calcul</p>
						               
						               <label for="scoreAttentionEtCalcul"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreAttentionEtCalcul" name="scoreAttentionEtCalcul" min="0" max="5"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 5. Merci pour votre compréhension." value="<c:out value="${mmse.scoreAttentionEtCalcul }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreAttentionEtCalcul'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreAttentionEtCalcul'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          
						          <br>
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Rappel</p>
						               
						               <label for="scoreRappel"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreRappel" name="scoreRappel" min="0" max="3"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 3. Merci pour votre compréhension." value="<c:out value="${mmse.scoreRappel }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreRappel'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreRappel'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          <br>
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Langage</p>
						               
						               <label for="scoreLangage"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scoreLangage" name="scoreLangage" min="0" max="8"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 8. Merci pour votre compréhension." value="<c:out value="${mmse.scoreLangage }"/>"
										required />

									<c:if test="${! empty form.erreurs['scoreLangage'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scoreLangage'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          <br>
						          
						          <div class="form-group">



								<p class="titres_ins_patient">Phrase à écrire ? </p>



								<label for="oui">Oui</label> <input type="radio" id="oui"
									name="phrase_ecrire" value="oui" /> <label for="non">Non</label>
								<input type="radio" id="non" name="phrase_ecrire" value="non" />

								<c:if test="${! empty form.erreurs['phrase_ecrire'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${form.erreurs['phrase_ecrire'] }</p>

									</div>


								</c:if>





							</div>
						          
						          
						          
						          
						          
						          
						          
						          <div class="col-xs-12" id="boutonphrase_ecrire" style="display:none;">
                                    
                                                 <div style="background-color:#F1C40F;
        font-size:1.5em;
        text-align:center;
        font-weight:bold;
        color:white;
        width:100%;
        font-family:agencyfb;
        border: 8px #F1C40F solid;
        border-radius:10px;">
                                                 
                                                         
                                                         
                                                         <a id="lien_phrase_ecrire" class="btn-block" style="color: white;" target="_blank" >Phrase à écrire</a>
                                                         
                                                         
                                                         
                                                 
                                                 
                                                 
                                                 
                                                 </div>
                                    
                                    </div>
                                    
                                    
						          
						          
						          <br>
						          
						          
						          
						          <div class="form-group">
						          
						               <p class="titres_ins_medecin">Praxies Constructives </p>
						               
						               <label for="scorePraxiesConstructives"></label> <input
										class="form-control input-lg" type="number" style="text-align:center"
										id="scorePraxiesConstructives" name="scorePraxiesConstructives" min="0" max="1"
										placeholder="S'il vous plaît, veuillez saisir le score entre 0 et 1. Merci pour votre compréhension." value="<c:out value="${mmse.scorePraxiesConstructives }"/>"
										required />

									<c:if test="${! empty form.erreurs['scorePraxiesConstructives'] }">


										<br />
										<div class="alert alert-info alert-dismissable col-xs-12">

											<button type="button" class="close" data-dismiss="alert">&times;</button>

											<p>${form.erreurs['scorePraxiesConstructives'] }</p>

										</div>


									</c:if>

						               
						          
						          
						          </div>
						          
						          <br>
						          
						          <div class="form-group">



								<p class="titres_ins_patient">Dessin à recopier ? </p>



								<label for="oui">Oui</label> <input type="radio" id="ouidessin"
									name="dessin_recopier" value="oui" /> <label for="non">Non</label>
								<input type="radio" id="nondessin" name="dessin_recopier" value="non" />

								<c:if test="${! empty form.erreurs['dessin_recopier'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${form.erreurs['dessin_recopier'] }</p>

									</div>


								</c:if>





							</div>
							
							<div class="col-xs-12" id="boutondessin_recopier" style="display:none;">
                                    
                                                 <div style="background-color:#8E44AD;
        font-size:1.5em;
        text-align:center;
        font-weight:bold;
        color:white;
        width:100%;
        font-family:agencyfb;
        border: 8px #8E44AD solid;
        border-radius:10px;">
                                                 
                                                         
                                                         
                                                         <a id="lien_dessin_recopier" class="btn-block" style="color: white;" target="_blank" >Dessin à recopier</a>
                                                         
                                                         
                                                         
                                                 
                                                 
                                                 
                                                 
                                                 </div>
                                    
                                    </div>
                                    
                                    <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
                                    
                                    
                                    <script type="text/javascript">
                                    
                                    $(document).ready(function(){
                                    	
                                    	var identifiantpat_click_oui_premier_phrase;
                                    	
                                    	var identifiantpat_click_oui_premier_dessin;
                                    	
                                    	var oui_avant_non = 0;
                                    	
                                    	var oui_avant_non_dessin = 0;
                                    	
                                    	 var date = new  Date();
         						          
         						          var year = date.getYear()+1900;

                       	  				var month = date.getMonth()+1;
                       	  				
                       	  				var day = date.getDate();
                       	  				
                       	  				var hour = date.getHours();
                       	  				
                       	  				var minute = date.getMinutes();
                       	  				
                       	  				var second = date.getSeconds();
                       	  				
                       	  				var millisecond = date.getMilliseconds();
                       	  				
                       	  				var aleatoire =year+""+month+""+day+""+hour+""+minute+""+second+""+millisecond;
                       	  				
                       	  			document.getElementById("champ_aleatoire").value= aleatoire;
                       	  			
                       	  			//alert(aleatoire);
                       	  			
                       	  		$('#oui').click(function(){
                       	  			
                       	  		oui_avant_non ++;
                                	
                                	document.getElementById("boutonphrase_ecrire").style.display ="block";
                                	
                                	
                                	identifiantpat_click_oui_premier_phrase = document.getElementById("choixPatient").value;
                                	
                                	var pre_traitement_mmse="/enad/pre_traitement_phrase_ecrire_mmse?id_aleatoire="+aleatoire+"&identifiantmed=${sessionScope.sessionMedecin.identifiant_medecin }&identifiantpat="+document.getElementById("choixPatient").value;
                                	
                                	
                                	$.get(pre_traitement_mmse);
                                	
                                	document.getElementById("lien_phrase_ecrire").href ="/enad/attente_phrase_ecrire?identifiantmed=${sessionScope.sessionMedecin.identifiant_medecin }&identifiantpat="+document.getElementById("choixPatient").value+"&id_aleatoire="+aleatoire;
                                	
                                	
                                });
                                
                                $('#non').click(function(){
                                	
                                	if(oui_avant_non > 0){
                                		
                                		oui_avant_non = 0;
                                		
                                		var pre_traitement_mmse_annulation="/enad/pre_traitement_phrase_ecrire_mmse_annulation?id_aleatoire="+aleatoire+"&identifiantmed=${sessionScope.sessionMedecin.identifiant_medecin }&identifiantpat="+identifiantpat_click_oui_premier_phrase;
                                    	
                                    	
                                    	$.get(pre_traitement_mmse_annulation);
                                		
                                	}
                                	
                                	document.getElementById("boutonphrase_ecrire").style.display ="none";
                                	
                                	
                                	
                                });
                                
                                //alert(document.getElementById("choixPatient").value);
                                
                                
                                //Le lien du bouton prendra en compte l'identifiant du pat, du med ; l'aleatoire... 
                                
                                $('#ouidessin').click(function(){
                                	
                                	oui_avant_non_dessin ++;
                                	
                                	document.getElementById("boutondessin_recopier").style.display ="block";
                                	
                                	identifiantpat_click_oui_premier_dessin = document.getElementById("choixPatient").value;
                                	
                                    var pre_traitement_mmse_dessin="/enad/pre_traitement_dessin_recopier_mmse?id_aleatoire="+aleatoire+"&identifiantmed=${sessionScope.sessionMedecin.identifiant_medecin }&identifiantpat="+document.getElementById("choixPatient").value;
                                	
                                	
                                	$.get(pre_traitement_mmse_dessin);
                                	
                                	document.getElementById("lien_dessin_recopier").href ="/enad/attente_dessin_recopier?identifiantmed=${sessionScope.sessionMedecin.identifiant_medecin }&identifiantpat="+document.getElementById("choixPatient").value+"&id_aleatoire="+aleatoire;
                                	
                                	
                                });
                                
                             $('#nondessin').click(function(){
                            	 
                            	 if(oui_avant_non_dessin > 0){
                             		
                             		oui_avant_non_dessin = 0;
                             		
                             		var pre_traitement_mmse_dessin_annulation="/enad/pre_traitement_dessin_recopier_mmse_annulation?id_aleatoire="+aleatoire+"&identifiantmed=${sessionScope.sessionMedecin.identifiant_medecin }&identifiantpat="+identifiantpat_click_oui_premier_dessin;
                                 	
                                 	
                                 	$.get(pre_traitement_mmse_dessin_annulation);
                             		
                             	}
                             	
                             	document.getElementById("boutondessin_recopier").style.display ="none";
                             	
                                	
                                	
                                	
                                });
                                
                       	  			
                                    	
                                    	
                                    	
                                    });
                                    
                                   
                                    
                                    
                                    
                                    
                                    </script>
						          
						          
						          <br>
						          
						          <br>
						          
						          <br>
						          
						          <br>
						          
						          <div class="form-group">

								<button  class="btn btn-primary btn-lg btn-block " type="reset">
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
         
         var plusinf = new SpeechSynthesisUtterance("Score final de ${nomsprenomspat} : ${total} sur 30");
         
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

									<p>Score final de ${nomsprenomspat} : ${total} / 30</p>

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

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

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