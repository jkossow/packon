package org.kossowski.packon.domain;


import org.kossowski.packon.domain.przedmMagazynowe.Wyrob;

import javax.persistence.*;
import java.util.*;

@Entity
@Table( name = "kontrahenci" )
public class Kontrahent extends BaseEntity<Long> {

    // Customer



    private String symbol;
    private String nazwa;
    private String nip;
    private String regon;


    private String email;

    private Boolean dostawca = false;
    private Boolean odbiorca = false;

    @Embedded
    private Adres adres = new Adres();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( inverseForeignKey = @ForeignKey( name = "FK_kontrahent__indeks_magazynowy") )
    private Set<IndeksMagazynowy> wyrobyGotowe = new HashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "kontrahent_adresy_wysylkowe", joinColumns = @JoinColumn(name = "kontrahent_id"))
    @MapKeyJoinColumn(name = "kontrahent_id", referencedColumnName = "id")
    private Map<String, Adres> adresyWysylkowe = new HashMap<>();


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public Set<IndeksMagazynowy> getWyrobyGotowe() {
        return wyrobyGotowe;
    }

    public void setWyrobyGotowe(Set<IndeksMagazynowy> wyrobyGotowe) {
        this.wyrobyGotowe = wyrobyGotowe;
    }

    public Map<String, Adres> getAdresyWysylkowe() {
        return adresyWysylkowe;
    }

    public void setAdresyWysylkowe(Map<String, Adres> adresyWysylkowe) {
        this.adresyWysylkowe = adresyWysylkowe;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Boolean getDostawca() {
        return dostawca;
    }

    public void setDostawca(Boolean dostawca) {
        this.dostawca = dostawca;
    }

    public Boolean getOdbiorca() {
        return odbiorca;
    }

    public void setOdbiorca(Boolean odbiorca) {
        this.odbiorca = odbiorca;
    }


    @Override
    public String toString() {
        return "Kontrahent{" +
                "symbol='" + symbol + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", email='" + email + '\'' +
                ", dostawca=" + dostawca +
                ", odbiorca=" + odbiorca +
                ", adres=" + adres +
                ", wyrobyGotowe=" + wyrobyGotowe +
                ", adresyWysylkowe=" + adresyWysylkowe +
                "} " + super.toString();
    }
}
