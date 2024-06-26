package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.modele.Piece;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class VuePuits extends JPanel implements PropertyChangeListener {
    public static final int MARGE = 20;
    public static final int TAILLE_PAR_DEFAUT = 700;
    private final int taille;
    private Puits puits;
    private final VueTas vueTas;
    private VuePiece vuePiece;
    private int tileSize;
    private PanneauInformation panneauInformation;

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        this.vuePiece = new VuePiece(puits.getPieceActuelle());
        this.panneauInformation = new PanneauInformation(puits.getPieceSuivante(), 0, 1);
        setPreferredSize(new Dimension(taille, taille));
        setBackground(Color.WHITE);
        this.puits.addPropertyChangeListener(this);

        this.vueTas = new VueTas(puits.getTas());

        PieceDeplacement pieceDeplacement = new PieceDeplacement(this, puits);
        this.addMouseListener(pieceDeplacement);
        this.addMouseMotionListener(pieceDeplacement);
        this.addMouseWheelListener(pieceDeplacement);

        // Add PanneauInformation to the layout
        setLayout(new BorderLayout());
        add(panneauInformation, BorderLayout.EAST);
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

        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D, tileSize);
        }

        if (vueTas != null) {
            vueTas.afficherTas(g2D, tileSize);
        }

        g2D.dispose();
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (Puits.MODIFICATION_PIECE_ACTUELLE.equals(event.getPropertyName())) {
            setVuePiece(new VuePiece((Piece) event.getNewValue()));
        }
        panneauInformation.setNextPiece(puits.getPieceSuivante());
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
        if(tileSize != 0){
            return (x - MARGE) / tileSize;
        }else {
            return (x - MARGE) / 10;
        }

    }

    public int getRowAt(int y) {
        return (y - MARGE) / tileSize;
    }

    public PanneauInformation getPanneauInformation() {
        return panneauInformation;
    }
}
