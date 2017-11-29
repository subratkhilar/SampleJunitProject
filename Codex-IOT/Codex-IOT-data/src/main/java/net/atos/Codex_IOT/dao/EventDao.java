package net.atos.Codex_IOT.dao;

import java.util.List;

import net.atos.Codex_IOT.pojo.Event;


/**
 * @author a622890
 *
 */
public interface EventDao {

	/**
	 * @return
	 */
	List<Event> getEventDescriptions();

	/**
	 * @return
	 */
	List<Event> getallevent();

	/**
	 * @param status
	 * @return
	 */
	List<Event> geteventbystatus(String status);

	/**
	 * @param eventId
	 * @return
	 */
	Event getEventByEventId(long eventId);

	/**
	 * @param event
	 * @return
	 */
	boolean updateEventStatus(Event event);

	/**
	 * @param customerId
	 * @return
	 */
	List<Event> getallEventbyCustomerID(long customerId);

	/**
	 * @param customerId
	 * @return
	 */
	public int noOfEventsByCustomerId(long customerId);
}
