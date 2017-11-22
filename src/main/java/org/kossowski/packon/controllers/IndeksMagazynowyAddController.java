package org.kossowski.packon.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.domain.WzorzecOperacji;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.kossowski.packon.repositories.JmRepository;
import org.kossowski.packon.repositories.WzorzecOperacjiRepository;
import org.kossowski.packon.utils.JSFUtils;
import org.primefaces.component.orderlist.OrderList;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

@Controller
@ViewScoped
@ManagedBean
public class IndeksMagazynowyAddController {

	Logger log = LoggerFactory.getLogger( this.getClass() );

	@Autowired
	protected IndeksMagazynowyRepository indeksRepo;
	
	@Autowired
	protected JmRepository jmRepo;
	
	@Autowired
	protected WzorzecOperacjiRepository wzorzecRepo;

	
	private IndeksMagazynowy indeksMag; 
	private IndeksMagazynowy selectedMaterial;
	private WzorzecOperacji selectedWzorzecOperacji; 
	//private OrderList primeOrderList;
	private WzorzecOperacji orderListSelected;
	
	
   @PostConstruct
	public void init() {
	   log.info( log.getName() + "  init()");
	   indeksMag = new IndeksMagazynowy();
	   selectedMaterial = null;
	   selectedWzorzecOperacji = null;
	   orderListSelected = null;
	}
	
	
	public void wyrobCheckBoxChanged() {
	   log.info( log.getName() + "checkBox changed wyrobGotowy = " + indeksMag.getWyrobGotowy() );
	}
	
	public void materialSelectOneMenuChanged() {
	   log.info( log.getName() + " selectedMaterial = " + selectedMaterial );
	}
	
	public void addSelectedMaterialToMaterials() {
	   log.info( log.getName() + " addSelectedMaterialToMaterials = " + selectedMaterial );
	   log.debug("debug message (jk)");
	   if( selectedMaterial != null )
	      indeksMag.getMaterials().add( selectedMaterial );
	}
	
	public void dellMaterialFromMaterials() {
	   log.info( log.getName() + " delMaterialFromMaterials");
	   Long id = Long.valueOf( JSFUtils.getRequestParam("id") );
	   
	   for( IndeksMagazynowy im : indeksMag.getMaterials() ) 
	      if( im.getId() == id) {
	            indeksMag.getMaterials().remove( im );
	            break;
	      };
	}
	
	public void orderListReorder() {
	   
	   //Object o = primeOrderList.getValue();
	   //
	   //List<WzorzecOperacji> l = null;
	   //if(  o instanceof List ) {
	   //  l = (List<WzorzecOperacji>)o;
	   //  indeksMag.setTechnologia( l );
	   //}
	   //log.info( log.getName() + "orderListReorder() l = " + l);
	   //log.info( log.getName() + "orderListReorder() getLocalValue() = " + primeOrderList.getLocalValue());
	   
	}
	
	public void orderListValueChange() {
	   log.info( log.getName() + "orderList value change");
	}
	
	public void orderListOnSelect( SelectEvent e) {
	   log.info( log.getName() + "orderListOnSelect() + " + e.getObject().toString() );
	   orderListSelected = (WzorzecOperacji)e.getObject();
	}
	
	public void orderListOnUnselect( UnselectEvent e) {
      log.info( log.getName() + "orderListOnUnselect() + " + e.getObject().toString() );
      orderListSelected = null;
   }
	
	public void addSelectedWzorzecToWzorce() {
      //log.info( log.getName() + " addSelectedWzorzecToWzorce selectedWzorzecOperacji = " + selectedWzorzecOperacji );
      ////log.info( log.getName() + " addSelectedWzorzecToWzorce primeOrderList.getValue() = " + primeOrderList.getValue() );
      ////log.info( log.getName() + " addSelectedWzorzecToWzorce primeOrderList.getLocalValue() = " + primeOrderList.getLocalValue() );
      //log.debug("debug message (jk)");
      //if( selectedWzorzecOperacji != null ) {
      //   indeksMag.getTechnologia().add( selectedWzorzecOperacji );
      //   selectedWzorzecOperacji = null;
      // }   
	   
      if( selectedWzorzecOperacji != null ) {
            indeksMag.getTechnologia().add( selectedWzorzecOperacji );
            selectedWzorzecOperacji = null;
      }
	   
   }
	
	
	public void delSelectedWzorzecFromWzorce() {
	   if( selectedWzorzecOperacji != null ) {
	      indeksMag.getTechnologia().remove( selectedWzorzecOperacji );
	      selectedWzorzecOperacji = null;
	   }
	}
	
	public void wzorzecOperacjiSelectOneMenuChanged() {
      log.info( log.getName() + " wzorzecOperacji = " + selectedWzorzecOperacji );
   }
	
	
	public List<IndeksMagazynowy> getMaterials() {
	   return indeksRepo.findByMaterialTrue();
	}
	
	
	public List<Jm> getJednMiary() {
	   return jmRepo.findAll();
	}
	
	public List<WzorzecOperacji> getWzorceOperacji() {
	   return wzorzecRepo.findAll();
	}
	
	
	public String save() {
		try {
			indeksRepo.save(indeksMag);
		} catch ( DataIntegrityViolationException e) {
			 System.out.println( "Wyjątek: " + e.getMessage() );
		}
		return "/indeksMagazynowy/list.xhtml";
	}
	
	public IndeksMagazynowyRepository getIndeksRepo() {
		return indeksRepo;
	}

	public void setIndeksRepo(IndeksMagazynowyRepository indeksRepo) {
		this.indeksRepo = indeksRepo;
	}

	public IndeksMagazynowy getIndeksMag() {
		return indeksMag;
	}

	public void setIndeksMag(IndeksMagazynowy indeksMag) {
		this.indeksMag = indeksMag;
	}


   /**
    * @return the selectedMaterial
    */
   public IndeksMagazynowy getSelectedMaterial() {
      return selectedMaterial;
   }


   /**
    * @param selectedMaterial the selectedMaterial to set
    */
   public void setSelectedMaterial(IndeksMagazynowy selectedMaterial) {
      this.selectedMaterial = selectedMaterial;
   }


  


   /**
    * @return the orderListSelected
    */
   public WzorzecOperacji getOrderListSelected() {
      return orderListSelected;
   }


   /**
    * @param orderListSelected the orderListSelected to set
    */
   public void setOrderListSelected(WzorzecOperacji orderListSelected) {
      this.orderListSelected = orderListSelected;
   }


   /**
    * @return the selectedWzorzecOperacji
    */
   public WzorzecOperacji getSelectedWzorzecOperacji() {
      return selectedWzorzecOperacji;
   }


   /**
    * @param selectedWzorzecOperacji the selectedWzorzecOperacji to set
    */
   public void setSelectedWzorzecOperacji(WzorzecOperacji selectedWzorzecOperacji) {
      log.info( log.getName() + " setSelectedWzorzecOperacji() new value = " + selectedWzorzecOperacji );
      this.selectedWzorzecOperacji = selectedWzorzecOperacji;
   }
	
	
	  
	
	
	
}
