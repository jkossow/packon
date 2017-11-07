package org.kossowski.packon.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.domain.User;
import org.kossowski.packon.repositories.JmRepository;
import org.kossowski.packon.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class JmListController {

	Logger log = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	protected JmRepository jmRepo;
	
	public List<Jm> getFindAll() {
		return jmRepo.findAll();
	}
	
	

}
