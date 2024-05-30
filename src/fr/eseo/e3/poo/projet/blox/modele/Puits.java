package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Puits {
    private static final int LARGEUR_PAR_DEFAULT = 10;
    private static final int PROFONDEUR_PAR_DEFAULT = 20;
    public static final String MODIFICATION_PIECE_ACTUELLE = "PieceActuelleChanged";
    public static final String MODIFICATION_PIECE_SUIVANTE = "PieceSuivanteChanged";

    private int largeur;
    private int profondeur;
    private Piece pieceActuelle;
    private Piece pieceSuivante;
    private final Tas tas;
    private final PropertyChangeSupport propertyChangeSupport;
    public boolean isGameOver = false;

    public Puits() {
        this(LARGEUR_PAR_DEFAULT, PROFONDEUR_PAR_DEFAULT);
    }

    public Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.tas = new Tas(this);
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public Piece getPieceActuelle() {
        return this.pieceActuelle;
    }

    public Piece getPieceSuivante() {
        return this.pieceSuivante;
    }

    public void setPieceSuivante(Piece piece) {
        if (this.pieceSuivante == null) {
            this.pieceSuivante = piece;
        } else {
            Piece oldPieceActuelle = this.pieceActuelle;
            this.pieceActuelle = this.pieceSuivante;
            this.pieceSuivante = piece;
            propertyChangeSupport.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, oldPieceActuelle, this.pieceActuelle);
        }
        propertyChangeSupport.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, null, this.pieceSuivante);

        if (this.pieceActuelle == null) {
            this.pieceActuelle = this.pieceSuivante;
            this.pieceSuivante = piece;
        }
        this.pieceActuelle.setPuits(this);
    }

    public int getLargeur() {
        return largeur;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public Tas getTas() {
        return tas;
    }


    public void gererCollision() {
        boolean addedSuccessfully = tas.ajouterElements(pieceActuelle);

        if (!addedSuccessfully) {
            isGameOver = true;
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

}
