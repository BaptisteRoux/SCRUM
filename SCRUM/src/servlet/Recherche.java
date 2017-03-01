package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.JeuDAO;
import metier.Jeu;

public class Recherche extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7884806023808465959L;
	public static final String ACCES_PUBLIC = "/WEB-INF/index.jsp";
	// public static final String ACCES_RESTREINT = "/6taimejouer";
	public static final String SESSION_ABONNE = "sessionAbonne";

	private static final String CHAMP_RECHERCHE = "recherche";
	private JeuDAO jeuDAO = new JeuDAO();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Jeu> recherche = jeuDAO.rechercherJeu(request.getParameter(CHAMP_RECHERCHE));
		
		/* Ajout de l'objet message dans la requête */
		request.setAttribute("listeResultats", recherche);

		/* Redirection vers la page publique */
		this.getServletContext().getRequestDispatcher(ACCES_PUBLIC).forward(request, response);

	}

}