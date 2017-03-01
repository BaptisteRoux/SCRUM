package dao;

import java.util.List;

import metier.Editeur;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class EditeurDAO {
    public List<Editeur> getEditeurs() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from Editeur");
        
        List<Editeur> editeurs = query.list();
        
        return editeurs;
    }
    public void addEditeur(Editeur editeur) {

		HibernateUtil.getSessionFactory()
        .getCurrentSession().beginTransaction();
		
		HibernateUtil.getSessionFactory()
        .getCurrentSession().save(editeur);

		HibernateUtil.getSessionFactory()
        .getCurrentSession().getTransaction().commit();

	}
}
