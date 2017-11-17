package org.kossowski.packon.controllers;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.domain.Kontrahent;
import org.kossowski.packon.domain.Zlecenie;
import org.kossowski.packon.factorry.ZlecenieFactory;
import org.kossowski.packon.repositories.KontrahentRepostory;
import org.kossowski.packon.repositories.ZlecenieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@ViewScoped
public class DokisZlecenieAddController implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   Logger log = LoggerFactory.getLogger(this.getClass());

   @Autowired
   protected ZlecenieRepository zlecRepo;
   
   @Autowired
   protected KontrahentRepostory kontrahRepo;

   protected Zlecenie zlecenie;

   @PostConstruct
   protected void init() {

      log.info(log.getName() + "init");

      zlecenie = ZlecenieFactory.newInstance();
   }

   public List<Kontrahent> getKontrahentList() {
      return kontrahRepo.findByOdbiorcaTrue();
   }

   

   public void kontrahentSelectOneMenuChanged() {

      log.info(log.getName() + " kontrahentSelectMenuChanged k=" + zlecenie.getKontrahent());
      zlecenie.setProdukt(null);

   }

   public void productSelectOneMenuChanged() {

      log.info(log.getName() + " productSelectMenuChanged k=" + zlecenie.getProdukt());

   }

   public void adresWysylkowyOneMenyChanged() {
      
   }
   
   public Collection<String> getAdresyWysylkowe() {
   
      return zlecenie != null  && zlecenie.getKontrahent() != null ? 
            zlecenie.getKontrahent().getAdresyWysylkowe().keySet() : 
            null;
   }
   
   
   public String  save() {
      
      log.info( log.getName() + " save() zlecenie = " + zlecenie );
      
      zlecRepo.save( zlecenie );
      return "/dokis/list.xhtml";
      
   }
   
   /**
    * @return the zlecenie
    */
   public Zlecenie getZlecenie() {
      return zlecenie;
   }

   /**
    * @param zlecenie
    *           the zlecenie to set
    */
   public void setZlecenie(Zlecenie zlecenie) {
      this.zlecenie = zlecenie;
   }

}
