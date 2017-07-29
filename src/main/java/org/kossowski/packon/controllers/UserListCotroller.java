package org.kossowski.packon.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.User;
import org.kossowski.packon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class UserListCotroller {
	
	
	@Autowired
	protected UserRepository userRepo;
	
	public List<User> getFindAll() {
		return userRepo.findAll();
	}
	
	

}
