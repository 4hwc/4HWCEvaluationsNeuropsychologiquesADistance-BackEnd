/**
 * 
 */

//LSVM

$(window).load(function() {
 	 $(body).load('/enad/liste_seances_validation_Medecin');
 		  
 	
   var refreshId = setInterval(function() {
      $(body).load('/enad/liste_seances_validation_Medecin');
    	  
      
   }, 1000);
   $.ajaxSetup({ cache: false });
});


/////////////

var nb = 10 ;

 window.setTimeout(" window.refresh();", 1000*nb, "JavaScript");