package projetJava;


public class Fou extends Piece{
	
	private final String nom = "F";
	
	public Fou(int couleur) {
		super(couleur);
	}
	
	@Override
	public String toString () {
		return this.nom + this.getCoul();
	}
	
	@Override
	public boolean movePiece (int depX, int depY, int finX, int finY) {
		int dx = depX - finX;
		int dy = depY - finY;
		
		if( (dx == dy) 
				|| (dx == -dy) )
		{
			return true;
		}

		return false;
	}
}
