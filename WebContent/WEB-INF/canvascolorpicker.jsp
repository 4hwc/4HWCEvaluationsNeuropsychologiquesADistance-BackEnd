<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>CANVAS COLOR PICKER</title>

<style type="text/css">

body {
        margin: 0px;
        padding: 0px;
      }

</style>


</head>

<body>

<canvas id="myCanvas" width="578" height="276"></canvas>
    <script>
      function getMousePos(canvas, evt) {
        var rect = canvas.getBoundingClientRect();
        return {
          x: evt.clientX - rect.left,
          y: evt.clientY - rect.top
        };
      }
      function drawColorSquare(canvas, color, imageObj) {
        var colorSquareSize = 100;
        var padding = 10;
        var context = canvas.getContext('2d');
        var squareX = (canvas.width - colorSquareSize + imageObj.width) / 2;
        var squareY = (canvas.height - colorSquareSize) / 2;

        context.beginPath();
        context.fillStyle = color;
        context.fillRect(squareX, squareY, colorSquareSize, colorSquareSize);
        context.strokeRect(squareX, squareY, colorSquareSize, colorSquareSize);
      }
      function init(imageObj) {
        var padding = 10;
        var canvas = document.getElementById('myCanvas');
        var context = canvas.getContext('2d');
        var mouseDown = false;
        
        context.strokeStyle = '#444';
        context.lineWidth = 2;

        canvas.addEventListener('mousedown', function() {
          mouseDown = true;
        }, false);

        canvas.addEventListener('mouseup', function() {
          mouseDown = false;
        }, false);

        canvas.addEventListener('mousemove', function(evt) {
          var mousePos = getMousePos(canvas, evt);
          var color = undefined;

          if(mouseDown && mousePos !== null && mousePos.x > padding && mousePos.x < padding + imageObj.width && mousePos.y > padding && mousePos.y < padding + imageObj.height) {

            // color picker image is 256x256 and is offset by 10px
            // from top and bottom
            var imageData = context.getImageData(padding, padding, imageObj.width, imageObj.width);
            var data = imageData.data;
            var x = mousePos.x - padding;
            var y = mousePos.y - padding;
            var red = data[((imageObj.width * y) + x) * 4];
            var green = data[((imageObj.width * y) + x) * 4 + 1];
            var blue = data[((imageObj.width * y) + x) * 4 + 2];
            var color = 'rgb(' + red + ',' + green + ',' + blue + ')';
            drawColorSquare(canvas, color, imageObj);
          }
        }, false);

        context.drawImage(imageObj, padding, padding);
        drawColorSquare(canvas, 'white', imageObj);
      }
      var imageObj = new Image();
      imageObj.onload = function() {
        init(this);
      };
      imageObj.src = 'http://www.html5canvastutorials.com/demos/assets/color-picker.png';
      </script>


</body>

</html>