package test;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.ClientDAO;
import metier.Client;

public class TestClientDAO {

	ClientDAO dao = new ClientDAO();
	Client abo;
	
	@Test
    public void addClient() {
        Client cli = new Client("nom","prenom",0606060606,"mail","mdp");
        dao.addClient(cli);
        
        Client recherche = dao.rechercheParMailAbonne("mail", "mdp");
        assertEquals("mail", recherche.getMail());
    }
}
