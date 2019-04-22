package projetJava;

public class Plateau {
	private Case[][] plateau;
	
	public Plateau () {
		this.plateau = new Case[8][8];
		
		for (int i = 7; i >=0; i--)
		{
            for (int j = 0; j < 8; j++)
            {
            	if( j == 0 )
                {
            		if(i == 4)
                	{
                		Case c = new Case(new Reine (0), i%2);
	                	this.plateau[i][j] = c;
                	}
            		else
            		{
	            		Case c = new Case(new Tour (0), i%2);
	       				this.plateau[i][j] = c;
            		}
                }
                else if ( j == 7 )
                {
                	if(i == 4)
                	{
                		Case c = new Case(new Reine (1), i%2);
	                	this.plateau[i][j] = c;
                	}
                	else
                	{
	                	Case c = new Case(new Fou (1), i%2);
	                	this.plateau[i][j] = c;
                	}
                }
                else
                {
                	Case c = new Case(null, i%2);
                	this.plateau[i][j] = c;
                }
            }
		}
	}
	
	// Déplace une piece
	public void movePiece (int depX, int depY, int finX, int finY) {
		int dx = depX - finX;
		int dy = depY - finY;
		
		Case c = this.plateau[depX][depY];
		Case dest = this.plateau[finX][finY];
		
		if(c.getPiece() != null 
				&& c.getPiece().movePiece(depX, depY, finX, finY)
				&& this.inMap(depX, depY, finX, finY)
				&& !( dx == 0 && dy == 0))
		{
			 if(dx == 0 || dy == 0)
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
			 if(dx == dy || dx == -dy)
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
		if(dx == dy)
		{
			if(dx > 0)
			{
				for(int i = depY + 1; i < finY; i++)
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
				for(int i = depY - 1; i > finY; i--)
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
		
		if(dx == -dy)
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
        for (int i = 7; i >=0; i--){
            for (int j = 0; j < 8; j++){
                if(this.plateau[j][i].getPiece() != null)
                    System.out.print("[" + this.plateau[j][i].getPiece() + "]");
                else
                    System.out.print("[vd]");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
	
}
