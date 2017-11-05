package org.kossowski.packon.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.MaszynaEnum;
import org.kossowski.packon.domain.Prioryted;
import org.kossowski.packon.domain.Status;
import org.kossowski.packon.domain.Zlecenie;
import org.kossowski.packon.domain.Zmiana;
import org.kossowski.packon.repositories.ZlecenieRepository;
import org.kossowski.packon.utils.JSFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class ZlecenieEditController {

	Logger log = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	protected ZlecenieRepository zRepo = null;
	
	protected Zlecenie zlecenie = new Zlecenie(); 

	public String prepEdit() {		
		String s = JSFUtils.getRequestParam("id");
		Long id = new Long( s );
		zlecenie = zRepo.findOne( id );
		return "/zlecenie/edit.xhtml";
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
