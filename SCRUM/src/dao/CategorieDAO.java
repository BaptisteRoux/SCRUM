package dao;

import java.util.List;
import metier.Categorie;
import metier.Jeu;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class CategorieDAO {
    public List<Categorie> getCategories() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from Categorie");
        
        List<Categorie> categories = query.list();
        
        return categories;
    }
}
