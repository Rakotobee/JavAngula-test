package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Commentaire")
public class Commentaire{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="id_client")
	private int idClient;

	@Column(name="id_voiture")
	private int idVoiture;
	
	@Column(name="commentaire")
	private String commentaire;
	
	
	public Commentaire() {
		super();
	}

	public Commentaire(int id,int idClient, int idVoiture, String commentaire) {
		super();
		this.setId(id);
		this.idClient = idClient;
		this.idVoiture = idVoiture;
		this.commentaire = commentaire;
	}

	
	public Commentaire(int idClient,int idVoiture, String commentaire) {
		super();
		this.idClient = idClient;
		this.idVoiture = idVoiture;
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	
}
