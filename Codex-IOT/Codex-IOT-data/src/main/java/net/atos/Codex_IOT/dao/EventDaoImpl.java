package net.atos.Codex_IOT.dao;

import java.util.List;

import javax.transaction.Transactional;

import net.atos.Codex_IOT.pojo.Event;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author a622890
 *
 */
@Transactional
@Repository
public class EventDaoImpl implements EventDao {
	
	private static final Logger logger = Logger.getLogger(EventDaoImpl.class); // Apache
	// logger


	@Autowired
	private SessionFactory sessionfactory;

	
	
	/**
	 * 
	 */
	public EventDaoImpl() {
		logger.info("in EventDaoImpl ");
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getEventDescriptions() {
	return this.sessionfactory.getCurrentSession().createQuery("select e from Event e").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getallevent() {
		return this.sessionfactory.getCurrentSession().createQuery("select e from Event e").list();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> geteventbystatus(String status) {
	
	 return (List<Event>) sessionfactory.getCurrentSession().createQuery("SELECT u FROM Event u where u.status='open' order by eventId asc").list();
	}

	@Override
	public Event getEventByEventId(long eventId) {
		return (Event) this.sessionfactory.getCurrentSession().createQuery("select e from Event e where e.eventId =:eventId").setParameter("eventId", eventId).uniqueResult();
	}

	@Override
	public boolean updateEventStatus(Event event) {
		this.sessionfactory.getCurrentSession().update(event);
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> getallEventbyCustomerID(long customerId) {
		return sessionfactory.getCurrentSession().createQuery("select e from Event e where e.customer.customerId =:customerId  order by e.createdDate desc").setParameter("customerId", customerId).list();
	}

	@Override
	public int noOfEventsByCustomerId(long customerId) {
		Long noOfEvents = (Long) sessionfactory.getCurrentSession()
				.createQuery("SELECT count(1) FROM Event e where e.customer.customerId = :customerId")
				.setParameter("customerId", customerId).uniqueResult();

		return noOfEvents.intValue();
	}
	
	
	
}
