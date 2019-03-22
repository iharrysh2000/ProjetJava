
public class Plateau {
	private Case[][] tab;
	
	public Plateau() {
		tab = new Case[8][8];
		int i, j;
		for(i = 0; i < 8; ++i)
		{
			for(j = 0; j < 8; ++j)
			{
				tab[i][j] = new Case(null, "noir");
			}
		}
		for(i = 0; i < 8; ++i)
		{
			tab[i][1] = new Case(new Pion(i, 1, "blanc"), "noir");
		}
		tab[5][5] =  new Case(new Roi(5, 5, "blanc"), "noir"); 
	}
	
	public Case getCase(int largeur, int hauteur)
	{
		return tab[largeur][hauteur];
	}
	
	public Piece getPiece(int largeur, int hauteur)
	{
		return tab[largeur][hauteur].getPiece();
	}
}

