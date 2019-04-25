package projetJava;

/**
 * Sous-classe Reine qui correspond au type de pièce reine
 */
public class Reine extends Piece {
	
	private final String nom = "D";

	/**
	 * Constructeur de la reine
	 * @param couleur la couleur de la reine
	 */
	public Reine(int couleur) {
		super(couleur);
	}
	
	/**
	 * Retourne la chaine de caractères composé du nom et de la couleur de la reine
	 * @return le nom et la couleur du reine
	 */
	@Override
	public String toString () {
		return this.nom + this.getCoul();
	}

	/**
	 * Déplacement de la reine
	 * @return boolean Retourne vrai si le déplacement est valide ou faux si le déplacement n'est pas valide
	 */
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
