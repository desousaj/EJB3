package service;

import javax.ejb.Stateless;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.ejb.Remote;

import meserreurs.MonException;
import metier.Stage;
import persistance.DialogueBd;
import utilitaires.FonctionsUtiles;

/**
 * Session Bean implementation class StageBean
 */
@Stateless(mappedName = "StageEJB")
@Remote(StageBeanRemote.class)
public class StageBean implements StageBeanRemote {

    /**
     * Default constructor. 
     */
    public StageBean() {
        // TODO Auto-generated constructor stub
    }
    
    /* traitements métier */
	// /
	// / Insertion d'un stage
	// /
	public void insertionStage(Stage unS) throws MonException {
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			String mysql = "";
			String dd = FonctionsUtiles.DateToString(unS.getDatedebut(),
					"dd-MM-yyyy");
			String df = FonctionsUtiles.DateToString(unS.getDatefin(),
					"dd-MM-yyyy");

			mysql = "INSERT INTO stages (id, libelle, datedebut ,";
			mysql = mysql + " datefin, nbplaces, nbinscrits) ";
			mysql = mysql + " VALUES ( \'" + unS.getId() + "\', \'"
					+ unS.getLibelle() + "\', ";
			mysql = mysql + "\' " + dd + "\', " + "\' " + df + "\', ";
			mysql = mysql + unS.getNbplaces() + ", " + unS.getNbinscrits()
					+ " )";
			unDialogueBd.insertionBD(mysql);
		} catch (MonException e) {
			throw e;
		}
	}

	// /
	// / Affichage de la liste des stages
	// /
	public ArrayList<Stage> rechercheLesStages() throws Exception, MonException,
			ParseException {
		ArrayList<Object> rs;
		ArrayList<Stage> mesStages = new ArrayList<Stage>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			String mysql = "";

			mysql = "SELECT * FROM stages ORDER BY id ASC";

			rs = unDialogueBd.lecture(mysql);

			while (index < rs.size()) {
				// On crée un stage
				Stage unS = new Stage();
				// il faut redecouper la liste pour retrouver les lignes
				unS.setId(rs.get(index + 0).toString());
				unS.setLibelle(rs.get(index + 1).toString());
				DateFormat dateFormatpers = new SimpleDateFormat("yyyy-MM-dd");
				unS.setDatedebut(dateFormatpers.parse(rs.get(index + 2)
						.toString()));
				unS.setDatefin((dateFormatpers.parse(rs.get(index + 3)
						.toString())));
				unS.setNbplaces(Integer.parseInt(rs.get(index + 4).toString()));
				unS.setNbinscrits(Integer
						.parseInt(rs.get(index + 5).toString()));
				// On incrémente tous les n champs
				index = index + 6;
				mesStages.add(unS);

			}

			return mesStages;

		} catch (MonException e) {
			System.out.println(e.getMessage());
			throw e;
		} catch (Exception ne) {
			System.out.println(ne.getMessage());
			throw ne;
		}

	}

	// /
	// / Recherche d'un stage sur le numéro
	// /
	public Stage rechercheStageId(String id) throws MonException, Exception,
			ParseException {
		ArrayList<Object> rs;
		String mysql = "";
		Stage unStage = new Stage();
		int index = 0;
		try {

			mysql = "SELECT * FROM stages WHERE id = " + id + ";";

			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = unDialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On crée un stage

				// il faut redecouper la liste pour retrouver les lignes
				unStage.setId(rs.get(index + 0).toString());
				unStage.setLibelle(rs.get(index + 1).toString());
				DateFormat dateFormatpers = new SimpleDateFormat("yyyy-MM-dd");
				unStage.setDatedebut(dateFormatpers.parse(rs.get(index + 2)
						.toString()));
				unStage.setDatefin((dateFormatpers.parse(rs.get(index + 3)
						.toString())));
				unStage.setNbplaces(Integer.parseInt(rs.get(index + 4)
						.toString()));
				unStage.setNbinscrits(Integer.parseInt(rs.get(index + 5)
						.toString()));

				index = index + 6;
			}
			return unStage;

		} catch (MonException e) {

			throw e;
		} catch (Exception e) {

			throw e;
		}

	}

	// /
	// / Recherche d'un stage sur le libellé
	// /
	public Stage rechercheStageLibelle(String libelle) throws MonException,
			Exception {
		ArrayList<Object> rs;
		String mysql = "";
		Stage unStage = new Stage();
		int index = 0;
		try {
			mysql = "SELECT * FROM stages WHERE libelle = '" + libelle + "';";

			DialogueBd unDialogueBd = DialogueBd.getInstance();
			System.out.println(mysql);
			rs = unDialogueBd.lecture(mysql);
			while (index < rs.size()) {
				// On crée un stage

				// il faut redecouper la liste pour retrouver les lignes
				unStage.setId(rs.get(index + 0).toString());
				unStage.setLibelle(rs.get(index + 1).toString());
				DateFormat dateFormatpers = new SimpleDateFormat("yyyy-MM-dd");
				unStage.setDatedebut(dateFormatpers.parse(rs.get(index + 2)
						.toString()));
				unStage.setDatefin((dateFormatpers.parse(rs.get(index + 3)
						.toString())));
				unStage.setNbplaces(Integer.parseInt(rs.get(index + 4)
						.toString()));
				unStage.setNbinscrits(Integer.parseInt(rs.get(index + 5)
						.toString()));
				index = index + 6;
			}
			return unStage;

		} catch (MonException e) {

			throw e;
		}

	}

	// /
	// / Suppression d'un stage
	// /
	public void suppressionStage(String id) throws MonException {
		String mysql = "";
		try {

			mysql = "DELETE FROM stages WHERE id = \'" + id + "\'";

			DialogueBd unDialogueBd = DialogueBd.getInstance();
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	// /
	// / Modification d'un stage
	// /
	public void modificationStage(Stage unstage) throws MonException, Exception {
		String mysql = "";
		System.out.println("J'arrive");

		try {

			String dd = FonctionsUtiles.DateToString(unstage.getDatedebut(),
					"dd-MM-yyyy");
			String df = FonctionsUtiles.DateToString(unstage.getDatefin(),
					"dd-MM-yyyy");
			mysql = "UPDATE stages SET libelle =" + "\'" + unstage.getLibelle()
					+ "\', ";
			mysql = mysql + "datedebut =" + "\'" + dd + "\', ";
			mysql = mysql + "datefin = " + "\'" + df + "\', ";
			mysql = mysql + "nbplaces = " + unstage.getNbplaces() + ", ";
			mysql = mysql + "nbinscrits = " + unstage.getNbinscrits();
			mysql = mysql + " " + "WHERE id = " + unstage.getId() + ";";

			DialogueBd unDialogueBd = DialogueBd.getInstance();
			unDialogueBd.execute(mysql);
		} catch (MonException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

	}
	

}