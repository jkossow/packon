package org.kossowski.packon.utils;

import org.kossowski.packon.domain.Adres;

public class AdresUtils {

	public static Adres AdresWyslkowySadowa() {
		
		Adres aw = new Adres();
		
		aw.setPoczta("Radomsko");
		aw.setKodPocztowy("97-500");
		aw.setMiejscowosc("Radomsko");
		aw.setUlica("Sadowa");
		aw.setNrDomu("7");
		aw.setNrLokalu("19");
		
		return aw;
	}
	
	
	public static Adres AdresWyslkowy11Listopada() {
		
		Adres aw = new Adres();
		
		aw.setPoczta("Radomsko");
		aw.setKodPocztowy("97-500");
		aw.setMiejscowosc("Radomsko");
		aw.setUlica("11-go Listopada");
		aw.setNrDomu("10");
		aw.setNrLokalu("13");
		
		return aw;
	}
	
	
}
