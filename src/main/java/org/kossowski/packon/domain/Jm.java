package org.kossowski.packon.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(name = "jedn_miary")
public class Jm implements Serializable {

   // UnitOfMeausure

   /**
    * 
    */
   
   private  static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;

   @Column(name = "uuid")
   private UUID uuid = UUID.randomUUID();

   @Version
   private Long JpaVersion = 0L;
   
   @Column( name="symbol" , unique=true)
   private String symbol;
   private String nazwa;


   public Jm() {};
   
   public Jm( String symbol, String nazwa ) {
      this.symbol = symbol;
      this.nazwa = nazwa;
   }
   
   public Jm( long id, String symbol, String nazwa ) {
      this.id = id;
      this.symbol = symbol;
      this.nazwa = nazwa;
   }
   
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getSymbol() {
      return symbol;
   }

   public void setSymbol(String symbol) {
      this.symbol = symbol;
   }

   public String getNazwa() {
      return nazwa;
   }

   public void setNazwa(String nazwa) {
      this.nazwa = nazwa;
   }

   /**
    * @return the uuid
    */
   public UUID getUuid() {
      return uuid;
   }

   /**
    * @param uuid
    *           the uuid to set
    */
   public void setUuid(UUID uuid) {
      this.uuid = uuid;
   }

   
   
   
   
   /**
    * @return the jpaVersion
    */
   public Long getJpaVersion() {
      return JpaVersion;
   }

   /**
    * @param jpaVersion the jpaVersion to set
    */
   public void setJpaVersion(Long jpaVersion) {
      JpaVersion = jpaVersion;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
      return result;
   }

   /*
    * (non-Javadoc)
    * 
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (!(obj instanceof Jm))
         return false;
      Jm other = (Jm) obj;
      if (uuid == null) {
         if (other.uuid != null)
            return false;
      } else if (!uuid.equals(other.uuid))
         return false;
      return true;
   }

   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return "Jm [id=" + id + ", uuid=" + uuid + ", JpaVersion=" + JpaVersion + ", symbol=" + symbol + ", nazwa="
            + nazwa + "]";
   }

   

}
