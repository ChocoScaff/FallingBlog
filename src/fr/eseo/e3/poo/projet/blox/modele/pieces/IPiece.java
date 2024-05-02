package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;

public class IPiece extends Piece {

	public int[][] dimension;
		/**
		 *
		 * @param coordonnees
		 * @param couleur
		 */
		public IPiece(Coordonnees coordonnees, Couleur couleur) {
			super(coordonnees, couleur);
			super.dimension = new int[][] {{0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}, {0, 1, 0, 0}};		// TODO Auto-generated constructor stub
		}

}
