package org.kossowski.packon.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.Maszyna;
import org.kossowski.packon.repositories.MaszynaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class MaszynaListController {

	Logger log = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	protected MaszynaRepository maszynaRepo;
	
	public List<Maszyna> getFindAll() {
		return maszynaRepo.findAll();
	}
	
	

}
