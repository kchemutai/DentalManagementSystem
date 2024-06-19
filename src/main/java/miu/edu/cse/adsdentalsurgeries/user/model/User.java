package miu.edu.cse.adsdentalsurgeries.user.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
@AllArgsConstructor
@Builder
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "First_Name")
	@NotEmpty(message = "First name cannot be empty")
	private String firstName;

	@Column(name = "Last_Name")
	@NotEmpty(message = "Last name cannot be empty")
	private String lastName;

	@Size(min = 10, max = 10, message = "Phone number must be 10 digit US format")
	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	@Column(unique = true)
	@NotNull(message = "email cannot be empty")
	private String email;

	@NotNull(message = "Password cannot be null")
	private String password;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Role cannot be null")
	private Role role;

	public User(String firstName, String lastName, String phoneNumber, String email, String password, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role.getAuthorities();
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return UserDetails.super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return UserDetails.super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return UserDetails.super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return UserDetails.super.isEnabled();
	}
}
