package in404.JeuEchec;

public class Plateau {


    /**Plateau du jeu en public**/
    public Piece[][] plateau;
    /**
     * Initialisation du plateau de jeu 8*8 cases
     */
    public Plateau(){
        plateau = new Piece[8][8];
    }

    /**
     * Initialise le plateau
     * @param plateau
     * @return plateau généré
     */
    public void InitPlateau(Plateau plateau){
        Piece tour1 = new Tour(new Point(0, 7), "Noir", "Tour1");
        Piece cavalier1 = new Cavalier(new Point(1,7),"Noir","Cavalier1");
        Piece fou1 = new Fou(new Point(2, 7), "Noir", "Fou1");
        Piece reine1 = new Reine(new Point(3,0),"Noir","Reine1");
        Piece roi1 = new Roi(new Point(4,0),"Noir","Roi1");
        Piece fou2 = new Fou(new Point(5,0),"Noir","Fou1");
        Piece cavalier2 = new Cavalier(new Point(6,0),"Noir","Cavalier2");
        Piece tour2 = new Tour(new Point(7,0),"Noir","Tour2");

        plateau.addPiece(tour1);
        plateau.addPiece(cavalier1);
        plateau.addPiece(fou1);
        plateau.addPiece(reine1);
        plateau.addPiece(roi1);
        plateau.addPiece(fou2);
        plateau.addPiece(cavalier2);
        plateau.addPiece(tour2);
    }
    /**
     * Affiche le plateau en txt
     */
    public void Afficher(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(this.plateau[j][i] != null)
                    System.out.print("[" + this.plateau[j][i] + "]");
                else
                    System.out.print("[void]");
            }
            System.out.println(" ");
        }
    }
    public void reset(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.plateau[i][j] = null;
            }
        }
    }
    /**
     * Ajoute une piece dans le plateau
     * @param piece la piece à ajouter dans une case.
     */
    public void addPiece(Piece piece) {
        this.plateau[piece.getPosition().getX()][piece.getPosition().getY()] = piece;
    }

    public Piece getPiece(int x, int y){
        if(this.plateau[x][y] == null)
            return null;
        return this.plateau[x][y];
    }

    /**
     * Permet de determiner
     * @param pointPosition
     * @param pointTarget
     * @return
     */
    public boolean movePiece(Point pointPosition,Point pointTarget){
        Piece p = this.plateau[pointPosition.getX()][pointPosition.getY()];

        if(p.movePossible(pointPosition,pointTarget) && this.plateau[pointTarget.getX()][pointTarget.getY()] == null){

            this.plateau[pointPosition.getX()][pointPosition.getY()] = null;
            this.plateau[pointTarget.getX()][pointTarget.getY()] = p;
            return true;

        }
        return false;
    }
}
