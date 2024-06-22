package miu.edu.cse.adsdentalsurgeries.dentist.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;
import miu.edu.cse.adsdentalsurgeries.user.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Dentist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Specialisation cannot be null or empty")
	@Column(nullable = false)
	private String specialization;

	@NotNull(message = "User details cannot be null")
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private User user;
	
	@OneToMany(mappedBy = "dentist")
	private List<Appointment> appointments;

	public Dentist(String specialization, User user) {
		this.specialization = specialization;
		this.user = user;
		this.appointments = new ArrayList<>();
	}


	public void addAppointment(Appointment appointment) {
		this.appointments.add(appointment);
	}
}
