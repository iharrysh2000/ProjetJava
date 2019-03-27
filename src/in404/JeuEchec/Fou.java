package in404.JeuEchec;

public class Fou extends Piece {
    //mettre dans classe mere
    private Point p;
    private String couleur;
    private String name;
    //

    public Fou(Point p,String couleur,String name){
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

    public boolean movePossible(Point pointPosition,Point pointTarget){
        if(Math.abs(pointPosition.getX()-pointTarget.getX()) == Math.abs(pointPosition.getY()-pointTarget.getY())){
            return true;
        }
        return false;
    }
}
