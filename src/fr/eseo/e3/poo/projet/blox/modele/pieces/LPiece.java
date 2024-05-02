package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;

public class LPiece extends Piece {

    public int[][] dimension;
    /**
     *
     * @param coordonnees
     * @param couleur
     */
    public LPiece(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
        super.dimension = new int[][] {{0, 1, 0}, {0, 1, 0}, {1, 1, 0}};		// TODO Auto-generated constructor stub
    }

}
