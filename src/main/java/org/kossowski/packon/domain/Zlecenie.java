package org.kossowski.packon.domain;

import java.math.BigDecimal;
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
   
   // ProductionOrder
	
	@Id @GeneratedValue
	private Long id = 0L;
	
	@Column( name = "uuid")
	UUID uuid = UUID.randomUUID(); 
	
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "FK_USER"))
	private User user;
	
	private Date data; // data wprowadzenia
	
	private Date terminDostawy;
	
	private String uwagi;
	
	private String numerZamowieniaKienta;
	
	private String adresWysylkowy;
	
	@ManyToOne
	private Kontrahent kontrahent;
	
	@ManyToOne
	private IndeksMagazynowy produkt;
	
	private BigDecimal ilosc; 
	
	
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

	


	/**
    * @return the terminDostawy
    */
   public Date getTerminDostawy() {
      return terminDostawy;
   }

   /**
    * @param terminDostawy the terminDostawy to set
    */
   public void setTerminDostawy(Date terminDostawy) {
      this.terminDostawy = terminDostawy;
   }

   /**
    * @return the uwagi
    */
   public String getUwagi() {
      return uwagi;
   }

   /**
    * @param uwagi the uwagi to set
    */
   public void setUwagi(String uwagi) {
      this.uwagi = uwagi;
   }

   /**
    * @return the numerZamowieniaKienta
    */
   public String getNumerZamowieniaKienta() {
      return numerZamowieniaKienta;
   }

   /**
    * @param numerZamowieniaKienta the numerZamowieniaKienta to set
    */
   public void setNumerZamowieniaKienta(String numerZamowieniaKienta) {
      this.numerZamowieniaKienta = numerZamowieniaKienta;
   }

   /**
    * @return the adresWysylkowy
    */
   public String getAdresWysylkowy() {
      return adresWysylkowy;
   }

   /**
    * @param adresWysylkowy the adresWysylkowy to set
    */
   public void setAdresWysylkowy(String adresWysylkowy) {
      this.adresWysylkowy = adresWysylkowy;
   }

   
   
   /**
    * @return the ilosc
    */
   public BigDecimal getIlosc() {
      return ilosc;
   }

   /**
    * @param ilosc the ilosc to set
    */
   public void setIlosc(BigDecimal ilosc) {
      this.ilosc = ilosc;
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

	
	
	
	/**
    * @return the uuid
    */
   public UUID getUuid() {
      return uuid;
   }

   /**
    * @param uuid the uuid to set
    */
   public void setUuid(UUID uuid) {
      this.uuid = uuid;
   }

   /**
    * @return the user
    */
   public User getUser() {
      return user;
   }

   /**
    * @param user the user to set
    */
   public void setUser(User user) {
      this.user = user;
   }

   /**
    * @return the kontrahent
    */
   public Kontrahent getKontrahent() {
      return kontrahent;
   }

   /**
    * @param kontrahent the kontrahent to set
    */
   public void setKontrahent(Kontrahent kontrahent) {
      this.kontrahent = kontrahent;
   }

   /**
    * @return the produkt
    */
   public IndeksMagazynowy getProdukt() {
      return produkt;
   }

   /**
    * @param produkt the produkt to set
    */
   public void setProdukt(IndeksMagazynowy produkt) {
      this.produkt = produkt;
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

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "Zlecenie [id=" + id + ", uuid=" + uuid + ", user=" + user + ", data=" + data + ", terminDostawy="
            + terminDostawy + ", uwagi=" + uwagi + ", numerZamowieniaKienta=" + numerZamowieniaKienta
            + ", adresWysylkowy=" + adresWysylkowy + ", kontrahent=" + kontrahent + ", produkt=" + produkt
            + ", prioryted=" + prioryted + ", status=" + status + "]";
   }

	
	

}
