package org.kossowski.packon.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@ManagedBean
public class IndeksMagazynowyConverter implements Converter {

   Logger log = LoggerFactory.getLogger( this.getClass() );
   
   @Autowired
   protected IndeksMagazynowyRepository indeksRepo;
   
   @Override
   public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
      
      if (value.isEmpty() )
         return null;
      
      Long id = Long.valueOf( value );
      IndeksMagazynowy im = null;
      if( id != 0L )
         im = indeksRepo.findOne( id );
      
      return im;
   }

   @Override
   public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
      
      log.info( log.getName() + " getAsString value.getClass =" + value.getClass().getSimpleName() );
      
      IndeksMagazynowy im = null;
      try {
         im = (IndeksMagazynowy)value;
      } catch ( ClassCastException e ) {
         //im = new IndeksMagazynowy();
         //im = null;
      }
      
      return im != null ? im.getId().toString() : "";
   }

}
