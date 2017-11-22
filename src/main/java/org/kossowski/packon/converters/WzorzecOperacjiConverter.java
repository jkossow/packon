package org.kossowski.packon.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.kossowski.packon.domain.WzorzecOperacji;
import org.kossowski.packon.repositories.WzorzecOperacjiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@ManagedBean
public class WzorzecOperacjiConverter implements Converter {

   Logger log = LoggerFactory.getLogger( this.getClass() );
   
   @Autowired
   protected WzorzecOperacjiRepository wzorzecOperacjiRepo;
   
   @Override
   public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
      
      if (value.isEmpty() )
         return null;
      
      Long id;
      
      try {
        id = Long.valueOf( value );
      } catch ( NumberFormatException e ) {
         return null;
      }
      
      WzorzecOperacji wz = null;
      if( id != 0L )
         wz = wzorzecOperacjiRepo.findOne( id );
      
      return wz;
   }

   @Override
   public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
      
      //log.info( log.getName() + " getAsString value.getClass =" + value.getClass().getSimpleName() );
      //log.info( log.getName() + " getAsString value  = " + value );
      
      WzorzecOperacji wz = null;
      try {
         wz = (WzorzecOperacji)value;
      } catch ( ClassCastException e ) {
         
         //log.info( log.getName() + " getAsString wyjatek im=" + im );
         //im = new IndeksMagazynowy();
         //im = null;
      }
      
      //log.info( log.getName() + " getAsString po wyjatku im=" + im );
      //if( im != null)
      //   log.info( log.getName() + " getAsString po wyjatku im.getId=" + im.getId() );
      
      return wz == null ? null : wz.getId().toString();
   }

}
