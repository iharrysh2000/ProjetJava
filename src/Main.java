/**
 * Représente l'application.
 *
 * @version  alpha 0.0
 * @author   me
 *
 */
enum Main {
	ENVIRONNEMENT;

	/*
	 * Méthode principale du programme.
	 * @param args void
	 */
	public void run(String[] args) {
		Jeu jeu = new Jeu(20);
		if(jeu.getPiece(5, 5) != null)
		{
			Piece a = jeu.getPiece(5, 5);
			System.out.println(a.getNom());
			a.deplacerPiece(1,1);
			System.out.println(a.getLigne() + " " + a.getColonne());
		}
	}

	/*
	 * Point d'entrée du programme.
	 * @param args les void
	 */
	public static void main(String[] args) {
		ENVIRONNEMENT.run(args);
	}
}