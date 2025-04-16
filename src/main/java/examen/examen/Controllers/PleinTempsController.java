package examen.examen.Controllers;


import examen.examen.Repositories.PleinTempsRepository;
import examen.examen.entities.PleinTemps;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PleinTemps")
public class PleinTempsController {
    private final PleinTempsRepository pleinTempsRepository;

    public PleinTempsController(PleinTempsRepository pleinTempsRepository) {
        this.pleinTempsRepository = pleinTempsRepository;
    }



    @GetMapping("/all")
    public List<PleinTemps> getAll(){
        return pleinTempsRepository.findAll();
    }
    @GetMapping("/find/{id}")
    public Optional<PleinTemps> getById(@PathVariable("id") Long id ){
        return pleinTempsRepository.findById(id);
    }
    @PostMapping("/add")
    public PleinTemps CreatePleinTemps(@RequestBody  PleinTemps pleinTemps){
        return pleinTempsRepository.save(pleinTemps);
    }
    @PutMapping("/Update")
    public PleinTemps UpdatePleinTemps(@RequestBody PleinTemps pleinTemps) {
        if(pleinTempsRepository.existsById(pleinTemps.getID())){
            return pleinTempsRepository.save(pleinTemps);
        }
        return null;

    }
    @DeleteMapping("/delete/{id}")
    public void DeletePleinTemps( @PathVariable("id") Long id) {
        pleinTempsRepository.deleteById(id);
    }
}
