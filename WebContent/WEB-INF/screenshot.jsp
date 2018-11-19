<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/inc/bootstrap/css/bootstrap.css"/>"
	rel="stylesheet" />
<title> Take Web Page Screenshot with HTML5 and JavaScript  </title>
</head>


<body>

          <a class="btn btn-success" href="javascript:void(0);" onclick="generate();">Generate  
        Screenshot »</a>  
        
        <!-- 
        
        http://www.xpertdeveloper.com/2012/10/webpage-screenshot-with-html5-js/
        
        http://www.c-sharpcorner.com/UploadFile/65794e/generate-screenshot-using-html-and-javascript/
        
         -->
        
        <script type="text/javascript">
        
        (function (exports) {  
            function urlsToAbsolute(nodeList) {  
                if (!nodeList.length) {  
                    return [];  
                }  
                var attrName = 'href';  
                if (nodeList[0].__proto__ === HTMLImageElement.prototype || nodeList[0].__proto__ === HTMLScriptElement.prototype) {  
                    attrName = 'src';  
                }  
                nodeList = [].map.call(nodeList, function (el, i) {  
                    var attr = el.getAttribute(attrName);  
                    if (!attr) {  
                        return;  
                    }  
                    var absURL = /^(https?|data):/i.test(attr);  
                    if (absURL) {  
                        return el;  
                    } else {  
                        return el;  
                    }  
                });  
                return nodeList;  
            }  
  
            function screenshotPage() {  
                urlsToAbsolute(document.images);  
                urlsToAbsolute(document.querySelectorAll("link[rel='stylesheet']"));  
                var screenshot = document.documentElement.cloneNode(true);  
                var b = document.createElement('base');  
                b.href = document.location.protocol + '//' + location.host;  
                var head = screenshot.querySelector('head');  
                head.insertBefore(b, head.firstChild);  
                screenshot.style.pointerEvents = 'none';  
                screenshot.style.overflow = 'hidden';  
                screenshot.style.webkitUserSelect = 'none';  
                screenshot.style.mozUserSelect = 'none';  
                screenshot.style.msUserSelect = 'none';  
                screenshot.style.oUserSelect = 'none';  
                screenshot.style.userSelect = 'none';  
                screenshot.dataset.scrollX = window.scrollX;  
                screenshot.dataset.scrollY = window.scrollY;  
                var script = document.createElement('script');  
                script.textContent = '(' + addOnPageLoad_.toString() + ')();';  
                screenshot.querySelector('body').appendChild(script);  
                var blob = new Blob([screenshot.outerHTML], {  
                    type: 'text/html'  
                });  
                return blob;  
            }  
  
            function addOnPageLoad_() {  
                window.addEventListener('DOMContentLoaded', function (e) {  
                    var scrollX = document.documentElement.dataset.scrollX || 0;  
                    var scrollY = document.documentElement.dataset.scrollY || 0;  
                    window.scrollTo(scrollX, scrollY);  
                });  
            }  
  
            function generate() {  
                window.URL = window.URL || window.webkitURL;  
                window.open(window.URL.createObjectURL(screenshotPage()));  
            }  
            exports.screenshotPage = screenshotPage;  
            exports.generate = generate;  
        })(window);
        
        </script>
        
        
        
        <script src="<c:url value="/inc/bootstrap/js/bootstrap.js"/>"></script>

</body>

</html>