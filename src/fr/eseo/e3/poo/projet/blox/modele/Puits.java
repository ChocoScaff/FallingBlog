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
    private final PropertyChangeSupport pcs;

    /**
     *
     */
    public Puits() {
        this(LARGEUR_PAR_DEFAULT, PROFONDEUR_PAR_DEFAULT);
    }

    /**
     * @param largeur
     * @param profondeur
     */
    public Puits(int largeur, int profondeur) {
        this.largeur = largeur;
        this.profondeur = profondeur;
        this.tas = new Tas(this);
        this.pcs = new PropertyChangeSupport(this);
    }

    /**
     * @return
     */
    public Piece getPieceActuelle() {
        return this.pieceActuelle;
    }

    /**
     * @return
     */
    public Piece getPieceSuivante() {
        return this.pieceSuivante;
    }

    /**
     * @param piece
     */
    public void setPieceSuivante(Piece piece) {
        if (this.pieceSuivante == null) {
            this.pieceSuivante = piece;
        } else {
            Piece oldPieceActuelle = this.pieceActuelle;
            this.pieceActuelle = this.pieceSuivante;
            this.pieceSuivante = piece;
            pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, oldPieceActuelle, this.pieceActuelle);

            this.pieceActuelle.setPuits(this);
        }

        // Fire event for pieceSuivante in every case.
        pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, null, this.pieceSuivante);
    }

    /**
     * @return
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * @return
     */
    public int getProfondeur() {
        return profondeur;
    }

    /**
     * @param profondeur
     */
    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }

    /**
     * @param largeur
     */
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    public Tas getTas() {
        return tas;
    }

    private void gererCollision() {
        tas.ajouterElements(pieceActuelle);
        setPieceSuivante(new UsineDePiece().genererPiece());
    }

    public void gravite() {
        boolean moved = pieceActuelle.deplacerDe(0, 1);
        if (!moved) {
            gererCollision();
        }
    }
}
