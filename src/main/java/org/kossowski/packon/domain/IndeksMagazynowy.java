package org.kossowski.packon.domain;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.kossowski.packon.domain.nowe.Magazynowalny;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "indeksy_magazynowe",

        indexes = {
            @Index( name = "UK_indeks", columnList = "indeks", unique = true )
        }

)
public class IndeksMagazynowy extends BaseEntity<Long> {

    // stockIndex
    // warehouseIndex
    // storagehouseIndex



    @Column( name="indeks",  nullable = false )
    private String indeks;

    private String nazwa;

    //@ManyToOne
    //private Jm jednMiary;


    // wskazuje, ze ten indeks jest wyrobemGotowym
    private Boolean wyrobGotowy;

    // wskazuje, ze ten indeks jest materialem do produkcji
    private Boolean material;

    @OneToOne( mappedBy = "indeksMag")
    @JoinColumn( foreignKey = @ForeignKey( name = "indeks_przedmiot" ))
    private PrzedmiotMagazynowy przedmiotMagazynowy;


    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Boolean getWyrobGotowy() {
        return wyrobGotowy;
    }

    public void setWyrobGotowy(Boolean wyrobGotowy) {
        this.wyrobGotowy = wyrobGotowy;
    }

    public Boolean getMaterial() {
        return material;
    }

    public void setMaterial(Boolean material) {
        this.material = material;
    }

    public PrzedmiotMagazynowy getPrzedmiotMagazynowy() {
        return przedmiotMagazynowy;
    }

    public void setPrzedmiotMagazynowy(PrzedmiotMagazynowy przedmiotMagazynowy) {
        this.przedmiotMagazynowy = przedmiotMagazynowy;
    }


    @Override
    public String toString() {
        return "IndeksMagazynowy{" +
                "indeks='" + indeks + '\'' +
                ", nazwa='" + nazwa + '\'' +
                ", wyrobGotowy=" + wyrobGotowy +
                ", material=" + material +
                ", przedmiotMagazynowy=" + przedmiotMagazynowy +
                "} " + super.toString();
    }
}


