
public class Jeu {
	private int nbTours;
	private Plateau plateau;
	
	public Jeu(int x) {
		this.plateau = new Plateau();
		this.nbTours = x;	
	}
	
	public int getTours() {
		return this.nbTours;
	}
	
	public Case getCase(int largeur, int hauteur)
	{
		return this.plateau.getCase(largeur, hauteur);
	}
	public Piece getPiece(int largeur, int hauteur)
	{
		return this.plateau.getPiece(largeur, hauteur);
	}
}
