package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Tas {
    private final Puits puits;
    private final List<Element> elements;

    public Tas(Puits puits) {
        this.puits = puits;
        this.elements = new ArrayList<>();
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
        Set<Coordonnees> usedCoordinates = new HashSet<>();
        while (elements.size() < nbElements) {
            int abs = rand.nextInt(puits.getLargeur());
            int ord = (puits.getProfondeur() - 1) - rand.nextInt(nbLignes);
            Coordonnees coord = new Coordonnees(abs, ord);
            if (!usedCoordinates.contains(coord)) {
                Element element = new Element(coord, Couleur.values()[rand.nextInt(Couleur.values().length)]);
                elements.add(element);
                usedCoordinates.add(coord);
            }
        }

        if (elements.size() < nbElements) {
            throw new IllegalStateException("Could not generate the required number of elements with unique coordinates.");
        }
    }

    public List<Element> getElements() {
        return elements;
    }

    public Puits getPuits() {
        return puits;
    }

    public void ajouterElements(Piece piece) {
        for (Element element : piece.getElements()) {
            elements.add(element);
        }
    }
}
