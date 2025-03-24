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

       patientRepository.save(new Patient(null,"TSEH", new Date(),Math.random()>0.5?true:false,15));
       patientRepository.save(new Patient(null,"alasanne", new Date(),Math.random()>0.5?true:false,40));
       patientRepository.save(new Patient(null,"Mohammed", new Date(),Math.random()>0.5?true:false,30));


    }
}
