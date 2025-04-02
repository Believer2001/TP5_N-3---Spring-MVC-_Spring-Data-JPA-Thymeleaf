package ma.enset.hospitalmvc;

import ma.enset.hospitalmvc.entities.Patient;
import ma.enset.hospitalmvc.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class HospitalMvcApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository PatientRepository;
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalMvcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

      // patientRepository.save(new Patient(null,"TSEH Kokou Benoit", new Date(),Math.random()>0.5?true:false,115));
      // patientRepository.save(new Patient(null,"alasanne Touré", new Date(),Math.random()>0.5?true:false,240));
      // patientRepository.save(new Patient(null,"Mohammed daiif", new Date(),Math.random()>0.5?true:false,330));


    }
}
