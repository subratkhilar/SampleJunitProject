package net.atos.Codex_IOT.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author a622774
 *
 */
public class IOTEventStatusModel implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1480539079212732994L;
	private String eventId;
	private String status;
	private List<String> errorMessages;

	/**
	 * @return the eventId
	 */
	public String getEventId() {
		return eventId;
	}

	/**
	 * @param eventId
	 *            the eventId to set
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the errorMessages
	 */
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * @param errorMessages
	 *            the errorMessages to set
	 */
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "IOTEventStatusModel [eventId=" + eventId + ", status=" + status + ", errorMessages=" + errorMessages
				+ "]";
	}

}