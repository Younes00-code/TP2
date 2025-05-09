package ma.younes.hostpital.repositories;

import ma.younes.hostpital.entities.Medecin;
import ma.younes.hostpital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String name);
}
