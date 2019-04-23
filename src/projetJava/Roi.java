package projetJava;

public class Roi extends Piece{
	
	private final String nom = "R";

	public Roi(int couleur) {
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
		
		if( dx >= -1 && dx <= 1
				&& dy >= -1 && dy <= 1 )
		{
			return true;
		}
			
		return false;
	}
}
