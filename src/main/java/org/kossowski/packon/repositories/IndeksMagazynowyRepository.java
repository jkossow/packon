package org.kossowski.packon.repositories;

import java.util.List;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndeksMagazynowyRepository extends JpaRepository<IndeksMagazynowy, Long> {
   
   public List<IndeksMagazynowy> findByWyrobGotowyTrue();
   public List<IndeksMagazynowy> findByMaterialTrue();

}
