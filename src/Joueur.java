
public class Joueur {
	private String couleur;
	private String nom;
	
	public Joueur(String nom, String couleur)
	{
		this.nom = nom;
		this.couleur = couleur;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getCouleur() {
		return this.couleur;
	}
}
