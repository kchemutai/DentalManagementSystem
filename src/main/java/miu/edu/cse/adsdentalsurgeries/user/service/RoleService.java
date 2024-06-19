package miu.edu.cse.adsdentalsurgeries.user.service;


import miu.edu.cse.adsdentalsurgeries.user.model.Role;

public interface RoleService {

	Integer createNewRole(Role role);
	
	Role findRoleById(Integer roleId);
	
	Role updateExistingRole(Role role);
	
	Integer deleteRole(Integer roleId);
}
