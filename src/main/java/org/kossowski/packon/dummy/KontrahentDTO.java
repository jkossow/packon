package org.kossowski.packon.dummy;

import org.kossowski.packon.domain.Adres;
import org.kossowski.packon.domain.IndeksMagazynowy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class KontrahentDTO {

    private long id;
    private int version;

    private String symbol;
    private String nazwa;
    private String nip;
    private String regon;


    private String email;

    private Boolean dostawca = false;
    private Boolean odbiorca = false;


    private Adres adres = new Adres();


    private Set<IndeksMagazynowy> wyrobyGotowe = new HashSet<>();


    private Map<String, Adres> adresyWysylkowe = new HashMap<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
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


    @Override
    public String toString() {
        return "KontrahentDTO{" +
                "id=" + id +
                ", version=" + version +
                ", symbol='" + symbol + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", nip='" + nip + '\'' +
                ", regon='" + regon + '\'' +
                ", email='" + email + '\'' +
                ", dostawca=" + dostawca +
                ", odbiorca=" + odbiorca +
                ", adres=" + adres +
                ", wyrobyGotowe=" + wyrobyGotowe +
                ", adresyWysylkowe=" + adresyWysylkowe +
                '}';
    }
}
