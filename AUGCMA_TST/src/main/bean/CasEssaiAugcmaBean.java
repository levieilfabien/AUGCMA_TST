package main.bean;

import beans.CasEssaiBean;

/**
 * Classe exemple pour un cas d'essai de projet de test.
 * @author levieilfa
 *
 */
public class CasEssaiAugcmaBean extends CasEssaiBean {

	/**
	 * Id de s�rialisation.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Dossier AUGCMA
	 */
	private String numeroDossier = "41102478031100";
	
	/**
	 * IUN du client
	 */
	private String numeroIUN = "3209020";
	
	/**
	 * Distributeur concern�
	 */
	private String distributeur = "CE";

	/**
	 * Constructeur par d�faut d'un sc�nario mod�le.
	 */
	public CasEssaiAugcmaBean() {
		super();
	}


	public String getNumeroDossier() {
		return numeroDossier;
	}


	public void setNumeroDossier(String numeroDossier) {
		this.numeroDossier = numeroDossier;
	}


	public String getNumeroIUN() {
		return numeroIUN;
	}


	public void setNumeroIUN(String numeroIUN) {
		this.numeroIUN = numeroIUN;
	}


	public String getDistributeur() {
		return distributeur;
	}


	public void setDistributeur(String distributeur) {
		this.distributeur = distributeur;
	}
	
}
