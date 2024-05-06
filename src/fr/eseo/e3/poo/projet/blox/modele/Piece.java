package fr.eseo.e3.poo.projet.blox.modele;

import java.util.List;

abstract public class Piece {

	private Couleur couleur;
    private Puits puits;
    private Element element;
	public int[][] dimension;


	/**
	 * 
	 * @param coordonnees
	 * @param couleur
	 */
	public Piece(Coordonnees coordonnees, Couleur couleur) {


    	this.element = new Element(coordonnees, couleur);
		this.couleur = couleur;
		this.dimension = new int[][]{{0, 1, 0}, {0, 1, 0}, {1, 1, 0}};
	}
	
	/**
	 * 
	 * @param coordonnees
	 * @param couleur
	 */
	protected void setElements(Coordonnees coordonnees, Couleur couleur) {

    	Element element = new Element(coordonnees, couleur);
	    this.element = element;
	}

	/**
	 *  Get elements
	 * @return
	 */
	public Element getElements() {
		return this.element;
	}
	
	/**
	 * Set position
	 * @param abscisse
	 * @param ordonnee
	 */
    public void setPosition(int abscisse, int ordonnee) {
    	
    	Coordonnees coordonnees = new Coordonnees(abscisse, ordonnee);
    	
    	this.element.setCoordonnes(coordonnees);
    }

    /**
     * Override toString() method
     */
    public String toString() {
        
        return "(" + this.element + ", " + this.couleur +  ", " + this.puits + ")";
    }

    /**
     * Get puits
     * @return
     */
    public Puits getPuits() {
        return puits;
    }

    /**
     * Set puits
     * @param puits
     */
    public void setPuits(Puits puits) {
        this.puits = puits;
    }

	/**
	 *
	 * @param deltaX
	 * @param deltaY
	 */
	public void deplacerDe(int deltaX, int deltaY) {
		Coordonnees coor = this.element.getCoordonnes();
		int abs = coor.getAbscisse();
		abs = abs + deltaX;
		coor.setAbscisse(abs);

		int ord = coor.getOrdonnee();
		ord = ord + deltaY;
		coor.setOrdonnee(ord);

		this.element.setCoordonnes(coor);
	}

	/**
	 *
	 * @param sensHorraire
	 */
	public void tourner(boolean sensHorraire) {

		int rows = this.dimension.length;    // Number of rows in the original matrix
		int cols = this.dimension[0].length; // Number of columns in the original matrix

		// New matrix with inverted dimensions
		int[][] rotatedMatrix = new int[cols][rows];

		if(sensHorraire) {
			// Rotate the matrix CW
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					rotatedMatrix[j][rows - 1 - i] = this.dimension[i][j];
				}
			}
		} else {
			// Rotate the matrix CCW
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					rotatedMatrix[cols - 1 - j][i] = this.dimension[i][j];
				}
			}
		}

		// Update the dimension array to the rotated matrix
		this.dimension = rotatedMatrix;
	}

	/**
	 *
	 * @return
	 */
	public int[][] getDimension () {
		return this.dimension;
	}

}
