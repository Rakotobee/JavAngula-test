package voiture;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import modele.Client;
import modele.Commentaire;
import modele.CommentaireVoiture;
import modele.Voiture;
import repository.ClientRepository;
import repository.CommentaireRepository;
import repository.VoitureRepository;

@SpringBootApplication
@ComponentScan({"modele","controller","repository"})
@EntityScan("modele")
@EnableJpaRepositories("repository")
public class BackendVoitureApplication implements CommandLineRunner {
	
	@Autowired
	VoitureRepository voitureRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	CommentaireRepository commentaireRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BackendVoitureApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		Client log = clientRepository.login("koto", "blabla");
		System.err.println(log.getId()+": id et nom: "+log.getNom());
		
		// test insertion  commentaire
		/*Commentaire _commentaire = this.commentaireRepository.save(new Commentaire(2, 0, "commentaire testvaovao"));
		System.out.println(" insertion avec succes "+_commentaire.getCommentaire());*/
		
		//recuperation voiture avec commentaire dans liste commentaire voiture
		Voiture _voiture = null;
		int id_voiture = 0;
		List<Commentaire> list_commentaire = new ArrayList<Commentaire>();
		List<Voiture> voiture = this.voitureRepository.findAll();
		List<CommentaireVoiture> list_commentaireVoiture = new ArrayList<CommentaireVoiture>();
		
		System.out.println("taille de voiture dans un Liset "+voiture.size());
		for(Voiture car : voiture) {
			_voiture = new Voiture(car.getMatricule(), car.getMarque(), car.getCouleur(),car.getImage());
			id_voiture = car.getId();
			list_commentaire = this.commentaireRepository.findCommentaireByIdVoiture(id_voiture);
			CommentaireVoiture commentairevoiture = new CommentaireVoiture(_voiture, list_commentaire);
			list_commentaireVoiture.add(commentairevoiture);
			
		
		}
		for(int i =0; i < list_commentaireVoiture.size(); i++) {
			System.err.println("voiture  marque: "+list_commentaireVoiture.get(i).getVoiture().getMarque()+" comms :"+list_commentaireVoiture.get(i).getListCommentaire());

		}
		
	}
	
	


}
