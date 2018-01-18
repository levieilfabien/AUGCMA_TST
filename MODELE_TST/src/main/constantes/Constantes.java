package main.constantes;

import outils.PropertiesOutil;

/**
 * Ensemble des constantes manipul�es par les tests.
 * @author levieilfa
 *
 */
public class Constantes {
	
	//////////////////////////////////////////////////// INFORMATIONS TECHNIQUES ////////////////////////////////////////////////////////////////
	public static final String EMPLACEMENT_FIREFOX = PropertiesOutil.getInfoConstante("EMPLACEMENT_FIREFOX");
	public static final String EMPLACEMENT_PROFIL = PropertiesOutil.getInfoConstante("EMPLACEMENT_PROFILE");
	public static final String EMPLACEMENT_GECKO =  System.setProperty("webdriver.gecko.driver", PropertiesOutil.getInfoConstante("EMPLACEMENT_GECKO"));
	public static final String EMPLACEMENT_LIASSE = PropertiesOutil.getInfoConstante("EMPLACEMENT_LIASSE");
	////////////////////////////////////////////////////INFORMATIONS POUR LES PREFERENCES ////////////////////////////////////////////////////////////
	public static final String PREF_FIREFOX_REPERTOIRE_TELECHARGEMENT = "browser.download.dir";
	
	//////////////////////////////////////////////////// INFORMATIONS POUR LES TESTS ////////////////////////////////////////////////////////////
	public static final String URL_GOOGLE = PropertiesOutil.getInfoConstante("URL_TEST");
	public static final String TITRE_PAGE = "Google";
}
