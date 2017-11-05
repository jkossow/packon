package org.kossowski.packon.controllers;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.MaszynaEnum;
import org.kossowski.packon.domain.Prioryted;
import org.kossowski.packon.domain.Status;
import org.kossowski.packon.domain.Zlecenie;
import org.kossowski.packon.domain.Zmiana;
import org.kossowski.packon.repositories.ZlecenieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class ZlecenieAddController {
	
	
	protected Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	protected ZlecenieRepository zRepo;
	
	protected Zlecenie zlecenie = new Zlecenie();
	
	public ZlecenieAddController() {
		
		logger.info("ZlecenieAddController created");
		
	}
	
	public String save() {
		zRepo.save( zlecenie );
		
		//TODO: dodać info o zapisaniu
		
		return "/zlecenie/list.xhtml";
	}

	
	public MaszynaEnum[] getMaszyny() {
		return MaszynaEnum.values();
	}
	
	public Zmiana[] getZmiany() {
		return Zmiana.values();
	}
	
	public Status[] getStatusy() {
		return Status.values();
	}
	
	public Prioryted[] getPriorytety() {
		return Prioryted.values();
	}
	
	public Zlecenie getZlecenie() {
		return zlecenie;
	}

	public void setZlecenie(Zlecenie zlecenie) {
		this.zlecenie = zlecenie;
	}
	
	
	
	
}
