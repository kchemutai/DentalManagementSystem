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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.cse.adsdentalsurgeries.address.model.Address;
import miu.edu.cse.adsdentalsurgeries.appointment.model.Appointment;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Surgery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Surgery_Name")
	private String surgeryName;

	@Column(name = "Phone_Number")
	private String phoneNumber;
	
	@OneToOne
	private Address address;
	
	@OneToOne(mappedBy = "surgery", cascade = CascadeType.ALL)
	private Appointment appointment;

	public Surgery(String surgeryName, String phoneNumber, Address address, Appointment appointment) {
		this.surgeryName = surgeryName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.appointment = appointment;
	}

}
