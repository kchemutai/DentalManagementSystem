package miu.edu.cse.adsdentalsurgeries.dentist.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;
import miu.edu.cse.adsdentalsurgeries.user.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dentist extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = true)
	private String specialization;
	
	@OneToMany(mappedBy = "dentist")
	private List<Appointment> appointments;

	public Dentist(String specialization) {
		this.specialization = specialization;
		this.appointments = new ArrayList<>();
	}

	public void addAppointment(Appointment appointment) {
		this.appointments.add(appointment);
	}
}
