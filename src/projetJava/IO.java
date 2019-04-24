package projetJava;

import java.util.Scanner;

public class IO {
	
		private Scanner sc;

		private int x_depart;		// ** coordonnées de départ x ** //
		private int y_depart;		// ** coordonnées de départ y ** //
		private int x_cible;		// ** coordonnées cible x ** //
		public int y_cible;		// ** coordonnées cible y ** //
		
		private Undo undo;
		
		public IO () {
			this.sc = new Scanner(System.in);
			
			this.x_depart = -1;
			this.x_cible = -1;
			this.y_depart = -1;
			this.y_cible = -1;
			this.undo = new Undo();
		}
		
		/**
		 * Lecture du clavier
		 * @param plateau 	plateau du jeu pour effectuer les modifications
		 */
		public void lireClavier(Plateau plateau){
			int tours = 0;
	        while(true)
	        {
	        	this.entryPiece (plateau, tours%2);
	        	System.out.println(">save piece:"  + this.undo.getPile_point_cible());
	        	System.out.println(">les joueurs hors jeu" + this.undo.getPile_piece());
	        	plateau.afficher(tours);
	        	tours++;
	        }
		}
		
		/*  Gère entré sortie
		 * 	while : - Test si les coordonnée sont dans la map
		 * 			- Test si la piece au coord de depart est de la bonne couleur (-1 si ya pas de piece)
		 * 			- Test si la piece peux bouger
		 */
		public void entryPiece (Plateau plateau, int couleur)
		{
			int coul_piece_depart;
			
		    do {
		        System.out.println("\nVeuillez saisir les coordonnées :");
		        String str = this.sc.nextLine();
		        
		        if(str.equals("undo")) {
		        	if(this.undo.getPile_point_cible().isEmpty()) return; // On verifie pour une pile
		        	Point point_cible = this.undo.depile_point_cible();
		        	if(plateau.getPiece(point_cible.getX(), point_cible.getY()) == null) { // Si case vide alors la pièce à cette endroit à été mangé donc il faut la remettre dans le plateau
		        		Piece piece = this.undo.depile_piece();
		        		plateau.addObject(piece,point_cible);
		        	}
		        	Point point_depart = this.undo.depile_point_depart();
		        	plateau.retour_arriere(point_cible, point_depart);
		        	return;
		        }
		        
		        this.x_depart = str.charAt(0) - 'a';
		        this.y_depart = str.charAt(1) - '1';
		        this.x_cible = str.charAt(2) - 'a';
		        this.y_cible = str.charAt(3) - '1';
		        
		        coul_piece_depart = -1;
		        
		        if (plateau.getPiece(this.x_depart, this.y_depart) != null)
		        {
		        	coul_piece_depart = plateau.getPiece(this.x_depart, this.y_depart).getCoul();
		        }
		        
		    } while ( !plateau.inMap(this.x_depart, this.y_depart, this.x_cible, this.y_cible)
		    			|| coul_piece_depart != couleur
		    			|| !plateau.movePiece(this.x_depart, this.y_depart, this.x_cible, this.y_cible) );
		    
		    this.undo.enregistrer_coords(new Point(x_depart,y_depart),new Point(x_cible,y_cible)); 
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
		
}
