package org.kossowski.packon.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.WzorzecOperacji;
import org.kossowski.packon.repositories.WzorzecOperacjiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;



@Controller
@ManagedBean
@RequestScoped
public class WzorzecOperacjiAddController implements Serializable {
   
   
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L;
   
   Logger log = LoggerFactory.getLogger( this.getClass() );

   @Autowired
   protected WzorzecOperacjiRepository wzorzecOperacjiRepo;
   
   private WzorzecOperacji wzorzecOperacji;
   
   @PostConstruct
   public void init() {
      wzorzecOperacji = new WzorzecOperacji();
   }
   
   public String prepAdd() {
      return "/wzorzecOperacji/add.xhtml?faces-redirect=true";
   }
   
   public String ok() {
      
      wzorzecOperacjiRepo.save( wzorzecOperacji );
      
      return "/wzorzecOperacji/list.xhtml?faces-redirect=true";
   }
   
   public String cancel() {
      
      return "/wzorzecOperacji/list.xhtml?faces-redirect=true";
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
   public void setWzorzecOperacji(WzorzecOperacji wzorzecOperacji) {
      this.wzorzecOperacji = wzorzecOperacji;
   }
   
}
