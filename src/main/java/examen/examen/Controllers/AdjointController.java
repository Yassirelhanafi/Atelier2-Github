package examen.examen.Controllers;


import examen.examen.Repositories.AdjointRepository;
import examen.examen.entities.Adjoint;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adjoint")
public class AdjointController {
    private final AdjointRepository adjointRepository;

    public AdjointController(AdjointRepository adjointRepository) {
        this.adjointRepository = adjointRepository;
    }

    @GetMapping("/all")
    public List<Adjoint> getAll() {
        return adjointRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public Optional<Adjoint> getById(@PathVariable("id") Long id) {
        return adjointRepository.findById(id);
    }

    @PostMapping("/add")
    public Adjoint CreateAdjoint(@RequestBody Adjoint adjoint) {
        return adjointRepository.save(adjoint);
    }

    @PutMapping("/update")
    public Adjoint updateAdjoint(@RequestBody Adjoint adjoint) {
        if (adjointRepository.existsById(adjoint.getID())) {
            return adjointRepository.save(adjoint);
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteAdjoint( @PathVariable("id") Long id) {
         adjointRepository.deleteById(id);
    }
}
