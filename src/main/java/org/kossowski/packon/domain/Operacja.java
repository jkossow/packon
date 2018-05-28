package org.kossowski.packon.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table( name = "operacje" )
public class Operacja extends BaseEntity<Long> {

    //Operation

    private String symbol;
    private String nazwa;

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
        return "Operacja{" +
                "symbol='" + symbol + '\'' +
                ", nazwa='" + nazwa + '\'' +
                "} " + super.toString();
    }
}
