package projetJava;

public class Cavalier extends Piece{
	
	private final String nom = "C";

	public Cavalier (int couleur) {
		super(couleur);
	}
	
	@Override
	public String toString () {
		return this.nom + this.getCoul();
	}

	@Override
	public boolean movePiece(int depX, int depY, int finX, int finY) {
		int dx = finX - depX;
		int dy = finY - depY;
		int distance = (dx >= 0 ? dx : -dx) + (dy >= 0 ? dy : -dy);
		
		if (distance == 3 && dx != 0 && dy != 0)
		{
			return true;
		}
			
		return false;
	}
}
