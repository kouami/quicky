package org.quicky.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.quicky.model.Event;
import org.springframework.beans.factory.annotation.Autowired;

import com.dhtmlx.planner.DHXEv;
import com.dhtmlx.planner.DHXEvent;
import com.dhtmlx.planner.DHXStatus;

public class EventCalendarDaoImpl implements EventCalendarDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Iterable<Event> getEvents() {
		return getSession().createQuery("from Event").list();
	}

	@Override
	public DHXStatus saveEvent(DHXEv event, DHXStatus status) {
		if(status == DHXStatus.UPDATE){
			getSession().update(event);
		} else if(status == DHXStatus.DELETE){
			getSession().delete(event);
		} else if(status == DHXStatus.INSERT) {
			getSession().save(event);
		}
		return null;
	}

	@Override
	public DHXEv createEvent(String id, DHXStatus status) {
		return new DHXEvent();
	}

}
