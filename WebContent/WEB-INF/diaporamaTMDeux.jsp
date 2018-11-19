<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>


<html>
<head>

<title>${seancediaporama.titre_seance }</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Page d'accueil du médecin">
<meta name="author" content="ENAD">

 <!-- <meta http-equiv="refresh" content="0"> --> 

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

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
       
       <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
       
       <style type="text/css">
       
        
       #head_slider{

/*
background: linear-gradient(to bottom, #33ccff 0%, #ffffff 100%);

background: linear-gradient(to bottom, #009999 0%, #ffffff 100%);

background: linear-gradient(to bottom, #0066cc 0%, #ffffff 100%);

background: linear-gradient(to bottom, #000000 0%, #ffffff 100%);

*/

background: linear-gradient(to bottom, #0099cc 0%, #ffffff 100%);
height:500px;
width:100%;

}

#white-background{
  
    display:none;
    width:100%;
    height:100%;
    position:fixed;
    top:0px;
    left:0px;
    background-color:#fefefe;
    opacity:0.7;
    z-index:9999;
  
  }

#dlgbox{
  
  /*Initially dialog box is hidden*/
  
  display:none;
  
    position:fixed;
    width:600px;
    z-index:9999;
    border-radius:10px;
    
    border: 10px #0099cc outset;
  
  }
  
  #dlg-header{
  
  background-color:#0099cc;
  color:white;
  font-size:20px;
  padding:10px;
  margin: 10px 10px 0px 10px;
  
  }
  
  #dlg-body{
  
  background-color:white;
  
  color:black;
  
  font-size:14px;
  
  padding:10px;
  
  margin:0px 10px 0px 10px;
  
  }
  
  #dlg-footer{
  
  background-color:#f2f2f2;
  
  text-align:right;
  padding:10px;
  margin:0px 10px 10px 10px;
  
  }
  
  

#validfreq{


color: white;
  background-color: #2ecc71;
  border-color: #ecf0f1;

}

#numero_image{


float:right;
height:60px;
width:160px;
margin-right:0px;
margin-top:195px;
font-weight:bold;
        color:white;
        font-family:agencyfb;
font-size:2em;
}




#bouton_telechargement{


float:left;
height:60px;
width:60px;

margin-left:20px;
margin-top:60px;
font-weight:bold;
        color:white;
        font-family:agencyfb;


}

#play , #pause{

float:left;
height:60px;
width:60px;

margin-left:20px;
margin-top:60px;
font-weight:bold;
        color:white;
        font-family:agencyfb;


}

#frequence{

float:left;
height:60px;
width:60px;

margin-left:20px;
margin-top:60px;
font-weight:bold;
        color:white;
        font-family:agencyfb;


}


#telecharger_resultatsbutton{

color:white;

}

div#telecharger_resultatsdiv{
        background-color:#0099cc;
        font-size:2em;
        text-align:center;
        font-weight:bold;
        color:white;
        font-family:agencyfb;
        position:fixed;
        bottom:0px;
        width:100%;
        z-index:2;
        border-radius:10px;
        border: 8px white solid;
       
        }
        
        #head_slider_content_list{

height:500px;
width:820px;
margin:auto;
overflow:hidden;

}

#head_slider_content{

height:500px;

width:820px;





}

#head_slider_content>*{

display: block;
    margin: auto;
    

}


       
       </style>
       
       
</head>
<body>

       <div class="container">
       
       
       
              <div class="row">
              
                    <div class="col-xs-12">
                    
                          <div  id="head_slider">
                          
                          
                                   <a id="bouton_telechargement" style="cursor:pointer;"  rel="tooltip" data-original-title="Je télécharge l'image actuelle.">
                                     
                                     
                                     <strong style=" font-size: 3em;"> <i class="fa fa-cloud-download" aria-hidden="true"></i></strong>
                    
                                     
                                     </a>
                                     
                                     <c:if test="${imagesdiaporama.size() > 1 }">
                                     
                                     <a id="play" style="cursor:pointer;" class="hide" rel="tooltip" data-original-title="Je meta fin à la pause  du diaporama.">
                                     
                                        <strong style=" font-size: 3em;"> <i class="fa fa-play" aria-hidden="true"></i></strong>
                                     
                                     </a>
                                     
                                     <a id="pause" style="cursor:pointer;"  rel="tooltip" data-original-title="Je mets le diaporama en pause.">
                                     
                                        <strong style=" font-size: 3em;"> <i class="fa fa-pause" aria-hidden="true"></i></strong>
                                     
                                     </a>
                                     
                                     </c:if>
                                     
                                     
                                     
                                     
                                     <div id="white-background">
                                     
                                     </div>
                                     
                                     <div id="dlgbox">
                                     
                                         <div id="dlg-header">Fréquence du diaporama</div>
                                         
                                         <div id="dlg-body">
                                         
                                         
                                         
                                              <div class="form-group">
                                             
                                                <div class="input-group">
                                                
                                                      <input type="number" class="form-control input-lg" style="text-align:center" id="freqdiapo"  placeholder="Fréquence en secondes. Exemple:15">
                                         
                                                   <span class="input-group-addon">secondes</span>
                                                
                                                
                                                </div>
                                             
                                                   
                                             </div>
                                             
                                         
                                        
                                         
                                             
                                        
                                                 
                                         </div>
                                         
                                         <div id="dlg-footer">
                                         
                                             
                                         <button id="validfreq" class="btn ">Je valide.</button>
                                         
                                         
                                         </div>
                                     
                                     
                                     </div>
                                     
                                     <c:if test="${imagesdiaporama.size() > 1 }">
                                     
                                     <a id="frequence" style="cursor:pointer;"  rel="tooltip" data-original-title="Je choisis la fréquence du diaporama.">
                                     
                                        <strong style=" font-size: 3em;"> <i class="fa fa-pencil-square-o" aria-hidden="true"></i></strong>
                                     
                                     </a>
                                     
                                     
                                     </c:if>
                                     
                                     
                                     
                                     
                                     
                                     
                                     <div id="numero_image" >
                     
                         <strong style=" font-size: 1em;"> <i class="fa fa-spinner fa-spin fa-3x fa-fw" aria-hidden="true" aria-hidden="true"></i></strong>
                     
                                </div>
                                
                                
                                <div id="head_slider_content_list">
                                
                                
                                       <div id="head_slider_content">
                                       
                                        
                                              <img class="" width="820" height="500" id="img" alt="ENAD" src="<c:url value="/inc/patience.png"/>" >
                                              
                                              
                                              <div class="hide">
                                              
                                              <c:forEach items="${imagesdiaporama }" var="images" varStatus="boucle">
                                            
                                            
                                            <div id ="${boucle.index}">${images.url_img_tm}</div>
                                            
                                           <a id="nom${boucle.index}" >${images.nom_img_tm}</a>
                                           
                                           
                                     
                                     </c:forEach>
                                              
                                              
                                              </div>
                                       
                                       
                                       </div>
                                
                                
                                
                                </div>
                          
                          
                          
                          </div>
                          
                          <script type="text/javascript">
                          
                          
$(document).ready(function(){
                       	   
                        	  
                        	  var freqinput = document.getElementById("freqdiapo");
                            	
                           	 
                           	 var tempsattente = 20000;
                           	
                           	freqinput.focus();
                           	
                           	function showDialog(){
                            	   
                            	   var whitebg = document.getElementById("white-background");
                            	   
                            	   var dlg = document.getElementById("dlgbox");
                            	   
                            	   whitebg.style.display ="block";
                            	   
                            	   dlg.style.display ="block";
                            	   
                            	   if (document.body)
                            		{
                            		var winWidth = (document.body.clientWidth);
                            		var winHeight = (document.body.clientHeight);
                            		}

                            		else
                            		{
                            		var winWidth = (window.innerWidth);
                            		var winHeight = (window.innerHeight);
                            		}
                            	   
                            	   dlg.style.left = (winWidth/2) -480/2 +"px";
                            	   
                            	   dlg.style.top = "150px";
                               }
                           	
                         
                           	
                           	$('#frequence').click(function(){
                           		
                           		showDialog();
                           		
                           	});
                           	
                           $('#play').click(function(){
                           		
                         	  $('#play').addClass('hide');
                       		
                       		$('#pause').removeClass('hide');
                       		
                       		$('#frequence').removeClass('hide');
                       		
                       		abc = setTimeout(changeImage,tempsattente);
                           		
                           	});
                           
                           $('#pause').click(function(){
                         		
                         		
                         		
                         		$('#pause,#frequence').addClass('hide');
                         		
                         		$('#play').removeClass('hide');
                         		
                         		clearTimeout(abc);
                         		
                         	});
                           	
                           	
                           	 
                           		
                           	  
                           	   var nombre_imgtexte = '${imagesdiaporama.size()}';
                           		
                           		var nombre_img = parseInt(nombre_imgtexte);    
                           	   
                           	   var urls = [];
                           	   
                           	   var noms = [];
                           	   
                           	   var multipled = [];
                           	   
                           	   var urlsmodifies = [];

                           	   
                           	   for(var i=0;i<nombre_img;i++){
                           		   
                           		   var as = i+'';
                           		   
                           		   var ze = "nom"+i;
                           		   
                           		   
                           		   
                           		   //var div = 'http://192.168.0.13:8080/enad'+document.getElementById(as).innerHTML;
                           		   
                           		   var gh = document.getElementById(as).innerHTML;
                           		   
                           		   var div = 'http://'+'${  sessionScope.adresseserveur }'+':8080/enad'+gh ;
                           		   
                           		  
                           		   
                           		   var adf = document.getElementById(ze).innerHTML;
                           		   
                           		   
                           		   urls.push(div);
                           		   
                           		   urlsmodifies.push(gh);
                           		   
                           		   noms.push(adf);
                           		   
                           		   
                           	   }
                           	   
                           	   
                           	   
                           	   
                           	   function changeImage()
                                {
                           		   
                           			
                           		 $('#bouton_telechargement').tooltip({placement:'top'});
                         		   
                            		$('#play').tooltip({placement:'top'});
                            		
                            		$('#pause').tooltip({placement:'top'});
                            		
                            		$('#frequence').tooltip({placement:'top'});
                            		   
                                 var img = document.getElementById("img");
                                 
                                 var alink = document.getElementById("bouton_telechargement");
                                 
                                 img.src = urls[x];
                                 
                                alink.download = noms[x];
                                 
                                 
                              	alink.href=urls[x];
                              	
                              	//alink.href="http://stackoverflow.com/questions/18451856/how-can-i-let-a-user-download-multiple-files-when-a-button-is-clicked";
                              	
                              	//alink.click();
                              	
                                 
                                 x++;
                                 
                                 numero=x;

                                 if(x >= urls.length){
                                     x = 0;
                                     
                                 } 
                                 
                                 document.getElementById("numero_image").innerText = "Image "+numero;
                            	   
                            	   document.getElementById("numero_image").textContent = "Image "+numero;
                                
                                 
                                 console.log("n : "+numero); 
                                 
                                 
                                 
                                 $('#validfreq').click(function(){
                               		
                               		
                               		
                               		//validation valeurfreqinput
                               		
                               		var valeur = parseInt(freqinput.value);
                               		
                               		if(valeur>0){
                               			
                               			
                               			clearTimeout(abc);
                          				 
                          				 console.log("azerty");
                          				
                          				 
                          				tempsattente = valeur*1000;
                          				
                          				console.log("temps c:"+tempsattente);
                          				
                          				
                          				
                          				abc = setTimeout(changeImage,tempsattente);
                          				 
                          			 }
                               		
                               		//boitedisparait
                               		
                               		var whitebg = document.getElementById("white-background");
                             	   
                             	   var dlg = document.getElementById("dlgbox");
                             	   
                             	   whitebg.style.display ="none";
                             	   
                             	   dlg.style.display ="none";
                               		
                               		
                               	});
                               	
                                 
                               abc =   setTimeout(changeImage, tempsattente);   	
                          	   
                                
                                }
                           	   
                                    
                           	   var x=0;
                           	   
                           	   var numero;
                           	   
                           	var abc =  setTimeout(changeImage, tempsattente);   	
                       	   
                    	
                       	});
                          
                          
                          </script>
                    
                    
                    </div>
              
              
              </div>
              
              <footer class="row">
              
              
                    <div class="col-xs-12">
                    
                         <div id="telecharger_resultatsdiv">
                         
                           
                           <c:if test="${imagesdiaporama.size()> 1 }">
                           
                           <script type="text/javascript">

var msgy = new SpeechSynthesisUtterance("${imagesdiaporama.size()} images disponibles");


msgy.lang = 'fr-FR';

window.speechSynthesis.speak(msgy);

</script>
                                                                                                                  
                                
                                                                                                                  
                               <a id="telecharger_resultatsbutton"   >Trail - Making Version 2 : Diaporama de  ${imagesdiaporama.size() } images.</a>
                           
                                                                                                                  
                       </c:if>
                       
                       
                       <c:if test="${imagesdiaporama.size() == 1 }">
                       
                       <script type="text/javascript">

var msgy = new SpeechSynthesisUtterance("Image unique ");


msgy.lang = 'fr-FR';

window.speechSynthesis.speak(msgy);

</script>
                       
                              
                                                                                                                  
                               <a id="telecharger_resultatsbutton"   >Trail - Making Version 2 : Image unique</a>
                           
                                                                                                                  
                       </c:if>
                         
                         
                         </div>
                    
                    
                    
                    </div>
              
                    
              
              
              </footer>
       
       
       </div>

</body>
</html>