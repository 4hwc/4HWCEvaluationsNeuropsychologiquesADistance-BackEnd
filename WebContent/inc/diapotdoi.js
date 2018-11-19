

$(document).ready(function(){ 
                        	   
                        	  
                        		   
var mode_automatique = 1;
                                  	
var mode_manuel = 0;

var nombre_imgtexte = '${imagesdiaporama.size()}';
	
	var nombre_img = parseInt(nombre_imgtexte);    
 
 var urls = [];
 
 var noms = [];
 
 var multipled = [];
 
 var urlsmodifies = [];
 
 var x=0;
   
   var numero;

 
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
 


while(mode_automatique == 1){
	
	var freqinput = document.getElementById("freqdiapo");
  	
    
 	 
 	 var tempsattente = 20000;
 	
 	
 	
 	freqinput.focus();
 	
 	function showDialog(){
    	   
    	   var whitebg = document.getElementById("white-background");
    	   
    	   var dlg = document.getElementById("dlgbox");
    	   
    	   whitebg.style.display ="block";
    	   
    	   dlg.style.display ="block";
    	   
    	   if (document.body)
    		{
    		var winWidth = (document.body.clientWidth);
    		var winHeight = (document.body.clientHeight);
    		}

    		else
    		{
    		var winWidth = (window.innerWidth);
    		var winHeight = (window.innerHeight);
    		}
    	   
    	   dlg.style.left = (winWidth/2) -480/2 +"px";
    	   
    	   dlg.style.top = "150px";
       }
 	
 	$('#frequence').click(function(){
  		
  		showDialog();
  		
  	});
 	
 	$('#validfreq').click(function(){
  		
  		
  		
  		//validation valeurfreqinput
  		
  		var valeur = parseInt(freqinput.value);
  		
  		if(valeur>0){
				 
				 console.log("azerty");
				 
				tempsattente = valeur*1000;
				
				console.log("temps c:"+tempsattente);
				 
			 }
  		
  		//boitedisparait
  		
  		var whitebg = document.getElementById("white-background");
	   
	   var dlg = document.getElementById("dlgbox");
	   
	   whitebg.style.display ="none";
	   
	   dlg.style.display ="none";
  		
  		
  	});
 	
 	function changeImage()
    {
		   
		
			
		 $('#bouton_telechargement').tooltip({placement:'top'});
		   
		$('#modemanuel').tooltip({placement:'top'});
		
		$('#modeautomatique').tooltip({placement:'top'});
		
		$('#frequence').tooltip({placement:'top'});
		   
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
 	
 	setTimeout(changeImage, tempsattente);
	   
  	
   	
	
 	$('#modemanuel').click(function(){
    	   
    	   mode_automatique = 0;
          	
          	 mode_manuel = 1;
       		
    		   $("#statutautomatique,#modemanuel,#frequence").addClass("hide");
   	    	
    	    	
    	    	$("#modeautomatique,#head_slider_fleche_gauche,#head_slider_fleche_droite,#statutmanuel").removeClass("hide");
    	    
       	});
}

while(mode_manuel == 1){
	
	
	function changeImageManuel(){
		   
  		
  			
  			
  		 $('#bouton_telechargement').tooltip({placement:'top'});
		   
   		
   		
   		$('#modeautomatique').tooltip({placement:'top'});
   		
   		
   		
        var img = document.getElementById("img");
        
        var alink = document.getElementById("bouton_telechargement");
        
        img.src = urls[x];
        
       alink.download = noms[x];
        
        
     	alink.href=urls[x];
     	
     	
     	$('#head_slider_fleche_droite').click(function(){
       		
     		x++;
     		
     		 numero=x;
       		
       	});
     	
    $('#head_slider_fleche_gauche').click(function(){
       		
     		x--;
     		
     		if(x <0 ){
                x = urls.length - 1;
                
            } 
     		
     		numero= x+1;
       		
       	});
     	
     	 
        

         if(x >= urls.length){
             x = 0;
             
         } 
         
         
         
         document.getElementById("numero_image").innerText = "Image "+numero;
    	   
    	   document.getElementById("numero_image").textContent = "Image "+numero;
        
         
         console.log("n : "+numero); 
         
  			
  	 }
  	   
  	
		   
  		changeImageManuel();
  		
  		   
  	  
  	   
	
	
	$('#modeautomatique').click(function(){
    	   
    	   mode_automatique = 1;
          	
          	 mode_manuel = 0;
       		
    		   $("#statutautomatique,#modemanuel,#frequence").removeClass("hide");
   	    	
    	    	
    	    	$("#modeautomatique,#head_slider_fleche_gauche,#head_slider_fleche_droite,#statutmanuel").addClass("hide");
    	    
       	});
	
}
                                  	
                                  	       
                           	
 });


                          