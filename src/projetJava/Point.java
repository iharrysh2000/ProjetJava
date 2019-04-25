package projetJava;

/**
 * Classe Point qui représente les coordonées
 */
public class Point {
	
	private int x;
	private int y;
	
	/**
	 * Constructeur du point
	 * @param x l'abscisse
	 * @param y l'ordonnée
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Retourne l'ordonnée du point
	 */ 
	public int getY() {
		return this.y;
	}
	
	/**
	 * Retourne l'abscisse du point
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Retourne la chaine de caractères composée de l'abscisse et de l'ordonnée du point
	 */
	@Override
	public String toString() {
		return "x : " + this.x + ", y : " + this.y;
	}
}
