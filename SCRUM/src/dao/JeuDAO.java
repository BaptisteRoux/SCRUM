package dao;

import java.util.ArrayList;
import java.util.List;
import metier.Categorie;
import metier.Client;
import metier.Editeur;
import metier.Jeu;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class JeuDAO {
    public Jeu rechercherJeu(String nom) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Query query = session.createQuery("from Jeu where nom like :nom");
        query.setString("nom", "%"+nom+"%");
        
        List<Jeu> jeux = query.list();
        
        session.close();
        
        if (jeux.size() > 0) {
            return jeux.get(0);
        } else {
            return null;
        }
    }
    
    public Jeu getJeuParNom(String nom) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Query query = session.createQuery("from Jeu where nom=:nom");
        query.setParameter("nom", nom);
        
        List<Jeu> jeux = query.list();
        
        session.close();
        
        if (jeux.size() > 0) {
            return jeux.get(0);
        } else {
            return null;
        }
    }
    
    public Jeu getJeuParCategorie(List<Categorie> categories) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Query query = session.createQuery("from Jeu where categorie  IN :categories");
        query.setParameterList("categories", categories);
        
        List<Jeu> jeux = query.list();
        
        session.close();
        
        if (jeux.size() > 0) {
            return jeux.get(0);
        } else {
            return null;
        }
    }
    
    public Jeu getJeuParEditeur(List<Editeur> editeurs) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Query query = session.createQuery("from Jeu where editeur IN :editeurs");
        query.setParameterList("editeurs", editeurs);
        
        List<Jeu> jeux = query.list();
        
        session.close();
        
        if (jeux.size() > 0) {
            return jeux.get(0);
        } else {
            return null;
        }
    }
    
    public Jeu getJeuParCategorieEtEditeur(List<Categorie> categories, List<Editeur> editeurs) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Query query = session.createQuery("from Jeu where categorie IN :categories AND editeur IN :editeurs");
        query.setParameterList("categories", categories);
        query.setParameterList("editeurs", editeurs);
        
        List<Jeu> jeux = query.list();
        
        session.close();
        
        if (jeux.size() > 0) {
            return jeux.get(0);
        } else {
            return null;
        }
    }
}
