package in404.JeuEchec;

public class Reine extends Piece {

    private Point p;
    private String couleur;
    private String name;

    public Reine(Point p,String couleur,String name){
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
    @Override
    public boolean movePossible(Point pointPosition,Point pointTarget){
        if((pointPosition.getX() == pointTarget.getX() || pointPosition.getY() == pointTarget.getY()) || Math.abs(pointPosition.getX()-pointTarget.getX()) == Math.abs(pointPosition.getY()-pointTarget.getY())){
            return true;
        }
        return false;
    }
}
