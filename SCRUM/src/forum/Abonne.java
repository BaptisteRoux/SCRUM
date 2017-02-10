package forum;

import java.util.HashSet;
import java.util.Set;

public abstract class Abonne {

	
	private String login;
	private String mdp;   
	//private Set<Message> listeMessages = new HashSet<Message>();
	
	public Abonne (){}
	public Abonne(String login, String mdp){
		this.setLogin(login);
		this.setMdp(mdp);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
