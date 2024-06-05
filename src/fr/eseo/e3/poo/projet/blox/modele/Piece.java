package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract public class Piece {
    protected Puits puits;
    protected List<Element> elements;
    private int height;

    public Piece() {
        this.height = 0; // Initialisation par défaut
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

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
        Coordonnees ref = elements.get(0).getCoordonnees();
        int deltaAbscisse = abscisse - ref.getAbscisse();
        int deltaOrdonnee = ordonnee - ref.getOrdonnee();
        for (Element element : elements) {
            Coordonnees coord = element.getCoordonnees();
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

        //Mouvements en step de 1 par 1 pour une collision plus facile
        for (int i = 0; i < stepsAbscisse; i++) {
            for (Element element : elements) {
                int newAbscisse = element.getCoordonnees().getAbscisse() + directionAbscisse;
                int newOrdonnee = element.getCoordonnees().getOrdonnee();
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
                int newAbscisse = element.getCoordonnees().getAbscisse();
                int newOrdonnee = element.getCoordonnees().getOrdonnee() + directionOrdonnee;
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
        if (puits != null) {
            if (abscisse < 0 || abscisse >= puits.getLargeur() || ordonnee < 0 || ordonnee >= puits.getProfondeur()) {
                return true;
            }

            for (Element element : puits.getTas().getElements()) {
                if (element.getCoordonnees().getAbscisse() == abscisse && element.getCoordonnees().getOrdonnee() == ordonnee) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param rotation
     */
    public void tourner(Rotation rotation) {
        Coordonnees pivot = elements.get(0).getCoordonnees();
        int pivotAbscisse = pivot.getAbscisse();
        int pivotOrdonnee = pivot.getOrdonnee();

        List<Coordonnees> newCoordinates = new ArrayList<>();

        for (Element element : elements) {
            int abscisse = element.getCoordonnees().getAbscisse() - pivotAbscisse;
            int ordonnee = element.getCoordonnees().getOrdonnee() - pivotOrdonnee;

            int newAbscisse;
            int newOrdonnee;

            if (rotation == Rotation.HORRAIRE) {
                newAbscisse = pivotAbscisse - ordonnee;
                newOrdonnee = pivotOrdonnee + abscisse;
            } else if (rotation == Rotation.ANTIHORRAIRE) {
                newAbscisse = pivotAbscisse + ordonnee;
                newOrdonnee = pivotOrdonnee - abscisse;
            } else {
                return; // Unknown rotation type
            }

            newCoordinates.add(new Coordonnees(newAbscisse, newOrdonnee));
        }

        // Vérifiez les collisions avant de définir les nouvelles coordonnées
        for (Coordonnees coord : newCoordinates) {
            if (collisionDetected(coord.getAbscisse(), coord.getOrdonnee())) {
                return;
            }
        }

        for (int i = 0; i < elements.size(); i++) {
            elements.get(i).setCoordonnees(newCoordinates.get(i));
        }
    }

    private List<Coordonnees> getCoordonneesList(List<Element> elements) {
        List<Coordonnees> coordList = new ArrayList<>();
        for (Element element : elements) {
            coordList.add(element.getCoordonnees());
        }
        return coordList;
    }
}
