package ma.younes.hostpital;

import ma.younes.hostpital.entities.Consultation;
import ma.younes.hostpital.entities.Medecin;
import ma.younes.hostpital.entities.Patient;
import ma.younes.hostpital.entities.RendezVous;
import ma.younes.hostpital.repositories.ConsultationRepository;
import ma.younes.hostpital.repositories.MedecinRepository;
import ma.younes.hostpital.repositories.PatientRepository;
import ma.younes.hostpital.repositories.RendezVousRepository;
import ma.younes.hostpital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HostpitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostpitalApplication.class, args);
	}

    @Bean
	CommandLineRunner start(IHospitalService hospitalService,
							PatientRepository patientRepository,
							RendezVousRepository rendezVousRepository,
							ConsultationRepository consultationRepository,
							MedecinRepository medecinRepository) {
     return args -> {
		 Stream.of("Mohamed","Hassan","Najat").forEach(name -> {
			 Patient patient = new Patient();
			 patient.setNom(name);
			 patient.setDateNaissance(new Date());
			 patient.setMalade(false);
			 hospitalService.savePatient(patient);
		 });
		 Stream.of("aymane","hanane","yasmine").forEach(name -> {
			 Medecin medecin = new Medecin();
			 medecin.setNom(name);
			 medecin.setEmail(name+"@gmail.com");
			 medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
			 hospitalService.saveMedecin(medecin);
		 });

		 	Patient patient = patientRepository.findById(1L).orElse(null);
			 Patient patient1 = patientRepository.findByNom("Hassan");

		 Medecin medecin = medecinRepository.findByNom("yasmine");

		 RendezVous rendezVous=new RendezVous();
		 rendezVous.setDate(new Date());
		 rendezVous.setStatus(StatusRDV.PENDING);
		 rendezVous.setMedecin(medecin);
		 rendezVous.setPatient(patient);

		 RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
		 System.out.println(saveDRDV.getId());

		 RendezVous rendezVous1 = rendezVousRepository.findAll().getFirst();
		 Consultation consultation = new Consultation();
		 consultation.setDateConsultation(new Date());
		 consultation.setRendezVous(rendezVous1);
		 consultation.setRapport("Rapport de la Consultation ........");
		 hospitalService.saveConsultation(consultation);

	 };
	}

}
