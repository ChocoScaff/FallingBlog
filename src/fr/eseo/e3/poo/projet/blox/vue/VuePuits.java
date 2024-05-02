package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import java.awt.*;
import javax.swing.*;

public class VuePuits extends JPanel {
    private final int taille;
    private Puits puits;
    private VuePiece vuePiece;

    public static final int TAILLE_PAR_DEFAUT = 700;

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        setPreferredSize(new Dimension(taille, taille));
        setBackground(Color.WHITE);
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
        int tileSize = (this.getTaille() - 40) / puits.getProfondeur();
        g2D.setColor(Color.lightGray);
        g2D.drawRect(20, 20, puits.getLargeur() * tileSize, puits.getProfondeur() * tileSize);

        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D, tileSize);
        }

        g2D.dispose();
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
}