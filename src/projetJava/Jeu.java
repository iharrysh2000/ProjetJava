package projetJava;

public class Jeu {
	
	private Plateau plateau;
	private IO io;
	private Joueur joueur;
	private int tours;
	
	public Jeu () {
		this.plateau = new Plateau();
		this.io = new IO();
		this.joueur = new Joueur();
		
		this.tours = 0;
		
		this.plateau.afficher(this.tours);
	}
	
	/**
	 * Lecture du clavier
	 * @param plateau 	plateau du jeu pour effectuer les modifications
	 */
	public void jouer (){
		boolean noQuit = true;
		
        while( noQuit )
        {
        	if(this.tours%2 == 0 )
        	{
        		if( this.joueur.getJ1().equals("H") )
        		{
        			noQuit = this.io.entryPiece (this.plateau, this.tours%2);
        		}
        		else
        		{
        			// ia a faire
        			noQuit = false;
        			System.out.println( this.joueur.getJ1() );
        		}
        	}
        	else
        	{
        		if( this.joueur.getJ2().equals("H") )
        		{
        			noQuit = this.io.entryPiece (this.plateau, this.tours%2);
        		}
        		else
        		{
        			// ia a faire
        			noQuit = false;
        			System.out.println( this.joueur.getJ2() );
        		}
        	}
        	
        	this.tours++;
        	if( noQuit )
        	{
        		this.plateau.afficher(this.tours);
        	}
        }
	}
}
