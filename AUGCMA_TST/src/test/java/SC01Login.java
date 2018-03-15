package test.java;

import org.junit.Test;

import constantes.Actions;
import exceptions.SeleniumException;
import main.constantes.Cibles;
import main.constantes.Constantes;
import outils.SeleniumOutils;

public class SC01Login extends SC00Modele {

	/**
	 * Id de serialisation.
	 */
	private static final long serialVersionUID = 1L;

	@Test
	public void accesTest() throws SeleniumException {

		// Description du sc�nario
		///CasEssaiAugcmaBean scenario0 = new CasEssaiAugcmaBean();
		
		// Valorisation des donn�es
		setNumeroDossier("41000326032100");
		setNumeroIUN("3108391");
		setDistributeur("CE");

		/////////////////////////////////////////////////// Configuration////////////////////////////////////////////////
		SeleniumOutils outil = obtenirDriverChrome(this);

		/////////////////////////////////////////////////// EXECUTION////////////////////////////////////////////////
		// Acc�s � AUG CMA
		accesAugCma(outil);

		// S'identifier sur l'appliation
		identificationAugCma(outil);
		
		////// SI DOSSIER DEJA EXISTANT /////////
		//Annuler un dossier d�j� existant
		//if(outil.testerPresenceElementDiffere(Cibles.METTRE_SANS_SUITE)) {
		//	outil.action(Actions.CLIQUER, Cibles.METTRE_SANS_SUITE);
			
			//S�lectionner motif d'annulation
		//	outil.action(Actions.CLIQUER, Cibles.MOTIF_ANNULATION);
			
			// Attente disponibilite bouton valider
		//	outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.VALIDER_ANNULATION);
			
			//S�lectionner motif d'annulation
		//	outil.action(Actions.CLIQUER, Cibles.VALIDER_ANNULATION);
			
			// Acc�s � AUG CMA
		//	accesAugCma(outil);

			// S'identifier sur l'appliation
		//	identificationAugCma(outil);
		//}	
		
		///// SI AUCUN DOSSIER EN COURS /////////
		// Attendre la pr�sence d'un �l�ment
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.NOUVELLE_INSTRUCTION);
				
		//Soumettre les donn�es clients
		outil.action(Actions.CLIQUER, Cibles.NOUVELLE_INSTRUCTION);
		
		// Attendre la pr�sence d'un �l�ment
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_SOUMETTRE_DONNEES_CLIENTS);
		//Soumettre les donn�es clients
		outil.action(Actions.CLIQUER, Cibles.BOUTON_SOUMETTRE_DONNEES_CLIENTS);
		
		//Remplir le champs "Augmentation suite �"
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.SELECTION_CHAMP_AUGSUITEA);
		outil.action(Actions.SELECTIONNER, Cibles.SELECTION_CHAMP_AUGSUITEA, Constantes.VALEUR_CHAMP_AUGSUITEA);
		
		//Remplir le champs "Montant du financement souhait�"
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.SAISIE_MONTANT_FIN_SOUHAITE);
		//outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);
		outil.saisieInstantanee(Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);
		
		
		//Nouvelle instruction jboss
		//outil.action(Actions.CLIQUER, Cibles.NOUVELLE_INSTRUCTION);
		
		// Attendre la pr�sence d'un �l�ment
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_SOUMETTRE_PROPOSITION);
		//Soumettre la proposition d'augmentation de CMA
		outil.action(Actions.CLIQUER, Cibles.BOUTON_SOUMETTRE_PROPOSITION);
		
		//Remplir le champs "Montant du financement souhait�"
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_VALIDER_CONTRAT);
		//outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);
		outil.saisieInstantanee(Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);
		
		

		// Attendre la pr�sence d'un �l�ment
		//outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_VALIDER_CONTRAT);
		//Valider la proposition en contrat de cr�dit
		outil.action(Actions.CLIQUER, Cibles.BOUTON_VALIDER_CONTRAT);
		
		//System.exit(0);
		
		///////	PAGE EDITION LIASSE - STATUT VALD ////////////////
		
		//Remplir le champs "Montant du financement souhait�"
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.SAISIE_MONTANT_FIN);
		outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MONTANT_FIN, Constantes.VALEUR_MONTANT_FIN_DEUX);
		
		// Attendre la pr�sence d'un �l�ment
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_EDITION_CONTRAT);
		//Valider la proposition en contrat de cr�dit
		outil.action(Actions.CLIQUER, Cibles.BOUTON_EDITION_CONTRAT);
		
		///////	PAGE EDITION LIASSE - STATUT EDIT ////////////////
		// Attendre la pr�sence d'un �l�ment
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_ETUDE_DOSSIER);
		//Valider la proposition en contrat de cr�dit
		outil.action(Actions.CLIQUER, Cibles.BOUTON_ETUDE_DOSSIER);
		
		///////	PAGE EDITION LIASSE -POPUP- STATUT ETUD ////////////////
		// Attendre la pr�sence d'un �l�ment
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_FERMER_APPLICATION);
		//Valider la proposition en contrat de cr�dit
		outil.action(Actions.CLIQUER, Cibles.BOUTON_FERMER_APPLICATION);
		
		
		//////////////RECUPERATION DE LIASSE//////////////////////////
	}

}
