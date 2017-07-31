package org.kossowski.packon.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

@Controller
@RequestScoped
@ManagedBean
public class IndeksMagazynowyAddController {

	Logger log = LoggerFactory.getLogger( this.getClass() );

	@Autowired
	protected IndeksMagazynowyRepository indeksRepo;
	
	private IndeksMagazynowy  indeksMag = new IndeksMagazynowy();

	
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
	
	
	  
	
	
	
}
