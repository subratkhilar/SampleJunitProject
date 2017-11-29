package net.atos.Codex_IOT.service;

import net.atos.Codex_IOT.model.EventModel;
import net.atos.Codex_IOT.model.PushNotification;
import net.atos.Codex_IOT.pojo.Event;




public interface NotificationService {

	/**
	 * @return
	 */
	boolean notificationtouser();

	/**
	 * @param eventm
	 * @return
	 */
	boolean notifyfromeventtable(EventModel eventm);


}
