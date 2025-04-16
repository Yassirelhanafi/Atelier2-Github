package examen.examen.Controllers;


import examen.examen.Repositories.DepartementRepository;
import examen.examen.Repositories.UniversitéRepository;
import examen.examen.entities.Departement;
import examen.examen.entities.Université;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departement")
public class DepartementController {
    private final DepartementRepository departementRepository;
    private final UniversitéRepository universitéRepository;

    public DepartementController(DepartementRepository departementRepository,UniversitéRepository universitéRepository) {
        this.departementRepository = departementRepository;
        this.universitéRepository=universitéRepository;
    }

    @GetMapping("/all_tous")
    public List<Departement> getAll(){
        return departementRepository.findAll();
    }
    @GetMapping("/find/{id}")
    public Optional<Departement> getById(@PathVariable("id") Long id ){
        return departementRepository.findById(id);
    }
    @PostMapping("/add")
    public Departement CreateAssocie(@RequestBody  Departement departement){
        return departementRepository.save(departement);
    }
    @PutMapping("/update")
    public Departement updateAssocie(@RequestBody  Departement departement){
        if(departementRepository.existsById(departement.getId())){
            return departementRepository.save(departement);
        }
        return null;
    }
    @PutMapping("/assign/{departementId}/to/{universiteId}")
    public Departement assignDepartementToUniversite(
            @PathVariable("departementId") Long departementId, @PathVariable("universiteId") Long universiteId) {
        Optional<Departement> optionalDepartement = departementRepository.findById(departementId);
        Optional<Université> optionalUniversite = universitéRepository.findById(universiteId);

        if (optionalDepartement.isPresent() && optionalUniversite.isPresent()) {
            Departement departement = optionalDepartement.get();
            Université universite = optionalUniversite.get();

            departement.setUniversité(universite);
            return departementRepository.save(departement);
        }

        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteDeparetement( @PathVariable("id") Long id) {
        departementRepository.deleteById(id);
    }

}
