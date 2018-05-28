package org.kossowski.packon.repositories;

import org.kossowski.packon.domain.PrzedmiotMagazynowy;
import org.kossowski.packon.domain.przedmMagazynowe.Material;
import org.kossowski.packon.domain.przedmMagazynowe.Wyrob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PrzedmiotMagazynowyRepository extends JpaRepository<PrzedmiotMagazynowy, Long > {


    @Query("select m from Material m")
    public List<Material> findAllMaterial();

    @Query("select w from Wyrob w")
    public List<Wyrob> findAllWyrob();
}
