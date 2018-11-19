<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html>
<html>
<head>

<title>Diaporama Test de Dénomination Orale d'Images</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Diaporama d'Images">
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
margin-top:195px;
font-weight:bold;
        color:white;
        font-family:agencyfb;
font-size:2em;

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

float:left;



}

#head_slider_content>*{

float:left;


}
        

       </style>
       



</head>
<body>

<div class="container">

<c:if test="${imagesdiaporama.size() == 0 }">

<script type="text/javascript">

window.location='/enad/telecharger_classer_images';


</script>


</c:if>

           <div class="row">
                
                      <div class="col-xs-12">
                      
                           
                           
                                 <div  id="head_slider">
                                 
                                
                                     
                                     <a id="bouton_telechargement" style="cursor:pointer;"  rel="tooltip" data-original-title="Je télécharge l'image actuelle.">
                                     
                                     
                                     <strong style=" font-size: 3em;"> <i class="fa fa-cloud-download" aria-hidden="true"></i></strong>
                    
                                     
                                     </a>
                                     
                                     
                                     
                                     <div id="numero_image" >
                     
                         <strong style=" font-size: 1em;"> <i class="fa fa-spinner fa-spin fa-3x fa-fw" aria-hidden="true" aria-hidden="true"></i></strong>
                     
                                </div>
                                
                               
                           
                     
                     <div id="head_slider_content_list">
                     
                             <div id="head_slider_content">
                             
                             
                             
                                   
                                   
                                    <img class="" id="img" alt="ENAD" src="<c:url value="/inc/patience.png"/>" > 
                                    
                                    
                                 
                                   
                                   <div class="hide">
                                   
                                            <c:forEach items="${imagesdiaporama }" var="images" varStatus="boucle">
                                            
                                            
                                            <div id ="${boucle.index}">${images.url_img_tdoi}</div>
                                            
                                           <a id="nom${boucle.index}" >${images.nom_img_tdoi}</a>
                                           
                                           
                                           
                                           
                                           
                                     
                                     </c:forEach>
                                   
                                   
                                   </div>
                             
                                     
                             
                             </div>
                     
                     </div>
                           
                           
                           
                           </div>
                           
                           
                           
                           
                      
                      
                           
                           
                           <script type="text/javascript">
                           
                           
                           
                           $(document).ready(function(){
                        	   
                        	  
                        	   
                        	   var numero;
                        		
                        		  
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
                        		   
                        		   var div = 'http://localhost:8080/enad'+gh || 'http://192.168.0.11:8080/enad'+gh;
                        		   
                        		  
                        		   
                        		   var adf = document.getElementById(ze).innerHTML;
                        		   
                        		   
                        		   urls.push(div);
                        		   
                        		   urlsmodifies.push(gh);
                        		   
                        		   noms.push(adf);
                        		   
                        		   
                        		  
                        		   
                        	   }
                        	   
                        	   var tempsattente = 20000;
                        	   
                        	   function changeImage()
                               {
                        		   
                        		   $('#bouton_telechargement').tooltip({placement:'top'});
                        		   
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
                               
                               
                        	   
                        	   setTimeout(changeImage, tempsattente);
                               
                              
                               
                               }
                        	   
                                   
                        	   var x=0;
                        	   
                        	   var numero;
                        	  
                               
                               setTimeout(changeImage, tempsattente);
                        	  
                        	});
                           
                           
                           </script>
                           
                           
                           
                           
                      
                      </div>
                
                
                
                </div>
                
                <footer class="row">
                
                   <div class="col-xs-12">
                   
                       <div id="telecharger_resultatsdiv">
                       
                       
                       
                       <c:if test="${imagesdiaporama.size()> 1 }">
                                                                                                                  
                                
                                                                                                                  
                               <a id="telecharger_resultatsbutton"   >Test de Dénomination Orale d'Images : Diaporama de  ${imagesdiaporama.size() } images.</a>
                           
                                                                                                                  
                       </c:if>
                       
                       <c:if test="${imagesdiaporama.size() == 1 }">
                       
                              
                                                                                                                  
                               <a id="telecharger_resultatsbutton"   >Test de Dénomination Orale d'Images : Image unique</a>
                           
                                                                                                                  
                       </c:if>
                          
                           </div>
                           
                           
                   
                   
                   </div>
                           
                           
                </footer>
         
         
         
</div>

</body>
</html>