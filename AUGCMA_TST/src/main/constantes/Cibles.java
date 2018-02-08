package main.constantes;

import beans.CibleBean;
import constantes.Clefs;

public class Cibles {

	////// EXEMPLE SUR GOOGLE //////
	/**
	 * Champ de saisie pour la recherche google.
	 */
	public static final CibleBean SAISIE_RECHERCHE = new CibleBean(Clefs.XPATH, "//input[@type!='hidden' and @type != 'submit'][1]");
	
	/**
	 * Bouton de recherche google.
	 */
	public static final CibleBean VALIDER_RECHERCHE = new CibleBean(Clefs.VALEUR, "Recherche Google");
	
	//////EXEMPLE SUR AUGCMA //////
	
	
	
}