package miu.edu.cse.adsdentalsurgeries.user.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RequiredArgsConstructor
public enum Role {

	PATIENT(
			Set.of(Permission.PATIENT_WRITE, Permission.PATIENT_READ)
    ),

	DENTIST(
			Set.of(Permission.DENTIST_WRITE, Permission.DENTIST_READ)
    ),
	ADMIN(
			Set.of(Permission.ADMIN_WRITE, Permission.ADMIN_READ)
    );

	@Getter
	private final Set<Permission> permissions;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		var authorities = new ArrayList<GrantedAuthority>();
		for (var permission : permissions) {
			authorities.add(new SimpleGrantedAuthority(permission.getPermission()));
		}
		authorities.add(new SimpleGrantedAuthority("ROLE_" + name()));
		return authorities;
	}
}
