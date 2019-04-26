package projetJava;

/**
 * Sous-classe Cavalier qui correspond au type de pièce Cavalier
 */
public class Cavalier extends Piece {

	private final String nom = "C";

	/**
	 * Constructeur du cavalier
	 * 
	 * @param couleur la couleur du cavalier
	 */
	public Cavalier(int couleur) {
		super(couleur);
	}

	/**
	 * Retourne la chaine de caractères composée du nom et de la couleur du cavalier
	 * 
	 * @return le nom et la couleur du cavalier
	 */
	@Override
	public String toString() {
		return this.nom + this.getCoul();
	}

	/**
	 * Déplacement du cavalier
	 * 
	 * @param depx l'abscisse de départ
	 * @param depy l'ordonée de départ
	 * @param finX l'abscisse d'arrivée
	 * @param finy l'ordonée de d'arrivée
	 * @return vrai si le déplacement est valide ou faux si le déplacement n'est pas
	 *         valide
	 */
	@Override
	public boolean movePiece(int depX, int depY, int finX, int finY) {
		int dx = finX - depX;
		int dy = finY - depY;
		int distance = (dx >= 0 ? dx : -dx) + (dy >= 0 ? dy : -dy);

		if (distance == 3 && dx != 0 && dy != 0) {
			return true;
		}

		return false;
	}
}
