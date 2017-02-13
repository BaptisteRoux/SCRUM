package servlet;

import dao.CategorieDAO;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.ClientDAO;
import dao.EditeurDAO;
import metier.Client;
import util.HibernateUtil;

public class Index extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7884806023808465959L;
	public static final String ACCES_PUBLIC = "/WEB-INF/index.jsp";
	//public static final String ACCES_RESTREINT = "/6taimejouer";
	public static final String SESSION_ABONNE = "sessionAbonne";

	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_MDP = "mdp";
	private static final String CHAMP_MAIL = "mail";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";

	
	private ClientDAO abonneDAO = new ClientDAO ();
        private CategorieDAO categorieDAO = new CategorieDAO ();
        private EditeurDAO editeurDAO = new EditeurDAO ();

	private String message ;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		message="";
                HttpSession session = request.getSession();
                session.setAttribute("editeurs", editeurDAO.getEditeurs());
                session.setAttribute("categories", categorieDAO.getCategories());
		redirection(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		message ="";
		// Cr�ation d'un objet abonn� dans la session si la connexion ou
		// l'inscription est valide
		if (request.getParameterMap().containsKey("connexion")) {
			connexion(request);
		} else if (request.getParameterMap().containsKey("inscriptionParticulier")) {
			inscriptionParticulier(request);
		}

		redirection(request, response);
	}
	
	
	private void connexion(HttpServletRequest request) {

		/* R�cup�ration des champs du formulaire */
		String mail = getValeurChamp(request, CHAMP_MAIL);
		String mdp = getValeurChamp(request, CHAMP_MDP);

		if (mail == null || mdp == null ) {
			message = "Les champs ne doivent pas �tre vide.";
		} else {
			
			Client abonne = abonneDAO.rechercheParMailAbonne(mail,mdp);
				if (abonne == null ){
					message = "Identifiants incorrects.";
				}else{
					HttpSession session = request.getSession();
					session.setAttribute(SESSION_ABONNE, abonne);
				}
				
		}

	}
	
	private void inscriptionParticulier(HttpServletRequest request) {

		/* R�cup�ration des champs du formulaire */
		String mail = getValeurChamp(request, CHAMP_MAIL);
		String mdp = getValeurChamp(request, CHAMP_MDP);
		String nom = getValeurChamp(request, CHAMP_NOM);
		String prenom = getValeurChamp(request, CHAMP_PRENOM);

		if (mail == null || mdp == null || nom == null || prenom == null) {
			message = "Les champs ne doivent pas �tre vide.";
		} else {
			try {
				HibernateUtil.getSessionFactory()
                .getCurrentSession().beginTransaction();
				//Client abonne = new Particulier(login, mdp, nom, prenom);
				//HibernateUtil.getSessionFactory().getCurrentSession().save(abonne);

				HibernateUtil.getSessionFactory()
                .getCurrentSession().getTransaction().commit();
				
				//Annuaire annuaire = annuaireDAO.rechercheParNomAnnuaire(ANNUAIRE_ABOS);
				//annuaireDAO.addAbo(annuaire, abonne);
				HttpSession session = request.getSession();
				//session.setAttribute(SESSION_ABONNE, abonne);
				
			} catch (org.hibernate.exception.ConstraintViolationException e) {
				HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
				message = "Le login est d�j� utilis�.";
			}
		}

	}


	/*
	 * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}

	

	public void redirection(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Ajout de l'objet message dans la requ�te */
		request.setAttribute("message", message);

		/* R�cup�ration de la session depuis la requ�te */
		HttpSession session = request.getSession();

		/*
		 * Si l'objet abonn� n'existe pas dans la session en cours, alors
		 * l'abonn� n'est pas connect�.
		 */
		if (session.getAttribute(SESSION_ABONNE) == null) {
			/* Redirection vers la page publique */
			this.getServletContext().getRequestDispatcher(ACCES_PUBLIC).forward(request, response);
		} else {
			
			/* Affichage de la page restreinte */
			this.getServletContext().getRequestDispatcher(ACCES_PUBLIC).forward(request, response);
		}
	}
}