package projetJava;

public abstract class Piece {
	private int couleur;
	private boolean move;
	
	public Piece (int couleur) {
		this.couleur = couleur;
		this.move = false;
	}
	
	public boolean getMove () {
		return this.move;
	}
	
	public void changeMove () {
		this.move = true;
	}
	
	public int getCoul () {
		return this.couleur;
	}
	
	public abstract boolean movePiece(int depX, int depY, int finX, int finY);
}
