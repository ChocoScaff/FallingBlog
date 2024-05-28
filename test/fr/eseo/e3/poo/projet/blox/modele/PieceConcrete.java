package fr.eseo.e3.poo.projet.blox.modele;

public class PieceConcrete extends Piece {
    public PieceConcrete(Coordonnees coordonnees, Couleur couleur) {
        super(coordonnees, couleur);
    }

    @Override
    protected void setElements(Coordonnees coordonnees, Couleur couleur) {
        // Pour simplifier, nous allons créer une pièce simple de 2x2 blocs pour les tests
        elements.add(new Element(coordonnees, couleur));
        elements.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee()), couleur));
        elements.add(new Element(new Coordonnees(coordonnees.getAbscisse(), coordonnees.getOrdonnee() + 1), couleur));
        elements.add(new Element(new Coordonnees(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee() + 1), couleur));
    }
}