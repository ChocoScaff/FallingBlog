package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanneauInformation extends JPanel {
    private Piece nextPiece;
    private int score;
    private int level;

    public PanneauInformation(Piece nextPiece, int score, int level) {
        this.nextPiece = nextPiece;
        this.score = score;
        this.level = level;
        this.setPreferredSize(new Dimension(150, 400));  // Adjust as needed
    }

    public void setNextPiece(Piece nextPiece) {
        this.nextPiece = nextPiece;
        repaint();
    }

    public void setScore(int score) {
        this.score = score;
        repaint();
    }

    public void setLevel(int level) {
        this.level = level;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        // Display score and level
        g2D.setColor(Color.BLACK);
        g2D.drawString("Score: " + score, 10, 20);
        g2D.drawString("Level: " + level, 10, 40);

        // Display next piece
        if (nextPiece != null) {
            int tileSize = 20;  // fixed size for the next piece display
            List<Element> elements = nextPiece.getElements();
            for (Element element : elements) {
                Color color = element.getCouleur().getCouleurPourAffichage();
                g2D.setColor(color);
                int abs = element.getCoordonnees().getAbscisse();
                int ord = element.getCoordonnees().getOrdonnee();
                g2D.fill3DRect(abs * tileSize + 10, ord * tileSize + 60, tileSize, tileSize, true);
            }
        }

        g2D.dispose();
    }
}
