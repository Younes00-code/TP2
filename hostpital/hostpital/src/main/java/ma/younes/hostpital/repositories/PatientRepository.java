package ma.younes.hostpital.repositories;

import ma.younes.hostpital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByNom(String name);

}
