<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
    
    
<!DOCTYPE html >
<html>
<head>

<title>Réalisation Slider</title>

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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->


<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>


   <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
   
   <script src="<c:url value="/inc/realisationSliderJS.js"/>"></script>
   

<style type="text/css">

#head_slider{

/*
background: linear-gradient(to bottom, #33ccff 0%, #ffffff 100%);

background: linear-gradient(to bottom, #009999 0%, #ffffff 100%);

background: linear-gradient(to bottom, #0066cc 0%, #ffffff 100%);

background: linear-gradient(to bottom, #000000 0%, #ffffff 100%);



*/

background: linear-gradient(to bottom, #0099cc 0%, #ffffff 100%);
height:470px;
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

#head_slider_content_list{

height:470px;
width:820px;
margin:auto;
overflow:hidden;

}

#head_slider_content{

height:470px;
width:3000px;
float:left;


}

#head_slider_content>*{

float:left;


}

</style>


</head>
<body>

  <div class="container">
  
         <div class="row">
         
                <div class="col-xs-12">
                
                      <div class="backgroundgradient4">
      
             <div class="container_12" id="head_slider">
             
                     <div id="head_slider_fleche_gauche" style="cursor:pointer;">
                     
                           <strong style=" font-size: 4em;"> <i class="fa fa-chevron-circle-left" aria-hidden="true"></i></strong>
                     
                     </div>
                     
                     <div id="head_slider_fleche_droite" style="cursor:pointer;">
                     
                         <strong style=" font-size: 4em;"> <i class="fa fa-chevron-circle-right" aria-hidden="true"></i></strong>
                     
                     </div>
                     
                     <div id="head_slider_content_list">
                     
                           <div id="head_slider_content">
                           
                                  <object width="820" height="470" data="http://www.youtube.com/v/4LIwFN8HtC0?enablejsapi=1" type="application/x-shockwave-flash"><param name="movie" value="http://www.youtube.com/v/4LIwFN8HtC0?enablejsapi=1"/><param name="wmode" value="transparent"/></object> 
                <object width="820" height="470" data="http://www.youtube.com/v/qXOwF5n5bos?enablejsapi=1" type="application/x-shockwave-flash"><param name="movie" value="http://www.youtube.com/v/qXOwF5n5bos?enablejsapi=1"/><param name="wmode" value="transparent"/></object> 
                <object width="820" height="470" data="http://www.youtube.com/v/uG4trJ1lduQ?enablejsapi=1" type="application/x-shockwave-flash"><param name="movie" value="http://www.youtube.com/v/uG4trJ1lduQ?enablejsapi=1"/><param name="wmode" value="transparent"/></object> 
                           
                           </div>
                     
                     </div>
             
             
             </div>
      
      </div>
      
      <div class="clearnospacing"></div>
      
      <!-- Page Callout Section -->
      
      <div class="calloutcontainer">
      
            <div class="container_12">
            
                <div class="grid_12">
                
                    <p class="calloutbutton alignright"><a href="a_propos.html" class="button black large">En savoir plus sur moi</a></p>
                    
                    <div class="callouttext"><span>Yann Bidon</span>  - Développeur web et d'applications</div>
                
                
                </div>
            
            
            </div>
      
      </div>
      
      <!-- End Page Callout Section -->
                      
         
         
               </div>
         
         </div>
  
  
  
  </div>


      
</body>
</html>