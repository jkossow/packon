package org.kossowski.packon.domain;

import org.kossowski.packon.domain.przedmMagazynowe.Material;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zamowienia_materialow")
public class ZamowienieMaterialu extends BaseEntity<Long> {

    // MaterialsOrder

    @ManyToOne
    @JoinColumn(name = "zlecenie_id", foreignKey = @ForeignKey( name = "FK_zamowienie_materialu__zlecenie" ))
    private Zlecenie zlecenie;

    @Temporal(TemporalType.DATE)
    private Date dataZamowienia;

    @Temporal(TemporalType.DATE)
    private Date terminDostawy;

    @ManyToOne
    @JoinColumn( foreignKey = @ForeignKey( name = "FK_zamowienie_materialu__indeks_magazynowy" ))
    private Material material;

    @ManyToOne
    @JoinColumn( foreignKey =  @ForeignKey( name = "FK_zamowienie_materialu__dostawca" ))
    private Kontrahent dostawca;

    private BigDecimal iloscZamowiona;
    private BigDecimal iloscDostarczona;

    private BigDecimal wartosc;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "zamowienieMaterialu",
            fetch = FetchType.LAZY)
    //@JoinColumn( name = "zam_mat_id")
    private Set<DostawaMaterialu> dostawy = new HashSet<>();

    public Date getDataZamowienia() {
        return dataZamowienia;
    }

    public void setDataZamowienia(Date dataZamowienia) {
        this.dataZamowienia = dataZamowienia;
    }

    public Date getTerminDostawy() {
        return terminDostawy;
    }

    public void setTerminDostawy(Date terminDostawy) {
        this.terminDostawy = terminDostawy;
    }


    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Kontrahent getDostawca() {
        return dostawca;
    }

    public void setDostawca(Kontrahent dostawca) {
        this.dostawca = dostawca;
    }

    public BigDecimal getIloscZamowiona() {
        return iloscZamowiona;
    }

    public void setIloscZamowiona(BigDecimal iloscZamowiona) {
        this.iloscZamowiona = iloscZamowiona;
    }

    public BigDecimal getIloscDostarczona() {
        return iloscDostarczona;
    }

    public void setIloscDostarczona(BigDecimal iloscDostarczona) {
        this.iloscDostarczona = iloscDostarczona;
    }

    public BigDecimal getWartosc() {
        return wartosc;
    }

    public void setWartosc(BigDecimal wartosc) {
        this.wartosc = wartosc;
    }

    public Zlecenie getZlecenie() {
        return zlecenie;
    }

    public void setZlecenie(Zlecenie zlecenie) {
        this.zlecenie = zlecenie;
    }

    public Set<DostawaMaterialu> getDostawy() {
        return dostawy;
    }

    public void setDostawy(Set<DostawaMaterialu> dostawy) {
        this.dostawy = dostawy;
    }


    @Override
    public String toString() {
        return "ZamowienieMaterialu{" +
                "zlecenie=" + zlecenie +
                ", dataZamowienia=" + dataZamowienia +
                ", terminDostawy=" + terminDostawy +
                ", material=" + material +
                ", dostawca=" + dostawca +
                ", iloscZamowiona=" + iloscZamowiona +
                ", iloscDostarczona=" + iloscDostarczona +
                ", wartosc=" + wartosc +
                ", dostawy=" + dostawy +
                "} " + super.toString();
    }
}
