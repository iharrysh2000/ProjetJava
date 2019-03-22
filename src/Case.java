
public class Case {
	private Piece p;
	private String couleur;
	
	public Case(Piece p, String couleur) {
		this.p = p;
		this.couleur = couleur;
	}
	
	public Piece getPiece() {
		return this.p;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
}
