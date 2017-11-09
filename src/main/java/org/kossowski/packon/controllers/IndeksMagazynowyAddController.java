package org.kossowski.packon.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.kossowski.packon.utils.JSFUtils;
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
	
	private IndeksMagazynowy indeksMag; 
	private IndeksMagazynowy selectedMaterial;
	
	@PostConstruct
	public void init() {
	   log.info( log.getName() + " IndeksMagazynowyAddController init()");
	   indeksMag = new IndeksMagazynowy();
	   selectedMaterial = null;
	}
	
	
	public void wyrobCheckBoxChanged() {
	   log.info( log.getName() + "checkBox chcnged wyrobGotowy = " + indeksMag.getWyrobGotowy() );
	}
	
	public void materialSelectOneMenuChanged() {
	   log.info( log.getName() + " selectedMaterial = " + selectedMaterial );
	}
	
	public void addSelectedMaterialToMaterials() {
	   log.info( log.getName() + " addSelectedMaterialToMaterials = " + selectedMaterial );
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
	
	
	public List<IndeksMagazynowy> getMaterials() {
	   return indeksRepo.findByMaterialTrue();
	}
	
	public String save() {
		try {
			indeksRepo.save(indeksMag);
		} catch ( DataIntegrityViolationException e) {
			 System.out.println( "Wyjątek: " + e.getMessage() );
		}
		return "/faces/indeksMagazynowy/list.xhtml";
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
	
	
	  
	
	
	
}
