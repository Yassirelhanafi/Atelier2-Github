package examen.examen.Controllers;


import examen.examen.Repositories.BureauRepository;
import examen.examen.Repositories.EmployerRepository;
import examen.examen.entities.Bureau;
import examen.examen.entities.Employer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployerController {
    private final EmployerRepository employerRepository;

    private final BureauRepository bureauRepository;

    public EmployerController(EmployerRepository employerRepository, BureauRepository bureauRepository) {
        this.employerRepository = employerRepository;
        this.bureauRepository=bureauRepository;
    }
    @GetMapping("/all")
    public List<Employer> getAll(){
        return employerRepository.findAll();
    }
    @GetMapping("/find/{id}")
    public Optional<Employer> getById(@PathVariable("id") Long id ){
        return employerRepository.findById(id);
    }
    @PostMapping("/add")
    public Employer CreateAssocie(@RequestBody  Employer employer){

        bureauRepository.save(employer.getBureau());
        return employerRepository.save(employer);
    }
    @PutMapping("/update")
    public Employer updateAssocie(@RequestBody  Employer employer){
        if(employerRepository.existsById(employer.getID())){
            return employerRepository.save(employer);
        }
        return null;
    }
    @DeleteMapping("/delete/{id}")
    public void DeleteEmployer( @PathVariable("id") Long id) {
        employerRepository.deleteById(id);
    }
    @PutMapping("/assign/{employeeId}/to/{bureauId}")
    public Employer assignEmployeeToBureau(
            @PathVariable("employeeId") Long employeeId, @PathVariable("bureauId") Long bureauId) {
        Optional<Employer> optionalEmployee = employerRepository.findById(employeeId);
        Optional<Bureau> optionalBureau = bureauRepository.findById(bureauId);

        if (optionalEmployee.isPresent() && optionalBureau.isPresent()) {
            Employer employee = optionalEmployee.get();
            Bureau bureau = optionalBureau.get();

            employee.setBureau(bureau);
            return employerRepository.save(employee);
        }

        return null;
    }
}
