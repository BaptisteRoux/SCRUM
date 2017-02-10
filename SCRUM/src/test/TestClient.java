package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.ClientDAO;
import metier.Client;
import util.HibernateUtil;

public class TestClient {

	ClientDAO dao = new ClientDAO();
	Client abo;
	
	@BeforeClass
    public static void init() throws Exception {
        
    }
	@Test
    public void simple() {
		HibernateUtil.getSessionFactory()
        .getCurrentSession().beginTransaction();
		//Client abonne = new Particulier("login", "mdp", "nom", "prenom");
		//HibernateUtil.getSessionFactory().getCurrentSession().save(abonne);

		HibernateUtil.getSessionFactory()
        .getCurrentSession().getTransaction().commit();
		
        Client abo = dao.rechercheParMailAbonne("mail", "mdp");
        assertNotNull(abo);
       // assertEquals("login", abo.getLogin());
    }
}
