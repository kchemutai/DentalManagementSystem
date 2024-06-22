package miu.edu.cse.adsdentalsurgeries.address.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Street cannot be null or empty")
	private String street;

	@NotEmpty(message = "City cannot be null or empty")
	private String city;

	@NotEmpty(message = "State cannot be null or empty")
	private String state;

	@NotEmpty(message = "Zip cannot be null or empty")
	private String  zip;
	
}
