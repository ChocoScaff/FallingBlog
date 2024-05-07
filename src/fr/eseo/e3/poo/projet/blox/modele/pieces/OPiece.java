package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.*;


public class OPiece extends Piece {
	/**
	 *
	 * @param coordonnees
	 * @param couleur
	 */
	public OPiece(Coordonnees coordonnees, Couleur couleur) {
		super(coordonnees, couleur);
	}

	/**
	 *
	 * @param coordonnees
	 * @param couleur
	 */
	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		elements.add(new Element(coordonnees, couleur));
		elements.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee()), couleur));
		elements.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() - 1), couleur));
		elements.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() - 1), couleur));
	}

	/**
	 *
	 * @param sensHorraire
	 */
	public void tourner(boolean sensHorraire) {
		System.out.println("OPiece ne peut pas tourner");
	}
}
