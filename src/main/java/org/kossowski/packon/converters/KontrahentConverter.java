package org.kossowski.packon.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.kossowski.packon.domain.Kontrahent;
import org.kossowski.packon.repositories.KontrahentRepostory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@ManagedBean
public class KontrahentConverter implements Converter {

   Logger log = LoggerFactory.getLogger( this.getClass() );
   
   @Autowired
   protected KontrahentRepostory kontrahRepo;
   
   @Override
   public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
      
      if (value.isEmpty() )
         return null;
      
      Long id = Long.valueOf( value );
      Kontrahent k = null;
      if( id != 0L )
         k = kontrahRepo.findOne( id );
      
      return k;
   }

   @Override
   public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
      
      log.info( log.getName() + " getAsString value.getClass =" + value.getClass().getSimpleName() );
      
      Kontrahent k = null;
      try {
         k = (Kontrahent)value;
      } catch ( ClassCastException e ) {
         //im = new IndeksMagazynowy();
         //im = null;
      }
      
      return k == null ? null : k.getId().toString();
   }

}
