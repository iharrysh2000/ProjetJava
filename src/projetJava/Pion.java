package projetJava;

/**
 * Sous-classe Pion qui correspond au type de pièce Pion
 */
public class Pion extends Piece {
	
	private final String nom = "P";
	
	/**
	 * Constructeur du pion
	 * @param couleur la couleur du pion
	 */
	public Pion (int couleur) {
		super(couleur);
	}
	
	@Override
	public String toString () {
		return this.nom + this.getCoul();
	}
	
	/**
	 * Retourne la chaine de caractères composé du nom et de la couleur du pion
	 * @return le nom et la couleur du pion
	 */
	@Override
	public boolean movePiece(int depX, int depY, int finX, int finY) {
		int dx = finX - depX;
		int dy = finY - depY;
		
		if( this.getCoul() == 0 )
		{
			if( dx == 0 )
			{
				if (this.getMove() && dy == 1)
				{
					return true;
				}
				else if(!this.getMove() && (dy == 1 || dy == 2) )
				{
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
				if (this.getMove() && dy == -1)
				{
					return true;
				}
				else if( !this.getMove() && (dy == -1 || dy == -2) )
				{
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
