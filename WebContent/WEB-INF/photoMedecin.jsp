<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
<!DOCTYPE html>

<html>
<head>

<title>Upload de la photo de profil</title>

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

<style type="text/css">

.uploadimages{

background-color:transparent;
        font-size:3em;
        text-align:center;
        font-weight:bold;
        color:#0099cc;
        font-family:agencyfb;
        width:100%;

}

#boutonupload{


height:100px;
width:100px;

position:absolute;

left:50%;

font-weight:bold;
        color:#0099cc;
        font-family:agencyfb;


}

#galleryparent{

margin:5px;
padding:5px;

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

.consigne{

font-weight:bold;
        color:#7f8c8d;
        font-style:italic;
        
        font-size:2em;
        text-align:center;
        
        

}


</style>
</head>
<body>

      <div class="container">
      
               <div class="row">
               
                     <div class="col-xs-12">
                     
                           <div class="uploadimages">
                    
                           Upload de la photo de profil par le médecin ${sessionScope.sessionMedecin.prenoms_medecin }  ${sessionScope.sessionMedecin.noms_medecin }
                           
                    
                           </div>
                     
                     </div>
               
               
               </div>
               
               <br>
               
               <div class="row">
               
                      <div class="col-xs-12">
                      
                       
                        
                            <strong id="boutonupload" style=" font-size: 5em;"> <i class="fa fa-cloud-upload" aria-hidden="true"></i></strong>
                        
                       
                      
                             
                      
                      
                      </div>
               
               
               </div>
               
               <br>
               <br>
               <br>
               <br>
               <br>
               <br>
               
               <div class="row">
               
                     <div class="col-xs-12">
                     
                           <div class="consigne">
                    
                           S'il vous plaît, il faut choisir une photo dont la taille est inférieure à 1 méga octets. 
                           
                           
                    
                           </div>
                     
                     </div>
               
               
               </div>
              
               <br>
               
               
               <br>
               
               
               
               
               <div class="row">
               
                     <div class="col-xs-12">
                     
                                <input type="file" class="form-control" id="fileinput"  accept="image/*" >
                                
                               
                     </div>
           
               </div>
               
                <br>
                <br>
                
                <div id="galleryparent" class="row hide ">
                
                     <div  id="gallery" class="col-xs-12">
                     
                     
                     </div>
                
                
                
                
                </div>
               
               
      
      
      </div>
      
      <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
      
      
      <script type="text/javascript">
       
       $(document).ready(function(){
       	
       	function previewImage(file) {
       		var galleryId = "gallery";
       		var gallery = document.getElementById(galleryId);
       		var imageType = /image.*/;
       		if (!file.type.match(imageType)) {
       		throw "Le fichier doit être une image !";
       		}
       		var thumb = document.createElement("div");
       		thumb.classList.add('thumbnail'); // Add the class thumbnail to the created div
       		var img = document.createElement("img");
       		img.file = file;
       		thumb.appendChild(img);
       		gallery.appendChild(thumb);
       		// Using FileReader to display the image content
       		var reader = new FileReader();
       		reader.onload = (function(aImg) { return function(e) { aImg.src = e.target.result; };  
       		})(img);
       		reader.readAsDataURL(file);
       		}
       	
       	function SendFile(file){
       		
       	    	 var url = '/enad/uploadimagesphotoprofilmedecin';
       	    	 var xhr = new XMLHttpRequest();
       	    	 var fd = new FormData();
       	    	 
       	    	 xhr.open("POST", url, true);
       	    	 xhr.onreadystatechange = function() {
       	    	 if (xhr.readyState == 4 && xhr.status == 200) {
       	    	 // Every thing ok, file uploaded
       	    	 
       	    	 
       	    	
       	    	 console.log(xhr.responseText); 
       	    	 
       	    	 console.log("envoi réussi au serveur");
       	    	 
       	    	
       	    	 
       	    	 }else{
       	    		 
       	    		
       	    		
       	    	 }
       	    	 
       	    	console.group("File ");
       		   console.log("name : " + file.name);
       		   console.log("size : " + file.size);
       		   console.log("type : " + file.type);
       		   console.log("date : " + file.lastModifiedDate);
       		   console.groupEnd();
       	    	 
       	    	 
       	    	 };
       	    	 fd.append("upload_img_photomedecin", file);  
       	    	 xhr.send(fd);
       	    	 
       	     }
       	
       	

             

       		var uploadfiles = document.querySelector('#fileinput');
       		uploadfiles.addEventListener('change', function () {
       			
       			 $("#galleryparent").removeClass("hide");
       	    	   
       	    	   $('#galleryparent').show();
       		var files = this.files;
       		for(var i=0; i<files.length; i++){
       			
       			SendFile(this.files[i]);
       			
       		previewImage(this.files[i]);
       		
       		
       		
       		
       		
       		}
      
       		}, false);
       		
       		
       	
       	
       });


       
       
       </script>

</body>
</html>