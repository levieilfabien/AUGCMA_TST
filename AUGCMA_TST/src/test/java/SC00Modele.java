package test.java;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.RemoteWebDriver;

import beans.CasEssaiBean;
import beans.ObjectifBean;
import constantes.Actions;
import exceptions.SeleniumException;
import main.bean.CasEssaiAugcmaBean;
import main.constantes.Cibles;
import main.constantes.Constantes;
import moteurs.ChromeImpl;
import moteurs.FirefoxImpl;
import moteurs.GenericDriver;
import outils.ALMOutils;
import outils.SeleniumOutils;
import outils.XLSOutils;
//import src.test.java.String;

public class SC00Modele extends CasEssaiAugcmaBean {
	
	/**
	 * Id de serialisation.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Créer le repertoire de téléchargement pour le cas d'essai.
	 * @param profile le profil firefox utilisé
	 * @param casEssai le cas d'essai
	 * @return le chemin du repertoire.
	 */
	public String creerRepertoireTelechargement(CasEssaiBean casEssai, FirefoxProfile profile) {
		File repertoireTelechargement = new File(".\\" + casEssai.getNomCasEssai());
		repertoireTelechargement.mkdir();
		profile.setPreference(Constantes.PREF_FIREFOX_REPERTOIRE_TELECHARGEMENT, repertoireTelechargement.getAbsolutePath());
		return repertoireTelechargement.getAbsolutePath();
	}
	
	/**
	 * Configuration du profil pour test.
	 * @return Le profil utiliser sur le modèle du profil "Automate"
	 */
	public static FirefoxProfile configurerProfilNatixis() {
		
		// Initialisation du profil avec le profil automate requis
		ProfilesIni profileIni = new ProfilesIni();
		//FirefoxProfile profile = profileIni.getProfile("Automate");
		FirefoxProfile profile = new FirefoxProfile(new File(Constantes.EMPLACEMENT_PROFIL));
		
		profile.setPreference("app.update.enabled", Boolean.FALSE);
		profile.setPreference("network.negotiate-auth.trusted-uris", "https://open-workplace.intranatixis.com/nfi/front-middle/wiki-izivente/Rfrentiel/Liens%20Izivente.aspx");
		profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "https://open-workplace.intranatixis.com/nfi/front-middle/wiki-izivente/Rfrentiel/Liens%20Izivente.aspx");
		
		profile.setPreference("browser.download.pluginOverrideTypes", "");
		profile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf,application/vnd.fdf,application/vnd.adobe.xfdf,application/vnd.adobe.xdp+xml");
		
		profile.setPreference("pdfjs.disabled", Boolean.TRUE);
		profile.setPreference("pdfjs.firstRun", Boolean.FALSE);
		profile.setPreference("pdfjs.previousHandler.alwaysAskBeforeHandling", Boolean.FALSE);
		profile.setPreference("pdfjs.previousHandler.preferredAction", 4);
		profile.setPreference("pdfjs.disabled", Boolean.TRUE);
		
		profile.setPreference("browser.download.useDownloadDir", Boolean.TRUE);
		profile.setPreference("browser.download.manager.focusWhenStarting", Boolean.FALSE);
		profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", new File(".\\").getAbsolutePath());
        
        //browser.download.panel.shown
        profile.setPreference("browser.helperApps.alwaysAsk.force", Boolean.FALSE);
        profile.setPreference("browser.download.manager.showWhenStarting", Boolean.FALSE);
        profile.setPreference("browser.download.manager.useWindow", Boolean.FALSE);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf,text/pdf,application/octet-stream,application/x-pdf,text/plain,text/xml");

		return profile;
	}
	
	/**
	 * Permet de finaliser le cas d'essai en erreur.
	 * @param outil la boite à outil
	 * @param casEssai le cas d'essai
	 * @param ex l'exception générant l'erreur
	 * @throws SeleniumException en cas d'erreur.
	 */
	public final void finaliserTestEnErreur(final SeleniumOutils outil, final CasEssaiBean casEssai, final SeleniumException ex, final String idObjectif) throws SeleniumException {
		ex.printStackTrace();
		casEssai.setCommentaire(ex.toString());
		logger(ex.toString());
		finaliserTest(outil, casEssai, idObjectif, false);
	}

	/**
	 * Finalise l'execution d'un test en renseignant les log du cas d'essai et du test à  partir des
	 * logs du driver.
	 * 
	 * @param outils le driver.
	 * @param casEssai le cas d'essai concerné par le test.
	 * @throws SeleniumException en cas d'erreur lors de la génération du fichier excel de rapport.
	 */
	private void finaliserTest(SeleniumOutils outils, CasEssaiBean casEssai, final String idObjectif, boolean succes) throws SeleniumException {
		// On finalise aussi les sous cas.
		for(CasEssaiBean sousCas : casEssai.getTests()) {
			finaliserTest(outils, sousCas, casEssai.getNomCasEssai() + casEssai.getTime(), sousCas.getEtatFinal());
		}
		// Si le driver n'est pas nul on effectue des capture d'écran et on récupère les logs.
		if (outils != null) {
			casEssai.setRegistreExecution(outils.getDriver());
			logger(casEssai.getRegistreExecution() + "\n" + casEssai.toString());
			if (casEssai.getRepertoireTelechargement() != null) {
				outils.captureEcran("captureFinale" + casEssai.getNomCasEssai(), casEssai.getRepertoireTelechargement());
			} else {
				outils.captureEcran("captureFinale" + casEssai.getNomCasEssai(), casEssai.getNomCasEssai());
			}
		}
		// On valide l'objectif en fonction du succès du cas de test.
		casEssai.validerObjectif(outils.getDriver(), idObjectif, succes);
		//setCasEssai(casEssai);

		logger(casEssai.toString());

		//TODO A remettre
//		if (outils != null) {
//			outils.getDriver().quit();
//		}

		// On renseigne le rapport d'execution avec les données du cas de test.
		XLSOutils.renseignerExcel(casEssai);
		
		// On tente de mettre à jour ALM
		if (casEssai.getAlm()) {
			try {
				ALMOutils.miseAJourTestSet(casEssai, succes);
				System.out.println("Mise à jour effectuée dans ALM");
			} catch (SeleniumException ex) {
				ex.printStackTrace();
				System.out.println("Mise à jour impossible à effectuée dans ALM : " + ex.toString());
			}	
		}
	}
	
	/**
	 * Fonction de finalisation de test.
	 * @param outil la boite à outil.
	 * @param casEssai le cas d'essai.
	 * @param idObjectif l'id de l'objectif final.
	 * @throws SeleniumException en cas d'erreur.
	 */
	public final void finaliserTest(SeleniumOutils outil, CasEssaiBean casEssai, final String idObjectif) throws SeleniumException {
		finaliserTest(outil, casEssai, idObjectif, true);
	}
	
	/**
	 * Permet d'ajouter une ligne dans le registre d'execution pour apporter plus d'informations.
	 * @param append la chaine de caractère à  ajouter dans le registre d'execution.
	 */
	public final void logger(final String append) {
		if (getLogs() != null) {
			setLogs(getLogs() + "\n" + append);
		} else {
			setLogs(append);
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// FONCTION COMMUNES :
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//public String accesGoogle(SeleniumOutils outil) throws SeleniumException {
		
		//String url = Constantes.URL_GOOGLE;
		//String titre = Constantes.TITRE_PAGE;

		// Accès à google
		//outil.chargerUrl(url);
		
		// Attente de l'affichage du titre de la page
		//outil.attendreChargementPage(titre);

		//return "OK";
	//}
	

	/**
	 * Permet d'obtenir la boite a outil Selenium associe a un driver pour le scenario donne.
	 * @param scenario0 le scenario concerne.
	 * @return la boite a outil Selenium associee au scenario.
	 */
	
	
	
	public SeleniumOutils obtenirDriverChrome(CasEssaiAugcmaBean scenario0) {

		//Configuration du driver
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("useAutomationExtension", false);
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		if (scenario0.getRepertoireTelechargement() == null) { 
			File repertoireTelechargement = new File(".\\" + scenario0.getNomCasEssai());
			repertoireTelechargement.mkdir();
			chromePrefs.put("download.default_directory", repertoireTelechargement.getAbsolutePath());
		}
		option.setExperimentalOption("prefs", chromePrefs);
		option.setBinary(Constantes.EMPLACEMENT_CHROME);

//		if (scenario0.getRepertoireTelechargement() == null) { 
//			String repertoire = creerRepertoireTelechargement(scenario0, repertoireTelechargement.getAbsolutePath());
//			scenario0.setRepertoireTelechargement(repertoire);
//			this.setRepertoireTelechargement(repertoire);
//		}
		// Initialisation du driver
		//FirefoxImpl driver = new FirefoxImpl(ffBinary, profile);
		ChromeImpl driver = new ChromeImpl(option);;
		
		driver.get(Constantes.URL_APP_AUGCMA);

		
	    SeleniumOutils outil = new SeleniumOutils(driver, GenericDriver.CHROME_IMPL);
	    outil.setRepertoireRacine(scenario0.getRepertoireTelechargement());
		
		return outil;
	}
	
	/**
	 * Permet d'obtenir la boite a outil Selenium associe a un driver pour le scenario donne.
	 * @param scenario0 le scenario concerne.
	 * @return la boite a outil Selenium associee au scenario.
	 */
	public SeleniumOutils obtenirDriver(CasEssaiAugcmaBean scenario0) {
		//Configuration du driver
		FirefoxBinary ffBinary = new FirefoxBinary(new File(Constantes.EMPLACEMENT_FIREFOX));
		FirefoxProfile profile = configurerProfilNatixis();

		if (scenario0.getRepertoireTelechargement() == null) { 
			String repertoire = creerRepertoireTelechargement(scenario0, profile);
			scenario0.setRepertoireTelechargement(repertoire);
			this.setRepertoireTelechargement(repertoire);
		}
		// Initialisation du driver
		//FirefoxImpl driver = new FirefoxImpl(ffBinary, profile);
		FirefoxImpl driver = new FirefoxImpl(ffBinary, profile);
		
		driver.get(Constantes.URL_APP_AUGCMA);

		
	    SeleniumOutils outil = new SeleniumOutils(driver, GenericDriver.CHROME_IMPL);
	    outil.setRepertoireRacine(scenario0.getRepertoireTelechargement());
		
		return outil;
	}
	
	
	
	/**
	 * Fonction de login à l'application AUG CMA.
	 * @param outil la boite à outil
	 * @throws SeleniumException en cas d'erreur.
	 */
	public void identificationAugCma(SeleniumOutils outil) throws SeleniumException {
		// Remplir l'identifiant et validation
		outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_IDENTIFIANT, Constantes.ID_AUGCMA);
		outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MOTDEPASSE, Constantes.PWD_AUGCMA);
		outil.action(Actions.CLIQUER, Cibles.VALIDER_LOGIN);
	}

		

	/**
	 * Fonction pour l'exécution du CT01 : Accès AugCma et login
	 * @param scenario0
	 * @param outil
	 * @return
	 * @throws SeleniumException
	 */
	public CasEssaiAugcmaBean CT01AccesViaLoginAugCma(CasEssaiAugcmaBean scenario0, SeleniumOutils outil) throws SeleniumException {

		// Déclaration du cas de test numéro 1
		CasEssaiAugcmaBean CT01 = new CasEssaiAugcmaBean();
		CT01.setAlm(scenario0.getAlm());
		CT01.setNomCasEssai("CT01 -" + getTime());
		CT01.setRepertoireTelechargement(scenario0.getRepertoireTelechargement());	
		
		//Gestion des steps
		CT01.ajouterObjectif(new ObjectifBean("Test arrive a terme", CT01.getNomCasEssai() + CT01.getTime()));
		CT01.ajouterStep("Ouverture de l'url d'accès à AugCma", "ACCESAUGCMA", "La page de login AugCma s'affiche");
		CT01.ajouterStep("Renseignement des identifiants et validation", "LOGINAUGCMA", "Les idneitifants sont corrects et la page AugCma s'ouvre pour le dossier demandé");
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Déroulement du cas de test
 		///////////////////////////////////////////////////////////////////////////////////////////////////////

		
		////////////////// Configuration////////////////////////////////////////////////
		String url = Constantes.URL_APP_AUGCMA;
		String titre = Constantes.TITRE_PAGE_AUGCMA;

		//Remplissage de l'URL
		url = url.replace("[DISTRIBUTEUR]", getDistributeur());
		url = url.replace("[IUN]", getNumeroIUN());
		url = url.replace("[CONTRAT]", getNumeroDossier());
		url = url.replace("[IDUNITED]", Constantes.ID_UNITED);
		url = url.replace("[MDPUNITED]", Constantes.PWD_UNITED);
		System.out.println(url);

		// Accès à AugCma
		outil.chargerUrl(url);
		outil.attendreChargementPage(titre);
		CT01.validerObjectif(outil.getDriver(), "ACCESAUGCMA", true);
		
		// Remplir l'identifiant et validation
		outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_IDENTIFIANT, Constantes.ID_AUGCMA);
		outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MOTDEPASSE, Constantes.PWD_AUGCMA);
		outil.action(Actions.CLIQUER, Cibles.VALIDER_LOGIN);
        
		// Attente de l'affichage du titre de la page
		outil.attendreChargementPage(titre);
		CT01.validerObjectif(outil.getDriver(), "LOGINAUGCMA", true);
		
		return CT01;
	}
	
	/**
	 * Fonction pour l'exécution du CT02 : début d'une nouvelle souscription
	 * @param scenario0
	 * @param outil
	 * @return
	 * @throws SeleniumException
	 */
	public CasEssaiAugcmaBean CT02NouvelleInstruction(CasEssaiAugcmaBean scenario0, SeleniumOutils outil) throws SeleniumException {

		
		String url = Constantes.URL_APP_AUGCMA;

		//Remplissage de l'URL
		url = url.replace("[DISTRIBUTEUR]", getDistributeur());
		url = url.replace("[IUN]", getNumeroIUN());
		url = url.replace("[CONTRAT]", getNumeroDossier());
		url = url.replace("[IDUNITED]", Constantes.ID_UNITED);
		url = url.replace("[MDPUNITED]", Constantes.PWD_UNITED);
		System.out.println(url);
		
		// Déclaration du cas de test numéro 2
		CasEssaiAugcmaBean CT02 = new CasEssaiAugcmaBean();
		CT02.setAlm(scenario0.getAlm());
		CT02.setNomCasEssai("CT02 -" + getTime());
		CT02.setRepertoireTelechargement(scenario0.getRepertoireTelechargement());	
		
		//Gestion des steps
		CT02.ajouterObjectif(new ObjectifBean("Test arrive a terme", CT02.getNomCasEssai() + CT02.getTime()));
		CT02.ajouterStep("Lancer une nouvelle soucription", "NOUVELLEINSTRUCTION", "La page de proposition s'affiche");
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Déroulement du cas de test
 		///////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
			////// SI DOSSIER DEJA EXISTANT /////////
				//Annuler un dossier déjà existant
				if(outil.testerPresenceElementDiffere(Cibles.METTRE_SANS_SUITE)) {
								
					//Mettre sans suite, sélectionner motif d'annulation puis valider
					outil.action(Actions.CLIQUER, Cibles.METTRE_SANS_SUITE);
					outil.action(Actions.CLIQUER, Cibles.MOTIF_ANNULATION);
					outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.VALIDER_ANNULATION);
					outil.action(Actions.CLIQUER, Cibles.VALIDER_ANNULATION);
					
					// Accès à AUG CMA
					//accesAugCma(outil);
					outil.chargerUrl(url);
					// S'identifier sur l'appliation
					//identificationAugCma(outil);
				}
		
			//Lancer une nouvelle instruction
			outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.NOUVELLE_INSTRUCTION);
			outil.action(Actions.CLIQUER, Cibles.NOUVELLE_INSTRUCTION);
				
			//Soumettre les données clients
			outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_SOUMETTRE_DONNEES_CLIENTS);
			outil.action(Actions.CLIQUER, Cibles.BOUTON_SOUMETTRE_DONNEES_CLIENTS);
				
				
		CT02.validerObjectif(outil.getDriver(), "NOUVELLEINSTRUCTION", true);
		
		return CT02;
	}
	
	/**
	 * Fonction pour l'exécution du CT03 : Nouvelle proposition de contrat
	 * @param scenario0
	 * @param outil
	 * @return
	 * @throws SeleniumException
	 */
	public CasEssaiAugcmaBean CT03NouvelleProposition(CasEssaiAugcmaBean scenario0, SeleniumOutils outil) throws SeleniumException {

		// Déclaration du cas de test numéro 3
		CasEssaiAugcmaBean CT03 = new CasEssaiAugcmaBean();
		CT03.setAlm(scenario0.getAlm());
		CT03.setNomCasEssai("CT03 -" + getTime());
		CT03.setRepertoireTelechargement(scenario0.getRepertoireTelechargement());	
		
		//Gestion des steps
		CT03.ajouterObjectif(new ObjectifBean("Test arrive a terme", CT03.getNomCasEssai() + CT03.getTime()));
		CT03.ajouterStep("Remplir les champs requis dans l'encadré de proposition et valider", "RENSEIGNERPROPOSITION", "Les informations sont prises en compte et le bouton 'Valider en contrat de crédit' apparaît");
		CT03.ajouterStep("Valider la proposition de contrat ", "VALIDATIONPROPOSITION", "La page d'édition du contrat s'ouvre et le dossier passe à l'état VALD");
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Déroulement du cas de test
 		///////////////////////////////////////////////////////////////////////////////////////////////////////


		//Remplir les champs
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.SELECTION_CHAMP_AUGSUITEA);
		outil.action(Actions.SELECTIONNER, Cibles.SELECTION_CHAMP_AUGSUITEA, Constantes.VALEUR_CHAMP_AUGSUITEA);
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.SAISIE_MONTANT_FIN_SOUHAITE);
			//outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);
		outil.saisieInstantanee(Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);
		
		//Soumettre la proposition d'augmentation de CMA
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_SOUMETTRE_PROPOSITION);
		outil.action(Actions.CLIQUER, Cibles.BOUTON_SOUMETTRE_PROPOSITION);
		
		CT03.validerObjectif(outil.getDriver(), "RENSEIGNERPROPOSITION", true);
		

		//Remplir le champs "Montant du financement souhaité" une seconde fois (a supprimer une fois l'ano corrigée)
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_VALIDER_CONTRAT);
		outil.saisieInstantanee(Cibles.SAISIE_MONTANT_FIN_SOUHAITE, Constantes.VALEUR_MONTANT_FIN_UN);	
		//Valider la proposition en contrat de crédit
		outil.action(Actions.CLIQUER, Cibles.BOUTON_VALIDER_CONTRAT);
		
		CT03.validerObjectif(outil.getDriver(), "VALIDATIONPROPOSITION", true);
		
		return CT03;
	}
	
	/**
	 * Fonction pour l'exécution du CT04 : Edition de la liasse contractuelle
	 * @param scenario0
	 * @param outil
	 * @return
	 * @throws SeleniumException
	 */
	public CasEssaiAugcmaBean CT04EditionLiasse(CasEssaiAugcmaBean scenario0, SeleniumOutils outil) throws SeleniumException {

		// Déclaration du cas de test numéro 4
		CasEssaiAugcmaBean CT04 = new CasEssaiAugcmaBean();
		CT04.setAlm(scenario0.getAlm());
		CT04.setNomCasEssai("CT04 -" + getTime());
		CT04.setRepertoireTelechargement(scenario0.getRepertoireTelechargement());	
		
		//Gestion des steps
		CT04.ajouterObjectif(new ObjectifBean("Test arrive a terme", CT04.getNomCasEssai() + CT04.getTime()));
		CT04.ajouterStep("Editer la liasse contrat", "EDITIONLIASSE", "Le dossier passe à l'état EDIT");
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Déroulement du cas de test
 		///////////////////////////////////////////////////////////////////////////////////////////////////////
	
				//Remplir le champs "Montant du financement souhaité"
				outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.SAISIE_MONTANT_FIN);
				outil.action(Actions.VIDER_ET_SAISIR, Cibles.SAISIE_MONTANT_FIN, Constantes.VALEUR_MONTANT_FIN_DEUX);
				
				//Valider la proposition en contrat de crédit
				outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_EDITION_CONTRAT);
				outil.action(Actions.CLIQUER, Cibles.BOUTON_EDITION_CONTRAT);
				
				CT04.validerObjectif(outil.getDriver(), "EDITIONLIASSE", true);

		
		return CT04;
	}

	/**
	 * Fonction pour l'exécution du CT05 : Passer à l'étude du dossier
	 * @param scenario0
	 * @param outil
	 * @return
	 * @throws SeleniumException
	 */
	public CasEssaiAugcmaBean CT05EtudeDossier(CasEssaiAugcmaBean scenario0, SeleniumOutils outil) throws SeleniumException {


		String titre = Constantes.TITRE_PAGE_AUGCMA;
		
		// Déclaration du cas de test numéro 5
		CasEssaiAugcmaBean CT05 = new CasEssaiAugcmaBean();
		CT05.setAlm(scenario0.getAlm());
		CT05.setNomCasEssai("CT05 -" + getTime());
		CT05.setRepertoireTelechargement(scenario0.getRepertoireTelechargement());	
		
		//Gestion des steps
		CT05.ajouterObjectif(new ObjectifBean("Test arrive a terme", CT05.getNomCasEssai() + CT05.getTime()));
		CT05.ajouterStep("Envoyer le dossier à l'étude", "ETUDEDOSSIER", "Affichage d'une popup pour ferme l'application");
		CT05.ajouterStep("Fermeture de la page et rechargement", "ENVOIETUDE", "La page est rechargée et le dossier est à l'état ETUD");
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Déroulement du cas de test
 		///////////////////////////////////////////////////////////////////////////////////////////////////////
		
		////////////////// Configuration////////////////////////////////////////////////
		String url = Constantes.URL_APP_AUGCMA;


		//Remplissage de l'URL
		url = url.replace("[DISTRIBUTEUR]", getDistributeur());
		url = url.replace("[IUN]", getNumeroIUN());
		url = url.replace("[CONTRAT]", getNumeroDossier());
		url = url.replace("[IDUNITED]", Constantes.ID_UNITED);
		url = url.replace("[MDPUNITED]", Constantes.PWD_UNITED);
		System.out.println(url);

		// TODO ANOMALIE SUR L'IMPOSSIBILITE DE POURSUIVRE LE PROCESS SANS RECHARGER LA PAGE

		// Rechargement AUG CMA
		outil.chargerUrl(url);		
		//Valider la proposition en contrat de crédit
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_ETUDE_DOSSIER);
		outil.action(Actions.CLIQUER, Cibles.BOUTON_ETUDE_DOSSIER);
		//System.exit(0);		
		//Valider la fermeture de l'application
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_FERMER_APPLICATION);
		
		CT05.validerObjectif(outil.getDriver(), "ETUDEDOSSIER", true);
			
			
		outil.action(Actions.CLIQUER, Cibles.BOUTON_FERMER_APPLICATION);
		outil.chargerUrl(url);	
		outil.attendreChargementPage(titre);
		
		CT05.validerObjectif(outil.getDriver(), "ENVOIETUDE", true);
		
		return CT05;
	}
	
	/**
	 * Fonction pour l'exécution du CT06 : Octroi du dossier
	 * @param scenario0
	 * @param outil
	 * @return
	 * @throws SeleniumException
	 */
	public CasEssaiAugcmaBean CT06OctroiDossier(CasEssaiAugcmaBean scenario0, SeleniumOutils outil) throws SeleniumException {

		// Déclaration du cas de test numéro 6
		CasEssaiAugcmaBean CT06 = new CasEssaiAugcmaBean();
		CT06.setAlm(scenario0.getAlm());
		CT06.setNomCasEssai("CT06 -" + getTime());
		CT06.setRepertoireTelechargement(scenario0.getRepertoireTelechargement());	
		
		//Gestion des steps
		CT06.ajouterObjectif(new ObjectifBean("Test arrive a terme", CT06.getNomCasEssai() + CT06.getTime()));
		CT06.ajouterStep("Accéder à la page d'octroi", "ACCESOCTROI", "La page s'ouvre");
		CT06.ajouterStep("Renseignement de la date de signature", "DATESIGNATURE", "La date du jour est renseignée");
		CT06.ajouterStep("Renseignement des boutons radio et de la décision d'octroi", "DECISIONOCTROI", "Les boutons radio sont renseignés correctement");
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		// Déroulement du cas de test
 		///////////////////////////////////////////////////////////////////////////////////////////////////////

		
		//Entamer la procédure d'octroi
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_SOUMETTRE_DONNEES_OCTROI);
		outil.action(Actions.CLIQUER, Cibles.BOUTON_SOUMETTRE_DONNEES_OCTROI);
		
		CT06.validerObjectif(outil.getDriver(), "ACCESOCTROI", true);

		
		//Renseigner la date de signature
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.CALENDRIER_DATE_SIGNATURE);
		outil.action(Actions.CLIQUER, Cibles.CALENDRIER_DATE_SIGNATURE);
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.SELECTION_DATE_SIGNATURE);
		outil.action(Actions.CLIQUER, Cibles.SELECTION_DATE_SIGNATURE);
				
				
		CT06.validerObjectif(outil.getDriver(), "DATESIGNATURE", true);
		
		
		/////////// BOUTONS RADIO /////////////////////////////////
		//Indiquer la bonne validation de la liasse
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_RADIO_LIASSE_VALIDEE);
		outil.action(Actions.CLIQUER, Cibles.BOUTON_RADIO_LIASSE_VALIDEE);
		
		//Refuser le financement à 8 jours
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_RADIO_FINANCEMENT_REFUS);
		outil.action(Actions.CLIQUER, Cibles.BOUTON_RADIO_FINANCEMENT_REFUS);
				
		//Indiquer que le justificatif est validé
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_RADIO_VALIDATION_JUSTIFICATIF);
		outil.action(Actions.CLIQUER, Cibles.BOUTON_RADIO_VALIDATION_JUSTIFICATIF);
				
		//Indiquer la décision favorable pour l'octroi
		outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.BOUTON_RADIO_DECISION_OCTROI_OK);
		outil.action(Actions.CLIQUER, Cibles.BOUTON_RADIO_DECISION_OCTROI_OK);
		
		CT06.validerObjectif(outil.getDriver(), "DECISIONOCTROI", true);

		
		return CT06;
	}
	
	
	
//	public void executionTestAugCma(SeleniumOutils outil) throws SeleniumException {
//	////// SI DOSSIER DEJA EXISTANT /////////
//			//Annuler un dossier déjà existant
//			if(outil.testerPresenceElementDiffere(Cibles.METTRE_SANS_SUITE)) {
//							
//				//Mettre sans suite, sélectionner motif d'annulation puis valider
//				outil.action(Actions.CLIQUER, Cibles.METTRE_SANS_SUITE);
//				outil.action(Actions.CLIQUER, Cibles.MOTIF_ANNULATION);
//				outil.action(Actions.ATTENDRE_DISPONIBILITE_ELEMENT, Cibles.VALIDER_ANNULATION);
//				outil.action(Actions.CLIQUER, Cibles.VALIDER_ANNULATION);
//				
//				// Accès à AUG CMA
//				accesAugCma(outil);
//
//				// S'identifier sur l'appliation
//				//identificationAugCma(outil);
//			}	
			
		
	}	
	
	

