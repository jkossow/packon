package org.kossowski.packon.domain.przedmMagazynowe;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Embeddable
public class PozycjaKompletu {

    @ManyToOne
    @JoinColumn( foreignKey = @ForeignKey( name = "FK_pozycja_kompletu__wyrob" ))
    private Wyrob wyrob;
    private BigDecimal ilosc;

    public Wyrob getWyrob() {
        return wyrob;
    }

    public void setWyrob(Wyrob wyrob) {
        this.wyrob = wyrob;
    }

    public BigDecimal getIlosc() {
        return ilosc;
    }

    public void setIlosc(BigDecimal ilosc) {
        this.ilosc = ilosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PozycjaKompletu that = (PozycjaKompletu) o;

        if (getWyrob() != null ? !getWyrob().equals(that.getWyrob()) : that.getWyrob() != null) return false;
        return getIlosc() != null ? getIlosc().equals(that.getIlosc()) : that.getIlosc() == null;
    }

    @Override
    public int hashCode() {
        int result = getWyrob() != null ? getWyrob().hashCode() : 0;
        result = 31 * result + (getIlosc() != null ? getIlosc().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PozycjaKompletu{" +
                "wyrob=" + wyrob +
                ", ilosc=" + ilosc +
                '}';
    }


}
