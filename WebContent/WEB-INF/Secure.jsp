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



<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet" />

<link href="<c:url value="/inc/colorpicker/css/colorpicker.css"/>" rel="stylesheet" />

<style type="text/css">

canvas {border-style:solid;}


.containerinterface {
	-moz-box-shadow: 8px 8px 12px #aaa;
	-webkit-box-shadow: 8px 8px 12px #aaa;
	box-shadow: 8px 8px 12px #555;
	border: 2px solid #666;
	border-radius: 4px;
	margin-top: 10px;
	height: 100%;
	margin-left:0.1%;
	margin-right:0.1%;
}




.span1 {
	padding-left: 50%;
	width: 200px;
	
}


form {
	margin-top: 10px;
	margin-left: 90px;
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
                      
                                     <div class="col-xs-9">
                                     
                                        <div class="containerinterface">
                                        
                                               <div class="row">
                                               
                                                       <nav class=" navbar navbar-inverse">
                                          
                                               
                                                             <ul class="nav navbar-nav ">
                                                             
                                                                  <li class="active"><a href="#">ENAD FCRO</a></li>
                                                                  
                                                                  <li id="fichier" class="dropdown"> <a  class="dropdown-toggle" data-toggle="dropdown" href="#"> Fichier<b class="caret"></b></a>
                                                                  
                                                                       <ul class="dropdown-menu">
                                                                       
                                                                           <li> <a href="#" id="nouveau">Nouveau...</a> </li>
                                                                       
                                                                       
                                                                       </ul>
                                                                  
                                                                  </li>
                                                                  
                                                                  <li id="modifier" class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#">Modifier<b class="caret"></b></a>
                                                                  
                                                                       <ul class="dropdown-menu">
                                                                       
                                                                         
                                                                       
                                                                            <li class="dropdown-submenu"> 
                                                                            
                                                                            <a   tabindex="-1" href="#">Arranger <i class="fa fa-caret-right" ></i></a>
                                                                            
                                                                                 <ul class="dropdown-menu">
                                                                                 
                                                                                      <li> <a href="#" id="go_up">Envoyer à l'avant</a> </li>
                                                                                      
                                                                                      <li> <a href="#" id="go_down">Envoyer à l'arrière</a> </li>
                                                                                      
                                                                                      <li> <a href="#" id="go_front">Envoyer au premier plan</a> </li>
                                                                                      
                                                                                      <li> <a href="#" id="go_back">Envoyer à l'arrière plan</a> </li>
                                                                                      
                                                                                 
                                                                                 
                                                                                 </ul>
                                                                            
                                                                            
                                                                            </li>
                                                                            
                                                                            <li class="dropdown-submenu"> 
                                                                            
                                                                            
                                                                            
                                                                            <a  tabindex="-1" href="#">Edition  <i class="fa fa-caret-right" ></i></a>
                                                                            
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
                                                                  
                                                                  <li id="fin"><a href="#">Figure terminée</a></li>
                                                             
                                                             
                                                             
                                                             </ul>
                                                             
                                                             
                                                             
                                               
                                               
                                               
                                                    
                                               
                                               
                                               
                                               
                                               
                                          
                                          
                                          </nav>
                                            
                                            
                                            
                                       </div>
                                       
                                       <div id="canvascont" class="row">
                                       
                                             <div class="col-xs-1">
                                             
                                             <aside class="span1">
                                            
                                              
                                              
                                                 <div id="mode" class="btn-group-vertical " data-toggle="buttons-radio">
                                                 
                                                       <a href="#" class="btn btn-primary btn-lg"  data-toggle="tooltip" title="Sélection" data-placement="right"><span class="glyphicon glyphicon-hand-up"></span></a>
                                                        
                                                       <a href="#" class="btn btn-primary btn-lg" rel="tooltip" data-original-title="Ligne"><span class="glyphicon glyphicon-minus"></span></a> 
                                                       
                                                       <a href="#" class="btn btn-primary btn-lg " rel="tooltip" data-original-title="Rectangle"><span class="glyphicon glyphicon-stop"></span></a>
                                                        
                                                       <a href="#" class="btn btn-primary btn-lg " rel="tooltip" data-original-title="Ellipse"><span class="glyphicon glyphicon-adjust"></span></a> 
                                                       
                                                 
                                                 
                                                 </div>
                                                 
                                                 
                                                 <br>
                                                 <br>
                                                 
                                                 
                                              
                                              
                                              
                                            
                                                 
                                                 
                                                 <div id="edition" class=" btn-group-vertical">
                                                 
                                                      <a href="#" class="btn btn-info btn-lg" rel="tooltip" data-original-title="Annuler"><span class="glyphicon glyphicon-backward"></span></a> 
                                                      
                                                        <a href="#" class="btn btn-info btn-lg" rel="tooltip" data-original-title="Répéter"><span class="glyphicon glyphicon-forward"></span></a> 
                                                        
                                                      <a href="#" class="btn btn-info btn-lg" rel="tooltip" data-original-title="Copier"><span class="glyphicon glyphicon-copy"></span></a> 
                                                      
                                                     <a href="#" class="btn btn-info btn-lg" rel="tooltip" data-original-title="Coller"><span class="glyphicon glyphicon-paste"></span></a> 
                                                     
                                                     <a href="#" class="btn btn-info btn-lg" rel="tooltip" data-original-title="Effacer"><span class="glyphicon glyphicon-erase"></span></a> 
                                                     
                                                     
                                                 <a href="#" class="btn btn-info btn-lg" rel="tooltip" data-original-title="Supprimer"><span class="glyphicon glyphicon-trash"></span></a> 
                                                 
                                                 
                                                 </div>
                                            
                                            
                                            
                                            </aside>
                                             
                                             
                                             </div>
                                             
                                             <div  class="col-xs-1" >
                                             </div>
                                             
                                             
                                             
                                     
                                                <div id="kinetic" class="col-xs-6" >
                                                
                                                <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script> 
                                
                                 <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>

                                <script src="<c:url value="/inc/kinetic/kinetic-v5.1.0.js"/>"></script>
                         
                                                
                                                <script type="text/javascript">

window.onload = function() {
	
	if (document.body)
	{
	var larg = (document.body.clientWidth);
	var haut = (document.body.clientHeight);
	}

	else
	{
	var larg = (window.innerWidth);
	var haut = (window.innerHeight);
	}
	
	var largeurresponsive ,hauteurresponsive,largeurresponsivearrondie,hauteurresponsivearrondie;
	
	
	
	if(larg<768){
		
 largeurresponsive = (larg*800)/1366;
		
 hauteurresponsive = (haut*500)/662;
		
 largeurresponsivearrondie = Math.floor(largeurresponsive);
		
 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
		
		
		
		
	}

	if(larg >= 768 && larg<992){
		
 largeurresponsive = (larg*800)/1366;
		
 hauteurresponsive = (haut*500)/662;
		
 largeurresponsivearrondie = Math.floor(largeurresponsive);
		
 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
		
		
		
		
	}

	if(larg >= 992 && larg<1200){
		
largeurresponsive = (larg*800)/1366;
		
 hauteurresponsive = (haut*500)/662;
		
 largeurresponsivearrondie = Math.floor(largeurresponsive);
		
 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
		
		
		
	}

	if(larg >= 1200 ){
		
		 largeurresponsive = (larg*800)/1366;
		
		 hauteurresponsive = (haut*500)/662;
		
		 largeurresponsivearrondie = Math.floor(largeurresponsive);
		
		 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
		
		
		
		
	}
	
	//Création de la scène
	
	var scene = new Kinetic.Stage({
		container: "kinetic",
		width: largeurresponsivearrondie,
		height: hauteurresponsivearrondie
		});
	
		
		
		var calque_top = new Kinetic.Layer();
        var calque_bottom = new Kinetic.Layer();
		
		var rect = new Kinetic.Rect({
			x: 0,
			y: 0,
			width: scene.getWidth(),
			height: scene.getHeight(),
			stroke: "#c0c0c0",
			strokeWidth: 5,
			cornerRadius: 20
			});
		
		calque_top.add(rect);
		
		calque_bottom.add(rect);
		
		scene.add(calque_bottom);
		
		scene.add(calque_top);
	

	};




</script>
                                                
                                                       
                                                       
                                                       
                                                       
                                                
                                                
                                                </div>
                                               
                                           
                                       </div>
                                       
                                       <footer class="row ">
                                       
                                          
                                          
                                                <form class=" form-inline ">
                                               
                                               <div class="form-group">
                                               
                                                   <label>Ligne : </label>
                                                     
                                                    <select id="typeligne" class="input-sm form-control">
                                                    
                                                        <option>Unie</option>
                                                    
                                                        <option>Sans</option>
                                                    
                                                   </select>
                                               
                                               
                                               </div>
                                               
                                               
                                               
                                               
                                               
                                               
                                               
                                               
                                               
                                                     <div id="widthline" class="input-group  ">
                                                   
                                                        
                                                        <input id="width" type="number"  class="form-control" style="text-align:center"  >
                                                        
                                                        <span class="input-group-addon" >px</span>
                                                        
                                                        
                                                        
                                                   
                                                   </div>
                                                   
                                                   
                                               
                                                
                                                  <div id="couleurligne" class="input-append color  input-group" data-color="#000">
                                                   
                                                           
                                                           <input id="colorligne" class=" form-control" type="text" readonly value="">
                                                           
                                                           <span class="input-group-addon"> <i style="background-color:#000"></i> </span>
                                                   
                                                   </div>
                                                
                                                
                                                   <div class="form-group">
                                                   
                                                       <label>Fond : </label>
                                                   
                                                   <select id="typefond" class="input-small form-control">
                                                   
                                                                <option>Sans</option>
                                                                
                                                               <option>Uni</option>
                                                   
                                                  </select>
                                                   
                                                   
                                                   </div>
                                                   
                                                   
                                                   
                                                   
                                                   
                                                   
                                                  
                                                  <div id="couleurfond" class="input-append color hide input-group form-group" data-color="#fff">
                                                  
                                                      <input id="colorremplissage" class="input-mini form-control" type="text" readonly value="">
                                                      <span class="input-group-addon"> <i style="background-color:#fff"></i> </span>
                                                  
                                                  
                                                  
                                                  </div>
                                                   
                                                     
                                               
                                               </form>
                                          
                                          
                                          
                                          
                                       
                                       
                                            
                                       
                                               
                                       
                                       
                                       </footer>
                                       
                                       <br>
                                       
                                       
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
                                       
                                       
                                       <script src="<c:url value="/inc/colorpicker/js/colorpicker.js"/>"></script>
                         
                                       
                                       
                                       <script type="text/javascript">
                                                       
                                                    
                                 

                              // Paramètres globaux

                              var params = {
                              	modes: ['selection','ligne','rectangle','ellipse'],
                              	id_mode: 0,
                              	line_color: 'black', // RED ?
                              	line_width: 2,
                              	fill_color: 'white',
                              	line_type: 'Unie',
                              	fill_type: 'Sans',
                              	en_cours: false,
                              	start_point: [],
                              	objet_modif: {},
                              	selecteurs: [],
                              	box: {},
                              	objets_effaces: [],
                              	objet_copie: null,
                              	inhibe_selection: false
                              };

                              //Reset du dessin

                              function reset_dessin() {
                              	
                              	params.en_cours = false;
                              	params.id_mode = 0;
                              	$('canvas').css('cursor', 'default');
                              	$('#mode .active').removeClass('active');
                              	$('#mode .btn:first').addClass('active');	
                              }


                              $(function (){
                              	
                              	// Synchronisation des contrôles avec la shape sélectionnée
                              	function sync_controls() {
                              		// Largeur de ligne
                              		if(params.objet_modif.getStrokeWidth() != undefined) 
                              			$('#width').val(params.objet_modif.getStrokeWidth()); //ici
                              		// Couleur de ligne
                              		if(params.objet_modif.getStroke() != undefined) {
                              			$('#typeligne').val('Unie');
                              			$('#colorligne').val(params.objet_modif.getStroke());
                              			$('#couleurligne i ').css('background-color', params.objet_modif.getStroke()); 
                              		    $('#couleurligne').removeClass('hide');
                              		    $('#widthline').removeClass('hide');//ici
                              		}
                              		else {
                              			$('#typeligne').val('Sans');
                              		    $('#couleurligne').addClass('hide');
                              		    $('#widthline').addClass('hide'); //ici
                              		}
                              		// Couleur de remplissage
                              		if(params.objet_modif.getFill() != undefined) {
                              			$('#typefond').val('Uni');
                              			$('#couleurfond').removeClass('hide');
                              			$('#colorremplissage').val(params.objet_modif.getFill());
                              			$('#couleurfond i').css('background-color', params.objet_modif.getFill());
                              		}
                              		else {
                              			$('#couleurfond').addClass('hide');	
                              			$('#typefond').val('Sans');	
                              		}
                              	}
                              	
                              	// Test de shape sélectionnée
                              	function test_select() {
                              		return params.modes[params.id_mode] == 'selection' && calque_top.getChildren().length;	
                              	}
                              	
                              	// Sélection d'un objet
                              	function select_object() {
                              		if(params.objet_modif.shapeType == "Line") {
                              			var points = params.objet_modif.getPoints();
                              			var pos = params.objet_modif.getPosition();
                              			params.selecteurs = [];
                              			params.selecteurs.push(build_selector(points[0].x + pos.x, points[0].y + pos.y));
                              			params.selecteurs.push(build_selector(points[1].x + pos.x, points[1].y + pos.y));
                              		}
                              		if(params.objet_modif.shapeType == "Rect") {
                              			var x = params.objet_modif.getX();
                              			var y = params.objet_modif.getY();
                              			var width = params.objet_modif.getWidth();
                              			var height = params.objet_modif.getHeight();
                              			params.selecteurs = [];
                              			params.selecteurs.push(build_selector(x, y));
                              			params.selecteurs.push(build_selector(x + width, y + height));
                              		}
                              		if(params.objet_modif.shapeType == "Ellipse") {
                              			var x = params.objet_modif.getX();
                              			var y = params.objet_modif.getY();
                              			var radius = params.objet_modif.getRadius();
                              			params.selecteurs = [];
                              			params.box = build_box(x - radius.x, y - radius.y, x + radius.x, y + radius.y);
                              			params.selecteurs.push(build_selector(x - radius.x, y - radius.y));
                              			params.selecteurs.push(build_selector(x + radius.x, y + radius.y));
                              		}
                              		$('canvas').css('cursor', 'default');
                              	}
                              	
                              	// Suppression d'un objet
                              	function del_object() {
                              		if(test_select()) {
                              			params.objets_effaces.push(params.objet_modif);
                              			calque_bottom.remove(params.objet_modif);
                              			calque_bottom.draw();
                              			reset_dessin();	
                              			calque_top.removeChildren();
                              			calque_top.draw();
                              		}	
                              	}
                              	
                              	// Annuler dernière création d'objet
                              	function annuler_objet() {
                              		reset_dessin();	
                              		calque_top.removeChildren();
                              		calque_top.draw();	
                              		var shapes = calque_bottom.getChildren();
                              		if(shapes.length) {
                              			params.objets_effaces.push(shapes[shapes.length - 1]);
                              			calque_bottom.remove(shapes[shapes.length - 1]);
                              			calque_bottom.draw();
                              		}
                              	}
                              	
                              	// Répéter dernière création d'objet
                              	function repete_objet() {
                              		if(params.objets_effaces.length) {
                              			reset_dessin();	
                              			calque_top.removeChildren();
                              			calque_top.draw();
                              			params.objet_modif = {};	
                              			//calque_bottom.add(params.objets_effaces.pop().clone());
                              			var shape = params.objets_effaces.pop();
                              			calque_bottom.add(shape);
                              			// Nécessaire pour retrouver la détection
                              			Kinetic.Global.shapes[shape.colorKey] = shape;
                              			calque_bottom.draw();	
                              		}
                              	}

                              	// Création des sélecteurs
                              	function build_selector(x, y) {
                              		var selector = new Kinetic.Circle({
                              			x: x,
                              			y: y,
                              			radius: 5,
                              			stroke: "#666",
                              			fill: "#ddd",
                              			strokeWidth: 2,
                              			draggable: true,
                              			name: 'selector'
                              		});
                              		
                              		selector.on("mouseover", function() {
                              			$('canvas').css('cursor', 'pointer');
                              			this.setOpacity(.1);
                              			inhibe_selection = true;
                              			calque_top.draw();
                              		});
                              		selector.on("mouseout", function() {
                              			$('canvas').css('cursor', 'default');
                              			this.setOpacity(1);
                              			inhibe_selection = false;
                              			calque_top.draw();
                              		});
                              		
                              		calque_top.add(selector);
                              		return selector;
                              	}
                              	
                              	// Création du cadre en pointillés
                              	function build_box(x1, y1, x2, y2) {
                              		var box = new Kinetic.Line({
                              			points: [x1, y1, x2 , y1, x2, y2, x1, y2, x1, y1],
                              			dashArray: [5, 5],
                              			strokeWidth: 1,
                              			stroke: "#666",
                              			lineCap: "round",
                              			id: "box",
                              			opacity: 0.6
                              		});	
                              		calque_top.add(box);
                              		return box;
                              	}
                              	
                              	// Initialisations
                              	$('#colorligne').val(params.line_color);
                              	$('#width').val(params.line_width); //ici
                              	$('#typeligne').val(params.line_type);
                              	$('#typefond').val(params.fill_type);
                              	$('#couleurfond').val(params.fill_color);	
                              	$('#colorremplissage').val(params.fill_color);
                              	
                              	// Fonctionnement du tooltip
                              	$('.btn').tooltip({placement:'right'});
                              	// Fonctionnement des colorpicker
                                 	$('.color').ColorPicker(); //COLORPICKER
                              	
                              	// Largeur de ligne
                              	$('#width').change(function() { //ici
                                		params.line_width = $(this).val();
                              		if(test_select() && params.objet_modif.getStrokeWidth() != 'undefined') {
                              			params.objet_modif.setStrokeWidth(params.line_width);
                              			calque_bottom.draw();
                              		}
                              	});
                              	
                              	// Couleur de ligne
                              	$('#couleurligne').ColorPicker().on('onChange', function(e){ //COLORPICKER
                              		params.line_color = e.color.toHex(); // COLORPICKER
                              		if(test_select() && params.objet_modif.getStroke() != 'undefined') {
                              			params.objet_modif.setStroke(params.line_color);
                              			calque_bottom.draw();
                              		}
                              	});
                              	
                              	// Changement type de ligne
                                  $('#typeligne').change(function () {
                              	  params.line_type = $('#typeligne option:selected').val() == 'Unie';
                              	  if(params.line_type) {
                              		  $('#couleurligne').removeClass('hide');
                              		  $('#widthline').removeClass('hide'); //ici
                              		  params.objet_modif.setStrokeWidth($('#width').val());
                              		  params.objet_modif.setStroke($('#colorligne').val());
                              	  }
                              	  else {
                              		  $('#couleurligne').addClass('hide');
                              		  $('#widthline').addClass('hide'); //ici
                              		  delete params.objet_modif.attrs.stroke;
                              		  delete params.objet_modif.attrs.strokeWidth;
                              	  }
                              	  calque_bottom.draw();
                              	})
                              	
                              	// Couleur de remplissage
                              	$('#couleurfond').colorpicker().on('onChange', function(e){ //COLOR PICKER
                              		params.fill_color = e.color.toHex();
                              		if(test_select()) {
                              			params.objet_modif.setFill(params.fill_color);
                              			calque_bottom.draw();
                              		}	
                              	});
                              	
                              	// Changement type de remplissage
                                  $('#typefond').change(function () {
                              	  params.fill_type = $('#typefond option:selected').val() == 'Uni';
                              	  if(params.fill_type) {
                              		  $('#couleurfond').removeClass('hide');
                              		  params.objet_modif.setFill($('#colorremplissage').val());
                              	  }
                              	  else {
                              		  $('#couleurfond').addClass('hide');
                              		  delete params.objet_modif.attrs.fill;
                              	  }
                              	  calque_bottom.draw();
                              	})
                              	
                              	                                               

                              	// Actualisation en mode Sélection
                              	calque_top.afterDraw(function() {
                              		if(params.modes[params.id_mode] == 'selection' && inhibe_selection) {
                              			var pos1 = params.selecteurs[0].getPosition();
                              			var pos2 = params.selecteurs[1].getPosition();
                              			if(params.objet_modif.shapeType == "Line") {
                              				var pos_line = params.objet_modif.getPosition();
                              				params.objet_modif.setPoints([pos1.x - pos_line.x, pos1.y - pos_line.y, pos2.x - pos_line.x, pos2.y - pos_line.y]);
                              			}
                              			else if(params.objet_modif.shapeType == "Rect") {
                              				params.objet_modif.setPosition(pos1);
                              				params.objet_modif.setWidth(pos2.x - pos1.x);
                              				params.objet_modif.setHeight(pos2.y - pos1.y);
                              			}
                              			else if(params.objet_modif.shapeType == "Ellipse") {
                              				params.objet_modif.setRadius({
                              					x: Math.abs(pos1.x - pos2.x) / 2,
                              					y: Math.abs(pos1.y - pos2.y) / 2
                              				});
                              				params.objet_modif.setPosition({
                              					x: pos1.x + (pos2.x - pos1.x) / 2,
                              					y: pos1.y + (pos2.y - pos1.y) / 2
                              				});
                              				params.box.setPoints([
                              					pos1.x, pos1.y,
                              					pos2.x, pos1.y,
                              					pos2.x, pos2.y,
                              					pos1.x, pos2.y,
                              					pos1.x, pos1.y
                              				]);
                              			}
                              			calque_bottom.draw();
                              		}
                              	});

                              	// Evénement sur les boutons de mode
                                  $('#mode .btn').click(function() {
                              		params.id_mode = $('#mode .btn').index(this);
                              		// Si un mode dessin on change le curseur et on reset la sélection
                              		if(params.id_mode) {
                              			$('canvas').css('cursor', 'crosshair');
                              			params.en_cours = false;
                              			params.objet_modif.setDraggable(false);
                              			params.objet_modif = {};
                              			calque_top.removeChildren();
                              			calque_top.draw();
                              		}
                              		else $('canvas').css('cursor', 'default');
                                  });
                              	
                              	// Evénements de souris sur le canvas
                              	$('canvas')
                              	.mousedown(function(e){
                              		// Si mode sélection
                              		if(params.modes[params.id_mode] == 'selection') {
                              			if(!inhibe_selection) {
                              				var offset = $('.kineticjs-content').offset();
                              				var p = [e.pageX - offset.left, e.pageY - offset.top];
                              				var shapes = scène.getIntersections(p);
                              				if(shapes.length && shapes[0].getLayer() != calque_top && shapes[0] != params.objet_modif) {
                              					calque_top.removeChildren();
                              					shapes[0].setDraggable(true);
                              					params.objet_modif = shapes[0];
                              					select_object();
                              					sync_controls();
                              					calque_top.draw();
                              				}
                              			}
                              		}
                              		// Si mode dessin
                              		else {
                              			// Position de la souris
                              			var offset = $('.kineticjs-content').offset();
                              			var x = e.pageX - offset.left;
                              			var y = e.pageY - offset.top;
                              			// Mémorisation de la position
                              			params.start_point = [x, y];
                              			params.en_cours = true;
                              		}
                                  })
                              	.mousemove(function(e){
                              		// Si mode sélection
                              		if(params.modes[params.id_mode] == 'selection') {
                              			var offset = $('.kineticjs-content').offset();
                              			var p = [e.pageX - offset.left, e.pageY - offset.top];
                              			var shapes = scène.getIntersections(p);
                              			if(shapes.length) $('canvas').css('cursor', 'pointer');
                              			else $('canvas').css('cursor', 'default');			
                              		}
                              		// Si mode dessin
                              		else if(params.en_cours) {
                              			// Position de la souris
                              			var offset = $('.kineticjs-content').offset();
                              			var x = e.pageX - offset.left;
                              			var y = e.pageY - offset.top;
                              			// Shape en cours
                              			var shapes = calque_top.getChildren();
                              			// Cas de la ligne
                              			if(params.modes[params.id_mode] == 'ligne') {
                              				// Ligne déjà créée
                              				if(shapes.length) {
                              					shapes[0].setPoints(params.start_point.concat([x, y]));
                              				}
                              				// Création de la ligne
                              				else {
                              					var ligne = new Kinetic.Line({
                              						points: params.start_point.concat([x, y]),
                              						stroke: params.line_color,
                              						strokeWidth: params.line_width
                              					});		
                              					calque_top.add(ligne);
                              				}
                              			}
                              			// Cas du rectangle
                              			else if(params.modes[params.id_mode] == 'rectangle') {
                              				// Rectangle déjà créé
                              				if(shapes.length) {
                              					shapes[0].setWidth(x - params.start_point[0]);
                              					shapes[0].setHeight(y - params.start_point[1]);
                              				}
                              				// Création du rectangle	
                              				else {
                              					var rectangle = new Kinetic.Rect({
                              						x: params.start_point[0],
                              						y: params.start_point[1],
                              						width: x - params.start_point[0],
                              						height: y - params.start_point[1],
                              					});	
                              					if($('#typefond option:selected').val() == 'Uni') 
                              						rectangle.setFill(params.fill_color);
                              					if($('#typeligne option:selected').val() == 'Unie') {
                              						rectangle.setStroke(params.line_color);
                              						rectangle.setStrokeWidth(params.line_width);
                              					}
                              					calque_top.add(rectangle);
                              				}
                              			}
                              			// Cas de l'ellipse
                              			else if(params.modes[params.id_mode] == 'ellipse') {
                              				// Ellipse déjà créée
                              				if(shapes.length) {
                              					shapes[0].setRadius({
                              						x: Math.abs(x - params.start_point[0]),
                              						y: Math.abs(y - params.start_point[1])
                              					});						
                              				}
                              				// Création de l'ellipse	
                              				else {
                              					var ellipse = new Kinetic.Ellipse({
                              						x: params.start_point[0],
                              						y: params.start_point[1],
                              						radius: {
                              							x: Math.abs(x - params.start_point[0]),
                              							y: Math.abs(y - params.start_point[1])
                              						}
                              					});	
                              					if($('#typefond option:selected').val() == 'Uni') 
                              						ellipse.setFill(params.fill_color);
                              					if($('#typeligne option:selected').val() == 'Unie') {
                              						ellipse.setStroke(params.line_color);
                              						ellipse.setStrokeWidth(params.line_width);
                              					}
                              					calque_top.add(ellipse);
                              				}
                              			}
                              			calque_top.draw();
                              		}		
                                  })
                              	.mouseup(function(e){
                              		// Dessin effectif
                              		if(params.modes[params.id_mode] != 'selection' && params.en_cours) {
                              			// Tansfert sur calque inférieur
                              			params.objet_modif = calque_top.getChildren()[0];
                              			params.objet_modif.moveTo(calque_bottom);
                              			params.objet_modif.setDraggable(true);
                              			calque_bottom.draw();
                              			// Mise en place événements de drag
                              			params.objet_modif.on("dragstart", function() {
                              				calque_top.removeChildren();
                              				calque_top.draw();
                              			});
                              			params.objet_modif.on("dragend", function() {
                              				select_object();
                              				calque_top.draw();
                              			});
                              			select_object();
                              			calque_top.draw();	
                              			reset_dessin();
                              		}
                                  });
                              	
                              	// Annulation sur escape, ou destruction sur del
                              	$(document).keydown(function(e) {
                              		// Annulation
                              		if(e.keyCode == 27) {
                              			if(params.modes[params.id_mode] == 'selection' || params.en_cours) {
                              				reset_dessin();	
                              				params.objet_modif = {};
                              				calque_top.removeChildren();
                              				calque_top.draw();		
                              			}
                              		}
                              		// Delete
                              		else if(e.keyCode == 46) del_object();
                                  });
                              	
                              	// Evénement sur les boutons d'édition
                                  $('#edition .btn').click(function() {
                              		// Annuler
                              		if($('#edition .btn').index(this) == 0) annuler_objet();
                              		// Répéter
                              		else if($('#edition .btn').index(this) == 1) repete_objet()
                              		// Copier
                              		else if($('#edition .btn').index(this) == 2) 
                              			params.objet_copie = params.objet_modif.clone();
                              		// Coller
                              		else if($('#edition .btn').index(this) == 3) {
                              			if(params.objet_copie != null) {
                              				calque_bottom.add(params.objet_copie.clone());
                              				calque_bottom.draw();	
                              			}
                              		}
                              		// Supprimer
                              		else if($('#edition .btn').index(this) == 4) del_object();
                                  });
                              	
                              	// Evénement dans le menu
                                  $('#nouveau').click(function() {$('#modal_new').modal();});
                                  
                                  
                                  $('#go_front').click(function() {
                              		if(test_select()) {
                              			params.objet_modif.moveToTop();
                              			calque_bottom.draw();
                              		}
                                  });
                                  $('#go_back').click(function() {
                              		if(test_select()) {
                              			params.objet_modif.moveToBottom();
                              			calque_bottom.draw();
                              		}
                                  });
                                  $('#go_up').click(function() {
                              		if(test_select()) {
                              			params.objet_modif.moveUp();
                              			calque_bottom.draw();
                              		}
                                  });
                                  $('#go_down').click(function() {
                              		if(test_select()){ 
                              			params.objet_modif.moveDown();
                              			calque_bottom.draw();
                              		}
                                  });
                                  $('#annuler').click(function() {annuler_objet();});
                                  $('#repeter').click(function() {repete_objet();});
                                  $('#supprimer').click(function() {del_object();});
                                  $('#copier').click(function() {params.objet_copie = params.objet_modif.clone();});
                                  $('#coller').click(function() {
                              		if(params.objet_copie != null) {
                              			calque_bottom.add(params.objet_copie.clone());
                              			calque_bottom.draw();	
                              		}
                                  });
                              		
                              	// Nouveau dessin
                                  $('#nouveaucanvas').click(function() {
                              		params.objets_effaces = [];
                              		calque_top.removeChildren();
                              		calque_top.draw();
                              		calque_bottom.removeChildren();
                              		calque_bottom.draw();
                                  });
                              	
                              });





                                 
                                 
                                 </script>
                                       
                                       
                                        
                                        
                                 </div>
                                 
                                         
                                 
                                 
                                
                                 
                                 
                                 
                                 
                                     </div>
                                     
                                     
                                     <div class="col-xs-3">
                                     
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


<script>
$('.dropdown-toggle').mouseover(function() {
$(this).dropdown('toggle');
});
</script>


</body>
</html>