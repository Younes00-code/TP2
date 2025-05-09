package ma.younes.hostpital.web;

import ma.younes.hostpital.entities.Patient;
import ma.younes.hostpital.entities.RendezVous;
import ma.younes.hostpital.repositories.PatientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    private PatientRepository patientRepository;
    @GetMapping("/patients")
    public List<Patient> patientList(){
        return patientRepository.findAll();
    }
}
