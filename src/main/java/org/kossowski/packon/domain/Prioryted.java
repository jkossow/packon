package org.kossowski.packon.domain;

public enum Prioryted {

	NORMALNY(1,"Zwykły"),
	PILNE(2,"Pilny");
	
	private final int id;
	private final String label;

	private Prioryted(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}
	
	
	
}
