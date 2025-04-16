package examen.examen.Repositories;

import examen.examen.entities.Université;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



public interface UniversitéRepository extends JpaRepository<Université,Long> {


}
