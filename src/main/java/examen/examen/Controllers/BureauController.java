package examen.examen.Controllers;


import examen.examen.Repositories.BureauRepository;
import examen.examen.Repositories.DepartementRepository;
import examen.examen.entities.Bureau;
import examen.examen.entities.Departement;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Bureau")
public class BureauController {
    private final BureauRepository bureauRepository;
    private UniversitéController universitéController;

    private final DepartementRepository departementRepository;

    public BureauController(BureauRepository bureauRepository, DepartementRepository departementRepository, UniversitéController universitéController) {
        this.bureauRepository = bureauRepository;
        this.departementRepository = departementRepository;
        this.universitéController = universitéController;
    }

    @GetMapping("/all")
    public List<Bureau> getAll(){
        return  bureauRepository.findAll();
    }
    @GetMapping("/find/{id}")

    public Optional<Bureau> getById(@PathVariable("id") Long id){
        return  bureauRepository.findById(id);
    }

    @PostMapping("/add")
    public Bureau addBureau(@RequestBody Bureau bureau){

        universitéController.CreateUniversité(bureau.getBrUniversité());
        return bureauRepository.save(bureau);
    }

    @PutMapping("/update")
    public Bureau updateBureau( @RequestBody  Bureau bureau){
        if(bureauRepository.existsById(bureau.getID())){
            return bureauRepository.save(bureau);
        }
        return null;
    }
    @PutMapping("/assign/{bureauId}/to/{departementId}")
    public Bureau assignBureauToDepartement(
            @PathVariable("bureauId") Long bureauId, @PathVariable("departementId") Long departementId) {
        Optional<Bureau> optionalBureau = bureauRepository.findById(bureauId);
        Optional<Departement> optionalDepartement = departementRepository.findById(departementId);

        if (optionalBureau.isPresent() && optionalDepartement.isPresent()) {
            Bureau bureau = optionalBureau.get();
            Departement departement = optionalDepartement.get();

            bureau.setDepartement(departement);
            return bureauRepository.save(bureau);
        }

        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteABureau( @PathVariable("id") Long id) {
        bureauRepository.deleteById(id);
    }


}
