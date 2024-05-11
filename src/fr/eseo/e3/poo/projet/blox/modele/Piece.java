package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract public class Piece {
	protected Puits puits;
	protected List<Element> elements;

	/**
	 *
	 * @param coordonnees
	 * @param couleur
	 */
	public Piece(Coordonnees coordonnees, Couleur couleur) {

		this.elements = new ArrayList<>();
		setElements(coordonnees, couleur);
	}

	/**
	 *
	 * @param coordonnees
	 * @param couleur
	 */
	protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

	/**
	 *  Get elements
	 * @return
	 */
	public List<Element> getElements() {
		return Collections.unmodifiableList(elements);
	}

	/**
	 * Set position
	 * @param abscisse
	 * @param ordonnee
	 */
    public void setPosition(int abscisse, int ordonnee) {
		Coordonnees ref = elements.get(0).getCoordonnes();
		int deltaX = abscisse - ref.getAbscisse();
		int deltaY = ordonnee - ref.getOrdonnee();
		for (Element el : elements) {
			Coordonnees coord = el.getCoordonnes();
			el.setCoordonnees(new Coordonnees(coord.getAbscisse() + deltaX, coord.getOrdonnee() + deltaY));
		}
    }

    /**
     * Override toString() method
     */
    public String toString() {
		StringBuilder sb = new StringBuilder(this.getClass().getSimpleName() + " :\n");
		for (Element element : elements) {
			sb.append("\t").append(element.toString()).append("\n");
		}
		return sb.toString();
    }

    /**
     * Get puits
     * @return
     */
    public Puits getPuits() {
        return puits;
    }

    /**
     * Set puits
     * @param puits
     */
    public void setPuits(Puits puits) {
        this.puits = puits;
    }

	/**
	 *
	 * @param deltaAbscisse
	 * @param deltaOrdonnee
	 */
	public void deplacerDe(int deltaAbscisse, int deltaOrdonnee) {

		for (int i = 0; i < elements.size(); i++) {
			Element element = elements.get(i);

			element.deplacerDe(deltaAbscisse, deltaOrdonnee);
		}
	}

	/**
	 *
	 * @param sensHorraire
	 */
	public void tourner(boolean sensHorraire) {
		Coordonnees pivot = elements.get(0).getCoordonnes();  // Get pivot element's coordinates
		int pivotX = pivot.getAbscisse();
		int pivotY = pivot.getOrdonnee();

		for (Element element : elements) {
			int x = element.getCoordonnes().getAbscisse() - pivotX;
			int y = element.getCoordonnes().getOrdonnee() - pivotY;

            int newX;
            int newY;

            if (sensHorraire) {
				// Rotate clockwise
				newX = -y + pivotX;
				newY = x + pivotY;
            } else {
				// Rotate counterclockwise
				newX = y + pivotX;
				newY = -x + pivotY;
            }
            element.setCoordonnees(new Coordonnees(newX, newY));
        }
	}
}
