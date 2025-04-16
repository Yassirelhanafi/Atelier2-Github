package examen.examen.Repositories;

import examen.examen.entities.Bureau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BureauRepository  extends JpaRepository<Bureau,Long> {
}
