package org.kossowski.packon.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.Maszyna;
import org.kossowski.packon.repositories.MaszynaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
@ManagedBean
@RequestScoped
public class MaszynaAddController implements Serializable {
   
   
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   Logger log = LoggerFactory.getLogger( this.getClass() );

   @Autowired
   protected MaszynaRepository maszynaRepo;
   
   private Maszyna maszyna;
   
   @PostConstruct
   public void init() {
      maszyna = new Maszyna();
   }
   
   public String prepAdd() {
      return "/maszyna/add.xhtml?faces-redirect=true";
   }
   
   public String ok() {
      
      maszynaRepo.save( maszyna );
      
      return "/maszyna/list.xhtml?faces-redirect=true";
   }
   
   public String cancel() {
      
      return "/maszyna/list.xhtml?faces-redirect=true";
   }

   /**
    * @return the maszyna
    */
   public Maszyna getMaszyna() {
      return maszyna;
   }

   /**
    * @param maszyna the maszyna to set
    */
   public void setMaszyna(Maszyna maszyna) {
      this.maszyna = maszyna;
   }
   
}
