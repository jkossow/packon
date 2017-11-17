package org.kossowski.packon.domain;

public enum Status {
	
   // Status
   
	WPROWADZONE(1),
	PRZYGOTOWANIE_DO_PRODUKCJI(2),
	GOTOWE_DO_PRODUKCJI(3),
	W_TRAKCIE_PRODUKCJI(3),
	WYPRODUKOWANE(5),
	W_MAGAZYNIE_WYR_GOTOWYCH(6),
	WYSLANE(7),
	ZAMKNIETE_OK(8),
	CANCELED(9);
	
	private final int id;
	
	private Status( int id) {
		this.id = id;
	}

	@SuppressWarnings("unused")
	private int getId() {
		return id;
	}
}
