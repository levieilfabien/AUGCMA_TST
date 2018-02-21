package test.java;

import org.junit.Test;

import constantes.Actions;
import exceptions.SeleniumException;
import main.bean.CasEssaiAugcmaBean;
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
		CasEssaiAugcmaBean scenario0 = new CasEssaiAugcmaBean();
		
		// Valorisation des données
		//scenario0.setNumeroDossier("41102478031100");
		//scenario0.setNumeroIUN("3209020");
		//scenario0.setDistributeur("CE");
		scenario0.setNumeroDossier("41000326032100");
		scenario0.setNumeroIUN("3108391");
		scenario0.setDistributeur("CE");

		/////////////////////////////////////////////////// Configuration////////////////////////////////////////////////
		SeleniumOutils outil = obtenirDriver(scenario0);

		/////////////////////////////////////////////////// EXECUTION////////////////////////////////////////////////
		String url = Constantes.URL_APP_AUGCMA;
		String titre = Constantes.TITRE_PAGE_AUGCMA;

		
		// Remplissage de l'URL
		//distributeur=[DISTRIBUTEUR]&iup=102769F&iun=[IUN]&mdpCommercial=[MDPUNITED]&idCommercial=[IDUNITED]&numContrat=[CONTRAT]&Profile=SAVCCO_OCT_I
		
		url = url.replace("[DISTRIBUTEUR]", scenario0.getDistributeur());
		url = url.replace("[IUN]", scenario0.getNumeroIUN());
		url = url.replace("[CONTRAT]", scenario0.getNumeroDossier());
		url = url.replace("[IDUNITED]", Constantes.ID_UNITED);
		url = url.replace("[MDPUNITED]", Constantes.PWD_UNITED);
		
		System.out.println(url);
		
		// Accès à augcma
		outil.chargerUrl(url);

		// Attente de l'affichage du titre de la page
		outil.attendreChargementPage(titre);

		// Remplir l'identifiant
		outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_IDENTIFIANT, Constantes.ID_AUGCMA);
		outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MOTDEPASSE, Constantes.PWD_AUGCMA);
		
		
		outil.action(Actions.CLIQUER, Cibles.VALIDER_LOGIN);
		
		
		//Annuler undossier déjà existant
		
		// Attendre la présence d'un élément
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_SOUMETTRE_DONNEES_CLIENTS);
		
		//Nouvelle instruction
		outil.action(Actions.CLIQUER, Cibles.NOUVELLE_INSTRUCTION);

		
		//Nouvelle instruction
		outil.action(Actions.CLIQUER, Cibles.NOUVELLE_INSTRUCTION);
	}

}
