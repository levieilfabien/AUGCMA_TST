package test.java;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;

import constantes.Actions;
import exceptions.SeleniumException;
import main.bean.CasEssaiAugcmaBean;
import main.constantes.Cibles;
import main.constantes.Constantes;
import moteurs.FirefoxImpl;
import moteurs.GenericDriver;
import outils.SeleniumOutils;

public class SC01Login extends SC00Modele {

       /**
       * Id de serialisation.
       */
       private static final long serialVersionUID = 1L;

       @Test
       public void accesTest() throws SeleniumException {
              
              //Description du scénario
              CasEssaiAugcmaBean scenario0 = new CasEssaiAugcmaBean();
              
              ///////////////////////////////////////////////////Configuration////////////////////////////////////////////////
           SeleniumOutils outil = obtenirDriver(scenario0);          
           
              ///////////////////////////////////////////////////EXECUTION////////////////////////////////////////////////
              String url = Constantes.URL_APP_AUGCMA;
              String titre = Constantes.TITRE_PAGE_AUGCMA;

              // Accès à google
              outil.chargerUrl(url);
              
              // Attente de l'affichage du titre de la page
              outil.attendreChargementPage(titre);
              
              	// Remplir l identite 
      			//outil.action(Actions.SELECTIONNER, Cibles.SELECTION_CIVILITE_SAMY, "HOMME"); 
      			//outil.action(Actions.VIDER_ET_SAISIR, Cibles.SELECTION_NOM_SAMY, "LEMONSIEUR"); 
      			//outil.action(Actions.VIDER_ET_SAISIR, Cibles.SELECTION_PRENOM_SAMY, "KEVIN"); 
      			

       }
    
}
