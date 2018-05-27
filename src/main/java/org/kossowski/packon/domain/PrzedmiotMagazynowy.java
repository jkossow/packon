package org.kossowski.packon.domain;


import javax.persistence.*;

@Entity
// joined dla sprawdzenia wydajnosci
@Table( name = "przedmioty_magazynowe")
@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
public class PrzedmiotMagazynowy extends BaseEntity<Long> {


    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "indeks_magazynowy_id", foreignKey = @ForeignKey(  name = "FK_przedmiot_magazynowy__indeks_magazynowy")  )
    private IndeksMagazynowy indeksMag = new IndeksMagazynowy();

    @ManyToOne
    @JoinColumn( foreignKey = @ForeignKey( name = "FK_przedmiot_magazynowy__jm" ))
    private Jm jm;



    public String getRodzaj() {
        return "przedmiotMagazynowy";
    }




    public IndeksMagazynowy getIndeksMag() {
        return indeksMag;
    }

    public void setIndeksMag(IndeksMagazynowy indeksMag) {
        this.indeksMag = indeksMag;
    }

    public Jm getJm() {
        return jm;
    }

    public void setJm(Jm jm) {
        this.jm = jm;
    }



    @Override
    public String toString() {
        return "PrzedmiotMagazynowy{" +
                "indeksMag=" + indeksMag +
                ", jm=" + jm +
                "} " + super.toString();
    }
}
