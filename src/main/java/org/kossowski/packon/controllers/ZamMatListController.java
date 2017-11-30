package org.kossowski.packon.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.kossowski.packon.domain.ZamowienieMaterialu;
import org.kossowski.packon.repositories.ZamowienieMaterialuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean
public class ZamMatListController implements Serializable {
   
   /**
    * 
    */
   private static final long serialVersionUID = 1L
         ;
   Logger log = LoggerFactory.getLogger(this.getClass());
   
   
   @Autowired
   protected ZamowienieMaterialuRepository zamMatRepo;
   
   
   public List<ZamowienieMaterialu> getZamMatList() {
      
      return zamMatRepo.findAll();
      
   }
   
}
