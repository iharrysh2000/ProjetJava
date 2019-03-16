
public class Pion {
	private int ligne;
	private char colonne;
	
	public Pion (int ligne, char colonne) {
		this.ligne = ligne;
		this.colonne = colonne;
	}
	
	public int getLigne () {
		return this.ligne;
	}
	
	public char getColonne () {
		return this.colonne;
	}

}
