package org.kossowski.packon.config;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@ApplicationScoped
@Service
@ManagedBean
public class SampleApplicationBean {

   
   Logger log = LoggerFactory.getLogger( this.getClass() );
   
   
   @PostConstruct
   public void init() {
      log.info( log.getName() + "created" );
   }
   
}
