package projetJava;

import java.util.Scanner;

/**
 * Classe interface utilisateur entrée-sortie (IO = Input-Output)
 */
public class IO {

	private Undo undo;

	private Scanner sc;

	private int x_depart; // ** coordonnées de départ x ** //
	private int y_depart; // ** coordonnées de départ y ** //
	private int x_cible; // ** coordonnées cible x ** //
	private int y_cible; // ** coordonnées cible y ** //

	/**
	 * Contructeur de l'Interface
	 * 
	 * @param undo
	 */
	public IO(Undo undo) {
		this.undo = undo;
		this.sc = new Scanner(System.in);

		this.x_depart = -1;
		this.x_cible = -1;
		this.y_depart = -1;
		this.y_cible = -1;
	}

	/**
	 * Gestion entrée-sortie
	 * 
	 * @param plateau le plateau de jeu
	 * @param couleur la couleur de la pièce
	 * @param tours   le nombre de tours
	 * @return vrai si c'est bon et faux sinon
	 */
	public boolean entryPiece(Plateau plateau, int couleur, int tours) {
		int coul_piece_depart;
		Piece piece_depart;
		Piece piece_cible;

		do {
			System.out.println("\nVeuillez saisir les coordonnées :");
			String str = this.sc.nextLine();
			if (this.quit(str))
				return false;

			if (str.charAt(0) == 'u') {
				while (str.charAt(0) == 'u') {
					System.out.println("\nPress q to quit undo mode.");
					if (!this.undo.getPile_piece_depart().empty()) {
						piece_depart = this.undo.depile_piece_depart();
						piece_cible = this.undo.depile_piece_cible();

						Point point_depart = this.undo.depile_point_depart();
						Point point_cible = this.undo.depile_point_cible();

						plateau.getCase(point_depart.getX(), point_depart.getY()).changePiece(piece_depart);
						plateau.getCase(point_cible.getX(), point_cible.getY()).changePiece(piece_cible);
						tours--;
						plateau.afficher(tours);
					}
					if (this.quit(str))
						return true;
					str = this.sc.nextLine();
				}
				return true;
			}

			this.x_depart = str.charAt(0) - 'a';
			this.y_depart = str.charAt(1) - '1';
			this.x_cible = str.charAt(2) - 'a';
			this.y_cible = str.charAt(3) - '1';

			coul_piece_depart = -1;

			if (plateau.getPiece(this.x_depart, this.y_depart) != null) {
				coul_piece_depart = plateau.getPiece(this.x_depart, this.y_depart).getCoul();
			}

			piece_depart = plateau.getPiece(this.x_depart, this.y_depart);
			piece_cible = plateau.getPiece(this.x_cible, this.y_cible);

		} while (!plateau.inMap(this.x_depart, this.y_depart, this.x_cible, this.y_cible)
				|| coul_piece_depart != couleur
				|| !plateau.movePiece(this.x_depart, this.y_depart, this.x_cible, this.y_cible));
		/*
		 * Dans la boucle while : 
		 * - Test si les coordonnée sont dans la map 
		 * - Test si la piece au coord de depart est de la bonne couleur (-1 si ya pas de piece) 
		 * - Test si la piece peux bouger
		 */

		Point point_depart = new Point(this.x_depart, this.y_depart);
		Point point_cible = new Point(this.x_cible, this.y_cible);

		this.empile(point_depart, point_cible, piece_depart, piece_cible);

		return true;
	}

	/**
	 * Rajouter un moment du jeu à la pile
	 * 
	 * @param point_depart le point de départ
	 * @param point_cible  le point d'arrivée
	 * @param piece_depart la pièce avant
	 * @param piece_cible  la pièce après
	 */
	public void empile(Point point_depart, Point point_cible, Piece piece_depart, Piece piece_cible) {
		this.undo.enregistrer_coords(point_depart, point_cible);
		this.undo.enregistrer_piece(piece_depart, piece_cible);
	}

	/**
	 * Getteur du scanner pour le fermer
	 * 
	 * @return scanner
	 */
	public Scanner getScanner() {
		return this.sc;
	}

	/**
	 * Gestion de la promotion des pions
	 * 
	 * @param dest la case de destination
	 */
	public void promotion(Case dest) {

		System.out
				.println("\nPromotion du pion :\n( C : Cavalier ), ( T : Tour ), ( F : Fou ), ( AUTRE : Dame/Reine )");
		String str = this.sc.nextLine();
		if (str.charAt(0) == 'C') {
			dest.changePiece(new Cavalier(dest.getPiece().getCoul()));
			System.out.println("Pion -> Cavalier");
		} else if (str.charAt(0) == 'T') {
			dest.changePiece(new Tour(dest.getPiece().getCoul()));
			System.out.println("Pion -> Tour");
		} else if (str.charAt(0) == 'F') {
			dest.changePiece(new Fou(dest.getPiece().getCoul()));
			System.out.println("Pion -> Fou");
		} else {
			dest.changePiece(new Reine(dest.getPiece().getCoul()));
			System.out.println("Pion -> Dame/Reine");
		}
	}

	/**
	 * Test si le joueur veux arrêter la partie
	 * 
	 * @param str la chaine de caractères qui correspond à une commande
	 * @return vrai s'il s'agit d'une bonne commande et faux sinon
	 */
	public boolean quit(String str) {
		if (str.equals("quit") || str.equals("q")) {
			return true;
		}
		return false;
	}

	/**
	 * Détermine qui sont les joueurs
	 * 
	 * @return la chaine de caractères
	 */
	public String quiJoue() {
		String str;
		str = this.sc.nextLine();
		return str;
	}
}
