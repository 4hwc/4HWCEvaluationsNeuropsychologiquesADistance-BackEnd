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


      body {
        margin: 0px;
        padding: 0px;
      }
      
      #myCanvas{
     left:15%;
     right:15%;
     bottom:15%;
     top:15%;
      }
    

canvas {border-style:solid;}


.containerinterface {
	-moz-box-shadow: 8px 8px 12px #aaa;
	-webkit-box-shadow: 8px 8px 12px #aaa;
	box-shadow: 8px 8px 12px #555;
	border: 2px solid #666;
	border-radius: 4px;
	margin-top: 10px;
	height:100%;
	margin-left:0.1%;
	margin-right:0.1%;
}




.span1 {
	padding-left: 50%;
	width: 200px;
	
}

#couleurligne div {
	width: 30px;
    height: 30px;
    left:110px;
    
    border : 3px #f2552c dashed;
    
    
    background-position-x: center;
    background-position-y: center;
    background-size: initial;
    background-repeat-x: initial;
    background-repeat-y: initial;
    background-attachment: initial;
    background-origin: initial;
    background-clip: initial;
    background-color: initial;
	
}

#couleurfond div {
	width: 30px;
    height: 30px;
    left:170px;
    
    border : 3px #f2552c  dashed;
    
    
    background-position-x: center;
    background-position-y: center;
    background-size: initial;
    background-repeat-x: initial;
    background-repeat-y: initial;
    background-attachment: initial;
    background-origin: initial;
    background-clip: initial;
    background-color: initial;
	
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

<script>

//API FILE PRESENT ?
//if (window.File && window.FileReader && window.FileList && window.Blob) {
//alert("File API supported.!");
//} else {
//alert('The File APIs are not fully supported in this browser.');
//}
</script>

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
                                                                  
                                                                  
                                                                  <li id="fin"><a  id="downloadandgivetodoctor" class="btn-block btn  " >Capture</a></li>
                                                                  
                                                             </ul>
                                                             
                                                             
                                          
                                          </nav>
                                            
                                            
                                            
                                       </div>
                                       
                                       <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<script src="<c:url value="/inc/html2canvas/html2canvas.js"/>"></script>


                                       
                                       <script type="text/javascript">
                                       
                                       $(document).ready(function(){
                                    	   
                                    	   var capture = document.getElementById('downloadandgivetodoctor');
                                           
                                           function captureandsend(){
                                        	   
                                        	   html2canvas(document.body, {
                                        	  		  onrendered: function(canvas) {
                                        	  			  
                                        	  			  var medpat = '${noms_prenoms_medpat}'; // Je reçois les noms et prénoms
                                        	  			  
                                        	  			var idseance = '${id_seance}';
                                        	  			  
                                        	  			  function now(){
                                        	  			  
                                        	  				var date = new Date();

                                        	  				var year = date.getYear()+1900;

                                        	  				var month = date.getMonth()+1;

                                        	  				var dateactuelle ="_dateheure_"+year+"_"+month+"_"+date.getDate()+"_"+date.getHours()+"_"+date.getMinutes()+"_"+date.getSeconds()+"_"+date.getMilliseconds();

                                        	  			  return dateactuelle;
                                        	  		  }
                                        	  			  
                                        	  			  
                                        	  			  function nomimage(){
                                        	  				  
                                        	  				  var nom ="fcro"+now()+"_"+idseance+"_"+medpat+"_.png";
                                        	  				  
                                        	  				  return nom;
                                        	  				  
                                        	  			  }
                                        	  			  
                                        	  			  var nomfinal = nomimage();
                                        	  			  
                                        	  		     function uploadFile(file){
                                        	  		    	 
                                        	  		    	 var url = '/enad/captureimagefcro?idseance=${id_seance}';
                                        	  		    	 var xhr = new XMLHttpRequest();
                                        	  		    	 var fd = new FormData();
                                        	  		    	 
                                        	  		    	 xhr.open("POST", url, true);
                                        	  		    	 xhr.onreadystatechange = function() {
                                        	  		    	 if (xhr.readyState == 4 && xhr.status == 200) {
                                        	  		    	 // Every thing ok, file uploaded
                                        	  		    	 console.log(xhr.responseText); // handle response.
                                        	  		    	 }
                                        	  		    	 };
                                        	  		    	 fd.append("upload_img_fcro", file); //parameter : upload_img_fcro 
                                        	  		    	 xhr.send(fd);
                                        	  		    	 
                                        	  		     }
                                        	  		     
                                        	  		     
                                        	  		     
                                        	  			  
                                        	  			  function downloadsendCanvas(link, canvas, filename) {
                                        	      link.href = canvas.toDataURL();
                                        	      link.download = filename;
                                        	      
                                        	      var dataURL = canvas.toDataURL("image/png");
                                        	      
                                        	      var imageObj = new Image();
                                        	      
                                        	      
                                        	      
                                        	      imageObj.src = dataURL;

                                        	   
                                        	      //GENERER FICHIER
                                        	      var blobBin = atob(imageObj.src.split(',')[1]);
                                        	      
                                        	     var array = [];
                                        	     
                                        	  for(var i = 0; i < blobBin.length; i++) {
                                        	      array.push(blobBin.charCodeAt(i));
                                        	  }

                                        	  var blobscreenshot=new Blob([new Uint8Array(array)], {type: 'image/png'});



                                        	  var filescreenshot = new File([new Uint8Array(array)], nomfinal);

                                        	  

                                        	  console.log("size:"+filescreenshot.size);

                                        	  console.log("date:"+filescreenshot.lastModifiedDate);

                                        	  console.log("name:"+filescreenshot.name);



                                        	     
                                        	  uploadFile(filescreenshot);
                                        	      
                                        	  }
                                        	  		     
                                        	  		     document.getElementById('downloadandgivetodoctor').addEventListener('click', function() {
                                        	  		    	    downloadsendCanvas(this, canvas, nomfinal); 
                                        	  		    	}, false);
                                        	  			  
                                        	  		  },
                                        	  		  
                                        	  		//useCORS:false
                                        	  		});
                                        	  	
                                        	        
                                        	    
                                        	   
                                           }
                                           
                                           capture.addEventListener('click', captureandsend() , false);
                                        	   
                                        	   
      
                                    	   
                                    	   
                                    	   
                                       });


                                       
</script>
                                            
                                       
                                       




                         
                                       
                                       
                                       
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
                                                   
                                                   
                                                   
                                                      <div id="couleurligne"  data-original-title="Couleur de la ligne" class=" color  input-group " data-color="#000">
                                                  
                                                  
                                                      <div style="background-color:rgb(0,0,0)">
                                                      
                                                      
                                                      </div>
                                                  
                                                  <!-- <input id="colorligne" class=" form-control" type="text" readonly value=""> -->
                                                   
                                                  <!-- <span class="input-group-addon"> <i style="background-color:#000"></i> </span> -->
                                                   
                                                   </div>
                                                   
                                                   
                                                
                                                   <div class="form-group">
                                                   
                                                       <label>Fond : </label>
                                                   
                                                   <select id="typefond" class="input-small form-control">
                                                   
                                                                <option>Sans</option>
                                                                
                                                               <option>Uni</option>
                                                   
                                                  </select>
                                                   
                                                   
                                                   </div>
                                                   
                                                   
                                                  
                                                  <div id="couleurfond" data-original-title="Couleur du fond" class=" color hide  input-group form-group" data-color="#000">
                                                  
                                                         <div style="background-color:white" class="couleurfondbord">
                                                  
                                                  
                                                         </div>
                                                         
                                                         <!-- 
                                                         
                                                         <input id="colorremplissage" class="input-mini form-control" type="text" readonly value="">
                                                      <span class="input-group-addon"> <i style="background-color:#fff"></i> </span>
                                                  
                                                         
                                                          -->
                                                  
                                                      
                                                  
                                                  
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
                              			//$('#colorligne').val(params.objet_modif.getStroke()); //JE MODIFIE
                              			$('#couleurligne ').css('background-color', params.objet_modif.getStroke()); 
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
                              			$('#couleurfond ').css('background-color', params.objet_modif.getFill());
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
                              	//$('#colorligne').val(params.line_color); JE MODIFIE
                              	$('#width').val(params.line_width); //ici
                              	$('#typeligne').val(params.line_type);
                              	$('#typefond').val(params.fill_type);
                              	$('#couleurfond').val(params.fill_color);	
                              //	$('#colorremplissage').val(params.fill_color); JE MODIFIE
                              	
                              	// Fonctionnement du tooltip
                              	
                              	
                              	$('.btn').tooltip({placement:'right'});
                              	
                              	$('#couleurligne').tooltip({placement:'bottom'});
                              	
                              	$('#couleurfond').tooltip({placement:'bottom'});
                              	
                              	// Fonctionnement des colorpicker
                              	
                              	$('#couleurligne').ColorPicker({
                                 		
	                                   color: '#000000',
	                                   
                                  onHide:function(colpkr){
	                                	   
	                                	   $(colpkr).fadeOut(500);
	                                	   
	                                	   return false;
	                                   },
	                                   
	                                   
	                                 onChange: function (hsb, hex, rgb) {
		           $('#couleurligne div').css('backgroundColor', '#' + hex);
	                      }
                   });
                              	
                              	$('#couleurfond').ColorPicker({
                             		
	                                   color: '#ffffff',
	                                   
	                                   
                               onHide:function(colpkr){
	                                	   
	                                	   $(colpkr).fadeOut(500);
	                                	   
	                                	   return false;
	                                   },
	                                   
	                                   
	                                 onChange: function (hsb, hex, rgb) {
		           $('#couleurfond div').css('backgroundColor', '#' + hex);
		           
		           
	                      }
                });
                              	
                              	
                              	
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
                              		  //params.objet_modif.setStroke($('#colorligne').val());
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
              
              <div class="col-xs-12">
              
              <br>
              <br>
              <br>
            
                  

<canvas id="myCanvas" class="col-xs-8 hide" width="578" height="200"></canvas>

<br>
<br>
<br>
<br>


								
								
								
								<a class="btn btn-primary btn-lg  btn-block " style="   text-align:center;"
						target="_blank" id="buttoncanvas"
						>  <strong style=" font-size: 4em;"> <i class="fa fa-smile-o" aria-hidden="true"></i></strong> <br />
					<br />
					
					<strong style=" font-size: 1.5em;"> En attendant d'assister à la réalisation du test, ENAD vous propose un moment de détente .
					
					<br />
									
									Il faut cliquer sur ce bouton et modifier la position du curseur dans le cadre qui apparaîtra.
					
					</strong>
					
					
					
					
									
									</a>
									
									
									
									


<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<script type="text/javascript">



$("canvas").css("background", "linear-gradient(to right, #33ccff 0%, #ccff99 100%)");



$("#buttoncanvas").click(function(){
    
    
    $("#buttoncanvas").hide(1000,function(){
    	
    	$("#myCanvas").removeClass("hide");
    	$("#myCanvas").show(1000);
    });
});

</script>

<script type="text/javascript">

window.requestAnimFrame = (function(callback) {
    return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame ||
    function(callback) {
      window.setTimeout(callback, 1000 / 60);
    };
  })();
  
function initBalls() {
    balls = [];

    var a = '#2980b9'; //blue
    
    var b = '#1abc9c'; //green
    
    var c='#7f8c8d';//gris
    
    var d = '#d35400';//orange
    
    
    

    // F
    balls.push(new Ball(173, 53, 0, 0, a));
    balls.push(new Ball(158, 53, 0, 0,a));
    balls.push(new Ball(143, 53, 0, 0,a));
    balls.push(new Ball(130, 53, 0, 0,a));
    balls.push(new Ball(117, 53, 0, 0, a));
    balls.push(new Ball(117, 70, 0, 0,a));
    balls.push(new Ball(117, 82, 0, 0, a));
    balls.push(new Ball(117, 96, 0, 0, a));
    balls.push(new Ball(173, 96, 0, 0,a));
    balls.push(new Ball(158, 96, 0, 0, a));
    balls.push(new Ball(143, 96, 0, 0,a));
    balls.push(new Ball(130, 96, 0, 0,a));
    balls.push(new Ball(117, 107, 0, 0, a));
    balls.push(new Ball(117, 120, 0, 0, a));
    balls.push(new Ball(117, 130, 0, 0,a));
    balls.push(new Ball(117, 136, 0, 0, a));
    

    // C
    balls.push(new Ball(210, 53, 0, 0, b));
    balls.push(new Ball(195, 53, 0, 0, b));
    balls.push(new Ball(225, 53, 0, 0, b));
    balls.push(new Ball(240, 53, 0, 0, b));
    balls.push(new Ball(255, 53, 0, 0, b));
    
    
    balls.push(new Ball(195, 68, 0, 0, b));
    balls.push(new Ball(195, 73, 0, 0, b));
    balls.push(new Ball(195, 88, 0, 0, b));
    balls.push(new Ball(195, 103, 0, 0, b));
    balls.push(new Ball(195, 118, 0, 0, b));
    balls.push(new Ball(195, 133, 0, 0,b));
    
    
    balls.push(new Ball(210, 140, 0, 0, b));
    balls.push(new Ball(195, 140, 0, 0, b));
    balls.push(new Ball(225, 140, 0, 0, b));
    balls.push(new Ball(240, 140, 0, 0, b));
    balls.push(new Ball(250, 140, 0, 0,b));
    
    
    
    
    
    
    
    
 // R
    var oOffset = 80;
 
    balls.push(new Ball(oOffset + 205, 53, 0, 0, c));   
    balls.push(new Ball(oOffset + 210, 53, 0, 0, c));
    balls.push(new Ball(oOffset + 220, 53, 0, 0, c));
    balls.push(new Ball(oOffset + 230, 53, 0, 0, c));
    balls.push(new Ball(oOffset + 240, 53, 0, 0, c));
    balls.push(new Ball(oOffset + 250, 53, 0, 0, c));
    
    balls.push(new Ball(oOffset + 205, 68, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 83, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 98, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 113, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 128, 0, 0, c));
    balls.push(new Ball(oOffset + 205, 143, 0, 0, c));
    
    balls.push(new Ball(oOffset + 205, 98, 0, 0, c));
    balls.push(new Ball(oOffset + 220, 98, 0, 0,c));
    balls.push(new Ball(oOffset + 235, 98, 0, 0, c));
    balls.push(new Ball(oOffset + 240, 98, 0, 0, c));
    balls.push(new Ball(oOffset + 255, 98, 0, 0, c));
    
    balls.push(new Ball(oOffset + 255, 88, 0, 0, c));
    balls.push(new Ball(oOffset + 255, 78, 0, 0, c));
    balls.push(new Ball(oOffset + 255, 68, 0, 0, c));
    balls.push(new Ball(oOffset + 255, 58, 0, 0, c));
    
    
    balls.push(new Ball(oOffset + 255, 143, 0, 0, c));
    
    balls.push(new Ball(oOffset + 245, 133, 0, 0, c));
    
    balls.push(new Ball(oOffset + 235, 123, 0, 0, c));
    
    balls.push(new Ball(oOffset + 225, 113, 0, 0, c));
    
 
    

    
    
 // 0
    
    
    
    balls.push(new Ball(381, 53, 0, 0, d));
    balls.push(new Ball(391, 53, 0, 0, d));
    balls.push(new Ball(401, 53, 0, 0, d));
    balls.push(new Ball(411, 53, 0, 0, d));
    balls.push(new Ball(422, 53, 0, 0, d));
    balls.push(new Ball(432, 53, 0, 0, d));
    
    balls.push(new Ball(432, 63, 0, 0, d));
    balls.push(new Ball(432, 73, 0, 0, d));
    balls.push(new Ball(432, 83, 0, 0, d));
    balls.push(new Ball(432, 93, 0, 0, d));
    balls.push(new Ball(432, 103, 0, 0, d));
    balls.push(new Ball(432, 118, 0, 0, d));
    balls.push(new Ball(432, 133, 0, 0, d));
    balls.push(new Ball(432, 143, 0, 0, d));
    
    balls.push(new Ball(381, 63, 0, 0, d));
    balls.push(new Ball(381, 73, 0, 0, d));
    balls.push(new Ball(381, 83, 0, 0, d));
    balls.push(new Ball(381, 93, 0, 0, d));
    balls.push(new Ball(381, 103, 0, 0, d));
    balls.push(new Ball(381, 118, 0, 0, d));
    balls.push(new Ball(381, 133, 0, 0, d));
    balls.push(new Ball(381, 143, 0, 0,d));
    
    
    balls.push(new Ball(381, 143, 0, 0, d));
    balls.push(new Ball(391, 143, 0, 0, d));
    balls.push(new Ball(401, 143, 0, 0, d));
    balls.push(new Ball(411, 143, 0, 0, d));
    balls.push(new Ball(421, 143, 0, 0, d));
    balls.push(new Ball(432, 143, 0, 0, d));
    
    
    
    
   

    

    return balls;
  }
  
function getMousePos(canvas, evt) {
    // get canvas position
    var obj = canvas;
    var top = 0;
    var left = 0;
    while(obj.tagName != 'BODY') {
      top += obj.offsetTop;
      left += obj.offsetLeft;
      obj = obj.offsetParent;
    }

    // return relative mouse position
    var mouseX = evt.clientX - left + window.pageXOffset;
    var mouseY = evt.clientY - top + window.pageYOffset;
    return {
      x: mouseX,
      y: mouseY
    };
  }
  
function updateBalls(canvas, balls, timeDiff, mousePos) {
    var context = canvas.getContext('2d');
    var collisionDamper = 0.3;
    var floorFriction = 0.0005 * timeDiff;
    var mouseForceMultiplier = 1 * timeDiff;
    var restoreForce = 0.002 * timeDiff;

    for(var n = 0; n < balls.length; n++) {
      var ball = balls[n];
      // set ball position based on velocity
      ball.y += ball.vy;
      ball.x += ball.vx;

      // restore forces
      if(ball.x > ball.origX) {
        ball.vx -= restoreForce;
      }
      else {
        ball.vx += restoreForce;
      }
      if(ball.y > ball.origY) {
        ball.vy -= restoreForce;
      }
      else {
        ball.vy += restoreForce;
      }
      
   // mouse forces
      var mouseX = mousePos.x;
      var mouseY = mousePos.y;

      var distX = ball.x - mouseX;
      var distY = ball.y - mouseY;

      var radius = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));

      var totalDist = Math.abs(distX) + Math.abs(distY);

      var forceX = (Math.abs(distX) / totalDist) * (1 / radius) * mouseForceMultiplier;
      var forceY = (Math.abs(distY) / totalDist) * (1 / radius) * mouseForceMultiplier;

      if(distX > 0) {// mouse is left of ball
        ball.vx += forceX;
      }
      else {
        ball.vx -= forceX;
      }
      if(distY > 0) {// mouse is on top of ball
        ball.vy += forceY;
      }
      else {
        ball.vy -= forceY;
      }

      // floor friction
      if(ball.vx > 0) {
        ball.vx -= floorFriction;
      }
      else if(ball.vx < 0) {
        ball.vx += floorFriction;
      }
      if(ball.vy > 0) {
        ball.vy -= floorFriction;
      }
      else if(ball.vy < 0) {
        ball.vy += floorFriction;
      }
      
   // floor condition
      if(ball.y > (canvas.height - ball.radius)) {
        ball.y = canvas.height - ball.radius - 2;
        ball.vy *= -1;
        ball.vy *= (1 - collisionDamper);
      }

      // ceiling condition
      if(ball.y < (ball.radius)) {
        ball.y = ball.radius + 2;
        ball.vy *= -1;
        ball.vy *= (1 - collisionDamper);
      }

      // right wall condition
      if(ball.x > (canvas.width - ball.radius)) {
        ball.x = canvas.width - ball.radius - 2;
        ball.vx *= -1;
        ball.vx *= (1 - collisionDamper);
      }

      // left wall condition
      if(ball.x < (ball.radius)) {
        ball.x = ball.radius + 2;
        ball.vx *= -1;
        ball.vx *= (1 - collisionDamper);
      }
    }
  }
  
function Ball(x, y, vx, vy, color) {
    this.x = x;
    this.y = y;
    this.vx = vx;
    this.vy = vy;
    this.color = color;
    this.origX = x;
    this.origY = y;
    this.radius = 10;
  }
  function animate(canvas, balls, lastTime, mousePos) {
    var context = canvas.getContext('2d');

    // update
    var date = new Date();
    var time = date.getTime();
    var timeDiff = time - lastTime;
    updateBalls(canvas, balls, timeDiff, mousePos);
    lastTime = time;

    // clear
    context.clearRect(0, 0, canvas.width, canvas.height);

    // render
    for(var n = 0; n < balls.length; n++) {
      var ball = balls[n];
      context.beginPath();
      context.arc(ball.x, ball.y, ball.radius, 0, 2 * Math.PI, false);
      context.fillStyle = ball.color;
      context.fill();
    }

    // request new frame
    requestAnimFrame(function() {
      animate(canvas, balls, lastTime, mousePos);
    });
  }
  
  var canvas = document.getElementById('myCanvas');
  var balls = initBalls();
  var date = new Date();
  var time = date.getTime();
  /*
   * set mouse position really far away
   * so the mouse forces are nearly obsolete
   */
  var mousePos = {
    x: 9999,
    y: 9999
  };

  canvas.addEventListener('mousemove', function(evt) {
    var pos = getMousePos(canvas, evt);
    mousePos.x = pos.x;
    mousePos.y = pos.y;
  });

  canvas.addEventListener('mouseout', function(evt) {
    mousePos.x = 9999;
    mousePos.y = 9999;
  });
  animate(canvas, balls, time, mousePos);



</script>
                                     
            
            
            </div>
              
              
              
              
              </c:if>
      
      
        </div> 
      
      


</div>



    <c:if test="${  sessionuser eq 'medecin'  }">
              
              <div class="container">
              
              <c:import url="/inc/footer.jsp"/> 
              
              </div>
             
              
  </c:if>






<script>
$('.dropdown-toggle').mouseover(function() {
$(this).dropdown('toggle');
});
</script>


</body>
</html>