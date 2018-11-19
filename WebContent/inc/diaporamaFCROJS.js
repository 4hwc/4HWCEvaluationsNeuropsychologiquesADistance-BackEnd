/**
 * 
 */

$(document).ready(function(){
	
	var nombre_imgtexte = '${imagesdiaporama.size()}';
	
	var nombre_img = parseInt(nombre_imgtexte);
    
    var largeur_head_slider_content = nombre_img*1000;
    
    $("#head_slider_content").css('width', largeur_head_slider_content+'px');
    
    
    
    
    	
    	slider.init();
    	
    	slider.play_defil();
    	
   
	
	
});

slider={
		
		init:function(){
			
			slider.elem = $("#head_slider_content");
			
			slider.nbSlide = slider.elem.find("object").length;
			
			slider.current = 0;
			
			$("#head_slider_fleche_droite").click(function(){
				
				slider.next();
			});
			
        $("#head_slider_fleche_gauche").click(function(){
				
				slider.prev();
			});
        
        
    	
        $("#head_slider").mouseover(function(){
				
				slider.stop_defil();
			});
        
        
        $("#head_slider").mouseout(function(){
			
			slider.play_defil();
		});
			
        
		},
		
		next:function(){
			
			slider.current++;
			
			if(slider.current>slider.nbSlide - 1){
				
				slider.current=0;
				
				slider.elem.stop().animate({marginLeft:"0px"});
			}else{
				
				slider.elem.stop().animate({marginLeft:-slider.current*820+"px"});
				
			}
			
			
		},
		
         prev:function(){
			
			slider.current--;
			
			if(slider.current<0){
				
				slider.current=slider.nbSlide-1;
				
				
			}
				
	    slider.elem.stop().animate({marginLeft:-slider.current*820+"px"});
				
			
		},
		
		play_defil:function(){
			
			slider.timer=window.setInterval("slider.next()",5000);
		},
		
      stop_defil:function(){
			
			window.clearInterval(slider.timer);
		}
		
		
       
}