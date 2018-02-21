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
		SeleniumOutils outil = obtenirDriver(this);

		/////////////////////////////////////////////////// EXECUTION////////////////////////////////////////////////
		// Accès à AUG CMA
		accesAugCma(outil);

		// S'identifier sur l'appliation
		identificationAugCma(outil);
		
		////// SI DOSSIER DEJA EXISTANT /////////
		//Annuler un dossier déjà existant
		if(outil.testerPresenceElementDiffere(Cibles.METTRE_SANS_SUITE)) {
			outil.action(Actions.CLIQUER, Cibles.METTRE_SANS_SUITE);
			
			//Sélectionner motif d'annulation
			outil.action(Actions.CLIQUER, Cibles.MOTIF_ANNULATION);
			
			// Attente disponibilite bouton valider
			outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.VALIDER_ANNULATION);
			
			//Sélectionner motif d'annulation
			outil.action(Actions.CLIQUER, Cibles.VALIDER_ANNULATION);
			
			// Accès à AUG CMA
			accesAugCma(outil);

			// S'identifier sur l'appliation
			identificationAugCma(outil);
		}	
		
		///// SI AUCUN DOSSIER EN COURS /////////
		// Attendre la présence d'un élément
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_SOUMETTRE_DONNEES_CLIENTS);
		
		//Soumettre les données clients
		outil.action(Actions.CLIQUER, Cibles.BOUTON_SOUMETTRE_DONNEES_CLIENTS);
		
		//Remplir le champs "Augmentation suite à"
		outil.action(Actions.SELECTIONNER, Cibles.SELECTION_CHAMP_AUGSUITEA, Constantes.VALEUR_CHAMP_AUGSUITEA);
		
		//Nouvelle instruction jboss
		//outil.action(Actions.CLIQUER, Cibles.NOUVELLE_INSTRUCTION);
		
		//Soumettre la proposition d'augmentation de CMA
		outil.action(Actions.CLIQUER, Cibles.BOUTON_SOUMETTRE_PROPOSITION);

	}

}
