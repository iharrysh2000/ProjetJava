package projetJava;

import java.util.Scanner;

public class IO {
	
		private Scanner sc;

		// ** coordonnées de départ x ** //
		private int x_depart;
		
		// ** coordonnées de départ y ** //
		private int y_depart;
		
		// ** coordonnées cible x ** //
		private int x_cible;
		
		// ** coordonnées cible y ** //
		private int y_cible;
		
		public IO () {
			this.sc = new Scanner(System.in);
			this.x_depart = -1;
			this.x_cible = -1;
			this.y_depart = -1;
			this.y_cible = -1;
		}
		
		/**
		 * Lecture du clavier
		 * @param plateau 	plateau du jeu pour effectuer les modifications
		 */
		public void lireClavier(Plateau plateau){
		
	        while(true)
	        {
	        	entryPieceInit(plateau);
	        	entryPieceMove(plateau);
	        	plateau.afficher();
	        }
		}
		
		/**
		 * L'utilisateur entre des coordonnées et la fonction cheche la piece aux coordonnées données en entrée
		 * @param plateau 	plateau du jeu
		 * @param sc 		scanner permet de scanner le clavier
		 */
		public void entryPieceInit(Plateau plateau)
		{
		    do {
		        System.out.println("Veuillez saisir les coordonnées position:");
		        String str = this.sc.nextLine();
		        this.x_depart = str.charAt(0) - 'a';
		        this.y_depart = str.charAt(1) - '1';
		        System.out.println(plateau.getPiece(this.x_depart, this.y_depart));
		    } while (plateau.getPiece(this.x_depart, this.y_depart) == null);
		}
		
		/**
		 * L'utilisateur rentre des coordonnées et va modifier le plateau de jeu
		 * @param plateau 	plateau du jeu
		 * @param sc 		scanner permet de scanner le calvier
		 */
		public void entryPieceMove(Plateau plateau)
		{
		  //do {
	          System.out.println("Veuillez saisir les coordonnées cible:");
	          String str = this.sc.nextLine();
	          this.x_cible = str.charAt(0) - 'a';
	          this. y_cible = str.charAt(1) - '1';
		  //}while (!(plateau.getPiece(this.x_depart, this.y_depart).movePiece(this.x_depart, this.y_depart, this.x_cible, this.y_cible)));
		  plateau.movePiece(this.x_depart, this.y_depart, this.x_cible, this.y_cible);
		}
}
