package net.atos.Codex_IOT.service;

import java.util.List;





import net.atos.Codex_IOT.model.EventModels;
import net.atos.Codex_IOT.model.IOTEventStatusModel;
import net.atos.Codex_IOT.pojo.Event;

/**
 * @author a622890
 *
 */
public interface EventService {

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
	 * @param iotevent
	 * @return
	 */
	boolean updateEventByEventId(IOTEventStatusModel iotevent);

	/**
	 * @param customerId
	 * @return
	 */
	List<EventModels> getallEventbyCustomerID(long customerId);

	/**
	 * @param customerId
	 * @return
	 */
	public int noOfEventsByCustomerId(long customerId);

	/**
	 * @param eventStatusModels
	 */
	public void updateAllEventStatus(List<IOTEventStatusModel> eventStatusModels);

}
