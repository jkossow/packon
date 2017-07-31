package org.kossowski.packon.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
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
	
	
	
	public List<IndeksMagazynowy> getFindAll() {
		return indeksRepo.findAll();
	}
	
}
