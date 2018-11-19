<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>ESSAI TAILLE FENETRE</title>

<style type="text/css">




</style>


</head>

<body>




<script type="text/javascript">

<!-- Debut
//JavaScript pris sur le site: "http://www.java.scripts-fr.com"
if (document.body)
{
var larg = (document.body.clientWidth);
var haut = (document.body.clientHeight);
}

/*
Ici une version DOM (le script est entre les balises <body> et </body>) qui devrait fonctionner sur tous les navigateurs.
On commence donc par détecter la présence de l'objet body dans le DOM.
Si il est présent, on va mettre dans 2 variables larg et haut la largeur et la hauteur de la fenêtre pris avec les propriétés clientWidth et clientHeight de l'objet body.
*/

else
{
var larg = (window.innerWidth);
var haut = (window.innerHeight);
}
/*
Cette version est purement javascript et ne fonctionne pas sous IE (les propriétés innerWidth et innerHeight de l'objet window n'ayant pas été intégrée dans ce navigateur).
Si l'objet n'existe pas, on met dans nos variables la hauteur et la largeur de la page. Seulement on utilisera ici les propriété innerWidth et innerHeight de l'objet window.
*/

document.write("Cette fenêtre fait " + larg + " de large et "+haut+" de haut");

//ensuite on en fait ce que l'on veut, la je les écrit avec la méthode write
//de l'objet document

//fin du script -->

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

document.write("Cette fenêtre fait " + larg + " de large et "+haut+" de haut");

if(larg<768){
	
	
	
	
}

if(larg >= 768 && larg<992){
	
	
	
	
	
	
}

if(larg >= 992 && larg<1200){
	
	
	
	
	
	
}

if(larg >= 1200 ){
	
	
	
	
	
	
}


</script>



<script src="<c:url value="/inc/teste.js"/>"></script>
</body>

</html>