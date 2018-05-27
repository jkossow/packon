package org.kossowski.packon.domain;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.kossowski.packon.domain.nowe.Produkowalny;
import org.kossowski.packon.domain.przedmMagazynowe.Wyrob;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "zlecenia")
public class Zlecenie extends BaseEntity<Long> {


    // ProductionOrder

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_zlecenie__user"))
    private User user;

    @Temporal(TemporalType.DATE)
    private Date data; // data wprowadzenia

    @Temporal(TemporalType.DATE)
    private Date terminDostawy;

    private String uwagi;

    private String numerZamowieniaKienta;

    private String adresWysylkowyKey;

    @Embedded
    private Adres adresWysylkowy = new Adres();

    @ManyToOne
    @JoinColumn( foreignKey = @ForeignKey( name = "FK_zlecenie__kontrahent"))
    private Kontrahent kontrahent;

    //@Any( metaColumn = @Column( name= "Entity" ))
    //@AnyMetaDef( idType="integer", metaType = "integer" , metaValues = {
    //
    //})
    @ManyToOne
    @JoinColumn( name = "parent_id", foreignKey = @ForeignKey( name = "FK_zlecenie__indeks_magazynowy") )
    private Wyrob wyrob;

    private BigDecimal ilosc;

    @ManyToOne
    @JoinColumn( foreignKey = @ForeignKey( name = "FK_zlecenie__jm") )
    private Jm jm;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "zlecenie", fetch = FetchType.LAZY )
    //@JoinColumn( foreignKey = @ForeignKey( name = "FK_zlecenie__zamowienie_materialu" ) )
    //@OneToMany
    //@JoinColumn( name = "ZLECENIE_ID")
    //@org.hibernate.annotations.Fetch(
    //      org.hibernate.annotations.FetchMode.SELECT )
    private Set<ZamowienieMaterialu> zamowieniaMaterialu = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Prioryted prioryted = Prioryted.NORMALNY;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NOWE;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getTerminDostawy() {
        return terminDostawy;
    }

    public void setTerminDostawy(Date terminDostawy) {
        this.terminDostawy = terminDostawy;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    public String getNumerZamowieniaKienta() {
        return numerZamowieniaKienta;
    }

    public void setNumerZamowieniaKienta(String numerZamowieniaKienta) {
        this.numerZamowieniaKienta = numerZamowieniaKienta;
    }

    public String getAdresWysylkowyKey() {
        return adresWysylkowyKey;
    }

    public void setAdresWysylkowyKey(String adresWysylkowyKey) {
        this.adresWysylkowyKey = adresWysylkowyKey;
    }

    public BigDecimal getIlosc() {
        return ilosc;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Kontrahent getKontrahent() {
        return kontrahent;
    }

    public void setKontrahent(Kontrahent kontrahent) {
        this.kontrahent = kontrahent;
    }

    public Wyrob getWyrob() {
        return wyrob;
    }

    public void setWyrob(Wyrob wyrob) {
        this.wyrob = wyrob;
    }

    public Adres getAdresWysylkowy() {
        return adresWysylkowy;
    }

    public void setAdresWysylkowy(Adres adresWysylkowy) {
        this.adresWysylkowy = adresWysylkowy;
    }

    public Set<ZamowienieMaterialu> getZamowieniaMaterialu() {
        return zamowieniaMaterialu;
    }

    public void setZamowieniaMaterialu(Set<ZamowienieMaterialu> zamowieniaMaterialu) {
        this.zamowieniaMaterialu = zamowieniaMaterialu;
    }

    public Jm getJm() {
        return jm;
    }

    public void setJm(Jm jm) {
        this.jm = jm;
    }

    @Override
    public String toString() {
        return "Zlecenie{" +
                "user=" + user +
                ", data=" + data +
                ", terminDostawy=" + terminDostawy +
                ", uwagi='" + uwagi + '\'' +
                ", numerZamowieniaKienta='" + numerZamowieniaKienta + '\'' +
                ", adresWysylkowyKey='" + adresWysylkowyKey + '\'' +
                ", adresWysylkowy=" + adresWysylkowy +
                ", kontrahent=" + kontrahent +
                ", iwyrob=" + wyrob +
                ", ilosc=" + ilosc +
                ", jm=" + jm +
                ", zamowieniaMaterialu=" + zamowieniaMaterialu +
                ", prioryted=" + prioryted +
                ", status=" + status +
                "} " + super.toString();
    }
}
