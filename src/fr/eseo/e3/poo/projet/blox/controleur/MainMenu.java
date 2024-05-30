package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;

public class MainMenu {
    private int largeurPuits = 10;
    private int profondeurPuits = 20;
    private UsineDePiece.Mode modeUsineDePiece = UsineDePiece.Mode.ALEATOIRE_PIECE;
    private int nbElementsTas = 0;
    private int nbLignesTas = 0;
    private int gameSpeed = 1000;

    public void setLargeurPuits(int largeur) {
        this.largeurPuits = largeur;
    }

    public void setProfondeurPuits(int profondeur) {
        this.profondeurPuits = profondeur;
    }

    public void setModeUsineDePiece(UsineDePiece.Mode mode) {
        this.modeUsineDePiece = mode;
    }

    public void setNbElementsTas(int nbElements) {
        this.nbElementsTas = nbElements;
    }

    public void setNbLignesTas(int nbLignes) {
        this.nbLignesTas = nbLignes;
    }

    public void setGameSpeed(int speed) {
        this.gameSpeed = speed;
    }

    public void startGame() {
        Puits puits = new Puits(largeurPuits, profondeurPuits);
        UsineDePiece usineDePiece = new UsineDePiece(modeUsineDePiece);

        puits.getTas().construireTas(nbElementsTas, nbLignesTas, new java.util.Random());

        new GameLoop(puits, modeUsineDePiece, gameSpeed);
    }
}
