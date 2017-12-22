package org.kossowski.packon.controllers;

import org.kossowski.packon.domain.*;
import org.kossowski.packon.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Controller
@ManagedBean
@ViewScoped
public class DokisZlecenieEdit2Controller implements Serializable {


    private static final long serialVersionUID = 1L;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected ZlecenieRepository zlecRepo;

    @Autowired
    protected JmRepository jmRepo;

    @Autowired
    protected ZamowienieMaterialuRepository zamRepo;

    @Autowired
    protected KontrahentRepostory kontrahRepo;

    @Autowired
    protected IndeksMagazynowyRepository indeksMatRepo;

    @Autowired
    protected SessionValues sv;



    protected Zlecenie zlecenie;
    //protected Set<IndeksMagazynowy> productList = null;
    protected ZamowienieMaterialu selZamMat = null;



    @PostConstruct
    protected void init() {

        log.info(log.getName() + " init");

        Long id = sv.getZlecenieToEdit();


        zlecenie = zlecRepo.findOne(id);

        log.info(log.getName() + " init() zlecenie.getClass() = {}", zlecenie.getClass());

        // inicjalizacja kolekcji

        zlecenie.getProdukt();
        zlecenie.getProdukt().getMaterials().size();

        for (ZamowienieMaterialu zm : zlecenie.getZamowieniaMaterialu()) {
            log.info(log.getName() + "init() dostawy.size()={}", zm.getDostawy().size());
            for (DostawaMaterialu d : zm.getDostawy())
                d.getIlosc();
        }
        ;

        // koniec incjalizacji

        log.debug(log.getName() + " doksZlecenieEditController.init() zlecenie.getId()={}", zlecenie.getId());
        log.debug(log.getName() + " doksZlecenieEditController.init() zlecenie.getZamowieniaMaterialow(),size()={}", zlecenie.getZamowieniaMaterialu().size());
        for (ZamowienieMaterialu zm : zlecenie.getZamowieniaMaterialu()) {
            log.debug(log.getName() + " doksZlecenieEditController.init() zamowienieMaterialu.getId()={} zamowienieMaterialu.getDostawy().size()={}",
                    zm.getId(), zm.getDostawy().size());
        }

        log.info(log.getName() + " zlecenie = {}", zlecenie);
        log.info(log.getName() + " init - end");
    }


    public List<Jm> getJmList() {
        return jmRepo.findAll();
    }


    public void dopisz() {

        log.info(log.getName() + " dopisz()");
        log.debug(log.getName() + " dopisz() zamowieniaMaterialu.size()={}", zlecenie.getZamowieniaMaterialu().size());
        for (IndeksMagazynowy i : zlecenie.getProdukt().getMaterials()) {
            ZamowienieMaterialu z = new ZamowienieMaterialu();
            z.setZlecenie(zlecenie);
            z.setMaterial(i);
            z.setDataZamowienia(new Date());

            zlecenie.getZamowieniaMaterialu().add(z);
        }
        ;
        log.debug(log.getName() + " dopisz() zamowieniaMaterialu.size()={}", zlecenie.getZamowieniaMaterialu().size());

    }

    public void nowyMaterial() {
        log.info(log.getName() + " nowyMaterial()");
        ZamowienieMaterialu z = new ZamowienieMaterialu();
        z.setZlecenie(zlecenie);
        z.setDataZamowienia(new Date());
        zlecenie.getZamowieniaMaterialu().add(z);
    }


    public void delOrder(ZamowienieMaterialu zm) {

        log.info(log.getName() + " delOrder()");
        log.debug(log.getName() + " przed delOrder() zm = " + zm);
        log.debug(log.getName() + " przed delOrder() zamowieniaMaterialow = " + zlecenie.getZamowieniaMaterialu());

        zlecenie.getZamowieniaMaterialu().remove(zm);

        log.debug(log.getName() + " po    delOrder() zamowieniaMaterialow = " + zlecenie.getZamowieniaMaterialu());
        log.debug(log.getName() + " po    delOrder() zm = " + zm);

    }


    public BigDecimal getWartosc() {

        BigDecimal w = BigDecimal.ZERO;

        log.info(log.getName() + " getWartosc() ");

        for (ZamowienieMaterialu z : zlecenie.getZamowieniaMaterialu()) {
            if (z.getWartosc() != null)
                w = w.add(z.getWartosc());
        }
        return w;
    }

    public List<Kontrahent> getListaDostawcow() {
        return kontrahRepo.findByOdbiorcaTrue();
    }


    public List<IndeksMagazynowy> getListaMaterialow() {
        return indeksMatRepo.findByMaterialTrue();
    }

    public void pokazDostawy(ZamowienieMaterialu z) {
        log.info(log.getName() + " pokazDostawy zlecenie.getId() = {}", zlecenie.getId());
        log.info(log.getName() + " pokazDostawy zamMat.getId() = {}", z.getId());
        log.info(log.getName() + " pokazDostawy zamMat.getDostawy().size() = {}", z.getDostawy().size());
        selZamMat = z;
    }

    public Collection<DostawaMaterialu> getDostawy() {
        log.info(log.getName() + " getDostawy()");
        log.info(log.getName() + " getDostawy() setZamMat.class = {}",
                selZamMat != null ? selZamMat.getClass().getName() : "selZamMat is null");
        //if( selZamMat != null )
        // Hibernate.initialize( zlecenie.getZamowieniaMaterialu());
        return selZamMat != null ? selZamMat.getDostawy() : null;
    }

    public void nowaDostawa() {
        log.info(log.getName() + " nowaDostawa()");

        DostawaMaterialu d = new DostawaMaterialu(new Date(), new BigDecimal(1), 1);
        if (selZamMat != null) {
            //Hibernate.initialize( selZamMat.getDostawy() );
            log.info(log.getName() + " nowaDostawa() dodaje");
            d.setZamowienieMaterialu(selZamMat);
            selZamMat.getDostawy().add(d);
        }
    }


    public String save() {


        log.info(log.getName() + " save() Saving ZLECENIE");
        log.info(log.getName() + " save() zamMat = " + zlecenie.getZamowieniaMaterialu());

        log.debug(log.getName() + " dokisZlecenieEditController.save() before save zlecenie.getId()={}", zlecenie);
        log.debug(log.getName() + " dokisZlecenieEditController.save() before save zlecenie.getZamowieniaMaterialow(),size()={}", zlecenie.getZamowieniaMaterialu().size());
        for (ZamowienieMaterialu zm : zlecenie.getZamowieniaMaterialu()) {
            log.debug(log.getName() + " doksiZlecenieEditController.save()  before save zamowienieMaterialu.getId()={} zamowienieMaterialu.getDostawy().size()={}",
                    zm.getId(), zm.getDostawy().size());
        }
        log.info(log.getName() + " save() before zlecRepo.save() ");
        zlecenie = zlecRepo.save(zlecenie);


        log.debug(log.getName() + " dokisZlecenieEditController.save() after save zlecenie.getId()={}", zlecenie);
        log.debug(log.getName() + " dokisZlecenieEditController.save() after save zlecenie.getZamowieniaMaterialow(),size()={}", zlecenie.getZamowieniaMaterialu().size());
        for (ZamowienieMaterialu zm : zlecenie.getZamowieniaMaterialu()) {
            log.debug(log.getName() + " doksiZlecenieEditController.save() after save zamowienieMaterialu.getId()={} zamowienieMaterialu.getDostawy().size()={}",
                    zm.getId(), zm.getDostawy().size());
        }

        return "/dokis/list.xhtml";

    }

    /**
     * @return the zlecenie
     */
    public Zlecenie getZlecenie() {
        return zlecenie;
    }

    /**
     * @param zlecenie the zlecenie to set
     */
    public void setZlecenie(Zlecenie zlecenie) {
        this.zlecenie = zlecenie;
    }


    /**
     * @return the selZamMat
     */
    public ZamowienieMaterialu getSelZamMat() {
        return selZamMat;
    }

    /**
     * @param selZamMat the selZamMat to set
     */
    public void setSelZamMat(ZamowienieMaterialu selZamMat) {
        this.selZamMat = selZamMat;
    }


}
