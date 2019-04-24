package projetJava;
import java.util.Stack;
/**
 * Classe Gestionnaire de pile
 * Cette classe permet la gestion des piles afin de sauvegarder les coups fait par les joueurs. Elle contient 3 piles :
 * 1. Pour sauvegarder les coordonnées initiale de pièce avant de changer de coordonnées
 * 2. Pour sauvegarder les coordonnées après déplacements de la pièce
 * 3. Pour sauvegarder les pièces qui ont été supprimées
 * @author user
 *
 */
class Undo {
	
	/* pile qui sauvegarde les coordonnées de départ */
    private Stack<Point> pile_depart;
    
    /* pile qui sauvegarde les coordonnées cible */
    private Stack<Point> pile_cible;

    /* pile qui sauvegarde les pièces qui ont été supprimées */
    private Stack<Piece> pile_piece_depart;
    
    /* pile qui sauvegarde les pièces qui ont été supprimées */
    private Stack<Piece> pile_piece_cible;
    

    /**
     * Constructeur de la classe Undo
     * Initialise des piles vide
     */
    public Undo(){
        this.pile_depart = new Stack<Point>();
        this.pile_cible = new Stack<Point>();
        this.pile_piece_depart = new Stack<Piece>();
        this.pile_piece_cible = new Stack<Piece>();
    }
    
    /**
     * Permet l'enregistrement des coordonnées
     * @param point_depart
     * @param point_cible
     */
    public void enregistrer_coords(Point point_depart,Point point_cible) {
    	this.pile_depart.push(point_depart);
    	this.pile_cible.push(point_cible);
    }
    
    /**
     * Permet d'enregistrer une piece
     * @param piece
     */
    public void enregistrer_piece_depart(Piece piece) {
    	this.pile_piece_depart.push(piece);
    }
    
    /**
     * Permet d'enregistrer une piece
     * @param piece
     */
    public void enregistrer_piece_cible (Piece piece) {
    	this.pile_piece_cible.push(piece);
    }
    
    /**
     * Depile les coordonnées de départ
     * @return coordonnées de départ
     */
    public Point depile_point_depart() {
    	return this.pile_depart.pop();
    }
    
    /**
     * Depile les coordonnées cible
     * @return coordonnées cible
     */
    public Point depile_point_cible() {
    	return this.pile_cible.pop();
    }
    
    /**
     * Depile les pieces qui ont été supprimées durant la partie
     * @return piece
     */
    public Piece depile_piece_depart() {
    	return this.pile_piece_depart.pop();
    }
    
    /**
     * Depile les pieces qui ont été supprimées durant la partie
     * @return piece
     */
    public Stack<Piece> depile_piece_cible(){
    	return this.pile_piece_cible;
    }
    
    /**
     * Getteur de la pile de coordonnées de départ
     * @return pile
     */
    public Stack<Point> getPile_point_depart() {
    	return this.pile_depart;
    }
    
    /**
     * Getteur de la pile de coordonnées cible
     * @return pile
     */
    public Stack<Point> getPile_point_cible(){
    	return this.pile_cible;
    }
    
    /**
     * Getteur de la pile des pièces
     * @return pile
     */
    public Stack<Piece> getPile_piece_depart (){
    	return this.pile_piece_depart;
    }
 
    
    /**
     * Getteur de la pile des pièces
     * @return pile
     */
    public Stack<Piece> getPile_piece_cible(){
    	return this.pile_piece_cible;
    }
}
