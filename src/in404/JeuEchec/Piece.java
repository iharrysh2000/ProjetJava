package in404.JeuEchec;

public abstract class Piece {
    /**
     * Redefinition de méthode toString
     * @return le nom de chaque sous classe soit le Fou,Cavalier,Roi,Reine,Tour.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /** Les classes ci-dessous utilise le polymorphisme,car chaque Piece à sa propre méthode de déplacement, exemple le fou se déplace ne diagonal et la Cavalier en L. **/

    /**
     * Recherche c'est possble de mettre un point à cette case donner en argument selon la classe,car chaque classe à un déplacement qu'il lui est propre
     * @param pointPostion le point piece initiale
     * @param pointTarget le point cible
     */
    public abstract boolean movePossible(Point pointPostion,Point pointTarget);

    /**
     * Donne la position de la piece
     * @return la position de la piece
     */
    public abstract Point getPosition();
}
