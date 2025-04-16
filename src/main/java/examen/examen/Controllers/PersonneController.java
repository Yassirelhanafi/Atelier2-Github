package examen.examen.Controllers;


import examen.examen.Repositories.PersonneRepository;
import examen.examen.Repositories.UniversitéRepository;
import examen.examen.entities.Personne;
import examen.examen.entities.Université;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/personne")
public class PersonneController {
    private final PersonneRepository personneRepository;
    private final UniversitéRepository universitéRepository;


    public PersonneController(PersonneRepository personneRepository,UniversitéRepository universitéRepository) {
        this.personneRepository = personneRepository;
        this.universitéRepository=universitéRepository;
    }
    @GetMapping("/all")
    public List<Personne> getAll(){
        return personneRepository.findAll();
    }
    @GetMapping("/find/{id}")
    public Optional<Personne> getById(@PathVariable("id") Long id ){
        return personneRepository.findById(id);
    }
    @PostMapping("/add")
    public Personne CreatePersonne(@RequestBody Personne personne) {
        return personneRepository.save(personne);
    }


    @PutMapping("/Update")
    public Personne UpdatePersonne(@RequestBody  Personne personne) {
        if(personneRepository.existsById(personne.getID())){
            return personneRepository.save(personne);
        }
        return null;

    }
    @DeleteMapping("/delete/{id}")
    public void DeletePersonne( @PathVariable("id") Long id) {
        personneRepository.deleteById(id);
    }
    @PutMapping("/assign/{personneId}/to/{universiteId}")
    public Personne assignPersonneToUniversite(
            @PathVariable("personneId") Long personneId, @PathVariable("universiteId") Long universiteId) {
        Optional<Personne> optionalPersonne = personneRepository.findById(personneId);
        Optional<Université> optionalUniversite = universitéRepository.findById(universiteId);

        if (optionalPersonne.isPresent() && optionalUniversite.isPresent()) {
            Personne personne = optionalPersonne.get();
            Université universite = optionalUniversite.get();

            personne.setUniversité(universite);
            return personneRepository.save(personne);
        }

        return null;
    }

}
