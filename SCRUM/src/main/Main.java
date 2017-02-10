package main;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import forum.*;

public class Main {


	public static void main(String[] args) {
	
	        Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		
               Abonne abo = new Particulier("bat","mdp", "Baptiste", "Roux");
               
               session.save(abo);
          
   
                
           
		tx.commit();
            
		
                
               
	    HibernateUtil.closeSession();
            HibernateUtil.getSessionFactory().close();
		}

	}

