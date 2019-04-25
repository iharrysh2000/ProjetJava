package projetJava;

/**
 * Sous-classe Fou qui correspond au type de pièce Fou
 */
public class Fou extends Piece{
	
	private final String nom = "F";
	
	/**
	 * Constructeur du fou
	 * @param couleur la couleur du fou
	 */
	public Fou(int couleur) {
		super(couleur);
	}
	
	/**
	 * Retourne la chaine de caractères composé du nom et de la couleur du fou
	 * @return le nom et la couleur du fou
	 */
	@Override
	public String toString () {
		return this.nom + this.getCoul();
	}
	
	/**
	 * Déplacement du fou
	 * @return boolean Retourne vrai si le déplacement est valide ou faux si le déplacement n'est pas valide
	 */
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
