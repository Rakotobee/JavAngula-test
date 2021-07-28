package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import modele.Commentaire;

public interface CommentaireRepository extends JpaRepository<Commentaire, Integer> {

	@Query(nativeQuery = true, value ="select*from Commentaire   where id_voiture = :id_voiture  ORDER BY id DESC LIMIT 3")
	List<Commentaire> findCommentaireByIdVoiture(@Param("id_voiture") int id_voiture);
}
