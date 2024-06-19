package miu.edu.cse.adsdentalsurgeries.patient.repository;

import miu.edu.cse.adsdentalsurgeries.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
