<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FACEBOOK CUSTOM DIALOGUE </title>

<style type="text/css">

  #white-background{
  
    display:none;
    width:100%;
    height:100%;
    position:fixed;
    top:0px;
    left:0px;
    background-color:#fefefe;
    opacity:0.7;
    z-index:9999;
  
  }
  
  #dlgbox{
  
  /*Initially dialog box is hidden*/
  
  display:none;
  
    position:fixed;
    width:480px;
    z-index:9999;
    border-radius:10px;
    background-color:#7c7d7c;
  
  }
  
  #dlg-header{
  
  background-color:#6d84b4;
  color:white;
  font-size:20px;
  padding:10px;
  margin: 10px 10px 0px 10px;
  
  }
  
  #dlg-body{
  
  background-color:white;
  
  color:black;
  
  font-size:14px;
  
  padding:10px;
  
  margin:0px 10px 0px 10px;
  
  }
  
  #dlg-footer{
  
  background-color:#f2f2f2;
  
  text-align:right;
  padding:10px;
  margin:0px 10px 10px 10px;
  
  }
  
  
  #dlg-footer button{
  
  background-color:#6d84b4;
  color:white;
  
  padding:5px;
  border:0px;
  
  }


</style>
</head>
<body>

    <!-- dialog box -->
    
    <div id="white-background">
    
    
    </div>
    
    
    <div id="dlgbox">
    
      <div id="dlg-header">You are logget out.</div>
      
      <div id="dlg-body">Kindly log in to continue.</div>
      
      <div id="dlg-footer">
      
         <button onClick="dlgLogin()"> Log in</button>
      
      </div>
    
    
    </div >
    
    <!-- rest of the page -->
    
    <h1>Dialog Box Demo</h1>
    <p>This is a dialog box example.</p>
    <p>Feel free to experiment with the code.</p>
    <p>Click the button below to see the dialog box.</p>
    <button onClick="showDialog()">Click Me !</button>
    
    <!-- Script of dialog -->
    
    <script type="text/javascript">
    
       function dlgLogin(){
    	   
    	   var whitebg = document.getElementById("white-background");
    	   
    	   var dlg = document.getElementById("dlgbox");
    	   
    	   whitebg.style.display ="none";
    	   
    	   dlg.style.display ="none";
       }
       
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
    
    
    </script>

</body>
</html>