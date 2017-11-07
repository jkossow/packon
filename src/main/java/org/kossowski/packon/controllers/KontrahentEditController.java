package org.kossowski.packon.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import org.kossowski.packon.domain.Adres;
import org.kossowski.packon.domain.IndeksMagazynowy;
import org.kossowski.packon.domain.Kontrahent;
import org.kossowski.packon.repositories.IndeksMagazynowyRepository;
import org.kossowski.packon.repositories.KontrahentRepostory;
import org.kossowski.packon.utils.AdresUtils;
import org.primefaces.model.DualListModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
//@RequestScoped
@ViewScoped
public class KontrahentEditController implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;


	protected Logger logger = LoggerFactory.getLogger( this.getClass() );
	
	@Autowired
	private SessionValues sv;
	
	@Autowired
	private KontrahentRepostory kontrahentRepo;
	
	@Autowired
	private IndeksMagazynowyRepository indeksRepo;

	protected Kontrahent kontrahent = null;
	
	protected Adres adresWysylkowy;
	protected String adresWysylkowySymbol; 
	
	
	
	
	protected DualListModel<IndeksMagazynowy> wyrobyPickList;


	@PostConstruct
	public void postConstruct() {
	   
	   logger.info("postConstruct() => wejscie");
	   
	   Long id = sv.getKontrahIdToEdit();
	   logger.info( logger.getName() + " id= " + id);
	   
	   kontrahent = kontrahentRepo.findOne( id );
	   
	   logger.info( "Kontrahent -> " + kontrahent);
	   
	   adresWysylkowy = new Adres();
	   adresWysylkowySymbol = "";
	   
	   wyrobyPickList = new DualListModel<>( indeksRepo.findAll(), new ArrayList<IndeksMagazynowy>( kontrahent.getWyrobyGotowe()) );
	   
		logger.info("postConstruct() => wyjscie");
	}
	
	
	
	public void addAdresWysylkowy() {
	   
		logger.info("addAdresWysylkowy() wejście");
		kontrahent.getAdresyWysylkowe().put( adresWysylkowySymbol, new Adres( adresWysylkowy ));
		logger.info("addAdresWysylkowy() wyjście");
	}
	
	public void prepAddAdres() {
		logger.info( "prepAddAdres() begin");
		//aw = new AdresWysylkowy();
		logger.info("setAw");
		setAdresWysylkowy( new Adres() );
		setAdresWysylkowySymbol("");
		logger.info( "prepAddAdres(): " + adresWysylkowySymbol );
		logger.info( "prepAddAdres(): " + adresWysylkowy );
		logger.info( "prepAddAdres() end");

		
	}
	
	public void prepEditAdres() {
		logger.info( "prepEditAdres() begin" );
		logger.info( "pepAddAdres(): " + adresWysylkowySymbol );
		logger.info( "prepEditAdres(): " + adresWysylkowy );
		logger.info( "prepAddAdres() end" );
		
	}


	
	
	public void addAdresWysylkowySadowa() {
		logger.info( "Dodaję Sadowa");
		kontrahent.getAdresyWysylkowe().put( "Sadowa", AdresUtils.AdresWyslkowySadowa() );
	}
	
	public void addAdresWysylkowy11Listopada() {
		logger.info( "Dodaję 11 Listopada");
		kontrahent.getAdresyWysylkowe().put( "11-go Listopada", AdresUtils.AdresWyslkowy11Listopada() );
	}
	
	
	
	
	public List<Entry<String,Adres>> getEntrySet() {
	   logger.info("kontrahentEditController.getEntrySet() -> wejscie" );
	   
	   Set<Entry<String,Adres>> entrySet = kontrahent.getAdresyWysylkowe().entrySet();
	   logger.info( "entrySet -> " + entrySet);
	 
	   List<Entry<String,Adres>> list = new ArrayList<>( entrySet );
	   logger.info("list -> " + list );
	   
	   logger.info("kontrahentEditController.getEntrySet() -> wyjscie" );
	   
	   return list;
	}
	
	public void save() {
	   logger.info( "save ->" + kontrahent.toString() );
	   logger.info( "Source size " +  wyrobyPickList.getSource().size() );
      logger.info( "Target size " +  wyrobyPickList.getTarget().size() );
      
      kontrahent.getWyrobyGotowe().addAll( wyrobyPickList.getTarget() );
      
      logger.info( "Wyroby gotowe (pickList target: ");
      for( IndeksMagazynowy im: wyrobyPickList.getTarget() ) {
         logger.info( "index -> " + im );
         kontrahent.getWyrobyGotowe().add( im );
      }
      kontrahentRepo.save( kontrahent );
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
		//wyrobyPickList.setSource( indeksRepo.findAll() );
		
		//List<IndeksMagazynowy> target = new ArrayList<>();
		//target.addAll( kontrahent.getWyrobyGotowe() );
		//wyrobyPickList.setTarget(  target );
		
		return wyrobyPickList;
	}

	/**
	 * @param wyrobyPickList the wyrobyPickList to set
	 */
	public void setWyrobyPickList(DualListModel<IndeksMagazynowy> wyrobyPickList) {
		this.wyrobyPickList = wyrobyPickList;
	}

   /**
    * @return the adresWysylkowy
    */
   public Adres getAdresWysylkowy() {
      return adresWysylkowy;
   }

   /**
    * @param adresWysylkowy the adresWysylkowy to set
    */
   public void setAdresWysylkowy(Adres adresWysylkowy) {
      this.adresWysylkowy = adresWysylkowy;
   }

   /**
    * @return the adresWysylkowySymbol
    */
   public String getAdresWysylkowySymbol() {
      return adresWysylkowySymbol;
   }

   /**
    * @param adresWysylkowySymbol the adresWysylkowySymbol to set
    */
   public void setAdresWysylkowySymbol(String adresWysylkowySymbol) {
      this.adresWysylkowySymbol = adresWysylkowySymbol;
   }

	
	

	
		
	
}
