package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import java.awt.*;
import javax.swing.*;

public class VuePuits extends JPanel {
    private final int taille;
    private Puits puits;

    public static final int TAILLE_PAR_DEFAUT = 700; // assuming a default size

    /**
     *
     * @param puits
     */
    public VuePuits(Puits puits) {
        this(puits, TAILLE_PAR_DEFAUT);
    }

    /**
     *
     * @param puits
     * @param taille
     */
    public VuePuits(Puits puits, int taille) {
        this.puits = puits;
        this.taille = taille;
        this.setPreferredSize(new Dimension(taille, taille));
        this.setBackground(Color.WHITE);
    }

    /**
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // This will fill the background with the set color (white)

        // Cast the Graphics object to Graphics2D for better control over the graphics
        Graphics2D g2D = (Graphics2D) g.create();

        // Drawing a light gray grid
        g2D.setColor(Color.LIGHT_GRAY);
        int tileSize = (this.getTaille() - 40) / puits.getProfondeur();
        for (int x = 20; x < puits.getLargeur()*tileSize; x += tileSize) {
            for (int y = 20; y < puits.getProfondeur()*tileSize; y += tileSize) {
                g2D.drawRect(x, y, tileSize, tileSize);
            }
        }

        g2D.dispose(); // Free up the graphics object resources
    }

    /**
     *
     * @return
     */
    public Puits getPuits() {
        return puits;
    }

    /**
     *
     * @param puits
     */
    public void setPuits(Puits puits) {
        this.puits = puits;
        repaint();
    }

    /**
     *
     * @return
     */
    public int getTaille() {
        return this.taille;
    }

    /**
     *
     * @param taille
     */
    public void setTaille(int taille) {
        this.setPreferredSize(new Dimension(taille, this.getPreferredSize().height));
        this.revalidate();
    }

    /**
     *
     */
    public void DisplayPuits() {
        JFrame frame = new JFrame("Simple Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.setSize(new Dimension(puits.getLargeur(), puits.getProfondeur()));
        frame.add(this);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
