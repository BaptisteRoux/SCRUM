package metier;

import java.util.Date;

public class Client {

	private int id_client;
	private String nom;
	private String prenom;
	private int telephone;
	private String mail;
	private String mdp;  
	private Date date_inscription;
	
	public Client (){}
	public Client(String nom, String prenom, int telephone, String mail, String mdp){
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setTelephone(telephone);
		this.setMail(mail);
		this.setMdp(mdp);
		this.setDate_inscription(new Date());
	}


	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getDate_inscription() {
		return date_inscription;
	}
	public void setDate_inscription(Date date_inscription) {
		this.date_inscription = date_inscription;
	}

}
