package projetJava;

public class Pion extends Piece {
	
	private final String nom = "P";
	private boolean move;

	public Pion (int couleur) {
		super(couleur);
		this.move = false;
	}
	
	@Override
	public String toString () {
		return this.nom + this.getCoul();
	}

	@Override
	public boolean movePiece(int depX, int depY, int finX, int finY) {
		int dx = finX - depX;
		int dy = finY - depY;
		
		if( this.getCoul() == 0 )
		{
			if( dx == 0 )
			{
				if (this.move && dy == 1)
				{
					return true;
				}
				else if(!this.move && (dy == 1 || dy == 2) )
				{
					this.move = true;
					return true;
				}
				else
					return false;
			}
			else if ( (dx == 1 || dx == -1) && dy == 1)
				return true;
			
			return false;
		}
		else if( this.getCoul() == 1 )
		{
			if( dx == 0 )
			{
				if (this.move && dy == -1)
				{
					return true;
				}
				else if( !this.move && (dy == -1 || dy == -2) )
				{
					this.move = true;
					return true;
				}
				else
					return false;
			}
			else if ( (dx == -1 || dx == 1) && dy == -1)
				return true;
			
			return false;
		}
		return false;
	}
}
