package org.kossowski.packon.domain;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table( name = "zlecenia" )
public class Zlecenie {
	
	@Id @GeneratedValue
	private Long id = 0L;
	
	@Column( name = "uuid")
	UUID uuid = UUID.randomUUID(); 
	
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_USER"))
	private User user;
	
	private Date data;
	
	private String opis;
	
	@Enumerated( EnumType.STRING )
	private Maszyna maszyna;
	
	@Enumerated( EnumType.STRING )
	private Zmiana zmiana;
	
	@Enumerated( EnumType.STRING )
	private Prioryted prioryted = Prioryted.NORMALNY;
	
	@Enumerated( EnumType.STRING )
	private Status status = Status.WPROWADZONE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Maszyna getMaszyna() {
		return maszyna;
	}

	public void setMaszyna(Maszyna maszyna) {
		this.maszyna = maszyna;
	}

	public Zmiana getZmiana() {
		return zmiana;
	}

	public void setZmiana(Zmiana zmiana) {
		this.zmiana = zmiana;
	}

	public Prioryted getPrioryted() {
		return prioryted;
	}

	public void setPrioryted(Prioryted prioryted) {
		this.prioryted = prioryted;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zlecenie other = (Zlecenie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Zlecenie [id=" + id + ", data=" + data + ", opis=" + opis + "]";
	}
	
	
	
	
	

}
