package miu.edu.cse.adsdentalsurgeries.surgery.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.model.Address;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Surgery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Surgery name cannot be empty")
	@Column(name = "Surgery_Name")
	private String surgeryName;

	@NotEmpty(message = "Phone number cannot be empty")
	@Column(name = "Phone_Number")
	private String phoneNumber;

	@NotNull(message = "Address cannot be null")
	@OneToOne(cascade = CascadeType.PERSIST)
	private Address address;

	@OneToOne(mappedBy = "surgery", cascade = CascadeType.PERSIST)
	private Appointment appointment;

	public Surgery(String surgeryName, String phoneNumber, Address address) {
		this.surgeryName = surgeryName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

}
