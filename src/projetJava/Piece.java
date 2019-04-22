package projetJava;

public abstract class Piece {
	private int couleur;
	
	public Piece (int couleur) {
		this.couleur = couleur;
	}
	
	public int getCoul () {
		return this.couleur;
	}
	
	public abstract boolean movePiece(int depX, int depY, int finX, int finY);
}
