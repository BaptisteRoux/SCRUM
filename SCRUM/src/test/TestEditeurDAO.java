package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.EditeurDAO;
import metier.Editeur;

public class TestEditeurDAO {

	EditeurDAO dao = new EditeurDAO();
	Editeur editeur;
	
	@Test
    public void addEditeur() {
        editeur = new Editeur("nom_editeur");
        dao.addEditeur(editeur);
        
        List<Editeur> recherche = dao.getEditeurs();
        assertEquals("nom_editeur", recherche.get(recherche.size()-1).getNom());
    }
}
