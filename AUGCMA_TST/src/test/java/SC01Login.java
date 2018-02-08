package test.java;

import org.junit.Test;

import exceptions.SeleniumException;
import main.bean.CasEssaiAugcmaBean;
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
		scenario0.setNumeroDossier("41102478031100");
		scenario0.setNumeroIUN("3209020");
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
		
		// Accès à google
		outil.chargerUrl(url);

		// Attente de l'affichage du titre de la page
		outil.attendreChargementPage(titre);

		// Remplir l identite
		// outil.action(Actions.SELECTIONNER, Cibles.SELECTION_CIVILITE_SAMY,
		// "HOMME");
		// outil.action(Actions.VIDER_ET_SAISIR, Cibles.SELECTION_NOM_SAMY,
		// "LEMONSIEUR");
		// outil.action(Actions.VIDER_ET_SAISIR, Cibles.SELECTION_PRENOM_SAMY,
		// "KEVIN");

	}

}
