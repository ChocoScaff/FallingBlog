package fr.eseo.e3.poo.projet.blox.modele;

import fr.eseo.e3.poo.projet.blox.modele.Piece;

public class Puits {
	private static final int LARGEUR_PAR_DEFAULT = 10;
	private static final int PROFONDEUR_PAR_DEFAULT = 20;

	private int largeur;
	private int profondeur;

	private Piece piece;

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
		return this.piece;
	}

	/**
	 *
	 * @return
	 */
	public Piece getPieceSuivante() {
		return this.piece;
	}

	/**
	 *
	 * @param piece
	 */
	public void setPieceSuivante(Piece piece) {
		this.piece = piece;
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
