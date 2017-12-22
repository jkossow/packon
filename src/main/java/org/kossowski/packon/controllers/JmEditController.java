package org.kossowski.packon.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.repositories.JmRepository;
import org.kossowski.packon.utils.JSFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
@ManagedBean
@RequestScoped
public class JmEditController implements Serializable {
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   Logger log = LoggerFactory.getLogger( this.getClass() );
   
   @Autowired
   protected JmRepository jmRepo ;
   
   private Jm jm;
   
   @PostConstruct
   public void init() {
      log.info( log.getName() + " postContruct()" );
      jm = new Jm();
      
   }
   
   public String prepEdit() {
      
      Long id = Long.valueOf( JSFUtils.getRequestParam("id") );
      
      jm = jmRepo.findOne( id );
      log.info( log.getName() + "prepEdit() jm= {}", jm );
      
      return "/jm/edit.xhtml";
   }
   
   
   public void testGrowl() {
      
      log.info( log.getName() + "testGrowl()");
      JSFUtils.addMessage("test growl");
   }
   //@Transactional
   public String ok() {
      
      log.info( log.getName() + " przed save() jm= {}", jm );
      try {
         jmRepo.save( jm );
      } catch (ObjectOptimisticLockingFailureException e) {
        JSFUtils.addMessage("Optimistic locking exception");
        return "";
      } catch( Exception e) {
         JSFUtils.addMessage( e.getMessage() + "już istnieje");
         return"";
      } 
      log.info( log.getName() + " po    save() jm= {}", jm );
      
      return "/jm/list.xhtml";
   }
   
   public String cancel() {
      return "/jm/list.xhtml";
   }

   /**
    * @return the jm
    */
   public Jm getJm() {
      return jm;
   }

   /**
    * @param jm the jm to set
    */
   public void setJm(Jm jm) {
      this.jm = jm;
   }
   
   
}
