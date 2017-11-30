package org.kossowski.packon.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "zamowienia_materialow")
public class ZamowienieMaterialu implements Serializable {
   
   // MaterialsOrder
  
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Id @GeneratedValue
   private Long id;
   
   @Column( name = "uuid")
   UUID uuid = UUID.randomUUID(); 
   
   private Date dataZamowienia;
   
   private Date terminDostawy;
   
   private Date dataDostawy;
   
   @ManyToOne
   private IndeksMagazynowy material;
   
   @ManyToOne
   private Kontrahent dostawca;

   private BigDecimal iloscZamowiona;
   private BigDecimal iloscDostarczona;
   
   private BigDecimal wartosc;

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
    * @return the dataZamowienia
    */
   public Date getDataZamowienia() {
      return dataZamowienia;
   }

   /**
    * @param dataZamowienia the dataZamowienia to set
    */
   public void setDataZamowienia(Date dataZamowienia) {
      this.dataZamowienia = dataZamowienia;
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
    * @return the dataDostawy
    */
   public Date getDataDostawy() {
      return dataDostawy;
   }

   /**
    * @param dataDostawy the dataDostawy to set
    */
   public void setDataDostawy(Date dataDostawy) {
      this.dataDostawy = dataDostawy;
   }

   /**
    * @return the material
    */
   public IndeksMagazynowy getMaterial() {
      return material;
   }

   /**
    * @param material the material to set
    */
   public void setMaterial(IndeksMagazynowy material) {
      this.material = material;
   }

   /**
    * @return the dostawca
    */
   public Kontrahent getDostawca() {
      return dostawca;
   }

   /**
    * @param dostawca the dostawca to set
    */
   public void setDostawca(Kontrahent dostawca) {
      this.dostawca = dostawca;
   }

   /**
    * @return the iloscZamowiona
    */
   public BigDecimal getIloscZamowiona() {
      return iloscZamowiona;
   }

   /**
    * @param iloscZamowiona the iloscZamowiona to set
    */
   public void setIloscZamowiona(BigDecimal iloscZamowiona) {
      this.iloscZamowiona = iloscZamowiona;
   }

   /**
    * @return the iloscDostarczona
    */
   public BigDecimal getIloscDostarczona() {
      return iloscDostarczona;
   }

   /**
    * @param iloscDostarczona the iloscDostarczona to set
    */
   public void setIloscDostarczona(BigDecimal iloscDostarczona) {
      this.iloscDostarczona = iloscDostarczona;
   }

   /**
    * @return the wartosc
    */
   public BigDecimal getWartosc() {
      return wartosc;
   }

   /**
    * @param wartosc the wartosc to set
    */
   public void setWartosc(BigDecimal wartosc) {
      this.wartosc = wartosc;
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
      if (!(obj instanceof ZamowienieMaterialu))
         return false;
      ZamowienieMaterialu other = (ZamowienieMaterialu) obj;
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
      return "ZamowienieMaterialu [id=" + id + ", uuid=" + uuid + ", dataZamowienia=" + dataZamowienia
            + ", terminDostawy=" + terminDostawy + ", dataDostawy=" + dataDostawy + ", material=" + material
            + ", dostawca=" + dostawca + ", iloscZamowiona=" + iloscZamowiona + ", iloscDostarczona=" + iloscDostarczona
            + ", wartosc=" + wartosc + "]";
   }
   
   
   
   
   
   
   
}
