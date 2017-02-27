/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JeuDAO;
import metier.Jeu;

import static servlet.Index.ACCES_PUBLIC;

/**
 *
 * @author arthu
 */
public class Fiche extends HttpServlet {
	private static final long serialVersionUID = 3362945275861110624L;
	public static final String ACCES_PUBLIC = "/WEB-INF/fiche.jsp";
	private JeuDAO jeuDAO = new JeuDAO();
	private static final String CHAMP_RECHERCHE = "recherche";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération et destruction de la session en cours */

		try {
			Jeu jeu = jeuDAO.rechercheParId(Integer.parseInt(request.getParameter(CHAMP_RECHERCHE)));
			request.setAttribute("ficheJeu", jeu);
		} catch (NumberFormatException e) {
			// failed
			// TODO 404
		}

		/* Redirection vers la page publique */
		this.getServletContext().getRequestDispatcher(ACCES_PUBLIC).forward(request, response);
	}
}
