package examen.examen.Controllers;


import examen.examen.Repositories.AssocieRepository;
import examen.examen.Repositories.PersonneRepository;
import examen.examen.entities.Associe;
import examen.examen.entities.Personne;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Associe")
public class AssocieController {
    private final AssocieRepository associeRepository;
    private final PersonneController personneController;

    public AssocieController(AssocieRepository associeRepository, PersonneController personneController) {
        this.associeRepository = associeRepository;
        this.personneController = personneController;
    }

    @GetMapping("/all")
    public List<Associe> getAll(){
       return associeRepository.findAll();
    }
    @GetMapping("/find/{id}")
    public Optional<Associe> getById(@PathVariable("id") Long id ){
        return associeRepository.findById(id);
    }
    @PostMapping("/add")
    public Associe CreateAssocie(@RequestBody  Associe associe){
        return associeRepository.save(associe);
    }
    @PutMapping("/update")
    public Associe updateAssocie(@RequestBody  Associe associe){
        if(associeRepository.existsById(associe.getID())){
            return associeRepository.save(associe);
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteAssocie( @PathVariable("id") Long id) {
        associeRepository.deleteById(id);
    }
}
