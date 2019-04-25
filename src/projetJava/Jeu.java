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
		int a_qui_de_jouer = 1;
        while( noQuit && this.isMat(a_qui_de_jouer) )
        {
        	a_qui_de_jouer = a_qui_de_jouer^ 1;
        	if(a_qui_de_jouer == 0)
        	{
        		if( this.joueur.getJ1().equals("H") )
        		{
        			if(this.plateau.isEchec(a_qui_de_jouer)){
        				System.out.println("Echec !");
    				}
        			noQuit = this.io.entryPiece (this.plateau, a_qui_de_jouer);
        		}
        		else
        		{
        			// ia a faire
        			if(this.plateau.isEchec(a_qui_de_jouer)){
        				System.out.println("Echec !");
    				}
        			noQuit = false;
        			System.out.println( this.joueur.getJ1() );
        		}
        	}
        	else
        	{
        		if( this.joueur.getJ2().equals("H") )
        		{
        			if(this.plateau.isEchec(a_qui_de_jouer)){
        				System.out.println("Echec !");
    				}
        			noQuit = this.io.entryPiece (this.plateau,a_qui_de_jouer);
        		}
        		else
        		{
        			// ia a faire
        			if(this.plateau.isEchec(a_qui_de_jouer)){
        				System.out.println("Echec !");
    				}
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
	
	public boolean isMat(int couleur) {
		
	final Point point_init = new Point(this.plateau.findKing(couleur).getX(),this.plateau.findKing(couleur).getY());
	return checkisMatHV(point_init,couleur);
	}
	
	public boolean checkisMatHV(final Point point_init, int couleur) {
		Point point = new Point(point_init.getX(),point_init.getY());
		if(!(this.plateau.checkMove_isEchec(point, couleur))) {
			point.setX(point_init.getX() + 1); 
			point.setY(point_init.getY()); 
			if(!(this.plateau.checkMove_isEchec(point, couleur))) {
				point.setX(point_init.getX());
				point.setY(point_init.getY() + 1);
				if(!(this.plateau.checkMove_isEchec(point, couleur))) {
					point.setX(point_init.getX() -1 );
					point.setY(point_init.getY()); 
					if(!(this.plateau.checkMove_isEchec(point, couleur))) {
						point.setX(point_init.getX()-1);
						point.setY(point_init.getY());
						if(!(this.plateau.checkMove_isEchec(point, couleur))) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean checkisMatDiagonal(final Point point_init,int couleur) {
		Point point = new Point(point_init.getX()+1,point_init.getY()+1);
		if(this.plateau.checkMove_isEchec(point, couleur)) {
			point.setX(point_init.getX()-1);
			point.setY(point_init.getY()+1);
			if(this.plateau.checkMove_isEchec(point, couleur)) {
				point.setX(point_init.getX()+1);
				point.setY(point_init.getY()-1);
				if(this.plateau.checkMove_isEchec(point, couleur)) {
					point.setX(point_init.getX()-1);
					point.setY(point_init.getY()-1);
					if(this.plateau.checkMove_isEchec(point, couleur)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
