# PROJET CONCEPTION ET PROGRAMMATION ORIENTÉE-OBJET

Réalisé par BOUTON Nicolas, DEDARALLY Taariq et TRINH Gia Tâm

Le projet consiste à créer un jeu d'échec en JAVA.

# Manuel utilisateur

Le joueur humain commence en 1er.

Pour faire avancer une pièce, il suffit d'indiquer la position actuelle de la pièce et la position d'arrivée pour la faire avancer. <br />
Attention, la pièce n'avance que si le jeton respecte toutes les conditions de mouvements liées à elle.
 
Exemple : si mon pion est à la position a2 et que je veux le déplacer en a3, on doit taper "a2a3".

La partie se termine quand ?????????. <br />
Bonne chance !

# Manuel technique

La classe Pièce est décomposée en plusieurs sous-classes représentant chacunes un type de pièce et contiennent tous une méthode de déplacement spécifique. <br />
Elles sont liées à un joueur en fonction de leur couleur.

Chaque jeton étant placé sur une case, la classe Case est nécessaire pour les associer.<br />
Ces cases composent le terrain de jeu à travers la classe Plateau qui initialise la poition de départ de chaque 
pièce et verifie si les déplacements sont valides pour les effectuer afin d'afficher le jeu 
(attention, il ne s'agit pas de Xboard mais simplement de la combinaison de Systeme.out.print() pour simuler l'apparence du plateau et des pièces).

La classe IO est présente pour pouvoir prendre en entrée les commandes du joueur. <br />
Et justement, la classe Joueur que j'ai pas encore fait vient déterminer si c'est au tour de l'humain de jouer. Dans le cas contraire, l'ordinateur effectue une action au hasard.
