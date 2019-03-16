
public class Terrain {
	private Pion[] P;

	public Terrain () {
		int i; char c = 'a';
		for(i = 0; i < 8; i++, c++)
		{
			P[i] = new Pion(i ,c);
		}
	}
	
	public Pion[] getPion() {
		return P;
	}
	
	public String getInfoPion(Pion A) {
		return  Integer.toString(+ A.getColonne()) + Integer.toString(A.getLigne());
	}
}
