package org.kossowski.packon.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "jedn_miary")
public class Jm {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column( name = "uuid")
	UUID uuid = UUID.randomUUID(); 
	
	private String symbol;
	private String nazwa;
	
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getSymbol() {
		return symbol;
	}
	
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	
	public String getNazwa() {
		return nazwa;
	}
	
	
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	
	
}
