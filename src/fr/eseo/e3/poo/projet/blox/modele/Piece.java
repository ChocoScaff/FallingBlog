package fr.eseo.e3.poo.projet.blox.modele;

import java.util.List;

abstract public class Piece {

	private Couleur couleur;
    private Puits puits;
    private Element element;
	
	/**
	 * 
	 * @param coordonnees
	 * @param couleur
	 */
	public Piece(Coordonnees coordonnees, Couleur couleur) {


    	this.element = new Element(coordonnees, couleur);
		this.couleur = couleur;
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
	public List<Element> getElements() {
		return (List<Element>) element;
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

		Coordonnees coor = this.element.getCoordonnes();
		int abs = coor.getAbscisse();
		int ord = coor.getOrdonnee();


		int newX = (int) (abs * Math.cos(90) - abs * Math.sin(90));
		int newY = (int) (ord * Math.sin(90) + ord * Math.cos(90));

		deplacerDe(newX,newY);
	}
}
