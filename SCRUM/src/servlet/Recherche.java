package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.ClientDAO;
import metier.Categorie;
import metier.Client;
import metier.Editeur;
import metier.Jeu;
import util.HibernateUtil;

public class Recherche extends HttpServlet {
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

	private static final String CHAMP_RECHERCHE = "recherche";
	
	private ClientDAO abonneDAO = new ClientDAO ();

	private String message ;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Categorie cat1 = new Categorie(1,"ACTION");
		Categorie cat2 = new Categorie(2,"ARCADE");
		Editeur edit1 = new Editeur(1,"SONY");
		Editeur edit2 = new Editeur(2,"UBISOFT");
		Jeu j1 = new Jeu(1,"video.url", "FIFA", cat1, edit1, 20, "description");
		Jeu j2 = new Jeu(2,"video.url", "FIFA2", cat2, edit2, 20, "description2");
		
		List<Jeu> recherche = new ArrayList<Jeu> ();
		recherche.add(j1);
		recherche.add(j2);
		
		
		/* Récupération de la session depuis la requête */
		     //HttpSession session = request.getSession();
		     /* Ajout de l'objet message dans la requête */
				request.setAttribute("listeResultats", recherche);

			/* Redirection vers la page publique */
			this.getServletContext().getRequestDispatcher(ACCES_PUBLIC).forward(request, response);
		
	}
	


	
}