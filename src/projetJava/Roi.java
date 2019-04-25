package projetJava;

/**
 * Sous-classe Roi qui correspond au type de pièce Roi
 */
public class Roi extends Piece{
	
	private final String nom = "R";
	
	/**
	 * Constructeur du roi
	 * @param couleur la couleur du roi
	 */
	public Roi(int couleur) {
		super(couleur);
	}
	
	/**
	 * Retourne la chaine de caractères composé du nom et de la couleur du roi
	 * @return le nom et la couleur du fou
	 */
	@Override
	public String toString () {
		return this.nom + this.getCoul();
	}
	
	/**
	 * Déplacement du roi
	 * @return boolean Retourne vrai si le déplacement est valide ou faux si le déplacement n'est pas valide
	 */
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
