package metier;

public class Categorie {

	private int id_categorie;
	private String nom;
	
	public Categorie (){}
public Categorie(int id_categorie, String nom){
	this.id_categorie=id_categorie;
	this.nom=nom;
}
	public int getId_categorie() {
		return id_categorie;
	}

	public void setId_categorie(int id_categorie) {
		this.id_categorie = id_categorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
}
