package org.kossowski.packon.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.WzorzecOperacji;
import org.kossowski.packon.repositories.WzorzecOperacjiRepository;
import org.kossowski.packon.utils.JSFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class WzorzecOperacjiEditController implements Serializable {
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   Logger log = LoggerFactory.getLogger( this.getClass() );
   
   @Autowired
   protected WzorzecOperacjiRepository wzorzecOperacjiRepo ;
   
   private WzorzecOperacji wzorzecOperacji;
   
   @PostConstruct
   public void init() {
      log.info( log.getName() + " postContruct()" );
      wzorzecOperacji = new WzorzecOperacji();
      
   }
   
   public String prepEdit() {
      
      Long id = Long.valueOf( JSFUtils.getRequestParam("id") );
      
      wzorzecOperacji = wzorzecOperacjiRepo.findOne( id );
      log.info( log.getName() + "prepEdit() wzorzecOperacji= " + wzorzecOperacji );
      
      return "/wzorzecOperacji/edit.xhtml";
   }
   
   public String ok() {
      
      wzorzecOperacjiRepo.save( wzorzecOperacji );
      return "/wzorzecOperacji/list.xhtml";
   }
   
   public String cancel() {
      return "/wzorzecOperacji/list.xhtml";
   }

   /**
    * @return the wzorzecOperacji
    */
   public WzorzecOperacji getWzorzecOperacji() {
      return wzorzecOperacji;
   }

   /**
    * @param wzorzecOperacji the wzorzecOperacji to set
    */
   public void setMaszyna(WzorzecOperacji wzorzecOperacji) {
      this.wzorzecOperacji = wzorzecOperacji;
   }
   
   
}
