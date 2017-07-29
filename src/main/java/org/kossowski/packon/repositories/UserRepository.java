package org.kossowski.packon.repositories;

import org.kossowski.packon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
	
	
}
