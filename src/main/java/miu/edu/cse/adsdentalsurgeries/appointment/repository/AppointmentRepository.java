package miu.edu.cse.adsdentalsurgeries.appointment.repository;


import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
