<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<title>Notice</title>


<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Notice d'utilisation d'ENAD">
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

</head>
<body>

            <div class="container">
            
                 <div class="row">
                 
                        <div class="col-xs-12">
                             
                             <div class="enad_background_image">
                             
                             
                             <!-- 
                    
                    <script>
                    
                    function changeImage(element)
                    {
                      var x = element.getElementsByTagName("img").item(0);
                      var v = x.getAttribute("src");
                      if(v == "inc/enadsoleil.png")
                        v = "inc/enadtof.png";
                      else
                        v = "inc/enadsoleil.png";
                      x.setAttribute("src", v);	
                    }
                    
                    setTimeout('changeImage(element)',1000);
                    
                    </script>
                    
                    <a onclick="changeImage(this)"> <img class="image"  alt="ENAD" src="inc/enadsoleil.png"  > </a>
                    
                    
                    
                    Spécial : faire disparaître une image
                    
                    <img class="image" id="img" alt="ENAD" src="<c:url value="/inc/enadtofl.png"/>" >
                    <script>
                    
                 
                 
                 function changeImage()
                        {
                        var img = document.getElementById("img");
                        
                        img.src = images[x];
                        
                        x++;

                        if(x >= images.length){
                            x = 0;
                        } 
                        
                        fadeImg(img, 100, true);
                        
                        setTimeout('changeImage()', 10000);
                        
                        }
                 
                 function fadeImg(el, val, fade){
                	    if(fade === true){
                	        val--;
                	    }else{
                	        val ++;
                	    }

                	    if(val > 0 && val < 100){
                	        el.style.opacity = val / 100;
                	        setTimeout(function(){fadeImg(el, val, fade);}, 10);
                	    }
                	}
                 
                 
                        
                    
                        var images = ['inc/enadsoleil.png','inc/enadtof.png','inc/enadtofa.png'];
                 
                        var x=0;
                        
                        setTimeout('changeImage()', 10000);
                        
 
                    </script>
                    
                    
                    
                    
                    -->
                    
                             
                                 <script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
                                 
                                 <!-- <img class="image" id="img" alt="ENAD" src="<c:url value="/inc/enadtofl.png"/>" > -->
                                 
                                
                                 <img class="image" id="img" alt="ENAD" src="<c:url value=""/>" >
                                 
                    <script>
                    
                 
                 
                 function changeImage()
                        {
                        var img = document.getElementById("img");
                        
                        img.src = images[x];
                        
                        x++;

                        if(x >= images.length){
                            x = 0;
                        } 
                        
                       
                        
                        setTimeout('changeImage()', 10000);
                        
                        }
                 
                    
                        var images = ['inc/enadsoleil.png','inc/enadtof.png','inc/enadtofa.png','inc/p0 03 08 2016 (1).JPG','inc/enad accueil 29 08 2016.JPG','inc/p1 24 07 2016.JPG','inc/p1 27 07 2016.JPG','inc/p1 28 07 2016.JPG','inc/p2 29 07 2016 med.JPG','inc/p3 29 07 2016 pat.JPG'];
                 
                        var x=0;
                        
                        setTimeout('changeImage()', 10000);
                        
 
                    </script>
                 
                
                             </div>
                        </div>
                 </div>
            
            
            </div>
            
            
            
<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
       <script src="<c:url value="/inc/jquery-3.1.0.js"/>"></script>
       <script src="<c:url value="/inc/jquery-ui/jquery-ui.js"/>"></script>
       <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>
       
       
</body>
</html>