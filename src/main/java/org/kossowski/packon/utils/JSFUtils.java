package org.kossowski.packon.utils;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFUtils {
    
    public static void addMessage( String message ) {
        FacesMessage facesMessage = new FacesMessage(  message );
        FacesContext.getCurrentInstance().addMessage(null,  facesMessage);
    }
    
    public static String getRequestParam( String paramName ) {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> pm = fc.getExternalContext().getRequestParameterMap();
        
        
        return pm.get( paramName );
    }
    
    public static String getElementValue( String id ) {
        //UIComponent c = FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        //c.getValueBinding("value");
        
        //return (String)c.getAttributes().get("value");
        return "";
    }
    
}
