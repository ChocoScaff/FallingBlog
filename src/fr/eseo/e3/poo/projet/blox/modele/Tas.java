package fr.eseo.e3.poo.projet.blox.modele;

public class Tas {

    Puits puits;
    int nbElements;
    int nbLignes;
    int[][] Element;

    public Tas(Puits puits) {
        this.puits = puits;
    }

    public Tas(Puits puits, int nbElements) {
        this.puits = puits;
        this.nbElements = nbElements;
    }

    public Tas(Puits puits, int nbElements, int nbLignes) {
        this.puits = puits;
        this.nbElements = nbElements;
        this.nbLignes = nbLignes;
    }

    public Puits getPuits() {
        return this.puits;
    }

    public int[][] getElements() {
        return this.Element;
    }

    private void constuireTas(int nbElements, int nbLignes, java.util.Random rand) {
        //TODO wrte func
    }
}
