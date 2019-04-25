# PROJET CONCEPTION ET PROGRAMMATION ORIENTÉE-OBJET

@Réalisé par BOUTON Nicolas, DEDARALLY Taariq et TRINH Gia Tâm

## 0. Introduction

L'objectif du projet consiste à créer un jeu d'échec en JAVA.

## 1. Manuel utilisateur
### 1.0 Contenu du projet
Le projet contients:

-> Un Makefile pour compiler le programme (make pour compiler et make run pour executer le main)

-> Le code sources contenant les .java et le Main (le code principal)

-> La sortie contenant les .class

-> La documentation (dossier doc) ou se trouve la Javadoc, la description de l'ensemble des classes

### 1.1 Instructions 
Le jeu est sous forme ascii.Après compilation et execution il faut décider si J1 et J2 seront des Joueurs ou des Ordinateur (respective H pour être joueur humain et O pour laisser l'ordinateur jouer).Et ensuite pour jouer il faut inscrire les coordonnées pour faire bouger les pièces du jeu. Pour quitter le jeu entrez "quit" et pour faire un retour en arrière entrez "undo".

# Manuel technique

## 1. Présentations général des classes
### 1.0 Gestion des entrées du clavier
Les entrées sorties sont gérées par la classe IO qui attend les données entrées par l'utilisateur.Si par inadvertance l'utilisateur entre des coordonnées qui dépasse le cadre du jeu ou qu'il choisi une case ou il y a pas de pièce alors il doit reécrire des coordonnées jusqu'à que ses coordonnées soient correcte.

### 1.1 Hiérachie des classes
Les classes Fou,Roi,Reine,Cavalier,Tour et Pion hérite de la classe abstraite Pion. En effet ces classes ont en commun les déplacements mais chaque Pièces ont un déplacements particulier, il faut donc les redéfinir.

### 1.2 Structure de données du plateau
Le plateau est une matrice 2 * 2 crée dans la classe Plateau.Elle contient des cases de types classe Case et chaque Case contient une couleur et une Piece. Si la case de contient rien alors cette case contient vide.

### 1.3 Ordinateur
On a deux types de joueurs possible, soit c'est l'utilisateur qui joue soit l'ordinateur. Le jeu de l'ordinateur consiste à placer déplacer des pièces du jeu de manière arbitraire.

### 1.4 Gestion du retour en arrière
Pour la gestion du retour en arrière on utilise le principe de pile, en sauvegardant les pièces déplacées et leurs coordonnées et en retirant de la pile les éléments sauvegarder en dernier. Le principe du retour arrière est géré dans la classe Undo.

### 1.4 Fin du jeu
La fin du jeu est marquer lorsque une des deux équipes est en situation d'échec et mat.

### 1.5 Gestion des erreurs
Certaines erreurs peuvent mener à un crash du jeu, par exemple si l'utilisateur oublie une lettre lors de la saisie des coordonnées.
