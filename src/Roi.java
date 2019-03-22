
public class Roi extends Piece {
	public Roi (int x, int y, String couleur) {
		super(x, y, couleur);
	}
	
	public String getNom() {
		return "roi";
	}
	
	public boolean deplacerPiece (int dx, int dy)
	{
		if(dx == 1 || dx == -1 || dy == 1 || dy == -1)
			return true;
		return false;
	}
}
