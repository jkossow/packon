package org.kossowski.packon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class IndexController {

	@RequestMapping( "/" )
	public String index() {
		return "redirect:/faces/index.xhtml";
	}
	
	@RequestMapping( "/hi" )
   public String hi() {
      return "hi";
   }
	
}
