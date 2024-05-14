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

        int stepsAbscisse = Math.abs(deltaAbscisse);
        int stepsOrdonnee = Math.abs(deltaOrdonnee);
        int directionAbscisse = (deltaAbscisse > 0) ? 1 : -1;
        int directionOrdonnee = (deltaOrdonnee > 0) ? 1 : -1;

        boolean moved = false;

        for (int i = 0; i < stepsAbscisse; i++) {
            for (Element element : elements) {
                int newAbscisse = element.getCoordonnes().getAbscisse() + directionAbscisse;
                int newOrdonnee = element.getCoordonnes().getOrdonnee();
                if (collisionDetected(newAbscisse, newOrdonnee)) {
                    return moved;
                }
            }
            for (Element element : elements) {
                element.deplacerDe(directionAbscisse, 0);
            }
            moved = true;
        }

        for (int i = 0; i < stepsOrdonnee; i++) {
            for (Element element : elements) {
                int newAbscisse = element.getCoordonnes().getAbscisse();
                int newOrdonnee = element.getCoordonnes().getOrdonnee() + directionOrdonnee;
                if (collisionDetected(newAbscisse, newOrdonnee)) {
                    return moved;
                }
            }
            for (Element element : elements) {
                element.deplacerDe(0, directionOrdonnee);
            }
            moved = true;
        }

        return moved;
    }

    private boolean collisionDetected(int abscisse, int ordonnee) {
        if (abscisse < 0 || abscisse >= puits.getLargeur() || ordonnee < 0 || ordonnee >= puits.getProfondeur()) {
            return true;
        }

        for (Element element : puits.getTas().getElements()) {
            if (element.getCoordonnes().getAbscisse() == abscisse && element.getCoordonnes().getOrdonnee() == ordonnee) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param rotation
     */
    public boolean tourner(Rotation rotation) {
        Coordonnees pivot = elements.get(0).getCoordonnes();
        int pivotAbscisse = pivot.getAbscisse();
        int pivotOrdonnee = pivot.getOrdonnee();

        List<Coordonnees> newCoordinates = new ArrayList<>();

        for (Element element : elements) {
            int abscisse = element.getCoordonnes().getAbscisse() - pivotAbscisse;
            int ordonnee = element.getCoordonnes().getOrdonnee() - pivotOrdonnee;

            int newAbscisse;
            int newOrdonnee;

            if (rotation == Rotation.HORRAIRE) {
                newAbscisse = -ordonnee + pivotAbscisse;
                newOrdonnee = abscisse + pivotOrdonnee;
            } else {
                newAbscisse = ordonnee + pivotAbscisse;
                newOrdonnee = -abscisse + pivotOrdonnee;
            }

            if (collisionDetected(newAbscisse, newOrdonnee)) {
                return false;
            }

            newCoordinates.add(new Coordonnees(newAbscisse, newOrdonnee));
        }

        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).setCoordonnees(newCoordinates.get(i));
        }

        return true;
    }
}
