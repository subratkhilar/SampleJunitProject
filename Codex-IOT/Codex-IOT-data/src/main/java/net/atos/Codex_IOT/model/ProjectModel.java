package net.atos.Codex_IOT.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ProjectModel {

	private long customerId;
	
	
	private String projectId;
	
	
	@NotNull(message="Project name should not be null.")
	@NotEmpty(message="Project name should not be empty.")
	private String projectName;
	
	@NotNull(message="Project Description name should not be null.")
	@NotEmpty(message="Project Description name should not be empty.")
	private String projectDescription;
	
	@NotNull(message="Project Location name should not be null.")
	@NotEmpty(message="Project Location name should not be empty.")
	private String projectLocation;

	@NotNull(message="Longitude should not be null.")
	@NotEmpty(message="Longitude should not be empty.")
	private String longitude;
	
	@NotNull(message="Latitude should not be null.")
	@NotEmpty(message="Latitude should not be empty.")
	private String latitude;
	
	
	
	public String getProjectId() {
		return projectId;
	}


	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getProjectDescription() {
		return projectDescription;
	}


	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


	public String getProjectLocation() {
		return projectLocation;
	}


	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}


	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
	
}
