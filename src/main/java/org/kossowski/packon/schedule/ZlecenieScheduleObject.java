package org.kossowski.packon.schedule;

import java.util.Date;

import org.kossowski.packon.domain.Zlecenie;
import org.primefaces.model.ScheduleEvent;

public class ZlecenieScheduleObject  implements ScheduleEvent {
	
	private Zlecenie zlecenie;
	
	public ZlecenieScheduleObject( Zlecenie zlecenie ) {
		
		this.zlecenie = zlecenie;
		
	}

	@Override
	public Object getData() {
		// TODO Auto-generated method stub
		return zlecenie;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return zlecenie.getOpis();
	}

	@Override
	public Date getEndDate() {
		// TODO Auto-generated method stub
		return zlecenie.getData();
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return zlecenie.getId().toString();
	}

	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return zlecenie.getData();
	}

	@Override
	public String getStyleClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		//return zlecenie.getOpis();
		return zlecenie.getOpis();
	}

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return "rteee";
	}

	@Override
	public boolean isAllDay() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEditable() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setId(String arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
