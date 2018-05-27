package org.kossowski.packon.domain.przedmMagazynowe;

import org.kossowski.packon.domain.BaseEntity;
import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.domain.PrzedmiotMagazynowy;
import org.kossowski.packon.domain.WzorzecOperacji;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public abstract class Wyrob extends PrzedmiotMagazynowy {


    // TODO: dopisac definicje join table dla @ManyToMAny
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( inverseForeignKey = @ForeignKey( name = "FK_wyrob__material" ) )
    private Set<Material> materials = new HashSet<>();

    // oparecje konieczne do wyprodukowania wyrobu
    @ManyToMany(fetch = FetchType.LAZY)
    @OrderColumn
    @JoinTable( inverseForeignKey =  @ForeignKey( name = "FK_wyrob__wzorzec_operacji") )
    private List<WzorzecOperacji> technologia = new ArrayList<>();


    // preferowany rozmiar palety - propozycja
    private String wymiarPalety;
    private String klisza;
    private String wykrojnik;
    // preferowana ilość sztuk na palecie
    private BigInteger iloscSztukNaPalecie;

    public Set<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(Set<Material> materials) {
        this.materials = materials;
    }

    public List<WzorzecOperacji> getTechnologia() {
        return technologia;
    }

    public void setTechnologia(List<WzorzecOperacji> technologia) {
        this.technologia = technologia;
    }
}
