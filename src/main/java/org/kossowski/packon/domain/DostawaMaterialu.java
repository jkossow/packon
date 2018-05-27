package org.kossowski.packon.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table( name = "dostawy_materialow")
public class DostawaMaterialu extends BaseEntity< Long > {
   

   
   @ManyToOne
   @JoinColumn( name="zam_mat_id", foreignKey = @ForeignKey( name = "FK_dostawa_materialu__zamowienie_materialu") )
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

    @Override
    public String toString() {
        return "DostawaMaterialu{" +
                "zamowienieMaterialu=" + zamowienieMaterialu +
                ", dataDostawy=" + dataDostawy +
                ", ilosc=" + ilosc +
                ", liczbaPalet=" + liczbaPalet +
                "} " + super.toString();
    }
}
