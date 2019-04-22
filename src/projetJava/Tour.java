package projetJava;


public class Tour extends Piece{
	
	private final String nom = "T";
	
	public Tour(int couleur) {
		super(couleur);
	}
	
	@Override
	public String toString () {
		return this.nom + this.getCoul();
	}
	
	@Override
	public boolean movePiece (int depX, int depY, int finX, int finY) {
		if( (depX == finX) 
				|| (depY == finY) )
		{
			return true;
		}
			
		return false;
	}
}
