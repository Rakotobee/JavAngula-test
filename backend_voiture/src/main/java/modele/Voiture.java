package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="voiture")
public class Voiture{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name="matricule")
	private String matricule;
	
	@Column(name="marque")
	private String marque;
	
	@Column(name="couleur")
	private String couleur;
	
	@Column(name="image")
	private String image;
	

	public Voiture() {
		super();
	}
	
	public Voiture(int id, String matricule, String marque, String couleur, String image) {
		super();
		this.id = id;
		this.matricule = matricule;
		this.marque = marque;
		this.couleur = couleur;
		this.image = image;
	}
	public Voiture(String matricule, String marque, String couleur, String image) {
		super();
		this.matricule = matricule;
		this.marque = marque;
		this.couleur = couleur;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
