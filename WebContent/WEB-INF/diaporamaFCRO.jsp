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

#head_slider_fleche_droite{


float:right;
height:60px;
width:60px;
margin-top:195px;

}

#head_slider_fleche_gauche{


float:left;
height:60px;
width:60px;
margin-top:195px;

}



#telecharger_resultatsbutton{

color:white;

}

div#telecharger_resultatsdiv{
        background-color:#0099cc;
        font-size:4em;
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

float:left;



}

#head_slider_content>*{

float:left;


}
        


       
       
       
       
       
       </style>
       
       <script type="text/javascript">
       
       
       
       var nombre_imgtexte = '${imagesdiaporama.size()}';
		
		var nombre_img = parseInt(nombre_imgtexte);
	    
	    var largeur_head_slider_content = nombre_img*1000;
	    
	   
	    
	    $("#head_slider_content").css('width', largeur_head_slider_content+'px');
       
       </script>
      
      
      


</head>
<body>

         <div class="container">
         
                <div class="row">
                
                      <div class="col-xs-12">
                      
                           <div>
                           
                                 <div  id="head_slider">
                           
                           
                           <c:if test="${imagesdiaporama.size()> 1 }">
                           
                           <div id="head_slider_fleche_gauche" style="cursor:pointer;">
                     
                           <strong style=" font-size: 4em;"> <i class="fa fa-chevron-circle-left" aria-hidden="true"></i></strong>
                     
                                     </div>
                     
                                  <div id="head_slider_fleche_droite" style="cursor:pointer;">
                     
                         <strong style=" font-size: 4em;"> <i class="fa fa-chevron-circle-right" aria-hidden="true"></i></strong>
                     
                                </div>
                           
                           
                           </c:if>
                           
                           
                                     
                     
                     <div id="head_slider_content_list">
                     
                             <div id="head_slider_content">
                             
                                     <c:forEach items="${imagesdiaporama }" var="images">
                                     
                                          
                                           <img width="820" height="500"  alt="${images.nom_img_fcro}" src="<c:url value="${images.url_img_fcro}"/>" >
                                 
                                     
                                     </c:forEach>
                             
                             </div>
                     
                     </div>
                           
                           
                           
                           </div>
                           
                           
                           
                           </div>
                      
                      
                           
                           
                           <script type="text/javascript">
                           
                           $(document).ready(function(){
                        		
                        		
                        	    
                        	    
                        	    	
                        	    	slider.init();
                        	    	
                        	    	slider.play_defil();
                        	    	
                        	});
                           
                           slider={
                       			
                       			init:function(){
                       				
                       				slider.elem = $("#head_slider_content");
                       				
                       				slider.nbSlide = slider.elem.find("object").length;
                       				
                       				slider.current = 0;
                       				
                       				$("#head_slider_fleche_droite").click(function(){
                       					
                       					slider.next();
                       				});
                       				
                       	        $("#head_slider_fleche_gauche").click(function(){
                       					
                       					slider.prev();
                       				});
                       	        
                       	        
                       	    	
                       	        $("#head_slider").mouseover(function(){
                       					
                       					slider.stop_defil();
                       				});
                       	        
                       	        
                       	        $("#head_slider").mouseout(function(){
                       				
                       				slider.play_defil();
                       			});
                       				
                       	        
                       			},
                       			
                       			next:function(){
                       				
                       				slider.current++;
                       				
                       				if(slider.current>slider.nbSlide - 1){
                       					
                       					slider.current=0;
                       					
                       					slider.elem.stop().animate({marginLeft:"0px"});
                       				}else{
                       					
                       					slider.elem.stop().animate({marginLeft:-slider.current*820+"px"});
                       					
                       				}
                       				
                       				
                       			},
                       			
                       	         prev:function(){
                       				
                       				slider.current--;
                       				
                       				if(slider.current<0){
                       					
                       					slider.current=slider.nbSlide-1;
                       					
                       					
                       				}
                       					
                       		    slider.elem.stop().animate({marginLeft:-slider.current*820+"px"});
                       					
                       				
                       			},
                       			
                       			play_defil:function(){
                       				
                       				slider.timer=window.setInterval("slider.next()",5000);
                       			},
                       			
                       	      stop_defil:function(){
                       				
                       				window.clearInterval(slider.timer);
                       			}
                       			
                       			
                       	       
                       	}
                          

                        	
                           </script>
                           
                           
                           
                           
                      
                      </div>
                
                
                
                </div>
                
                <footer class="row">
                
                   <div class="col-xs-12">
                   
                       <div id="telecharger_resultatsdiv" style="cursor:pointer;">
                       
                       
                       
                       <c:if test="${imagesdiaporama.size()> 1 }">
                                                                                                                  
                                
                                                                                                                  
                               <a id="telecharger_resultatsbutton" class="btn-block"  href="<c:url value="/notice"/>">Je télécharge toutes les ${imagesdiaporama.size() } images.</a>
                           
                                                                                                                  
                       </c:if>
                       
                       <c:if test="${imagesdiaporama.size() == 1 }">
                       
                              
                                                                                                                  
                               <a id="telecharger_resultatsbutton" class="btn-block"  href="<c:url value="/notice"/>">Je télécharge l'image.</a>
                           
                                                                                                                  
                       </c:if>
                          
                           </div>
                   
                   
                   </div>
                           
                           
                </footer>
         
         
         
         </div>

</body>
</html>