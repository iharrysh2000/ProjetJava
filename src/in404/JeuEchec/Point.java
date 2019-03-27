package in404.JeuEchec;

public class Point {

    /** Point en abscisse **/
    private int x;

    /** Point en ordonées **/
    private int y;

    /**
     * Constructeur Point
     * @param x point en ordonnée
     * @param y point en abscisse
     */
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Donne en x
     * @return x Point en abscisse
     */
    public int getX() {
        return x;
    }

    /**
     * Donne y
     * @return y Point en ordonnée
     */
    public int getY() {
        return y;
    }

    /**
     * Redéfinition de la classe toString
     * Donne les coordonées d'une piece dans le plateau
     * @return les coordonées d'un piece en format String: coords_x : X coords_y Y.
     */
    @Override
    public String toString() {
        return " coords_x:" + x + " coords_y:" + y ;
    }
}
