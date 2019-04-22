package projetJava;

public class Reine extends Piece {
	
	private final String nom = "R";

	public Reine(int couleur) {
		super(couleur);
	}
	
	@Override
	public String toString () {
		return this.nom + this.getCoul();
	}

	@Override
	public boolean movePiece(int depX, int depY, int finX, int finY) {
		int dx = depX - finX;
		int dy = depY - finY;
		
		if( (dx == dy) || (dx == -dy) 
				|| dx == 0 || dy == 0)
		{
			return true;
		}
			
		return false;
	}

}
