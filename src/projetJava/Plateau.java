package projetJava;

public class Plateau {
	private Case[][] plateau;
	private IO io;
	
	// Initialise le plateau
	public Plateau (IO io) {
		this.io = io;
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
	
	// probleme
	public void movePion  (int depX, int depY, int finX, int finY) {
		int dx = finX - depX;
		int dy = finY - depY;
		
		Case c = this.plateau[depX][depY];
		Case dest = this.plateau[finX][finY];
		
		boolean bouge = false;

		if(dx == 0)
		{
			if( this.moveLigne(depX, depY, finX, finY) )
			{
				// Test si la case destination n'a pas de piece
				if( dest.getPiece() == null )
				{
					dest.changePiece(c.getPiece());
					c.changePiece(null);
					bouge = true;
				}
			}
		}
		else if (dx == -1 || dx == 1)
		{
			if(dy == -1 && c.getPiece().getCoul() == 1)
			{
				if ( this.moveDiag(depX, depY, finX, finY) )
				{
					if( dest.getPiece() != null && c.getPiece().getCoul() != dest.getPiece().getCoul() )
					{
						dest.changePiece(c.getPiece());
						c.changePiece(null);
						bouge = true;
					}
				}
			}
			if(dy == 1 && c.getPiece().getCoul() == 0)
			{
				if ( this.moveDiag(depX, depY, finX, finY) )
				{
					if( dest.getPiece() != null && c.getPiece().getCoul() != dest.getPiece().getCoul() )
					{
						dest.changePiece(c.getPiece());
						c.changePiece(null);
						bouge = true;
					}
				}
			}
		}
		
		// Promotion des pions a faire 
		if(bouge && (finY == 0 || finY == 7) )
		{
			io.promotion(dest);
			/*
			System.out.println("\nPromotion du pion :");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			if(str.charAt(0) == 'C')
			{
				dest.changePiece(new Cavalier(dest.getPiece().getCoul()));
			}
			else if(str.charAt(0) == 'T')
			{
				dest.changePiece(new Tour(dest.getPiece().getCoul()));
			}
			else if(str.charAt(0) == 'F')
			{
				dest.changePiece(new Fou(dest.getPiece().getCoul()));
			}
			else
			{
				dest.changePiece(new Reine(dest.getPiece().getCoul()));
			}
			sc.close();
			*/
		}
	}
	
	// Traite le cas du cavalier
	public void moveCavalier (int depX, int depY, int finX, int finY) {
		
		Case c = this.plateau[depX][depY];
		Case dest = this.plateau[finX][finY];
		
		if( dest.getPiece() == null)
		{
			dest.changePiece(c.getPiece());
			c.changePiece(null);
		}
		else if( c.getPiece().getCoul() != dest.getPiece().getCoul() )
		{
			dest.changePiece(c.getPiece());
			c.changePiece(null);
		}
	}
	
	// Déplace une piece
	public void movePiece (int depX, int depY, int finX, int finY) {
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
				this.movePion(depX, depY, finX, finY);
			}
			// Traite le cas du cavalier
			else if(c.getPiece().getClass() == Cavalier.class)
			{
				this.moveCavalier(depX, depY, finX, finY);
			}
			// traite les autres cas
			else if(dx == 0 || dy == 0)
			{
				if( this.moveLigne(depX, depY, finX, finY) )
				{
					// Test si la case destination n'a pas de piece
					if( dest.getPiece() == null )
					{
						dest.changePiece(c.getPiece());
						c.changePiece(null);
					}
					// Test si la couleur de la piece destination est différente de la piece de départ
					else if ( c.getPiece().getCoul() != dest.getPiece().getCoul() )
					{
						dest.changePiece(c.getPiece());
						c.changePiece(null);
					}
				}
			}
			else if(dx == dy || dx == -dy)
			{
				if ( this.moveDiag(depX, depY, finX, finY) )
				{
					if( dest.getPiece() == null )
					{
						dest.changePiece(c.getPiece());
						c.changePiece(null);
					}
					// Test si la couleur de la piece destination est différente de la piece de départ
					else if ( c.getPiece().getCoul() != dest.getPiece().getCoul() )
					{
						dest.changePiece(c.getPiece());
						c.changePiece(null);
					}
				}
			}
		}
	}
	
	
	// Retourne true si les coordonné sont dans la map, false sinon
	
	public boolean inMap (int depX, int depY, int finX, int finY) {
		if (depX >= 0 && depX < 8 && finX >= 0 && finX < 8
				&& depY >= 0 && depY < 8 && finY >= 0 && finY < 8)
		{
			return true;
		}
		return false;
	}
	
	
	// Déplacement en diagonale
	
	public boolean moveDiag (int depX, int depY, int finX, int finY) {
		int dx = depX - finX;
		int dy = depY - finY;
		Case c;
		// Test diagonale /
		if(dx == dy)
		{
			System.out.println(dx);
			if(dx > 0)
			{
				for(int i = depX + 1; i < finX; i++)
				{
					c = this.plateau[i][i];
					if(c.getPiece() != null)
					{
						return false;
					}
				}
				return true;
			}
			else
			{
				for(int i = depX - 1; i > finX; i--)
				{
					c = this.plateau[i][i];
					if(c.getPiece() != null)
					{
						return false;
					}
				}
				return true;
			}
		}
		// Test diagonale \
		else if(dx == -dy)
		{
			if(dx > 0)
			{
				for(int i = depX + 1, j = depY - 1; i < finX; i++, j--)
				{
					c = this.plateau[i][j];
					if(c.getPiece() != null)
					{
						return false;
					}
				}
				return true;
			}
			else
			{
				for(int i = depX - 1, j = depY + 1; j < finY; i--, j++)
				{
					c = this.plateau[i][j];
					if(c.getPiece() != null)
					{
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
	
	
	// Déplacement en ligne
	
	public boolean moveLigne (int depX, int depY, int finX, int finY) {
		int dx = depX - finX;
		int dy = depY - finY;
		Case c;
		// Test horizontale
		if(dx == 0)
		{
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
		
		// Test verticale
		if(dy == 0)
		{
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
		return false;
	}
	
	
	// Affichage
	
	public void afficher(){
        for (int j = 7; j >=0; j--){
            for (int i = 0; i < 8; i++){
                if(this.plateau[i][j].getPiece() != null)
                    System.out.print("[" + this.plateau[i][j].getPiece() + "]");
                else
                    System.out.print("[  ]");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
	
	// Getteur de piece
	public Piece getPiece (int x, int y) {
		return this.plateau[x][y].getPiece();
	}
	
}
