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
	
	
	// Nouvelle instruction avec simulation deja en cours
	
	/**
	 * Bouton d'annulation de simulation.
	 */
	public static final CibleBean METTRE_SANS_SUITE = new CibleBean(Clefs.NAME, "majClientForm:mettreSsSuite");
	
	/**
	 * Bouton radio motif annulation
	 */
	public static final CibleBean MOTIF_ANNULATION = new CibleBean(Clefs.VALEUR, "Agence");
	
	/**
	 * Bouton validation annulation
	 */
	public static final CibleBean VALIDER_ANNULATION = new CibleBean(Clefs.VALEUR, "Valider");
	
	
	
	// Nouvelle instruction
	/**
	 * Bouton de d�marrage d'une nouvelle instruction.
	 */
	public static final CibleBean NOUVELLE_INSTRUCTION = new CibleBean(Clefs.NAME, "majClientForm:instruireNouveauDossier");
	
	/**
	 * Bouton de soumission des donn�es clients
	 */
	public static final CibleBean BOUTON_SOUMETTRE_DONNEES_CLIENTS = new CibleBean(Clefs.NAME, "majClientForm:soumettreDonneeSubmit");
	
	
	//Remplir �l�ments cadre propositions
	/**
	 * S�lection Champ "Augmentation suite �"
	 */
	public static final CibleBean SELECTION_CHAMP_AUGSUITEA = new CibleBean(Clefs.NAME, "majClientForm:augmentationLabel:augmentationText");
	/**
	 * S�lection Valeur "Augmentation suite �"
	 */
	public static final CibleBean VALEUR_CHAMP_AUGSUITEA = new CibleBean(Clefs.VALEUR, "OR1");
	
	// Validation de la proposition
	/**
	 * Bouton de soumission des donn�es clients
	 */
	public static final CibleBean BOUTON_SOUMETTRE_PROPOSITION = new CibleBean(Clefs.NAME, "majClientForm:simulerSubmit");
	
}