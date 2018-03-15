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

		// Description du scénario
		///CasEssaiAugcmaBean scenario0 = new CasEssaiAugcmaBean();
		
		// Valorisation des données
		setNumeroDossier("41000326032100");
		setNumeroIUN("3108391");
		setDistributeur("CE");

		/////////////////////////////////////////////////// Configuration////////////////////////////////////////////////
		SeleniumOutils outil = obtenirDriverChrome(this);

		/////////////////////////////////////////////////// EXECUTION////////////////////////////////////////////////
		// Accès à AUG CMA
		accesAugCma(outil);

		// S'identifier sur l'appliation
		identificationAugCma(outil);
		
		////// SI DOSSIER DEJA EXISTANT /////////
		//Annuler un dossier déjà existant
		//if(outil.testerPresenceElementDiffere(Cibles.METTRE_SANS_SUITE)) {
		//	outil.action(Actions.CLIQUER, Cibles.METTRE_SANS_SUITE);
			
			//Sélectionner motif d'annulation
		//	outil.action(Actions.CLIQUER, Cibles.MOTIF_ANNULATION);
			
			// Attente disponibilite bouton valider
		//	outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.VALIDER_ANNULATION);
			
			//Sélectionner motif d'annulation
		//	outil.action(Actions.CLIQUER, Cibles.VALIDER_ANNULATION);
			
			// Accès à AUG CMA
		//	accesAugCma(outil);

			// S'identifier sur l'appliation
		//	identificationAugCma(outil);
		//}	
		
		///// SI AUCUN DOSSIER EN COURS /////////
		// Attendre la présence d'un élément
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.NOUVELLE_INSTRUCTION);
				
		//Soumettre les données clients
		outil.action(Actions.CLIQUER, Cibles.NOUVELLE_INSTRUCTION);
		
		// Attendre la présence d'un élément
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_SOUMETTRE_DONNEES_CLIENTS);
		//Soumettre les données clients
		outil.action(Actions.CLIQUER, Cibles.BOUTON_SOUMETTRE_DONNEES_CLIENTS);
		
		//Remplir le champs "Augmentation suite à"
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.SELECTION_CHAMP_AUGSUITEA);
		outil.action(Actions.SELECTIONNER, Cibles.SELECTION_CHAMP_AUGSUITEA, Constantes.VALEUR_CHAMP_AUGSUITEA);
		
		//Remplir le champs "Montant du financement souhaité"
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.SAISIE_MONTANT_FIN_SOUHAITE);
		//outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);
		outil.saisieInstantanee(Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);
		
		
		//Nouvelle instruction jboss
		//outil.action(Actions.CLIQUER, Cibles.NOUVELLE_INSTRUCTION);
		
		// Attendre la présence d'un élément
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_SOUMETTRE_PROPOSITION);
		//Soumettre la proposition d'augmentation de CMA
		outil.action(Actions.CLIQUER, Cibles.BOUTON_SOUMETTRE_PROPOSITION);
		
		//Remplir le champs "Montant du financement souhaité"
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_VALIDER_CONTRAT);
		//outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);
		outil.saisieInstantanee(Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);
		
		

		// Attendre la présence d'un élément
		//outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_VALIDER_CONTRAT);
		//Valider la proposition en contrat de crédit
		outil.action(Actions.CLIQUER, Cibles.BOUTON_VALIDER_CONTRAT);
		
		//System.exit(0);
		
		///////	PAGE EDITION LIASSE - STATUT VALD ////////////////
		
		//Remplir le champs "Montant du financement souhaité"
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.SAISIE_MONTANT_FIN);
		outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MONTANT_FIN, Constantes.VALEUR_MONTANT_FIN_DEUX);
		
		// Attendre la présence d'un élément
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_EDITION_CONTRAT);
		//Valider la proposition en contrat de crédit
		outil.action(Actions.CLIQUER, Cibles.BOUTON_EDITION_CONTRAT);
		
		///////	PAGE EDITION LIASSE - STATUT EDIT ////////////////
		// Attendre la présence d'un élément
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_ETUDE_DOSSIER);
		//Valider la proposition en contrat de crédit
		outil.action(Actions.CLIQUER, Cibles.BOUTON_ETUDE_DOSSIER);
		
		///////	PAGE EDITION LIASSE -POPUP- STATUT ETUD ////////////////
		// Attendre la présence d'un élément
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_FERMER_APPLICATION);
		//Valider la proposition en contrat de crédit
		outil.action(Actions.CLIQUER, Cibles.BOUTON_FERMER_APPLICATION);
		
		
		//////////////RECUPERATION DE LIASSE//////////////////////////
	}

}
