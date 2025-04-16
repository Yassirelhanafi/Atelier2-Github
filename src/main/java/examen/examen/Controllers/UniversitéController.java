package examen.examen.Controllers;


import examen.examen.Repositories.PersonneRepository;
import examen.examen.Repositories.UniversitéRepository;

import examen.examen.entities.Université;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/université")
public class UniversitéController {
    private final UniversitéRepository universitéRepository;
    private final PersonneRepository personneRepository;

    public UniversitéController(UniversitéRepository universitéRepository, PersonneRepository personneRepository) {
        this.universitéRepository = universitéRepository;
        this.personneRepository = personneRepository;
    }
    @GetMapping("/all")
    public List<Université> getAll(){
        return universitéRepository.findAll();
    }
    @GetMapping("/find/{id}")
    public Optional<Université> getById(@PathVariable("id") Long id ){
        return universitéRepository.findById(id);
    }
    @PostMapping("/add")
    public Université CreateUniversité(@RequestBody Université université){
        personneRepository.save(université.getPersonne());
        return universitéRepository.save(université);
    }
    @PutMapping("/Update")
    public Université UpdateUniversité( @RequestBody Université université) {
        if(universitéRepository.existsById(université.getId())){
            return universitéRepository.save(université);
        }
        return null;

    }
    @DeleteMapping("/delete/{id}")
    public void DeleteUniversité( @PathVariable("id") Long id) {
        universitéRepository.deleteById(id);
    }



}
