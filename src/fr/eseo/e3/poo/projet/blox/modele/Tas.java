package fr.eseo.e3.poo.projet.blox.modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tas {
    private final Puits puits;
    private final List<Element> elements;
    private int nbElements;
    private int nbLignes;

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
        this.nbElements = nbElements;
        this.nbLignes = nbLignes;
        for (int i = 0; i < nbElements; i++) {// probleme les element generer peuve etre au meme coord q'un autre element
            int abs = rand.nextInt(puits.getLargeur());
            int ord = (puits.getProfondeur() - 1) - rand.nextInt(nbLignes);
            Element element = new Element(new Coordonnees(abs, ord), Couleur.values()[rand.nextInt(Couleur.values().length)]);
            elements.add(element);
        }
    }

    public List<Element> getElements() {
        return elements;
    }

    public Puits getPuits() {
        return puits;
    }
}
