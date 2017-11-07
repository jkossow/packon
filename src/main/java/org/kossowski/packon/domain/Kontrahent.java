package org.kossowski.packon.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;



@Entity
public class Kontrahent {

	@Id @GeneratedValue
	private Long id;
	
	@Column( name = "uuid")
	private final UUID uuid = UUID.randomUUID();
	
	private String symbol;
	private String nazwa;
	private String nip;
	private String regon;
	private String email;
	
	private Boolean dostawca = false;
	private Boolean odbiorca = false;
	
	@Embedded
	private Adres adres = new Adres();
	
	@OneToMany
	private Set<IndeksMagazynowy> wyrobyGotowe = new HashSet<>();
	
	
	
	@ElementCollection
	@CollectionTable(
	        name = "kontrahent_adresy_wysylkowe",
	        joinColumns = @JoinColumn( name = "kontrahent_id")
	)
	@MapKeyJoinColumn( name = "kontrahent_id", referencedColumnName = "id" )
	private Map<String , Adres> adresyWysylkowe = new HashMap<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Set<IndeksMagazynowy> getWyrobyGotowe() {
		return wyrobyGotowe;
	}

	public void setWyrobyGotowe(Set<IndeksMagazynowy> wyrobyGotowe) {
		this.wyrobyGotowe = wyrobyGotowe;
	}

	

	/**
    * @return the adresyWysylkoweNew
    */
   public Map<String, Adres> getAdresyWysylkowe() {
      return adresyWysylkowe;
   }

   /**
    * @param adresyWysylkoweNew the adresyWysylkoweNew to set
    */
   public void setAdresyWysylkowe( Map<String, Adres> adresyWysylkowe) {
      this.adresyWysylkowe = adresyWysylkowe;
   }

   
   
   
   
   /**
    * @return the nip
    */
   public String getNip() {
      return nip;
   }

   /**
    * @param nip the nip to set
    */
   public void setNip(String nip) {
      this.nip = nip;
   }

   /**
    * @return the regon
    */
   public String getRegon() {
      return regon;
   }

   /**
    * @param regon the regon to set
    */
   public void setRegon(String regon) {
      this.regon = regon;
   }

   /**
    * @return the email
    */
   public String getEmail() {
      return email;
   }

   /**
    * @param email the email to set
    */
   public void setEmail(String email) {
      this.email = email;
   }

   /**
    * @return the nazwa
    */
   public String getNazwa() {
      return nazwa;
   }

   /**
    * @param nazwa the nazwa to set
    */
   public void setNazwa(String nazwa) {
      this.nazwa = nazwa;
   }

   
   
   
   /**
    * @return the dostawca
    */
   public Boolean getDostawca() {
      return dostawca;
   }

   /**
    * @param dostawca the dostawca to set
    */
   public void setDostawca(Boolean dostawca) {
      this.dostawca = dostawca;
   }

   /**
    * @return the odbiorca
    */
   public Boolean getOdbiorca() {
      return odbiorca;
   }

   /**
    * @param odbiorca the odbiorca to set
    */
   public void setOdbiorca(Boolean odbiorca) {
      this.odbiorca = odbiorca;
   }

   /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		
		return uuid.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Kontrahent))
			return false;
		Kontrahent other = (Kontrahent) obj;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "Kontrahent [id=" + id + ", uuid=" + uuid + ", symbol=" + symbol + ", nazwa=" + nazwa + ", nip=" + nip
            + ", regon=" + regon + ", email=" + email + ", dostawca=" + dostawca + ", odbiorca=" + odbiorca + ", adres="
            + adres + ", wyrobyGotowe=" + wyrobyGotowe + ", adresyWysylkowe=" + adresyWysylkowe + "]";
   }

   

	

	
	
	
	
	
	
	
	
}
