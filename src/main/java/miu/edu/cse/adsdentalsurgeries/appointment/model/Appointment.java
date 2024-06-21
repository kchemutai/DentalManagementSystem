package miu.edu.cse.adsdentalsurgeries.appointment.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.model.Address;
import miu.edu.cse.adsdentalsurgeries.patient.model.Patient;
import miu.edu.cse.adsdentalsurgeries.surgery.model.Surgery;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Status cannot be null")
	private Status status;

	@OneToOne
	@JoinColumn(name = "surgery_id")
	@NotNull(message = "Surgery cannot be null")
	private Surgery surgery;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	@NotNull(message = "Patient cannot be null")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "dentist_id")
	@NotNull(message = "Dentist cannot be null")
	private Patient dentist;

	@OneToOne
	@NotNull(message = "Location cannot be null")
	private Address location;
}
