<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
    .doc {
        width: 604px;
        margin: 0 auto;
    }
    canvas {
        display: block;
        border: 2px solid #888;
    }
</style>

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
	
<title>CANVAS TO IMAGE</title>
</head>
<body>

<!--  

<a class="btn btn-success" href="javascript:void(0);" onclick="htmlexecute();">Generate  
        Screenshot And Save it :) »</a>
        
        
        s

function htmlexecute() {
	
	html2canvas(document.body, {
		  onrendered: function(canvas) {
			  var img = canvas.toDataURL("image/png").replace("image/png", "image/octet-stream");
		      location.href = img;
		  },
		  
		  useCORS:false
		});
  	
  		
  }
  
  

-->



<a id="download" class="btn btn-success"  onclick="htmlexecute();">Generate  
        Screenshot And Save it :) »</a>
        
        

<script type="text/javascript">

function htmlexecute() {
	
	html2canvas(document.body, {
		  onrendered: function(canvas) {
			  //document.body.appendChild(canvas);
			  
			// save canvas image as data url (png format by default)
		      //var dataURL = canvas.toDataURL("image/png").replace("image/png", "image/octet-stream");

		      // set canvasImg image src to dataURL
		      // so it can be saved as an image
		      
		      //var img = new Image();
		     // img.src = dataURL;
		     
		     ///var image = Canvas2Image.convertToPNG(canvas);
		     
		      //return Canvas2Image.saveAsPNG(canvas);
		     
		    // var image = Canvas2Image.convertToPNG(canvas);
		     
		     //return image;
		     
		     function downloadCanvas(link, canvas, filename) {
    link.href = canvas.toDataURL();
    link.download = filename;
}
		     
		     document.getElementById('download').addEventListener('click', function() {
		    	    downloadCanvas(this, canvas, 'test.png');
		    	}, false);
		     
			  
			  
			
		      
			  
		  },
		  
		  useCORS:false
		});
  	
  		
  }


</script>

<script src="<c:url value="/inc/jquery-1.12.4.min.js"/>"></script>
	

<script src="<c:url value="/inc/html2canvas/html2canvas.js"/>"></script>


<script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>

        

</body>
</html>