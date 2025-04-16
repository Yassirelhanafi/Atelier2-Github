package examen.examen.Repositories;

import examen.examen.entities.Adjoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdjointRepository extends JpaRepository<Adjoint,Long> {
}
