/**
 * 
 */

////////////////////////////////////////


var canvas, ctx, flag = false,prevX = 0,currX = 0,prevY = 0,currY = 0,dot_flag = false;
                                                
                                                
                                                var x = "black",y = 2;
                                                
                                            
                                            canvas = document.getElementById('canvasfcromg');
                                            ctx = canvas.getContext("2d");
                                           var w = canvas.width;
                                           var  h = canvas.height;
                                           
                                           function draw() {
                                               ctx.beginPath();
                                               ctx.moveTo(prevX, prevY);
                                               ctx.lineTo(currX, currY);
                                               ctx.strokeStyle = x;
                                               ctx.lineWidth = y;
                                               ctx.stroke();
                                               ctx.closePath();
                                           }
                                           
                                           function findxy(res, e) {
                                               if (res == 'down') {
                                                   prevX = currX;
                                                   prevY = currY;
                                                   currX = e.clientX - canvas.offsetLeft;
                                                   currY = e.clientY - canvas.offsetTop;
                                           
                                                   flag = true;
                                                   dot_flag = true;
                                                   if (dot_flag) {
                                                       ctx.beginPath();
                                                       ctx.fillStyle = x;
                                                       ctx.fillRect(currX, currY, 2, 2);
                                                       ctx.closePath();
                                                       dot_flag = false;
                                                   }
                                               }
                                               if (res == 'up' || res == "out") {
                                                   flag = false;
                                               }
                                               if (res == 'move') {
                                                   if (flag) {
                                                       prevX = currX;
                                                       prevY = currY;
                                                       currX = e.clientX - canvas.offsetLeft;
                                                       currY = e.clientY - canvas.offsetTop;
                                                       draw();
                                                   }
                                                   
                                               }
                                           }

                                            
                                            $('#canvasfcromg').mousedown(function(e){
                                            	
                                            	$('#canvasfcromg').css('cursor', 'crosshair');
                                            	
                                            	canvas.addEventListener("mousedown", function (e) {
                                                    findxy('down', e)
                                                }, false);
                                            	
                                            	  
                                            	});
                                            
                                            $('#canvasfcromg').mousemove(function(e){
                                            	
                                            	$('#canvasfcromg').css('cursor', 'crosshair');
                                            	
                                            	canvas.addEventListener("mousemove", function (e) {
                                                    findxy('move', e)
                                                }, false);
                                            	  
                                            	});
                                            
                                            $('#canvasfcromg').mouseup(function(e){
                                            	
                                            	canvas.addEventListener("mouseup", function (e) {
                                                    findxy('up', e)
                                                }, false);
                                            	  
                                            	});
                                            
                                            $('#canvasfcromg').mouseout(function(e){
                                            	
                                            	canvas.addEventListener("mouseout", function (e) {
                                                    findxy('out', e)
                                                }, false);
                                            	  
                                            	});
                                            
                                            
                                                
                                                


/////////////////////////

(function() {
    // Creates a new canvas element and appends it as a child
    // to the parent element, and returns the reference to
    // the newly created canvas element


    function createCanvas(parent, width, height) {
        var canvas = {};
        canvas.node = document.createElement('canvas');
        canvas.context = canvas.node.getContext('2d');
        canvas.node.width = width || 100;
        canvas.node.height = height || 100;
        parent.appendChild(canvas.node);
        return canvas;
    }

    function init(container, width, height, fillColor) {
        var canvas = createCanvas(container, width, height); //insérer ton canvas
        var ctx = canvas.context;
        // define a custom fillCircle method
        ctx.fillCircle = function(x, y, radius, fillColor) {
            this.fillStyle = fillColor;
            this.beginPath();
            this.moveTo(x, y);
            this.arc(x, y, radius, 0, Math.PI * 2, false);
            this.fill();
        };
        ctx.clearTo = function(fillColor) {
            ctx.fillStyle = fillColor;
            ctx.fillRect(0, 0, width, height);
        };
        ctx.clearTo(fillColor || "#ddd");

        // bind mouse events
        canvas.node.onmousemove = function(e) {
            if (!canvas.isDrawing) {
               return;
            }
            var x = e.pageX - this.offsetLeft;
            var y = e.pageY - this.offsetTop;
            var radius = 10; // or whatever
            var fillColor = '#ff0000';
            ctx.fillCircle(x, y, radius, fillColor);
        };
        canvas.node.onmousedown = function(e) {
            canvas.isDrawing = true;
        };
        canvas.node.onmouseup = function(e) {
            canvas.isDrawing = false;
        };
    }

    var container = document.getElementById('canvas');
    init(container, 200, 200, '#ddd');

})();


////////////


//Version fiddle améliorée

(function() {
    // Creates a new canvas element and appends it as a child
    // to the parent element, and returns the reference to
    // the newly created canvas element
    
   var canvasFCRO = document.getElementById('canvasfcromg');
    
    var prevX = 0,currX = 0,prevY = 0,currY = 0;


    function init(colorline) {
        var canvas = canvasFCRO; //insérer ton canvas
        var ctx = canvas.getContext("2d");
        // define a custom strokePath method
        ctx.strokePath = function(prevX,prevY,currX,currY, strokeColor) {
            this.strokeStyle = strokeColor;
            this.beginPath();
            this.moveTo(prevX, prevY);
            this.lineTo(currX,currY);
            
            //this.lineWidth = y;
            this.stroke();
        };
        

        // bind mouse events
        canvas.node.onmousemove = function(e) {
            if (!canvas.isDrawing) {
               return;
            }
            
            prevX = currX;
            prevY = currY;
            currX = e.clientX - this.offsetLeft;
            currY = e.clientY - this.offsetTop;
            
            
            
            var strokeColor = oolorline;
            ctx.strokePath(prevX,prevY,currX,currY, strokeColor);
        };
        canvas.node.onmousedown = function(e) {
            canvas.isDrawing = true;
        };
        canvas.node.onmouseup = function(e) {
            canvas.isDrawing = false;
        };
    }

    
    init('red');

})();



	
	
	
	
                                                	
                                                	
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                	
                                                    
                                                        
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                    
                                                	
                                                	
                                                	
                                               
                                                
                                                
                                                
                                                
                                                