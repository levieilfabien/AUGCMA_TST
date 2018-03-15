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
	 * Bouton de démarrage d'une nouvelle instruction.
	 */
	public static final CibleBean NOUVELLE_INSTRUCTION = new CibleBean(Clefs.NAME, "majClientForm:instruireNouveauDossier");
	
	/**
	 * Bouton de soumission des données clients
	 */
	public static final CibleBean BOUTON_SOUMETTRE_DONNEES_CLIENTS = new CibleBean(Clefs.NAME, "majClientForm:soumettreDonneeSubmit");
	
	
	//Remplir éléments cadre propositions
	/**
	 * Sélection Champ "Augmentation suite à"
	 */
	public static final CibleBean SELECTION_CHAMP_AUGSUITEA = new CibleBean(Clefs.NAME, "majClientForm:augmentationLabel:augmentationText");
	/**
	 *Remplir Valeur "Montant du financement souhaité"
	 */
	public static final CibleBean SAISIE_MONTANT_FIN_SOUHAITE = new CibleBean(Clefs.ID, "majClientForm:mntFinanceLabel:mntFinanceText");

	
	// Validation de la proposition
	/**
	 * Bouton de soumission des données clients
	 */
	public static final CibleBean BOUTON_SOUMETTRE_PROPOSITION = new CibleBean(Clefs.NAME, "majClientForm:simulerSubmit");
	
	// Validation de la proposition
	/**
	 * Bouton de soumission des données clients
	 */
	public static final CibleBean BOUTON_VALIDER_CONTRAT = new CibleBean(Clefs.NAME, "majClientForm:validerContratCreditSubmit");
	
	/**
	 *Remplir Valeur "Augmentation suite à"
	 */
	public static final CibleBean SAISIE_MONTANT_FIN = new CibleBean(Clefs.ID, "augCMAEditionForm:mntFinanceLabel:mntFinanceText");
	
	// Demande édition liasses
	/**
	 * Bouton de soumission des données clients
	 */
	public static final CibleBean BOUTON_EDITION_CONTRAT = new CibleBean(Clefs.NAME, "augCMAEditionForm:editer");
	
	// Demande édition liasses
	/**
	 * Bouton de soumission des données clients
	 */
	public static final CibleBean BOUTON_ETUDE_DOSSIER = new CibleBean(Clefs.NAME, "augCMAEditionForm:passerEtudeEdit");
	
	
	// Demande édition liasses
	/**
	 * Bouton de soumission des données clients
	 */
		public static final CibleBean BOUTON_FERMER_APPLICATION = new CibleBean(Clefs.NAME, "formReceptionDossier:boutonFermer");
	
	
	
	
}