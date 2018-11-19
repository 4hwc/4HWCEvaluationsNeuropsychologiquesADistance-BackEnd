/**
 * 
 */

(function($){
	
	$('input.round').wrap('<div class="round" />').each(function(){
		
		var $input = $(this);
		
		var $div = $input.parent();
		
		var min = $input.data('min');
		
		var max = $input.data('max');
		
		var ratio = ($input.val()- min) / (max - min);
		
		var color = $input.data('color') ? $input.data('color') : "#91c2ff";
		
		$circle = $(' <canvas width="200px" height="200px" >');
		
		$color = $(' <canvas width="200px" height="200px" >');
		
		$div.append($circle);
		
		$div.append($color);
		
		var ctx = $circle[0].getContext('2d');
		
		ctx.beginPath();
		
		ctx.arc(100,100,85,0,2*Math.PI);
		
		ctx.lineWidth = 20;
		
		ctx.strokeStyle ="#FFF";
		
		ctx.shadowOffsetX = 2;
		
		ctx.shadowBlur= 5;
		
		ctx.shadowColor = "rgba(0,0,0,0.1)";
		
		ctx.stroke();
		
		
		var ctx = $color[0].getContext('2d');
		
		ctx.beginPath();
		
        ctx.arc(100,100,85,-1/2*Math.PI,ratio*2*Math.PI-1/2*Math.PI);
		
		ctx.lineWidth = 20;
		
		ctx.strokeStyle =color;
		
		
		
		ctx.shadowColor = "rgba(0,0,0,0.1)";
		
		ctx.stroke();
		
		
		$div.mousedown(function(event){
			
			
			
			event.preventDefault();
			
			$div.bind('mousemove',function(event){
				
				
				
				var x = event.pageX - $div.offset().left - $div.width()/2;
				
				var y = event.pageY - $div.offset().top - $div.height()/2;
				
				var angle = Math.atan2(x,-y)/(2*Math.PI);
				
				
				if(angle<0){a+=1;}
				
				ctx.clearRect(0,0,200,200);
				
				ctx.beginPath();
				
			       ctx.arc(100,100,85,-1/2*Math.PI,angle*2*Math.PI-1/2*Math.PI);
					
					ctx.lineWidth = 20;
					
					ctx.strokeStyle =color;
					
					
					ctx.stroke();
					
					$input.val(Math.round(angle*(max-min)+min));
					
			
				
			})
			
			
		}).mouseup(function(event){
			
			event.preventDefault();
			
			$div.unbind('mousemove');
		})
		
		
		
	})
	
})(jQuery);