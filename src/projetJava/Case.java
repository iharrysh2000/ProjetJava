package projetJava;


public class Case {
	private int couleur;
	private Piece piece;
	
	public Case (Piece piece, int couleur) {
		this.piece = piece;
		this.couleur = couleur;
	}
	
	public Piece getPiece () {
		return this.piece;
	}
	
	public int getCoul () {
		return this.couleur;
	}
	
	public void changePiece (Piece piece) {
		this.piece = piece;
	}
}
