package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.Piece;



public class UsineDePiece {


    public enum Mode{
        ALEATOIRE_COMPLET,
        ALEATOIRE_PIECE,
        CYCLIC
    }

    private Mode mode;


    public UsineDePiece() {

    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Piece genererPiece() {

        if (this.mode == Mode.ALEATOIRE_COMPLET)
            return null;
        else if (this.mode == Mode.ALEATOIRE_PIECE)
            return null;
        else if (this.mode == Mode.CYCLIC)
            return null;
    }
}
