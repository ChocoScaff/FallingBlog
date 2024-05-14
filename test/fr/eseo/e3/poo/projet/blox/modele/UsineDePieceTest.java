package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.pieces.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsineDePieceTest {

    private UsineDePiece usineDePiece;

    @BeforeEach
    void setUp() {
        usineDePiece = new UsineDePiece();
    }

    @Test
    void setModeTest() {
        usineDePiece.setMode(UsineDePiece.Mode.ALEATOIRE_COMPLET);
        assertEquals(UsineDePiece.Mode.ALEATOIRE_COMPLET, usineDePiece.mode);

        usineDePiece.setMode(UsineDePiece.Mode.ALEATOIRE_PIECE);
        assertEquals(UsineDePiece.Mode.ALEATOIRE_PIECE, usineDePiece.mode);

        usineDePiece.setMode(UsineDePiece.Mode.CYCLIC);
        assertEquals(UsineDePiece.Mode.CYCLIC, usineDePiece.mode);
    }

    @RepeatedTest(10)
    void genererPieceAleatoireCompletTest() {
        usineDePiece.setMode(UsineDePiece.Mode.ALEATOIRE_COMPLET);
        Piece piece = usineDePiece.genererPiece();
        assertNotNull(piece);
        assertTrue(isValidPiece(piece));
    }

    @RepeatedTest(10)
    void genererPieceAleatoirePieceTest() {
        usineDePiece.setMode(UsineDePiece.Mode.ALEATOIRE_PIECE);
        Piece piece = usineDePiece.genererPiece();
        assertNotNull(piece);
        assertTrue(isValidPiece(piece));
    }

    @Test
    void genererPieceCyclicTest() {
        usineDePiece.setMode(UsineDePiece.Mode.CYCLIC);
        Piece piece1 = usineDePiece.genererPiece();
        assertNotNull(piece1);
        assertTrue(isValidPiece(piece1));

        Piece piece2 = usineDePiece.genererPiece();
        assertNotNull(piece2);
        assertTrue(isValidPiece(piece2));

        // Ensure cyclic behavior
        assertNotEquals(piece1.getClass(), piece2.getClass());
    }

    private boolean isValidPiece(Piece piece) {
        return piece instanceof OPiece || piece instanceof IPiece ||
                piece instanceof TPiece || piece instanceof LPiece ||
                piece instanceof JPiece || piece instanceof ZPiece ||
                piece instanceof SPiece;
    }
}
