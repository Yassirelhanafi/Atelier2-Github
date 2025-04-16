package examen.examen.Controllers;


import examen.examen.Repositories.SalleRepository;
import examen.examen.Repositories.UniversitéRepository;
import examen.examen.entities.Salle;
import examen.examen.entities.Université;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salle")
public class SalleController {
    private final SalleRepository salleRepository;

    private final UniversitéRepository universitéRepository;

    public SalleController(SalleRepository salleRepository,UniversitéRepository universitéRepository) {
        this.salleRepository = salleRepository;
        this.universitéRepository=universitéRepository;
    }

    @GetMapping("/all")
    public List<Salle> getAll(){
        return salleRepository.findAll();
    }
    @GetMapping("/find/{id}")
    public Optional<Salle> getById(@PathVariable("id") Long id ){
        return salleRepository.findById(id);
    }
    @PostMapping("/add")
    public Salle CreateSalle(@RequestBody  Salle salle){
        return salleRepository.save(salle);
    }
    @PutMapping("/Update")
    public Salle UpdateSalle(@RequestBody Salle salle ) {
        if(salleRepository.existsById(salle.getID())){
            return salleRepository.save(salle);
        }
        return null;

    }
    @DeleteMapping("/delete/{id}")
    public void DeleteSalle( @PathVariable("id") Long id) {
        salleRepository.deleteById(id);
    }
    @PutMapping("/assign/{salleId}/to/{universiteId}")
    public Salle assignSalleToUniversite(@PathVariable("salleId") Long salleId, @PathVariable("universiteId") Long universiteId) {
        Optional<Salle> optionalSalle = salleRepository.findById(salleId);
        Optional<Université> optionalUniversite = universitéRepository.findById(universiteId);

        if (optionalSalle.isPresent() && optionalUniversite.isPresent()) {
            Salle salle = optionalSalle.get();
            Université universite = optionalUniversite.get();

            salle.setUniversité(universite);
            return salleRepository.save(salle);
        }

        return null;
    }
}
