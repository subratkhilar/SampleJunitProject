package net.atos.Codex_IOT.model;

import java.util.Date;

/**
 * @author a622693
 *
 */
public class Data {
	
	private long eventId;

	private String eventtype;

	private String eventdesc;

	private Date createdDate;
	
	private String severity;
	
	private String sensorId;


	/**
	 * @return the sensorId
	 */
	public String getSensorId() {
		return sensorId;
	}

	/**
	 * @param sensorId the sensorId to set
	 */
	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	/**
	 * @return the eventId
	 */
	public long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the eventname
	 */


	/**
	 * @return the eventdesc
	 */
	public String getEventdesc() {
		return eventdesc;
	}

	public String getEventtype() {
		return eventtype;
	}

	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}

	/**
	 * @param eventdesc the eventdesc to set
	 */
	public void setEventdesc(String eventdesc) {
		this.eventdesc = eventdesc;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Data [eventId=" + eventId
				+ ", eventtype=" + eventtype + ", eventdesc=" + eventdesc
				+ ", createdDate=" + createdDate +", severity=" + severity + "]";
	}


}
