package org.kossowski.packon.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.kossowski.packon.repositories.JmRepository;
import org.kossowski.packon.utils.JSFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class IndeksMagazynowyEditController2 {

   Logger log = LoggerFactory.getLogger( this.getClass() );
   
   @Autowired
   protected IndeksMagazynowyRepository indeksMagRepo;
   
   @Autowired 
   protected JmRepository jmRepo;
   
   protected IndeksMagazynowy indeksMag = new IndeksMagazynowy();
   
   
   public String prepEdit() {
      
      Long id = Long.valueOf( JSFUtils.getRequestParam("id") );
      log.info( log.getName() + "id=" + id);
     
      indeksMag = indeksMagRepo.findOne( id );
      log.info( log.getName() + " indeksMagazynowy = " + indeksMag );
      
      return "/indeksMagazynowy/edit.xhtml";
   }
   
   public List<Jm> getJednMiary() {
      return jmRepo.findAll();
   }
   
   public String save() {
      
      indeksMagRepo.save( indeksMag );
      return "/indeksMagazynowy/list.xhtml";
   }

   /**
    * @return the indeksMag
    */
   public IndeksMagazynowy getIndeksMag() {
      return indeksMag;
   }

   /**
    * @param indeksMag the indeksMag to set
    */
   public void setIndeksMag(IndeksMagazynowy indeksMag) {
      this.indeksMag = indeksMag;
   }
   
   
   
   
}
