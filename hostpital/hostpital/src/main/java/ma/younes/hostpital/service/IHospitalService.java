package ma.younes.hostpital.service;

import ma.younes.hostpital.entities.Consultation;
import ma.younes.hostpital.entities.Medecin;
import ma.younes.hostpital.entities.Patient;
import ma.younes.hostpital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
