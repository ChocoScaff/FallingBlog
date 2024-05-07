package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;


public class UsineDePiece {


    public enum Mode{
        ALEATOIRE_COMPLET,
        ALEATOIRE_PIECE,
        CYCLIC
    }

    private Mode mode;
    private static final int NUM_DE_TYPE_DE_PIECE = 2;
    private int semiRandomIndex = -1;
    private int cycleIndex = 0;

    /**
     *
     */
    public UsineDePiece() {
        this.mode = Mode.ALEATOIRE_COMPLET;

    }

    /**
     *
     * @param mode
     */
    public void setMode(Mode mode) {
        this.mode = mode;
    }

    /**
     *
     * @return
     */
    public Piece genererPiece() {
        Coordonnees coordonnees = new Coordonnees(2,3);
        Couleur couleur = Couleur.BLEU;
        Piece piece = null;

        if (this.mode == Mode.ALEATOIRE_COMPLET){
            int randomIndex = (int) (Math.random() * NUM_DE_TYPE_DE_PIECE);
            piece = this.pieceTypes(randomIndex, coordonnees, couleur);
        }

        else if (this.mode == Mode.ALEATOIRE_PIECE){
            int oldSemiRandomIndex = this.semiRandomIndex;
            while (this.semiRandomIndex == oldSemiRandomIndex){
                this.semiRandomIndex = (int) (Math.random() * NUM_DE_TYPE_DE_PIECE);
            }

            piece = this.pieceTypes(semiRandomIndex, coordonnees, couleur);

        }

        else if (this.mode == Mode.CYCLIC){
            piece = this.pieceTypes(this.cycleIndex, coordonnees, couleur);
            if(this.cycleIndex < NUM_DE_TYPE_DE_PIECE){cycleIndex += 1;}
            else {this.cycleIndex = 0;}

        }

        return piece;
    }

    public Piece pieceTypes(int index, Coordonnees coordonnees, Couleur couleur){
        Piece piece = null;
        switch (index) {
            case 0:
                piece = new LPiece(coordonnees, couleur);
                break;

            case 1:
                piece = new OPiece(coordonnees, couleur);
                break;

        }
        return piece;
    }
}
