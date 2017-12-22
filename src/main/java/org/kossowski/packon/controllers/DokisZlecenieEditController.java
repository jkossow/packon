package org.kossowski.packon.controllers;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.Hibernate;
import org.kossowski.packon.domain.Adres;
import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.domain.Kontrahent;
import org.kossowski.packon.domain.ZamowienieMaterialu;
import org.kossowski.packon.domain.Zlecenie;
import org.kossowski.packon.factorry.ZlecenieFactory;
import org.kossowski.packon.repositories.JmRepository;
import org.kossowski.packon.repositories.KontrahentRepostory;
import org.kossowski.packon.repositories.ZamowienieMaterialuRepository;
import org.kossowski.packon.repositories.ZlecenieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;






@Controller
@ManagedBean
@ViewScoped
public class DokisZlecenieEditController implements Serializable {

   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   Logger log = LoggerFactory.getLogger(this.getClass());

   @Autowired
   protected ZlecenieRepository zlecRepo;
   
   @Autowired
   protected KontrahentRepostory kontrahRepo;

   @Autowired
   protected JmRepository jmRepo;
   
   @Autowired
   protected ZamowienieMaterialuRepository zamRepo;
   
   @Autowired
   protected SessionValues sv;
   
   protected Zlecenie zlecenie;
   protected Set<IndeksMagazynowy> productList = null;
  

   @PostConstruct
   protected void init() {

      log.info(log.getName() + "init");

      Long id = sv.getZlecenieToEdit();
      zlecenie = zlecRepo.findOne( id );
      
      
      
      log.info( log.getName() + " doksZlecenieEditController.init() zlecenie=" + zlecenie );
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
      zlecenie.setJm(  zlecenie.getProdukt().getJednMiary() );

   }

   public void adresWysylkowyChanged() {
      
      
      String key = zlecenie.getAdresWysylkowyKey();
      log.info( log.getName() + "adresWysylkowyChanged() aw="  +  key);
      if( key != null && !key.equals("")) {
         log.info( log.getName() + "adresWysylkowyChanged() ustawiam z mapy" );
           zlecenie.setAdresWysylkowy( zlecenie.getKontrahent().getAdresyWysylkowe().get( key ) );
      } else {
         log.info( log.getName() + "adresWysylkowyChanged() uswtawiam aw=new Adres()" );
           zlecenie.setAdresWysylkowy( new Adres() );
      }
   }
   
   public Set<IndeksMagazynowy> getProducts() {
      
//      if( productList == null) {
//         productList = zle
//      }
      //Hibernate.initialize( zlecenie.getKontrahent().getWyrobyGotowe() );
      
      return zlecenie.getKontrahent() != null ?  zlecenie.getKontrahent().getWyrobyGotowe() : null;
   }
   
   public Collection<String> getAdresyWysylkowe() {
   
      return zlecenie != null  && zlecenie.getKontrahent() != null ? 
            zlecenie.getKontrahent().getAdresyWysylkowe().keySet() : 
            null;
   }
   
   
   public List<Jm> getJmList() {
      return jmRepo.findAll();
   }
   
   
   
  
   
   public String  save() {
      
      
      log.info( log.getName() + " save() Saving ZLECENIE" );
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
