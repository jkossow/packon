package org.kossowski.packon.domain;

import java.util.HashSet;
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

import javax.persistence.OneToMany;



@Entity
public class Kontrahent {

	@Id @GeneratedValue
	private Long id;
	
	@Column( name = "uuid")
	private final UUID uuid = UUID.randomUUID();
	
	private String symbol;
	
	@Embedded
	private Adres adres;
	
	@OneToMany
	private Set<IndeksMagazynowy> wyrobyGotowe = new HashSet<>();
	
	@ElementCollection
	@CollectionTable( 
			name = "kontrahent_adresy_wysylkowe",
			joinColumns = @JoinColumn( name="kontrahent_id" )
	)
	private Set<AdresWysylkowy> adresyWysylkowe = new HashSet<>();

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

	public Set<AdresWysylkowy> getAdresyWysylkowe() {
		return adresyWysylkowe;
	}

	public void setAdresyWysylkowe(Set<AdresWysylkowy> adresyWysylkowe) {
		this.adresyWysylkowe = adresyWysylkowe;
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

	

	
	
	
	
	
	
	
	
}
