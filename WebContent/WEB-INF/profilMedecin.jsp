<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >
<html>
<head>

<title>Profil Médecin</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Profil d'un médecin d' ENAD.">
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


  <c:if test="${ ! empty actif  }">
  
       <c:if test="${  actif eq 'patient'  }">
       
       <c:import url="/inc/enadnotice.jsp"/>
              
              <div class="row">
      
            <div class="col-xs-12">
            
                    <div class="enad_ENAD">
                    
                    Profil du médecin 
                    
                    <c:if test="${ ! empty medecinprofil }">
${medecinprofil.prenoms_medecin }  ${medecinprofil.noms_medecin }


      
     <c:if test="${ ! empty medecinprofil.url_photo_medecin }">
     
     <br>
     
     <img class="" style="margin:auto;" width="200" height="200" id="img" alt="ENAD" src="http://${  sessionScope.adresseserveur }:8080/enad${  medecinprofil.url_photo_medecin }" >
                        
     
     
     </c:if>


</c:if>
                    
                    </div>
            </div>
      
      
      
      </div>
      
      
      <c:import url="/inc/presentationPatient.jsp"/>
      
      <br>
      
      <!-- MENU + CONTACTS + NOTIFS -->
      
      <div class="row">
      
           <!-- CONTACTS -->
           
           <c:import url="/inc/contactspat.jsp" />
           
           <!-- MENU -->
           
           <div class="col-xs-8">
           
                   <div class="menumed">
                   
                         <c:if test="${ ! empty liaisonmedpat }">
                         
                                <c:if test="${  liaisonmedpat eq 'oui' }">
                                
                                <c:if test="${ ! empty liaisonmedtraitantpat }">
                                
                                <c:if test="${  liaisonmedtraitantpat eq 'oui' }">
                                
                                     <div class="row relationavecmedecintraitantoui">
                                     
                                          Voici votre médecin traitant.
                                          
                                          <script type="text/javascript">
         
         var plusinfo = new SpeechSynthesisUtterance("Voici votre médecin traitant.");
         
         plusinfo.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinfo);

         
         </script>
                                     
                                     
                                     </div>
                                
                                
                                
                                </c:if>
                                
                                <c:if test="${  liaisonmedtraitantpat eq 'non' }">
                                
                                   <div class="row relationavecmedecintraitantnon">
                                   
                                   <script type="text/javascript">
         
         var plusinf = new SpeechSynthesisUtterance("Vous êtes en relation avec ce médecin mais ce n'est pas votre médécin traitant.");
         
         plusinf.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinf);

         
         </script>
                                     
                                          Vous êtes en relation avec ce médecin mais ce n'est pas votre médécin traitant.
                                     
                                     
                                     </div>
                                
                                
                                
                                <c:if test="${  !empty avoirmdt }">
                                
                                <c:if test="${  avoirmdt eq 'oui' }">
                                
                                </c:if>
                                
                                <c:if test="${  avoirmdt eq 'non' }">
                                
                                  <div class="row sansmedecintraitant">
                                  
                                       Vous n'avez pas de médecin traitant.
                                       
                                       <script type="text/javascript">
         
         var plusin = new SpeechSynthesisUtterance("Vous n'avez pas de médecin traitant.");
         
         plusin.lang='fr-FR';
         
         window.speechSynthesis.speak(plusin);

         
         </script>
                                  
                                  </div>
                                
                                
                                
                                                                                      <c:if test="${ ! empty demandeliaisonmedt }">
                                       
                                                       <c:if test="${  demandeliaisonmedt eq 'oui' }">
                                                       
                                                              <c:if test="${ ! empty demandeliaisonmedtsens }">
                                                              
                                                                       <c:if test="${  demandeliaisonmedtsens eq 'gauchedroite' }">
                                                                       
                                                                       
                                                                       
                                                                       <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/confirmation_medt_pat?ide_em=${medecinprofil.identifiant_medecin}&ide_dest=${sessionScope.sessionPatient.identifiant_patient }&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je confirme la demande de mise en relation de ce médecin en tant que médecin traitant.</a>
                                                                       
                                                                       </c:if>
                                                                       
                                                                       <c:if test="${  demandeliaisonmedtsens eq 'droitegauche' }">
                                                                       
                                                                       <div class="row demandeattentevalidation">
                                                                       
                                                                       <script type="text/javascript">
         
         var plusi = new SpeechSynthesisUtterance("Votre demande de médecin traitant est en attente de validation par ce médecin.");
         
         plusi.lang='fr-FR';
         
         window.speechSynthesis.speak(plusi);

         
         </script>
                                                                       
                                                                       Votre demande de médecin traitant est en attente de validation par ce médecin.
                                                                       
                                                                       
                                                                       </div>
                                                                       
                                                                       
                                                                       </c:if>
                                                              
                                                              
                                                              
                                                              </c:if>
                                
                                
                                                       </c:if>
                                        
                                                      <c:if test="${  demandeliaisonmedt eq 'non' }">
                                                      
                                                      
                                                      
                                                      <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/etreenrelation_medt_pat?ide_em=${sessionScope.sessionPatient.identifiant_patient }&ide_dest=${medecinprofil.identifiant_medecin}&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je souhaite que vous soyez mon médecin traitant.</a>
                                
                                
                                                      </c:if>
                                       
                                       
                                       </c:if>
      
                                
                                </c:if>
                                
                                
                                </c:if>
                                
                          
                                </c:if>
                                
                                </c:if>
                                
                                
                                
                                        
                                
                                
                                
                                </c:if>
                                
                                <c:if test="${  liaisonmedpat eq 'non' }">
                                
                                <div class="row relationavecmedecinnon">
                                
                                <script type="text/javascript">
         
         var plus = new SpeechSynthesisUtterance("Vous n'êtes pas en relation avec ce médecin");
         
         plus.lang='fr-FR';
         
         window.speechSynthesis.speak(plus);

         
         </script>
                                
                                   Vous n'êtes pas en relation avec ce médecin.
                                
                                
                                </div>
                                
                                
                                
                                
                                              <c:if test="${  ! empty demandeliaisonmedpat }">
                                              
                                              
                                                          <c:if test="${   demandeliaisonmedpat eq 'oui' }">
                                                          
                                                                 <c:if test="${  ! empty demandeliaisonmedpatsens }"> 
                                                                 
                                                                 
                                                                          <c:if test="${   demandeliaisonmedpatsens eq 'gauchedroite' }">
                                                                          
                                                                          
                                                                          
                                                                          <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/confirmation_med_pat?ide_em=${medecinprofil.identifiant_medecin}&ide_dest=${sessionScope.sessionPatient.identifiant_patient }&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je confirme la demande de mise en relation de ce médecin.</a>
                                                                          
                                                                          </c:if>
                                                                          
                                                                          <c:if test="${   demandeliaisonmedpatsens eq 'droitegauche' }">
                                                                          
                                                                          <div class ="row demandeattentevalidation">
                                                                          
                                                                          <script type="text/javascript">
         
         var plu = new SpeechSynthesisUtterance("Votre demande est en attente de validation par ce médecin.");
         
         plu.lang='fr-FR';
         
         window.speechSynthesis.speak(plu);

         
         </script>
                                                                          
                                                                           Votre demande est en attente de validation par ce médecin.
                                                                          
                                                                          
                                                                          </div>
                                                                          
                                                                         
                                                                          
                                                                          </c:if>
                                                                 
                                                                 
                                                                         
                                                                 
                                                                 
                                                                 
                                                                 </c:if>
                                                                 
                                                                 
                                                          
                                                          </c:if>
                                                          
                                                          <c:if test="${   demandeliaisonmedpat eq 'non' }">
                                                          
                                                          
                                                          
                                                          <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/etreenrelation_med_pat?ide_em=${sessionScope.sessionPatient.identifiant_patient }&ide_dest=${medecinprofil.identifiant_medecin}&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je souhaite être en relation avec ce médecin.</a>
                                                          
                                                          </c:if>
                                              
                                                      
                                              
                                              
                                              </c:if>
                                              
                                              <c:if test="${  !empty avoirmdt }">
                                
                                <c:if test="${  avoirmdt eq 'oui' }">
                                
                                
                                
                                </c:if>
                                
                                <c:if test="${  avoirmdt eq 'non' }">
                                
                                <div class="row sansmedecintraitant">
                                
                                <script type="text/javascript">
         
         var pl = new SpeechSynthesisUtterance("Vous n'avez pas de médecin traitant.");
         
         pl.lang='fr-FR';
         
         window.speechSynthesis.speak(pl);

         
         </script>
                                
                               
                                  
                                       Vous n'avez pas de médecin traitant.
                                  
                                  </div>
                                
                                                                                      <c:if test="${ ! empty demandeliaisonmedt }">
                                       
                                                       <c:if test="${  demandeliaisonmedt eq 'oui' }">
                                                       
                                                              <c:if test="${ ! empty demandeliaisonmedtsens }">
                                                              
                                                                       <c:if test="${  demandeliaisonmedtsens eq 'gauchedroite' }">
                                                                       
                                                                       
                                                                       
                                                                       <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/confirmation_medt_pat?ide_em=${medecinprofil.identifiant_medecin}&ide_dest=${sessionScope.sessionPatient.identifiant_patient }&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je confirme la demande de mise en relation de ce médecin en tant que médecin traitant.</a>
                                                                       
                                                                       </c:if>
                                                                       
                                                                       <c:if test="${  demandeliaisonmedtsens eq 'droitegauche' }">
                                                                       
                                                                       <div class="row demandeattentevalidation">
                                                                       
                                                                       <script type="text/javascript">
         
         var p = new SpeechSynthesisUtterance("Votre demande de médecin traitant est en attente de validation par ce médecin.");
         
         p.lang='fr-FR';
         
         window.speechSynthesis.speak(p);

         
         </script>
                                                                       
                                                                       Votre demande de médecin traitant est en attente de validation par ce médecin.
                                                                       
                                                                       
                                                                       </div>
                                                                       
                                                                       </c:if>
                                                              
                                                              
                                                              
                                                              </c:if>
                                
                                
                                                       </c:if>
                                        
                                                      <c:if test="${  demandeliaisonmedt eq 'non' }">
                                                      
                                                   
                                                      
                                                      <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/etreenrelation_medt_pat?ide_em=${sessionScope.sessionPatient.identifiant_patient }&ide_dest=${medecinprofil.identifiant_medecin}&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je souhaite que vous soyez mon médecin traitant.</a>
                                
                                
                                                      </c:if>
                                       
                                       
                                       </c:if>
      
                                
                                </c:if>
                                
                                
                                </c:if>
                                
                                
                                
                                       
                                        
                                
                                
                                </c:if>
                         
                         
                         </c:if>
                   
                   
                   </div>
           
           
           </div>
           
           <!-- NOTIFS  -->

			<c:import url="/inc/notifspat.jsp" />
           
      
      
      </div>
      
      <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
              
              

<c:import url="/inc/footer.jsp"/>
                                    
                                    
                               
       
       
       
       </c:if>
       
       <c:if test="${  actif eq 'medecin'  }">
       
       
              <c:if test="${ ! empty action  }">
            
                  
                   <c:if test="${  action eq 'consulteretmodifier'  }">
                   
                           <c:import url="/inc/enadnotice.jsp"/>
              
              <div class="row">
      
            <div class="col-xs-12">
            
                    <div class="enad_ENAD">
                    
                    Profil du médecin 
                    
                    <c:if test="${ ! empty sessionScope.sessionMedecin }">
${sessionScope.sessionMedecin.prenoms_medecin }  ${sessionScope.sessionMedecin.noms_medecin }


</c:if>
                    
                    </div>
            </div>
      
      
      
      </div>
      
      
      <c:import url="/inc/presentationMedecin.jsp"/>
      
      <br>
      
      <!-- MENU + CONTACTS + NOTIFS -->
      
      <div class="row">
      
           <!-- CONTACTS -->
           
           <c:import url="/inc/contactsmed.jsp" />
           
           <!-- MENU -->
           
           <div class="col-xs-8">
           
                   <div class="menumed">
                   
                   
                   <div class="row">

						<div class="col-xs-5 ">

							<div class="boutontestsetresultats">


								<button data-toggle="modal" data-backdrop="false"  data-target="#nomsmed" class="btn-block buttonsmenu"
									><i
									class="fa fa-pencil"></i><br />Noms</button>
									
									<div class="modal fade" id="nomsmed" role="dialog" aria-labelledby="nomsmedLabel" aria-hidden="true">
									
									       <div class="modal-dialog modal-lg">
									       
									            <div class="modal-content">
									            
									                 <div class="modal-header">
									                 
									                        <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                             <h2 class="modal-title">Je modifie mon nom ou mes noms.</h2>
									                 
									                 
									                 </div>
									                 
									                 <div class="modal-body well">
									                 
									                        <div class="row">
									                        
									                              <div class="col-xs-12">
									                              
									                                     <div class="enad_ins_med">
									                                     
									                                         <form method="post" class="col-xs-12 "
						action="<c:url value="/modification_noms_Medecin"/>">
									                                         
									                                              <fieldset>
									                                                
									                                                <br />
									                                                
									                                                    <div class="form-group">
									                                                    
									                                                          <p class="titres_ins_medecin">Nom(s) du médecin</p>

								<label for="nomsMedecin"></label> <input
									class="form-control input-lg" type="text" id="nomsMedecin"
									name="nomsMedecin"
									placeholder="S'il vous plaît, veuillez modifier votre nom ou vos noms. Merci pour votre compréhension."
									value="<c:out value="${medecin.noms_medecin }"/>" required />


								<c:if test="${! empty formnoms.erreurs['nomsMedecin'] }">

									<br />
									
									


									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formnoms.erreurs['nomsMedecin'] }</p>

									</div>


								</c:if>


									                                                          
									                                                    
									                                                    
									                                                    </div>
									                                                    
									                                                    <br>
									                                              
									                                              <div class="form-group">
									                      
									                         <button class="btn btn-primary btn-lg btn-block " type="reset">
									<span class="glyphicon glyphicon-erase"></span>
									<h4>J'efface  la donnée du formulaire.</h4>
								</button>
								
								<br>
								
                                                               
                                                               <button class="btn btn-success btn-lg btn-block "  type="submit">
									<span class="glyphicon glyphicon-ok-sign"></span>
									<h4>Je modifie mon nom.</h4>
								</button>
								
								<c:if test="${! empty formnoms.resultat}">

								<br />



								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>

									<p>${formnoms.resultat}</p>

								</div>


							</c:if>
								
								<br>
								
								<button class="btn btn-info btn-lg btn-block " data-dismiss="modal" >
									<span class="glyphicon glyphicon-remove-circle"></span>
									<h4>Fermer</h4>
								</button>
								
								
									                   
									                   
									                   
									     </div>
									     
									     
                                       
									                                              
									                                              </fieldset>
									                                              
									                                              
									                                         
									                                         
									                                         
									                                         </form>
									                                     
									                                     
									                                     </div>
									                              
									                              
									                              </div>
									                        
									                        
									                        </div>
									                 
									                 
									                 
									                 
									                 </div>
									                 
									                 
									                 
									                 
									            
									            
									            
									            </div>
									       
									       
									       
									       </div>
									
									
									
									</div>





							</div>



						</div>
						
						<c:if test="${! empty formnoms}">
						
						<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

	<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
						
						<script type="text/javascript">
						
						
						
						$(window).load(function(){
					        $('#nomsmed').modal('show');
					    });
						
						
						</script>
						
						</c:if>



						<div class=" col-xs-5 col-xs-push-2">

							<div class="boutoncarnetsdesante">

								<button class="btn-block buttonsmenu" data-toggle="modal" data-backdrop="false"  data-target="#prenomsmed"
									><i
									class="fa fa-pencil"></i><br />Prénoms</button>
									
									
									<div class="modal fade" id="prenomsmed" role="dialog" aria-labelledby="prenomsmedLabel" aria-hidden="true">
									
									     <div class="modal-dialog modal-lg">
									     
									             <div class="modal-content">
									             
									                     <div class="modal-header ">
									                     
									                           <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                               <h2 class="modal-title">Je modifie mon prénom ou mes prénoms.</h2>
									                 
									                     
									                     
									                     </div>
									                     
									                     <div class="modal-body well">
									                     
									                           <div class="row">
									                           
									                                <div class="col-xs-12">
									                                
									                                
									                                      <div class="enad_ins_med">
									                                      
									                                      
									                                                   <form method="post" class="col-xs-12 "
						action="<c:url value="/modification_prenoms_Medecin"/>">
									                                         
									                                              <fieldset>
									                                                
									                                                <br />
									                                                
									                                                    <div class="form-group">
									                                                    
									                                                          <p class="titres_ins_medecin">Prénom(s) du médecin</p>

								<label for="prenomsMedecin"></label> <input
									class="form-control input-lg" type="text" id="prenomsMedecin"
									name="prenomsMedecin"
									placeholder="S'il vous plaît, veuillez modifier votre prénom ou vos prénoms. Merci pour votre compréhension."
									value="<c:out value="${medecin.prenoms_medecin }"/>"  />


								<c:if test="${! empty formprenoms.erreurs['prenomsMedecin'] }">

									<br />


									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formprenoms.erreurs['prenomsMedecin'] }</p>

									</div>


								</c:if>


									                                                          
									                                                    
									                                                    
									                                                    </div>
									                                                    
									                                                    <br>
									                                              
									                                              <div class="form-group">
									                      
									                         <button class="btn btn-primary btn-lg btn-block " type="reset">
									<span class="glyphicon glyphicon-erase"></span>
									<h4>J'efface  la donnée du formulaire.</h4>
								</button>
								
								<br>
								
                                                               
                                                               <button class="btn btn-success btn-lg btn-block "  type="submit">
									<span class="glyphicon glyphicon-ok-sign"></span>
									<h4>Je modifie mon prénom.</h4>
								</button>
								
								<c:if test="${! empty formprenoms.resultat}">

								<br />



								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>

									<p>${formprenoms.resultat}</p>

								</div>


							</c:if>
								
								<br>
								
								<button class="btn btn-info btn-lg btn-block " data-dismiss="modal" >
									<span class="glyphicon glyphicon-remove-circle"></span>
									<h4>Fermer</h4>
								</button>
								
								
									                   
									                   
									                   
									     </div>
									     
									     
                                       
									                                              
									                                              </fieldset>
									                                              
									                                              
									                                         
									                                         
									                                         
									                                         </form>
									                                     
									                                     
									                                     
									                 
									                                      
									                                      
									                                      
									                                      
									                                      </div>
									                                
									                                
									                                
									                                </div>
									                           
									                           
									                           </div>
									                     
									                     
									                     </div>
									                     
									                     
									             
									             </div>
									     
									     
									     </div>
									
									</div>

                        


							</div>



						</div>


					</div>
					
					<c:if test="${! empty formprenoms}">
						
						<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

	<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
						
						<script type="text/javascript">
						
						
						
						$(window).load(function(){
					        $('#prenomsmed').modal('show');
					    });
						
						
						</script>
						
						</c:if>

					<br /> <br />
					
					

					<div class="row">

						<div class="col-xs-5 ">

							<div class="boutontestsetresultats">

								<button class="btn-block buttonsmenu" data-toggle="modal" data-backdrop="false"  data-target="#identifiantmed"
									><i
									class="fa fa-pencil"></i><br />Identifiant</button>
									
									<div class="modal fade" id="identifiantmed" role="dialog" aria-labelledby="identifiantmedLabel" aria-hidden="true">
									
									     <div class="modal-dialog modal-lg">
									     
									             <div class="modal-content">
									             
									                     <div class="modal-header ">
									                     
									                     <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                               <h2 class="modal-title">Je modifie mon identifiant.</h2>
									                 
									                     
									                     </div>
									                     
									                     <div class="modal-body well ">
									                     
									                            <div class="row">
									                           
									                                <div class="col-xs-12">
									                                
									                                
									                                      <div class="enad_ins_med">
									                                      
									                                            <form method="post" class="col-xs-12 " action="<c:url value="/modification_identifiant_Medecin"/>">
									                                            
									                                            
									                                                  <fieldset>
									                                                  
									                                                       <br>
									                                                       
									                                                       <div class="form-group">
									                                                       
									                                                             <p class="titres_ins_medecin">Identifiant du médecin</p>
									                                                             
									                                                             <label for="identifiantMedecin"></label> 
									                                                             
									                                                             <input
									                                                                class="form-control input-lg" type="text"
									                                                                id="identifiantMedecin" name="identifiantMedecin"
									                                                                placeholder="S'il vous plaît, veuillez saisir un identifiant unique pour recevoir un contenu qui vous est destiné. Merci pour votre compréhension."
									                                                                value="<c:out value="${medecin.identifiant_medecin }"/>"
									                                                                required />
									                                                                
									                                                                
									                                                                
									                                                                <c:if test="${! empty formidentifiant.erreurs['identifiantMedecin'] }">

									<br />
									
									


									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formidentifiant.erreurs['identifiantMedecin'] }</p>

									</div>




								</c:if>
									                                                             
									                                                       
									                                                       
									                                                       </div>
									                                                       
									                                                       <br>
									                                                       
									                                                         <div class="form-group">

								<p class="titres_ins_medecin">Confirmation de l'identifiant
									du médecin</p>

								<label for="confirmeidentifiantMedecin"></label> <input
									class="form-control input-lg" type="text"
									id="confirmeidentifiantMedecin"
									name="confirmeidentifiantMedecin"
									placeholder="S'il vous plaît, veuillez confirmer votre identifiant en le saisissant de nouveau. Merci pour votre compréhension."
									value="<c:out value=""/>" required />

								<c:if
									test="${! empty formidentifiant.erreurs['confirmeidentifiantMedecin'] }">

									<br />


									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formidentifiant.erreurs['confirmeidentifiantMedecin'] }</p>

									</div>

								</c:if>




							</div>
							
							<br>
							
							<div class="form-group">
									                      
									                         <button class="btn btn-primary btn-lg btn-block " type="reset">
									<span class="glyphicon glyphicon-erase"></span>
									<h4>J'efface  les données du formulaire.</h4>
								</button>
								
								<br>
								
                                                               
                                                               <button class="btn btn-success btn-lg btn-block "  type="submit">
									<span class="glyphicon glyphicon-ok-sign"></span>
									<h4>Je modifie mon identifiant.</h4>
								</button>
								
								<c:if test="${! empty formidentifiant.resultat}">

								<br />



								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>

									<p>${formidentifiant.resultat}</p>

								</div>


							</c:if>
								
								<br>
								
								<button class="btn btn-info btn-lg btn-block " data-dismiss="modal" >
									<span class="glyphicon glyphicon-remove-circle"></span>
									<h4>Fermer</h4>
								</button>
								
								
									                   
									                   
									                   
									     </div>
									     
									                                                         
									                                                  
									                                                  
									                                                  </fieldset>
									                                            
									                                            
									                                            </form>
									                                      
									                                      </div>
									                                      
									                                 </div>
									                                 
									                             </div>         
									                                      
									                                      
									                                      
									                     
									                     </div>
									                     
									                     
									              </div>
									              
									       </div>
									       
									       
									   </div>                 


							</div>


						</div>
						
						<c:if test="${! empty message}">
						
						<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

	<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
						
						<script type="text/javascript">
						
						
						
						$(window).load(function(){
					        $('#identifiantmed').modal('show');
					    });
						
						
						</script>
						
						</c:if>

						<div class="col-xs-5 col-xs-push-2">

							<div class="boutoncarnetsdesante">

								<button class="btn-block buttonsmenu" data-toggle="modal" data-backdrop="false"  data-target="#mdpmed"
									><i
									class="fa fa-pencil"></i><br />Mot de passe</button>
									
									
									<div class="modal fade" id="mdpmed" role="dialog" aria-labelledby="mdpmedLabel" aria-hidden="true">
									
									     <div class="modal-dialog modal-lg">
									     
									             <div class="modal-content">
									             
									                     <div class="modal-header ">
									                     
									                     <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                         <h2 class="modal-title">Je modifie mon mot de passe.</h2>
									                 
									                     
									                     </div>
									                     
									                     <div class="modal-body well">
									                     
									                            <div class="row">
									                            
									                                   <div class="col-xs-12">
									                                   
									                                        <div class="enad_ins_med">
									                                        
									                                             <form method="post" class="col-xs-12 " action="<c:url value="/modification_mdp_Medecin"/>">
									                                             
									                                             
									                                                 <fieldset>
									                                                 
									                                                    <br>
									                                                    
									                                                    
							<div class="form-group">

								<p class="titres_ins_medecin">Mot de passe du médecin</p>

								<label for="mdpMedecin"></label> <input
									class="form-control input-lg" type="password" id="mdpMedecin"
									name="mdpMedecin"
									placeholder="S'il vous plaît, veuillez saisir un mot de passe pour personnaliser votre expérience. Merci pour votre compréhension."
									value="" required />


								<c:if test="${! empty formmdp.erreurs['mdpMedecin'] }">

									<br />

									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formmdp.erreurs['mdpMedecin'] }</p>

									</div>



								</c:if>


							</div>

							<br />

							<div class="form-group">

								<p class="titres_ins_medecin">Confirmation du mot de passe
									du médecin</p>

								<label for="confirmemdpMedecin"></label> <input
									class="form-control input-lg" type="password"
									id="confirmemdpMedecin" name="confirmemdpMedecin"
									placeholder="S'il vous plaît, veuillez confirmer votre mot de passe en le saisissant de nouveau. Merci pour votre compréhension."
									value="" required />

								<c:if test="${! empty formmdp.erreurs['confirmemdpMedecin'] }">


									<br />


									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formmdp.erreurs['confirmemdpMedecin'] }</p>

									</div>

								</c:if>



							</div>
							
								
							<br>
							
							<div class="form-group">
									                      
									                         <button class="btn btn-primary btn-lg btn-block " type="reset">
									<span class="glyphicon glyphicon-erase"></span>
									<h4>J'efface  les données du formulaire.</h4>
								</button>
								
								<br>
								
                                                               
                                                               <button class="btn btn-success btn-lg btn-block "  type="submit">
									<span class="glyphicon glyphicon-ok-sign"></span>
									<h4>Je modifie mon mot de passe.</h4>
								</button>
								
								<c:if test="${! empty formmdp.resultat}">

								<br />



								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>

									<p>${formmdp.resultat}</p>

								</div>


							</c:if>
								
								<br>
								
								<button class="btn btn-info btn-lg btn-block " data-dismiss="modal" >
									<span class="glyphicon glyphicon-remove-circle"></span>
									<h4>Fermer</h4>
								</button>
								
								
									                   
									                   
									                   
									     </div>
									
									                                                    
									                                                 
									                                                 
									                                                 
									                                                 
									                                                 </fieldset>
									                                             
									                                             
									                                             
									                                             </form>
									                                        
									                                        
									                                        
									                                        </div>
									                                   
									                                   
									                                   </div>
									                            
									                            
									                            </div>
									                     
									                     
									                     </div>
									                     
									                 </div>
									                 
									            </div>
									            
									     </div>              

							</div>



						</div>



					</div>
					
					
					
					<c:if test="${! empty formmdp}">
						
						<script src='<c:url value="/inc/jquery-1.12.4.min.js"/>'></script>

	<script src='<c:url value="/inc/jquery-ui/jquery-ui.js"/>'></script>
	<script src='<c:url value="/inc/bootstrap/js/bootstrap.js"/>'></script>
						
						<script type="text/javascript">
						
						
						
						$(window).load(function(){
					        $('#mdpmed').modal('show');
					    });
						
						
						</script>
						
						</c:if>

					<br /> <br />

					<div class="row">

						<div class="col-xs-5 ">

							<div class="boutoncommentaires">

								<a class="btn-block buttonsmenu"
									href="<c:url value="/collegues_Medecin"/>"><i
									class="fa fa-user-md"></i><br />Mes collègues</a>


							</div>


						</div>



						<div class="col-xs-5 col-xs-push-2">

							<div class="boutongroupes">

								<a class="btn-block buttonsmenu"
									href="<c:url value="/encharge_Medecin"/>"><i
									class="fa fa-group"></i><br />Mes patient(e)s</a>


							</div>



						</div>



					</div>
					
					

                   <br>
                   <br>
                   
                   
                   </div>
           
           
           </div>
           
           <!-- NOTIFS  -->

			<c:import url="/inc/notifsmed.jsp" />
           
      
      
      </div>
      
      <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
              
              

<c:import url="/inc/footer.jsp"/>
                                    
                                    
                                    
                    </c:if>
                                    
                    <c:if test="${  action eq 'consulter'  }">
                    
                    
                          <c:import url="/inc/enadnotice.jsp"/>
              
              <div class="row">
      
            <div class="col-xs-12">
            
                    <div class="enad_ENAD">
                    
                    Profil du médecin 
                    
                    <c:if test="${ ! empty medecinconsulter }">
                    
    ${medecinconsulter.prenoms_medecin } ${medecinconsulter.noms_medecin }  


</c:if>


<c:if test="${ ! empty medecinconsulter.url_photo_medecin }">

<br>

<img class=""  style="margin:auto;" width="200" height="200" id="img" alt="ENAD" src="http://${  sessionScope.adresseserveur }:8080/enad${  medecinconsulter.url_photo_medecin }" >
                        


</c:if>

            
      
      <!-- PHOTO  -->


                    
                    </div>
            </div>
      
      
      
      </div>
      
      
      <c:import url="/inc/presentationMedecin.jsp"/>
      
      <br>
      
      <!-- MENU + CONTACTS + NOTIFS -->
      
      <div class="row">
      
           <!-- CONTACTS -->
           
           <c:import url="/inc/contactsmed.jsp" />
           
           <!-- MENU -->
           
           <div class="col-xs-8">
           
                   <div class="menumed">
                   
                     <c:if test="${ ! empty liaison }">
                     
                     
                               <c:if test="${  liaison eq 'oui' }">
                               
                                   <div class="row relationavecmedecinoui">
                                   
                                   <script type="text/javascript">
         
         var c = new SpeechSynthesisUtterance("Vous êtes en relation avec ce médecin.");
         
         c.lang='fr-FR';
         
         window.speechSynthesis.speak(c);

         
         </script>
                                   
                                       Vous êtes en relation avec ce médecin.
                                   
                                   
                                   </div>
                               
                               
                               
                               
                               </c:if>
                               
                               <c:if test="${  liaison eq 'non' }">
                               
                                      <div class="row relationavecmedecinnon">
                                      
                                      <script type="text/javascript">
         
         var d = new SpeechSynthesisUtterance("Vous n'êtes pas en relation avec ce médecin.");
         
         d.lang='fr-FR';
         
         window.speechSynthesis.speak(d);

         
         </script>
                                      
                                         Vous n'êtes pas en relation avec ce médecin.
                                         
                                         
                               
                                      </div>
                                      
                                      <br>
                                      <br>
                                      <br>
                               
                                  
                               
                                       <c:if test="${ ! empty demandeliaison }">
                                       
                                              <c:if test="${  demandeliaison eq 'oui' }">
                                              
                                              
                                                    <c:if test="${ ! empty demandeliaisonsens }">
                                                    
                                                             <c:if test="${  demandeliaisonsens eq 'gauchedroite' }">
                                                             
                                                             
                                                             
                                                             <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/confirmation_med_med?ide_em=${medecinconsulter.identifiant_medecin}&ide_dest=${sessionScope.sessionMedecin.identifiant_medecin }"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je confirme la demande de mise en relation de ce médecin.</a>
                                                             
                                                             </c:if>
                                                             
                                                             <c:if test="${  demandeliaisonsens eq 'droitegauche' }">
                                                             
                                                                  <div class="row demandeattentevalidation">
                                                                  
                                                                  <script type="text/javascript">
         
         var e = new SpeechSynthesisUtterance("Mise en relation  en attente de confirmation de la part de ce médecin");
         
         e.lang='fr-FR';
         
         window.speechSynthesis.speak(e);

         
         </script>
                                                                  
                                                                  Mise en relation  en attente de confirmation de la part de ce médecin
                                                    
                                                                  </div>
                                                             
                                                             
                                                             
                                                             </c:if>
                                                    
                                                    
                                                    </c:if>
                               
                               
                                             </c:if>
                                             
                                             <c:if test="${  demandeliaison eq 'non' }">
                                             
                                                    
                                             
                                             <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/etreenrelation_med_med?ide_em=${sessionScope.sessionMedecin.identifiant_medecin }&ide_dest=${medecinconsulter.identifiant_medecin}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je souhaite être  en relation avec  ce médecin.</a>
                               
                               
                                             </c:if>
                                       
                                       
                                       
                                       </c:if>
                               
                               
                               </c:if>
                     
                     
                     
                     
                     
                     </c:if>
                   
                   
                   
                   </div>
           
           
           </div>
           
           <!-- NOTIFS  -->

			<c:import url="/inc/notifsmed.jsp" />
           
      
      
      </div>
      
      <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
              
              

<c:import url="/inc/footer.jsp"/>
                                    
                                    
                                    
                     </c:if>
            
            
            
   </c:if>
       
       </c:if>
  
  
  
  </c:if>

            

              
</div>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

	<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>


</body>
</html>