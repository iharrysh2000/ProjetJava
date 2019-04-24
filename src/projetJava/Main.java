package projetJava;

public class Main {

	public static void main(String[] args) {

		IO io = new IO (); // TEMPORAIRE
		Plateau p = new Plateau();
		
		p.afficher(0);
		
		io.lireClavier(p);
		io.getScanner().close();
		
		// NE PAS ENLEVER SVP
		//System.out.println("Tour 1:");
		//p.movePiece(4, 1, 3, 2);
		//p.afficher();
	}

}