package miu.edu.cse.adsdentalsurgeries.user.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
	PATIENT_WRITE("patient:write"),
	PATIENT_READ("patient:read"),
	DENTIST_WRITE("dentist:write"),
	DENTIST_READ("dentist:read"),
	ADMIN_WRITE("admin:write"),
	ADMIN_READ("admin:read");

	@Getter
	private final String permission;
}
