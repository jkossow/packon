package org.kossowski.packon.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Adres implements Serializable {

    // Address

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String ulica;
    private String nrDomu;
    private String nrLokalu;
    private String miejscowosc;
    private String poczta;
    private String kodPocztowy;

    public Adres() {
    };

    public Adres( String miejscowosc, String ulica, String nrDomu, String nrLokalu, String kodPocztowy, String poczta) {
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrLokalu = nrLokalu;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }


    public Adres(Adres a) {
        setUlica(new String(a.getUlica()));
        setNrDomu(new String(a.getNrDomu()));
        setNrLokalu(new String(a.getNrLokalu()));
        setMiejscowosc(new String(a.getMiejscowosc()));
        setPoczta(new String(a.getPoczta()));
        setKodPocztowy(new String(a.getKodPocztowy()));
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((kodPocztowy == null) ? 0 : kodPocztowy.hashCode());
        result = prime * result + ((miejscowosc == null) ? 0 : miejscowosc.hashCode());
        result = prime * result + ((nrDomu == null) ? 0 : nrDomu.hashCode());
        result = prime * result + ((nrLokalu == null) ? 0 : nrLokalu.hashCode());
        result = prime * result + ((poczta == null) ? 0 : poczta.hashCode());
        result = prime * result + ((ulica == null) ? 0 : ulica.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Adres))
            return false;
        Adres other = (Adres) obj;
        if (kodPocztowy == null) {
            if (other.kodPocztowy != null)
                return false;
        } else if (!kodPocztowy.equals(other.kodPocztowy))
            return false;
        if (miejscowosc == null) {
            if (other.miejscowosc != null)
                return false;
        } else if (!miejscowosc.equals(other.miejscowosc))
            return false;
        if (nrDomu == null) {
            if (other.nrDomu != null)
                return false;
        } else if (!nrDomu.equals(other.nrDomu))
            return false;
        if (nrLokalu == null) {
            if (other.nrLokalu != null)
                return false;
        } else if (!nrLokalu.equals(other.nrLokalu))
            return false;
        if (poczta == null) {
            if (other.poczta != null)
                return false;
        } else if (!poczta.equals(other.poczta))
            return false;
        if (ulica == null) {
            if (other.ulica != null)
                return false;
        } else if (!ulica.equals(other.ulica))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Adres [ulica=" + ulica + ", nrDomu=" + nrDomu + ", nrLokalu=" + nrLokalu + ", miejscowosc=" + miejscowosc
                + ", poczta=" + poczta + ", kodPocztowy=" + kodPocztowy + "]";
    }

}
