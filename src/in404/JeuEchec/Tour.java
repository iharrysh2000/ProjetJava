package in404.JeuEchec;

public class Tour extends Piece {

    private Point p;
    private String couleur;
    private String name;

    public Tour(Point p,String couleur,String name){
        this.p = p;
        this.couleur = couleur;
        this.name = name;
    }

    public Point getPosition(){
        return p;
    }

    public String getCouleur(){
        return couleur;
    }

    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
    public boolean movePossible(Point pointPosition,Point pointTarget) {
        if(pointPosition.getX() == pointTarget.getX() || pointPosition.getY() == pointTarget.getY()){
            return true;
        }
        return false;
    }
}
