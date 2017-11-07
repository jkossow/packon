package org.kossowski.packon.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@ManagedBean
@SessionScoped
public class SessionValues implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   Logger log = LoggerFactory.getLogger( this.getClass() );
   
   
   private Long kontrahIdToEdit = null;

   
   @PostConstruct
   public void init() {
      log.info( log.getName() + " session bean created ");
   }
   
   
   /**
    * @return the kontrahIdToEdit
    */
   public Long getKontrahIdToEdit() {
      return kontrahIdToEdit;
   }

   /**
    * @param kontrahIdToEdit the kontrahIdToEdit to set
    */
   public void setKontrahIdToEdit(Long kontrahIdToEdit) {
      this.kontrahIdToEdit = kontrahIdToEdit;
   }

   /**
    * @return the serialversionuid
    */
   public static long getSerialversionuid() {
      return serialVersionUID;
   }
   
   
   
   

   
   
   
}
