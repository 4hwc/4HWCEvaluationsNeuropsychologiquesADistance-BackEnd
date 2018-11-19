package enad.projet;

/*
 * PLANIFICATION DEBUT PROGRAMMATION SAMEDI 26/06/2016
 * 
 * FIN PREVUE POUR 25/07
 * 
 * Réaliser le carnet de santé du patient pour permettre son suivi par plusieurs
 * médécins.
 * 
 * Permettre de télécharger le carnet sous forme de pdf
 * 
 * enregistrer l'audio de l'échange
 * 
 * Chaque patient a son méd traitant
 * 
 * prévoir des icônes pour chaque bouton
 * 
 * 
 * 5 ETAPES :
 * 
 * 1 le reste 26/06 - 03/07 2 Réaliser 5 tests 04/07 - 10/07 3 envoi temps réel
 * 11/07 - 17/07
 * 
 * 
 * 18/07 - 25/07
 *
 * 4 Tests de l'appli : jmeter; tests avec d'autres ordis 5publication internet
 * 
 * 
 * 26/07 : PUBLICATION OFFICIELLE SUR FACEBOOK
 * 
 * ETAPE 1
 * 
 * BEANS
 * 
 * Patient Medecin Commentaire Diagnostic Ehpad Resultat_test ajouter durée
 * Seance ajouter durée Test ajouter durée
 * 
 * Permettre à l'utilisateur d'accéder à une rubrique (HOME; Séances;Tests et
 * résultats;Commentaires;Diagnostics; Carnets de santé; Groupes;...)
 * 
 * Faire un journal des activités de chaque utilisateur par jour
 * 
 * Permettre de changer le thème de couleurs de l'application
 * 
 * Permettre de changer la voix de l'appli
 * 
 * permettre de changer la langue
 * 
 * 
 * Faire un test simple avec jsapi
 * 
 * 
 * Permettre aux meds d'ajouter des ehpad. Du coup, s'il n' y a pas d'ehpad, pas
 * de liste déroulante pour le patient (profil)
 */

/*
 * Après déconnexion, faire un bilan :
 * 
 * (vocale)
 * 
 * Prénoms + Noms, nous vous remercions d'avoir utilisé ENAD. Ci-dessous, un
 * bilan:
 * 
 * Heure de connexion:
 * 
 * Heure de déconnexion:
 * 
 * Durée:
 * 
 * 
 * Activités de la personne
 * 
 * Nous espérons vous revoir dans bientôt sur ENAD.
 * 
 * (préciser que la page se dirigera automatiquement dans par exple 10 min
 * (bref, le temps que l'utilisateur est le temps de lire le bilan) vers la page
 * med_pat))
 * 
 * (permettre que ce journal puisse être consultable à tout moment dans profil)
 * 
 * (permettre de télécharger le journal d'activités)
 * 
 * petit ppb, en cliquant sur deconnexion, je perds l'id, du coup pas possible
 * d'afficher
 * 
 * si, il suffit de mettre ça dans des variables dédiés uniquement pour la page
 * remerciements et le tour est joué ;)
 * 
 * des infos précises sur l'utilisateur. Du coup, je vais me contenter de
 * remercier l'utilisateur
 * 
 * et rediriger vers med_pat sachant qu'il a accès au journal dans son profil.
 * 
 * 
 * IPs
 * 
 * Récupérer les adresses IP de chaq utilisateur à la connexion et supprimer ces
 * adresses IP à la déconnexion
 * 
 * 
 * Créer compte administrateur à la fin (statistiques ; combien de personnes
 * utilisent l'appli à un moment donné ? ; nbre instantané de pers connectées
 * ...
 */
