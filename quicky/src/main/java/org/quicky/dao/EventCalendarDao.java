package org.quicky.dao;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXStatus;

public interface EventCalendarDao {
	
	//http://javaplanner.com/docs/using_javaplanner_with_the_spring_framework.html
	//http://javaplanner.com/docs/loading_data.html
	//http://javaplanner.com/docs/managing_crud_operations.html
	
	public Iterable<DHXEv> getEvents();
	public DHXStatus saveEvent(DHXEv event, DHXStatus status);
	public DHXEv  createEvent(String id, DHXStatus status);
	
}
