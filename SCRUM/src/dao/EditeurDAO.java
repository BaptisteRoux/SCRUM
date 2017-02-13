package dao;

import java.util.List;
import metier.Editeur;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class EditeurDAO {
    public List<Editeur> getEditeurs() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Query query = session.createQuery("from Editeur");
        
        List<Editeur> editeurs = query.list();
        
        session.close();
        
        return editeurs;
    }
}
