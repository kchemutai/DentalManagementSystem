package miu.edu.cse.adsdentalsurgeries.appointment.model;

import jakarta.persistence.*;
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
	private String street;
	private String city;
	@NotNull
	private String zip;
	
	@ManyToOne
	@JoinColumn(name = "surgery_id")
	private Surgery surgery;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "dentist_id")
	private Patient dentist;

	@OneToOne
	private Address location;
}
