package org.kossowski.packon.repositories;

import java.util.List;

import org.kossowski.packon.domain.Kontrahent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KontrahentRepostory  extends JpaRepository<Kontrahent, Long>{
   
   public List<Kontrahent> findByOdbiorcaTrue();
   public List<Kontrahent> findByDostawcaTrue();
   
}
