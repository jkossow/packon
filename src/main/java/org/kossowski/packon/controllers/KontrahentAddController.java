package org.kossowski.packon.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.kossowski.packon.domain.Adres;
import org.kossowski.packon.domain.AdresWysylkowy;
import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.domain.Kontrahent;
import org.kossowski.packon.domain.Role;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.kossowski.packon.repositories.KontrahentRepostory;
import org.primefaces.model.DualListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
//@RequestScoped
@ViewScoped
public class KontrahentAddController implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;


	protected Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	
	@Autowired
	private KontrahentRepostory kontrahentRepo;
	
	@Autowired
	private IndeksMagazynowyRepository indeksRepo;

	
	protected Kontrahent kontrahent = new Kontrahent();
	
	protected AdresWysylkowy aw = null;
	
	protected String ulica;
	
	
	protected DualListModel<IndeksMagazynowy> wyrobyPickList = new DualListModel<>();

	
	
	public void addAdres( ActionEvent event) {
		System.out.println("hello kontr=" + kontrahent + "  ul:" + ulica);
		
		AdresWysylkowy aw = new AdresWysylkowy();
		aw.setSymbol( ulica );
		ulica = "";
		kontrahent.getAdresyWysylkowe().add( aw );
	}
	
	public void prepAddAdres( ActionEvent event) {
		System.out.println("prepAddAdres");
		aw = new AdresWysylkowy();
		
	}
	
	public void prepEditAdres( ActionEvent event) {
		System.out.println("prepEditAdres");
		aw = new AdresWysylkowy();
		aw.setSymbol("edit");
		aw.getAdresWysylkowy().setKodPocztowy("ee-500");
		
	}
	
	
	/**
	 * @return the kontrahent
	 */
	public Kontrahent getKontrahent() {
		return kontrahent;
	}

	/**
	 * @param kontrahent the kontrahent to set
	 */
	public void setKontrahent(Kontrahent kontrahent) {
		this.kontrahent = kontrahent;
	}

	/**
	 * @return the wyrobyPickList
	 */
	public DualListModel<IndeksMagazynowy> getWyrobyPickList() {
		
		System.out.println("Kontroller getWyrobyPickList() - wejście");
		wyrobyPickList.setSource( indeksRepo.findAll() );
		
		ArrayList<IndeksMagazynowy> target = new ArrayList<>();
		target.addAll( kontrahent.getWyrobyGotowe() );
		wyrobyPickList.setTarget(  target );
		
		return wyrobyPickList;
	}

	/**
	 * @param wyrobyPickList the wyrobyPickList to set
	 */
	public void setWyrobyPickList(DualListModel<IndeksMagazynowy> wyrobyPickList) {
		this.wyrobyPickList = wyrobyPickList;
	}


	/**
	 * @return the ulica
	 */
	public String getUlica() {
		return ulica;
	}


	/**
	 * @param ulica the ulica to set
	 */
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	/**
	 * @return the aw
	 */
	public AdresWysylkowy getAw() {
		return aw;
	}

	/**
	 * @param aw the aw to set
	 */
	public void setAw(AdresWysylkowy aw) {
		this.aw = aw;
	}


	
		
	
}
