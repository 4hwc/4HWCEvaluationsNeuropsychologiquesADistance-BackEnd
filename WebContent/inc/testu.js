/**
 * 
 */

window.onload = function() {
	
	if (document.body)
	{
	var larg = (document.body.clientWidth);
	var haut = (document.body.clientHeight);
	}

	else
	{
	var larg = (window.innerWidth);
	var haut = (window.innerHeight);
	}
	
	var largeurresponsive ,hauteurresponsive,largeurresponsivearrondie,hauteurresponsivearrondie;
	
	
	
	if(larg<768){
		
 largeurresponsive = (larg*800)/1366;
		
 hauteurresponsive = (haut*500)/662;
		
 largeurresponsivearrondie = Math.floor(largeurresponsive);
		
 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
		
		
		
		
	}

	if(larg >= 768 && larg<992){
		
 largeurresponsive = (larg*800)/1366;
		
 hauteurresponsive = (haut*500)/662;
		
 largeurresponsivearrondie = Math.floor(largeurresponsive);
		
 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
		
		
		
		
	}

	if(larg >= 992 && larg<1200){
		
largeurresponsive = (larg*800)/1366;
		
 hauteurresponsive = (haut*500)/662;
		
 largeurresponsivearrondie = Math.floor(largeurresponsive);
		
 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
		
		
		
	}

	if(larg >= 1200 ){
		
		 largeurresponsive = (larg*800)/1366;
		
		 hauteurresponsive = (haut*500)/662;
		
		 largeurresponsivearrondie = Math.floor(largeurresponsive);
		
		 hauteurresponsivearrondie = Math.floor(hauteurresponsive);
		
		
		
		
	}
	
	var w,h;
	
	w = largeurresponsivearrondie+'';
	
		h=hauteurresponsivearrondie+'';
	
	document.getElementById('canvasfcromg').setAttribute('height',h);
	
	document.getElementById('canvasfcromg').setAttribute('width',w);


	};



