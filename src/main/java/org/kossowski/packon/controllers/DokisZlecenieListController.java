package org.kossowski.packon.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.transaction.Transactional;

import org.kossowski.packon.domain.Status;
import org.kossowski.packon.domain.Zlecenie;
import org.kossowski.packon.repositories.ZlecenieRepository;
import org.kossowski.packon.utils.JSFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
@RequestScoped
public class DokisZlecenieListController {

   Logger log = LoggerFactory.getLogger(this.getClass());

   @Autowired
   protected ZlecenieRepository zRepo;

   @Autowired
   protected SessionValues sv;

   @ManagedProperty(value = "null")
   protected Zlecenie zlecenie;

   protected Status newStatus;

   protected List<Zlecenie> list = null;

   public DokisZlecenieListController() {
      log.info("ZlecenieListCpntroller()");
   }

   public List<Zlecenie> getFindAll() {

      log.info("Metoda getFindAll() ");
      if (list == null) {
         log.info("Metoda getFindAll() - odczyt z repo");
         list = zRepo.findAll();
      }
      return list;
   }

   public Status[] getStatusSelectItems() {
      return Status.getValues();
   }

   public String saveStatus() {

      Long id = Long.valueOf(JSFUtils.getRequestParam("id"));

      log.info(log.getName() + " saveStatus()  newStatus= " + newStatus);
      log.info(log.getName() + " saveStatus()         id= " + id);
      log.info(log.getName() + " saveStatus()   zlecenie= " + zlecenie);

      Zlecenie z = zRepo.findOne(id);
      if (z.getStatus() != newStatus) {

         z.setStatus(newStatus);
         zRepo.save(z);

      }

      return "list.xhtml";
   }

   public String prepEdit() {

      Long id = Long.valueOf(JSFUtils.getRequestParam("id"));
      Status status = Status.valueOf(JSFUtils.getRequestParam("status"));

      sv.setZlecenieToEdit(id);

      log.info("dokisZlecenieListController -> prepEdit() -> id " + id);
      log.info("dokisZlecenieListController -> prepEdit() -> status " + status);

      String view;

      switch (status) {
      case NOWE:
         view = "edit.xhtml?faces-redirect=true";
         break;
      case MATERIALY_DOBOR:
         view = "edit2.xhtml?faces-redirect=true";
         break;
      default:
         view = "";
         break;
      }

      return view;
   }

   /**
    * @return the zlecenie
    */
   public Zlecenie getZlecenie() {
      return zlecenie != null ? zlecenie : new Zlecenie();
   }

   /**
    * @param zlecenie
    *           the zlecenie to set
    */
   public void setZlecenie(Zlecenie zlecenie) {
      log.info(log.getName() + " setZlecenie() zlecenie.id=" + zlecenie.getId());
      this.zlecenie = zlecenie;
   }

   /**
    * @return the newStatus
    */
   public Status getNewStatus() {
      return newStatus;
   }

   /**
    * @param newStatus
    *           the newStatus to set
    */
   public void setNewStatus(Status newStatus) {
      this.newStatus = newStatus;
   }

}
