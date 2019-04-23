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
	        	this.entryPiece (plateau);
	        	plateau.afficher();
	        }
		}
		
		/*  Gère entré sortie
		 * 
		 */
		public void entryPiece (Plateau plateau)
		{
		    do {
		        System.out.println("Veuillez saisir les coordonnées :");
		        String str = this.sc.nextLine();
		        this.x_depart = str.charAt(0) - 'a';
		        this.y_depart = str.charAt(1) - '1';
		        this.x_cible = str.charAt(2) - 'a';
		        this. y_cible = str.charAt(3) - '1';
		    } while (!plateau.inMap(this.x_depart, this.y_depart, this.x_cible, this.y_cible) || plateau.getPiece(this.x_depart, this.y_depart) == null);
		    
		    // Bouge la piece
		    plateau.movePiece(this.x_depart, this.y_depart, this.x_cible, this.y_cible);
		}
		
		/** Getteur du scanner pour le fermer
		 * 
		 * @return scanner
		 */
		public Scanner getScanner () {
			return this.sc;
		}
		
		
		/* Gère la promotion des pion
		 * 
		 */
		public void promotion (Case dest) {
			
			System.out.println("\nPromotion du pion :");
			String str = this.sc.nextLine();
			if(str.charAt(0) == 'C')
			{
				dest.changePiece(new Cavalier(dest.getPiece().getCoul()));
			}
			else if(str.charAt(0) == 'T')
			{
				dest.changePiece(new Tour(dest.getPiece().getCoul()));
			}
			else if(str.charAt(0) == 'F')
			{
				dest.changePiece(new Fou(dest.getPiece().getCoul()));
			}
			else
			{
				dest.changePiece(new Reine(dest.getPiece().getCoul()));
			}
		}
}
