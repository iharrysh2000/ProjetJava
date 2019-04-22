package projetJava;

public class Main {

	public static void main(String[] args) {
		Plateau p = new Plateau ();
		
		System.out.println("Tour 0:");
		p.afficher();
		
		System.out.println("Tour 1:");
		p.movePiece(4, 1, 4, 3);
		p.afficher();
		
		System.out.println("Tour 2:");
		p.movePiece(4, 6, 4, 4);
		p.afficher();
		
		System.out.println("Tour 3:");
		p.movePiece(3, 0, 7, 4);
		p.afficher();
		
		System.out.println("Tour 4:");
		p.movePiece(7, 4, 5, 6);
		p.afficher();
		
	}

}
