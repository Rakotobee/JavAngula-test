package modele;

import java.util.List;

public class CommentaireVoiture {
	 
	private Voiture voiture;
	
	private List<Commentaire> listCommentaire;

	public CommentaireVoiture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CommentaireVoiture(Voiture voiture, List<Commentaire> commentaire) {
		super();
		this.voiture = voiture;
		this.listCommentaire = commentaire;
	}

	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	public List<Commentaire> getListCommentaire() {
		return listCommentaire;
	}
	public void setListCommentaire(List<Commentaire> commentaire) {
		this.listCommentaire = commentaire;
	}

}
