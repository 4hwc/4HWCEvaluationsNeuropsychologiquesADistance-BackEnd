

$(document).ready(function(){
	
	function previewImage(file) {
		var galleryId = "gallery";
		var gallery = document.getElementById(galleryId);
		var imageType = /image.*/;
		if (!file.type.match(imageType)) {
		throw "Le fichier doit être une image !";
		}
		var thumb = document.createElement("div");
		thumb.classList.add('thumbnail'); // Add the class thumbnail to the created div
		var img = document.createElement("img");
		img.file = file;
		thumb.appendChild(img);
		gallery.appendChild(thumb);
		// Using FileReader to display the image content
		var reader = new FileReader();
		reader.onload = (function(aImg) { return function(e) { aImg.src = e.target.result; };  
		})(img);
		reader.readAsDataURL(file);
		}
	
	function SaveFile(file){
		
	    	 var url = '/enad/uploadimagestdoi?idemed=${sessionScope.sessionMedecin.identifiant_medecin }';
	    	 var xhr = new XMLHttpRequest();
	    	 var fd = new FormData();
	    	 
	    	 xhr.open("POST", url, true);
	    	 xhr.onreadystatechange = function() {
	    	 if (xhr.readyState == 4 && xhr.status == 200) {
	    	 // Every thing ok, file uploaded
	    	
	    	 console.log(xhr.responseText); 
	    	 }
	    	 };
	    	 fd.append("upload_img_tdoi", file);  
	    	 xhr.send(fd);
	    	 
	     }
	
	

       var compteur = 0;

		var uploadfiles = document.querySelector('#fileinput');
		uploadfiles.addEventListener('change', function () {
			
			 $("#galleryparent").removeClass("hide");
	    	   
	    	   $('#galleryparent').show();
		var files = this.files;
		for(var i=0; i<files.length; i++){
			
			SaveFile(this.files[i]);
			
		previewImage(this.files[i]);
		
		
		compteur++;
		}
		
if(compteur == files.length){
			
			
		}
		}, false);
		
		
	
	
});

