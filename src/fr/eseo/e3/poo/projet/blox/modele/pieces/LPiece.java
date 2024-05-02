package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;

public class LPiece extends Piece {

    private int[][] dimension;
    /**
     *
     * @param coordonnees
     * @param couleur
     */
    public LPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
        this.dimension = new int[][] {{1, 0}, {1, 0}, {1, 1}};		// TODO Auto-generated constructor stub
    }

    /**
     *
     * @return
     */
    public int[][] getDimension () {
        return this.dimension;
    }

}
