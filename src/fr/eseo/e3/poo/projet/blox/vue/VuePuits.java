package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.modele.*;
import java.awt.*;
import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VuePuits extends JPanel implements PropertyChangeListener {
    public static final int MARGE = 20;
    public static final int TAILLE_PAR_DEFAUT = 700;
    private  final int taille;
    private Puits puits;
    private VuePiece vuePiece;
    private VuePiece vueNextPiece;
    private int tileSize;

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        this.vuePiece = new VuePiece(puits.getPieceActuelle());
        this.vueNextPiece = new VuePiece(puits.getPieceSuivante());
        setPreferredSize(new Dimension(taille, taille));
        setBackground(Color.WHITE);
        this.puits.addPropertyChangeListener(this); // Listen to property changes

        PieceDeplacement deplacement = new PieceDeplacement(this, new Puits());
        this.addMouseMotionListener(deplacement);
    }

    public VuePiece getVuePiece() {
        return vuePiece;
    }

    public void setVuePiece(VuePiece vuePiece) {
        this.vuePiece = vuePiece;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();
        tileSize = (this.getTaille() - 40) / puits.getProfondeur();
        g2D.setColor(Color.lightGray);
        g2D.drawRect(MARGE, MARGE, puits.getLargeur() * tileSize, puits.getProfondeur() * tileSize);

        //affiche nextPiece
        g2D.drawRect((getWidth() - (5 * tileSize)) - MARGE, MARGE, 5 * tileSize, 5 * tileSize);

        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D, tileSize);
        }

        if (vueNextPiece != null) {
            //vueNextPiece.afficherNextPiece(g2D, tileSize);
        }

        g2D.dispose();
    }

    @Override
        public void propertyChange(PropertyChangeEvent event) {
        if (Puits.MODIFICATION_PIECE_ACTUELLE.equals(event.getPropertyName())) {
            setVuePiece(new VuePiece((Piece) event.getNewValue()));
        }
    }

    public int getTaille() {
        return taille;
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
        repaint();
    }

    public int getColumnAt(int x) {
        return (x - MARGE) / tileSize;
    }

    public int getRowAt(int y) {
        return (y - MARGE) / tileSize;
    }

}