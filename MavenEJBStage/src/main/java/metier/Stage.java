package metier;

import java.io.Serializable;
import java.util.*;


public class Stage implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String libelle;
	private Date datedebut;
	private Date datefin;
	private int nbplaces;
	private int nbinscrits;
	
	/* (non-Javadoc)
	 * @see metier.test#getNbplaces()
	 */
	public int getNbplaces() {
		return nbplaces;
	}


	/* (non-Javadoc)
	 * @see metier.test#setNbplaces(int)
	 */
	public void setNbplaces(int nbplaces) {
		this.nbplaces = nbplaces;
	}


	/* (non-Javadoc)
	 * @see metier.test#getNbinscrits()
	 */
	public int getNbinscrits() {
		return nbinscrits;
	}


	/* (non-Javadoc)
	 * @see metier.test#setNbinscrits(int)
	 */
	public void setNbinscrits(int nbinscrits) {
		this.nbinscrits = nbinscrits;
	}
	

	
	public Stage(String id, String libelle, Date datedebut, Date datefin, 
			int nbplaces, int nbinscrits) {
		this.id = id;
		this.libelle = libelle;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.nbplaces = nbplaces;
		this.nbinscrits = nbinscrits;
	}
	

	/* (non-Javadoc)
	 * @see metier.test#getId()
	 */
	public String getId() {
		return id;
	}
	public Stage() {
	
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see metier.test#setId(java.lang.String)
	 */
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see metier.test#getLibelle()
	 */
	public String getLibelle() {
		return libelle;
	}
	/* (non-Javadoc)
	 * @see metier.test#setLibelle(java.lang.String)
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/* (non-Javadoc)
	 * @see metier.test#getDatedebut()
	 */
	public Date getDatedebut() {
		return datedebut;
	}
	/* (non-Javadoc)
	 * @see metier.test#setDatedebut(java.util.Date)
	 */
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	/* (non-Javadoc)
	 * @see metier.test#getDatefin()
	 */
	public Date getDatefin() {
		return datefin;
	}
	/* (non-Javadoc)
	 * @see metier.test#setDatefin(java.util.Date)
	 */
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	
}
