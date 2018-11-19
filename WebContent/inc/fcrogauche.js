
// Paramètres globaux

var params = {
	modes: ['selection','ligne','rectangle','ellipse'],
	id_mode: 0,
	line_color: 'black',
	line_width: 2,
	fill_color: 'white',
	line_type: 'Unie',
	fill_type: 'Sans',
	en_cours: false,
	start_point: [],
	objet_modif: {},
	selecteurs: [],
	box: {},
	objets_effaces: [],
	objet_copie: null,
	inhibe_selection: false
};

//Reset du dessin

function reset_dessin() {
	
	params.en_cours = false;
	params.id_mode = 0;
	$('canvas').css('cursor', 'default');
	$('#mode .active').removeClass('active');
	$('#mode .btn:first').addClass('active');	
}


$(function (){
	
	// Synchronisation des contrôles avec la shape sélectionnée
	function sync_controls() {
		// Largeur de ligne
		if(params.objet_modif.getStrokeWidth() != undefined) 
			$('#width').val(params.objet_modif.getStrokeWidth());
		// Couleur de ligne
		if(params.objet_modif.getStroke() != undefined) {
			$('#typeligne').val('Unie');
			$('#colorligne').val(params.objet_modif.getStroke());
			$('#couleurligne i').css('background-color', params.objet_modif.getStroke()); 
		    $('#couleurligne').removeClass('hide');
		    $('#widthline').removeClass('hide');
		}
		else {
			$('#typeligne').val('Sans');
		    $('#couleurligne').addClass('hide');
		    $('#widthline').addClass('hide');
		}
		// Couleur de remplissage
		if(params.objet_modif.getFill() != undefined) {
			$('#typefond').val('Uni');
			$('#couleurfond').removeClass('hide');
			$('#colorremplissage').val(params.objet_modif.getFill());
			$('#couleurfond i').css('background-color', params.objet_modif.getFill());
		}
		else {
			$('#couleurfond').addClass('hide');	
			$('#typefond').val('Sans');	
		}
	}
	
	// Test de shape sélectionnée
	function test_select() {
		return params.modes[params.id_mode] == 'selection' && calque_top.getChildren().length;	
	}
	
	// Sélection d'un objet
	function select_object() {
		if(params.objet_modif.shapeType == "Line") {
			var points = params.objet_modif.getPoints();
			var pos = params.objet_modif.getPosition();
			params.selecteurs = [];
			params.selecteurs.push(build_selector(points[0].x + pos.x, points[0].y + pos.y));
			params.selecteurs.push(build_selector(points[1].x + pos.x, points[1].y + pos.y));
		}
		if(params.objet_modif.shapeType == "Rect") {
			var x = params.objet_modif.getX();
			var y = params.objet_modif.getY();
			var width = params.objet_modif.getWidth();
			var height = params.objet_modif.getHeight();
			params.selecteurs = [];
			params.selecteurs.push(build_selector(x, y));
			params.selecteurs.push(build_selector(x + width, y + height));
		}
		if(params.objet_modif.shapeType == "Ellipse") {
			var x = params.objet_modif.getX();
			var y = params.objet_modif.getY();
			var radius = params.objet_modif.getRadius();
			params.selecteurs = [];
			params.box = build_box(x - radius.x, y - radius.y, x + radius.x, y + radius.y);
			params.selecteurs.push(build_selector(x - radius.x, y - radius.y));
			params.selecteurs.push(build_selector(x + radius.x, y + radius.y));
		}
		$('canvas').css('cursor', 'default');
	}
	
	// Suppression d'un objet
	function del_object() {
		if(test_select()) {
			params.objets_effaces.push(params.objet_modif);
			calque_bottom.remove(params.objet_modif);
			calque_bottom.draw();
			reset_dessin();	
			calque_top.removeChildren();
			calque_top.draw();
		}	
	}
	
	// Annuler dernière création d'objet
	function annuler_objet() {
		reset_dessin();	
		calque_top.removeChildren();
		calque_top.draw();	
		var shapes = calque_bottom.getChildren();
		if(shapes.length) {
			params.objets_effaces.push(shapes[shapes.length - 1]);
			calque_bottom.remove(shapes[shapes.length - 1]);
			calque_bottom.draw();
		}
	}
	
	// Répéter dernière création d'objet
	function repete_objet() {
		if(params.objets_effaces.length) {
			reset_dessin();	
			calque_top.removeChildren();
			calque_top.draw();
			params.objet_modif = {};	
			//calque_bottom.add(params.objets_effaces.pop().clone());
			var shape = params.objets_effaces.pop();
			calque_bottom.add(shape);
			// Nécessaire pour retrouver la détection
			Kinetic.Global.shapes[shape.colorKey] = shape;
			calque_bottom.draw();	
		}
	}

	// Création des sélecteurs
	function build_selector(x, y) {
		var selector = new Kinetic.Circle({
			x: x,
			y: y,
			radius: 5,
			stroke: "#666",
			fill: "#ddd",
			strokeWidth: 2,
			draggable: true,
			name: 'selector'
		});
		
		selector.on("mouseover", function() {
			$('canvas').css('cursor', 'pointer');
			this.setOpacity(.1);
			inhibe_selection = true;
			calque_top.draw();
		});
		selector.on("mouseout", function() {
			$('canvas').css('cursor', 'default');
			this.setOpacity(1);
			inhibe_selection = false;
			calque_top.draw();
		});
		
		calque_top.add(selector);
		return selector;
	}
	
	// Création du cadre en pointillés
	function build_box(x1, y1, x2, y2) {
		var box = new Kinetic.Line({
			points: [x1, y1, x2 , y1, x2, y2, x1, y2, x1, y1],
			dashArray: [5, 5],
			strokeWidth: 1,
			stroke: "#666",
			lineCap: "round",
			id: "box",
			opacity: 0.6
		});	
		calque_top.add(box);
		return box;
	}
	
	// Initialisations
	$('#colorligne').val(params.line_color);
	$('#width').val(params.line_width);
	$('#typeligne').val(params.line_type);
	$('#typefond').val(params.fill_type);
	$('#couleurfond').val(params.fill_color);	
	$('#colorremplissage').val(params.fill_color);
	
	// Fonctionnement du tooltip
	$('.btn').tooltip({placement:'left'});
	// Fonctionnement des colorpicker
   	$('.color').colorpicker();
	
	// Largeur de ligne
	$('#width').change(function() {
  		params.line_width = $(this).val();
		if(test_select() && params.objet_modif.getStrokeWidth() != 'undefined') {
			params.objet_modif.setStrokeWidth(params.line_width);
			calque_bottom.draw();
		}
	});
	
	// Couleur de ligne
	$('#couleurligne').colorpicker().on('changeColor', function(e){
		params.line_color = e.color.toHex();
		if(test_select() && params.objet_modif.getStroke() != 'undefined') {
			params.objet_modif.setStroke(params.line_color);
			calque_bottom.draw();
		}
	});
	
	// Changement type de ligne
    $('#typeligne').change(function () {
	  params.line_type = $('#typeligne option:selected').val() == 'Unie';
	  if(params.line_type) {
		  $('#couleurligne').removeClass('hide');
		  $('#widthline').removeClass('hide');
		  params.objet_modif.setStrokeWidth($('#width').val());
		  params.objet_modif.setStroke($('#colorligne').val());
	  }
	  else {
		  $('#couleurligne').addClass('hide');
		  $('#widthline').addClass('hide');
		  delete params.objet_modif.attrs.stroke;
		  delete params.objet_modif.attrs.strokeWidth;
	  }
	  calque_bottom.draw();
	})
	
	// Couleur de remplissage
	$('#couleurfond').colorpicker().on('changeColor', function(e){
		params.fill_color = e.color.toHex();
		if(test_select()) {
			params.objet_modif.setFill(params.fill_color);
			calque_bottom.draw();
		}	
	});
	
	// Changement type de remplissage
    $('#typefond').change(function () {
	  params.fill_type = $('#typefond option:selected').val() == 'Uni';
	  if(params.fill_type) {
		  $('#couleurfond').removeClass('hide');
		  params.objet_modif.setFill($('#colorremplissage').val());
	  }
	  else {
		  $('#couleurfond').addClass('hide');
		  delete params.objet_modif.attrs.fill;
	  }
	  calque_bottom.draw();
	})
	
	var sectiongauche = document.getElementById('sectiondessingauche');

                                 var sectiongauche_largeur = getComputedStyle(sectiongauche,null).width || sectiongauche.currentStyle.width;

                                 var sectiongauche_hauteur = getComputedStyle(sectiongauche,null).height || sectiongauche.currentStyle.height;


                                 // Création de la scène

                                 var scène = new Kinetic.Stage({
                                   container: "kineticdessin",
                                   width: 400,
                                   height: 400
                                 });

                                 //Création des calques
                                 var calque_top = new Kinetic.Layer();
                                 var calque_bottom = new Kinetic.Layer();
                                 

                                 // Ajout des calques à la scène
                                 
                                 scène.add(calque_bottom);
                                 scène.add(calque_top);
                                 
                                 

	// Actualisation en mode Sélection
	calque_top.afterDraw(function() {
		if(params.modes[params.id_mode] == 'selection' && inhibe_selection) {
			var pos1 = params.selecteurs[0].getPosition();
			var pos2 = params.selecteurs[1].getPosition();
			if(params.objet_modif.shapeType == "Line") {
				var pos_line = params.objet_modif.getPosition();
				params.objet_modif.setPoints([pos1.x - pos_line.x, pos1.y - pos_line.y, pos2.x - pos_line.x, pos2.y - pos_line.y]);
			}
			else if(params.objet_modif.shapeType == "Rect") {
				params.objet_modif.setPosition(pos1);
				params.objet_modif.setWidth(pos2.x - pos1.x);
				params.objet_modif.setHeight(pos2.y - pos1.y);
			}
			else if(params.objet_modif.shapeType == "Ellipse") {
				params.objet_modif.setRadius({
					x: Math.abs(pos1.x - pos2.x) / 2,
					y: Math.abs(pos1.y - pos2.y) / 2
				});
				params.objet_modif.setPosition({
					x: pos1.x + (pos2.x - pos1.x) / 2,
					y: pos1.y + (pos2.y - pos1.y) / 2
				});
				params.box.setPoints([
					pos1.x, pos1.y,
					pos2.x, pos1.y,
					pos2.x, pos2.y,
					pos1.x, pos2.y,
					pos1.x, pos1.y
				]);
			}
			calque_bottom.draw();
		}
	});

	// Evénement sur les boutons de mode
    $('#mode .btn').click(function() {
		params.id_mode = $('#mode .btn').index(this);
		// Si un mode dessin on change le curseur et on reset la sélection
		if(params.id_mode) {
			$('canvas').css('cursor', 'crosshair');
			params.en_cours = false;
			params.objet_modif.setDraggable(false);
			params.objet_modif = {};
			calque_top.removeChildren();
			calque_top.draw();
		}
		else $('canvas').css('cursor', 'default');
    });
	
	// Evénements de souris sur le canvas
	$('canvas')
	.mousedown(function(e){
		// Si mode sélection
		if(params.modes[params.id_mode] == 'selection') {
			if(!inhibe_selection) {
				var offset = $('.kineticjs-content').offset();
				var p = [e.pageX - offset.left, e.pageY - offset.top];
				var shapes = scène.getIntersections(p);
				if(shapes.length && shapes[0].getLayer() != calque_top && shapes[0] != params.objet_modif) {
					calque_top.removeChildren();
					shapes[0].setDraggable(true);
					params.objet_modif = shapes[0];
					select_object();
					sync_controls();
					calque_top.draw();
				}
			}
		}
		// Si mode dessin
		else {
			// Position de la souris
			var offset = $('.kineticjs-content').offset();
			var x = e.pageX - offset.left;
			var y = e.pageY - offset.top;
			// Mémorisation de la position
			params.start_point = [x, y];
			params.en_cours = true;
		}
    })
	.mousemove(function(e){
		// Si mode sélection
		if(params.modes[params.id_mode] == 'selection') {
			var offset = $('.kineticjs-content').offset();
			var p = [e.pageX - offset.left, e.pageY - offset.top];
			var shapes = scène.getIntersections(p);
			if(shapes.length) $('canvas').css('cursor', 'pointer');
			else $('canvas').css('cursor', 'default');			
		}
		// Si mode dessin
		else if(params.en_cours) {
			// Position de la souris
			var offset = $('.kineticjs-content').offset();
			var x = e.pageX - offset.left;
			var y = e.pageY - offset.top;
			// Shape en cours
			var shapes = calque_top.getChildren();
			// Cas de la ligne
			if(params.modes[params.id_mode] == 'ligne') {
				// Ligne déjà créée
				if(shapes.length) {
					shapes[0].setPoints(params.start_point.concat([x, y]));
				}
				// Création de la ligne
				else {
					var ligne = new Kinetic.Line({
						points: params.start_point.concat([x, y]),
						stroke: params.line_color,
						strokeWidth: params.line_width
					});		
					calque_top.add(ligne);
				}
			}
			// Cas du rectangle
			else if(params.modes[params.id_mode] == 'rectangle') {
				// Rectangle déjà créé
				if(shapes.length) {
					shapes[0].setWidth(x - params.start_point[0]);
					shapes[0].setHeight(y - params.start_point[1]);
				}
				// Création du rectangle	
				else {
					var rectangle = new Kinetic.Rect({
						x: params.start_point[0],
						y: params.start_point[1],
						width: x - params.start_point[0],
						height: y - params.start_point[1],
					});	
					if($('#typefond option:selected').val() == 'Uni') 
						rectangle.setFill(params.fill_color);
					if($('#typeligne option:selected').val() == 'Unie') {
						rectangle.setStroke(params.line_color);
						rectangle.setStrokeWidth(params.line_width);
					}
					calque_top.add(rectangle);
				}
			}
			// Cas de l'ellipse
			else if(params.modes[params.id_mode] == 'ellipse') {
				// Ellipse déjà créée
				if(shapes.length) {
					shapes[0].setRadius({
						x: Math.abs(x - params.start_point[0]),
						y: Math.abs(y - params.start_point[1])
					});						
				}
				// Création de l'ellipse	
				else {
					var ellipse = new Kinetic.Ellipse({
						x: params.start_point[0],
						y: params.start_point[1],
						radius: {
							x: Math.abs(x - params.start_point[0]),
							y: Math.abs(y - params.start_point[1])
						}
					});	
					if($('#typefond option:selected').val() == 'Uni') 
						ellipse.setFill(params.fill_color);
					if($('#typeligne option:selected').val() == 'Unie') {
						ellipse.setStroke(params.line_color);
						ellipse.setStrokeWidth(params.line_width);
					}
					calque_top.add(ellipse);
				}
			}
			calque_top.draw();
		}		
    })
	.mouseup(function(e){
		// Dessin effectif
		if(params.modes[params.id_mode] != 'selection' && params.en_cours) {
			// Tansfert sur calque inférieur
			params.objet_modif = calque_top.getChildren()[0];
			params.objet_modif.moveTo(calque_bottom);
			params.objet_modif.setDraggable(true);
			calque_bottom.draw();
			// Mise en place événements de drag
			params.objet_modif.on("dragstart", function() {
				calque_top.removeChildren();
				calque_top.draw();
			});
			params.objet_modif.on("dragend", function() {
				select_object();
				calque_top.draw();
			});
			select_object();
			calque_top.draw();	
			reset_dessin();
		}
    });
	
	// Annulation sur escape, ou destruction sur del
	$(document).keydown(function(e) {
		// Annulation
		if(e.keyCode == 27) {
			if(params.modes[params.id_mode] == 'selection' || params.en_cours) {
				reset_dessin();	
				params.objet_modif = {};
				calque_top.removeChildren();
				calque_top.draw();		
			}
		}
		// Delete
		else if(e.keyCode == 46) del_object();
    });
	
	// Evénement sur les boutons d'édition
    $('#edition .btn').click(function() {
		// Annuler
		if($('#edition .btn').index(this) == 0) annuler_objet();
		// Répéter
		else if($('#edition .btn').index(this) == 1) repete_objet()
		// Copier
		else if($('#edition .btn').index(this) == 2) 
			params.objet_copie = params.objet_modif.clone();
		// Coller
		else if($('#edition .btn').index(this) == 3) {
			if(params.objet_copie != null) {
				calque_bottom.add(params.objet_copie.clone());
				calque_bottom.draw();	
			}
		}
		// Supprimer
		else if($('#edition .btn').index(this) == 4) del_object();
    });
	
	// Evénement dans le menu
    $('#nouveau').click(function() {$('#modal_new').modal();});
    
    
    $('#go_front').click(function() {
		if(test_select()) {
			params.objet_modif.moveToTop();
			calque_bottom.draw();
		}
    });
    $('#go_back').click(function() {
		if(test_select()) {
			params.objet_modif.moveToBottom();
			calque_bottom.draw();
		}
    });
    $('#go_up').click(function() {
		if(test_select()) {
			params.objet_modif.moveUp();
			calque_bottom.draw();
		}
    });
    $('#go_down').click(function() {
		if(test_select()){ 
			params.objet_modif.moveDown();
			calque_bottom.draw();
		}
    });
    $('#annuler').click(function() {annuler_objet();});
    $('#repeter').click(function() {repete_objet();});
    $('#supprimer').click(function() {del_object();});
    $('#copier').click(function() {params.objet_copie = params.objet_modif.clone();});
    $('#coller').click(function() {
		if(params.objet_copie != null) {
			calque_bottom.add(params.objet_copie.clone());
			calque_bottom.draw();	
		}
    });
		
	// Nouveau dessin
    $('#nouveaucanvas').click(function() {
		params.objets_effaces = [];
		calque_top.removeChildren();
		calque_top.draw();
		calque_bottom.removeChildren();
		calque_bottom.draw();
    });
	
});




