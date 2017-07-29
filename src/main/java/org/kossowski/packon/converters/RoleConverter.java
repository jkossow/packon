package org.kossowski.packon.converters;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.kossowski.packon.domain.Role;



@ManagedBean
public class RoleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		System.out.println( "getAsObject");
		System.out.println( arg2.getClass().getName());
		System.out.println( arg2 );
		return new Role( arg2 );
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		System.out.println("getAsString");
		System.out.println( arg2.getClass().getName());
		System.out.println( arg2 );
		return ((Role)arg2).getRole();
	}

		
	
}
