package dao;

import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import metier.Client;




public class ClientDAO {

	@SuppressWarnings("unchecked")
	public Client rechercheParMailAbonne(String mail, String mdp) {
		

		List<Client> client = new ArrayList<Client>();
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		
		client = HibernateUtil.sessionFactory.getCurrentSession().createQuery("from Client where mail=? and mdp=?")
				.setParameter(0, client).setParameter(1, mdp).list();
		
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		if (client.size() > 0) {
			return client.get(0);
		} else {
			return null;
		}

	}

	public void addClient(Client client) {

		HibernateUtil.getSessionFactory()
        .getCurrentSession().beginTransaction();
		
		HibernateUtil.getSessionFactory()
        .getCurrentSession().save(client);

		HibernateUtil.getSessionFactory()
        .getCurrentSession().getTransaction().commit();

	}
}
