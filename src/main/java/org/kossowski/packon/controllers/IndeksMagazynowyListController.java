package org.kossowski.packon.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@ViewScoped
public class IndeksMagazynowyListController {

	
	@Autowired
	protected IndeksMagazynowyRepository indeksRepo;
	
	
	
	public List<IndeksMagazynowy> getFindAll() {
		return indeksRepo.findAll();
	}
	
}
