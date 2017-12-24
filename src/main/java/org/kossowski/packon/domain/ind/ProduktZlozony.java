package org.kossowski.packon.domain.ind;

import org.kossowski.packon.domain.IndeksMagazynowy;

import java.util.HashSet;
import java.util.Set;

public class ProduktZlozony extends IndeksMagazynowy {

    private Set<Produkt> produkty = new HashSet<>();
}
