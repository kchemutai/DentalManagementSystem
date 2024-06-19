package miu.edu.cse.adsdentalsurgeries.dentist.repository;

import miu.edu.cse.adsdentalsurgeries.dentist.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DentistRepository extends JpaRepository<Dentist, Integer> {

}
