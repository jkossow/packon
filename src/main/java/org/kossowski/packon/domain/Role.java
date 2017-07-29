package org.kossowski.packon.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embeddable;

@Embeddable
public class Role {
	
	private static Set<Role> allRoles = initRoles();
	
	
	private String role;
	
	
	public Role() {}
	
	public Role( String role ) {
		this.role = role;
	}

	
	

	public static Set<Role> initRoles() {
		
		HashSet<Role> s = new HashSet<>();
		
		s.add( new Role( "ROLE_ADMIN"));
		s.add( new Role( "ROLE_OPERATOR"));
	
		
		return s;
	}


	

	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	
	
}
