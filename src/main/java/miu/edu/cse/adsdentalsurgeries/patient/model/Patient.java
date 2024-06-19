package miu.edu.cse.adsdentalsurgeries.patient.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.model.Address;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;
import miu.edu.cse.adsdentalsurgeries.user.model.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "date_of_birth", nullable = true)
	private LocalDate dateOfBirth;
	@Column(name = "outstanding_bill", nullable = true)
	private double outstandingBill;
	
	@OneToOne
	private Address address;
	
	@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
	private List<Appointment> appointments;
}
