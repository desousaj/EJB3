package controle;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import meserreurs.MonException;
import metier.Stage;
import service.StageBean;
import service.StageBeanRemote;
import utils.Utils;

public class Controleur extends HttpServlet {
	@EJB
	private StageBeanRemote unEjbStage = null;

	private static String getLookupNom() {
		/*
		 * appname désigne le nom de l'EAR qui es déployé. Le suffixe ear est
		 * absent. Ce nom peut être laissé vide mais il est préférable de le
		 * renseigner
		 */
		String appName = "";
		/*
		 * modulename désigne le nom du JAR dans le quel l'EJB est encapsulé.
		 */
		String moduleName = "";
		/*
		 * ce nom n'est pas renseigné
		 */
		String distinctName = "";
		// Le nom de la classe Bean de l'EJB
		String beanName = StageBean.class.getSimpleName();
		// le nom de l'interface de l'EJB
		final String interfaceName = StageBeanRemote.class.getName();
		// on crée la chaîne pour former le nom de la recherche
		String nom = "ejb:" + appName + "/" + moduleName + "/" + distinctName
				+ "/" + beanName + "!" + interfaceName;
		return nom;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			try {
				// on appelle l'EJB
				Context ctx = JBossContext.getInitialContext();
				String nom = getLookupNom();
				unEjbStage = (StageBeanRemote) ctx.lookup("nom");
			} catch (NamingException ne) {
				request.setAttribute("MesErreurs", ne.getMessage());
			}
			processusTraiteRequete(request, response);
		} catch (Exception e) {
			String destinationPage = "/Erreur.jsp";
			request.setAttribute("MesErreurs", e.getMessage());
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(destinationPage);
			dispatcher.forward(request, response);
		}
	}

	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";

	// Action sur les stages
	private static final String SAISIE_STAGE = "saisieStage";
	private static final String AFFICHER_STAGE = "afficheStage";
	private static final String AJOUT_STAGE = "ajoutStage";
	private static final String AFFICHER_MODIFIER_STAGE = "aficherModifierStage";
	private static final String MODIFIER_STAGE = "modifierStage";

	private static final String RECHERCHER_STAGE = "rechercherStages";
	private static final String SUPPRIMER_STAGE = "supprimerStage";

	private static final String SAISIE_STAGIAIRE = "saisieStagiaire";
	private static final String AFFICHER_STAGIAIRE = "afficheStagiaire";
	private static final String AJOUT_STAGIAIRE = "ajoutStagiaire";
	private static final String ERROR_PAGE = null;

	protected void processusTraiteRequete(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			MonException, Exception {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = ERROR_PAGE;
		// execute l'action
		switch (actionName) {
		// Application sur les stages
		case SAISIE_STAGE:
			request.setAttribute("stage", new Stage());
			destinationPage = "/saisieStage.jsp";
			break;
		case AJOUT_STAGE:
			destinationPage = ajoutStage(request);
			break;
		case AFFICHER_STAGE:
			destinationPage = afficherStages(request);
			break;
		case AFFICHER_MODIFIER_STAGE:
			destinationPage = afficherModifierStage(request);
			break;
		case MODIFIER_STAGE:
			destinationPage = modifierStage(request);
			break;
		case SUPPRIMER_STAGE:
			destinationPage = supprimerStage(request);
			break;
		case RECHERCHER_STAGE:
			destinationPage = rechercherStages(request);
			break;

		}
		// Redirection vers la page jsp appropriee
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);
	}

	private String modifierStage(HttpServletRequest request) {
		String destinationPage = "";
		try {
			String lastId = request.getParameter("lastId");
			Stage unStage = new Stage();
			unStage.setId(request.getParameter("id"));
			unStage.setLibelle(request.getParameter("libelle"));
			String dd = request.getParameter("datedebut");
			unStage.setDatedebut(Utils.conversionChaineenDate(dd, "yyyy-MM-dd"));
			String df = request.getParameter("datefin");
			unStage.setDatefin(Utils.conversionChaineenDate(df, "yyyy-MM-dd"));
			unStage.setNbplaces(Integer.parseInt(request
					.getParameter("nbplaces")));
			unStage.setNbinscrits(Integer.valueOf(
					(request.getParameter("nbplaces"))).intValue());
			unStage.setNbinscrits(Integer.valueOf(
					(request.getParameter("nbinscrits"))).intValue());
			unStage.misAJourStage(lastId, unStage);
			destinationPage = "/index.jsp";
			request.setAttribute("MesSucces", "Le stage a bien été modifié !");
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			System.out.println(e.getMessage());
			return destinationPage = "/index.jsp";
		}
		return destinationPage;
	}

	private String supprimerStage(HttpServletRequest request) {
		String id = request.getParameter("id");
		String destinationPage = "";
		if (id != null && id != "") {
			Stage unStage = new Stage();
			try {
				unStage.suppressionStage(id);
				destinationPage = "/index.jsp";
				request.setAttribute("MesSucces",
						"Le stage a bien été supprimer !");
			} catch (Exception e) {
				request.setAttribute("MesErreurs", e.getMessage());
				System.out.println(e.getMessage());
				return destinationPage = "/index.jsp";
			}
		}
		return destinationPage;
	}

	private String afficherModifierStage(HttpServletRequest request) {
		String destinationPage;
		Stage stage;
		try {
			Stage unStage = new Stage();
			String id = request.getParameter("id");
			stage = unStage.rechercheUnStage(id);
			if (stage != null) {
				request.setAttribute("stage", stage);
				destinationPage = "/modifierStage.jsp";
			} else {
				request.setAttribute("MesErreurs",
						"Une érreur est survenu, veuillez contacter l'administrateur.");
				destinationPage = "/Erreur.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			return destinationPage = "/Erreur.jsp";

		}
		return destinationPage;
	}

	private String afficherStages(HttpServletRequest request)
			throws ParseException {
		String destinationPage;
		List<Stage> listeStages;
		try {
			Stage unStage = new Stage();
			request.setAttribute("affichageListe", 1);
			listeStages = unStage.rechercheLesStages();
			request.setAttribute("liste", listeStages);
			destinationPage = "/afficherStages.jsp";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			destinationPage = "/Erreur.jsp";

		}
		return destinationPage;
	}

	private String ajoutStage(HttpServletRequest request) {
		String destinationPage = "";
		try {
			Stage unStage = new Stage();
			String id = request.getParameter("id");
			if (unStage.rechercheUnStage(id) == null) {
				unStage.setId(id);
				unStage.setLibelle(request.getParameter("libelle"));
				unStage.setDatedebut(Utils.conversionChaineenDate(
						request.getParameter("datedebut"), "yyyy-MM-dd"));
				unStage.setDatefin(Utils.conversionChaineenDate(
						request.getParameter("datefin"), "yyyy-MM-dd"));
				unStage.setNbplaces(Integer.parseInt(request
						.getParameter("nbplaces")));
				unStage.setNbinscrits(Integer.valueOf(
						(request.getParameter("nbplaces"))).intValue());
				unStage.setNbinscrits(Integer.valueOf(
						(request.getParameter("nbinscrits"))).intValue());
				unStage.insertionStage();
				destinationPage = "/index.jsp";
				request.setAttribute("MesSucces",
						"Le stage a bien été ajouté !");
			} else {// Il existe déjà un stage avec cet identifiant
				request.setAttribute("MesErreurs",
						"Cet identifiant est déjà utilisé !");
				System.out.println("Cet identifiant est déjà utilisé !");
				destinationPage = "/index.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			System.out.println(e.getMessage());
			return destinationPage = "/index.jsp";
		}
		return destinationPage;
	}

	private String rechercherStages(HttpServletRequest request) {
		String destinationPage = "";
		List<Stage> listeStages;
		try {
			Stage unStage = new Stage();
			request.setAttribute("affichageListe", 1);
			listeStages = unStage.rechercheLesStages(request
					.getParameter("libelle"));
			request.setAttribute("liste", listeStages);
			request.setAttribute("libelle", request.getParameter("libelle"));

			// unStage.setId(request.getParameter("id"));
			// unStage.setLibelle(request.getParameter("libelle"));
			// unStage.setDatedebut(conversionChaineenDate(
			// request.getParameter("datedebut"), "yyyy/MM/dd"));
			// unStage.setDatefin(conversionChaineenDate(
			// request.getParameter("datefin"), "yyyy/MM/dd"));
			// unStage.setNbplaces(Integer.parseInt(request
			// .getParameter("nbplaces")));
			// unStage.setNbinscrits(Integer.valueOf(
			// (request.getParameter("nbplaces"))).intValue());
			// unStage.setNbinscrits(Integer.valueOf(
			// (request.getParameter("nbinscrits"))).intValue());
			// unStage.insertionStage();
			destinationPage = "/rechercherStages.jsp";
		} catch (Exception e) {
			request.setAttribute("MesErreurs", e.getMessage());
			System.out.println(e.getMessage());
			destinationPage = "/Erreur.jsp";
		}
		return destinationPage;
	}

}
