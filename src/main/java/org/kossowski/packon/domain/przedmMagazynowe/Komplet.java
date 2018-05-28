package org.kossowski.packon.domain.przedmMagazynowe;

import org.kossowski.packon.domain.IndeksMagazynowy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Komplet extends IndeksMagazynowy {


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "komplet_pozycje_kompletu", joinColumns = @JoinColumn(name = "komplet_id"),
            foreignKey =  @ForeignKey( name = "FK_komplet")
    )
    @MapKeyJoinColumn(name = "komplet_id", referencedColumnName = "id"
            )
    private Set<PozycjaKompletu> produkty = new HashSet<>();


}

