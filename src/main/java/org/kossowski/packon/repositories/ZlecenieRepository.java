package org.kossowski.packon.repositories;

import org.kossowski.packon.domain.Zlecenie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ZlecenieRepository extends JpaRepository<Zlecenie, Long> {

}
