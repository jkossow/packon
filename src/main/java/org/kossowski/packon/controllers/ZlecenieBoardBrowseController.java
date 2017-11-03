package org.kossowski.packon.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.Zlecenie;
import org.kossowski.packon.repositories.ZlecenieRepository;
import org.kossowski.packon.schedule.ZlecenieScheduleObject;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class ZlecenieBoardBrowseController {

	Logger log = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	protected ZlecenieRepository zRepo;
	
	protected DefaultScheduleModel sm;
	
	@PostConstruct 
	public void init() {
		
		List<Zlecenie> zl = zRepo.findAll();
		
		sm = new DefaultScheduleModel();
		
		Date d = new Date();
		sm.addEvent( new DefaultScheduleEvent("ddd", d,  d) );
		sm.addEvent( new DefaultScheduleEvent("ddd", d,  d ));
		for( Zlecenie z : zl) {
			sm.addEvent( new ZlecenieScheduleObject( z) );
		}
	}

	public DefaultScheduleModel getSm() {
		log.info( "Metoda getSm()");
		return sm;
	}

	public void setSm(DefaultScheduleModel sm) {
		this.sm = sm;
	}
	
	
	
}
