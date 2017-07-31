package org.kossowski.packon.domain;

import javax.persistence.Embeddable;

@Embeddable
public class AdresWysylkowy {

	private String symbol;
	private Adres adresWysylkowy = new Adres();

	public AdresWysylkowy() {};

	public AdresWysylkowy( AdresWysylkowy aw ) {
		this.symbol = aw.getSymbol();
		this.adresWysylkowy = new Adres( aw.getAdresWysylkowy() );
	}
	
	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}
	
	
	/**
	 * @param symbol the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
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
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresWysylkowy == null) ? 0 : adresWysylkowy.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		return result;
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
		if (!(obj instanceof AdresWysylkowy))
			return false;
		AdresWysylkowy other = (AdresWysylkowy) obj;
		if (adresWysylkowy == null) {
			if (other.adresWysylkowy != null)
				return false;
		} else if (!adresWysylkowy.equals(other.adresWysylkowy))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		return true;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdresWysylkowy [symbol=" + symbol + ", adresWysylkowy=" + adresWysylkowy + "]";
	}
	
	
	
	
	
}
