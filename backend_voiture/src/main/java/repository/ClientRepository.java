package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import modele.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	@Query("select c from Client c where c.login = ?1 and mdp = ?2")
    Client  login(String login, String mdp);
}
