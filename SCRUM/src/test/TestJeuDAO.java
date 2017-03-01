package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.JeuDAO;
import metier.Jeu;

public class TestJeuDAO {

	JeuDAO dao = new JeuDAO();
	Jeu jeu;
	List<Jeu> jeux;
	
	@Test
    public void addJeu() {
       // Client cli = new Client("nom","prenom",0606060606,"mail","mdp");
        //dao.addClient(cli);
         jeu = dao.rechercheParId(1);
        assertEquals("FIFA 17", jeu.getNom());
        
        jeux = dao.rechercherJeu("FIFA");
        assertEquals("FIFA 17", jeux.get(0).getNom());
        
        jeux = dao.rechercherJeu("CE JEU N'EXISTE PAS!");
        assertEquals(null, jeux);
        
        
      //  jeu = dao.getJeuParNom("FIFA 17");
      //  assertEquals("FIFA 17", jeu.getNom());
    }
}
