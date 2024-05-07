package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.Piece;

public class Puits {
	private static final int LARGEUR_PAR_DEFAULT = 10;
	private static final int PROFONDEUR_PAR_DEFAULT = 20;

	private int largeur;
	private int profondeur;

	private Piece pieceActuelle;
	private Piece pieceSuivante;

	/**
	 *
	 */
	public Puits() {
		this.largeur = LARGEUR_PAR_DEFAULT;
		this.profondeur = PROFONDEUR_PAR_DEFAULT;
	}

	/**
	 *
	 * @param largeur
	 * @param profondeur
	 */
	public Puits(int largeur, int profondeur) {
		this.largeur = largeur;
		this.profondeur = profondeur;
	}

	/**
	 *
	 * @return
	 */
	public Piece getPieceActuelle() {
		return this.pieceActuelle;
	}

	/**
	 *
	 * @return
	 */
	public Piece getPieceSuivante() {
		return this.pieceSuivante;
	}

	/**
	 *
	 * @param piece
	 */
	public void setPieceSuivante(Piece piece) {

		if(this.pieceSuivante == null){
			this.pieceSuivante = piece;
		} else {
			this.pieceActuelle = this.pieceSuivante;
			this.pieceSuivante = piece;
		}

	}

	/**
	 *
	 * @return
	 */
	public int getLargeur() {
		return largeur;
	}

	/**
	 *
	 * @return
	 */
	public int getProfondeur() {
		return profondeur;
	}

	/**
	 *
	 * @param profondeur
	 */
	public void setProfondeur(int profondeur) {
		this.profondeur = profondeur;
	}

	/**
	 *
	 * @param largeur
	 */
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
}
