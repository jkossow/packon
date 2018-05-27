package org.kossowski.packon.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "jednostki_miary", indexes = {

        @Index( name = "UK_symbol", columnList = "symbol", unique = true )

        }
)
public class Jm extends BaseEntity<Long> {


    // UnitOfMeausure


    @Column(name = "symbol", nullable = false)
    private String symbol;
    private String nazwa;


    public Jm() {
    }

    ;

    public Jm(String symbol, String nazwa) {
        this.symbol = symbol;
        this.nazwa = nazwa;
    }

    public Jm(long id, String symbol, String nazwa) {
        setId(id);
        this.symbol = symbol;
        this.nazwa = nazwa;
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

    @Override
    public String toString() {
        return "Jm{" +
                "id=" + getId() +
                ", version=" + getVersion() +
                ", symbol='" + symbol + '\'' +
                ", nazwa='" + nazwa + '\'' +
                "} " + super.toString();
    }
}
