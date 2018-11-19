<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.joda.org/joda/time/tags" prefix="joda" %>
    
<!DOCTYPE html >
<html>
<head>

<title> BREF - Ordre Croissant Score Total</title>

<meta http-equiv="X-UA-Compatible" content="IE=edge" >
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Liste des séances en attente de validation">
<meta name="author" content="ENAD">

<link rel="shortcut icon" type="image/png" href="<c:url value="/inc/favicon.png"/>">
<!-- [if IE]><link rel="shortcut icon" type="image/x-icon" href="<c:url value="/inc/favicon.ico"/>"/><![endif]-->

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/font-awesome/css/font-awesome.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/style.css"/>" rel="stylesheet"/>

<link href="<c:url value="/inc/jquery-ui/jquery-ui.css"/>" rel="stylesheet"/>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!-- [if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
<! [endif]-->

<style type="text/css">


  .bref{
  
  font-weight:bold;
        color:#3498db;
        font-family:agencyfb;
        font-size:2em;
  
  }
  
  .meaning{
  
  font-style:italic;
        color:black;
        font-family:agencyfb;
        font-size:2em;
  
  
  }
  
  .info{
	
	border: 8px #3498db inset;
        border-radius:10px;
        text-align:justify;
        padding-left:50px;
        padding-right:20px;
        padding-top:30px;
        
  
}



</style>



</head>
<body >

<div class="container" id="responsecontainer">

<c:import url="/inc/verificationAvoirResultatBref.jsp" />



<c:if test="${  ! empty listebref }">


<script type="text/javascript">

var msgu = new SpeechSynthesisUtterance("J'ai trouvé ${listebref.size()} résultats");

msgu.lang = 'fr-FR';


window.speechSynthesis.speak(msgu);




</script>
                               
                               
                               
                               
                               
</c:if>

                <c:import url="/inc/enadnotice.jsp"/>
                
                <div class="row">
                
                       <div class="col-xs-12">
                       
                                 <div class="enad_ENAD">
                                 
                                 BREF - Ordre Croissant Score Total
                                 
                                 </div>
                       
                       </div>
                
                
                </div>
                
                <br>
                
       <div class="row info">
                
              <div id="brefun">
                
                     <div class="col-xs-1 bref">
                    
                    BREF 1 :
                    
                    
                    </div>
                    
                    <div class="col-xs-11 meaning">
                    
                    Score de l'épreuve des similitudes
                    
                    
                    </div>
                
                
             </div>
             
             <br><br>
             
             <div id="brefdeux">
                
                     <div class="col-xs-1  bref">
                    
                    BREF 2 :
                    
                    
                    </div>
                    
                    <div class="col-xs-11 meaning">
                    
                    Score de l'épreuve de fluence verbale
                    
                    
                    </div>
                
                
             </div>
             
             <br><br>
             
             <div id="breftrois">
                
                     <div class="col-xs-1  bref">
                    
                    BREF 3 :
                    
                    
                    </div>
                    
                    <div class="col-xs-11 meaning">
                    
                    Score du comportement de préhension
                    
                    
                    </div>
                
                
             </div>
             
             <br><br>
             
             <div id="brefquatre">
                
                     <div class="col-xs-1  bref">
                    
                    BREF 4 :
                    
                    
                    </div>
                    
                    <div class="col-xs-11 meaning">
                    
                    Score des séquences motrices de Luria
                    
                    
                    </div>
                
                
             </div>
             
             <br><br>
             
             <div id="brefcinq">
                
                     <div class="col-xs-1  bref">
                    
                    BREF 5 :
                    
                    
                    </div>
                    
                    <div class="col-xs-11 meaning">
                    
                    Score de l'épreuve des consignes conflictuelles
                    
                    
                    </div>
                
                
             </div>
             
             <br><br>
             
             <div id="brefsix">
                
                     <div class="col-xs-1  bref">
                    
                    BREF 6 :
                    
                    
                    </div>
                    
                    <div class="col-xs-11 meaning">
                    
                    Score de l'épreuve de Go - No Go
                    
                    
                    </div>
                
                
             </div>
             
             <br><br>
                
                    
                
        </div>
        
        <br>
                
                
                
                <!-- MENU + CONTACTS + NOTIFS -->
                
                <div class="row">
                
                
                
                <!-- MENU -->
                
                <div class="col-xs-12">
                
                      <div class="validees">
                      
                      
                               
                               
                               
                               <c:if test="${ ! empty listebref }">
                               
                               
                                        <div class="row totalseancesvalidation">
                                        
                                        TOTAL : ${listebref.size() }
                                        
                                        
                                        
                                        </div>
                                        
                                        <br>
                                        <br>
                                        <br>
                                        
                                        
                                        <div class="row">
                                        
                                            <div class="row col-xs-12  table-responsive">
                                            
                                            
                                                 <table class="table table-bordered table-striped">
                                            
                                                  <tr class="danger">
                                                  
                                                      <th>N°</th>
                                                      
                                                      <th>Date et heure </th>
                                                      
                                                      <th>Patient(e)</th>
                                                      
                                                      <th>BREF 1</th>
                                                      
                                                      <th>BREF 2</th>
                                                      
                                                      <th>BREF 3</th>
                                                      
                                                      <th>BREF 4</th>
                                                      
                                                      <th>BREF 5</th>
                                                      
                                                      <th>BREF 6</th>
                                                      
                                                      <th>TOTAL</th>
                                                      
                                                      
                                                      
                                                      
                                                  
                                                  </tr>
                                                  
                                                  
                                                  <c:forEach  items="${ listebref }" var="liste" varStatus="boucle">
                                                  
                                                  
                                                    <tr>
                                                  
                                                       <td> <c:out value=" ${boucle.index +1 } "/> </td>
                                                       
                                                       <td> <c:out value="${liste.date_heure_resultat_bref } "/> </td>
                                                       
                                                       <td> <c:out value="${liste.prenoms_noms_patient } "/> </td>
                                                       
                                                       <td> <c:out value="${liste.scoreEpreuveSimilitudes } "/> </td>
                                                       
                                                       <td> <c:out value="${liste.scoreEpreuveFluenceVerbale } "/> </td>
                                                       
                                                       <td> <c:out value="${liste.scoreComportementPrehension } "/> </td>
                                                       
                                                       <td> <c:out value="${liste.scoreSequencesMotricesLuria } "/> </td>
                                                       
                                                       <td> <c:out value="${liste.scoreEpreuveConsignesConflictuelles } "/> </td>
                                                       
                                                       <td> <c:out value="${liste.scoreEpreuveGoNoGo } "/> </td>
                                                       
                                                       <td> <c:out value="${liste.scoreTotalBref } "/> </td>
                                                       
                                                       
                                                  </tr>
                                                 
                                                  </c:forEach>
                                                 
                                            
                                            </table>
                                        
                                            
                                            </div>
                                        
                                        
                                            
                                        </div>
                               
                               
                               
                               
                               
                               </c:if>
                      
                      
                             
                      
                      
                      
                      
                      </div>
                
                    
                </div>
                
                
                
                </div>
                
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                
                <!-- Importer footer car il ne varie pas -->
                
                <c:import url="/inc/footer.jsp"/>
</div>

</body>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>

<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>







</html>