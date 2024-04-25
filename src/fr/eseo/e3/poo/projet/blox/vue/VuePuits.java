package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.*;
import javax.swing.JPanel;

public class VuePuits extends JPanel {
    public VuePuits()
    {
        this.setBounds(0, 0, 100, 100);
        this.setBackground(Color.BLUE);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fillRect(0, 0, 50, 50);
    }
}
