package projetJava;

/**
 * Sous-classe Tour représentant le type de pièce Tour
 */
public class Tour extends Piece{
	
	private final String nom = "T";
	
	/**
	 * Constructeur de la tour
	 * @param couleur la couleur de la tour
	 */
	public Tour(int couleur) {
		super(couleur);
	}
	
	/**
	 * Retourne la chaine de caractères composé du nom et de la couleur de la tour
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
		if( (depX == finX) 
				|| (depY == finY) )
		{
			return true;
		}
			
		return false;
	}
}
