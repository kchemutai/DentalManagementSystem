package miu.edu.cse.adsdentalsurgeries.surgery.repository;

import miu.edu.cse.adsdentalsurgeries.surgery.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SurgeryRepository extends JpaRepository<Surgery, Integer> {

}
