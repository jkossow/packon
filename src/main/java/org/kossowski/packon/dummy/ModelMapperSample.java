package org.kossowski.packon.dummy;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.kossowski.packon.domain.Adres;
import org.kossowski.packon.domain.Kontrahent;
import org.kossowski.packon.utils.AdresUtils;


public class ModelMapperSample {







    public static void main( String[] args ) {


        Mapper bm = new DozerBeanMapper();

        Kontrahent k = new Kontrahent();

        k.setId( 222L );
        k.getAdresyWysylkowe().put("sadowa", AdresUtils.AdresWyslkowySadowa() );
        k.getAdresyWysylkowe().put("11-list", AdresUtils.AdresWyslkowy11Listopada() );


        System.out.println( k );

        KontrahentDTO kDto = bm.map( k, KontrahentDTO.class );



        System.out.println( kDto );

        Kontrahent k1 = bm.map( kDto, Kontrahent.class );

        System.out.println( k1 );


    }

}

