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
	//public static final CibleBean METTRE_SANS_SUITE = new CibleBean(Clefs.NAME, "majClientForm:mettreSsSuite");
	public static final CibleBean METTRE_SANS_SUITE = new CibleBean(Clefs.NAME, "form-octroi:sansSuiteBouton");
	
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
	
	// Demande octroi
	/**
	* Bouton de soumission des données clients
	*/
	public static final CibleBean BOUTON_SOUMETTRE_DONNEES_OCTROI = new CibleBean(Clefs.NAME, "form-octroi:soummettreBouton");
	
	
	// Ouvrir calendrier
		/**
		* Bouton de soumission des données clients
		*/
		public static final CibleBean CALENDRIER_DATE_SIGNATURE = new CibleBean(Clefs.ID, "form-octroi:dateSignaturePopupButton");
	
	// Ouvrir calendrier
	/**
	* Bouton de soumission des données clients
	*/
	public static final CibleBean SELECTION_DATE_SIGNATURE = new CibleBean(Clefs.TEXTE_COMPLET, "Aujourd'hui");
	
	// Bouton radio liasse contractuelle validee OK
		/**
		* Bouton de soumission des données clients
		*/
		public static final CibleBean BOUTON_RADIO_LIASSE_VALIDEE = new CibleBean(Clefs.ID, "form-octroi:table-completude:0:j_id399279269_405869a9:0");
		
	// Bouton radio demande de financement KO
	/**
	 * Bouton de soumission des données clients
	*/
	public static final CibleBean BOUTON_RADIO_FINANCEMENT_REFUS = new CibleBean(Clefs.ID, "form-octroi:table-completude:1:j_id399279269_405869a9:1");
	
	
	// Bouton radio justificatif vérifié
		/**
		 * Bouton de soumission des données clients
		*/
		public static final CibleBean BOUTON_RADIO_VALIDATION_JUSTIFICATIF = new CibleBean(Clefs.ID, "form-octroi:table-justificatifs:0:justifVerifie:0");
		
	
		// Bouton radio justificatif vérifié
				/**
				 * Bouton de soumission des données clients
				*/
				public static final CibleBean BOUTON_RADIO_DECISION_OCTROI_OK = new CibleBean(Clefs.ID, "form-octroi:selectDecisionOK:0");
				
	
		
	
	
	
	
	
	
}