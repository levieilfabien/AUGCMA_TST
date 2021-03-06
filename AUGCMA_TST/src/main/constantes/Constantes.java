package main.constantes;

import outils.PropertiesOutil;

/**
 * Ensemble des constantes manipulées par les tests.
 * @author levieilfa
 *
 */
public class Constantes {
	
	//////////////////////////////////////////////////// INFORMATIONS TECHNIQUES ////////////////////////////////////////////////////////////////
	public static final String EMPLACEMENT_FIREFOX = PropertiesOutil.getInfoConstante("EMPLACEMENT_FIREFOX");
	public static final String EMPLACEMENT_PROFIL = PropertiesOutil.getInfoConstante("EMPLACEMENT_PROFILE");
	public static final String EMPLACEMENT_GECKO =  System.setProperty("webdriver.gecko.driver", PropertiesOutil.getInfoConstante("EMPLACEMENT_GECKO"));
	public static final String EMPLACEMENT_LIASSE = PropertiesOutil.getInfoConstante("EMPLACEMENT_LIASSE");
	public static final String EMPLACEMENT_CHROME = PropertiesOutil.getInfoConstante("EMPLACEMENT_CHROME");
	public static final String EMPLACEMENT_CHROME_DRIVER = System.setProperty("webdriver.chrome.driver", PropertiesOutil.getInfoConstante("EMPLACEMENT_CHROME_DRIVER"));
	
	////////////////////////////////////////////////////INFORMATIONS POUR LES PREFERENCES ////////////////////////////////////////////////////////////
	public static final String PREF_FIREFOX_REPERTOIRE_TELECHARGEMENT = "browser.download.dir";
	
	//////////////////////////////////////////////////// INFORMATIONS POUR LES TESTS ////////////////////////////////////////////////////////////
	public static final String URL_GOOGLE = PropertiesOutil.getInfoConstante("URL_TEST");
	public static final String TITRE_PAGE = "Google";

	public static final String URL_APP_AUGCMA = PropertiesOutil.getInfoConstante("URL_AUGCMA");
	public static final String ID_UNITED = PropertiesOutil.getInfoConstante("UNITED.login");
	public static final String PWD_UNITED = PropertiesOutil.getInfoConstante("UNITED.password");
	public static final String TITRE_PAGE_AUGCMA = "nxs - Augmentation de CMA - BL A_CEB:1.4_09_BL_GENERIC";
	
	public static final String ID_AUGCMA = PropertiesOutil.getInfoConstante("AUGCMA.login");
	public static final String PWD_AUGCMA = PropertiesOutil.getInfoConstante("AUGCMA.password");
	
	/////////////////////////////////////////////////// VALEURS BLOC PROPOSITION ////////////////////////////////////////////////////////////////////
	public static final String VALEUR_CHAMP_AUGSUITEA = "OR1";
	public static final String VALEUR_MONTANT_FIN_UN = "";
	public static final String VALEUR_MONTANT_FIN_DEUX = "1000";
}
