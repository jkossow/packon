package org.kossowski.packon.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.kossowski.packon.domain.Role;
import org.kossowski.packon.domain.User;
import org.kossowski.packon.repositories.UserRepository;
import org.primefaces.model.DualListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;




@Controller
@ManagedBean
@RequestScoped
public class UserAddController {

	protected Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	protected UserRepository uRepo;
		
	protected User user = new User();
	
	protected DualListModel<Role> rolesPickList = new DualListModel<>();
	
	public String prepAdd() {
		//user = new User();
		return "/user/add.xhtml";
	}

	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public DualListModel<Role> getRolesPickList() {
		
		ArrayList<Role> source = new ArrayList<>();
		source.addAll( Role.initRoles() );
		rolesPickList.setSource( source );
		
		ArrayList<Role> target = new ArrayList<>();
		source.addAll( user.getRoles());
		rolesPickList.setTarget( target );
		
		return rolesPickList;
	}



	public void setRolesPickList(DualListModel<Role> rolesPickList) {
		logger.info( "setRolesPickList" );
		logger.info( "Source size " +  rolesPickList.getSource().size() );
		logger.info( "Target size " +  rolesPickList.getTarget().size() );
		this.rolesPickList = rolesPickList;
		logger.info( "Koniec metody");
	}
	
	public String save() {
		
		logger.info( "Source size " +  rolesPickList.getSource().size() );
		logger.info( "Target size " +  rolesPickList.getTarget().size() );
		
		Set<Role> set = new HashSet<>();
		set.addAll( rolesPickList.getTarget());
		user.setRoles(set);
		uRepo.save( user );
		return "/user/list.xhtml";
	}
	
	
	
	
}
