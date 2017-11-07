package org.kossowski.packon.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.kossowski.packon.domain.Kontrahent;
import org.kossowski.packon.repositories.KontrahentRepostory;
import org.kossowski.packon.utils.JSFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@ManagedBean
@RequestScoped
public class KontrahentListController {


	Logger log = LoggerFactory.getLogger( this.getClass() );

	@Autowired
	protected SessionValues sv;
	
	@Autowired
	protected KontrahentRepostory kontrahentRepo;
	
	
	public List<Kontrahent> getFindAll() {
		return kontrahentRepo.findAll();
	}
	
	public String prepEdit() {
	  Long id = Long.valueOf( JSFUtils.getRequestParam("id" ));
	  
	  sv.setKontrahIdToEdit( id );
	  
	  log.info( "kontrahentListController -> prepEdit() -> id " + id );
	  
	  return "/kontrahent/edit.xhtml?faces-redirect=true"; 
	}
	
}
