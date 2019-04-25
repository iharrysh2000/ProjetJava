package projetJava;

/**
 * Classe pièce représentant tout les types de pièces
 */
public abstract class Piece {
	private int couleur;
	private boolean move;
	
	/**
	 * Constructeur de la classe pièce
	 * @param couleur la couleur de la pièce
	 */
	public Piece (int couleur) {
		this.couleur = couleur;
		this.move = false;
	}
	
	/**
	 * Retourne la nature du mouvement de la pièce
	 */
	public boolean getMove () {
		return this.move;
	}
	
	/**
	 * Modifie la nature du mouvement de la pièce
	 */
	public void changeMove () {
		this.move = true;
	}
	
	/**
	 * Retourne la couleur de la pièce
	 */
	public int getCoul () {
		return this.couleur;
	}
	
	/**
	 * Déplacement d'une pièce
	 * @param les coordonnées de départ et d'arrivées
	 */
	public abstract boolean movePiece(int depX, int depY, int finX, int finY);
}
