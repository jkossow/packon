package org.kossowski.packon.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.kossowski.packon.utils.JSFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@ViewScoped
public class IndeksMagazynowyListController {


	Logger log = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	protected IndeksMagazynowyRepository indeksRepo;
	
	@Autowired
	protected SessionValues sv;
	
	public List<IndeksMagazynowy> getFindAll() {
		return indeksRepo.findAll();
	}
	
	
	public String prepEdit() {
	     Long id = Long.valueOf( JSFUtils.getRequestParam("id" ));
	     
	     sv.setIndeksMagazynowyToEdit( id );
	     
	     log.info( "indeksMagazynowyListController -> prepEdit() -> id " + id );
	     
	     return "/indeksMagazynowy/edit.xhtml?faces-redirect=true"; 
	   }
	
}
