package org.kossowski.packon.controllers;

import org.kossowski.packon.domain.PrzedmiotMagazynowy;
import org.kossowski.packon.domain.przedmMagazynowe.*;
import org.kossowski.packon.repositories.PrzedmiotMagazynowyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.math.BigDecimal;
import java.util.List;

@ManagedBean
@RequestScoped
@Controller
public class PrzedmiotMagazynowyAddController {

    @Autowired
    protected PrzedmiotMagazynowyRepository przedmiotMagazynowyRepository;

    public void addSampleThing() {

        ProstyMaterial pm = new ProstyMaterial();
        pm.getIndeksMag().setIndeks("pr mat 1 symbol");
        pm.getIndeksMag().setNazwa( "pp mat 1 nazwa ");
        przedmiotMagazynowyRepository.save( pm );

        Tektura t = new Tektura();
        t.getIndeksMag().setIndeks("tektura 1 symbol");
        t.getIndeksMag().setNazwa( "tektira 1 nazwa ");
        t.setDlugosc( 100L );
        t.setSzerokosc( 333L );
        t.setGramatura( new BigDecimal( 300 ));
        przedmiotMagazynowyRepository.save( t );

        Karton k = new Karton();
        k.getIndeksMag().setIndeks("karton 1 symbol");
        k.getIndeksMag().setNazwa( "karton 1 nazwa ");
        k.setDlugosc( 2l );
        k.setSzerokosc( 3L );
        k.setWysokosc( 4L );
        przedmiotMagazynowyRepository.save( k );


    }

    public List<Material> getMaterialList() {
            return przedmiotMagazynowyRepository.findAllMaterial();
    }

    public List<Wyrob> getWyrobyList() {
        return przedmiotMagazynowyRepository.findAllWyrob();
    }
}
