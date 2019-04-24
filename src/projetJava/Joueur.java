package projetJava;

import java.util.Scanner;

/**
 * Classe Joueur qui indique qui sont les joueurs
 */
public class Joueur {
	
	private Scanner sc; //scanner pour lire qui joue
	private char j1; //représente le joueur 1
	private char j2; //repréente le joueur 2
	
	/**
	 * Constructeur du joueur
	 */
	public Joueur () {
		this.sc = new Scanner(System.in);
		this.j1 = '0'; //juste pour initialiser
		this.j2 = '0'; //juste pour initialiser
	}
	
	/**
	 * Détermine qui sont les joueurs
	 */
	public boolean quiJoue () {
		System.out.println("\nLe jeu se joue à 2. Ecrivez : "
				+ "\n HO pour une partie Humain VS Ordinateur"
				+ "\n HH pour une partie Humain VS Humain"
				+ "\n OO pour une partie Ordinateur VS Ordinateur");
		String str = this.sc.nextLine();
		j1 = str.charAt(0);
		j2 = str.charAt(1);
		if ((j1 == 'H' && j2 == 'O') || (j1 == j2)){
			return true;
		}
		else {
			System.out.println("ERREUR : Mauvaise commande. Veuillez taper une des 3 commandes");
			return false;
		}
	}
}
