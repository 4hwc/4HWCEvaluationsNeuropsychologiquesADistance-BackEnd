/**
 * 
 */

(function($){
	
	$.fn.notif = function(options){
		
		//console.log(options);
		
		var settings = {html:'<div class="notification animated fadeInLeft {{cls}}"> \
            <div class="left">\
            <div class="icon">\
	{{{icon}}}\
           </div>\
       </div>\
       <div class="right">\
               <h2>{{title}}</h2>\
               <p>{{content}}</p>\
       </div>\
  </div>',icon :'&#8505;'}
		
		if(options=='error'){
			
			settings.icon= '&#10060;';
		}
		
        if(options=='success'){
			
			settings.icon= '&#10003;';
		}
		
		var options = $.extend(settings,options);
		
		
		
		return this.each(function(){
			
			var $this = $(this);
			var $notifs = $('>.notifications',this);
			var $notif = $(Mustache.render(options.html,options));
			if($notifs.length==0){
				
				$notifs = $('<div class="notifications animated flipInX "/>');
				
				$this.prepend($notifs);
			}
			
			$notifs.append($notif);
			$notif.click(function(event){
				
				event.preventDefault();
				
				$notif.addClass('fadeOutLeft').delay(500).slideUp(300, function(){
					
					if($notif.siblings().length==0){
						
						$notifs.remove();
					}
					
					$notif.remove();
				});
			})
		})
	}
	
	$('.add').click(function(event){
		
		event.preventDefault();
		
		$('body').notif({title:'Mon titre',content:'Mon contenu'});
		
		
	})
	
	
	
	
})(jQuery);