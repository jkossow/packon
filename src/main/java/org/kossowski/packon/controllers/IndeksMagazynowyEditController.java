package org.kossowski.packon.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.domain.WzorzecOperacji;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.kossowski.packon.repositories.JmRepository;
import org.kossowski.packon.repositories.WzorzecOperacjiRepository;
import org.kossowski.packon.utils.JSFUtils;
import org.primefaces.event.ReorderEvent;
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
public class IndeksMagazynowyEditController {

	Logger log = LoggerFactory.getLogger( this.getClass() );

	@Autowired
	protected IndeksMagazynowyRepository indeksRepo;
	
	@Autowired
	protected JmRepository jmRepo;
	
	@Autowired
	protected WzorzecOperacjiRepository wzorzecRepo;

	@Autowired
	protected SessionValues sv;
	
	private IndeksMagazynowy indeksMag; 
	private IndeksMagazynowy selectedMaterial;
	private WzorzecOperacji selectedWzorzecOperacji; 
	//private OrderList primeOrderList;
	//private WzorzecOperacji orderListSelected;
	
	
   @PostConstruct
	public void init() {
	   log.info( log.getName() + "  init()");
	   
	   indeksMag = indeksRepo.findOne( sv.getIndeksMagazynowyToEdit() );
	   
	   selectedMaterial = null;
	   selectedWzorzecOperacji = null;
	   //orderListSelected = null;
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
	   //
	   //if( selectedMaterial != null )
	   //   indeksMag.getMaterials().add( selectedMaterial );
	}
	
	public void dellMaterialFromMaterials() {
	   log.info( log.getName() + " delMaterialFromMaterials");
	   Long id = Long.valueOf( JSFUtils.getRequestParam("id") );

	   //
	   //for( IndeksMagazynowy im : indeksMag.getMaterials() )
	   //   if( im.getId() == id) {
	   //         indeksMag.getMaterials().remove( im );
	   //         break;
	   //   };
	}
	
	public void orderListReorder( ReorderEvent e ) {
	   
	   //log.info( log.getName() + " Reorder event from: {}  to :{} " , new Object[] {
	   //   e.getFromIndex(), e.getToIndex()
	   //});
	   log.info( log.getName() + " Test {} {} ", new Object[] {2,3} );
	   log.info( log.getName() + " Reorder event " );
	   
	}
	
	public void orderListValueChange() {
	   log.info( log.getName() + "orderList value change");
	}
	
	public void orderListOnSelect( SelectEvent e) {
	   log.info( log.getName() + "orderListOnSelect() + " + e.getObject().toString() );
	   //orderListSelected = (WzorzecOperacji)e.getObject();
	}
	
	public void orderListOnUnselect( UnselectEvent e) {
      log.info( log.getName() + "orderListOnUnselect() + " + e.getObject().toString() );
      //orderListSelected = null;
   }
	
	public void addSelectedWzorzecToWzorce() {

      //
      //if( selectedWzorzecOperacji != null ) {
      //      indeksMag.getTechnologia().add( selectedWzorzecOperacji );
      //      selectedWzorzecOperacji = null;
      //}
	   
   }
	
	public void delAllFromWzorce() {

       //
       //indeksMag.getTechnologia().clear();
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
