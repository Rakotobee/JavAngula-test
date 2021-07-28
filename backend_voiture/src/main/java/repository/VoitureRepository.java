package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import modele.Voiture;



public interface VoitureRepository  extends JpaRepository<Voiture, Integer>{
	
}
