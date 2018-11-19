# *************************************
# * Une MakeFile pour compiler SI_VOX *
# *************************************
#
# Institut    : Ecole Polytechnique Universitaire de Nice Sophia Antipolis
# Auteur      : mosser@essi.fr
# Compilateur : javac 1.5
# Date        : 7 juillet 2005

# Utilisation : 
#  Depuis le repertoire src : 
#    make         : construit les classes éxécutables
#    make clean   : efface les fichiers de sauvegardes ~
#    make clobber : efface les fichiers de sauvegarde et les .class 
#    make jar     : fabrique l'archive auto éxécutable jar
#    make javadoc : exécute la commande pour fabriquer la documentation ad'hoc

# Options de compilation : 
#   -nowarn : pour retirer les warnings du à la non utilisation de la 
#             généricité désormais fournie avec java 1.5
options=-nowarn

# Emplacement des différents compilateurs (a modifier selon ...) : 
java2=/opt/jdk1.4.2/bin/javac
java5=javac

# Selection du compilateur voulu : 
javac=$(java5)

# +-----------------------------------------+
# | Ne pas editer en dessous de cette ligne |
# +-----------------------------------------+
.SUFFIXES: .java .class

# Les chemins d'accès : 

# Pour les sources : 
src=.
t2s_src= $(src)/t2s
ihm_src= $(t2s_src)/ihm
prosodie_src= $(t2s_src)/prosodie
son_src= $(t2s_src)/son
traitement_src= $(t2s_src)/traitement
util_src= $(t2s_src)/util

# Pour les binaires : 
bin=../bin
t2s_bin= $(bin)/t2s
ihm_bin= $(t2s_bin)/ihm
prosodie_bin= $(t2s_bin)/prosodie
son_bin= $(t2s_bin)/son
traitement_bin= $(t2s_bin)/traitement
util_bin= $(t2s_bin)/util

# Pour l'archive éxécutable :
manifest= manifest.mf
jar_file= SI_VOX.jar

# Définition des packages : 

util_pkg= $(util_bin)/ConfigFile.class $(util_bin)/Indice.class $(util_bin)/LecteurFichier.class $(util_bin)/Random.class $(util_bin)/StaticCounter.class $(util_bin)/SuiteCroissante.class


traitement_pkg= $(traitement_bin)/RegleException.class $(traitement_bin)/AnalyseException.class  $(traitement_bin)/Regle.class $(traitement_bin)/GenerateurPreposition.class $(traitement_bin)/GenerateurRegle.class $(traitement_bin)/ListeRegles.class $(traitement_bin)/Phrase.class $(traitement_bin)/PlusDePhraseException.class $(traitement_bin)/Pretraitement.class $(traitement_bin)/Arbre.class

prosodie_pkg= $(prosodie_bin)/Syntagme.class $(prosodie_bin)/CoupleProsodie.class $(prosodie_bin)/Phoneme.class $(prosodie_bin)/Courbe.class $(prosodie_bin)/ListePhonemes.class  

son_pkg= $(son_bin)/JukeBox.class $(son_bin)/SynthetiseurMbrola.class $(son_bin)/LecteurTexte.class  

ihm_pkg= $(ihm_bin)/Cadre_AboutBox.class $(ihm_bin)/Cadre.class $(ihm_bin)/Lecture.class $(ihm_bin)/ParleThread.class

main_pkg=$(t2s_bin)/Main.class 

# La directive par défaut : 
all: main

# Directives pour se faciliter la vie : 
clobber:
	rm -rvf $(bin)/*
	rm -rvf $(src)/*~ $(t2s_src)/*~ $(util_src)/*~ $(traitement_src)/*~ $(prosodie_src)/*~ $(son_src)/*~ $(ihm_src)/*~

clean:
	rm -rvf $(src)/*~ $(t2s_src)/*~ $(util_src)/*~ $(traitement_src)/*~ $(prosodie_src)/*~ $(son_src)/*~ $(ihm_src)/*~

jar: all
	cd $(bin); jar cmf ../src/$(manifest) ../$(jar_file) *
	ls -lh ../$(jar_file)

javadoc:
	javadoc -locale "fr_FR" -charset "iso-8859-15" -d ../javadoc t2s t2s.son t2s.ihm t2s.prosodie t2s.traitement t2s.util


# Directives de compilations : 

main: ihm $(main_pkg)

$(main_pkg): $(t2s_bin)/%.class: $(t2s_src)/%.java
	$(javac) $(options) -classpath $(bin) -d $(bin) $<

util: $(util_pkg)	

$(util_pkg): $(util_bin)/%.class: $(util_src)/%.java
	$(javac) $(options) -classpath $(bin) -d $(bin) $<

traitement: util $(traitement_pkg)

$(traitement_pkg): $(traitement_bin)/%.class: $(traitement_src)/%.java
	$(javac) $(options) -classpath $(bin) -d $(bin) $<

prosodie: traitement $(prosodie_pkg)

$(prosodie_pkg): $(prosodie_bin)/%.class: $(prosodie_src)/%.java
	$(javac) $(options) -classpath $(bin) -d $(bin) $<

son: prosodie $(son_pkg)

$(son_pkg): $(son_bin)/%.class: $(son_src)/%.java
	$(javac) $(options) -classpath $(bin) -d $(bin) $<

ihm: son $(ihm_pkg)

$(ihm_pkg): $(ihm_bin)/%.class: $(ihm_src)/%.java
	$(javac) $(options) -classpath $(bin) -d $(bin) $<