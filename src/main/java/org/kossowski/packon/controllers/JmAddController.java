package org.kossowski.packon.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.repositories.JmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
@ManagedBean
@RequestScoped
public class JmAddController implements Serializable {
   
   
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   Logger log = LoggerFactory.getLogger( this.getClass() );

   @Autowired
   protected JmRepository jmRepo;
   
   private Jm jm;
   
   @PostConstruct
   public void init() {
      jm = new Jm();
   }
   
   public String prepAdd() {
      return "/jm/add.xhtml?faces-redirect=true";
   }
   
   public String ok() {
      
      jmRepo.save( jm );
      
      return "/jm/list.xhtml?faces-redirect=true";
   }
   
   public String cancel() {
      
      return "/jm/list.xhtml?faces-redirect=true";
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
