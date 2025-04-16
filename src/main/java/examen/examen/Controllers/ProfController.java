package examen.examen.Controllers;


import examen.examen.Repositories.DepartementRepository;
import examen.examen.Repositories.ProfRepository;
import examen.examen.entities.Departement;
import examen.examen.entities.Personne;
import examen.examen.entities.Prof;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prof")
public class ProfController {
    private final ProfRepository profRepository;
    private final DepartementRepository departementRepository;


    public ProfController(ProfRepository profRepository,DepartementRepository departementRepository) {
        this.profRepository = profRepository;
        this.departementRepository=departementRepository;
    }

    @GetMapping("/all")
    public List<Prof> getAll(){
        return profRepository.findAll();
    }
    @GetMapping("/find/{id}")
    public Optional<Prof> getById(@PathVariable("id") Long id ){
        return profRepository.findById(id);
    }
    @PostMapping("/add")
    public Prof CreateProf(@RequestBody  Prof prof){
        return profRepository.save(prof);
    }
    @PutMapping("/Update")
    public Prof UpdateProf(@RequestBody Prof prof) {
        if(profRepository.existsById(prof.getID())){
            return profRepository.save(prof);
        }
        return null;

    }
    @DeleteMapping("/delete/{id}")
    public void DeleteProf( @PathVariable("id") Long id) {
        profRepository.deleteById(id);
    }
    @PutMapping("/assign/{profId}/to/{departementId}")
    public Prof assignProfToDepartement(
            @PathVariable("profId") Long profId, @PathVariable("departementId") Long departementId) {
        Optional<Prof> optionalProf = profRepository.findById(profId);
        Optional<Departement> optionalDepartement = departementRepository.findById(departementId);

        if (optionalProf.isPresent() && optionalDepartement.isPresent()) {
            Prof prof = optionalProf.get();
            Departement departement = optionalDepartement.get();

            prof.setDepartement(departement);
            return profRepository.save(prof);
        }

        return null;
    }
}
