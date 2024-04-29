package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import java.awt.*;
import javax.swing.*;

public class VuePuits extends JPanel {
    private Puits puits;

    public static final int TAILLE_PAR_DEFAUT = 700; // assuming a default size

    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.setPreferredSize(new Dimension(taille, puits.getProfondeur()));
        this.setBackground(Color.BLUE);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Using Puits properties for size
        g.fillRect(0, 0, puits.getLargeur(), puits.getProfondeur());
    }

    public Puits getPuits() {
        return puits;
    }

    public void setPuits(Puits puits) {
        this.puits = puits;
        repaint();
    }

    public int getTaille() {
        return this.getWidth(); // or getHeight(), depending on which represents the "taille"
    }

    public void setTaille(int taille) {
        this.setPreferredSize(new Dimension(taille, this.getPreferredSize().height));
        this.revalidate();
    }

    public void DisplayPuits() {
        JFrame frame = new JFrame("Simple Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        frame.setSize(new Dimension(puits.getLargeur(), puits.getProfondeur()));
        frame.add(this);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
