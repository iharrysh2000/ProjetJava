package projetJava;

public class Joueur {
	
	//instances
	private int aQuiDeJouer;
	
	//constructeur
	public Joueur () {
		this.aQuiDeJouer = 0;
	}
	
	//méthodes
	public int changement () {
		if (this.aQuiDeJouer == 0) { //c'était l'ordi qui jouait
			this.aQuiDeJouer = 1; //donc au tour de l'humain
		}
		else { //c'était l'humain qui jouait
			this.aQuiDeJouer = 0; //donc au tour de l'ordi
		}
		return this.aQuiDeJouer;
	}
	
	public void auTourDeQui () { //affiche qui joue
		if(changement ()%2 == 1) {
			System.out.println("Au tour de l'humain de jouer.");
		}
		else {
			System.out.println("Au tour de l'ordinateur de jouer.");
		}
	}
}
