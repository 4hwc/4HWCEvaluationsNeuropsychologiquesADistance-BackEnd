<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html>

<html>
<head>

<title>Suppression d'images TDOI</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Upload d'images">
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
 

<style type="text/css">




.az{

margin:15px;
padding:15px;

border: 10px #0099cc outset;
border-radius:5px;


}



#gallery .thumbnail{
width:150px;
height: 150px;
float:left;
margin:10px;
}
#gallery .thumbnail img{
width:150px;
height: 150px;
}

.total{

background-color:#0099cc;
        font-size:4em;
        text-align:center;
        font-weight:bold;
        color:white;
        font-family:agencyfb;
      
        width:100%;
        
        border-radius:10px;
        border: 8px white solid;

}


</style>
</head>
<body>


   <div class="container az">
   
   <c:import url="/inc/verificationTdoiImagesPresentes.jsp" />
   
   

<c:if test="${imagesdiaporama.size() > 0 }">

<script type="text/javascript">

//var msgy = new SpeechSynthesisUtterance("Pour supprimer, c'est facile ! Cliquez sur l'image !");


//msgy.lang = 'fr-FR';

//window.speechSynthesis.speak(msgy);

</script>


</c:if>

<div class="row">

      <div  class="total" class="col-xs-12 ">
      
      ${imagesdiaporama.size()}
                        
      </div>



</div>

<br><br>
   
          <div class="row">
          
                
                 
                     <div  id="gallery" class="col-xs-12 ">
                     
                     <c:forEach items="${imagesdiaporama }" var="images" varStatus="boucle">
                     
                     <script type="text/javascript">
                     
                     $(document).ready(function(){
       
       
    	   var source = 'http://${  sessionScope.adresseserveur }:8080/enad${images.url_img_tdoi}';
       	
       	function viewImage(source) {
       		
       		var Id_lettre = "${boucle.index}"; 
       		var galleryId = "gallery";
       		var gallery = document.getElementById(galleryId);
       		
       		var thumb = document.createElement("div");
       		
       		thumb.id=Id_lettre;
       		thumb.classList.add('thumbnail'); // Add the class thumbnail to the created div
       		var img = document.createElement("img");
       		
       		img.id='c'+Id_lettre;
       		var a = document.createElement("a");
       		
       		
       		
       		a.href = "/enad/suppression_imagesTdoi?idtdoi=${images.id_image_test_tdoi}";
       		img.src = source;
       		thumb.appendChild(img);
       		thumb.appendChild(a);
       		gallery.appendChild(thumb);
       		
       		document.getElementById(thumb.id).addEventListener('click', function() {
            	
            	
            
    			a.click();
    		} , true);
       		
       		var d = '#'+thumb.id;
       		
       		$(d).css('cursor', 'pointer');
       		
       		}
       	
       	//donner un id
       	//affecter un a pour chaque div avec un href suppression
       	
       	viewImage(source);});
       	
       
       </script>
                     
                     
                     </c:forEach>
                     
                     
                      
                     
                     
                     </div>
                 
                 
                 
          
          </div>
   
   
   </div>







     
      
     


</body>
</html>