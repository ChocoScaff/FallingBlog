package fr.eseo.e3.poo.projet.blox.modele.pieces;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Piece;


public class TPiece extends Piece {


	public TPiece(Coordonnees coordonnees, Couleur couleur) {
		super(coordonnees, couleur);
	}


	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		elements.add(new Element(coordonnees, couleur));
		elements.add(new Element(new Coordonnees(coordonnees.getAbscisse() - 1, coordonnees.getOrdonnee()), couleur));
		elements.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee()), couleur));
		elements.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1), couleur));
	}
}
