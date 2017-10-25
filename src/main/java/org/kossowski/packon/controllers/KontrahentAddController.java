package org.kossowski.packon.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import javax.annotation.PostConstruct;
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
import org.kossowski.packon.utils.AdresWysylkowyUtils;
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


	@PostConstruct
	public void postConstruct() {
		logger.info("postConstruct() => ustawienie adresWysylkowy");
		aw = AdresWysylkowyUtils.AdresWyslkowySadowa();
		aw.getAdresWysylkowy().setUlica("Sierakowskiego");
	}
	
	public void addAdres() {
		logger.info("addAdres() wejście");
		
		AdresWysylkowy aw = new AdresWysylkowy();
		aw.setSymbol( ulica );
		ulica = "";
		kontrahent.getAdresyWysylkowe().add( aw );
	}
	
	public void prepAddAdres() {
		logger.info( "prepAddAdres() begin");
		//aw = new AdresWysylkowy();
		logger.info("setAw");
		setAw( new AdresWysylkowy() );
		logger.info( "prepAddAdres(): " + aw );
		logger.info( "prepAddAdres() end");

		
	}
	
	public void prepEditAdres() {
		logger.info( "prepEditAdres() begin" );
		logger.info( "pepAddAdres(): " + aw );
		logger.info( "prepAddAdres() end" );
		
	}


	public void saveNewAdresWysylkowy() {
		logger.info( "saveNewAdresWysylkowy() begin" );
		//kontrahent.getAdresyWysylkowe().add( new AdresWysylkowy( aw ) );
		logger.info( "aw -> " + aw );
		logger.info( "saveNewAdresWysulkowy() end ");

	}
	
	public void addAdresWysylkowySadowa() {
		logger.info( "Dodaję Sadowa");
		kontrahent.getAdresyWysylkowe().add( new AdresWysylkowyUtils().AdresWyslkowySadowa() );
	}
	
	public void addAdresWysylkowy11Listopada() {
		logger.info( "Dodaję Sadowa");
		kontrahent.getAdresyWysylkowe().add( new AdresWysylkowyUtils().AdresWyslkowy11Listopada() );
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


		logger.info( "getWyrobyPickList(): Wejscie");
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
