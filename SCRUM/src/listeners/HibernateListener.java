package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.HibernateUtil;

public class HibernateListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getSessionFactory(); // Initialisation de la fabrique
	}

	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getSessionFactory().close(); // Fermeture
	}
}