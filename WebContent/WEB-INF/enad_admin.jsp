<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda"%>
<!DOCTYPE html>
<html>
<head>

<title>Bienvenue sur ENAD ADMIN</title>



<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Le but est de permettre à un admin de gérer le site ENAD.">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png"
	href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />

<link href="<c:url value="/inc/style_admin.css"/>" rel="stylesheet" />

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

				<div class="enad_background_image_admin">

					<div class="barredeprogression">

						<div class="progress progress-striped">
							<div class="progress-bar progress-bar-info"></div>
						</div>

						<div id="pourcentage" class="pull-right"></div>
					</div>

					<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
					<script>
                    
                            function timer(n) {
                            	$(".progress-bar").css("width",n+"%");
                            	$("#pourcentage").text("Chargement : "+n+"%");
                            	
                            	if(n<100){
                            		
                            		setTimeout(function(){
                            			timer(n+10);
                            		},6000);
                            	}
                            }
                            
                            $(function(){
                            	
                            	
                            		
                            		timer(0);
                            	
                            });
                    
                    
                    </script>

					<script>
                    
                    function redirect()
                    
                    {
                    	window.location='/enad/enad_admin_connexion';
                    }
                    
                    setTimeout('redirect()',66000);
                    
                    </script>

					<img class="image" id="img" alt="ENAD"
						src="<c:url value="/inc/enadsoleil.png"/>">





				</div>
			</div>
		</div>
	</div>

	<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>

</body>
</html>