package org.kossowski.packon.factorry;

import java.util.Date;
import java.util.HashSet;

import org.kossowski.packon.domain.Status;
import org.kossowski.packon.domain.Zlecenie;

public class ZlecenieFactory {

   public static Zlecenie newInstance() {
      
      Zlecenie z = new Zlecenie();
      
      z.setData( new Date() );
      z.setStatus( Status.NOWE );
      
      z.setZamowieniaMaterialu( new HashSet<>() );
      
      return z;
   }
   
}
