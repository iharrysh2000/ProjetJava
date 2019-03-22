
public class Main {

	public static void main(String[] args) {
		Jeu jeu = new Jeu(20);
		if(jeu.getPiece(5, 5) != null)
		{
			Piece a = jeu.getPiece(5, 5);
			System.out.println(a.getNom());
			a.deplacerPiece(1,1);
			System.out.println(a.getLigne() + " " + a.getColonne());
		}
	}
}
