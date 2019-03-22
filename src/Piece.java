
public abstract class Piece {
	private int x;
	private int y;
	private String couleur;
	
	public Piece (int x, int y, String couleur) {
		this.x = x;
		this.y = y;
		this.couleur = couleur;
	}
	
	public int getLigne() {
		return this.x;
	}
	
	public int getColonne() {
		return this.y;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
	
	public boolean deplacerPiece(int dx, int dy) {
		if(this.deplacerPiece(dx, dy))
		{
			this.x += dx;
			this.y += dy;
			return true;
		}
		return false;		
	}
	
	public abstract String getNom();
}
