package projetJava;
import java.util.Stack;

public class Undo {

    private Stack<Point> pile_depart;
    
    private Stack<Point> pile_cible;

    public Undo(){
        this.pile_depart = new Stack<Point>();
        this.pile_cible = new Stack<Point>();
    }
    
    public void Enregistrer(Point point_depart,Point point_cible) {
    	this.pile_depart.push(point_depart);
    	this.pile_cible.push(point_cible);
    }
    
    public Point depile_point_depart() {
    	return this.pile_depart.pop();
    }
    public Point depile_point_cible() {
    	return this.pile_cible.pop();
    }
    
    public Stack<Point> getPile_point_depart() {
    	return this.pile_depart;
    }
    
    public Stack<Point> getPile_point_cible(){
    	return this.pile_cible;
    }
}
