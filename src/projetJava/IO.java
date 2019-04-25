package projetJava;

import java.util.Scanner;

public class IO {
	
		private Scanner sc;

		private int x_depart;		// ** coordonnées de départ x ** //
		private int y_depart;		// ** coordonnées de départ y ** //
		private int x_cible;		// ** coordonnées cible x ** //
		private int y_cible;		// ** coordonnées cible y ** //
		
		public IO () {
			this.sc = new Scanner(System.in);
			
			this.x_depart = -1;
			this.x_cible = -1;
			this.y_depart = -1;
			this.y_cible = -1;
		}
		
		/*  Gère entré sortie
		 * 	while : - Test si les coordonnée sont dans la map
		 * 			- Test si la piece au coord de depart est de la bonne couleur (-1 si ya pas de piece)
		 * 			- Test si la piece peux bouger
		 */
		public boolean entryPiece (Plateau plateau, int couleur)
		{
			int coul_piece_depart;
			
		    do {
		        System.out.println("\nVeuillez saisir les coordonnées :");
		        String str = this.sc.nextLine();
		        if( this.quit(str) ) return false;
		        
		        this.x_depart = str.charAt(0) - 'a';
		        this.y_depart = str.charAt(1) - '1';
		        this.x_cible = str.charAt(2) - 'a';
		        this. y_cible = str.charAt(3) - '1';
		        
		        coul_piece_depart = -1;
		        
		        if (plateau.getPiece(this.x_depart, this.y_depart) != null)
		        {
		        	coul_piece_depart = plateau.getPiece(this.x_depart, this.y_depart).getCoul();
		        }
		        
		    } while ( !plateau.inMap(this.x_depart, this.y_depart, this.x_cible, this.y_cible)
		    			|| coul_piece_depart != couleur
		    			|| !plateau.movePiece(this.x_depart, this.y_depart, this.x_cible, this.y_cible) );
        	
			if(plateau.isEchec(couleur)){
				System.out.println("Echec !");
			}
		    return true;
		}
		
		/** Getteur du scanner pour le fermer
		 * 
		 * @return scanner
		 */
		public Scanner getScanner () {
			return this.sc;
		}
		
		
		/* Gère la promotion des pions
		 * 
		 */
		public void promotion (Case dest) {
			
			System.out.println("\nPromotion du pion :\n( C : Cavalier ), ( T : Tour ), ( F : Fou ), ( AUTRE : Dame/Reine )");
			String str = this.sc.nextLine();
			if(str.charAt(0) == 'C')
			{
				dest.changePiece(new Cavalier(dest.getPiece().getCoul()));
				System.out.println("Pion -> Cavalier");
			}
			else if(str.charAt(0) == 'T')
			{
				dest.changePiece(new Tour(dest.getPiece().getCoul()));
				System.out.println("Pion -> Tour");
			}
			else if(str.charAt(0) == 'F')
			{
				dest.changePiece(new Fou(dest.getPiece().getCoul()));
				System.out.println("Pion -> Fou");
			}
			else
			{
				dest.changePiece(new Reine(dest.getPiece().getCoul()));
				System.out.println("Pion -> Dame/Reine");
			}
		}
		
		
		/* Test si le joueur veux arrêter la partie
		 * 
		 */
		public boolean quit (String str) {
			if(str.equals("quit") || str.equals("q"))
			{
				return true;
			}
			return false;
		}
		
		/**
		 * Détermine qui sont les joueurs
		 */
		public String quiJoue () {
			String str;
			str = this.sc.nextLine();
			return str;
		}
}
