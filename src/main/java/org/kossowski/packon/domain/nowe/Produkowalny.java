package org.kossowski.packon.domain.nowe;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.domain.WzorzecOperacji;

import java.util.List;
import java.util.Set;


public interface Produkowalny {


    public Set<IndeksMagazynowy> getMaterials();
    public List<WzorzecOperacji> getTechnology();

}
