package org.kossowski.packon.utils;

import org.kossowski.packon.domain.AdresWysylkowy;

public class AdresWysylkowyUtils {

	public static AdresWysylkowy AdresWyslkowySadowa() {
		
		AdresWysylkowy aw = new AdresWysylkowy();
		aw.setSymbol( "SADOWA" );
		aw.getAdresWysylkowy().setMiejscowosc("Radomsko");
		aw.getAdresWysylkowy().setUlica("Sadowa");
		
		return aw;
	}
	
	
	public static AdresWysylkowy AdresWyslkowy11Listopada() {
		
		AdresWysylkowy aw = new AdresWysylkowy();
		aw.setSymbol( "11 Listopada" );
		aw.getAdresWysylkowy().setMiejscowosc("Radomsko");
		aw.getAdresWysylkowy().setUlica("11-go Lustopada");
		
		return aw;
	}
	
	
}
