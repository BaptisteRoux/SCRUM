package metier;

public class Jeu {
	private int id_jeu;
	private String video;
	private String nom;
	private Categorie categorie;
	private Editeur editeur;
	private float prix;
	private String description;
	
	public Jeu (){}
public Jeu(int id_jeu, String video, String nom, Categorie categorie, Editeur editeur, float prix, String description){
	this.id_jeu=id_jeu;
	this.video=video;
	this.nom=nom;
	this.categorie=categorie;
	this.editeur=editeur;
	this.prix=prix;
	this.description=description;
}
	public int getId_jeu() {
		return id_jeu;
	}

	public void setId_jeu(int id_jeu) {
		this.id_jeu = id_jeu;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Editeur getEditeur() {
		return editeur;
	}

	public void setEditeur(Editeur editeur) {
		this.editeur = editeur;
	}
}
