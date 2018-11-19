<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >
<html>
<head>

<title>Mon profil </title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Profil d'un patient d' ENAD.">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png" href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet"/>

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

              <c:if test="${ ! empty actif  }">
              
                      <c:if test="${  actif eq 'patient'  }">
                      
                             <c:if test="${ ! empty action  }">
                             
                                     <c:if test="${  action eq 'consulteretmodifier'  }">
                                     
                                     <c:import url="/inc/verificationModificationProfilPatient.jsp" />
                                     
                                     <c:import url="/inc/enadnotice.jsp"/>
              
              <div class="row">
      
            <div class="col-xs-12">
            
                    <div class="enad_ENAD">
                    
                    <c:if test="${ ! empty sessionScope.sessionPatient }">
                     
                     <c:if test="${ sessionScope.sessionPatient.sexe_patient eq 'homme' }">
                     
                     Profil du patient
                     
                     </c:if>
                     
                     <c:if test="${ sessionScope.sessionPatient.sexe_patient eq 'femme' }"> Profil de la patiente </c:if>
                     
                     </c:if>
                    
                    
                    
                     
                    
                    <c:if test="${ ! empty sessionScope.sessionPatient }">
${sessionScope.sessionPatient.prenoms_patient }  ${sessionScope.sessionPatient.noms_patient }


</c:if>

<br>

<!-- photo -->
                    
                    </div>
            </div>
      
      
      
      </div>
      
      
      <c:import url="/inc/presentationPatient.jsp"/>
      
      <br>
      
      <div class="row">
      
             <!-- CONTACTS -->

			<c:import url="/inc/contactspat.jsp" />
			
			<!-- MENU -->

			<div class="col-xs-8">
			
			       <div class="menumed">
			       
			       <div class="row">
			       
			                <div class="col-xs-5 ">
			                
			                      <div class="boutontestsetresultats">
			                             
			                                 <button data-toggle="modal" data-backdrop="false"  data-target="#nomspat" class="btn-block buttonsmenu"
									><i
									class="fa fa-pencil"></i><br />Noms</button>
									
									
									<div class="modal fade" id="nomspat" role="dialog" aria-labelledby="nomspatLabel" aria-hidden="true">
									
									      <div class="modal-dialog modal-lg">
									      
									          <div class="modal-content">
									          
									               <div class="modal-header">
									               
									                   <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                             <h2 class="modal-title">Je modifie mon nom ou mes noms.</h2>
									               
									               
									               </div>
									               
									               <div class="modal-body well">
									               
									                     <div class="row">
									                     
									                          <div class="col-xs-12">
									                          
									                               <div class="enad_ins_pat">
									                               
									                                    <form action="<c:url value="/modification_noms_Patient"/>" method="post" class="col-xs-12 ">
									                                    
									                                          <fieldset>
									                                          
									                                               <br>
									                                               
									                                               <div class="form-group">
									                                               
									                                                   <p class="titres_ins_patient">Nom(s)</p>
									                                                   
									                                                          <label for="nomsPatient"></label> <input
									class="form-control input-lg" type="text" id="nomsPatient"
									name="nomsPatient"
									placeholder="S'il vous plaît, veuillez saisir votre nom ou vos noms. Merci pour votre compréhension."
									value="<c:out value="${patient.noms_patient }"/>" required />

								<c:if test="${! empty formnoms.erreurs['nomsPatient'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formnoms.erreurs['nomsPatient'] }</p>

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
			                
			                <div class=" col-xs-5 col-xs-push-2">
			                
			                             <div class="boutoncarnetsdesante">
			                             
			                                  <button data-toggle="modal" data-backdrop="false"  data-target="#prenomspat" class="btn-block buttonsmenu"
									><i
									class="fa fa-pencil"></i><br />Prénoms</button>
									
									<div class="modal fade" id="prenomspat" role="dialog" aria-labelledby="prenomspatLabel" aria-hidden="true">
									
									              <div class="modal-dialog modal-lg">
									              
									              
									                     <div class="modal-content">
									                     
									                     
									                            <div class="modal-header">
									                            
									                                    <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                               <h2 class="modal-title">Je modifie mon prénom ou mes prénoms.</h2>
									           
									                            
									                            </div>
									                            
									                            <div class="modal-body well">
									                            
									                                     <div class="row">
									                                     
									                                           <div class="col-xs-12">
									                                           
									                                           
									                                                 <div class="enad_ins_pat">
									                                                 
									                                                     <form action="<c:url value="/modification_prenoms_Patient"/>" method="post" class="col-xs-12 ">
									                                                     
									                                                           <fieldset>
									                                                           
									                                                                <br>
									                                                                
									                                                                           <div class="form-group">

								<p class="titres_ins_patient">Prénom(s) </p>

								<label for="prenomsPatient"></label> <input
									class="form-control input-lg" type="text" id="prenomsPatient"
									name="prenomsPatient"
									placeholder="S'il vous plaît, veuillez saisir votre prénom ou vos prénoms. Merci pour votre compréhension."
									value="<c:out value="${patient.prenoms_patient }"/>" />

								<c:if test="${! empty formprenoms.erreurs['prenomsPatient'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formprenoms.erreurs['prenomsPatient'] }</p>

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
			       
			       <br>
			       <br>
			       
			       <div class="row">
			       
			              <div class="col-xs-5 ">
			                
			                      <div class="boutontestsetresultats">
			                      
			                             <button data-toggle="modal" data-backdrop="false"  data-target="#identifiantpat" class="btn-block buttonsmenu"
									><i
									class="fa fa-pencil"></i><br />Identifiant</button>
									
									<div class="modal fade" id="identifiantpat" role="dialog" aria-labelledby="identifiantpatLabel" aria-hidden="true">
									
									         <div class="modal-dialog modal-lg">
									         
									                <div class="modal-content">
									                
									                       <div class="modal-header ">
									                     
									                     <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                               <h2 class="modal-title">Je modifie mon identifiant.</h2>
									                 
									                     
									                     </div>
									                     
									                     <div class="modal-body well ">
									                     
									                           <div class="row">
									                           
									                                 <div class="col-xs-12">
									                                 
									                                      
									                                         <div class="enad_ins_pat">
									                                         
									                                                <form method="post" class="col-xs-12 " action="<c:url value="/modification_identifiant_Patient"/>">
									                                                
									                                                        <fieldset>
									                                                        
									                                                             <br>
									                                                             
									                                                             <div class="form-group">

								<p class="titres_ins_patient">Identifiant</p>

								<label for="identifiantPatient"></label> <input
									class="form-control input-lg" type="text"
									id="identifiantPatient" name="identifiantPatient"
									placeholder="S'il vous plaît, veuillez saisir un identifiant unique pour recevoir un contenu qui vous est destiné. Merci pour votre compréhension."
									value="<c:out value="${patient.identifiant_patient }"/>"
									required />

								<c:if test="${! empty formidentifiant.erreurs['identifiantPatient'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formidentifiant.erreurs['identifiantPatient'] }</p>

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
									test="${! empty formidentifiant.erreurs['confirmeidentifiantPatient'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formidentifiant.erreurs['confirmeidentifiantPatient'] }</p>

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
			                
			                <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
			                
			                
			                
			                
			                <div class=" col-xs-5 col-xs-push-2">
			                
			                             <div class="boutoncarnetsdesante">
			                             
			                                    <button data-toggle="modal" data-backdrop="false"  data-target="#sexepat" class="btn-block buttonsmenu"
									><i
									class="fa fa-pencil"></i><br />Sexe</button>
									
									<div class="modal fade" id="sexepat" role="dialog" aria-labelledby="sexepatLabel" aria-hidden="true">
									
									        <div class="modal-dialog modal-lg">
									        
									               <div class="modal-content">
									               
									                     <div class="modal-header">
									                     
									                            <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                               <h2 class="modal-title">Je modifie mon sexe.</h2>
									                 
									                     </div>
									                     
									                     <div class="modal-body well">
									                     
									                           <div class="row">
									                           
									                           
									                                 <div class="col-xs-12">
									                                 
									                                 
									                                       <div class="enad_ins_pat">
									                                       
									                                              <form method="post" class="col-xs-12 " action="<c:url value="/modification_sexe_Patient"/>">
									                                              
									                                                      <fieldset>
									                                                      
									                                                         <br>
									                                                         
									                                                         <div class="form-group">



								<p class="titres_ins_patient">Sexe </p>



								<label for="femme">Femme</label> <input type="radio" id="femme"
									name="sexe" value="femme" /> <label for="homme">Homme</label>
								<input type="radio" id="homme" name="sexe" value="homme" />

								<c:if test="${! empty formsexe.erreurs['sexe'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formsexe.erreurs['sexe'] }</p>

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
									<h4>Je modifie mon sexe.</h4>
								</button>
								
								<c:if test="${! empty formsexe.resultat}">

								<br />



								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>

									<p>${formsexe.resultat}</p>

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
			       
			       
			       
			       <div class="row hide">
			       
			              <div class="col-xs-5 ">
			                
			                      <div class="boutontestsetresultats">
			                      
			                      
			                                      <button data-toggle="modal" data-backdrop="false"  data-target="#massepat" class="btn-block buttonsmenu"
									><i
									class="fa fa-pencil"></i><br />Masse</button>
									
									<div class="modal fade" id="massepat" role="dialog" aria-labelledby="massepatLabel" aria-hidden="true">
									
									      <div class="modal-dialog modal-lg">
									      
									             <div class="modal-content">
									             
									             
									                    <div class="modal-header">
									                    
									                    <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                               <h2 class="modal-title">Je modifie ma masse corporelle.</h2>
									                 
									                    
									                    </div>
									                    
									                    <div class="modal-body well">
									                    
									                         <div class="row">
									                         
									                         
									                             <div class="col-xs-12">
									                             
									                                   <div class="enad_ins_pat">
									                                   
									                                   
									                                         <form method="post" class="col-xs-12 " action="<c:url value="/modification_masse_Patient"/>">
									                                         
									                                               <fieldset>
									                                               
									                                               <br>
									                                               
									                                               <div class="form-group">
									                                               
									                                                     
									                                                     
									                                                     
									                                                     <c:if test="${ ! empty massepatientexiste  }">
									                                                     
									                                                     
									                                                         <c:if test="${  massepatientexiste eq 'oui'  }">
									                                                         
									                                                         <p class="titres_ins_patient">Masse: ${sessionScope.sessionPatient.masse_patient } Kg</p>
									                                                         
									                                                         
									                                                         
									                                                         </c:if>
									                                                         
									                                                         
									                                                         
									                                                         <c:if test="${  massepatientexiste eq 'non'  }">
									                                                         
									                                                             <p class="titres_ins_patient">Vous n'avez pas fourni votre masse.</p>
									                                                         
									                                                         
									                                                         
									                                                         
									                                                         </c:if>
									                                                     
									                                                     
									                                                     
									                                                     
									                                                     </c:if>
									                                               
									                                               
									                                               </div>
									                                               
									                                               
									                                               
									                                               <div class="form-group">
									                                               
									                                                         <label for="massePatient"></label> <input
									class="form-control input-lg" type="text" id="massePatient"
									name="massePatient"
									placeholder="S'il vous plaît, veuillez saisir votre masse en kilogrammes. Exemples: 100 ou 100.4 "
									value="<c:out value="${patient.masse_patient }"/>" required />
									
									<c:if test="${! empty formmasse.erreurs['massePatient'] }">

									<br />
									
									


									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formmasse.erreurs['massePatient'] }</p>

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
									<h4>Je modifie ma masse.</h4>
								</button>
								
								<c:if test="${! empty formmasse.resultat}">

								<br />



								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>

									<p>${formmasse.resultat}</p>

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
			                
			                <div class=" col-xs-5 col-xs-push-2">
			                
			                             <div class="boutoncarnetsdesante">
			                             
			                                          <button data-toggle="modal" data-backdrop="false"  data-target="#taillepat" class="btn-block buttonsmenu"
									><i
									class="fa fa-pencil"></i><br />Taille</button>
									
									<div class="modal fade" id="taillepat" role="dialog" aria-labelledby="taillepatLabel" aria-hidden="true">
									
									        <div class="modal-dialog modal-lg">
									        
									        
									             <div class="modal-content">
									             
									                     <div class="modal-header">
									                     
									                               <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                               <h2 class="modal-title">Je modifie ma taille.</h2>
							
									                     
									                     
									                     </div>
									                     
									                     <div class="modal-body well">
									                     
									                             <div class="row">
									                             
									                                    <div class="col-xs-12">
									                                    
									                                           <div class="enad_ins_pat">
									                                           
									                                                <form method="post" class="col-xs-12 " action="<c:url value="/modification_taille_Patient"/>">
									                                                
									                                                
									                                                      <fieldset>
									                                                      
									                                                      <br>
									                                                      
									                                                      <div class="form-group">
									                                                      
									                                                           <c:if test="${ ! empty taillepatientexiste  }">
									                                                     
									                                                     
									                                                         <c:if test="${  taillepatientexiste eq 'oui'  }">
									                                                         
									                                                         <p class="titres_ins_patient">Taille: ${sessionScope.sessionPatient.taille_patient } m</p>
									                                                         
									                                                         
									                                                         
									                                                         </c:if>
									                                                         
									                                                         
									                                                         
									                                                         <c:if test="${  taillepatientexiste eq 'non'  }">
									                                                         
									                                                             <p class="titres_ins_patient">Vous n'avez pas fourni votre taille.</p>
									                                                         
									                                                         
									                                                         
									                                                         
									                                                         </c:if>
									                                                     
									                                                     
									                                                     
									                                                     
									                                                     </c:if>
									                                               
									                                                      
									                                                      
									                                                      </div>
									                                                      
									                                                      <div class="form-group">
									                                                      
									                                                               <label for="taillePatient"></label> <input
									class="form-control input-lg" type="text" id="taillePatient"
									name="taillePatient"
									placeholder="S'il vous plaît, veuillez saisir votre taille en mètre(s). Exemples: 100 ou 100.4 "
									value="<c:out value="${patient.taille_patient }"/>" required />
									
									<c:if test="${! empty formtaille.erreurs['taillePatient'] }">

									<br />
									
									


									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formtaille.erreurs['taillePatient'] }</p>

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
									<h4>Je modifie ma taille.</h4>
								</button>
								
								<c:if test="${! empty formtaille.resultat}">

								<br />



								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>

									<p>${formtaille.resultat}</p>

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
			       
			       <br>
			       <br>
			       
			       <div class="row">
			       
			               <div class="col-xs-5 ">
			                
			                      <div class="boutontestsetresultats">
			                      
			                                       <button data-toggle="modal" data-backdrop="false"  data-target="#datenaissancepat" class="btn-block buttonsmenu"
									><i
									class="fa fa-pencil"></i><br />Date de naissance</button>
									
									<div class="modal fade" id="datenaissancepat" role="dialog" aria-labelledby="datenaissancepatLabel" aria-hidden="true">
									
									       
									            <div class="modal-dialog modal-lg">
									            
									            
									                   <div class="modal-content">
									                   
									                   
									                            <div class="modal-header">
									                            
									                            <button type="button" class="close" data-dismiss="modal"><span class="glyphicon glyphicon-remove-circle"></span></button>
                                                                                 
                                                               <h2 class="modal-title">Je modifie ma date de naissance.</h2>
							
									                            
									                            
									                            
									                            </div>
									                            
									                            <div class="modal-body well">
									                            
									                            
									                                  <div class="row">
									                                  
									                                  
									                                        <div class="col-xs-12">
									                                        
									                                        
									                                              <div class="enad_ins_pat">
									                                              
									                                                     
									                                                     <form method="post" class="col-xs-12 " action="<c:url value="/modification_datenaissance_Patient"/>">
									                                                     
									                                                     
									                                                              <br>
									                                                              
									                                                              
									                                                              <fieldset>
									                                                              
									                                                                      <div class="form-group">

								<p class="titres_ins_patient">Date de naissance</p>

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
									name="datedenaissance"
									value="<c:out value="${patient.date_naissance_patient }"/>"
									placeholder="S'il vous plaît, veuillez sélectionner votre date de naissance en utilisant le calendrier. Merci pour votre compréhension."
									required />

								<c:if test="${! empty formdatenaissance.erreurs['datedenaissance'] }">


									<br />
									<div class="alert alert-info alert-dismissable col-xs-12">

										<button type="button" class="close" data-dismiss="alert">&times;</button>

										<p>${formdatedenaissance.erreurs['datedenaissance'] }</p>

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
									<h4>Je modifie ma date de naissance.</h4>
								</button>
								
								<c:if test="${! empty formdatenaissance.resultat}">

								<br />



								<div class="alert alert-danger alert-dismissable col-xs-12">

									<button type="button" class="close" data-dismiss="alert">&times;</button>

									<p>${formdatenaissance.resultat}</p>

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
			                
			                <div class="col-xs-5 col-xs-push-2">

							<div class="boutongroupes">

								<a class="btn-block buttonsmenu"
									href="<c:url value="/medecinsduPatient"/>"><i
									class="fa fa-user-md"></i><br />Mes médecins</a>


							</div>



						</div>
			       
			       </div>
			       
			       <br>
			       <br>
			       
			       
			    
			       
			       </div>
			
			</div>
			
			<!-- NOTIFS  -->

			<c:import url="/inc/notifspat.jsp" />
      
      
      
      </div>
      
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
              
              

<c:import url="/inc/footer.jsp"/>
                                     
                                     
                                     </c:if>
                                     
                                     
                                     <c:if test="${  action eq 'consulter'  }">
                                     
                                     <script type="text/javascript">
                    
                    function redirect()
                    
                    {
                    	window.location='/enad/profil_Patient?identifiant=${sessionScope.sessionPatient.identifiant_patient }';
                    }
                    
                    setTimeout(redirect,1);
                    
                    
                    
                    
                    </script>
                                     
                                     <c:import url="/inc/enadnotice.jsp"/>
              
              <div class="row">
      
            <div class="col-xs-12">
            
                    <div class="enad_ENAD">
                    
                    <c:if test="${ ! empty patientconsulter }">
                    
                    
                     
                     <c:if test="${ patientconsulter.sexe_patient eq 'homme' }">
                     
                     Profil du patient
                     
                     </c:if>
                     
                     <c:if test="${ patientconsulter.sexe_patient eq 'femme' }"> Profil de la patiente </c:if>
                     
                     </c:if>
                    
                    
                    
                     
                    
                    <c:if test="${ ! empty patientconsulter }">
${patientconsulter.prenoms_patient }  ${patientconsulter.noms_patient }


</c:if>



<c:if test="${ ! empty  patientconsulter.url_photo_patient  }">

<br>


<img style="margin:auto;" class="" width="200" height="200" id="img" alt="ENAD" src="http://${  sessionScope.adresseserveur }:8080/enad${  patientconsulter.url_photo_patient }" >
        


</c:if>
      
                        
                    
                    </div>
            </div>
      
      
      
      </div>
      
      
      <c:import url="/inc/presentationPatient.jsp"/>
      
      <br>
      
      <div class="row">
      
                 <!-- CONTACTS -->
                 
                 <c:import url="/inc/contactspat.jsp" />
                 
                 <!-- MENU -->
                 
                 <div class="col-xs-8">
                 
                         <div class="menumed">
                         
                         <h1>
                         
                         <c:if test="${ ! empty patientconsulter }">
                         
                         Vous êtes sur le
                     
                     <c:if test="${ patientconsulter.sexe_patient eq 'homme' }">
                     
                     profil d'un autre patient.
                     
                     </c:if>
                     
                     <c:if test="${ patientconsulter.sexe_patient eq 'femme' }"> profil d'une autre patiente. </c:if>
                     
                     </c:if>
                     
                     </h1>
                         
                         </div>
                 
                 
                 </div>
                 
                 <!-- NOTIFS  -->

			    <c:import url="/inc/notifspat.jsp" />
                 
      
      
      </div>
      
      <br>
      <br>
      <br>
      <br>
      <br>
      
      
      
              
              

<c:import url="/inc/footer.jsp"/>
                                     
                                     
                                     </c:if>
                             
                             
                             </c:if>
                      
                      </c:if>
                      
                      <c:if test="${  actif eq 'medecin'  }">
                           
                               <c:import url="/inc/enadnotice.jsp"/>
              
              <div class="row">
      
            <div class="col-xs-12">
            
                    <div class="enad_ENAD">
                    
                    <c:if test="${ ! empty patientprofil }">
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'homme' }">
                     
                     Profil du patient ${patientprofil.prenoms_patient }  ${patientprofil.noms_patient } né ${patientprofil.affichage_date_naissance }
                     
                     </c:if>
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'femme' }"> Profil de la patiente ${patientprofil.prenoms_patient }  ${patientprofil.noms_patient } née ${patientprofil.affichage_date_naissance } </c:if>
                     
                     </c:if>
                    
                    
                    
                     
                   


      
      <c:if test="${! empty patientprofil.url_photo_patient }">
      
      <br>
      
      
      <img class="" style="margin:auto;" width="200" height="200" id="img" alt="ENAD" src="http://${  sessionScope.adresseserveur }:8080/enad${patientprofil.url_photo_patient}" >
                          
      
      
      
      
      </c:if>
                    
                    </div>
            </div>
      
      
      
      </div>
      
      
      <c:import url="/inc/presentationMedecin.jsp"/>
      
      <br>
      
      <div class="row">
      
                <!-- CONTACTS -->
                
                <c:import url="/inc/contactsmed.jsp" />
                
                <!-- MENU -->
                
                <div class="col-xs-8">
                
                       <div class="menumed">
                       
                                 <c:if test="${ ! empty liaisonmedpat }">
                         
                                <c:if test="${  liaisonmedpat eq 'oui' }">
                                
                                <c:if test="${ ! empty liaisonmedtraitantpat }">
                                
                                <c:if test="${  liaisonmedtraitantpat eq 'oui' }">
                                
                                     <div class="row relationavecmedecintraitantoui">
                                     
                                     <script type="text/javascript">
         
         var plusinfo = new SpeechSynthesisUtterance("Vous êtes son médecin traitant.");
         
         plusinfo.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinfo);

         
         </script>
                                     
                                          Vous êtes son médecin traitant.
                                     
                                     
                                     </div>
                                
                                
                                
                                </c:if>
                                
                                <c:if test="${  liaisonmedtraitantpat eq 'non' }">
                                
                                   <div class="row relationavecmedecintraitantnon">
                                   
                                   <script type="text/javascript">
         
         var plusinf = new SpeechSynthesisUtterance("Vous êtes en relation  mais vous n'êtes pas son  médécin traitant.");
         
         plusinf.lang='fr-FR';
         
         window.speechSynthesis.speak(plusinf);

         
         </script>
                                     
                                          Vous êtes en relation  mais vous n'êtes pas son  médécin traitant.
                                     
                                     
                                     </div>
                                
                                
                                
                                <c:if test="${  !empty avoirmdt }">
                                
                                <c:if test="${  avoirmdt eq 'oui' }">
                                
                                </c:if>
                                
                                <c:if test="${  avoirmdt eq 'non' }">
                                
                                  <div class="row sansmedecintraitant">
                                  
                                       <c:if test="${ ! empty patientprofil }">
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'homme' }">
                     
                     <script type="text/javascript">
         
         var plusin = new SpeechSynthesisUtterance("Ce patient n'a pas de médecin traitant.");
         
         plusin.lang='fr-FR';
         
         window.speechSynthesis.speak(plusin);

         
         </script>
                     
                     Ce patient
                     
                     </c:if>
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'femme' }"> 
                     
                     <script type="text/javascript">
         
         var plusi = new SpeechSynthesisUtterance("Cette patiente n'a pas de médecin traitant.");
         
         plusi.lang='fr-FR';
         
         window.speechSynthesis.speak(plusi);

         
         </script>
                     
                     
                     Cette patiente 
                     
                     </c:if>
                     
                     </c:if> 
                     
                     
                     
                                       
                                       
                                       n'a pas de médecin traitant.
                                  
                                  </div>
                                
                                
                                
                                                                                      <c:if test="${ ! empty demandeliaisonmedt }">
                                       
                                                       <c:if test="${  demandeliaisonmedt eq 'oui' }">
                                                       
                                                              <c:if test="${ ! empty demandeliaisonmedtsens }">
                                                              
                                                                       <c:if test="${  demandeliaisonmedtsens eq 'gauchedroite' }">
                                                                       
                                                                       
                                                                       
                                                                       <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/confirmation_medt_pat?ide_em=${patientprofil.identifiant_patient}&ide_dest=${sessionScope.sessionMedecin.identifiant_medecin }&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je confirme la demande de mise en relation de cette personne en tant que médecin traitant.</a>
                                                                       
                                                                       </c:if>
                                                                       
                                                                       <c:if test="${  demandeliaisonmedtsens eq 'droitegauche' }">
                                                                       
                                                                       <div class="row demandeattentevalidation">
                                                                       
                                                                       
                                                                       
                                                                       Votre demande de médecin traitant est en attente de validation par 
                                                                       
                                                                       
                                                                       
                                                                       <c:if test="${ ! empty patientprofil }">
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'homme' }">
                     
                     <script type="text/javascript">
         
         var plu = new SpeechSynthesisUtterance("Votre demande de médecin traitant est en attente de validation par ce patient.");
         
         plu.lang='fr-FR';
         
         window.speechSynthesis.speak(plu);

         
         </script>
                     
                     ce patient.
                     
                     </c:if>
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'femme' }">
                     
                     <script type="text/javascript">
         
         var pl = new SpeechSynthesisUtterance(" Votre demande de médecin traitant est en attente de validation par cette patiente.");
         
         pl.lang='fr-FR';
         
         window.speechSynthesis.speak(pl);

         
         </script>
                     cette patiente. </c:if>
                     
                     </c:if>
                                                                       
                                                                       
                                                                       
                                                                       
                                                                       </div>
                                                                       
                                                                       
                                                                       </c:if>
                                                              
                                                              
                                                              
                                                              </c:if>
                                
                                
                                                       </c:if>
                                        
                                                      <c:if test="${  demandeliaisonmedt eq 'non' }">
                                                      
                                                      
                                                      
                                                      <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/etreenrelation_medt_pat?ide_em=${sessionScope.sessionMedecin.identifiant_medecin }&ide_dest=${patientprofil.identifiant_patient}&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je souhaite être votre médecin traitant.</a>
                                
                                
                                                      </c:if>
                                       
                                       
                                       </c:if>
      
                                
                                </c:if>
                                
                                
                                </c:if>
                                
                          
                                </c:if>
                                
                                </c:if>
                                
                                
                                
                                        
                                
                                
                                
                                </c:if>
                                
                                <c:if test="${  liaisonmedpat eq 'non' }">
                                
                                <div class="row relationavecmedecinnon">
                                
                                
                                
                                   Vous n'êtes pas en relation avec 
                                   
                                   <c:if test="${ ! empty patientprofil }">
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'homme' }">
                     
                     <script type="text/javascript">
         
         var h = new SpeechSynthesisUtterance("Vous n'êtes pas en relation avec ce patient.");
         
         h.lang='fr-FR';
         
         window.speechSynthesis.speak(h);

         
         </script>
                     
                     ce patient .
                     
                     </c:if>
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'femme' }"> 
                     
                     <script type="text/javascript">
         
         var q = new SpeechSynthesisUtterance("Vous n'êtes pas en relation avec cette patiente.");
         
         q.lang='fr-FR';
         
         window.speechSynthesis.speak(q);

         
         </script>
                     cette patiente . </c:if>
                     
                     </c:if>
                     
                     
                                   
                                   
                                
                                
                                </div>
                                
                                
                                
                                
                                              <c:if test="${  ! empty demandeliaisonmedpat }">
                                              
                                              
                                                          <c:if test="${   demandeliaisonmedpat eq 'oui' }">
                                                          
                                                                 <c:if test="${  ! empty demandeliaisonmedpatsens }"> 
                                                                 
                                                                 
                                                                          <c:if test="${   demandeliaisonmedpatsens eq 'gauchedroite' }">
                                                                          
                                                                          
                                                                          
                                                                          <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/confirmation_med_pat?ide_em=${patientprofil.identifiant_patient}&ide_dest=${sessionScope.sessionMedecin.identifiant_medecin }&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je confirme la demande de mise en relation de 
                                                                          
                                                                          <c:if test="${ ! empty patientprofil }">
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'homme' }">
                     
                     
                     
                     ce patient .
                     
                     </c:if>
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'femme' }"> 
                     
                     
                     
                     cette patiente . </c:if>
                     
                     </c:if>
                                                                          
                                                                          
                                                                          
                                                                          </a>
                                                                          
                                                                          </c:if>
                                                                          
                                                                          <c:if test="${   demandeliaisonmedpatsens eq 'droitegauche' }">
                                                                          
                                                                          <div class ="row demandeattentevalidation">
                                                                          
                                                                          
                                                                          
                                                                           Votre demande est en attente de validation par 
                                                                           
                                                                           <c:if test="${ ! empty patientprofil }">
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'homme' }">
                     
                     <script type="text/javascript">
         
         var dfah = new SpeechSynthesisUtterance("Votre demande est en attente de validation par ce patient.");
         
         dfah.lang='fr-FR';
         
         window.speechSynthesis.speak(dfah);

         
         </script>
                     
                     ce patient .
                     
                     </c:if>
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'femme' }">
                     
                     
                     <script type="text/javascript">
         
         var dfahu = new SpeechSynthesisUtterance("Votre demande est en attente de validation par cette patiente.");
         
         dfahu.lang='fr-FR';
         
         window.speechSynthesis.speak(dfahu);

         
         </script>
                     
                      cette patiente . </c:if>
                     
                     </c:if>
                                                                          
                                                                          
                                                                          </div>
                                                                          
                                                                         
                                                                          
                                                                          </c:if>
                                                                 
                                                                 
                                                                         
                                                                 
                                                                 
                                                                 
                                                                 </c:if>
                                                                 
                                                                 
                                                          
                                                          </c:if>
                                                          
                                                          <c:if test="${   demandeliaisonmedpat eq 'non' }">
                                                          
                                                          
                                                          
                                                          <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/etreenrelation_med_pat?ide_em=${sessionScope.sessionMedecin.identifiant_medecin }&ide_dest=${patientprofil.identifiant_patient}&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je souhaite être en relation avec 
                                                          
                                                          <c:if test="${ ! empty patientprofil }">
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'homme' }">
                     
                     
                     
                     ce patient .
                     
                     </c:if>
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'femme' }">
                     
                     
                     
                      cette patiente . </c:if>
                     
                     </c:if>
                                                          
                                                          </a>
                                                          
                                                          </c:if>
                                              
                                                      
                                              
                                              
                                              </c:if>
                                              
                                              <c:if test="${  !empty avoirmdt }">
                                
                                <c:if test="${  avoirmdt eq 'oui' }">
                                
                                
                                
                                </c:if>
                                
                                <c:if test="${  avoirmdt eq 'non' }">
                                
                                <div class="row sansmedecintraitant">
                                  
                                       <c:if test="${ ! empty patientprofil }">
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'homme' }">
                     
                     <script type="text/javascript">
         
         var dfahuiih = new SpeechSynthesisUtterance("Ce patient n'a pas de médecin traitant .");
         
         dfahuiih.lang='fr-FR';
         
         window.speechSynthesis.speak(dfahuiih);

         
         </script>
                     
                     Ce patient
                     
                     </c:if>
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'femme' }">
                     
                     <script type="text/javascript">
         
         var az = new SpeechSynthesisUtterance("Cette patiente n'a pas de médecin traitant .");
         
         az.lang='fr-FR';
         
         window.speechSynthesis.speak(az);

         
         </script>
                     
                      Cette patiente </c:if>
                     
                     </c:if>
                     
                     
                                       
                                       
                                       
                                       n'a pas de médecin traitant .
                                  
                                  </div>
                                
                                                                                      <c:if test="${ ! empty demandeliaisonmedt }">
                                       
                                                       <c:if test="${  demandeliaisonmedt eq 'oui' }">
                                                       
                                                              <c:if test="${ ! empty demandeliaisonmedtsens }">
                                                              
                                                                       <c:if test="${  demandeliaisonmedtsens eq 'gauchedroite' }">
                                                                       
                                                                       
                                                                       
                                                                       <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/confirmation_medt_pat?ide_em=${patientprofil.identifiant_patient}&ide_dest=${sessionScope.sessionMedecin.identifiant_medecin }&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je confirme la demande de mise en relation de 
                                                                       
                                                                       
                                                                       
                                                                       <c:if test="${ ! empty patientprofil }">
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'homme' }">
                     
                     ce patient 
                     
                     </c:if>
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'femme' }"> cette patiente  </c:if>
                     
                     </c:if>
                                                                       
                                                                        en tant que médecin traitant.
                                                                        
                                                                        
                                                                        
                                                                        </a>
                                                                       
                                                                       </c:if>
                                                                       
                                                                       <c:if test="${  demandeliaisonmedtsens eq 'droitegauche' }">
                                                                       
                                                                       <div class="row demandeattentevalidation">
                                                                       
                                                                       
                                                                       
                                                                       Votre demande de médecin traitant est en attente de validation par 
                                                                       
                                                                       
                                                                       <c:if test="${ ! empty patientprofil }">
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'homme' }">
                     
                     <script type="text/javascript">
         
         var io = new SpeechSynthesisUtterance(" Votre demande de médecin traitant est en attente de validation par ce patient.");
         
         io.lang='fr-FR';
         
         window.speechSynthesis.speak(io);

         
         </script>
                     
                     ce patient .
                     
                     </c:if>
                     
                     <c:if test="${ patientprofil.sexe_patient eq 'femme' }"> 
                     <script type="text/javascript">
         
         var ioj = new SpeechSynthesisUtterance("Votre demande de médecin traitant est en attente de validation par cette patiente.");
         
         ioj.lang='fr-FR';
         
         window.speechSynthesis.speak(ioj);

         
         </script>
                     
                     cette patiente . </c:if>
                     
                     </c:if>
                                                                       
                                                                       
                                                                       </div>
                                                                       
                                                                       </c:if>
                                                              
                                                              
                                                              
                                                              </c:if>
                                
                                
                                                       </c:if>
                                        
                                                      <c:if test="${  demandeliaisonmedt eq 'non' }">
                                                      
                                                   
                                                      
                                                      <a class="btn btn-primary btn-lg btn-block "  href="<c:url value="/etreenrelation_medt_pat?ide_em=${sessionScope.sessionMedecin.identifiant_medecin }&ide_dest=${patientprofil.identifiant_patient}&page=${profil}"/>"><span class="glyphicon glyphicon-info-sign"></span> <br/>Je souhaite être son  médecin traitant.</a>
                                
                                
                                                      </c:if>
                                       
                                       
                                       </c:if>
      
                                
                                </c:if>
                                
                                
                                </c:if>
                                
                                
                                
                                       
                                        
                                
                                
                                </c:if>
                         
                         
                         </c:if>
                       
                       
                       </div>
                
                
                </div>
                
                <!-- NOTIFS -->
                
                <c:import url="/inc/notifsmed.jsp" />
                
                
      
      </div>
      
      <br>
      <br>
      <br>
      <br>
      <br>
      <br>
              
              

<c:import url="/inc/footer.jsp"/>
                               
                      
                      </c:if>
              
              </c:if>
</div>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>


</body>
</html>