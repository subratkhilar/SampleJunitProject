package net.atos.Codex_IOT.model;

import java.util.Date;

/**
 * @author a622890
 *
 */
public class EventModels {
	
	private long eventId;

	
	private String eventtype;

	
	private String severity;

	
	private String eventdesc;

	
	private Date  createdDate;

	
	private String status;


	private String projectId;

	

	
	private String sensorId;


	private String assetId ;


	public long getEventId() {
		return eventId;
	}


	public void setEventId(long eventId) {
		this.eventId = eventId;
	}


	public String getEventtype() {
		return eventtype;
	}


	public void setEventtype(String eventtype) {
		this.eventtype = eventtype;
	}


	public String getSeverity() {
		return severity;
	}


	public void setSeverity(String severity) {
		this.severity = severity;
	}


	public String getEventdesc() {
		return eventdesc;
	}


	public void setEventdesc(String eventdesc) {
		this.eventdesc = eventdesc;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getSensorId() {
		return sensorId;
	}


	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}


	public String getAssetId() {
		return assetId;
	}


	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}




	
	

}
