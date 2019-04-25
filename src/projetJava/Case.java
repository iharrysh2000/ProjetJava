package projetJava;

/**
 * Classe Case qui associe une pièce et sa couleur à sa position
 */
public class Case {
	private int couleur;
	private Piece piece;
	
	/**
	 * Constructeur d'une case
	 * @param piece la pièce sur la case
	 * @param couleur la couleur de la pièce
	 */
	public Case (Piece piece, int couleur) {
		this.piece = piece;
		this.couleur = couleur;
	}
	
	/**
	 * Renvoie la pièce qui occupe la case
	 * @return la pièce
	 */
	public Piece getPiece () {
		return this.piece;
	}
	
	/**
	 * Renvoie la couleur de la pièce qui occupe la case
	 * @return la couleur de la pièce
	 */
	public int getCoul () {
		return this.couleur;
	}
	
	/**
	 * Change la pièce de la case par une autre
	 * @param piece la pièce qui va occuper la case
	 */
	public void changePiece (Piece piece) {
		this.piece = piece;
	}
}
