package org.kossowski.packon.domain.przedmMagazynowe;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
public class Karton extends Wyrob {

    private Long dlugosc;
    private Long szerokosc;
    private Long wysokosc;

    private Long gramatura;


    public Double powierzchnia() {
        return dlugosc.doubleValue() * szerokosc.doubleValue() ;
    }

    public Double masa() {
        return powierzchnia() * gramatura.doubleValue();
    }


    @Override
    public String getRodzaj() {
        return "Karton";
    }

    public Long getDlugosc() {
        return dlugosc;
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

    public Long getGramatura() {
        return gramatura;
    }

    public void setGramatura(Long gramatura) {
        this.gramatura = gramatura;
    }

    public Long getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(Long wysokosc) {
        this.wysokosc = wysokosc;
    }
}
