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
	public void jouer () {
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
        			this.ia();
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
        			this.ia();
        		}
        	}
        	
        	this.tours++;
        	if( noQuit )
        	{
        		this.plateau.afficher(this.tours);
        	}
        }
	}
	
	public void ia () {

		int x_depart;
		int y_depart;
		int x_cible;
		int y_cible;
		
		for(int i = 0; i < 8; i++) 
		{
			for(int j = 0; j < 8; j++) 
			{
				x_depart = i;
				y_depart = j;
				
				for(int k = 0; k < 8; k++) 
				{
					for(int l = 0; l < 8; l++) 
					{
						x_cible = k;
						y_cible = l;
						
						if( this.plateau.getPiece(x_depart, y_depart) != null )
						{
							
							if( plateau.inMap(x_depart, y_depart, x_cible, y_cible)
					    			&& plateau.movePiece(x_depart, y_depart, x_cible, y_cible) )
							{
								return;
							}
						}
					}
				}
			}
		}
	}
}
