
public class Main {

	public static void main(String[] args) {
		Terrain T = new Terrain();
		Pion[] P;
		P = T.getPion();
		System.out.println(T.getInfoPion(P[1]));
	}

}
