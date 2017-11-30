package org.kossowski.packon.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.repositories.JmRepository;
import org.kossowski.packon.utils.JSFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class JmDelController {

   Logger log = LoggerFactory.getLogger( this.getClass() );
   
   @Autowired
   protected JmRepository jmRepo;
   
   public void delete( Jm jm) {
      
      log.info( log.getName() + " jmDelController.delete jm=" + jm) ;
      
      try {
         jmRepo.delete(jm);
      } catch ( DataIntegrityViolationException e) {
         log.info( log.getName() + "Wyjatek JdbcSQLException + " + e.getMessage() );
         JSFUtils.addMessage( "Nie można skasować (zależności)");
      }
      
      
   }
   
   
}
