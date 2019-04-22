package projetJava;
import java.util.Scanner;

/**
 * Classe Io permet la gestion des entrées sortie:
 * La classe contients des fonctions permettant la gestion des entrées claviers et effectue les modifications données par le joueur 
 * @author user
 *	
 */
public class Io {
	
	// ** coordonnées de départ x ** //
	private int x_depart;
	
	// ** coordonnées de départ y ** //
	private int y_depart;
	
	// ** coordonnées cible x ** //
	private int x_cible;
	
	// ** coordonnées cible y ** //
	private int y_cible;
	
	/**
	 * Lecture du clavier
	 * @param plateau plateau du jeu pour effectuer les modifications
	 */
	public void lireClavier(Plateau plateau){
		
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	entryPieceInit(plateau,sc);
        	entryPieceMove(plateau,sc);
        }
	}
	
	/**
	 * L'utilisateur entre des coordonnées et la fonction cheche la piece aux coordonnées données en entrée
	 * @param plateau plateau du jeu
	 * @param sc scanner permet de scanner le clavier
	 */
	public void entryPieceInit(Plateau plateau,Scanner sc)
	{
	    do {
	        System.out.println("Veuillez saisir les coordonnées position:");
	        String str = sc.nextLine();
	        x_depart = str.charAt(0);
	        y_depart = str.charAt(1);
	        System.out.println(plateau.getPiece(x_depart - 'a', y_depart - '1'));
	    } while (plateau.getPiece(x_depart - 'a', y_depart - '1') == null);
	}
	
	/**
	 * L'utilisateur rentre des coordonnées et va modifier le plateau de jeu
	 * @param plateau plateau du jeu
	 * @param sc scanner permet de scanner le calvier
	 */
	public void entryPieceMove(Plateau plateau,Scanner sc)
	{
	  do {
          System.out.println("Veuillez saisir les coordonnées cible:");
          String str = sc.nextLine();
          x_cible = str.charAt(0);
          y_cible = str.charAt(1);
      }while (!(plateau.getPiece(x_cible, y_cible).movePiece(x_depart, y_depart, x_cible, y_cible)));	
	}
}
