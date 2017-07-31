package org.kossowski.packon.utils;

import org.kossowski.packon.domain.AdresWysylkowy;

public class AdresWysylkowyUtils {

	public static AdresWysylkowy AdresWyslkowySadowa() {
		
		AdresWysylkowy aw = new AdresWysylkowy();
		aw.setSymbol( "SADOWA" );
		aw.getAdresWysylkowy().setPoczta("Radomsko");
		aw.getAdresWysylkowy().setKodPocztowy("97-500");
		aw.getAdresWysylkowy().setMiejscowosc("Radomsko");
		aw.getAdresWysylkowy().setUlica("Sadowa");
		aw.getAdresWysylkowy().setNrDomu("7");
		aw.getAdresWysylkowy().setNrLokalu("19");
		
		return aw;
	}
	
	
	public static AdresWysylkowy AdresWyslkowy11Listopada() {
		
		AdresWysylkowy aw = new AdresWysylkowy();
		aw.setSymbol( "11 Listopada" );
		aw.getAdresWysylkowy().setPoczta("Radomsko");
		aw.getAdresWysylkowy().setKodPocztowy("97-500");
		aw.getAdresWysylkowy().setMiejscowosc("Radomsko");
		aw.getAdresWysylkowy().setUlica("11-go Listopada");
		aw.getAdresWysylkowy().setNrDomu("10");
		aw.getAdresWysylkowy().setNrLokalu("13");
		
		return aw;
	}
	
	
}
