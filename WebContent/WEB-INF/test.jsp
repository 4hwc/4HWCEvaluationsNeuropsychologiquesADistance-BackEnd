<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html >
<html>
<head>

<title>Réalisation de la Figure complexe de Rey-Osterrieth</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Réalisation de la Figure Complexe de Rey-Osterrieth">
<meta name="author" content="ENAD">

<style type="text/css">

canvas {border-style:solid;}

</style>

<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet" />

<style type="text/css">

.containerinterface {
	-moz-box-shadow: 8px 8px 12px #aaa;
	-webkit-box-shadow: 8px 8px 12px #aaa;
	box-shadow: 8px 8px 12px #555;
	border: 2px solid #666;
	border-radius: 4px;
	margin-top: 10px;
	height: 90%;
}

.btn-group {
	padding-top: 10px;
}
.btn-group-vertical .btn {
	width: 30%;
}
.btn-group + .btn-group-vertical {
    margin-left: 0;
}


.span1 {
	padding-left: 10px;
	width: 100%;
}
.thumbnail {
	padding-bottom: 0;
}

form {
	margin-top: 10px;
	margin-left: 90px;
}
#width {
	max-width: 20px;
}
label {
	margin-left: 10px;
}



</style>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->




</head>
<body>

<div class="container">

      <div class="row">
      
              <c:if test="${  sessionuser eq 'patient'  }">
              
              
                      <c:if test="${  main eq 'gauche'  }">
                      
                                     <div class="col-xs-7">
                                     
                                        <div class="containerinterface">
                                        
                                               <div class="row">
                                               
                                                       <nav class="span1">
                                          
                                               <div class="navbar">
                                               
                                                    <div class="navbar-inner"> <a class="brand" href="#">ENAD FCRO</a>
                                                    
                                                    
                                                             <ul class="nav">
                                                             
                                                                  <li class="divider-vertical"></li>
                                                                  
                                                                  <li id="fichier" class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#"> Fichier</a>
                                                                  
                                                                       <ul class="dropdown-menu">
                                                                       
                                                                           <li> <a href="#" id="nouveau">Nouveau...</a> </li>
                                                                       
                                                                       
                                                                       </ul>
                                                                  
                                                                  </li>
                                                                  
                                                                  <li id="modifier" class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#">Modifier</a>
                                                                  
                                                                       <ul class="dropdown-menu">
                                                                       
                                                                            <li class="dropdown-submenu"> <a tabindex="-1" href="#">Arranger</a>
                                                                            
                                                                                 <ul class="dropdown-menu">
                                                                                 
                                                                                      <li> <a href="#" id="go_up">Envoyer à l'avant</a> </li>
                                                                                      
                                                                                      <li> <a href="#" id="go_down">Envoyer à l'arrière</a> </li>
                                                                                      
                                                                                      <li> <a href="#" id="go_front">Envoyer au premier plan</a> </li>
                                                                                      
                                                                                      <li> <a href="#" id="go_back">Envoyer à l'arrière plan</a> </li>
                                                                                      
                                                                                 
                                                                                 
                                                                                 </ul>
                                                                            
                                                                            
                                                                            </li>
                                                                            
                                                                            <li class="dropdown-submenu"> <a tabindex="-1" href="#">Edition</a>
                                                                            
                                                                                 <ul class="dropdown-menu">
                                                                                 
                                                                                        <li> <a href="#" id="annuler">Annuler</a> </li>
                                                                                        
                                                                                        <li> <a href="#" id="repeter">Répéter</a> </li>
                                                                                        
                                                                                        <li> <a href="#" id="supprimer">Supprimer</a> </li>
                                                                                        
                                                                                        <li class="divider"></li>
                                                                                        
                                                                                        <li> <a href="#" id="copier">Copier</a> </li>
                                                                                        
                                                                                        <li> <a href="#" id="coller">Coller</a> </li>
                                                                                        
                                                                                 
                                                                                 
                                                                                 </ul>
                                                                            
                                                                            
                                                                            </li>
                                                                       
                                                                       
                                                                       </ul>
                                                                  
                                                                  
                                                                  </li>
                                                             
                                                             
                                                             
                                                             </ul>
                                                             
                                                             
                                                             
                                               
                                               
                                               
                                                    </div>
                                               
                                               
                                               
                                               </div>
                                               
                                          
                                          
                                          </nav>
                                            
                                            
                                            
                                       </div>
                                       
                                       <div id="canvascont" class="row">
                                       
                                            <aside class="span1">
                                            
                                                 <div id="mode" class="btn-group btn-group-vertical" data-toggle="buttons-radio">
                                                 
                                                       <a href="#" class="btn active" rel="tooltip" data-original-title="Sélection"><i class="icon-hand-up"></i></a>
                                                        
                                                       <a href="#" class="btn" rel="tooltip" data-original-title="Ligne"><i class="icon-ok"></i></a> 
                                                       
                                                       <a href="#" class="btn" rel="tooltip" data-original-title="Rectangle"><i class="icon-stop"></i></a>
                                                        
                                                       <a href="#" class="btn" rel="tooltip" data-original-title="Ellipse"><i class="icon-adjust"></i></a> 
                                                       
                                                 
                                                 
                                                 </div>
                                                 
                                                 <div id="edition" class="btn-group btn-group-vertical">
                                                 
                                                      <a href="#" class="btn" rel="tooltip" data-original-title="Annuler"><i class="icon-backward"></i></a> 
                                                      
                                                        <a href="#" class="btn" rel="tooltip" data-original-title="Répéter"><i class="icon-forward"></i></a> 
                                                        
                                                      <a href="#" class="btn" rel="tooltip" data-original-title="Copier"><i class="icon-check"></i></a> 
                                                      
                                                     <a href="#" class="btn" rel="tooltip" data-original-title="Coller"><i class="icon-share"></i></a> 
                                                     
                                                     
                                                 <a href="#" class="btn" rel="tooltip" data-original-title="Supprimer"><i class="icon-trash"></i></a> 
                                                 
                                                 
                                                 </div>
                                            
                                            
                                            
                                            </aside>
                                            
                                            <section class="span11" id="sectiondessingauche">
                                            
                                                <div id="kinetic" class="thumbnail">
                                                
                                                
                                                </div>
                                                
                                            
                                            
                                            </section>
                                       
                                       
                                       
                                       </div>
                                       
                                       <footer class="row">
                                       
                                               <form class="form-inline well-small">
                                               
                                                     <label>Ligne : </label>
                                                     
                                                    <select id="typeligne" class="input-small">
                                                    
                                                        <option>Unie</option>
                                                    
                                                        <option>Sans</option>
                                                    
                                                   </select>
                                                   
                                                   <div id="widthline" class="input-append">
                                                   
                                                        <input id="width" type="text">
                                                        <span class="add-on">px</span>
                                                   
                                                   </div>
                                                   
                                                   <div id="couleurligne" class="input-append color" data-color="#000">
                                                   
                                                           <input id="colorligne" class="input-mini" type="text" readonly value="">
                                                           <span class="add-on"> <i style="background-color:#000"></i> </span>
                                                   
                                                   </div>
                                                   
                                                   <label>Fond : </label>
                                                   
                                                   <select id="typefond" class="input-small">
                                                   
                                                                <option>Sans</option>
                                                                
                                                               <option>Uni</option>
                                                   
                                                  </select>
                                                  
                                                  <div id="couleurfond" class="input-append color hide" data-color="#fff">
                                                  
                                                      <input id="colorremplissage" class="input-mini" type="text" readonly value="">
                                                      <span class="add-on"> <i style="background-color:#fff"></i> </span>
                                                  
                                                  
                                                  
                                                  </div>
                                                   
                                                     
                                               
                                               </form>
                                       
                                       
                                       </footer>
                                       
                                       <div class="modal hide" id="modal_new" tabindex="-1">
                                       
                                           <div class="modal-header">
                                           
                                              <h3 id="myModalLabel">Nouveau dessin</h3>
                                              
                                           </div>
                                           
                                           <div class="modal-body">
                                           
                                                <p>Vous êtes sûr de vouloir un nouveau dessin ?</p>
                                                
                                           
                                           
                                           </div>
                                           
                                           <div class="modal-footer">
                                           
                                           
                                              <button id="nouveaucanvas" class="btn btn-danger" data-dismiss="modal">Oui</button>
                                              
                                              <button class="btn" data-dismiss="modal">Annuler</button>
                                           
                                           
                                           
                                           </div>
                                           
                                       
                                       
                                       </div>
                                       
                                       
                                        
                                        
                                 </div>
                                 
                                 <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
                                 
                                 <script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
                                 
                                 <script src="<c:url value="/inc/bootstrap.js"/>"></script>

                                <script src="<c:url value="/inc/kinetic/kinetic-v5.1.0.js"/>"></script>
                                 
                                 <script src="<c:url value="/inc/fcrogauche.js"/>"></script>
                                 
                                 <script src="<c:url value="/inc/bootstrap.js"/>"></script>
                                 
                                 
                                     </div>
                                     
                                     
                                     <div class="col-xs-5">
                                     
                                           <img class="imagedroite" id ="fcrodessin" alt="Figure Complexe de Rey-Osterrieth" title="Figure Complexe de Rey-Osterrieth"
						src="<c:url value="/inc/figure_complexe_de_rey_big.gif"/>">
                                     
                                                           
                                           
                                     
                                     </div>
                      
                          
                      </c:if>
                      
                      
                      <c:if test="${  main eq 'droite'  }">
                      
                      
                                   <div class="col-xs-5">
                                   
                                         <img class="imagegauche" id ="fcrodessin" alt="Figure Complexe de Rey-Osterrieth" title="Figure Complexe de Rey-Osterrieth"
						src="<c:url value="/inc/figure_complexe_de_rey_big.gif"/>">
                                     
                                     
                                    </div>
                                     
                                     
                                    <div class="col-xs-7">
                                    
                                    
                                         <div id="kinetic">
                          
                                
                          
                          
                                         </div>
                          
                                     
                                     
                                    </div>
                      
                          
                      </c:if>
              
              
              </c:if>
              
              
              <c:if test="${  sessionuser eq 'medecin'  }">
              
              
              </c:if>
      
      
      </div>


</div>


<script src="<c:url value="/inc/bootstrap.js"/>"></script>

<script src="<c:url value="/inc/kinetic/kinetic-v5.1.0.js"/>"></script>


</body>
</html>