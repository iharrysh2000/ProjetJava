package projetJava;

public class Plateau {
	private Case[][] plateau;
	
	// Initialise le plateau
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
	            		c = new Case(null, (i+j)%2);
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
	            		c = new Case(null, (i+j)%2);
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
	
	// Pion
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
						this.movePiece(c, dest);
						bouge = true;
					}
				}
			}
		}

		// Promotion des pions a faire 
		if(bouge && (finY == 0 || finY == 7) )
		{
			IO tmp = new IO();
			tmp.promotion(dest);
		}
		
		return bouge;
	}
	
	// Traite le cas du cavalier
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
	
	// Déplace une piece
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
	
	
	// Déplacement en ligne
	
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
	
	
	// Affichage
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
	
	// Getteur de piece
	public Piece getPiece (int x, int y) {
		return this.plateau[x][y].getPiece();
	}
	
	// Getteur de pos d'une piece
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
	
	public void movePiece (Case c, Case dest) {
		dest.changePiece(c.getPiece());
		c.changePiece(null);
	}
	
	
	public boolean isEchec(int couleur) {
		Point point = new Point(this.findKing(couleur).getX(),this.findKing(couleur).getY());
		System.out.println(this.haveDiagonal(point,couleur ^ 1));
		return true;
	}
	
	public Point findKing(int couleur) {
		for( int i = 0 ; i < 8 ; i++) 
		{
			for( int j = 0 ; j < 8 ; j++) 
			{
				if(this.plateau[i][j].getPiece() != null)
				{
					if(this.plateau[i][j].getPiece().toString().equals("R" + couleur)) {
						return new Point(i,j);
					}
				}
			}
		}
		return new Point(-1,-1); // Afficher erreurs roi non trouvé
	}
	
	public boolean haveHV(final Point point,int couleur) {
		
		for( int x = point.getX() ; x < 8 ; x++) {
			if(this.plateau[x][point.getY()].getPiece() != null) {
				
				if(this.plateau[x][point.getY()].getPiece().toString().equals("T" + couleur)
						|| this.plateau[x][point.getY()].getPiece().toString().equals("D" + couleur)){
					return true;
				}
				if(this.plateau[x][point.getY()].getPiece().getCoul() != couleur
						&& x != point.getX()) {
					break;
				}
			}
		}
		for( int x = point.getX() ; x > 0 ; x--) {
			if(this.plateau[x][point.getY()].getPiece() != null) {
				if(this.plateau[x][point.getY()].getPiece().toString().equals("T" + couleur)
						|| this.plateau[x][point.getY()].getPiece().toString().equals("D" + couleur)){
					return true;
				}
				if(this.plateau[x][point.getY()].getPiece().getCoul() != couleur
						&& x != point.getX()) {
					break;
				}
			}
		}
		for( int y = point.getY() ; y < 8 ; y++) {
			if(this.plateau[point.getX()][y].getPiece() != null) {
				if(this.plateau[point.getX()][y].getPiece().toString().equals("T" + couleur)
						|| this.plateau[point.getX()][y].getPiece().toString().equals("D" + couleur)){
					return true;
				}
				if(this.plateau[point.getX()][y].getPiece().getCoul() != couleur
						&& y != point.getY()) {
					break;
				}
			}
		}
		for( int y = point.getY() ; y > 0; y--) {
			if(this.plateau[point.getX()][y].getPiece() != null) {
				if(this.plateau[point.getX()][y].getPiece().toString().equals("T" + couleur)
						|| this.plateau[point.getX()][y].getPiece().toString().equals("D" + couleur)){
					return true;
				}
				if(this.plateau[point.getX()][y].getPiece().getCoul() != couleur
						&& y != point.getY()) {
					break;
				}
			}
		}
		return false;
	}
	
	public boolean haveDiagonal(final Point point,int couleur) {
		
		for( int x = point.getX(),y = point.getY() ; x < 8 && y < 8 ; x++,y++) {
			if(this.plateau[x][y].getPiece() != null) {
				if(this.plateau[x][y].getPiece().toString().equals("F" + couleur)
						|| this.plateau[x][y].getPiece().toString().equals("D" + couleur)){
					return true;
				}
				if(this.plateau[x][y].getPiece().getCoul() != couleur
						&& (x!=point.getX() && y != point.getY())) {
					break;
				}
			}
		}
		for( int x = point.getX(),y = point.getY() ; x > 0 && y < 8 ; x--,y++) {
			if(this.plateau[x][y].getPiece() != null) {
				if(this.plateau[x][y].getPiece().toString().equals("F" + couleur)
						|| this.plateau[x][y].getPiece().toString().equals("D" + couleur)){
					return true;
				}
				if(this.plateau[x][y].getPiece().getCoul() != couleur
						&& (x!=point.getX() && y != point.getY())) {
					break;
				}
			}
		}
		
		for( int x = point.getX(),y = point.getY() ; x < 8 && y > 0 ; x++,y-- ) {
			System.out.println(x + " " + y);
			if(this.plateau[x][y].getPiece() != null) {
				if(this.plateau[x][y].getPiece().toString().equals("F" + couleur)
						|| this.plateau[x][y].getPiece().toString().equals("D" + couleur)){
					return true;
				}
				if(this.plateau[x][y].getPiece().getCoul() != couleur
						&& (x!=point.getX() && y != point.getY())) {
					break;
				}
			}
		}
		for( int x = point.getX(),y = point.getY() ; x > 0 && y > 0 ; x--,y--) {
			if(this.plateau[x][y].getPiece() != null) {
				if(this.plateau[x][y].getPiece().toString().equals("F" + couleur)
						|| this.plateau[x][y].getPiece().toString().equals("D" + couleur)){
					return true;
				}
				if(this.plateau[x][y].getPiece().getCoul() != couleur
						&& (x!=point.getX() && y != point.getY())) {
					break;
				}
			}
		}
		return false;
	}
	
	public boolean haveCavalier() {
		return true;
	}
	
	public boolean havePion() {
		return true;
	}
}
