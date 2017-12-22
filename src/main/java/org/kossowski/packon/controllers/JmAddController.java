package org.kossowski.packon.controllers;

import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.repositories.JmRepository;
import org.kossowski.packon.utils.JSFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import java.io.Serializable;


@Controller
@ManagedBean
@RequestScoped
public class JmAddController implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected JmRepository jmRepo;

    @Autowired
    protected EntityManager em;

    private Jm jm;

    @PostConstruct
    public void init() {
        jm = new Jm();
    }

    public String prepAdd() {

        log.info( log.getName() + " prepAdd() ");
        return "/jm/add.xhtml?faces-redirect=true";
    }


    public String ok() {

        log.info(log.getName() + "ok() jm= {}" + jm);
        try {
            jmRepo.save(jm);
        } catch (DataIntegrityViolationException e) {
            log.info(log.getName() + " ok() wyjatek " + e.getClass().getName());
            JSFUtils.addMessage(e.getClass().getName());
            return "";
        }

        return "/jm/list.xhtml?faces-redirect=true";
    }

    public String cancel() {

        log.info( log.getName() + " cance()" );
        return "/jm/list.xhtml?faces-redirect=true";
    }

    /**
     * @return the jm
     */
    public Jm getJm() {
        return jm;
    }

    /**
     * @param jm the jm to set
     */
    public void setJm(Jm jm) {
        this.jm = jm;
    }


}
