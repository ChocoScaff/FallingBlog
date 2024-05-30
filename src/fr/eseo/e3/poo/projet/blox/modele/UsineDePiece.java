package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UsineDePiece {

    public enum Mode {
        ALEATOIRE_COMPLET,
        ALEATOIRE_PIECE,
        CYCLIQUE
    }

    Mode mode;
    private int indexSemiAleatoire = -1;
    private int indexCyclique = 0;


    private final List<Function<Coordonnees, Piece>> pieceUsines = new ArrayList<>();


    public UsineDePiece() {
        this(Mode.ALEATOIRE_PIECE);
    }

    public UsineDePiece(Mode mode) {
        this.mode = mode;
        initializeFactories();
    }

    private void initializeFactories() {

        pieceUsines.add(coordonnees -> new OPiece(coordonnees, Couleur.ROUGE));
        pieceUsines.add(coordonnees -> new IPiece(coordonnees, Couleur.ORANGE));
        pieceUsines.add(coordonnees -> new TPiece(coordonnees, Couleur.BLEU));
        pieceUsines.add(coordonnees -> new LPiece(coordonnees, Couleur.VERT));
        pieceUsines.add(coordonnees -> new JPiece(coordonnees, Couleur.JAUNE));
        pieceUsines.add(coordonnees -> new ZPiece(coordonnees, Couleur.CYAN));
        pieceUsines.add(coordonnees -> new SPiece(coordonnees, Couleur.VIOLET));
    }


    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Piece genererPiece() {
        Coordonnees coordonnees = new Coordonnees(2, 3);
        Piece piece = null;

        switch (this.mode) {
            case ALEATOIRE_COMPLET:
                int randomIndex = (int) (Math.random() * pieceUsines.size());
                piece = pieceUsines.get(randomIndex).apply(coordonnees);
                break;

            case ALEATOIRE_PIECE:
                int oldSemiRandomIndex = this.indexSemiAleatoire;
                while (this.indexSemiAleatoire == oldSemiRandomIndex) {
                    this.indexSemiAleatoire = (int) (Math.random() * pieceUsines.size());
                }
                piece = pieceUsines.get(this.indexSemiAleatoire).apply(coordonnees);
                break;

            case CYCLIQUE:
                piece = pieceUsines.get(this.indexCyclique).apply(coordonnees);
                if (this.indexCyclique < pieceUsines.size() - 1) {
                    this.indexCyclique += 1;
                } else {
                    this.indexCyclique = 0;
                }
                break;
        }

        return piece;
    }
}
