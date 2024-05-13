package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UsineDePiece {

    public enum Mode {
        ALEATOIRE_COMPLET,
        ALEATOIRE_PIECE,
        CYCLIC
    }

    private Mode mode;
    private int semiRandomIndex = -1;
    private int cycleIndex = 0;


    private final List<Function<Coordonnees, Piece>> pieceFactories = new ArrayList<>();


    public UsineDePiece() {
        this.mode = Mode.ALEATOIRE_COMPLET;
        initializeFactories();
    }


    private void initializeFactories() {

        pieceFactories.add(coords -> new OPiece(coords, Couleur.ROUGE));
        pieceFactories.add(coords -> new IPiece(coords, Couleur.ORANGE));
        pieceFactories.add(coords -> new TPiece(coords, Couleur.BLEU));
        pieceFactories.add(coords -> new LPiece(coords, Couleur.VERT));
        pieceFactories.add(coords -> new JPiece(coords, Couleur.JAUNE));
        pieceFactories.add(coords -> new ZPiece(coords, Couleur.CYAN));
        pieceFactories.add(coords -> new SPiece(coords, Couleur.VIOLET));
    }


    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Piece genererPiece() {
        Coordonnees coordonnees = new Coordonnees(2, 3);
        Piece piece = null;

        switch (this.mode) {
            case ALEATOIRE_COMPLET:
                int randomIndex = (int) (Math.random() * pieceFactories.size());
                piece = pieceFactories.get(randomIndex).apply(coordonnees);
                break;

            case ALEATOIRE_PIECE:
                int oldSemiRandomIndex = this.semiRandomIndex;
                while (this.semiRandomIndex == oldSemiRandomIndex) {
                    this.semiRandomIndex = (int) (Math.random() * pieceFactories.size());
                }
                piece = pieceFactories.get(this.semiRandomIndex).apply(coordonnees);
                break;

            case CYCLIC:
                piece = pieceFactories.get(this.cycleIndex).apply(coordonnees);
                if (this.cycleIndex < pieceFactories.size() - 1) {
                    this.cycleIndex += 1;
                } else {
                    this.cycleIndex = 0;
                }
                break;
        }

        return piece;
    }
}
