package org.kossowski.packon.domain;

public enum Status {
	
   // Status
   
  
	NOWE( 10, "Nowe" ),
	MATERIALY_DOBOR( 20, "Materiały dobór" ),
	MATERIALY_DOSTAWY( 30, "Materiały dostawy" ),
	GOTOWE_DO_PRODUKCJI( 40, "Gotowe do produkcji" ),
	W_TRAKCIE_PODUKCJI( 50 , "W trakcie produkcji" ),
	WYPRODUKOWANE( 60 , "Wyprodukowane"),
	W_MAGAZYNIE_WYR_GOTOWYCH( 70, "W magazynie wyr. gotowych" ),
	WYSYLKA( 80, "Wysyłki" ),
	WYSLANE( 90, "Wysłane" ),
	ZAMKNIETE_OK( 100, "Zamknięte" ),
	CANCELED( 105, "Anulowane" );
	
	private final int id;
	private final String label;
	
	private Status( int id, String label ) {
		this.id = id;
		this.label = label;
	}

	public int getId() {
		return id;
	}
	
	public String getLabel() {
	   return label;
	}
	
	public static Status[] getValues() {
	   return Status.values();
	}
}
