package examen.examen.Repositories;

import examen.examen.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PersonneRepository extends JpaRepository<Personne,Long> {
}
