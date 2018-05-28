package org.kossowski.packon.converters;

import org.kossowski.packon.domain.Jm;
import org.kossowski.packon.repositories.JmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


@Service
@ManagedBean
public class JmConverter implements Converter {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected JmRepository jmRepo;

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

        if( value == null )
            return null;


        if (value.isEmpty())
            return null;


        Long id = null;

        try {
            log.info(log.getName() + "getAsObject()  value= " + value +
                    " value class = " + value.getClass().getName());
            id = Long.valueOf(value);
        } catch (NumberFormatException e) {
            log.info(log.getName() + "getAsObject() - blok chroniony");
            return null;
        }


        Jm jm = null;
        if (id != 0L)
            jm = jmRepo.findOne(id);

        return jm;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

        //log.info( log.getName() + " getAsString value.getClass =" + value.getClass().getSimpleName() );
        //log.info( log.getName() + " getAsString value  = " + value );

        Jm jm = null;
        try {
            jm = (Jm) value;
        } catch (ClassCastException e) {

            //log.info( log.getName() + " getAsString wyjatek jm=" + jm );

        }

        //log.info( log.getName() + " getAsString po wyjatku jm=" + jm );
        //if( im != null)
        //   log.info( log.getName() + " getAsString po wyjatku im.getId=" + im.getId() );

        return jm == null ? null : jm.getId().toString();
    }


    public JmRepository getJmRepo() {
        return jmRepo;
    }

    public void setJmRepo(JmRepository jmRepo) {
        this.jmRepo = jmRepo;
    }
}
