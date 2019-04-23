package projetJava;

public class Main {

	public static void main(String[] args) {
		Plateau p = new Plateau ();
		IO io = new IO ();
		
		System.out.println("Tour 0:");
		p.afficher();
		
		io.lireClavier(p);
		
	}

}
