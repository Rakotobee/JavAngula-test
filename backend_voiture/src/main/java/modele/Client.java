package modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="login")
	private String login;
	
	@Column(name="mdp")
	private String mdp;
	
	public Client() {
		super();
	}

	public Client(String nom, String login, String mdp) {
		super();
		this.nom = nom;
		this.login = login;
		this.mdp = mdp;
	}
	public Client(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
