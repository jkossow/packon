package org.kossowski.packon.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Maszyna {
   
   // Machine
   
   @Id @GeneratedValue
   private Long id;
   
   @Column( name = "uuid")
   private final UUID uuid = UUID.randomUUID();
   
   
   private String symbol;
   private String nazwa;
   
   
   /**
    * @return the id
    */
   public Long getId() {
      return id;
   }
   
   
   /**
    * @param id the id to set
    */
   public void setId(Long id) {
      this.id = id;
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
    * @return the nazwa
    */
   public String getNazwa() {
      return nazwa;
   }
   
   
   /**
    * @param nazwa the nazwa to set
    */
   public void setNazwa(String nazwa) {
      this.nazwa = nazwa;
   }
   
   
   /**
    * @return the uuid
    */
   public UUID getUuid() {
      return uuid;
   }


   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
      if (!(obj instanceof Maszyna))
         return false;
      Maszyna other = (Maszyna) obj;
      if (uuid == null) {
         if (other.uuid != null)
            return false;
      } else if (!uuid.equals(other.uuid))
         return false;
      return true;
   }
   
   
   
   

}
