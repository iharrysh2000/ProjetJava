package in404.JeuEchec;

public class Cavalier extends Piece {

    private Point p;
    private String couleur;
    private String name;

    public Cavalier(Point p,String couleur,String name){
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
        if(((pointPosition.getX() +  1 == pointTarget.getX()) && (pointPosition.getY() + 2 == pointTarget.getY())) || ((pointPosition.getX() + 2 == pointTarget.getX()) && (pointPosition.getY() +1 == pointTarget.getY()))){
            return true;
        }
        return false;
    }
}
