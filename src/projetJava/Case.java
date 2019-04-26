package projetJava;

/**
 * Classe Case qui associe une pièce et sa couleur au plateau
 */
public class Case {
	private int couleur;
	private Piece piece;

	/**
	 * Constructeur d'une case
	 * 
	 * @param piece   la pièce sur la case
	 * @param couleur la couleur de la pièce
	 */
	public Case(Piece piece, int couleur) {
		this.piece = piece;
		this.couleur = couleur;
	}

	/**
	 * Renvoie la pièce qui occupe la case
	 * 
	 * @return piece la pièce
	 */
	public Piece getPiece() {
		return this.piece;
	}

	/**
	 * Renvoie la couleur de la pièce qui occupe la case
	 * 
	 * @return couleur la couleur de la pièce
	 */
	public int getCoul() {
		return this.couleur;
	}

	/**
	 * Change la pièce de la case par autre chose
	 * 
	 * @param piece l'éventuelle pièce qui va occuper la case
	 */
	public void changePiece(Piece piece) {
		this.piece = piece;
	}
}
