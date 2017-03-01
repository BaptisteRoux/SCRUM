package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.CategorieDAO;
import metier.Categorie;

public class TestCategorieDAO {

	CategorieDAO dao = new CategorieDAO();
	Categorie categorie;
	
	@Test
    public void addCategorie() {
	//	categorie = new Editeur("nom_categorie");
	   // dao.addEditeur(categorie);
		   List<Categorie> recherche = dao.getCategories();
	        assertEquals("RPG ", recherche.get(0).getNom());
	   
    }
}
