package fr.eseo.e3.poo.projet.blox.modele;

import java.util.*;

public class Tas {
    private final Puits puits;
    private final List<Element> elements;
    private int score;

    public Tas(Puits puits) {
        this.puits = puits;
        this.elements = new ArrayList<>();
        this.score = 0;
    }

    public Tas(Puits puits, int nbElements) {
        this(puits);
        construireTas(nbElements, (nbElements / puits.getLargeur()) + 1, new Random());
    }

    public Tas(Puits puits, int nbElements, int nbLignes) {
        this(puits);
        construireTas(nbElements, nbLignes, new Random());
    }

    public void construireTas(int nbElements, int nbLignes, Random rand) {
        int maxElements = puits.getLargeur() * nbLignes;
        if (nbElements >= maxElements && nbElements != 0) {
            throw new IllegalArgumentException("Impossible de générer plus d'éléments uniques que l'espace disponible ne le permet.");
        }

        Set<Coordonnees> usedCoordinates = new HashSet<>();
        while (elements.size() < nbElements) {
            int abs = rand.nextInt(puits.getLargeur());
            int ord = (puits.getProfondeur() - 1) - rand.nextInt(nbLignes);
            Coordonnees coord = new Coordonnees(abs, ord);
            if (usedCoordinates.add(coord)) {
                Element element = new Element(coord, Couleur.values()[rand.nextInt(Couleur.values().length)]);
                elements.add(element);
            }
        }
    }

    public List<Element> getElements() {
        return elements;
    }

    public Puits getPuits() {
        return puits;
    }

    public int getScore() {
        return score;
    }

    public boolean ajouterElements(Piece piece) {
        for (Element newElement : piece.getElements()) {
            for (Element existingElement : elements) {
                if (newElement.getCoordonnees().equals(existingElement.getCoordonnees())) {
                    return false; // Collision detected, game over
                }
            }
        }

        for (Element element : piece.getElements()) {
            elements.add(element);
        }
        clearLines();
        return true;
    }

    void clearLines() {
        int profondeur = puits.getProfondeur();
        int largeur = puits.getLargeur();
        int linesCleared = 0;

        for (int ord = 0; ord < profondeur; ord++) {
            List<Element> toRemove = new ArrayList<>();
            List<Element> toMoveDown = new ArrayList<>();
            long count = 0;
            for (Element element : elements) {
                if (element.getCoordonnees().getOrdonnee() == ord) {
                    count++;
                }
                if (element.getCoordonnees().getOrdonnee() == ord) {
                    toRemove.add(element);
                }
                if (element.getCoordonnees().getOrdonnee() < ord) {
                    toMoveDown.add(element);
                }
            }
            if (count == largeur) {
                elements.removeAll(toRemove);
                linesCleared++;
                for (Element element : toMoveDown) {
                    if (element.getCoordonnees().getOrdonnee() < ord) {
                        element.setCoordonnees(new Coordonnees(element.getCoordonnees().getAbscisse(), element.getCoordonnees().getOrdonnee() + 1));
                    }
                }
            }
        }
        if (linesCleared > 0) {
            score += calculateScore(linesCleared);
        }
    }

    private int calculateScore(int linesCleared) {
        int baseScore = 100;
        int multiplier = 1;
        for (int i = 0; i < linesCleared; i++){
            multiplier = multiplier * 2;
        }
        return baseScore * multiplier;
    }
}
