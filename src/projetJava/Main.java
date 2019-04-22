package projetJava;

public class Main {

	public static void main(String[] args) {
		Plateau p = new Plateau ();
		
		System.out.println("Tour 0:");
		p.afficher();
		
		System.out.println("Tour 1:");
		p.movePiece(7, 7, 0, 0);
		p.afficher();
		
		System.out.println("Tour 2:");
		p.movePiece(0, 7, 7, 0);
		p.afficher();
		
		System.out.println("Tour 3:");
		p.movePiece(4, 0, 3, 1);
		p.afficher();
		
		System.out.println("Tour 4:");
		p.movePiece(4, 7, 4, 0);
		p.afficher();
	
	}

}
