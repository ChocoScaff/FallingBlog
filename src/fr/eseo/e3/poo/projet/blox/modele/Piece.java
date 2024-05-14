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

        int stepsX = Math.abs(deltaAbscisse);
        int stepsY = Math.abs(deltaOrdonnee);
        int directionX = (deltaAbscisse > 0) ? 1 : -1;
        int directionY = (deltaOrdonnee > 0) ? 1 : -1;

        boolean moved = false;

        for (int i = 0; i < stepsX; i++) {
            for (Element element : elements) {
                int newX = element.getCoordonnes().getAbscisse() + directionX;
                int newY = element.getCoordonnes().getOrdonnee();
                if (collisionDetected(newX, newY)) {
                    return moved;
                }
            }
            for (Element element : elements) {
                element.deplacerDe(directionX, 0);
            }
            moved = true;
        }

        for (int i = 0; i < stepsY; i++) {
            for (Element element : elements) {
                int newX = element.getCoordonnes().getAbscisse();
                int newY = element.getCoordonnes().getOrdonnee() + directionY;
                if (collisionDetected(newX, newY)) {
                    return moved;
                }
            }
            for (Element element : elements) {
                element.deplacerDe(0, directionY);
            }
            moved = true;
        }

        return moved;
    }


    private boolean collisionDetected(int x, int y) {
        if (x < 0 || x >= puits.getLargeur() || y < 0 || y >= puits.getProfondeur()) {
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
    public boolean tourner(boolean sensHorraire) {
        Coordonnees pivot = elements.get(0).getCoordonnes();  // Get pivot element's coordinates
        int pivotX = pivot.getAbscisse();
        int pivotY = pivot.getOrdonnee();

        List<Coordonnees> newCoordinates = new ArrayList<>();

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

            if (collisionDetected(newX, newY)) {
                return false;
            }

            newCoordinates.add(new Coordonnees(newX, newY));
        }

        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).setCoordonnees(newCoordinates.get(i));
        }

        return true;
    }
}
