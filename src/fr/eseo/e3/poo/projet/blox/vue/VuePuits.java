package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.*;
import javax.swing.*;

public class VuePuits extends JPanel {
    public VuePuits()
    {
        this.setBackground(Color.BLUE);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fillRect(0, 0, 50, 50);
    }

    public void DisplayPuits() {
        JFrame frame = new JFrame("Simple Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        this.setPreferredSize(new Dimension(700, 500));  // Set this to your desired dimensions
        frame.setSize(100, 100);
        frame.add(this);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
