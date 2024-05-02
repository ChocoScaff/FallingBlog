package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;

public class IPiece extends Piece {

	private int[][] dimension;
		/**
		 *
		 * @param coordonnees
		 * @param couleur
		 */
		public IPiece(Coordonnees coordonnees, Couleur couleur) {
			super(coordonnees, couleur);
			this.dimension = new int[][] {{1}, {1}, {1}, {1}};		// TODO Auto-generated constructor stub
		}

	/**
	 *
	 * @return
	 */
	public int[][] getDimension () {
		return this.dimension;
	}

}
