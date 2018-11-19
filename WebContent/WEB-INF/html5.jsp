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
              
                    <c:if test="${  sessionuser eq 'patient'  }">
                    
                          <div id="kinetic">
                          
                                <script type="text/javascript">
                                
                                     window.onload = function(){
                                    	 
                                    	 var scene = new Kinetic.Stage({
                                    		 
                                    		 container:"kinetic",
                                    		 width:auto,
                                    		 height:device-height
                                    	 });
                                    	 
                                    	 var calque = new Kinetic.Layer();
                                    	 
                                    	 //Ici on dessine sur le calque
                                    	 
                                    	 scene.add(calque);
                                     };
                                
                                
                                
                                
                                
                                
                                </script>
                          
                          
                          
                          </div>
                          
                          
                          <c:if test="${  main eq 'gauche'  }">
                          
                          </c:if>
                          
                          <c:if test="${  main eq 'droite'  }">
                          
                          </c:if>
                    
                    
                    </c:if>
                    
                    <c:if test="${  sessionuser eq 'medecin'  }">
                    
                    
                    </c:if>
              
              
              </div>
      
      
      </div>


</div>


<script src="<c:url value="/inc/bootstrap.js"/>"></script>

<script src="<c:url value="/inc/kinetic/kinetic-v5.1.0.js"/>"></script>

</body>
</html>