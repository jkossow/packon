package org.kossowski.packon.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table( name = "dostawy_materialow")
public class DostawaMaterialu {
   
   @Id @GeneratedValue
   private Long id;
   
   @Column( name="uuid" )
   private UUID uuid = UUID.randomUUID();
   
   @ManyToOne
   @JoinColumn( name="zam_mat_id")
   private ZamowienieMaterialu zamowienieMaterialu;
   
   @Temporal( TemporalType.DATE)
   private Date dataDostawy;
   
   private BigDecimal ilosc;
   
   private int liczbaPalet;
   
   
   public DostawaMaterialu() {};
   
   public DostawaMaterialu( Date dataDostawy, BigDecimal ilosc, int liczbaPalet ) {
      this.dataDostawy = dataDostawy;
      this.ilosc = ilosc;
      this.liczbaPalet = liczbaPalet;
   }
   

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

   /**
    * @return the liczbaPalet
    */
   public int getLiczbaPalet() {
      return liczbaPalet;
   }

   /**
    * @param liczbaPalet the liczbaPalet to set
    */
   public void setLiczbaPalet(int liczbaPalet) {
      this.liczbaPalet = liczbaPalet;
   }
   
   
   
   

   /**
    * @return the zamowienieMaterialu
    */
   public ZamowienieMaterialu getZamowienieMaterialu() {
      return zamowienieMaterialu;
   }

   /**
    * @param zamowienieMaterialu the zamowienieMaterialu to set
    */
   public void setZamowienieMaterialu(ZamowienieMaterialu zamowienieMaterialu) {
      this.zamowienieMaterialu = zamowienieMaterialu;
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
      if (!(obj instanceof DostawaMaterialu))
         return false;
      DostawaMaterialu other = (DostawaMaterialu) obj;
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
      return "DostawaMaterialu [id=" + id + ", uuid=" + uuid + ", dataDostawy=" + dataDostawy + ", ilosc=" + ilosc
            + ", liczbaPalet=" + liczbaPalet + "]";
   }
   
   
   
   
   
   
}
