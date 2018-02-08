package main.constantes;

import beans.CibleBean;
import constantes.Clefs;

public class Cibles {

	////// EXEMPLE SUR GOOGLE //////
	/**
	 * Champ de saisie pour la recherche google.
	 */
	//public static final CibleBean SAISIE_RECHERCHE = new CibleBean(Clefs.XPATH, "//input[@type!='hidden' and @type != 'submit'][1]");
	
	/**
	 * Bouton de recherche google.
	 */
	//public static final CibleBean VALIDER_RECHERCHE = new CibleBean(Clefs.VALEUR, "Recherche Google");
	
	//////EXEMPLE SUR AUGCMA //////
	/**
	 * Champ de saisie pour l'identifiant AUGCMA.
	 */
	public static final CibleBean SAISIE_IDENTIFIANT = new CibleBean(Clefs.NAME, "j_username");
	/**
	 * Champ de saisie pour le mot de passe AUGCMA.
	 */
	public static final CibleBean SAISIE_MOTDEPASSE = new CibleBean(Clefs.NAME, "j_password");
	/**
	 * Bouton de recherche google.
	 */
	public static final CibleBean VALIDER_LOGIN = new CibleBean(Clefs.VALEUR, "Valider");
	
	
	
}