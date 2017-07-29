package org.kossowski.packon.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.kossowski.packon.domain.Zlecenie;
import org.kossowski.packon.repositories.ZlecenieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class ZlecenieListController {

	Logger log = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	protected ZlecenieRepository zRepo;
	
	protected List<Zlecenie> list = null;
	
	
	public ZlecenieListController() {
		log.info("ZlecenieListCpntroller()" );
	}
	
	public List<Zlecenie> getFindAll() {
		
		log.info( "Metoda getFindAll() ");
		if( list == null ) {
			log.info( "Metoda getFindAll() - odczyt z repo");
			list = zRepo.findAll();
		}
		return list;
	}


	
	
}
