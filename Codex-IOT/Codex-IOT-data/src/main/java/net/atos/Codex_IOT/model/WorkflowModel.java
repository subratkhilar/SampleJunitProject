
package net.atos.Codex_IOT.model;

import java.util.Date;

/**
 * @author a631080
 *
 */
public class WorkflowModel {

	
	
	private long workflowId;
	
	private long userId;
	
	private String projectId;

	private String assetId;
	
	private String sensorId;
	
	private long customerId;

	private String eventType;
		
	private int upperLimit;
		
	private int lowerLimit;
		 
	private int noOfOccurrences;
		
	private String meadiaType;
		
	private String mediaValue;
		 
	private Date createdDate;
		 
	private Date updatedDate;
		
	private boolean isActive;

	
	public long getWorkflowId() {
		return workflowId;
	}


	public void setWorkflowId(long workflowId) {
		this.workflowId = workflowId;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getAssetId() {
		return assetId;
	}


	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}


	public String getSensorId() {
		return sensorId;
	}

	
	
	
	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}


	public String getEventType() {
		return eventType;
	}


	public void setEventType(String eventType) {
		this.eventType = eventType;
	}


	public int getUpperLimit() {
		return upperLimit;
	}


	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}


	public int getLowerLimit() {
		return lowerLimit;
	}


	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}


	public int getNoOfOccurrences() {
		return noOfOccurrences;
	}


	public void setNoOfOccurrences(int noOfOccurrences) {
		this.noOfOccurrences = noOfOccurrences;
	}


	public String getMeadiaType() {
		return meadiaType;
	}


	public void setMeadiaType(String meadiaType) {
		this.meadiaType = meadiaType;
	}


	public String getMediaValue() {
		return mediaValue;
	}


	public void setMediaValue(String mediaValue) {
		this.mediaValue = mediaValue;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
