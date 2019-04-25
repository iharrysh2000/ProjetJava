package projetJava;

/**
 * Classe Jeu représentant le jeu
 */
public class Jeu {
	
	private Undo undo;
	private Plateau plateau;
	private IO io;
	private Joueur joueur;
	private int tours;
	
	/**
	 * Constructeur du jeu
	 */
	public Jeu () {
		this.undo = new Undo();
		this.plateau = new Plateau();
		this.io = new IO(this.undo);
		this.joueur = new Joueur();
		
		this.tours = 0;
		
		this.plateau.afficher(this.tours);
	}
	
	/**
	 * Lecture du clavier
	 * @param plateau plateau du jeu pour effectuer les modifications
	 */
	public void jouer () {
		boolean noQuit = true;
		
        while( noQuit )
        {
        	if(this.tours%2 == 0 )
        	{
        		if( this.joueur.getJ1().equals("H") )
        		{
        			noQuit = this.io.entryPiece (this.plateau, this.tours%2, this.tours);
        		}
        		else
        		{
        			if( !this.ia( this.tours%2) )
        			{
        				noQuit = false;
        			}
        		}
        	}
        	else
        	{
        		if( this.joueur.getJ2().equals("H") )
        		{
        			noQuit = this.io.entryPiece (this.plateau, this.tours%2, this.tours);
        		}
        		else
        		{
        			if( !this.ia( this.tours%2) )
        			{
        				noQuit = false;
        			}
        		}
        	}
        	
        	this.tours++;
        	if( noQuit )
        	{
        		this.plateau.afficher(this.tours);
        	}
        }
	}
	
	/**
	 * Retourne 
	 * @param couleur
	 */
	public boolean ia (int couleur) {

		int x_depart;
		int y_depart;
		int x_cible;
		int y_cible;
		
		Piece piece_depart;
		Piece piece_cible;
		
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
						
						if( this.plateau.getPiece(x_depart, y_depart) != null 
							&& this.plateau.getPiece(x_depart, y_depart).getCoul() == couleur)
						{
							piece_depart = plateau.getPiece(x_depart, y_depart);
					        piece_cible = plateau.getPiece(x_cible, y_cible);
					        
							if( plateau.inMap(x_depart, y_depart, x_cible, y_cible)
					    			&& plateau.movePiece(x_depart, y_depart, x_cible, y_cible) )
							{
								Point point_depart = new Point(x_depart, y_depart);
								Point point_cible = new Point(x_cible , y_cible);
								this.io.empile(point_depart, point_cible, piece_depart, piece_cible);
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}
