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
      
      Long id = null;
      try {
         id = Long.valueOf(value);
      } catch ( NumberFormatException e ) {
         return null;
      }
      
      
      IndeksMagazynowy im = null;
      if( id != 0L )
         im = indeksRepo.findOne( id );
      
      return im;
   }

   @Override
   public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
      
      //log.info( log.getName() + " getAsString value.getClass =" + value.getClass().getSimpleName() );
      //log.info( log.getName() + " getAsString value  = " + value );
      
      IndeksMagazynowy im = null;
      try {
         im = (IndeksMagazynowy)value;
      } catch ( ClassCastException e ) {
         
         //log.info( log.getName() + " getAsString wyjatek im=" + im );
         //im = new IndeksMagazynowy();
         //im = null;
      }
      
      //log.info( log.getName() + " getAsString po wyjatku im=" + im );
      //if( im != null)
      //   log.info( log.getName() + " getAsString po wyjatku im.getId=" + im.getId() );
      
      return im == null ? null : im.getId().toString();
   }

}
