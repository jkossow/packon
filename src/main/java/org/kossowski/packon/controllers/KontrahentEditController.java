package org.kossowski.packon.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
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


	protected Logger log = LoggerFactory.getLogger( this.getClass() );
	
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
	   
	   log.info("postConstruct() => wejscie");
	   
	   Long id = sv.getKontrahIdToEdit();
	   log.info( log.getName() + " id= " + id);
	   
	   kontrahent = kontrahentRepo.findOne( id );
	   
	   log.info( "Kontrahent -> " + kontrahent);
	   
	   adresWysylkowy = new Adres();
	   adresWysylkowySymbol = "";
	   
	   List<IndeksMagazynowy> source = indeksRepo.findByWyrobGotowyTrue();
	   List<IndeksMagazynowy> target = new ArrayList<>( kontrahent.getWyrobyGotowe() );
	   //usuniecie wyrobow juz przpisanych do kontrahenta
	   source.removeAll( target );
	   
	   wyrobyPickList = new DualListModel<>( source, target ); 
	   
		log.info("postConstruct() => wyjscie");
	}
	
	
	
	public void addAdresWysylkowy() {
	   
		log.info("addAdresWysylkowy() wejście");
		kontrahent.getAdresyWysylkowe().put( adresWysylkowySymbol, new Adres( adresWysylkowy ));
		log.info("addAdresWysylkowy() wyjście");
	}
	
	public void prepAddAdres() {
		log.info( "prepAddAdres() begin");
		//aw = new AdresWysylkowy();
		log.info("setAw");
		setAdresWysylkowy( new Adres() );
		setAdresWysylkowySymbol("");
		log.info( "prepAddAdres(): " + adresWysylkowySymbol );
		log.info( "prepAddAdres(): " + adresWysylkowy );
		log.info( "prepAddAdres() end");

		
	}
	
	public void prepEditAdres() {
		log.info( "prepEditAdres() begin" );
		log.info( "pepAddAdres(): " + adresWysylkowySymbol );
		log.info( "prepEditAdres(): " + adresWysylkowy );
		log.info( "prepAddAdres() end" );
		
	}

	
	public void addAdresWysylkowySiedziba() {
      log.info( "Dodaję siedziba");
      kontrahent.getAdresyWysylkowe().put( "SIEDZIBA", kontrahent.getAdres() );
   }
	
	
	public void addAdresWysylkowySadowa() {
		log.info( "Dodaję Sadowa");
		kontrahent.getAdresyWysylkowe().put( "Sadowa", AdresUtils.AdresWyslkowySadowa() );
	}
	
	public void addAdresWysylkowy11Listopada() {
		log.info( "Dodaję 11 Listopada");
		kontrahent.getAdresyWysylkowe().put( "11-go Listopada", AdresUtils.AdresWyslkowy11Listopada() );
	}
	
	
	
	
	public List<Entry<String,Adres>> getEntrySet() {
	   log.info("kontrahentEditController.getEntrySet() -> wejscie" );
	   
	   Set<Entry<String,Adres>> entrySet = kontrahent.getAdresyWysylkowe().entrySet();
	   log.info( "entrySet -> " + entrySet);
	 
	   List<Entry<String,Adres>> list = new ArrayList<>( entrySet );
	   log.info("list -> " + list );
	   
	   log.info("kontrahentEditController.getEntrySet() -> wyjscie" );
	   
	   return list;
	}
	
	public void save() {
	   log.info( "save ->" + kontrahent.toString() );
	   log.info( "Source size " +  wyrobyPickList.getSource().size() );
      log.info( "Target size " +  wyrobyPickList.getTarget().size() );
      
      kontrahent.getWyrobyGotowe().addAll( wyrobyPickList.getTarget() );
      
      log.info( "Wyroby gotowe (pickList target: ");
      //for( IndeksMagazynowy im: wyrobyPickList.getTarget() ) {
      //   log.info( "index -> " + im );
      //   kontrahent.getWyrobyGotowe().add( im );
      //}
      kontrahent.setWyrobyGotowe( new HashSet<>( wyrobyPickList.getTarget() )  );
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


		log.info( "getWyrobyPickList(): Wejscie");
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
