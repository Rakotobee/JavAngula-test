package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import modele.Client;
import modele.Commentaire;
import modele.CommentaireVoiture;
import modele.Voiture;
import repository.ClientRepository;
import repository.CommentaireRepository;
import repository.VoitureRepository;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VoitureController {
	
	@Autowired
	VoitureRepository voitureRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	CommentaireRepository commentaireRepository;

	
	@GetMapping("/voiture")
	public ResponseEntity<List<Voiture>> getAllVoiture(@RequestParam(required = false) String marque){
		try {
			List<Voiture> listeVoiture = new ArrayList<Voiture>();
			if(marque == null) {
				voitureRepository.findAll().forEach(listeVoiture::add);
			}if(listeVoiture.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(listeVoiture,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Client client){
		try {
			Client _client = new Client();
			_client = this.clientRepository.login(client.getLogin(), client.getMdp());
			return new ResponseEntity<>(_client,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	@PostMapping("/commentaire")
	public ResponseEntity<Commentaire> creerCommentaire(@RequestBody Commentaire commentaire){
		try {
			Commentaire _commentaire = this.commentaireRepository
					.save(new Commentaire(commentaire.getIdClient(),commentaire.getIdVoiture(),commentaire.getCommentaire()));
			return new ResponseEntity<>(_commentaire,HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/commentaireVoiture")
	public ResponseEntity<List<CommentaireVoiture>> findCommentaireVoiture(){
		Voiture _voiture = null;
		int id_voiture = 0;
		List<Commentaire> list_commentaire = new ArrayList<Commentaire>();
		List<Voiture> list_voiture = this.voitureRepository.findAll();
		List<CommentaireVoiture> list_commentaireVoiture = new ArrayList<CommentaireVoiture>();
		try {
			for(Voiture v :list_voiture) {
				_voiture = new Voiture(v.getId(),v.getMatricule(),v.getMarque(),v.getCouleur(),v.getImage());
				 id_voiture = v.getId();
				 list_commentaire = this.commentaireRepository.findCommentaireByIdVoiture(id_voiture);
				 CommentaireVoiture commentairevoiture = new CommentaireVoiture(_voiture, list_commentaire);
				 list_commentaireVoiture.add(commentairevoiture);
			}
			if(list_commentaireVoiture.isEmpty())  {
				return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list_commentaireVoiture,HttpStatus.OK);
		}catch(Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
