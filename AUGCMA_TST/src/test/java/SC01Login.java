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
		this.setNomCasEssai("TNRSC01-" + getTime());
		this.setDescriptif("TNRSC01 - AUG CMA - Octroi avec mise sans suite");
		this.setIdConfluence("");
		
		
		// Valorisation des données
		setNumeroDossier("41000326032100");
		setNumeroIUN("3108391");
		setDistributeur("CE");

		/////////////////////////////////////////////////// Configuration////////////////////////////////////////////////
		SeleniumOutils outil = obtenirDriverChrome(this);

		
		
		try {
		/////////////////////////////////////////////////// EXECUTION////////////////////////////////////////////////

		this.getTests().add(CT01AccesViaLoginAugCma(this, outil));
		this.getTests().add(CT02NouvelleInstruction(this, outil));
		this.getTests().add(CT03NouvelleProposition(this, outil));
		this.getTests().add(CT04EditionLiasse(this, outil));
		this.getTests().add(CT05EtudeDossier(this, outil));
		this.getTests().add(CT06OctroiDossier(this, outil));
		
		
		//Fermer le naviguateur
		outil.getDriver().quit();
		
		} catch (SeleniumException ex) {
			// Finalisation en erreur du cas de test.
			finaliserTestEnErreur(outil, this, ex, this.getNomCasEssai() + this.getTime());
			throw ex;
		}
		// Finalisation normale du cas de test.
		finaliserTest(outil, this, this.getNomCasEssai() + this.getTime());
				
	}

}
