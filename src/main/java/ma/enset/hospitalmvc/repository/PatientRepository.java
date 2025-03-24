package ma.enset.hospitalmvc.repository;

import ma.enset.hospitalmvc.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
