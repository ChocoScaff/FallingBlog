package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract public class Piece {
    protected Puits puits;
    protected List<Element> elements;

    /**
     * @param coordonnees
     * @param couleur
     */
    public Piece(Coordonnees coordonnees, Couleur couleur) {

        this.elements = new ArrayList<>();
        setElements(coordonnees, couleur);
    }

    /**
     * @param coordonnees
     * @param couleur
     */
    protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);

    /**
     * Get elements
     *
     * @return
     */
    public List<Element> getElements() {
        return Collections.unmodifiableList(elements);
    }

    /**
     * Set position
     *
     * @param abscisse
     * @param ordonnee
     */
    public void setPosition(int abscisse, int ordonnee) {
        Coordonnees ref = elements.get(0).getCoordonnes();
        int deltaAbscisse = abscisse - ref.getAbscisse();
        int deltaOrdonnee = ordonnee - ref.getOrdonnee();
        for (Element element : elements) {
            Coordonnees coord = element.getCoordonnes();
            element.setCoordonnees(new Coordonnees(coord.getAbscisse() + deltaAbscisse, coord.getOrdonnee() + deltaOrdonnee));
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
     *
     * @return
     */
    public Puits getPuits() {
        return puits;
    }

    /**
     * Set puits
     *
     * @param puits
     */
    public void setPuits(Puits puits) {
        this.puits = puits;
    }

    /**
     * @param deltaAbscisse
     * @param deltaOrdonnee
     */
    public boolean deplacerDe(int deltaAbscisse, int deltaOrdonnee) {
         if (deltaOrdonnee < 0) {
            throw new IllegalArgumentException("Invalid movement direction. Movement must be left, right, or down.");
        }

        for (Element element : elements) {
            int newX = element.getCoordonnes().getAbscisse() + deltaAbscisse;
            int newY = element.getCoordonnes().getOrdonnee() + deltaOrdonnee;

            if (newY < 0 || collisionDetected(newX, newY)) {
                return false;
            }
        }

        for (Element element : elements) {
            element.deplacerDe(deltaAbscisse, deltaOrdonnee);
        }

        return true;
    }

    private boolean collisionDetected(int x, int y) {
        if (x < 0 || x >= puits.getLargeur() || y >= puits.getProfondeur()) {
            return true;
        }

        for (Element element : puits.getTas().getElements()) {
            if (element.getCoordonnes().getAbscisse() == x && element.getCoordonnes().getOrdonnee() == y) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param sensHorraire
     */
    public void tourner(boolean sensHorraire) {
        Coordonnees pivot = elements.get(0).getCoordonnes();  // Get pivot element's coordinates
        int pivotAbscisse = pivot.getAbscisse();
        int pivotOrdonnee = pivot.getOrdonnee();

        for (Element element : elements) {
            int abscisse = element.getCoordonnes().getAbscisse() - pivotAbscisse;
            int ordonnee = element.getCoordonnes().getOrdonnee() - pivotOrdonnee;

            int nouveauAbscisse;
            int nouveauOrdonnee;

            if (sensHorraire) {
                // Rotation sensHorraire
                nouveauAbscisse = -ordonnee + pivotAbscisse;
                nouveauOrdonnee = abscisse + pivotOrdonnee;
            } else {
                // Rotation sensAntiHorraire
                nouveauAbscisse = ordonnee + pivotAbscisse;
                nouveauOrdonnee = -abscisse + pivotOrdonnee;
            }
            element.setCoordonnees(new Coordonnees(nouveauAbscisse, nouveauOrdonnee));
        }
    }
}
