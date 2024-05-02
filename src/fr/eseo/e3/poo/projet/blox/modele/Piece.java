package fr.eseo.e3.poo.projet.blox.modele;

import java.util.List;

abstract public class Piece {

	private Couleur couleur;
    private Puits puits;
    private Element element;
	private int[][] dimension;


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

		printMatrix();
		transpose();
		printMatrix();
		reverseColumns();
		printMatrix();
	}

	/**
	 *
	 */
	private void reverseColumns()
	{
		for (int i = 0; i < this.dimension[0].length; i++)
			for (int j = 0, k = this.dimension[0].length - 1; j < k;
				 j++, k--) {
				int temp = this.dimension[j][i];
				this.dimension[j][i] = this.dimension[k][i];
				this.dimension[k][i] = temp;
			}
	}

	/**
	 *
	 */
	private void transpose()
	{
		for (int i = 0; i < this.dimension.length; i++)
			for (int j = i; j < this.dimension[0].length; j++) {
				int temp = this.dimension[j][i];
				this.dimension[j][i] = this.dimension[i][j];
				this.dimension[i][j] = temp;
			}
	}

	/**
	 *
	 * @return
	 */
	public int[][] getDimension () {
		return this.dimension;
	}

	/**
	 *
	 */
	private void printMatrix()
	{
		for (int i = 0; i < this.dimension.length; i++) {
			for (int j = 0; j < this.dimension[0].length; j++)
				System.out.print(this.dimension[i][j] + " ");
			System.out.println("");
		}
	}
}
