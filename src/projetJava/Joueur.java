package projetJava;

/**
 * Classe Joueur qui indique qui sont les joueurs
 */
public class Joueur {
	
	private String j1; //représente le joueur 1
	private String j2; //repréente le joueur 2
	
	/**
	 * Constructeur du joueur
	 */
	public Joueur () {
		IO tmp = new IO(null);
		boolean found = false;
		
		System.out.println("\nLe jeu se joue à 2. Ecrivez : "
				+ "\n - H pour Humain"
				+ "\n - O pour Ordi\n");
		
		while( !found )
		{
			System.out.println("\nVeuillez choisir le type du premier joueur :\n");
			this.j1 = tmp.quiJoue();
			System.out.println("\nVeuillez choisir le type du second joueur :\n");
			this.j2 = tmp.quiJoue();
			
			if ( ( this.j1.equals("H") || this.j1.equals("O") ) && ( this.j2.equals("H") || this.j2.equals("O") ) )
			{
				found = true;
			}
			else
			{
				System.out.println("ERREUR : Mauvaise commande. Veuillez taper une des 2 commandes");
			}
		}
		
		if(this.j1.equals("O") && this.j2.equals("O"))
		{
			System.out.println("ATTENTION : BOUCLE INFINI");
			System.out.println("ATTENTION : BOUCLE INFINI");
			System.out.println("ATTENTION : BOUCLE INFINI");
		}
	}
	
	/**
	 * Retourne le type du joueur 1
	 */
	public String getJ1 () {
		return this.j1;
	}
	
	/**
	 * Retourne le type du joueur 2
	 */
	public String getJ2 () {
		return this.j2;
	}
}
