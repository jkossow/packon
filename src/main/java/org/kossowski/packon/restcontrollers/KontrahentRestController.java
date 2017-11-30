package org.kossowski.packon.restcontrollers;

import java.util.List;

import org.kossowski.packon.domain.Kontrahent;
import org.kossowski.packon.repositories.KontrahentRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/kontrahent")
public class KontrahentRestController {

   @Autowired
   protected KontrahentRepostory kontrahRepo;
   
   
   @RequestMapping("/findAll") 
   @ResponseBody
   public List<Kontrahent> findAll() {
      return kontrahRepo.findAll();
   }
   
   @RequestMapping("/findOne/{id}")
   @ResponseBody
   public Kontrahent findOne(  @PathVariable("id") Long id ) {
      return kontrahRepo.findOne( id );
   }
   
   public String hi() {
      return "hi";
   }
}
