package org.kossowski.packon.converters;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@ManagedBean
public class GenericConverter<T, PK> implements Converter {

   
   
   @Override
   public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
      
      if (value.isEmpty() )
         return null;
      
      Long id = Long.valueOf( value );
      T im = null;
      if( id != 0L )
         im = getRepository().findOne( id );
      
      return im;
   }

   @Override
   public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
      
      IndeksMagazynowy im;
      try {
         im = (IndeksMagazynowy)value;
      } catch ( ClassCastException e ) {
         im = new IndeksMagazynowy();
      }
      
      return im != null ? im.getId().toString() : "0";
   }
   
   public JpaRepository<T, Serializable> getRepository() {
      return null;
   }

}
