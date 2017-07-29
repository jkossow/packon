package org.kossowski.packon.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table( name = "users" )
public class User {
	
	@Id
	private String login;
	
	@Column( name = "uuid")
	UUID uuid = UUID.randomUUID(); 
	
	
	private String nazwisko;
	private String imie;
	
	@ElementCollection
    @CollectionTable( name = "roles",  joinColumns = {@JoinColumn(name="login")})
	private Set<Role> roles = new HashSet<>(); 
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	public String getImie() {
		return imie;
	}
	
	public void setImie(String imie) {
		this.imie = imie;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
	
}
