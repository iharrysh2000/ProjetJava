package projetJava;

/**
 * Classe Plateau représentant le plateau de jeu
 */
public class Plateau {
	private Case[][] plateau;
	
	/**
	 * Contructeur du plateau : initialisation
	 */
	public Plateau () {

		this.plateau = new Case[8][8];
		
		Case c;
		int coul = 0;

			for (int i = 0; i < 8; i++)
			{
	            for (int j = 0; j < 2; j++)
	            {
	            	if( j == 1 )
	            	{
	            		c = new Case(new Pion (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else if( i == 0 || i == 7)
	            	{
	            		c = new Case(new Tour (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else if( i == 1 || i == 6)
	            	{
	            		c = new Case(new Cavalier (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else if( i == 2 || i == 5)
	            	{
	            		c = new Case(new Fou (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else if( i == 4)
	            	{
	            		c = new Case(new Roi (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else if( i == 3)
	            	{
	            		c = new Case(new Reine (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else
	            	{
	            		c = new Case(null, (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            }
			}
			
			coul = 1;
			
			for (int i = 0; i < 8; i++)
			{
	            for (int j = 6; j < 8; j++)
	            {
	            	if( j == 6 )
	            	{
	            		c = new Case(new Pion (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else if( i == 0 || i == 7)
	            	{
	            		c = new Case(new Tour (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else if( i == 1 || i == 6)
	            	{
	            		c = new Case(new Cavalier (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else if( i == 2 || i == 5)
	            	{
	            		c = new Case(new Fou (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else if( i == 4)
	            	{
	            		c = new Case(new Roi (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else if( i == 3)
	            	{
	            		c = new Case(new Reine (coul), (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            	else
	            	{
	            		c = new Case(null, (i+j)%2);
	                	this.plateau[i][j] = c;
	            	}
	            }
			}
			
			for (int i = 0; i < 8; i++)
			{
	            for (int j = 2; j < 6; j++)
	            {
	            	c = new Case(null, (i+j)%2);
                	this.plateau[i][j] = c;
	            }
			}
			
	}
	
	/**
	 * Déplacement du pion
	 */
	public boolean movePion  (int depX, int depY, int finX, int finY) {
		int dx = finX - depX;
		int dy = finY - depY;
		
		Case c = this.plateau[depX][depY];
		Case dest = this.plateau[finX][finY];
		
		boolean bouge = false;

		if(dx == 0)
		{
			if( this.testLigne(depX, depY, finX, finY) )
			{
				// Test si la case destination n'a pas de piece
				if( dest.getPiece() == null )
				{
					if(!c.getPiece().getMove())
						c.getPiece().changeMove();
					this.movePiece(c, dest);
					bouge = true;
				}
			}
		}
		else if (dx == -1 || dx == 1)
		{
			if(dy == -1 && c.getPiece().getCoul() == 1)
			{
				if ( this.testDiag(depX, depY, finX, finY) )
				{
					if( dest.getPiece() != null && c.getPiece().getCoul() != dest.getPiece().getCoul() )
					{
						if(!c.getPiece().getMove())
							c.getPiece().changeMove();
						this.movePiece(c, dest);
						bouge = true;
					}
				}
			}
			if(dy == 1 && c.getPiece().getCoul() == 0)
			{
				if ( this.testDiag(depX, depY, finX, finY) )
				{
					if( dest.getPiece() != null && c.getPiece().getCoul() != dest.getPiece().getCoul() )
					{
						if(!c.getPiece().getMove())
							c.getPiece().changeMove();
						this.movePiece(c, dest);
						bouge = true;
					}
				}
			}
		}

		// Promotion des pions a faire 
		if(bouge && (finY == 0 || finY == 7) )
		{
			IO tmp = new IO(null);
			tmp.promotion(dest);
		}
		
		return bouge;
	}
	
	/**
	 * Déplacement du cavalier
	 */
	public boolean moveCavalier (int depX, int depY, int finX, int finY) {
		
		Case c = this.plateau[depX][depY];
		Case dest = this.plateau[finX][finY];
		
		if( dest.getPiece() == null)
		{
			this.movePiece(c, dest);
			return true;
		}
		else if( c.getPiece().getCoul() != dest.getPiece().getCoul() )
		{
			this.movePiece(c, dest);
			return true;
		}
		return false;
	}
	
	/**
	 * Déplacement d'une pièce
	 */
	public boolean movePiece (int depX, int depY, int finX, int finY) {
		int dx = finX - depX;
		int dy = finY - depY;
		
		Case c = this.plateau[depX][depY];
		Case dest = this.plateau[finX][finY];
		
		// La condition test si il y a une piece, test si le mouvement de la piece est bon,
		//test si toutes les coord sont dans la map, test si ce ne sont pas les même coord
		if(c.getPiece() != null 
				&& c.getPiece().movePiece(depX, depY, finX, finY)
				&& this.inMap(depX, depY, finX, finY)
				&& !( dx == 0 && dy == 0))
		{
			// Traite le cas du pion
			if(c.getPiece().getClass() == Pion.class)
			{
				return this.movePion(depX, depY, finX, finY);
			}
			// Traite le cas du cavalier
			else if(c.getPiece().getClass() == Cavalier.class)
			{
				return this.moveCavalier(depX, depY, finX, finY);
			}
			// traite les autres cas
			else if(dx == 0 || dy == 0)
			{
				if( this.testLigne(depX, depY, finX, finY) )
				{
					// Test si la case destination n'a pas de piece
					if( dest.getPiece() == null )
					{
						this.movePiece(c, dest);
						return true;
					}
					// Test si la couleur de la piece destination est différente de la piece de départ
					else if ( c.getPiece().getCoul() != dest.getPiece().getCoul() )
					{
						this.movePiece(c, dest);
						return true;
					}
				}
			}
			else if(dx == dy || dx == -dy)
			{
				if ( this.testDiag(depX, depY, finX, finY) )
				{
					if( dest.getPiece() == null )
					{
						this.movePiece(c, dest);
						return true;
					}
					// Test si la couleur de la piece destination est différente de la piece de départ
					else if ( c.getPiece().getCoul() != dest.getPiece().getCoul() )
					{
						this.movePiece(c, dest);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	/**
	 * Retourne true si les coordonné sont dans la map, false sinon
	 * @param les coordonnées de départ et d'arrivée
	 */
	
	public boolean inMap (int depX, int depY, int finX, int finY) {
		if (depX >= 0 && depX < 8 && finX >= 0 && finX < 8
				&& depY >= 0 && depY < 8 && finY >= 0 && finY < 8)
		{
			return true;
		}
		return false;
	}
	
	
	/**
	 * Déplacement en diagonale
	 * @param les coordonnées de départ et d'arrivée
	 */
	public boolean testDiag (int depX, int depY, int finX, int finY) {
		int dx = finX - depX;
		int dy = finY - depY;

		// Test diagonale /
		if(dx == dy)
		{
			if(dx > 0)
			{
				return this.testDiagHautDroite (depX, depY, finX, finY);
			}
			else
			{
				return this.testDiagBasGauche (depX, depY, finX, finY);
			}
		}
		// Test diagonale \
		else if(dx == -dy)
		{
			if(dx > 0)
			{
				return this.testDiagBasDroite (depX, depY, finX, finY);
			}
			else
			{
				return this.testDiagHautGauche (depX, depY, finX, finY);
			}
		}
		return false;
	}
	
	/**
	 * Test de la diagonale en haut à droite
	 * @param les coordonnées de départ et d'arrivée
	 */
	public boolean testDiagHautDroite (int depX, int depY, int finX, int finY) {
		Case c;
		for(int i = depX + 1, j = depY + 1; i < finX && j < finY; i++, j++)
		{
			c = this.plateau[i][j];
			if(c.getPiece() != null)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Test de la diagonale en bas à gauche
	 * @param les coordonnées de départ et d'arrivée
	 */
	public boolean testDiagBasGauche (int depX, int depY, int finX, int finY) {
		Case c;
		for(int i = depX - 1, j = depY - 1; i > finX && j > finY; i--, j--)
		{
			c = this.plateau[i][j];
			if(c.getPiece() != null)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Test de la diagonale en haut à gauche
	 * @param les coordonnées de départ et d'arrivée
	 */
	public boolean testDiagHautGauche (int depX, int depY, int finX, int finY) {
		Case c;
		for(int i = depX - 1, j = depY + 1; i > finX && j < finY; i--, j++)
		{
			c = this.plateau[i][j];
			if(c.getPiece() != null)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Test de la diagonale en bas à droite
	 * @param les coordonnées de départ et d'arrivée
	 */
	public boolean testDiagBasDroite (int depX, int depY, int finX, int finY) {
		Case c;
		for(int i = depX + 1, j = depY - 1; i < finX && j > finY; i++, j--)
		{
			c = this.plateau[i][j];
			if(c.getPiece() != null)
			{
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Déplacement en ligne
	 * @param les coordonnées de départ et d'arrivée
	 */
	
	public boolean testLigne (int depX, int depY, int finX, int finY) {
		int dx = finX - depX;
		int dy = finY - depY;
		
		// Test Verticale
		if(dx == 0)
		{
			if(dy > 0)
			{
				return this.testVerticaleLigneHaut (depX, depY, finX, finY);
			}
			else
			{
				return this.testVerticaleLigneBas (depX, depY, finX, finY);
			}
		}
		
		// Test Horizontale
		if(dy == 0)
		{
			if(dx > 0)
			{
				return this.testHorizontaleLigneDroite(depX, depY, finX, finY);
			}
			else
			{
				return this.testHorizontaleLigneGauche(depX, depY, finX, finY);
			}
		}
		return false;
	}
	
	/**
	 * Test de la direction en haut
	 * @param les coordonnées de départ et d'arrivée
	 */
	public boolean testVerticaleLigneHaut (int depX, int depY, int finX, int finY) {
		Case c;
		for(int i = depY + 1; i < finY; i++)
		{
			c = this.plateau[depX][i];
			if(c.getPiece() != null)
			{
				return false;
			}
		}
		return true;
	}
	
	/** 
	 * Test de la direction en bas
	 * @param les coordonnées de départ et d'arrivée
	 */
	public boolean testVerticaleLigneBas (int depX, int depY, int finX, int finY) {
		Case c;
		for(int i = depY - 1; i > finY; i--)
		{
			c = this.plateau[depX][i];
			if(c.getPiece() != null)
			{
				return false;
			}
		}
		return true;
	}
	
	/** 
	 * Test de la direction à droite
	 * @param les coordonnées de départ et d'arrivée
	 */
	public boolean testHorizontaleLigneDroite (int depX, int depY, int finX, int finY) {
		Case c;
		for(int i = depX + 1; i < finX; i++)
		{
			c = this.plateau[i][depY];
			if(c.getPiece() != null)
			{
				return false;
			}
		}
		return true;
	}
	
	/** 
	 * Test de la direction à gauche
	 * @param les coordonnées de départ et d'arrivée
	 */
	public boolean testHorizontaleLigneGauche (int depX, int depY, int finX, int finY) {
		Case c;
		for(int i = depX - 1; i > finX; i--)
		{
			c = this.plateau[i][depY];
			if(c.getPiece() != null)
			{
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Affichage du jeu
	 * @param tours le nombre de tours
	 */
	public void afficher( int tours){
		System.out.println("\nTours " + tours + " :\n");
        for (int j = 7; j >=0; j--){
            for (int i = 0; i < 8; i++){
            	if(i == 0)
            	{
            		System.out.print(j+1 + " ");
            	}
                if(this.plateau[i][j].getPiece() != null)
                    System.out.print("[" + this.plateau[i][j].getPiece() + "]");
                else
                    System.out.print("[  ]");
            }
            System.out.println(" ");
        }
        System.out.print("   a   b   c   d   e   f   g   h");
        System.out.println(" ");
    }
	
	/**
	 * Getteur de piece
	 * @param la position de la pièce
	 */
	public Piece getPiece (int x, int y) {
		return this.plateau[x][y].getPiece();
	}
	
	public Case getCase (int x, int y) {
		return this.plateau[x][y];
	}
	
	/**
	 * Getteur de position d'une piece
	 * @param piece la pièce
	 */
	public Point getPosPiece (Piece piece) {
		for( int i = 0 ; i < 8 ; i++) 
		{
			for( int j = 0 ; j < 8 ; j++) 
			{
				if(this.plateau[i][j].getPiece() == piece)
				{
					return new Point(i,j);
				}
			}
		}
		return null;
	}
	
	/**
	 * Dépalcement d'une pièce
	 * @param c la case de départ; dest la case d'arrivée
	public void movePiece (Case c, Case dest) {
		dest.changePiece(c.getPiece());
		c.changePiece(null);
	}
	
	/**
	 * Détection du roi
	 * @param couleur la couleur du roi
	 */
	public Point findKing(int couleur) {
		
		for( int i = 0 ; i < 8 ; i++) 
		{
			for( int j = 0 ; j < 8 ; j++) 
			{
				if(this.plateau[i][j].getPiece().getClass() == Roi.class
					&& this.plateau[i][j].getPiece().getCoul() == couleur)
				{
					return new Point(i,j);
				}
			}
		}
		
		return null;
	}
	
	/**
	 * test si le roi est en situation d'échec
	 * @param couleur la couleur du roi
	 */
	public boolean isEchec(int couleur) {
		Point point = this.findKing(couleur);
		
		if(point == null)
		{
			System.out.println("Problème");
			return true;
		}
		else
		{
			// Cas Pion
			
			// Cas Cavalier
			
			// Autre cas
		}
		return true;
	}
	
	public boolean echecPion (Point point, int couleur) {
		
		if( couleur == 0)
		{
			
		}
		else
		{
			
		}
		return true;
	}
	
	public boolean echecCavalier (Point point, int couleur) {
		
		if( couleur == 0)
		{
			
		}
		else
		{
			
		}
		return true;
	}
	
	public boolean echecAutre (Point point, int couleur) {
		
		if( couleur == 0)
		{
			
		}
		else
		{
			
		}
		return true;
	}
}
