package org.kossowski.packon.domain.przedmMagazynowe;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.domain.PrzedmiotMagazynowy;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Tektura extends Material {

    private Long dlugosc;
    private Long szerokosc;

    private BigDecimal gramatura;


    public Long getDlugosc() {
        return dlugosc;
    }


    @Override
    public String getRodzaj() {
        return "Tektura";
    }

    public void setDlugosc(Long dlugosc) {
        this.dlugosc = dlugosc;
    }

    public Long getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(Long szerokosc) {
        this.szerokosc = szerokosc;
    }

    public BigDecimal getGramatura() {
        return gramatura;
    }

    public void setGramatura(BigDecimal gramatura) {
        this.gramatura = gramatura;
    }




    @Override
    public String toString() {
        return "Tektura{" +
                "gramatura=" + gramatura +
                "} " + super.toString();
    }
}
